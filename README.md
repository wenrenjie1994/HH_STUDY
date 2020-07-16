***
本工程包含两个module，hr-server以及hr-client

运行步骤为
1. 执行hr-server工程下HRServer类中的main方法打开socket服务端
2. 执行hr-client工程下HRClient类中的main方法打开socket客户端
3. 根据命令行提示进行操作，现支持对简历的增删改查
4. 客户端现未对返回的数据进行解析，直接粗暴地打印了出来

***
tips
1. 可在intellj idea中配置HRClient的run configuration中的allow parallel run属性为true，则可以并行多个客户端测试服务端性能
2. 进一步的优化目标包括Socket的重连尝试，心跳包的建立来合理释放服务器及客户端资源，优化数据库操作，提高工具类通用性等工作
