# java基础
##	JVM
*	JVM内存结构
堆、栈、方法区、直接内存、堆和栈区别
解答：
*	JVM内存模型
内存可见性、重排序、顺序一致性、volatile、锁、final
*	垃圾回收
内存分配策略、垃圾收集器（G1）、GC算法、GC参数、对象存活的判定
*	JVM参数及调优
*	Java对象模型
oop-klass、对象头
*	HotSpot
即时编译器、编译优化
*	类加载机制
classLoader、类加载过程、双亲委派（破坏双亲委派）、模块化（jboss modules、osgi、jigsaw）
*	虚拟机性能监控与故障处理工具
jps,jstack、jmap、jstat,jconsole,jinfo,jhat,javap,btrace、TProfiler
##	编译与反编译
Javac、Javap、Jad、CRF
##	Java基础知识
*	阅读源代码
String、Integer、Long、Enum、BigDecimal、ThreadLocal、ClassLoader & URLClassLoader、ArryList、HashMap & LinkedHashMap & TreeMap & CouncurrentHashMap、HashSet & LinkedHashSet &  TreeSet
*	Java中各种变量
*	熟悉Java String的使用，熟悉String的各种函数
JDK 6和JDK 7中subString的原来及区别、replaceFirst、replaceAll、replace区别、String对“+”的重载、String.valueOf()和Integer.toString()的区别、字符串的不可变性
*	自动拆装箱
Integer的缓存机制
*	熟悉Java中各种关键字
transient、instanecof、volatile、synchronized、final、static、const原理及用法
*	集合类
常用集合类的使用
ArrayList和LinkedList和Vector的区别
SynchronizedList和Vector的区别
HashMap、HashTable、ConcurrentHashMap区别
Java8中Stream相关用法
Apache集合处理工具类的使用
不同版本的JDK中HashMap的实现的区别以及原因
*	枚举
枚举的用法、枚举与单例、Enum类
*	Java IO & Java NIO，并学会使用
BIO、NIO和AIO的区别，三种IO的用法和原理，netty
*	Java反射与Javassist
反射与工厂模式、java.lang.reflect.*
*	Java序列化
什么是序列化与反序列化、为什么要序列化
序列化底层原理
序列化与单列模式
Protobuf
为什么说序列化并不安全
*	注解
元注解、自定义注解、Java中常用的注解使用、注解与反射的结合
*	JMS
什么是Java消息服务、JMS消息传送模型
*	泛型
泛型与继承
类型擦除
泛型中K T V E
Object等得含义、泛型各种用法
*	JMX
Java.lang.management.*、javax.manager
*	单元测试
Junit、mock、mockito、内存数据库（h2）
*	正则表达式
Java.lang.util.regex.*
*	常用的Java工具库
Commons.lang，conmmons.*、netty
*	什么是API&SPI
*	异常
异常类型、正常处理异常、自定义异常
*	时间处理
时区、时令、java中时间API
*	编码方式
解决乱码问题，常用的编码方式
回答：常见的编码utf-8,gbk,iso8859-1，解决方法是统一页面编码，中间件编码，设置request,response编码。
*	语法糖
Java中语法糖原理、解语法糖
##	Java并发编程
*	什么是线程，与进程的区别
*	阅读源代码，并学会使用
Thread、Runnable、Callable、ReentrantLock、ReentrantReadWriteLock、Atomic*、Semaphore、CountDownLatch、ConcurrentHashMap、Executors
*	线程池
自己设计线程池、submit()和execute()
*	线程安全
死锁、死锁的排查、Java线程调度、线程安全和内存模型的关系
*	锁（Lock）
CAS、乐观锁与悲观锁、数据库相关锁机制、分布式锁、偏向锁、轻量级锁、重量级锁、monitor、锁优化、锁消除、锁粗化、自旋锁、可重入锁、阻塞锁、死锁
*	死锁
*	Volatile
Happens-before、编译器指令重排和CPU指令重排
*	Synchronized
Synchronized是如何实现的？
Synchronized和lock之间关系
不使用synchronized如何实现一个线程安全的单例
*	Sleep和wait
*	Wait和notify
*	Notify和notifyAll
*	ThreadLoacl
*	写一个死锁程序、写代码解决生产者消费者问题
*	守护线程
守护线程和非守护线程的区别以及用法
