## docker环境搭建

docker环境搭建，详见[boot2docker环境搭建](./boot2docker环境的搭建.md)

## k3s的搭建

### k3s的安装

#### docker配置修改

1. 进入虚拟机

```shell
docker-machine ssh test
```

2. 修改/etc/resolv.conf

```shell
nameserver 8.8.8.8
```

3. 修改/var/lib/boot2docker/profile

```
--label provider=virtualbox
--registry-mirror https://docker.mirrors.ustc.edu.cn
```

#### 安装k3s

1. 安装k3s

```shell
k3d cluster create k3s --api-port 6443 --port 0.0.0.0:80:80@loadbalancer --servers 1 --agents 2 --no-hostip
```

显示如下表示成功

```shell
...
INFO[0432] Starting cluster 'k3s'
INFO[0432] Starting servers...
INFO[0432] Starting Node 'k3d-k3s-server-0'
INFO[0439] Starting agents...
INFO[0439] Starting Node 'k3d-k3s-agent-1'
INFO[0439] Starting Node 'k3d-k3s-agent-0'
INFO[0449] Starting helpers...
INFO[0449] Starting Node 'k3d-k3s-serverlb'
INFO[0456] Injecting records for hostAliases (incl. host.k3d.internal) and for 4 network members into CoreDNS configmap...
INFO[0459] Cluster 'k3s' created successfully!
INFO[0459] You can now use it like this:
kubectl cluster-info
```



2. 查看

```shell
kubectl get pod -o wide -A
```

显示如下服务

```
NAMESPACE     NAME                                      READY   STATUS      RESTARTS   AGE    IP          NODE               NOMINATED NODE   READINESS GATES
kube-system   local-path-provisioner-7b7dc8d6f5-49v9f   1/1     Running     0          129m   10.42.2.3   k3d-k3s-agent-1    <none>           <none>
kube-system   coredns-b96499967-46m2h                   1/1     Running     0          129m   10.42.2.4   k3d-k3s-agent-1    <none>           <none>
kube-system   helm-install-traefik-crd-ss64p            0/1     Completed   0          129m   10.42.1.2   k3d-k3s-server-0   <none>           <none>
kube-system   helm-install-traefik-r6nk2                0/1     Completed   2          129m   10.42.1.3   k3d-k3s-server-0   <none>           <none>
kube-system   svclb-traefik-898c78ef-2lwvb              2/2     Running     0          127m   10.42.0.2   k3d-k3s-agent-0    <none>           <none>
kube-system   traefik-7cd4fcff68-974nq                  1/1     Running     0          127m   10.42.0.3   k3d-k3s-agent-0    <none>           <none>
kube-system   svclb-traefik-898c78ef-bk5qk              2/2     Running     0          127m   10.42.2.5   k3d-k3s-agent-1    <none>           <none>
kube-system   svclb-traefik-898c78ef-jqmkl              2/2     Running     0          127m   10.42.1.4   k3d-k3s-server-0   <none>           <none>
kube-system   metrics-server-668d979685-9jsps           1/1     Running     0          129m   10.42.2.2   k3d-k3s-agent-1    <none>           <none>

```



#### 安装nginx

1. 编写nginx-deployment.yml文件

```yaml
apiVersion: apps/v1    #与k8s集群版本有关，使用 kubectl api-versions 即可查看当前集群支持的版本
kind: Deployment    #该配置的类型，我们使用的是 Deployment
metadata:            #译名为元数据，即 Deployment 的一些基本属性和信息
  name: nginx-deployment    #Deployment 的名称
  namespace: kube-system
  labels:        #标签，可以灵活定位一个或多个资源，其中key和value均可自定义，可以定义多组，目前不需要理解
    app: nginx    #为该Deployment设置key为app，value为nginx的标签
spec:            #这是关于该Deployment的描述，可以理解为你期待该Deployment在k8s中如何使用
  replicas: 2    #使用该Deployment创建一个应用程序实例
  selector:        #标签选择器，与上面的标签共同作用，目前不需要理解
    matchLabels: #选择包含标签app:nginx的资源
      app: nginx
  template:        #这是选择或创建的Pod的模板
    metadata:    #Pod的元数据
      labels:    #Pod的标签，上面的selector即选择包含标签app:nginx的Pod
        app: nginx
    spec:        #期望Pod实现的功能（即在pod中部署）
      containers:    #生成container，与docker中的container是同一种
      - name: nginx    #container的名称
        image: nginx:alpine    #使用镜像nginx创建container，
        imagePullPolicy: IfNotPresent
        ports:
          - containerPort: 80   #内部服务暴露的端口
```

2. 执行nginx-deployment.yml文件

```shell
kubectl apply -f conf/nginx-deployment.yml
```

3. 编写nginx-service.yml文件

 当我们创建部署完毕，nginx 服务仅仅只是部署，我们还需要让它暴露出自己的服务

```yaml
apiVersion: v1
kind: Service  #该配置的类型，我们使用的是 Service 服务类型
metadata:
  name: nginx-service  #该服务类型的名称
  namespace: kube-system
spec:
  selector:    #选中的app部署实例
    app: nginx #为该Deployment设置key为app，value为nginx的标签
  ports:  #暴露的端口
  - protocol: TCP  # 走得tcp 协议
    port: 80 #默认端口
    targetPort: 80 #内建服务端口
    nodePort: 30080 #对外服务端口
  type: NodePort
```

4. 执行nginx-service.yml文件

```shell
kubectl apply -f conf/nginx-service.yml
```



