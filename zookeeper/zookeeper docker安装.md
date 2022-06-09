

### zookeeper的docker安装

#### 安装步骤

```shell
docker pull zookeeper:3.6.1

docker images|grep zoo
#zookeeper 3.6.1 3bbbc7545ea8 9 months ago 252MB
#id: 3bbbc7545ea8
```



```shell
mkdir /usr/local/zookeeper-cluster
mkdir /usr/local/zookeeper-cluster/node1
mkdir /usr/local/zookeeper-cluster/node2
mkdir /usr/local/zookeeper-cluster/node3
ls /usr/local/zookeeper-cluster/
```



```shell
docker network create --driver bridge --subnet=172.18.0.0/16 --gateway=172.18.0.1 zoonet

#1dfbdc454a13 zoonet bridge local
#id: 1dfbdc454a13
#docker network inspect 1dfbdc454a13
```



```shell
docker run -d -p 2181:2181 --name zookeeper_node1 --privileged --restart always --network zoonet --ip 172.18.0.2 \
-v /usr/local/zookeeper-cluster/node1/volumes/data:/data \
-v /usr/local/zookeeper-cluster/node1/volumes/datalog:/datalog \
-v /usr/local/zookeeper-cluster/node1/volumes/logs:/logs \
-e ZOO_MY_ID=1 \
-e "ZOO_SERVERS=server.1=172.18.0.2:2888:3888;2181 server.2=172.18.0.3:2888:3888;2181 server.3=172.18.0.4:2888:3888;2181" 3bbbc7545ea8
```



```shell
docker run -d -p 2182:2181 --name zookeeper_node2 --privileged --restart always --network zoonet --ip 172.18.0.3 \
-v /usr/local/zookeeper-cluster/node2/volumes/data:/data \
-v /usr/local/zookeeper-cluster/node2/volumes/datalog:/datalog \
-v /usr/local/zookeeper-cluster/node2/volumes/logs:/logs \
-e ZOO_MY_ID=2 \
-e "ZOO_SERVERS=server.1=172.18.0.2:2888:3888;2181 server.2=172.18.0.3:2888:3888;2181 server.3=172.18.0.4:2888:3888;2181" 3bbbc7545ea8
```



```
docker run -d -p 2183:2181 --name zookeeper_node3 --privileged --restart always --network zoonet --ip 172.18.0.4 \
-v /usr/local/zookeeper-cluster/node3/volumes/data:/data \
-v /usr/local/zookeeper-cluster/node3/volumes/datalog:/datalog \
-v /usr/local/zookeeper-cluster/node3/volumes/logs:/logs \
-e ZOO_MY_ID=3 \
-e "ZOO_SERVERS=server.1=172.18.0.2:2888:3888;2181 server.2=172.18.0.3:2888:3888;2181 server.3=172.18.0.4:2888:3888;2181" 3bbbc7545ea8
```



#### 验证

docker命令

- docker ps -it xxxx bash
- ./bin/zkCli.sh

客户端

- wget https://downloads.apache.org/zookeeper/stable/apache-zookeeper-3.6.3-bin.tar.gz
- tar zxvf apache-zookeeper-3.6.3-bin.tar.gz
- ./zkCli.sh -server 10.226.136.231:2181

tenlnet/nc

- echo srvr|nc 10.226.136.231 2181
- 有些版本可能支持吧srvr换成"status"，参考：
  - https://stackoverflow.com/questions/48122834/zookeeper-where-do-i-find-the-real-version-of-a-running-instance-of-zookeepe
  - https://stackoverflow.com/questions/29106546/how-to-check-if-zookeeper-is-running-or-up-from-command-prompt

#### 其他文档

[Zookeeper 3.6.1 详尽用法指南](https://segmentfault.com/a/1190000038218676)

[Centos下安装Zookeeper](https://www.jianshu.com/p/a79ea43c49bc)

 不用docker方式安装服务

[Zookeeper 工作流](https://www.w3cschool.cn/zookeeper/zookeeper_workflow.html) 工作原理介绍

