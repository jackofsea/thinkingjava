# JVM参数

## 1.常用参数

## 内存相关

> 通过这些参数可以对JVM的内存分配做调整

**Xms**
英文解释：`Initial heap size(in bytes)`
中文释义：`堆区初始值`
使用方法：`-Xms2g` 或 `-XX:InitialHeapSize=2048m`

**Xmx**
英文解释：`Maximum heap size(in bytes)`
中文释义：`堆区最大值`
使用方法：`-Xmx2g` 或 `-XX:MaxHeapSize=2048m`

**Xmn**
英文解释：`Maximum new generation size(in bytes)`
中文释义：`新生代最大值`
使用方法：`-Xmn512m` 或 `-XX:MaxNewSize=512m`

**PermSize**(JDK1.8以后已废弃)
英文解释：`Initial size of permanent generation(in bytes)`
中文释义：`永久代初始大小`
使用方法：`-XX:PermSize=128m`

**MaxPermSize**(JDK1.8以后已废弃)
英文解释：`Maximum size of permanent generation(in bytes)`
中文释义：`永久代最大值`
使用方法：`-XX:MaxPermSize=256m`

**MetaspaceSize**(JDK1.8以后用于替换PermSize)
英文解释：`Initial size of Metaspaces (in bytes)`
中文释义：`元数据区初始大小`
使用方法：`-XX:MetaspaceSize=128m`

**MaxMetaspaceSize**(JDK1.8以后用于替换MaxPermSize)
英文解释：`Maximum size of Metaspaces (in bytes)`
中文释义：`元数据区最大值`
使用方法：`-XX:MaxMetaspaceSize=256m`

**Xss**
英文解释：`Thread Stack Size(in Kbytes)`
中文释义：`线程栈最大值`
使用方法：`-Xss256k` 或 `-XX:ThreadStackSize=256k`

**MaxDirectMemorySize**
英文解释：`Maximum total size of NIO direct-buffer allocations`
中文释义：`最大直接内存（堆外）大小`
使用方法：`-XX:MaxDirectMemorySize=256m`

## GC策略相关

> 通过这些参数可以对JVM的GC性能进行调优

**SurvivorRatio**
英文解释：`Rato of eden/survivor space size`
中文释义：`eden区和survivor的比值`
使用方法：`-XX:SurvivorRatio=6`
使用经验：假如设为6，则表示每个survivor区跟eden区的比值为1:6,每个survivor区占新生代的八分之一

**PretenureSizeThreshold**
英文解释：`Maximum size in bytes of objects allocated in DefNew generation;zero means no maximum`
中文释义：`可以在新生代直接分配的对象最大值，0表示没有最大值`
使用方法：`-XX:PretenureSizeThreshold=1000000`
使用经验：设置该参数，可以使大于这个值的对象直接在老年代分配，避免在Eden区和Survivor区发生大量的内存复制，该参数只对Serial和ParNew收集器有效，Parallel Scavenge并不认识该参数

**MaxTenuringThreshold**
英文解释：`Maximum value fo tenuring threshold`
中文释义：`年轻代最大年龄`
使用方法：`-XX:MaxTenuringThreshold=10`
使用经验：每个对象在坚持过一次Minor GC之后，年龄就增加1，当超过这个参数值时就进入老年代，最大支持15

**UseSerialGC**
英文解释：`Use the Serial garbage collector`
中文释义：`年轻代使用Serial垃圾收集器`
使用方法：
开启 `-XX:+UseSerialGC`
关闭 `-XX:-UseSerialGC`
使用经验：不推荐使用，性能太差，老年代将会使用SerialOld垃圾收集器

**UseParNewGC**
英文解释：`Use parallel threads in the new generation`
中文释义：`年轻代使用ParNew垃圾收集器`
使用方法：
开启 `-XX:+UseParNewGC`
关闭 `-XX:-UseParNewGC`

**ParallelGCThreads**
英文解释：`Number of parallel threads parallel gc will use`
中文释义：`并行执行gc的线程数`
使用方法：`-XX:ParallelGCThreads=16`

**UseParallelGC**
英文解释：`Use the Parallel Scavenge garbage collector`
中文释义：`年轻代使用Parallel Scavenge垃圾收集器`
使用方法：
开启 `-XX:+UseParallelGC`
关闭 `-XX:-UseParallelGC`
使用经验：Linux下1.6,1.7,1.8默认开启，老年代将会使用SerialOld垃圾收集器

**UseParallelOldGC**
英文解释：`Use the Parallel Old garbage collector`
中文释义：`年轻代使用Parallel Scavenge收集器`
使用方法：
开启 `-XX:+UseParallelOldGC`
关闭 `-XX:-UseParallelOldGC`
使用经验：老年代将会使用Parallel Old收集器

**UseConcMarkSweepGC**
英文解释：`Use Concurrent Mark-Sweep GC in the old generation`
中文释义：`老年代使用CMS收集器（如果出现"Concurrent Mode Failure"，会使用SerialOld收集器）`
使用方法：
开启 `-XX:+UseConcMarkSweepGC`
关闭 `-XX:-UseConcMarkSweepGC`
使用经验：年轻代将会使用ParNew收集器

**CMSInitiatingOccupancyFraction**
英文解释：`Percentage CMS generation occupancy to start a CMS collection cycle. A negative value means that CMSTriggerRatio is used`
中文释义：`触发执行CMS回收的当前年代区内存占用的百分比，负值表示使用CMSTriggerRatio设置的值`
使用方法：`-XX:+CMSInitiatingOccupancyFraction=75`

**UseCMSInitiatingOccupancyOnly**
英文解释：`Only use occupancy as a criterion for staring a CMS collection`
中文释义：`只根据占用情况作为开始执行CMS收集的标准`
使用方法：
开启 `-XX:+UseCMSInitiatingOccupancyOnly`
关闭 `-XX:-UseCMSInitiatingOccupancyOnly`

**UseCMSCompactAtFullCollection**
英文解释：`Use Mark-Sweep-Compact algorithm at full collections`
中文释义：`使用CMS执行Full GC时对内存进行压缩`
使用方法：
开启 `-XX:+UseCMSCompactAtFullCollection`
关闭 `-XX:-UseCMSCompactAtFullCollection`

**CMSFullGCsBeforeCompaction**
英文解释：`Number of CMS full collection done before compaction if > 0`
中文释义：`多少次FGC后进行内存压缩`
使用方法：`-XX:CMSFullGCsBeforeCompaction=1`

**CMSClassUnloadingEnabled**
英文解释：`Whether class unloading enabled when using CMS GC`
中文释义：`当使用CMS GC时是否启用类卸载功能`
使用方法：
开启 `-XX:+CMSClassUnloadingEnabled`
关闭 `-XX:-CMSClassUnloadingEnabled`

**CMSParallelRemarkEnabled**
英文解释：`Whether parallel remark enabled (only if ParNewGC)`
中文释义：`是否启用并行标记（仅限于ParNewGC）`
使用方法：
开启 `-XX:+CMSParallelRemarkEnabled`
关闭 `-XX:-CMSParallelRemarkEnabled`

**UseG1GC**
英文解释：`Use the Garbage-First garbage collector`
中文释义：`使用G1垃圾收集器`
使用方法：
开启 `-XX:+UseG1GC`
关闭 `-XX:-UseG1GC`

**MaxGCPauseMillis**
英文解释：`Adaptive size policy maximum GC pause time goal in millisecond, or (G1 Only) the maximum GC time per MMU time slice`
中文释义：`自适应大小策略的最大GC暂停时间目标（以毫秒为单位），或（仅G1）每个MMU时间片的最大GC时间`
使用方法：`-XX:MaxGCPauseMillis=200`

**DisableExplicitGC**
英文解释：`Ignore calls to System.gc()`
中文释义：`禁用System.gc()触发FullGC`
使用方法：
开启 `-XX:+DisableExplicitGC`
关闭 `-XX:-DisableExplicitGC`
PS:不建议开启，如果开启了这个参数可能会导致堆外内存无法及时回收造成内存溢出

## GC日志相关

> 通过这些参数可以对JVM的GC日志输出进行配置，方便分析

**Xloggc**
英文解释：`GC log file`
中文释义：`GC日志文件路径`
使用方法：`-Xloggc:/data/gclog/gc.log`

**UseGCLogFileRotation**
英文解释：`Rotate gclog files(for long running applications). It requires -Xloggc:<filename>`
中文释义：`滚动GC日志文件，须配置Xloggc`
使用方法：
开启 `-XX:+UseGCLogFileRotation`
关闭 `-XX:-UseGCLogFileRotation`

**NumberOfGCLogFiles**
英文解释：`Number of gclog files in rotation(default:0,no rotation)`
中文释义：`滚动GC日志文件数，默认0，不滚动`
使用方法：`-XX:NumberOfGCLogFiles=4`

**GCLogFileSize**
英文解释：`GC log file size,requires UseGCLogFileRotation. Set to 0 to only trigger rotation via jcmd`
中文释义：`GC文件滚动大小，需配置UseGCLogFileRotation，设置为0表示仅通过jcmd命令触发`
使用方法：`-XX:GCLogFileSize=100k`

**PrintGCDetails**
英文解释：`Print more details at garbage collection`
中文释义：`GC时打印更多详细信息`
使用方法：
开启 `-XX:+PrintGCDetails`
关闭 `-XX:-PrintGCDetails`
可以通过`jinfo -flag [+|-]PrintGCDetails <pid>` 或 `jinfo -flag PrintGCDetails=<value> <pid>` 来动态开启或设置值

**PrintGCDateStamps**
英文解释：`Print date stamps at garbage collection`
中文释义：`GC时打印时间戳信息`
使用方法：
开启 `-XX:+PrintGCDateStamps`
关闭 `-XX:-PrintGCDateStamps`
可以通过`jinfo -flag [+|-]PrintGCDateStamps <pid>` 或 `jinfo -flag PrintGCDateStamps=<value> <pid>` 来动态开启或设置值

**PrintTenuringDistribution**
英文解释：`Print tenuring age information`
中文释义：`打印存活实例年龄信息`
使用方法：
开启 `-XX:+PrintTenuringDistribution`
关闭 `-XX:-PrintTenuringDistribution`

**PrintGCApplicationStoppedTime**
英文解释：`Print the time of application has been stopped`
中文释义：`打印应用暂停时间`
使用方法：
开启 `-XX:+PrintGCApplicationStoppedTime`
关闭 `-XX:-PrintGCApplicationStoppedTime`

**PrintHeapAtGC**
英文解释：`Print heap layout before and after each GC`
中文释义：`GC前后打印堆区使用信息`
使用方法：
开启 `-XX:+PrintHeapAtGC`
关闭 `-XX:-PrintHeapAtGC`

## 异常相关

> 通过这些参数可以在JVM异常情况下执行某些操作，以保留现场做分析用

**HeapDumpOnOutOfMemoryError**
英文解释：`Dump heap to file when java.lang.OutOfMemoryError is thrown`
中文释义：`抛出内存溢出错误时导出堆信息到指定文件`
使用方法：
开启 `-XX:+HeapDumpOnOutOfMemoryError`
关闭 `-XX:-HeapDumpOnOutOfMemoryError`
可以通过`jinfo -flag [+|-]HeapDumpOnOutOfMemoryError <pid>` 或 `jinfo -flag HeapDumpOnOutOfMemoryError=<value> <pid>` 来动态开启或设置值

**HeapDumpPath**
英文解释：`When HeapDumpOnOutOfMemoryError is on, the path(filename or directory) of the dump file(defaults to java_pid<pid>.hprof in the working directory)`
中文释义：`当HeapDumpOnOutOfMemoryError开启的时候，dump文件的保存路径，默认为工作目录下的java_pid<pid>.hprof文件`
使用方法：`-XX:HeapDumpPath=/data/dump/jvm.dump`
使用经验：除非必要，建议不设置

## 其他

**server**
英文解释：`server mode`
中文释义：`服务端模式`
使用方法：`-server`

**TieredCompilation**
英文解释：`Enable tiered compilation`
中文释义：`启用多层编译`
使用方法：
开启 `-XX:+TieredCompilation`
关闭 `-XX:-TieredCompilation`