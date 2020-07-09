## Yarn

#### 概述

1. Apache Hadoop YARN （Yet Another Resource Negotiator，另一种资源协调者）是一种新的Hadoop资源管理器，它是一个通用资源管理系统，可为上层应用提供统一的资源管理和调度，它的引入为集群在资源利用率、资源统一管理和数据共享等方面带来了巨大好处。
2. YARN的基本思想是将JobTracker的两个主要功能（资源管理和作业调度/监控）分离，主要方法是创建一个全局的ResourceManager（RM）和若干个针对应用程序的ApplicationMaster（AM）。这里的应用程序是指传统的MapReduce作业。
3. YARN分层结构的本质是 ResourceManager。这个实体控制整个集群并管理应用程序向基础计算资源的分配。ResourceManager     将各个资源部分（计算、内存、带宽等）精心安排给基础 NodeManager（YARN 的每节点代理）。
4. ResourceManager还与 ApplicationMaster 一起分配资源，与 NodeManager一起启动和监视它们的基础应用程序。在此上下文中，ApplicationMaster 承担了以前的 TaskTracker的一些角色,ResourceManager 承担了 JobTracker 的角色。
5. ApplicationMaster管理一个在 YARN 内运行的应用程序的每个实例。ApplicationMaster 负责协调来自 ResourceManager 的资源，并通过NodeManager 监视容器的执行和资源使用（CPU、内存等的资源分配）。

#### 架构图

![Yarn架构图](picture\yarn.png)

#### 核心思想

将JobTracker和TaskTacker进行分离，它由下面几大构成组件：

1. 一个全局的资源管理器ResourceManager
2. ResourceManager的每个节点代理NodeManager
3. 表示每个应用的ApplicationMaster
4. 每一个ApplicationMaster拥有多个Container在NodeManager上运行

#### 基本概念

##### ResourceManager（RM）

1. RM是一个全局的资源管理器,负责整个系统的资源管理和分配。它主要由两个组件构成：调度器（Scheduler）和应用程序管理器（Applications Manager，ASM）。
2. 调度器 ：调度器根据容量、队列等限制条件（如每个队列分配一定的资源，最多执行一定数量的作业等），将系统中的资源分配给各个正在运行的应用程序。需要注意的是，该调度器是一个“纯调度器”，它不再从事任何与具体应用程序相关的工作，比如不负责监控或者跟踪应用的执行状态等，也不负责重新启动因应用执行失败或者硬件故障而产生的失败任务，这些均交由应用程序相关的ApplicationMaster完成。调度器仅根据各个应用程序的资源需求进行资源分配，而资源分配单位用一个抽象概念“资源容器”（Resource     Container，简称Container）表示，Container是一个动态资源分配单位，它将内存、CPU资源封装在一起，从而限定每个任务使用的资源量。
3. 应用程序管理器(Applications Manager)负责管理整个系统中所有应用程序，包括应用程序提交、与调度器协商资源以启动ApplicationMaster、监控ApplicationMaster运行状态并在失败时重新启动它等。

##### ApplicationMaster（AM）

用户提交的每个应用程序均包含一个AM，主要功能包括：

1. 与RM调度器协商以获取资源（用Container表示）。
2. 将得到的任务进一步分配给内部的任务(资源的二次分配)。
3. 与NM通信以启动/停止任务。
4. 监控所有任务运行状态，并在任务运行失败时重新为任务申请资源以重启任务。

##### NodeManager（NM）

1. NM是每个节点上的资源和任务管理器
2. 它会定时地向RM汇报本节点上的资源使用情况和各个Container的运行状态
3. 它接收并处理来自AM的Container启动/停止等各种请求。

##### Container

1. Container是YARN中的资源抽象，它封装了某个节点上的内存、CPU资源。
2. 当AM向RM申请资源时，RM为AM返回的资源便是用Container表示。
3. YARN会为每个任务分配一个Container，且该任务只能使用该Container中描述的资源。

#### 常见参数

| 参数                                     | 默认值                                                       |
| ---------------------------------------- | ------------------------------------------------------------ |
| yarn.nodemanager.resource.memory-mb      | 8192（MB)（每台服务NodeManager服务器贡献的内存），工作中，要根据服务器的实际内存来调节。     比如服务器内存：64GB。给操作系统留出8G。还需要考虑这个服务器上是否还运行，比如Hbase。给Hbase留出16GB，剩下的40GB留给yarn |
| yarn.nodemanager.resource.cpu-vcores     | 8,cpu核数，根据实际情况来配置，有几核就配置几个              |
| yarn.scheduler.minimum-allocation-mb     | 1024（MB），每个Container最小的使用内存量                    |
| yarn.scheduler.maximum-allocation-mb     | 8192（MB），每个Container最大的使用内存量                    |
| yarn.scheduler.minimum-allocation-vcores | 1，每个Container最少的使用核数                               |
| yarn.scheduler.maximum-allocation-vcores | 4，每个Container最多使用的核数                               |
| mapreduce.map.memory.mb                  | 1024（MB），每个MapTask运行所有的内存大小。此参数如果在Container的下限和上限之间，就用设置的参数值。     如果不在上限和下限范围，就取下限或上限值 |
| mapreduce.reduce.memory.mb               | 1024（MB）                                                   |
| yarn.resourcemanager.scheduler.class     | org.apache.hadoop.yarn.server.resourcemanager.scheduler.capacity.CapacityScheduler     配置Yarn的调度器类型，默认是容器调度器。     另外两种调度器：     ①FIFO 调度器     ②Fair 调度器 |

#### job的执行流程

1. 客户端将Job提交给ResourceManager。

2. ResourceManager在收到Job任务之后会等待NodeManager的心跳。

3. 在ResourceManager收到NodeManager的心跳之后会将Job交给这个NodeManager，同时在这个NodeManager上开启一个ApplicationMaster，将Job分配给这个ApplicationMaster - 在Yarn中，每一个Job任务会对应一个单独的ApplicationMaster。

4. ApplicationMaster收到Job之后会对这个Job进行划分，划分好之后会向ResourceManager请求执行资源。请求的资源数量要考虑副本数量。例如，如果一个任务划分成5个MapTask以及2个ReduceTask，那么默认情况下在申请资源的时候会申请17份资源，但是注意ResourceManager会只返回7份资源。

5. ResourceManager收到请求之后会将资源封装成Container对象发送给ApplicationMaster。

6. ApplicationMaster收到Container之后会对资源进行二次分配，分配给具体的子任务。

7. ApplicationMaster会将子任务分发给NodeManager执行，并且会监控这些任务的执行情况。每一个ApplicationMaster只监控自己的任务，不监控其他的ApplicationMaster的任务。

8. 当子任务执行失败的时候，这个子任务所占用的资源也会被释放。ApplicationMaster在监控到这个任务失败的时候会试图重启这个子任务，在重启之前，ApplicationMaster会向ResourceManager重新为这个子任务来申请资源。

9. 注意：

10. 1. 在Yarn体系结构中，ResourceManager管理ApplicationMaster，ApplicationMaster管理子任务。
    2. 默认情况下，每份资源中包含1G内存一个1个CPU核，即允许每一个子任务占用1G内存以及1个CPU核。

![job执行流程](picture\job.png)