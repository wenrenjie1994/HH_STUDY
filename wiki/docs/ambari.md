# Ambari安装
## Introduce
Apache Ambari项目旨在通过开发用于配置，管理和监视Apache Hadoop集群的软件来简化Hadoop管理。Ambari通过其RESTful API提供了直观，易于使用的Hadoop管理Web UI。

Ambari使系统管理员可以：
1. 设置Hadoop集群
	- Ambari提供了用于在任意数量的主机上安装Hadoop服务的分步向导。
	- Ambari处理群集的Hadoop服务的配置。
2. 管理Hadoop集群
	- Ambari提供了用于在整个集群中启动，停止和重新配置Hadoop服务的集中管理。
3. 监控Hadoop集群
	- Ambari提供了一个仪表板，用于监视Hadoop集群的运行状况和状态。
	- Ambari利用Ambari Metrics System收集指标。
	- Ambari利用Ambari Alert Framework进行系统警报，并在需要您关注时（例如，节点故障，剩余磁盘空间不足等）通知您。
4. Ambari使应用程序开发人员和系统集成商能够：
	- 使用Ambari REST API轻松将Hadoop的配置，管理和监视功能集成到自己的应用程序中。

## 安装前准备
1. SSH免密登录;
2. 确保home目录的写权限;
3. Python Interpreter version >= 2.6.

## 安装过程
1. Get Ambari

	`wget http://www.apache.org/dist/ambari/ambari-2.7.4/apache-ambari-2.7.4-src.tar.gz` 
2. Install Ambari server

	`yum install ambari-server*.rpm    #This should also pull in postgres packages as well.`
3. Setup server with setup command to configure the Ambari server, DB, JDK, LDAP..

	`ambari-server setup`
4. Start

	`ambari-server start`
5. Install and Start Ambari agent on all hosts

	`yum install ambari-agent*.rpm`
6. Edit /etc/ambari-agent/ambari.ini

```
...
[server]
hostname=localhost
 
...
```
> Make sure hostname under the [server] section points to the actual Ambari Server host, rather than "localhost".

7. `ambari-agent start`

## Ambari的架构和工作原理

![Ambari架构](\images\ambari\img016.jpg)

## 拓展Service服务

1. Service隶属于Stack，所以需将Service放在对应版本的Stack下，结构如图

```
redis-service
├─ configurate
│    └─ redis-service.xml
├─ metainfo.xml
├─ metrics.json
├─ package
│    └─ scripts
│           ├─ master.py
│           └─ slave.py
└─ widgets.json
```

- `configurate/redis-service.xml`主要安装完成配置该模块的调用；
- `package`中python脚本控制Service的生命周期；
- `metainfo.xml`定义Service的属性；
- `metrics.json`和`widgets.json`控制Service界面的图表显示。

2. ` metainfo.xml `

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <metainfo> 
      <schemaVersion>2.0</schemaVersion>  
      <services> 
        <service> 
          <name>REDIS-SERVICE</name>  
          <displayName>Reids</displayName>  
          <comment>My Service</comment>  
          <version>1.0</version>  
          <components> 
            <component> 
              <name>MASTER</name>  
              <displayName>Master</displayName>  
              <category>MASTER</category>  
              <timelineAppid>redis</timelineAppid>  
              <cardinality>1</cardinality>  
              <commandScript> 
                <script>scripts/master.py</script>  
                <scriptType>PYTHON</scriptType>  
                <timeout>5000</timeout> 
              </commandScript> 
            </component>  
            <component> 
              <name>SALVE</name>  
              <displayName>Slave</displayName>  
              <category>SLAVE</category>  
              <cardinality>1+</cardinality>  
              <commandScript> 
                <script>scripts/slave.py</script>  
                <scriptType>PYTHON</scriptType>  
                <timeout>5000</timeout> 
              </commandScript> 
            </component> 
          </components>  
          <osSpecifics> 
            <osSpecific> 
              <osFamily>any</osFamily> 
            </osSpecific> 
          </osSpecifics> 
        </service> 
      </services> 
    </metainfo>
    
    ```

    