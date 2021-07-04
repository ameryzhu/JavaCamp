先把程序跑起来。

通过jps 查看gateway_xxx.jar对应的进程名。

查找进程对应的端口号。

lsof -nN -p 4144 |grep LISTEN

lsof打开该进程对应的open files，grep找到对应的LISTEN端口。

wrk -t 12 -c 1000 -d2s http://localhost:8088

```
Running 2s test @ http://localhost:8088

 12 threads and 1000 connections

 Thread Stats  Avg   Stdev   Max  +/- Stdev

  Latency  17.10ms  13.47ms 92.58ms  70.68%

  Req/Sec  762.18  291.91   2.69k  65.37%

 18673 requests in 2.09s, 4.63MB read

 Socket errors: connect 757, read 100, write 0, timeout 0

 Non-2xx or 3xx responses: 18673

Requests/sec:  8921.50

Transfer/sec:   2.21MB
```







