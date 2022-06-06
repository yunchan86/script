## JVM常用命令整理

|      |        |                                                              |
| :--- | :----- | :----------------------------------------------------------- |
| 1    | jps    | 查找java的进程                                               |
| 2    | jinfo  | 查看java进程启动命令                                         |
| 3    | jstat  | 查看java进程的统计数据                                       |
| 4    | jstack | 查看java进程的线程栈                                         |
| 5    | jmap   | 查看java进程的堆数据，jmap -dump:live,format=b,file=/opt/jvm/dump.hprof pid |

### jps



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