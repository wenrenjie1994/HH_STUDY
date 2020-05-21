## HDFS

### dfsadmin
   
| 命令选项                                    | 描述                                                         |
| --- | -------------- |
| `-report`                                     | 报告文件系统的基本信息和统计信息。                           |
| `-safemode enter \| leave \| get \| wait`    | 安全模式维护命令。安全模式是Namenode的一个状态，这种状态下，Namenode 1. 不接受对名字空间的更改(只读) 2. 不复制或删除块 Namenode会在启动时自动进入安全模式，当配置的块最小百分比数满足最小的副本数条件时，会自动离开安全模式。安全模式可以手动进入，但是这样的话也必须手动关闭安全模式。 |
| `-refreshNodes`                               | 重新读取hosts和exclude文件，更新允许连到Namenode的或那些需要退出或入编的Datanode的集合。 |
| `-finalizeUpgrade`                            | 终结HDFS的升级操作。Datanode删除前一个版本的工作目录，之后Namenode也这样做。这个操作完结整个升级过程。 |
| `-upgradeProgress status \| details \| force` | 请求当前系统的升级状态，状态的细节，或者强制升级操作进行。   |
| `-metasave filename`                          | 保存Namenode的主要数据结构到hadoop.log.dir属性指定的目录下的<filename>文件。对于下面的每一项，<filename>中都会一行内容与之对应 1. Namenode收到的Datanode的心跳信号 2. 等待被复制的块 3. 正在被复制的块 4. 等待被删除的块 |
| `-setQuota <quota> <dirname>...<dirname>`     | 为每个目录 <dirname>设定配额<quota>。目录配额是一个长整型整数，强制限定了目录树下的名字个数。 命令会在这个目录上工作良好，以下情况会报错： 1. N不是一个正整数，或者 2. 用户不是管理员，或者 3. 这个目录不存在或是文件，或者 4. 目录会马上超出新设定的配额。 |
| `-clrQuota <dirname>...<dirname>`             | 为每一个目录<dirname>清除配额设定。 命令会在这个目录上工作良好，以下情况会报错： 1. 这个目录不存在或是文件，或者 2. 用户不是管理员。 如果目录原来没有配额不会报错。 |
| `-help [cmd]`                                 | 显示给定命令的帮助信息，如果没有给定命令，则显示所有命令的帮助信息。 |

1. 使用dfsadmin查看文件系统报告
`hdfs dfsadmin -report`
 ```
Configured Capacity: 86905466880 (80.94 GB)
Present Capacity: 77542240256 (72.22 GB)
DFS Remaining: 76954312704 (71.67 GB)
DFS Used: 587927552 (560.69 MB)
DFS Used%: 0.76%
Under replicated blocks: 0
Blocks with corrupt replicas: 0
Missing blocks: 0
Missing blocks (with replication factor 1): 0
Pending deletion blocks: 0
```

## Yarn
### `yarn application -list [options]`
- `-list`:获取yarn应用程序列表(下面是两个可选的过滤器);
	- appStates [ALL, NEW, NEW_SAVING, SUBMITTED, ACCEPTED, RUNNING, FINISHED, FAILED, KILLED];
	- appTypes [MAPREDUCE, ...];

> 示例:`yarn application -list -appStates ALL`

- `-kill <applicationId>` 杀掉指定的应用程序(applicationId: 指定应用程序的ID);
- `-status <applicationId>`打印指定应用程序的状态

### `yarn node [options]`
- `-list`:列出所有RUNNING的节点；
	- `-all`：列出所有节点，不管是什么状态的；
	- `-states <States>`：状态过滤；
	- `-status <nodeId>`：打印指定节点的状态。

### `yarn daemonlog `
- `-getlevel <host:httpport> <classname>` :打印运行在`<host:port>`的守护进程的日志级别。这个命令内部会连接`http://<host:port>/logLevel?log=<name>`;
- `-setlevel <host:httpport> <classname> <level>`：设置运行在`<host:port>`的守护进程的日志级别。这个命令内部会连接`http://<host:port>/logLevel?log=<name>`。

```bash
[root@hadoopcluster78 ~]# yarn daemonlog -getlevel hadoopcluster79:8088 org.apache.hadoop.yarn.server.resourcemanager.rmapp.RMAppImpl
Connecting to http://hadoopcluster79:8088/logLevel?log=org.apache.hadoop.yarn.server.resourcemanager.rmapp.RMAppImpl
Submitted Log Name: org.apache.hadoop.yarn.server.resourcemanager.rmapp.RMAppImpl
Log Class: org.apache.commons.logging.impl.Log4JLogger
Effective level: INFO
 
[root@hadoopcluster78 ~]# yarn daemonlog -getlevel hadoopcluster78:19888 org.apache.hadoop.mapreduce.v2.hs.JobHistory
Connecting to http://hadoopcluster78:19888/logLevel?log=org.apache.hadoop.mapreduce.v2.hs.JobHistory
Submitted Log Name: org.apache.hadoop.mapreduce.v2.hs.JobHistory
Log Class: org.apache.commons.logging.impl.Log4JLogger
Effective level: INFO
```

### `yarn queue [options]`
- `-help`：帮助
- `-status <QueueName>`：打印队列的状态