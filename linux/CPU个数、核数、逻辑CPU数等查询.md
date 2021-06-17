> 物理CPU数

主板上实际插入的cpu数量，可以数不重复的 physical id 有几个（physical id）
```
cat /proc/cpuinfo| grep "physical id"| sort| uniq| wc -l
```

> CPU核数

单块CPU上面能处理数据的芯片组的数量，如双核、四核等 （cpu cores）
```
cat /proc/cpuinfo| grep "cpu cores"| uniq
```

> 逻辑cpu数

简单来说，它可使处理器中的1颗内核，如2颗内核那样在操作系统中发挥作用。

```
cat /proc/cpuinfo| grep "processor"| wc -l
```

> 查看cpu信息（型号）

```
cat /proc/cpuinfo | grep name | cut -f2 -d: | uniq -c
```