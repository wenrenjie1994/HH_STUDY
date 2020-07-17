# hr_system4.0
本系统为hr_system的4.0版本,本版本主要练习的是socket通信以及多线程
## 文件结构
hr_system4.0 
           |---client--clientMain 
           |---server--serverMain 
           
本系统为maven项目，其中包含server和client两个子项目，client中只包含显示以及输出功能，server中包含所有逻辑结构
为了server和client之间进行通信，定义了Request和Response类。

## 运行方式
1. 设置ServerMain的运行参数：`-port 8081`,在`MySqlUtil`中配置数据库相关数据
2. 运行ServerMain
3. 运行ClientMain
4. 程序运行       
