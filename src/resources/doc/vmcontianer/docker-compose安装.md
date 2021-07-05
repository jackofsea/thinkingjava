# docker-compose安装

## CentOS 7下安装

### 方法一：二进制文件安装

```bash
sudo curl -L "https://github.com/docker/compose/releases/download/1.24.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```



```bash
 chmod +x /usr/local/bin/docker-compose   #添加执行权限
  docker-compose --version   #查看版本信息
```

注意：但是此方法会经常因为网络的原因而无法安装

### 方法二：pip安装
1、安装python-pip

```bash
yum -y install epel-release
yum -y install python-pip
```

2、安装docker-compose

```bash
pip install docker-compose
```

查看版本信息

```bash
docker-compose --version   #查看版本信息
```

官方网址：https://docs.docker.com/compose/install/