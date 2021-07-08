# redis

## 1.简介

redis是一个key-value[存储系统](https://baike.baidu.com/item/存储系统)。和Memcached类似，它支持存储的value类型相对更多，包括string(字符串)、list([链表](https://baike.baidu.com/item/链表))、set(集合)、zset(sorted set --有序集合)和hash（哈希类型）。这些[数据类型](https://baike.baidu.com/item/数据类型)都支持push/pop、add/remove及取交集并集和差集及更丰富的操作，而且这些操作都是原子性的。在此基础上，redis支持各种不同方式的排序。与memcached一样，为了保证效率，数据都是缓存在内存中。区别的是redis会周期性的把更新的数据写入磁盘或者把修改操作写入追加的记录文件，并且在此基础上实现了master-slave(主从)同步。

Redis 是一个高性能的key-value数据库。 redis的出现，很大程度补偿了[memcached](https://baike.baidu.com/item/memcached)这类key/value存储的不足，在部 分场合可以对关系数据库起到很好的补充作用。它提供了Java，C/C++，C#，PHP，JavaScript，Perl，Object-C，Python，Ruby，Erlang等客户端，使用很方便。 [1] 

Redis支持主从同步。数据可以从主服务器向任意数量的从服务器上同步，从服务器可以是关联其他从服务器的主服务器。这使得Redis可执行单层树复制。存盘可以有意无意的对数据进行写操作。由于完全实现了发布/订阅机制，使得从数据库在任何地方同步树时，可订阅一个频道并接收主服务器完整的消息发布记录。同步对读取操作的可扩展性和数据冗余很有帮助。

redis的官网地址，非常好记，是redis.io。（域名后缀io属于国家域名，是british Indian Ocean territory，即英属印度洋领地），Vmware在资助着redis项目的开发和维护。

官网地址：https://redis.io/

**软件架构**

## 2.redis安装

## 3.redis的数据类型

Redis 支持 5 中数据类型：string（字符串），hash（哈希），list（列表），set（集合），zset（sorted set：有序集合）。每种数据类型的具体命令请参考[Redis 命令参考](https://links.jianshu.com/go?to=http%3A%2F%2Fdoc.redisfans.com%2Findex.html)

**string**

string 是 redis 最基本的数据类型。一个 key 对应一个 value。string 是二进制安全的。也就是说 redis 的 string 可以包含任何数据。比如 jpg 图片或者序列化的对象。string 类型是 redis 最基本的数据类型，string 类型的值最大能存储 512 MB。



**hash**

Redis hash 是一个键值对（key - value）集合。Redis hash 是一个 string 类型的 key 和 value 的映射表，hash 特别适合用于存储对象。并且可以像数据库中一样只对某一项属性值进行存储、读取、修改等操作。



**list**

Redis 列表是简单的字符串列表，按照插入顺序排序。我们可以网列表的左边或者右边添加元素。 list 就是一个简单的字符串集合，和 Java 中的 list 相差不大，区别就是这里的 list 存放的是字符串。list 内的元素是可重复的。可以做消息队列或最新消息排行等功能。



**set**

redis 的 set 是字符串类型的无序集合。集合是通过哈希表实现的，因此添加、删除、查找的复杂度都是 O（1）。redis 的 set 是一个 key 对应着多个字符串类型的 value，也是一个字符串类型的集合，和 redis 的 list 不同的是 set 中的字符串集合元素不能重复，但是 list 可以。利用唯一性，可以统计访问网站的所有独立 ip。



**Zset**

redis zset 和 set 一样都是字符串类型元素的集合，并且集合内的元素不能重复。不同的是 zset 每个元素都会关联一个 double 类型的分数。redis 通过分数来为集合中的成员进行从小到大的排序。zset 的元素是唯一的，但是分数（score）却可以重复。可用作排行榜等场景。

## 4.内存淘汰策略

​       1.volatile-lru：从已经设置过期时间的数据集中，挑选最近最少使用的数据淘汰

　　2.volatile-ttl：从已经设置过期时间的数据集中，挑选即将要过期的数据淘汰

　　3.volatile-random：从已经设置过期时间的数据集中，随机挑选数据淘汰

　   4.allkeys-lru：从所有的数据集中，挑选最近最少使用的数据淘汰

　    5.allkeys-random：从所有的数据集中，随机挑选数据淘汰

　　6.no-enviction：禁止淘汰数据

## 5.持久化

Redis 是内存型数据库，为了保证数据在断电后不会丢失，需要将内存中的数据持久化到硬盘上。Redis提供了两种持久化的方式，分别是RDB（Redis DataBase）和AOF（Append Only File）。

**RDB**

简而言之，就是在不同的时间点，将redis存储的数据生成快照并存储到磁盘等介质上，可以将快照复制到其他服务器从而创建具有相同数据的服务器副本。如果系统发生故障，将会丢失最后一次创建快照之后的数据。如果数据量大，保存快照的时间会很长。

**AOF**

换了一个角度来实现持久化，那就是将redis执行过的所有写指令记录下来，在下次redis重新启动时，只要把这些写指令从前到后再重复执行一遍，就可以实现数据恢复了。将写命令添加到 AOF 文件（append only file）末尾。

使用 AOF 持久化需要设置同步选项，从而确保写命令同步到磁盘文件上的时机。这是因为对文件进行写入并不会马上将内容同步到磁盘上，而是先存储到缓冲区，然后由操作系统决定什么时候同步到磁盘。选项同步频率always每个写命令都同步，eyerysec每秒同步一次，no让操作系统来决定何时同步，always 选项会严重减低服务器的性能，everysec 选项比较合适，可以保证系统崩溃时只会丢失一秒左右的数据，并且 Redis 每秒执行一次同步对服务器几乎没有任何影响。no 选项并不能给服务器性能带来多大的提升，而且会增加系统崩溃时数据丢失的数量。随着服务器写请求的增多，AOF 文件会越来越大。Redis 提供了一种将 AOF 重写的特性，能够去除 AOF 文件中的冗余写命令。

其实RDB和AOF两种方式也可以同时使用，在这种情况下，如果redis重启的话，则会优先采用AOF方式来进行数据恢复，这是因为AOF方式的数据恢复完整度更高。如果你没有数据持久化的需求，也完全可以关闭RDB和AOF方式，这样的话，redis将变成一个纯内存数据库。

## 6.适用场景

**1.会话缓存（Session Cache）**

最常用的一种使用Redis的情景是会话缓存（session cache）。用Redis缓存会话比其他存储（如Memcached）的优势在于：Redis提供持久化。当维护一个不是严格要求一致性的缓存时，如果用户的购物车信息全部丢失，大部分人都会不高兴的。

**2.队列**

Reids在内存存储引擎领域的一大优点是提供 list 和 set 操作，这使得Redis能作为一个很好的消息队列平台来使用。Redis作为队列使用的操作，就类似于本地程序语言（如Python）对 list 的 push/pop 操作。

**3.全页缓存**

大型互联网公司都会使用Redis作为缓存存储数据，提升页面相应速度。即使重启了Redis实例，因为有磁盘的持久化，用户也不会看到页面加载速度的下降。

**4.排行榜/计数器**

Redis在内存中对数字进行递增或递减的操作实现的非常好。集合（Set）和有序集合（Sorted Set）也使得我们在执行这些操作的时候变的非常简单。