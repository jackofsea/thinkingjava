# docker-ce安装

## CentOS7 下安装

1.卸载旧版本

```bash
 sudo yum remove docker \
                  docker-common \
                  docker-selinux \
                  docker-engine
```

2.安装依赖包

```bash
sudo yum install -y yum-utils \
  device-mapper-persistent-data \
  lvm2
```

3.安装稳定仓库

```bash
sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
```

4.安装docker-ce

```bash 
sudo yum install docker-ce
docker --version    #查看docker版本
```

参考官网:https://docs.docker.com/v17.09/engine/installation/linux/docker-ce/