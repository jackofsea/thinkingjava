# JVM的总结

## 1.常见的JVM

**1）Sun Classic VM/Exact VM**

  世界第一款商用java虚拟机,只能以纯解释的方式运行，如果要是JIT，必须进行外挂，其中“sunwjut”就是sun提供的外挂编译器。

**2）sun HotSpot VM**

  目前使用最广的java虚拟机，被Sun jdk和OpenJDK默认使用。

**3） IBM J9**

   IBM J9 VM并不是IBM唯一的一款虚拟机，他是一款设计上从服务器端到桌面应用再到嵌入式都全面考虑的多用途虚拟机，J9的开发目的是作为IBM各种java产品的执行平台

## 2.jvm的内存管理

jvm运行时数据区包括：方法区、堆、虚拟机栈、本地方法栈和程序计数器。其中在sun JVM中把虚拟机栈和本地方法栈合二为一。

**1）程序计数器**

​        使用一块较小的内存空间，每个线程都拥有一个程序计数器，各个程序计数器独立互不影响，是线程私有的。程序计数器永远指向程序下一条的指令，若是java方法，计数器记录的是正在执行的字节码指令的地址，若执行native本地方法时，程序计数器的值为空（Undefined）。因为native方法是java通过JNI直接调用本地C/C++库，可以近似的认为native方法相当于C/C++暴露给java的一个接口，java通过调用这个接口从而调用到C/C++方法。由于该方法是通过C/C++而不是java进行实现。那么自然无法产生相应的字节码，并且C/C++执行时的内存分配是由自己语言决定的，而不是由JVM决定的。

   程序计数器，是唯一一个在java虚拟机规范中没有规定任何OutOfMemoryError的区域。

**2）java虚拟机栈**

​     线程私有，生命周期和线程相同，虚拟机栈描述：每个方在法执行的同时会创建栈帧（stack frame）用于存储局部变量表、操作数栈、动态链接、方法出口等信息。每一个方法调用到执行完成，都是一个入栈到出栈的过程。

​    局部变量表存放了编译时期数据类型（byte、char、boolen、short、int、long、float、double）,对象引用和returnAddress类型(指向一条字节码指令的地址)。

​    其中64位的long和double类型的数据占2 slot，其余的占1 slot，局部变量表所需的内存空间在编译期完成分配，所以一个栈帧中的局部变量空间大小是完全确定的。

java虚拟机规范：当请求栈深度大于虚拟机所以允许的栈深度，会抛出StackOverFlowError异常；如果虚拟机支持动态扩展，当扩展时申请不到足够的内存时，会抛出OutOfMemeryError异常。

**3）本地方法栈**

​           和虚拟机栈基本类似，不过执行的是本地方法，而非字节码。Sun HotSpot将虚拟机栈和本地方法栈合二为一，此部分区域会抛出StackOverFlowError异常和OutOfMemeryError异常。

**4）JAVA堆**

​       线程共享，且在虚拟机启动时创建，绝大部分的对象实例都在堆上分配。java堆是垃圾回收器管理的主要区域，现在的垃圾回收器基本采用分代算法。

​     内存不足以分配新的对象且无法进行扩展，将抛出OutOfMemeryError异常。

**5）方法区**

​      方法区在JVM中也是一个非常重要的区域，它与堆一样，是被线程共享的区域。在方法区中，存储了每个类的信息（包括类的名称、方法信息、字段信息）、静态变量、常量以及编译器编译后的代码等。

​     **方法区（method area）**只是**JVM规范**中定义的一个概念，用于存储类信息、常量池、静态变量、JIT编译后的代码等数据，具体放在哪里，不同的实现可以放在不同的地方。而**永久代**是**Hotspot**虚拟机特有的概念，是方法区的一种实现，别的JVM都没有这个东西。

方法区包括：

（1）静态常量池：即*.class文件中的常量池，class文件中的常量池不仅仅包含字符串/数字这些字面量，还包含类、方法的信息，占用class文件绝大部分空间。这种常量池主要用于存放两大类常量：字面量和符号引用量，字面量相当于Java语言层面常量的概念，如文本字符串，声明为final的常量值等；符号引用则属于编译原理    方面的概念，包括了如下三种类型的常量：类和接口的全限定名、字段名称描述符、方法名称描述符。

​        类的加载过程中的链接部分的解析步骤就是把符号引用替换为直接引用，即把那些描述符（名字）替换为能直接定位到字段、方法的引用或句柄（地址）。

（2）运行时常量池：虚拟机会将各个class文件中的常量池载入到运行时常量池中，即编译期间生成的字面量、符号引用，总之就是装载class文件。

（3）字符串常量池 ：字符串常量池可以理解为运行时常量池分出来的部分。加载时，对于class的静态常量池，如果字符串会被装到字符串常量池中。

（4）整型常量池：Integer，类似字符串常量池，可以理解为运行时常量池分出来的。加载时，对于class的静态常量池装的东西，如果是整型会被装到整型常量池中。

​               类似的还有Character、Long等等常量池（基本数据类型没有）。。

 内存不足以分配新的对象且无法进行扩展，将抛出OutOfMemeryError异常。

**6）直接内存**

   不是虚拟机运行时数据区的一部分，也不是JAVA虚拟机规范的一部分。主要为NIO（New input/output）使用，于JDK1.4引入，是一种基于通道（Channel）和缓冲(Buffer)的方式，使用Native函数库直接分配堆外内存，避免在java堆和Native堆来回复制，显著提高效率。

**7）对象分配**

​     分配方式有两种：指针碰撞和空闲列表。因为多线程的原因，为了解决分配冲突，有种两种方法解决分配冲突：TLAB（Thread Local Allocation Buffer）和CAS。

**8）对象访问**

​    两种：句柄池和直接访问。直接访问是通过引用直接访问到对象，类似C的指针；句柄池则需要单独开辟空间维护，通过引用间接访问对象，类型C的二级指针。

## 3.垃圾收集器和内存分配

### 3.1.对象存活判定

#### 1) 判断算法

​     引用计数法和可达性算法。引用计数法效率很高，给每一个对象添加一个计数器，当有一个地方引用指向这个对象就在该计数器上加一，当引用失效时计数器就减一，任何时刻计数器为0时这个对象不会再被使用，此对象便是可回收的对象。引用计数法虽然效率高，但是无法解决循环引用的问题；可达性算法是通过“GC Roots”的对象作为起始点，由这些对象开始向下搜索，搜索过的路径称为引用链，当一个对象不能通过GC Roots到达，那么这个对象就是不可达，由此判定位可回收的对象。

  在java的语言中，以下对象可作为GC Root:

​        虚拟机栈中的引用对象；

​        方法区中类静态属性引用的对象；

​        方法区中常量引用的对象；

​        本地方法栈JNI中引用的对象。

  在可达性算法中，对象也不是“非死不可”，它们只是处于“缓刑”阶段，一个对象的真正死亡至少要经过两次标记过程：如果对象经过可达性算法分析后发现没有与GC Roots相连接的引用链，那它将会被第一次标记并且进行一次筛选，筛选的条件是此对象是否有必要执行finalize()方法。

#### 2)引用分类

​    JDK1.2以后将引用分为四类：强引用、软引用、弱引用和虚引用，这4种引用强度依次减弱。

​       强引用：代码中普遍存在，如“Object a=new Object()”此类的代码，只要引用存在那么JVM是不会回收此对象的。

​      软引用：描述一些有用但非必需对象，当JVM内存发生内存溢出异常前的时候，垃圾回收器会回收软引用对象的内存，如果回收后的内存不足以分配空间，那么会抛出OOM异常。软引用由SoftReference实现。

​     弱引用：描述一下非必需的对象，被弱引用关联的对象只能生存到下一次垃圾收集发生之前。当垃圾收集器工作时，无论内存是否足够，都会回收弱引用关联的对象。弱引用由WeakReference实现。

​    虚引用：也称幽灵引用或幻影引用，它是最弱的一种引用关系。一个对象是否有虚引用的存在，完全不会对其生存时间构成影响，也无法通过虚引用取得一个对象的实例。唯一目的就是能在这个对象被回收时收到一个系统通知。需引用由PhantomReference类实现。

### 3.2.垃圾收集算法

#### 1）标记-清除

​      ”标记-清除“（Mark-Sweep）是最基础的算法，该算法分为”标记“和”清除“两个阶段：第一阶段标记，再标记完成后统一回收。该算法有两个缺点：其一是效率问题，标记和清除的效率都不高；其二是完成回收后会产生大量的空间碎片。大量的空间碎片可能导致无法分配大对象，从而频繁触发垃圾回收动作。

#### 2）复制算法

​     “复制”算法将内存分为大小相等的两块，每次使用一块内存，当触发垃圾回收的时候，直接将存活的对象复制到另一块的内存上，然后清除使用的内存。该算法在存活对象少的时候效率高，不产生空间碎片，缺点需要的内存时原来的两倍，当存活对象多的时候效率下降明显。

#### 3）标记-整理

   “标记-整理”（Mark-Compact）算法，标记过程与  ”标记-清除“算法一样，后面的步骤是让存活的对象项一端移动，最后清理掉边界之外的内存。

#### 4）分代收集算法

​      当代商业虚拟机都采用“分代手机”算法（应该算是一种策略），根据对象生存周期的不同把内存划分成的几块，一般把堆分为老年代和新生代，根据各个年代的特点采用最适合的算法。一般新生代采用复制算法，老年代采用“标记-整理”或“标记-清除”算法。

### 3.3.HotSpot的算法实现

#### 1) 枚举根节点

   可达性算法中必须现在找到GC Roots节点，从而找到引用链。

   分析工作必须在执行系统在某个状态下进行，所以会导致java所有线程处于停顿状态。
由于目前的主流java虚拟机使用的都是准确式GC，所以当执行系统停顿下来后，不需要一个不漏的检查完所有执行上下文和全局的引用位置。
   在HotSpot中，使用一组称为OopMap的数据结构来达到这个目的，在类加载完成的时候，HotSpot就把对象内什么偏移量上是什么类型的数据计算出来，在JIT编译过程中，也会在特定的位置记录下栈和寄存器中哪些位置是引用。这样GC在扫描的时候就可以直接得知这些信息了。

#### 2）安全点

​         HotSpot可以快速且准确的完成GC Roots的枚举，但是导致引用关系变化，OopMap内容变化的指令非常多。

​      HotSpot 并没有为每条指令都生成OopMap，只是在特定的位置记录了这些信息。这些位置叫做安全点。
GC并不是在所有地方都能停顿下来开始GC，只有在达到安全点时才能暂停。安全点不能太少（导致GC等待时间太长），也不能太多（过分增大运行时的负荷）。安全点的选定基本上是以程序“是否具有让程序长时间执行的特征”为标准进行选定的——因为每条指令执行的时间都非常短暂，所以长时间执行的最明显的特征是指令序列服用。如方法调用，循环跳转，异常跳转等。所以具有这些功能的指令才会产生Safepoint。
​      在GC发生时让所有线程都跑到最近的安全点上停顿的解决方案：抢先式中断，主动是中断。
​      抢先式中断：在GC发生的时，先把所有的线程全部中断，如果发现有现成中断的地方不在安全点上，就恢复这些线程，让它跑到安全点上。现在几乎没有虚拟机使用这种方案。
​       主动式中断：不直接对线程操作，仅仅简单的设置一个标志，各个线程执行时主动去轮询这个标志，发现中断标志为true时就自己中断挂起。轮询标志的地方和安全点是重合的,另外再加上创建对象需要分配内存的地方。

#### 3）安全区域

​       面讲述的Safepoint似乎已经完美的解决了如何进入GC的问题，但实际情况却不一定。Safepoint机制保证了程序执行时，在不长的时间内就会遇到可进入GC的Safepoint。但是，程序不执行的时候呢？所谓的程序不执行就是没有分配CPU时间，典型的例子就是线程处于sleep状态或者Blocked状态，这时候线程无法响应JVM的中断请求，“走”到安全的地方去中断挂起，JVM显然也不太可能等待线程重新被分配CPU时间。这种情况，就需要安全区域来解决了。

　　安全区域是指在一段代码片段之中，引用关系不会发生变化。在这个区域中的任意地方开始GC都是安全的。可以把安全区域看做是扩展了的安全点。

　　在线程执行到安全区域的代码时，首先标识自己进入到了安全区域，这样，当这段时间内JVM要发起GC时，就不用管标识自己为安全区域状态的线程了；在线程要离开安全区域时，它要检查是否系统已经完成了枚举根节点（或整个GC过程），如果完成了，那么线程就继续执行，否则就必须等待到直到收到可以安全离开安全区域的信号为止。

### 3.4.垃圾回收器

#### 1）serial收集器

​       Serial收集器是最基本、发展历史最悠久的收集器。这是一个**单线程收集器**。但它的“单线程”的意义并不仅仅说明它只会使用一个CPU或一条收集线程去完成垃圾收集工作，更重要的是它在进行垃圾收集时，必须暂停其他所有的工作线程，直到它收集结束。它是虚拟机运行在Client模式下的默认新生代收集器。

#### 2）ParNew收集器

​     ParNew收集器是Serial收集器的多线程版本，是许多运行在Server模式下的虚拟机中首选的新生代收集器，其中一个与性能无关但很重要的原因是，除了Serial收集器外，目前只有它能与CMS收集器配合工作。

ParNew收集器默认开启的收集线程数与CPU的数量相同。

#### 3）Parallel Scavenge收集器

Parallel Scavenge收集器是一个新生代收集器，使用复制算法，又是并行的多线程收集器。
**最大的特点是：**Parallel Scavenge收集器的目标是达到一个可控制的吞吐量。

**所谓吞吐量就是CPU用于运行用户代码的时间与CPU总消耗时间的比值**，即吞吐量=运行用户代码时间/（运行用户代码时间+垃圾收集时间）。

高吞吐量则可以高效率地利用CPU时间，尽快完成程序的运算任务，**主要适合在后台运算而不需要太多交互的任务。**

#### 4）Serial Old收集器

Serial Old是Serial收集器的老年代版本，同样是一个单线程收集器，使用“标记-整理”算法。这个收集器的主要意义也是在于给Client模式下虚拟机使用。

如果在Server模式下，它主要还有两大用途：
      1.与Parallel Scavenge收集器搭配使用

​      2.作为CMS收集器的后备预案，在并发收集发生Conurrent Mode Failure使用。

#### 5）Palalle Old收集器

Parallel Old是Parallel Scavenge收集器的老年代版本，使用多线程和“标记-整理”算法。

在注重吞吐量以及CPU资源敏感的场合，都可以优先考虑Parallel Scavenge+Parallel Old收集器

#### 6）CMS收集器

**是HotSpot虚拟机中第一款真正意义上的并发收集器，它第一次实现了让垃圾收集线程与用户线程同时工作。**

**关注点：**尽可能地缩短垃圾收集时用户线程的停顿时间。

CMS收集器是基于“标记-清除”算法实现的，**整个过程分为4个步骤**：
①初始标记
②并发标记
③重新标记
④并发清除
其中，初始标记，重新标记这两个步骤仍然需要“Stop The World”。初始标记仅仅只标记一下GC Roots能直接关联到的对象，速度很快。并发标记阶段就是 进行GC Roots Tracing的过程。
重新标记阶段则是为了修正并发标记期间因用户程序继续运作而导致标记产生变动的那一部分对象的标记几率，这个阶段的停顿时间一般会比初始标记阶段稍长，但远比并发标记时间短。
整个过程耗时最长的阶段是并发标记，并发清除过程，但这两个过程可以和用户线程一起工作。

#### 7）G1收集器

是当今收集器技术发展的最前沿成果之一。是一款面向服务端应用的垃圾收集器。
**特点：**
①并行与并发
能充分利用多CPU，多核环境下的硬件优势，缩短Stop-The-World停顿的时间，同时可以通过并发的方式让Java程序继续执行
②分代收集
可以不需要其他收集器的配合管理整个堆，但是仍采用不同的方式去处理分代的对象。
③空间整合
G1从整体上来看，采用基于“标记-整理”算法实现收集器
G1从局部上来看，采用基于“复制”算法实现。
④可预测停顿

使用G1收集器时，Java堆内存布局与其他收集器有很大差别，它将整个Java堆划分成为多个大小相等的独立区域。
G1跟踪各个Region里面的垃圾堆积的价值大小（回收所获得的空间大小以及回收所需时间的经验值），在后台维护一个优先列表，每次根据允许的收集时间，优先回收价值最大的Region。

#### 8）GC日志

[GC [PSYoungGen: 7307K->480K(9216K)] 7307K->6624K(19456K), 0.0072860 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]

[Full GC [PSYoungGen: 480K->0K(9216K)] [ParOldGen: 6144K->6476K(10240K)] 6624K->6476K(19456K) [PSPermGen: 2920K->2919K(21504K)], 0.0178620 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]

[Full GC [PSYoungGen: 4354K->1024K(9216K)] [ParOldGen: 6476K->9536K(10240K)] 10831K->10560K(19456K) [PSPermGen: 2921K->2921K(21504K)], 0.0139610 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]

[Full GC [PSYoungGen: 7339K->0K(9216K)] [ParOldGen: 9536K->4419K(10240K)] 16876K->4419K(19456K) [PSPermGen: 3004K->3004K(21504K)], 0.0120490 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]


Heap

 PSYoungGen      total 9216K, used 4190K [0x00000007ff600000, 0x0000000800000000, 0x0000000800000000)

​    eden space 8192K, 51% used [0x00000007ff600000,0x00000007ffa17a18,0x00000007ffe00000)

​    from space 1024K, 0% used [0x00000007ffe00000,0x00000007ffe00000,0x00000007fff00000)

​    to   space 1024K, 0% used [0x00000007fff00000,0x00000007fff00000,0x0000000800000000)

 ParOldGen       total 10240K, used 4419K [0x00000007fec00000, 0x00000007ff600000, 0x00000007ff600000)

​      object space 10240K, 43% used [0x00000007fec00000,0x00000007ff050eb0,0x00000007ff600000)

  PSPermGen       total 21504K, used 3010K [0x00000007f9a00000, 0x00000007faf00000, 0x00000007fec00000)

​     object space 21504K, 14% used [0x00000007f9a00000,0x00000007f9cf0bf8,0x00000007faf00000)

GC日志的格式：

（1）GC, Full GC说明了这次垃圾收集的停顿类型，而不是用来区分新生代GC还是老年代GC。如果有"Full"，则表示这次GC发生了"Stop-The-World"。

（2）PSYoungGen, ParOldGen，PSPermGen表示GC发生的区域，这里显示的区域名称与使用的GC收集器密切相关，不同收集器对于不同区域所显示的名称可能不同。

（3）接下来"7307K->480K(9216K)"的含义是：GC前该内存区域已使用容量 -> GC后该内存区域已使用容量(该内存区域的总容量)。

（4）"7307K->6624K(19456K)"的含义是：GC前Java堆已使用容量 -> GC后Java堆已使用容量（Java堆总容量） 

（5）"0.0072860 secs" 表示该内存区域GC所占用的时间，单位是秒。

（6）[Times: user=0.01 sys=0.01, real=0.00 secs]：分别表示用户态消耗CPU时间, 内核态消耗CPU时间，操作从开始到结束所经过的墙钟时间。

　　PS，CPU时间与墙钟时间的区别是：墙钟时间包括各种非运算的等待耗时，例如等待磁盘I/O、等待线程阻塞等；而CPU时间不包括这些耗时。

　　当系统有多cpu或者多核的话，多线程操作会叠加这些CPU时间，所以有时看到user或sys时间超过real时间是完全正常的。

4.性能监控工具和命令

#### 4.1.命令概述

​    **jps**  列出正在运行的java进程

 常用参数：-l   -v

​    **jinfo** 显示配置信息

 常用参数：-flags

   **jstat**  统计运行时的数据

 常用参数：-gc   -class  -gcutil  -gccause

   **jmap**  生成虚拟机的内存转储快照（生成文件heapdump）

 常用参数:-heap   -dump -finalizerinfo

示例：jmap -dump:farmat=b,file=ba.bin  23322

   **jhat**    与jmap搭配使用，用于分析heapdump

示例：jhat ba.bin

   **jstack**   显示虚拟机的线程快照

常用参数:-F -l  -m

#### 4.2.监控工具

**1）jconsole**

   图形化工具，自行学习，比较简单。

**2) jvisualvm**

   图形化工具，自行学习，需安装插件。

### 类文件结构

   任何一个Class文件都对应唯一一个类或接口，但反过来不一定，类或接口并不一定文件里，有可能被加载器生产。

   java虚拟机规范规定，Class文件格式采用类似C语言的伪结构体来存储数据，这个伪结构体只有两种类型：无符号数和表，解析都以这两种类型为基础。

- 魔数、次版本号、主版本号
- 常量池
- 访问标志
- 类索引、父类索引和接口索引
- 字段表集合
- 方法表集合
- 属性表集合