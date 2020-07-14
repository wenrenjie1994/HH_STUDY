## JDBC连接池
  - 概念：其实就是一个容器(集合)，存放数据库连接的容器。<br>
    　　当系统初始化好后，容器被创建，容器中会申请一些连接对象，当用户来访问数据库时，从容器中获取连接对象，用户访问完之后，会将连接对象归还给容器。
  
    - 好处：
      - 节约资源
      - 用户访问高效
  
    - 实现：标准接口：DataSource   javax.sql包下的<br>
  	- 方法：
  	  - 获取连接：getConnection()
  	  - 归还连接：Connection.close()。如果连接对象Connection是从连接池中获取的，那么调用Connection.close()方法，则不会再关闭连接了。而是归还连接
        ```
        一般由数据库厂商来实现
        1. C3P0：数据库连接池技术
        2. Druid：数据库连接池实现技术，由阿里巴巴提供的
        ```
## Druid：数据库连接池实现技术，由阿里巴巴提供的
  - 步骤：
    - 导入jar包 druid-1.0.9.jar
  - 定义配置文件：是properties形式的，可以叫任意名称，可以放在任意目录下
  - 加载配置文件druid.Properties
  - 获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
  - 获取连接：
    ```
    示例代码
    Properties pro = new Properties();
    InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
    pro.load(is);
    //获取连接池对象
    DataSource ds = DruidDataSourceFactory.createDataSource(pro);
    //获取连接
    Connection conn = ds.getConnection();
    ```		
## JdbcTemplate
  - Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC的开发
  - 使用步骤
    ```
	   1)导入jar包
	   2)创建JdbcTemplate对象。依赖于数据源DataSource
    　　  JdbcTemplate template = new JdbcTemplate(ds);
	   3)调用JdbcTemplate的方法来完成CRUD的操作
	　　  update():执行DML语句。增、删、改语句
	　　  queryForList():查询结果将结果集封装为list集合
       注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
          query():查询结果，将结果封装为JavaBean对象
       注：query的参数：RowMapper;一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装:new BeanPropertyRowMapper<类型>(类型.class)
	      queryForObject：查询结果，将结果封装为对象。一般用于聚合函数的查询
    ```