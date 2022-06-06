## JVM常用命令整理

|      |        |                                                              |
| :--- | :----- | :----------------------------------------------------------- |
| 1    | jps    | 查找java的进程                                               |
| 2    | jinfo  | 查看java进程启动命令                                         |
| 3    | jstat  | 查看java进程的统计数据                                       |
| 4    | jstack | 查看java进程的线程栈                                         |
| 5    | jmap   | 查看java进程的堆数据，jmap -dump:live,format=b,file=/opt/jvm/dump.hprof pid |

### jps

usage: jps [--help]
       jps [-q] [-mlvV] [<hostid>]

Definitions:
    <hostid>:      <hostname>[:<port>]
    -? -h --help -help: Print this help message and exit.

### jinfo

Usage:
    jinfo <option> <pid>
       (to connect to a running process)

where <option> is one of:
    -flag <name>         to print the value of the named VM flag
    -flag [+|-]<name>    to enable or disable the named VM flag
    -flag <name>=<value> to set the named VM flag to the given value
    -flags               to print VM flags
    -sysprops            to print Java system properties
    <no option>          to print both VM flags and system properties
    -? | -h | --help | -help to print this help message

### jstat

Usage: jstat --help|-options
       jstat -<option> [-t] [-h<lines>] <vmid> [<interval> [<count>]]

Definitions:
  <option>      An option reported by the -options option
  <vmid>        Virtual Machine Identifier. A vmid takes the following form:
                     <lvmid>[@<hostname>[:<port>]]
                Where <lvmid> is the local vm identifier for the target
                Java virtual machine, typically a process id; <hostname> is
                the name of the host running the target Java virtual machine;
                and <port> is the port number for the rmiregistry on the
                target host. See the jvmstat documentation for a more complete
                description of the Virtual Machine Identifier.
  <lines>       Number of samples between header lines.
  <interval>    Sampling interval. The following forms are allowed:
                    <n>["ms"|"s"]
                Where <n> is an integer and the suffix specifies the units as
                milliseconds("ms") or seconds("s"). The default units are "ms".
  <count>       Number of samples to take before terminating.
  -J<flag>      Pass <flag> directly to the runtime system.
  -? -h --help  Prints this help message.
  -help         Prints this help message.

> option

-gc：统计 jdk gc时 heap信息，以使用空间字节数表示
-gcutil：统计 gc时， heap情况，以使用空间的百分比表示
-class：统计 class loader行为信息
-compile：统计编译行为信息
-gccapacity：统计不同 generations（新生代，老年代，持久代）的 heap容量情况
-gccause：统计引起 gc的事件
-gcnew：统计 gc时，新生代的情况
-gcnewcapacity：统计 gc时，新生代 heap容量
-gcold：统计 gc时，老年代的情况
-gcoldcapacity：统计 gc时，老年代 heap容量
-gcpermcapacity：统计 gc时， permanent区 heap容量

> 看GC情况

jstat -gccapacity
jstat -gcutil [pid] 1000 100 (每1000毫秒看内存情况，持续100次)

指标解释
S0 — Heap上的 Survivor space 0 区已使用空间的百分比
S1 — Heap上的 Survivor space 1 区已使用空间的百分比
E — Heap上的 Eden space 区已使用空间的百分比
O — Heap上的 Old space 区已使用空间的百分比
P — Perm space 区已使用空间的百分比
YGC — 从应用程序启动到采样时发生 Young GC 的次数
YGCT– 从应用程序启动到采样时 Young GC 所用的时间(单位秒)
FGC — 从应用程序启动到采样时发生 Full GC 的次数
FGCT– 从应用程序启动到采样时 Full GC 所用的时间(单位秒)
GCT — 从应用程序启动到采样时用于垃圾回收的总时间(单位秒)

S0C：第一个幸存区的大小
S1C：第二个幸存区的大小
S0U：第一个幸存区的使用大小
S1U：第二个幸存区的使用大小
EC：伊甸园区的大小
EU：伊甸园区的使用大小
OC：老年代大小
OU：老年代使用大小
MC：方法区大小
MU：方法区使用大小
CCSC:压缩类空间大小
CCSU:压缩类空间使用大小
YGC：年轻代垃圾回收次数
YGCT：年轻代垃圾回收消耗时间
FGC：老年代垃圾回收次数
FGCT：老年代垃圾回收消耗时间
GCT：垃圾回收消耗总时间



### jstatck

> 看线程堆栈

jstack [pid] >jstack.log
jstack -F [pid] >jstack.log (服务已死加 -F)
jstack -F -m [pid] >jstack.log
jstack -F -m -l [pid] >jstack.log

### jmap

> 看对象数量(显示堆中对象的统计信息)

jmap -histo [pid]>jmaphisto.log
jmap -F -histo [pid]>jmaphisto.log (服务已死加 -F)
jmap -histo:live [pid]>jmaphisto.log (只看存活（会触发fullgc再导出)
其中包括每个Java类、对象数量、内存大小(单位：字节)、完全限定的类名。打印的虚拟机内部的类名称将会带有一个’*’前缀。

> 显示Java堆详细信息

jmap -heap pid
打印一个堆的摘要信息，包括使用的GC算法、堆配置信息和各内存区域内存使用信息

> 看内存Dump

jmap -dump:format=b,file=jmapdump.hprof [pid]
jmap -F -dump:format=b,file=jmapdump.hprof [pid]
tar zcvf jmapdump.hprof.tar.gz jmapdump.hprof



### 查看线程情况

pstree [pid] (打印进程的线程使用情况)
top (看资源使用情况)
top -Hp [pid] (看进程内线程资源情况)
转为 16 进制配合 jstack 可查询线程 CPU 情况