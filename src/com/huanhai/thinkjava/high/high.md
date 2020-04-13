# java高级
1.	新技术
	Java 8
Lamada表达式、Stream API
	Java 9
Jigsaw、Jshell、Reactive Stream
	Java 10
局部变量类型推断、G1的并行FULL GC、ThreadLocal握手机制
	Spring 5
响应式编程
	Spring Boot 2.0
2.	性能优化
	使用单例、使用Futue模式
	使用线程池
	选择就绪
	减少上下文切换
	减少锁粒度
	数据压缩
	结果缓存
3.	线上问题分析
	Dump获取
线程dump、内存Dump、GC情况
	Dump分析
分析死锁、分析内存泄漏
	自己编写各种outofmemory,stackoverflow程序
HeapOutOfMenorry,YoungOutOfMemory,MethodArea OutOfMemory,ConstantPool OutOfMemory, DirectMemory OutOfMemory,StackOutOfMemory,Stack OverFlow
	常见问题解决思路
内存溢出、线程死锁、类加载冲突
	使用工具尝试解决以下问题，并写下总结
1）	当一个java程序响应很慢是如何查找问题
2）	当一个java程序频繁FullGC是如何解决问题
3）	如何查看垃圾回收日志
4）	当一个java应用发生outOfmemory时该如何解决
5）	如何判断是否出现死锁
6）	如何判断是否存在内存泄漏
4.	编译原理知识
	编译和反编译
	Java代码的编译和反编译
	Java的反编译工具
	词法分析，语法分析（LL算法，递归下降算法，LR算法），语义分析，运行时环境，中间代码，代码生成，代码优化
5.	操作系统知识
	Linux的常用命令
	进程同步
	缓冲区溢出
	分段和分页
	虚拟内存和主存
6.	数据库知识
	MySql执行引擎
	MySql执行计划
如何查看执行计划，如何根据执行计划进行SQL优化
	SQL优化
	事务
事务的隔离级别、事务能不能实现锁的功能
	数据库锁
行锁、表锁、使用数据库锁实现乐观锁
	数据库主备搭建
	Binlog
	内存数据库
h2
	常用的NoSQL数据库
Redis、memcached
	分别使用数据库锁、NoSQL实现分布式锁性能调优
	性能调优
7.	数据结构与算法知识
	简单的数据结构
栈、队列、链表、数组、哈希表
	树
二叉树、字典树、平衡树、排序树、B树、B+树、R树、多路树、红黑树
	排序算法
各种排序算法和时间复杂度、深度优先和广度优先搜索、全排列、贪心算法、KMP算法、hash算法、海量数据处理
8.	大数据知识
	Zookeeper
基本概念、常见用法
	Solr，Lucene，ElasticSearch
在linux上部署solr、solrcloud，新增、删除、查询、索引
	Storm，流式计算，了解Spark，S4
在Linux上部署storm,用ZooKeeper做协调，运行storm hello world,local和remote模式运行调试storm topology
	Hadoop，离线计算
	分布式日志收集flume,kafka,logstash
	数据挖掘，mahout
9.	网络安全知识
	什么是XSS
XSS防御
	什么是CSRF
	什么是注入攻击
SQL注入、XML注入、CRLF注入
	什么是文件上传漏洞
	加密与解密
MD5、SHA1、DES、AES、RSA、DSA
	什么是DOS攻击和DDos攻击
Mekcached为什么可以导致DDos攻击、什么是反射型DDos
	SSL、TLS、HTTPS
	如何通过Hash碰撞进行DOS攻击
	用openssl签一个证书部署到apache或nginx
