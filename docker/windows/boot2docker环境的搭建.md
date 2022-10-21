[TOC]



## 1.安装docker-machine工具

下载windows版本的[docker-machine](https://github.com/docker/machine/releases)

下载完成后，复制docker-machine.exe 到指定的docker bin的目录，同时配置环境变量

## 2.安装虚拟机

### virtualbox虚拟机

#### 安装

在[virtualbox](https://www.virtualbox.org)下载windows版本virtualbox并安装

#### 创建虚拟机

创建虚拟机可参考[命令](https://gdevillele.github.io/machine/drivers/virtualbox/)

```shell
docker-machine create -d virtualbox --virtualbox-import-boot2docker-vm boot2docker-vm b2d
```

启动docker

```shell
eval $(docker-machine env b2d --shell bash)
```

