# ftp服务器搭建

## 一、linux下的

**1.安装vsftp软件**

基于centOS 7，使用vsftpd搭建ftp服务器,使用命令安装服务,可以使用vsftpd -v 查看版本

```shell
#基于yum安装
yum install -y vsftpd
```

**2.修改配置文件**

/etc/vsftpd/vsftpd.conf修改如下项:

anonymous_enable=NO   #禁止匿名登录

local_enable=YES     

write_enable=YES

listen=YES

listen_ipv6=NO

追加以下配置项：

guest_enable=YES      #开启虚拟账户
guest_username=vsftpd  #这个为系统用户，用于关联虚拟账户的
user_config_dir=/etc/vsftpd/vconf  #此为用户配置目录，根据用户自行自定

allow_writeable_chroot=YES

**3.建立系统用户，为虚拟用户做准备**

#用户登录终端设为**/**bin/false(即：使之不能登录系统)

useradd vsftpd -d /home/vritFtp -s /bin/false

建立虚拟用户在/etc/vsftpd，创建文件(文件名随意)

touch virtusers

写入虚拟用户名和密码，注意奇数行是用户名，偶数行是密码，可写入多个

test

123456

生产数据库验证文件,使用了hash算法，生产带db的文件

db_load -T -t  hash  -f /etc/vsftpd/virtusers  /etc/vsftpd/virtusers.db

修改pam验证文件，注意配置中的验证路径

  \# 修改前先备份  

cp /etc/pam.d/vsftpd /etc/pam.d/vsftpd.bak 

vim /etc/pam.d/vsftpd 

#先将配置文件中原有的 auth 及 account 的所有配置行均注释掉,再追加 

auth sufficient /lib64/security/pam_userdb.so db=/etc/vsftpd/virtusers

account sufficient /lib64/security/pam_userdb.so db=/etc/vsftpd/virtusers

 如果系统为32位，上面改为lib

**4.建立虚拟账户配置项**

mkdir /etc/vsftpd/vconf

以虚拟用户名建立文件，建立如test文件，touch test写入

 local_root=/home/vritFtp/test 

write_enable=YES

 anon_umask=022 #设置虚拟用户权限

anon_world_readable_only=NO 

anon_upload_enable=YES 

anon_mkdir_write_enable=YES 

anon_other_write_enable=YES

5.建好虚拟用户目录/home/vritFtp/test，重启vsftpd,一般都会成功的。

systemctl restart vsftpd

systemctl enable vsftpd

**注意**

 1.ftp协议只能传输iso-8859-1，在代码上传容易遇见坑，特别是中文文件名

 2.由于使用了虚拟用户，所以需要是否按照pam认证

**详细配置说明如下**


 -----关于ftp所有配置项的详细解释

-----关于匿名用户：


- anonymous_enable=YES：是否允许匿名访问；
- anon_umask=022：设置匿名用户所上传文件的默认权限掩码值（反掩码）；
- anon_root=/var/ftp：设置匿名用户的FTP根目录；
- anon_upload_enable=YES;是否允许匿名用户上传文件；
- anon_mkdir_write_enable=YES：是否允许匿名用户由创建目录的写入权限；
- anon_other_write_enable=YES：是否允许匿名用户有其他写入权限，如对文件改名、覆盖及删除文件等；

-----关于本地用户：

- local_enable=YES：是否允许本地用户访问；
- local_umask=022：设置本地用户所上传文件的默认权限掩码值（反掩码）；
- local_root=/var/ftp：设置本地用户的FTP根目录（默认为用户的宿主目录）；
- chroot_local_user=YES：是否将FTP本地用户禁锢在宿主目录中；
- allow_writeable_chroot=YES：允许被限制用户的主目录具有写权限；
- local_max_rate=0：限制本地用户的最大传输速率（0为无限制），单位为字节/秒（B/s）

-----关于全局配置：

- listen=NO： 是否以独立运行的方式监听服务；
- listen_address=0.0.0.0：设置监听f t p服务的ip地址；
- listen_port=21：设置监听ftp服务的端口号；
- write_enable=YES：启用任何形式的写入权限，（如上传、删除文件等）都需要开启此项；
- download_enable=YES：是否允许下载文件（建立仅限于浏览、上传的FTP服务器时，可将此项设置为“NO”）；
- dirmessage_enable=YES：用户切换进入目录时显示 “.message”文件（如果已存在）的内容；
- xferlog_enable=YES：启用xferlog日志，默认记录到 /var/log/xferlog；
- xferlog_std_format=YES：启用标准的xferlog日志格式，若禁用此项，将使用vsftpd自己的日志格式；
- connect_from_port_20=YES：允许服务器主动模式（从20端口建立数据连接）；
- pasv_enable=NO：禁止被动模式连接；默认允许被动模式连接；
- pasv_max_port=24600：设置用于被动模式的服务器最大端口号；
- pasv_min_port=24500：设置用于被动模式的服务器最大端口号；
- pam_service_name=vsftpd.vu：设置用于用户认证的PAM文件位置（/etc/pam.d/目录中对应的文件名）；
- userlist_enable=YES：是否启用userl_ist用户列表文件；
- userlist_deny=YES：是否禁用user_list列表文件中的用户账号；
- max_clients=0：最多允许多少个客户端同时连接（0为无限制）；
- max_per_ip=0：对来自同一个ip地址的客户端，最多允许多少个并发连接（0为无限制）；
- tcp_wrappers=YES：是否启用tcp_wrappers主机访问控制；

-----关于虚拟用户的配置项：

- guest_username=test：指定映射的系统用户名称；
- guest_enable=YES：是否启用虚拟用户；
- allow_writeable_chroot=允许被限制用户的主目录具有写权限（此项必须写入，否则可能会报错）
- anon_world_readable_only=NO：允许用户下载目录内容
- anon_other_write_enable=YES：允许匿名用户有其他写入权限，如重命名、覆盖及删除文件等；
- user_config_dir=/etc/vsftpd/vusers_dir：指定虚拟用户独立的配置文件目录；

## 二、windows下

1.基于win 10，首先在控制面板-程序-程序和功能-打开或关闭windows功能开启ftp功能

![img](file:///C:\Users\Administrator\AppData\Roaming\Tencent\Users\842693026\QQ\WinTemp\RichOle\_3D(D5G$T%L~TJ67_S3]Y)5.png)

打开图中的ftp功能和IIS管理

2.在计算机管理中，新建ftp用户，如下图

![1570603580721](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1570603580721.png)

3.打开IIS，右击网站，选择新建ftp站点，填写站点名称，和选择站点的访问目录。

![1570603823588](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1570603823588.png)

物理路径为真实路径，上传的文件都在这个目录下

4.下一步选择网卡，端口，是否需要SSL等

![1570603956067](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1570603956067.png)

5.选择验证和权限，身份：基本，访问一般为指定用户，可视具体情况而定，读写权限自行考虑，建站完成。

![1570604166227](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1570604166227.png)

6.验证，主要验证命令如下

ftp  #进入ftp

open [ip]  #打开连接，然后按提示输入用户密码

put [file] #上传文件



