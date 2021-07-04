java - 标准参数

java -X 非标准参数

java -XX 非stable参数



serial gc 线性GC，单线程，处理速度较慢

parallel gc 并行有比较大的吞吐量；但是gc时间可能比较长。

cms gc 并发gc，线程数量的1/4作为gc线程，剩余作为业务线程。

g1 gc 把堆中内存分成了一块一块的，根据每块内存填充情况，来智能决定回收哪一块的内存，有比较低的延时，如果对低延时有要求的可以考虑。



```
02nio % java -XX:+PrintGC -XX:+UseSerialGC GCLogAnalysis
正在执行...
[GC (Allocation Failure)  69717K->21281K(253440K), 0.0114904 secs]
[GC (Allocation Failure)  91233K->45607K(253440K), 0.0178116 secs]
[GC (Allocation Failure)  115559K->69338K(253440K), 0.0134900 secs]
[GC (Allocation Failure)  139290K->90467K(253440K), 0.0122384 secs]
[GC (Allocation Failure)  160419K->115235K(253440K), 0.0136257 secs]
[GC (Allocation Failure)  185173K->138724K(253440K), 0.0129903 secs]
[GC (Allocation Failure)  208450K->160418K(253440K), 0.0126623 secs]
[GC (Allocation Failure)  230370K->184459K(254596K), 0.0153917 secs]
[Full GC (Allocation Failure)  184459K->161479K(254596K), 0.0183964 secs]
[GC (Allocation Failure)  268971K->196689K(390288K), 0.0130137 secs]
[GC (Allocation Failure)  304204K->236958K(390288K), 0.0315014 secs]
[GC (Allocation Failure)  344670K->276336K(390288K), 0.0224012 secs]
[GC (Allocation Failure)  383744K->312297K(420048K), 0.0217485 secs]
[Full GC (Allocation Failure)  312297K->247657K(420048K), 0.0292349 secs]
[GC (Allocation Failure)  412791K->297166K(598556K), 0.0166588 secs]
[GC (Allocation Failure)  462350K->351134K(598556K), 0.0320805 secs]
[GC (Allocation Failure)  516318K->398787K(598556K), 0.0269439 secs]
[GC (Allocation Failure)  563971K->452027K(617348K), 0.0302205 secs]
[Full GC (Allocation Failure)  452027K->337560K(617348K), 0.0335007 secs]
[GC (Allocation Failure)  562712K->409685K(815852K), 0.0187194 secs]
[GC (Allocation Failure)  634837K->475942K(815852K), 0.0291620 secs]
[GC (Allocation Failure)  701094K->544536K(815852K), 0.0389941 secs]
[GC (Allocation Failure)  769688K->611239K(836512K), 0.0388397 secs]
[Full GC (Allocation Failure)  611239K->355119K(836512K), 0.0372757 secs]
[GC (Allocation Failure)  591983K->429703K(858300K), 0.0132939 secs]
[GC (Allocation Failure)  666567K->503188K(858300K), 0.0122997 secs]
[GC (Allocation Failure)  740052K->566809K(858300K), 0.0111065 secs]
执行结束!共生成对象次数:12318

```

```
02nio % java -XX:+PrintGC -XX:+UseParallelGC GCLogAnalysis
正在执行...
[GC (Allocation Failure)  65116K->21913K(251392K), 0.0081818 secs]
[GC (Allocation Failure)  87449K->45513K(316928K), 0.0113502 secs]
[GC (Allocation Failure)  176585K->85359K(316928K), 0.0198913 secs]
[GC (Allocation Failure)  216431K->124950K(448000K), 0.0199715 secs]
[GC (Allocation Failure)  387094K->198821K(461824K), 0.0268911 secs]
[Full GC (Ergonomics)  198821K->165597K(590336K), 0.0141540 secs]
[GC (Allocation Failure)  427565K->243450K(899584K), 0.0276463 secs]
[GC (Allocation Failure)  741626K->350106K(915456K), 0.0578701 secs]
[Full GC (Ergonomics)  350106K->267758K(1044992K), 0.0276435 secs]
[GC (Allocation Failure)  765934K->414384K(1520640K), 0.0498311 secs]
[GC (Allocation Failure)  1328816K->554502K(1542656K), 0.1032345 secs]
[Full GC (Ergonomics)  554502K->350108K(1651712K), 0.0293258 secs]
执行结束!共生成对象次数:11526
```

```
02nio % java -XX:+PrintGC -XX:+UseConcMarkSweepGC GCLogAnalysis
正在执行...
[GC (Allocation Failure)  69921K->23755K(253440K), 0.0091885 secs]
[GC (Allocation Failure)  93603K->45411K(253440K), 0.0106099 secs]
[GC (Allocation Failure)  115363K->67611K(253440K), 0.0158491 secs]
[GC (Allocation Failure)  137549K->90976K(253440K), 0.0133939 secs]
[GC (Allocation Failure)  160828K->117571K(253440K), 0.0170735 secs]
[GC (CMS Initial Mark)  120179K(253440K), 0.0002858 secs]
[GC (Allocation Failure)  187517K->144685K(253440K), 0.0159195 secs]
[GC (Allocation Failure)  214637K->169863K(253440K), 0.0150422 secs]
[GC (Allocation Failure)  239815K->195571K(266200K), 0.0175489 secs]
[GC (Allocation Failure)  265355K->219349K(290036K), 0.0147334 secs]
[GC (Allocation Failure)  289301K->245446K(316072K), 0.0140661 secs]
[GC (Allocation Failure)  314988K->265979K(336680K), 0.0151550 secs]
[GC (Allocation Failure)  335931K->286740K(357548K), 0.0122168 secs]
[GC (Allocation Failure)  356652K->316881K(387632K), 0.0177315 secs]
[GC (Allocation Failure)  386452K->341152K(412008K), 0.0202622 secs]
[GC (Allocation Failure)  411056K->362597K(433460K), 0.0177601 secs]
[GC (Allocation Failure)  432549K->388572K(459396K), 0.0217684 secs]
[GC (Allocation Failure)  458466K->409609K(480400K), 0.0134530 secs]
[GC (Allocation Failure)  479391K->432127K(502956K), 0.0284350 secs]
[GC (Allocation Failure)  502079K->457875K(528660K), 0.0154308 secs]
[GC (Allocation Failure)  527827K->478071K(548892K), 0.0195613 secs]
[GC (Allocation Failure)  547740K->500332K(571272K), 0.0172755 secs]
[GC (Allocation Failure)  570284K->520033K(590872K), 0.0129574 secs]
[GC (Allocation Failure)  589985K->541359K(612324K), 0.0131058 secs]
[GC (Allocation Failure)  611116K->563340K(634340K), 0.0192428 secs]
[GC (Allocation Failure)  633292K->583801K(654768K), 0.0135150 secs]
[GC (Allocation Failure)  653753K->607525K(678468K), 0.0173467 secs]
[GC (Allocation Failure)  677407K->629722K(700652K), 0.0154626 secs]
[GC (Allocation Failure)  699626K->655268K(726336K), 0.0214770 secs]
[GC (Allocation Failure)  725170K->679121K(750124K), 0.0201432 secs]
[GC (Allocation Failure)  748838K->703161K(774128K), 0.0166945 secs]
[GC (Allocation Failure)  773113K->726550K(797492K), 0.0147238 secs]
[GC (Allocation Failure)  796502K->750151K(821268K), 0.0214803 secs]
[GC (Allocation Failure)  820103K->773197K(844264K), 0.0166998 secs]
[GC (Allocation Failure)  843113K->798487K(869532K), 0.0166119 secs]
[GC (Allocation Failure)  868439K->822882K(893972K), 0.0187572 secs]
[GC (Allocation Failure)  892533K->844025K(915088K), 0.0133880 secs]
[GC (Allocation Failure)  913977K->865119K(936100K), 0.0187987 secs]
[GC (Allocation Failure)  935071K->886745K(957764K), 0.0174129 secs]
[GC (Allocation Failure)  956697K->911318K(982276K), 0.0141096 secs]
执行结束!共生成对象次数:10330
```



parallel gc 回收更多的内存，但是消耗的时间更短。

```
02nio % java -XX:+PrintGC -XX:+UseG1GC GCLogAnalysis
正在执行...
[GC pause (G1 Evacuation Pause) (young) 30M->10M(256M), 0.0031861 secs]
[GC pause (G1 Evacuation Pause) (young) 42M->21M(256M), 0.0033573 secs]
[GC pause (G1 Evacuation Pause) (young) 71M->38M(256M), 0.0079462 secs]
[GC pause (G1 Evacuation Pause) (young) 102M->58M(512M), 0.0083792 secs]
[GC pause (G1 Evacuation Pause) (young) 168M->86M(1024M), 0.0128242 secs]
[GC pause (G1 Evacuation Pause) (young) 212M->123M(1639M), 0.0161960 secs]
[GC pause (G1 Evacuation Pause) (young) 305M->174M(2131M), 0.0117328 secs]
[GC pause (G1 Evacuation Pause) (young) 682M->304M(2524M), 0.0373792 secs]
[GC pause (G1 Evacuation Pause) (young) 482M->341M(2839M), 0.0156301 secs]
[GC pause (G1 Evacuation Pause) (young) 698M->437M(3091M), 0.0380126 secs]
执行结束!共生成对象次数:6723
```

g1 gc 一次full gc也没有产生。

