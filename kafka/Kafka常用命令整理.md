## kafka常用命令

### 启动kafka服务 && 停止kafka服务

```shell
#==============start==============
bin/kafka-server-start.sh -daemon config/server.properties
#==============stop==============
bin/kafka-server-stop.sh
```



### 创建topic命令 && 删除topic命令

```shell
#==============create==============
bin/kafka-topics.sh --create --zookeeper ${zk_ip:zk_port/chroot} --replication-factor 2 --partitions 3 --topic ${topic_name}
#==============delete==============
bin/kafka-topics.sh --delete --zookeeper ${zk_ip:zk_port/chroot} --topic ${topic_name}
```

修改replication-factor这个参数调整不能调整topic的副本因子数吧？编辑好partitions-topic.json文件来改的

### 查询所有的topic && 查询详情

``` shell
#==============list==============
bin/kafka-topics.sh --list --zookeeper ${zk_ip:zk_port/chroot}
#==============describe==============
bin/kafka-topics.sh --describe --zookeeper ${zk_ip:zk_port/chroot} --topic ${topic_name}
```

### 查询所有的groupid && 查询详情（Lag查询）

```shell
#==============list==============
bin/kafka-consumer-groups.sh --list --bootstrap-server localhost:9092
#==============describe==============
bin/kafka-consumer-groups.sh --describe --bootstrap-server localhost:9092 --group ${consumer-group}
#==================查询特定topic下consumer group的消费情况==================
bin/kafka-consumer-offset-checker.sh --zookeeper ${zk_ip:zk_port/chroot} --group {group} --topic {topic} 
```

### 生产者生产消息 && 消费者消费消息

```shell
#==============producer==============
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic ${topic_name}
#==============consumer==============
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --new-consumer --from-beginning --topic ${topic_name}
#==============指定offset============
for i in `ls data/{partition-*}/ |grep log`;do echo $i;bin/kafka-run-class.sh kafka.tools.DumpLogSegments -print-data-log -files data/{partition-*}/$i |grep "offset: 123123";done
```

### 动态修改kafka topic保存时间

```shell
bin/kafka-topics.sh --zookeeper ${zk_ip:zk_port/chroot} --topic ${topic_name} --alter --config retention.ms=3600000
```

### 动态删除zookeeper日志和快照数据

```shell
./bin/zkCleanup.sh /export/servers/zookeeper-3.4.6/data -n 1000  [-n 1000表示保留快照日志的数量]
```

### 加鉴权命令
```shell
#==============启动kafka=============
bin/secured-kafka-server-start.sh -daemon config/server.properties
#==============查看Group详情==============
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --command-config config/consumer.properties --describe --group ${group}
#==============生产消息==============
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test_midop --producer.config config/producer.properties 
#==============消费消息==============
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test_midop --consumer.config config/consumer.properties
#==============授权生产者write，describe权限==============
bin/kafka-acls.sh --add --authorizer-properties zookeeper.connect=${zk_ip:zk_port/chroot} --allow-principal User:jvessel --producer --topic=*
#==============授权消费者read权限，需要授权topic与group权限==============
bin/kafka-acls.sh --add --authorizer-properties zookeeper.connect=${zk_ip:zk_port/chroot} --allow-principal User:jvessel --consumer --topic=* --group=*
#==============查看授权==============
bin/kafka-acls.sh --authorizer-properties zookeeper.connect=${zk_ip:zk_port/chroot} --list -cluster
#==============取消授权==============
#--------------取消授权topic--------------
bin/kafka-acls.sh --authorizer-properties zookeeper.connect=${zk_ip:zk_port/chroot} --remove --topic *
#--------------取消授权group--------------
bin/kafka-acls.sh --authorizer-properties zookeeper.connect=${zk_ip:zk_port/chroot} --remove --group *
#--------------取消授权集群--------------
bin/kafka-acls.sh --authorizer-properties zookeeper.connect=${zk_ip:zk_port/chroot} --remove --cluster
#--------------压测--------------
bin/kafka-producer-perf-test.sh --topic test_midop --num-records 100 --record-size 100 --throughput 20 --producer.config config/producer.properties  --producer-props bootstrap.servers=${brokerip}:9092
```



### 查询消息是否发送成功

```shell
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --new-consumer --from-beginning --topic ${topic_name} | grep ${message-key-word}
```

### 查询消息生产时间
```shell
./kafka-run-class.sh kafka.tools.DumpLogSegments --print-data-log --files /data/${partition_name}/*.log
./kafka-run-class.sh kafka.tools.DumpLogSegments --files /data/xxxxxxxxxxx.log
```

### kafka partition扩容 && kafka broker扩容
````shell
#==============partition==============
bin/kafka-topics.sh --alter --zookeeper ${zk_ip:zk_port/chroot} --topic ${topic_name} --partitions ${partition_number}
#==============replica==============
#方法参考: https://cf.jd.com/pages/viewpage.action?pageId=144360751 二、扩展 b) replica扩容
````

### 平衡leader
````shell
bin/kafka-preferred-replica-election.sh --zookeeper zk_host:port/kafka 
#==============平衡某partition===========
bin/kafka-preferred-replica-election --zookeeper zk_host:port/kafka --path-to-json-file xx.json
````

### kafka 动态修改配置
```shell
#==============cleanup.policy==============
bin/kafka-configs.sh --alter --zookeeper ${zk_ip:zk_port/chroot} --entity-type topics --entity-name ${topic_name} --add-config cleanup.policy=delete
bin/kafka-configs.sh --alter --zookeeper ${zk_ip:zk_port/chroot} --entity-type topics --entity-name ${topic-name} --add-config cleanup.policy=compact
bin/kafka-configs.sh --alter --zookeeper ${zk_ip:zk_port/chroot} --entity-type topics --entity-name ${topic_name} --add-config cleanup.policy=[compact,delete] 通过加方括号[]添加多个参数
#==============日志保存时间==============
bin/kafka-configs.sh --alter --zookeeper ${zk_ip:zk_port/chroot} --entity-type topics --entity-name ${topic_name} --add-config retention.ms=${xxxx}
#==============删除动态修改配置==============
bin/kafka-configs.sh --alter --zookeeper ${zk_ip:zk_port/chroot} --entity-type topics --entity-name ${topic_name} --delete-config retention.ms
#==============消息添加服务器时间==============
bin/kafka-configs.sh --alter --zookeeper ${zk_ip:zk_port/chroot} --entity-type topics --add-config message.timestamp.type=LogAppendTime --entity-name ${topic_name}
```

### 查询一个topic有哪些consumer group在消费？
````shell
方法一：
#! /bin/bash
topic=resource-create  (要查询的topic)
ConsumerGroups=`bin/kafka-consumer-groups.sh --list --bootstrap-server localhost:9092`(注意服务是否为9092端口，下同)
for consumergroup in $ConsumerGroups
do
    result=`bin/kafka-consumer-groups.sh --describe --bootstrap-server localhost:9092 --group $consumergroup | grep $topic`
    if [ -n "$result" ]
    then
        echo "topic:$topic"
        echo "group:$consumergroup"  (输出消费topic的消费者组)
    fi
done
方法二:
for i in `bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list`;do echo $i;bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group $i 2>/dev/null |grep  要查询的topic;done
````

### 压力测试
> 1、写入消息：

```shell
bin/kafka-producer-perf-test.sh --topic test_midop --num-records 100 --record-size 10 --throughput 20 --producer-props bootstrap.servers=localhost:9092
输出结果：
100 records sent, 20.020020 records/sec (0.00 MB/sec), 3.73 ms avg latency, 173.00 ms max latency, 2 ms 50th, 13 ms 95th, 173 ms 99th, 173 ms 99.9th.
解读：
总共发送了100个消息，每条消息10字节，每秒钟发送20个，平均每秒发送17737条，即每秒平均向kafka写入16.92MB的数据，平均延迟962.23毫秒，最大延迟7415毫秒，延时831 ms内占50%，3932ms内占95%。
```



> 2、消费消息：

```shell
bin/kafka-consumer-perf-test.sh --zookeeper ${zk_ip:zk_port/chroot} --topic test_midop --fetch-size 1048576 --messages 1000 --threads 1
输出结果：
start.time, end.time, data.consumed.in.MB, MB.sec, data.consumed.in.nMsg, nMsg.sec
2018-09-12 20:54:49:820, 2018-09-12 20:54:50:263, 47.6837, 107.6382, 10000, 22573.3634
解读：
总共消费了47.6837M的数据，每秒为107.6382M， 总共消费了10000条消息，每秒为22573.3634条
```

