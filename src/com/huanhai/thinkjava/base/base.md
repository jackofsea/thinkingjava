# java基础
##	JVM
*	JVM内存结构
堆、栈、方法区、直接内存、堆和栈区别

解答：
 堆：线程共享，可动态扩展的内存区域，在JVM中，堆还被分为年轻代（eden）和年老代，但内存分配超过Xmx时，会发生OOM；
 栈：线程私有，为每个方法创建栈诊，存储局部变量表、操作栈、动态链接、方法出口等信息，当线程调用深度过大会抛出StackOverflowError,
 JVM在扩展栈无法申请到足够内存会发OOM；
 方法区：存储被JVM加载的class信息、常量、静态变量、JIT编译后的代码等数据，也称永久代；
 直接内存：NIO、Native函数直接分配的堆外内存、DirectBuffer会引用这部分内存。

*	JVM内存模型
内存可见性、重排序、顺序一致性、volatile、锁、final

内存可见性：JVM中线程执行有两部分内存：工作内存和主存，工作内存是线程私有，存储变量（有主存中读取过来的），作为缓存存储变量
副本，主存是所有线程能访问的。当变量在线程工作内存中发生变化，其他线程感受不到此变量的变化，除非变量的改变刷新到主存，其他线程才
能读到最新的值，但其中存在延迟，所有不能确定变量值是否最新。因此，线程对变量操作是在工作内存中，其他线程不可见。

重排序：一般情况下，CPU和编译器为了提升程序执行的效率，会按照一定的规则允许进行指令优化，在某些情况下，这种优化会带来一些执行的
逻辑问题，主要的原因是代码逻辑之间是存在一定的先后顺序，在并发执行情况下，会发生二义性，即按照不同的执行逻辑，会得到不同的结果
信息。java存在编译器重排序，处理器重排序（指令级、内存系统）等情况，重排序可能会导致多线程程序出现内存可见性问题。
单线程遵守as-if-serial语义：不管怎么重排序（编译器和处理器为了提高并行度），（单线程）程序的执行结果不能被改变。编译器，runtime
 和处理器都必须遵守as-if-serial语义。
 多线程遵守happens-before原则:在JMM中，如果一个操作执行的结果需要对另一个操作可见，那么这两个操作之间必须存在happens-before关系。
 1. 如果一个操作happens-before另一个操作，那么第一个操作的执行结果将对第二个操作可见，而且第一个操作的执行顺序排在第二个操作之前。
 
 2. 两个操作之间存在happens-before关系，并不意味着一定要按照happens-before原则制定的顺序来执行。如果重排序之后的执行结果与按照
 happens-before关系来执行的结果一致，那么这种重排序并不非法。
 
 下面是happens-before原则规则：
 
 程序次序规则：一个线程内，按照代码顺序，书写在前面的操作先行发生于书写在后面的操作；
 锁定规则：一个unLock操作先行发生于后面对同一个锁额lock操作；
 volatile变量规则：对一个变量的写操作先行发生于后面对这个变量的读操作；
 传递规则：如果操作A先行发生于操作B，而操作B又先行发生于操作C，则可以得出操作A先行发生于操作C；
 线程启动规则：Thread对象的start()方法先行发生于此线程的每个一个动作；
 线程中断规则：对线程interrupt()方法的调用先行发生于被中断线程的代码检测到中断事件的发生；
 线程终结规则：线程中所有的操作都先行发生于线程的终止检测，我们可以通过Thread.join()方法结束、Thread.isAlive()的返回值手段检测到线程已经终止执行；
 对象终结规则：一个对象的初始化完成先行发生于他的finalize()方法的开始；
 我们来详细看看上面每条规则（摘自《深入理解Java虚拟机第12章》）：
 
 程序次序规则：一段代码在单线程中执行的结果是有序的。注意是执行结果，因为虚拟机、处理器会对指令进行重排序（重排序后面会详细介绍）。虽然重排序了，但是并不会影响程序的执行结果，所以程序最终执行的结果与顺序执行的结果是一致的。故而这个规则只对单线程有效，在多线程环境下无法保证正确性。
 
 锁定规则：这个规则比较好理解，无论是在单线程环境还是多线程环境，一个锁处于被锁定状态，那么必须先执行unlock操作后面才能进行lock操作。
 
 volatile变量规则：这是一条比较重要的规则，它标志着volatile保证了线程可见性。通俗点讲就是如果一个线程先去写一个volatile变量，然后一个线程去读这个变量，那么这个写操作一定是happens-before读操作的。
 
 传递规则：提现了happens-before原则具有传递性，即A happens-before B , B happens-before C，那么A happens-before C
 
 线程启动规则：假定线程A在执行过程中，通过执行ThreadB.start()来启动线程B，那么线程A对共享变量的修改在接下来线程B开始执行后确保对线程B可见。
 
 线程终结规则：假定线程A在执行的过程中，通过制定ThreadB.join()等待线程B终止，那么线程B在终止之前对共享变量的修改在线程A等待返回后可见。
 
 上面八条是原生Java满足Happens-before关系的规则，但是我们可以对他们进行推导出其他满足happens-before的规则：
 
 将一个元素放入一个线程安全的队列的操作Happens-Before从队列中取出这个元素的操作
 将一个元素放入一个线程安全容器的操作Happens-Before从容器中取出这个元素的操作
 在CountDownLatch上的倒数操作Happens-Before CountDownLatch#await()操作
 释放Semaphore许可的操作Happens-Before获得许可操作
 Future表示的任务的所有操作Happens-Before Future#get()操作
 向Executor提交一个Runnable或Callable的操作Happens-Before任务开始执行操作
 这里再说一遍happens-before的概念：如果两个操作不存在上述（前面8条 + 后面6条）任一一个happens-before规则，那么这两个操作就没有
 顺序的保障，JVM可以对这两个操作进行重排序。如果操作A happens-before操作B，那么操作A在内存上所做的操作对操作B都是可见的。
 
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
String、Integer、Long、Enum、BigDecimal、ThreadLocal、
ClassLoader & URLClassLoader、ArryList、HashMap & LinkedHashMap & TreeMap & CouncurrentHashMap、HashSet & LinkedHashSet &  TreeSet
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
