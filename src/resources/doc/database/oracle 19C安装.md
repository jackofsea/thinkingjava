# oracle 19C

## 安装

### centOS 8 下的rpm安装

#### 下载RPM：

https://yum.oracle.com/repo/OracleLinux/OL7/latest/x86_64/index.html

wget https://yum.oracle.com/repo/OracleLinux/OL7/latest/x86_64/getPackage/oracle-database-preinstall-19c-1.0-1.el7.x86_64.rpm

https://www.oracle.com/technetwork/database/enterprise-edition/downloads/index.html

两个文件：oracle-database-preinstall-19c-1.0-1.el7.x86_64.rpm

​                   oracle-database-ee-19c-1.0-1.x86_64.rpm

#### 准备用户：

  groupadd oinstall
 groupadd dba

useradd oracle -g oinstall -G dba

检查oracle用户：id  oracle

#### 安装19c软件：

yum -y localinstall oracle-database-preinstall-19c-1.0-1.el7.x86_64.rpm 
yum -y localinstall oracle-database-ee-19c-1.0-1.x86_64.rpm
这里会缺少依赖，按照缺少软件的安装相关依赖

配置是数据库： /etc/init.d/oracledb_ORCLCDB-19c configure（这也是一个文件，可以修改）

 

#### 其他问题

可能会缺少libnsl.so.1等的库文件，使用:dnf  install libnsl 