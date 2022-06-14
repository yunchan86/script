[TOC]



## kafka应用与实践

kafka作为分布式消息系统，提供了高效的消息发布与订阅功能，并且具有消息解耦，海量吞吐，易扩展，多消费，强容错等特点。kafka的这些特点在我们工作实践中起到了很重要的作用，下面我们通过实践来探索kafka的性能。

### 吞吐

kafka的高吞吐量可以通过kafka收发消息压力测试来体现，下面分别对kafka集群进行100W，1000W条消息进行统计从而评估kafka的消息处理能力。

| Host        | 配置                                  | 系统      | kafka版本          |
| ----------- | ------------------------------------- | --------- | ------------------ |
| 192.168.0.4 | CPU:8核 内存:16GB 带宽:2Mbps SSD:128G | Centos7.2 | kafka2.11-0.10.2.1 |
| 192.168.0.5 | CPU:8核 内存:16GB 带宽:2Mbps SSD:128G | Centos7.2 | kafka2.11-0.10.2.1 |
| 192.168.0.6 | CPU:8核 内存:16GB 带宽:2Mbps SSD:128G | Centos7.2 | kafka2.11-0.10.2.1 |

我们使用的压测方法为kafka自带的压测脚本，脚本可以通过调整各种参数达到不同的标准，下面为测试时间，生产者测试脚本如下：

```shell
bin/kafka-producer-perf-test.sh --topic testtopic \
--num-records 1000000 \
--record-size 1000 \
--producer-props bootstrap.servers=localhost:9092 \
--throughput 100000
```

测试结果如下表所示：

| **消息条数** | **消息大小** | **吞吐量** | **写入速度** |
| ------------ | ------------ | ---------- | ------------ |
| 100W         | 1000字节     | 1W         | 9.53 MB/sec  |
| 1000W        | 1000字节     | 1W         | 9.66 MB/sec  |
| 1000W        | 1000字节     | 10W        | 95.25 MB/sec |
| 1000W        | 1000字节     | 20W        | 94.73 MB/sec |

从测试结果可以看出，当吞吐量相同，生产消息条数不同时，即条数为100w与1000w时kafka写入速度基本相同，当生产消息条数相同，吞吐量不同时，即吞吐量为1w与10w时写入速度随着吞吐量变大而变大，但当生产条数相同，吞吐量继续变大时，即吞吐量10w与20w时kafka写入速度基本保持不变，由此可以得出，向kafka系统发送消息条数多少并不影响其生产速率，其消息写入速度与磁盘性能及吞吐量相关。

接下来我们进行消费测试，消费者测试脚本如下：

```shell
bin/kafka-consumer-perf-test.sh --topic testtopic \
--zookeeper localhost:2181/kafka \
--fetch-size 1048576 \
--messages 100000 \
--threads 1

```



测试结果如下表所示：

| **消息条数** | **消息大小** | **进程数** | **消费速度**    | **消费条数**        |
| ------------ | ------------ | ---------- | --------------- | ------------------- |
| 100W         | 1M           | 1          | 280.0806 MB/sec | 293685.7562 msg/sec |
| 100W         | 1M           | 2          | 281.2369 MB/sec | 294898.2601 msg/sec |
| 1000W        | 1M           | 2          | 283.2416 MB/sec | 297000.2970 msg/sec |

从测试结果可以看出，当消费消息条数相同，消费进程条数不同时，即进程为1与2时kafka消息消费速度基本相同，当进程数相同，消费消息条数不同，即消费条数为100w与1000w时kafka消息消费速度基本相同，由此可以得出，kafka系统消费消息条数多少以及线程多少并不影响其消费速率，因此多个消费者同时消费消息并不会增加系统的负担.

通过压力测试可以看出kafka再应对百万千万消息时并不会随着消息的增大而降低其性能，因此在应对上亿数据时仍然是效率极高的消息处理系统。

### 扩展

kafka作为分布式系统具有良好的扩展能力，在应对业务量暴增、机器过保退役等需求时，其良好的扩容、缩容能力为消息系统带来了极大的灵活性。

#### a) broker扩容

kakfa集群有3个节点，下面我们将节点数目扩容为5个，操作如下：

【操作前】

查看zookeeper当中broker数目，执行如下命令，获取输出内容：

```shell
bin/zkCli.sh -server localhost:2181
[zk: localhost:2181(CONNECTED) 0] ls /kafka/brokers/ids
[1, 2, 3]
```

【第1步】

在三台机器上安装kafka程序

【第2步】

由于zookeeper存放kafka的broker节点信息、集群信息等元数据信息，因此kafka扩容不需要对zookeeper进行扩容，所以kafka扩容机器同样使用原zookeeper即可，即新安装的三个kafka配置信息中zookeeper.connect仍然保持不变如下所示：

```shell
zookeeper.connect=test1:2181,test2:2181,test33:2181/kafka
```

【第3步】

将三台机器的broker.id在原id为1，2，3的基础上设置成4，5，详细配置如下：

```shell
############################# Server Basics #############################
broker.id=4
default.replication.factor=3
num.partitions=2
auto.create.topics.enable=True
delete.topic.enable=true
queued.max.requests=1000
############################# Socket Server Settings #############################
listeners=PLAINTEXT://:9092
port=9092
advertised.host.name=192.168.0.7
num.network.threads=3
num.io.threads=8
socket.send.buffer.bytes=102400
socket.receive.buffer.bytes=102400
socket.request.max.bytes=104857600
############################# Log Basics #############################
log.dirs=/export/work/kafka_9092/data
num.recovery.threads.per.data.dir=1
############################# Log Retention Policy #############################
log.retention.minutes=5
log.segment.bytes=1073741824
log.retention.check.interval.ms=300000
############################# Zookeeper #############################
zookeeper.connect=test1:2181,test2:2181,test3:2181/kafka
zookeeper.connection.timeout.ms=6000
############################# END #############################

```

修改配置后，重新启动集群即完成broker扩展

```shell
bin/zkCli.sh -server localhost:2181
[zk: localhost:2181(CONNECTED) 0] ls /kafka/brokers/ids
[1, 2, 3]
```

【第4步】

kafka扩容后原topic仍然记录为3个分区状态因此需要对topic进行重新分配即replica扩容



#### b) replica扩容

下面我们将testtopic的副本数进行扩展，将replica原来的2个扩展为3个，操作如下：

【操作前】

```shell
Topic:testtopic    PartitionCount:2        ReplicationFactor:2     Configs:
        Topic: testtopic   Partition: 0    Leader: 1       Replicas: 1,2   Isr: 1,2
        Topic: testtopic   Partition: 1    Leader: 2       Replicas: 2,3   Isr: 2,3

```



【第1步】生成reassign plan

编辑文件指定待处理的topic，格式是json，格式如下，vim execute.json：

```
{
    "version": 1,
    "partitions": [
        {
            "topic": "testtopic",
            "partition": 0,
            "replicas": [
                1,
                2,
                3
            ]
        },
        {
            "topic": "testtopic",
            "partition": 1,
            "replicas": [
                2,
                1,
                3
            ]
        }
    ]
}
```



【第2步】执行扩容execute.json

```shell
bin/kafka-reassign-partitions.sh --zookeeper localhost:2181/kafka --execute \
--reassignment-json-file execute.json
```

<font color="red"> 【注意】broker-id的顺序，排在第一个的id就是leader节点的id，不同分区的第一个id打散分布。</font>



【第3步】查看执行结果

```shell
bin/kafka-reassign-partitions.sh --zookeeper localhost:2181/kafka  -verify\
--reassignment-json-file plan.json 
Status of partition reassignment:  
Reassignment of partition [testjd,0] completed successfully
Reassignment of partition [testjd,1] completed successfully
```



【第4步】验证：查看拓扑分布是否符合预期，收发消息是否正常，日志滚动是否正常（无Error）

```shell
Topic:testtopic    PartitionCount:2        ReplicationFactor:3     Configs:
        Topic: testtopic   Partition: 0    Leader: 1       Replicas: 1,2,3 Isr: 1,2,3
        Topic: testtopic   Partition: 1    Leader: 2       Replicas: 2,1,3 Isr: 2,3,1

```



####  c) partition扩容

下面我们将testjd的分区数进行扩展，将partitions由原来的2个扩展为7个，操作如下：

【操作前】

```shell
Topic:testjd PartitionCount:2        ReplicationFactor:3     Configs:
Topic: testtopic        Partition: 0    Leader: 0       Replicas: 1,0,2 Isr: 0,2,1
Topic: testtopic        Partition: 1    Leader: 1       Replicas: 0,1,2 Isr: 1,2,0

```



【执行命令】

```shell
bin/kafka-topics.sh --alter  \
--zookeeper *** \
--topic XXX \
--partitions {N}
```



【操作后】

```shell
Topic:testjd PartitionCount:7        ReplicationFactor:3     Configs:
Topic: testtopic        Partition: 0    Leader: 0       Replicas: 1,0,2 Isr: 0,2,1
Topic: testtopic        Partition: 1    Leader: 1       Replicas: 0,1,2 Isr: 1,2,0
Topic: testtopic        Partition: 2    Leader: 2       Replicas: 2,0,1 Isr: 2,0,1
Topic: testtopic        Partition: 3    Leader: 0       Replicas: 0,2,1 Isr: 0,2,1
Topic: testtopic        Partition: 4    Leader: 1       Replicas: 1,0,2 Isr: 1,0,2
Topic: testtopic        Partition: 5    Leader: 2       Replicas: 2,1,0 Isr: 2,1,0

```



### 容灾

随着业务线的增多、数据量的变大，一个数据中心往往不能提供安全可靠的服务，通常可以采用多AZ（Availability Zone）的方案进行容灾操作。kafka在多AZ环境中同样可以保持高可用，可以在每个ZA当中独立部署kafka集群，业务方通过访问域名调用VIP（Virtual IP Address）获取后端实例，当其中AZ1发生故障时LB发现后端实例停止服务后自动切换域名VIP指向AZ2中实例，此时业务方完成无感知切换，其中AZ1当中的数据与AZ2当中的数据可以通过kafka的MirrorMaker进行数据复制。具体操作如下。

【第1步】
搭建好两套集群后，只需要在原kafka集群中启动MirrorMaker即可，其中需要设置一个或多个consumer配置文件以及一个producer文件
(1)Consumer.config需要配置备份集群的zookeeper信息与group信息

```shell
zookeeper.connect=test4:2181,test5:2181,test6:2181/kafka
group.id=mirror-test
request.timeout.ms=40000
heartbeat.interval.ms=15000
session.timeout.ms=30000 
partition.assignment.strategy=org.apache.kafka.clients.consumer.RoundRobinAssignor
max.poll.records=20000
receive.buffer.bytes=524288
max.partition.fetch.bytes=5248576
```

(2)Producer.config需要配置原集群的bootstrap信息

```shell
bootstrap.servers=test1:9092,test1:9092,test1:9092
producer.type=sync
compression.codec=none
serializer.class=kafka.serializer.DefaultEncoder
```

【第2步】

启动脚本，其中whitelist为白名单

```shell
bin/kafka-run-class.sh kafka.tools.MirrorMaker --consumer.config sourceClusterConsumer.config --num.streams 2 --producer.config targetClusterProducer.config --whitelist=".*"
```

【第3步】

检查同步状况，在原集群中查看group数目

```
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
Note: This will only show information about consumers that use the Java consumer API (non-ZooKeeper-based consumers).
mirror-test
```

新集群中查看kafka数目

```shell
bin/kafka-topics.sh --list --zookeeper localhost:2181/kafka
__consumer_offsets
testtopic
```

可以看出原集群当中的存在镜像复制的group并且原集群当中的testtopic这个topic已经复制到了新集群当中。