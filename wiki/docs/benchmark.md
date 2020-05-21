## TestDFSIO
> Program TestDFSIO can be found in jar file /usr/hdp/xxx/hadoop-mapreduce/hadoop-mapreduce-client-jobclient-tests.jar.
The TestDFSIO benchmark is used for measuring I/O (read/write) performance. It does this by using a MapReduce job to read and write files in parallel. Hence, functional MapReduce is needed for it.
The benchmark test uses one map task per file.
### 测试程序路径
`/usr/local/bin/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.9.2-tests.jar`
### TestDFSIO 参数
|arguments|description|
|---------|-----------|
|-write|写测试|
|-read|读测试|
|-nrFiles|文件个数|
|-fileSize|单文件大小|
|-resFile|结果输出文件|
|-bufferSize|缓冲区大小|
|-clean|清除文件|
|-rootDir|根目录|

### 写测试
```bash
# 写入10个100MB文件
$ hadoop jar hadoop-mapreduce-client-jobclient-2.9.2-tests.jar TestDFSIO -write -nrFiles 10 -fileSize 100MB -resFile /tmp/DFS-Write.log
```

```DFS-Write.log
----- TestDFSIO ----- : write
            Date & time: Tue Dec 03 02:32:01 EST 2019
        Number of files: 10
 Total MBytes processed: 1000
      Throughput mb/sec: 3.79
 Average IO rate mb/sec: 4.42
  IO rate std deviation: 1.8
     Test exec time sec: 112.95
```
### 读测试

```DFS-Read.log
----- TestDFSIO ----- : read
            Date & time: Tue Dec 03 03:07:57 EST 2019
        Number of files: 10
 Total MBytes processed: 1000
      Throughput mb/sec: 7.54
 Average IO rate mb/sec: 11.14
  IO rate std deviation: 7.27
     Test exec time sec: 75.59
```

### 测试指标
- **Throughput mb/sec**：每个MapTask的平均吞吐量；
- **Average IO rate mb/sec**: 每个文件的平均IO速度；
- **IO rate std deviation**: 文件IO速率标准差，如果相差较大那么集群中某个节点可能存在IO相关短板。


## TeraSort

### 生成1GB的测试文件
`hadoop jar hadoop-mapreduce-examples-2.9.1.jar teragen -Dmapred.map.tasks=10 10737418 [结果输出]`
- **teragen**: 生成待排序序列；
- **-Dmapred.map.tasks=10**: Map数量；
- **10737418**: 生成排序序列行数，一行100B。

### 对生成序列进行排序
`hadoop jar hadoop-mapreduce-examples-2.9.1.jar terasort -Dmapred.reduce.tasks=10 [输入文件] [结果输出]`
- **terasort**: 排序；
- **-Dmapred.reduce.tasks=10**: reduce数量。

### 对排序结果进行验证
`hadoop jar hadoop-mapreduce-examples-2.9.1.jar teravalidate  /tmp/1GB-output /tmp/1GB-valid`
进入HDFS:/tmp/1GB-valid中可以看到验证结果
```
[root@master hadoop-mapreduce-client]# hadoop fs -ls /tmp/1GB-valid
Found 2 items
-rw-r--r--   3 user hdfs          0 2019-12-03 17:08 /tmp/1GB-valid/_SUCCESS
-rw-r--r--   3 user hdfs          0 2019-12-03 17:08 /tmp/1GB-valid/part-r-00000
```

## MRBench

`time hadoop jar hadoop-mapreduce-client-jobclient-2.9.2-tests.jar  mrbench -numRuns 5`
> 循环运行5次小作业, MRBench会检查小型作业是否有效响应且在集群上正常运行，他将测试重点放在MapReduce上，因为每个任务对HDFS的影响非常小。

```
-baseDir <输出/输入的基本DFS路径，默认为/ benchmarks / MRBench> 
-jar <包含Mapper和Reducer实现的作业jar文件的本地路径，默认为当前jar文件>
-numRuns <运行作业的次数，默认为1>] [-maps <每次运行的映射数，默认为2>
-reduces <每次运行的减少数量，默认为1>] [-inputLines <number生成的输入行数，默认为1>
-inputType <生成的输入类型，升序（默认），降序，随机值之一>
```
### 测试结果
```
DataLines       Maps    Reduces AvgTime (milliseconds)
1               2       1       31787
```
> **AvgTime**：每个task的平均执行时间为31.7秒。


## NNBench
> NNBench用于测试NameNode的负载，它会生成很多与HDFS相关的请求（通常带有很小的有效负载），给NameNode施加较大的压力。这个测试能在HDFS上模拟创建、读取、重命名和删除文件等操作。

`time hadoop jar hadoop-mapreduce-client-jobclient-2.9.2-tests.jar nnbench -operation create_write -maps 12 -reduces 6 -blockSize 1 -bytesToWrite 0 -numberOfFiles 1000`
该命令发起使用12个map和6个reduce创建1000个文件的请求。
```
-operation <create_write/open_read/delete, 此参数是必须的，且先要运行create_write>
-maps <map数量, 默认值为1。非必须>
-reduces <reduce数量, 默认值为1>
-startTime <开始时间，以时间段为单位。确保将来足够远，以便所有map同时开始。默认值为启动时间+2分钟>
-blockSize <块大小（以字节为单位）。默认值为1>
-bytesToWrite <要写入的字节。默认值为0。>
-bytesPerChecksum <文件的每个校验和的字节数。默认值为1。>
-numberOfFiles <要创建的文件数。默认值为1。>
-replicationFactorPerFile <文件的复制数量。默认值为1。>
-baseDir <生成文件目录。默认值为/becnhmarks/NNBench。>
-readFileAfterOpen <true或false。如果为true，它将读取文件并报告平均读取时间。这对open_read操作有效。默认为false。>
-help：显示帮助语句
```

## GridMix2

> GridMix软件包中含有一系列不同的操作，经过测试可以为集群性能进行建模。通过生成随机数并提交到MapReduce来模仿用户的操作，从而进行真实使用环境的性能评估。完整的基准测试完成后将会生成约2.5TB的文件。

### GridMix中包含的任务
1. 三阶段Map/Reduce作业
```
输入：500G压缩（等价于2T未压缩的）SequenceFile
（key,value）=（5 words，100 words）
计算1：map保留10%的数据，reduce保留40%数据,
计算2：map保留10%的数据，reduce保留40%数据，数据来自[计算1]的输出
计算3：map保留10%的数据，reduce保留40%数据，数据来自[计算2]的输出
动机：很多作业负载是流水式 map/reduce 作业，包括pig
对应作业：monsterQuery
```
2. 大规模的数据排序，其中Key和Value都是变长的
```
输入：500G压缩（等价于2T未压缩的）SequenceFile
（key,value）=（5-10 words，100-10000 words）
计算：map保留100%的数据，reduce保留100%数据
动机：处理大规模的压缩数据是非常常见的
对应作业：webdataSort
```
3. 过滤
```
输入：500G压缩（等价于2T未压缩的）SequenceFile
（key,value）=（5-10 words，100-10000 words）
计算：map保留0.2%的数据，reduce保留5%数据
动机：对大数据集进行过滤是很常见的
对应作业：webdataScan
```
4. API文本排序（直接调用API进行排序）
```
输入：500G未压缩文本
（key,value）=（1-10 words，0-200 words）
计算：map保留100%的数据，reduce保留100%数据
动机：map/reduce直接调用库函数进行排序
对应作业：streamSort，javaSort，其中streamSort使用了shell命令cat作为mapper和reducer（这并不是排序，只是简单的进行逐行扫描），javaSort调用了java中的API进行排序。
```

### 使用方法
> Gridmix生成的一个基准负载包含不同数量的各种类型的作业，且每种作业处理的数据量也不同。用户可以在一个xml文件中配置作业数量和数据量，Gridmix会根据这个配置文件构造相应的作业，提交到集群中并监控它们的执行情况直到所有作业完成。

1. 编译：在src/benchmarks/gridmix下，输入“ant”，会在build目录下生成gridmix.jar文件，把它copy到gridmix目录下。

2. 配置环境变量
```
修改脚本gridmix-env-2中的以下几个变量值：
HADOOP_HOME：hadoop安装路径
HADOOP_VERSION：hadoop版本，如hadoop-0.20.2
HADOOP_CONF_DIR：conf路径，如${HADOOP_HOME}/conf
USE_REAL_DATA：是否使用大的数据集（2TB），如果设为false，缺省数据量是2G。用户可以在generateGridmix2Data.sh根据需要配置。
```
3. 配置作业信息
```
Gridmix提供了一个缺省的gridmix_conf.xml，用户可以根据自己的需要作修改。修改的内容可以是：作业的类型和数量，作业处理的数据量，reduce task数目，是否对数据结果进行压缩等。需要注意的是，用户可以配置多个不同reduce数量的同一类型作业，比如：
javaSort.smallJobs.numOfJobs
8,2
javaSort.smallJobs.numOfReduces
15,70
上面的例子设置了10个java sort小作业，其中8个每个带有15个reduce task，另外2个每个带70个reduce task。
在Gridmix中，每种作业有大中小三种类型，小作业只有3个map task（只处理{part-00000,part-00001,part-00002}三块数据）；中作业的task 数目与数据总量有关，它处理与正则表达式{part-000*0,part-000*1,part-000*2}匹配的数据块，比如有10个数据块，分别是part-00000，part-00001，part-00002…part-0009,则中作业只会处理前三块；大作业会处理所有数据。
```
4. 产生数据:使用generateGridmix2Data.sh脚本产生数据，用户可以根据需要配置数据量。在Gridmix中，数据压缩率是4x。
5. 运行:首先确保hadoop集群已经启动，然后运行./rungridmix_2，该脚本会创建start.out记录作业运行开始时间，作业结束时，创建end.out记录完成时间。
