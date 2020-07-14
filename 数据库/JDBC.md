##1 JDBC-Java DataBase Connection
  - 定义：`java访问数据库`的`标准规范`，一组用Java语言编写的`接口和类`组成
  - 程序与数据库如何沟通？<br>
  　　当应用程序连接数据库要使用JDBC,而JDBC连接数据库得通过数据驱动
  - 数据库驱动和JDBC的关系？<br>
  　　JDBC的驱动就是获取数据库连接的接口的实现类,通过这些实现类就可以操作数据库<br>
  　　JDBC与数据库驱动的关系：接口与实现的关系。
  - JDBC的核心要素-`一类三接口`
    - DriverManager：注册驱动的类
    - Connection：数据库连接类的根接口
    - Statement：数据库语句执行类的根接口
    - ResultSet：数据库查询结果集类的根接口

##2 JDBC原生开发步骤
```
  a、导入相关的jar包。
    1、将jar包导入libs文件夹下
    2、添加的jar包,右键add as Library
  b、注册驱动类->调用DriverMananger的registerDriver方法
    Class.forName("com.mysql.jdbc.Driver")
    //随着类的加载，会执行静态代码块
    //其就会调用DriverManager.registerDriver(/*Driver*/ driver);
  c、获取数据库连接对象
    //String url = "jdbc:mysql://localhost:3306/jdbctest";
    Connection conn = DriverManager.getConnection(url,username,password);
  d、获取sql语句执行对象(PrepareStatement)
    //String sql = "select * from category where pname = ?,price = ?";
    PrepareStatement pst = conn.prepareStatement(sql);
    pst.setObject(1,"%烤%");
    pst.setObject(2, 50);
  e、获取结果集对象【查询语句】
    ResultSet rs = pst.executeQuery();
    【增删改语句：无返回值】
     pst.executeUpdate()
  f、处理结果集【查询语句】
    while(rs.next()){
      Object obj = rs.getObject("pid");
      Object obj2 = rs.getObject("pname");
      System.out.println(obj1+":"+obj2);
    }
  g、关闭资源
      rs.close();
      pst.close();
      conn.close();
  【数据库连接完之后，需要关闭的接口有哪两个？】
      ResultSet和PrepareStatement
```

##3 sql注入
  - 定义：用户输入的内容作为了sql语句的一部分，改变了原有sql的真正意义<br>
  eg:利用了sql语句中字符串用''表示的特性
    ```
    String sql = "select * from user where username='" +username+ "'and password = '" + " 'OR '1'='1 "+"'";
    ```
  - 解决：获取Statement对象时，不使用Statement对象，而是使用Statement的子类prepareStatement，它将传入的参数进行预处理，有效防止了sql注入。

##4 事务
  - 定义：一组要么同时成功，要么同时失败的sql语句，是数据库(并发操作)的一个基本执行单元
    ```
    并行：指两个或多个事件在同一时刻(同时)发生
    并发：值两个或多个事件在同一时间段(交替)发生
    理解：
      并行：一人吃菜，一人吃肉
      并发：一人既吃菜又吃肉
    ```
  - 事务开始： 
    - 连接到数据库上，并执行一条DML语句（Insert/delete/update）。
    - 前一个事务结束后，有输入了另外一条DML语句
  - 事务结束于： 
    - 执行commit()或rollback()语句
    - 断开与数据库连接时
    - 执行的DML语句无效时，会为该无效的语句执行rollback()
  - 事务4个特性：
    - 原子性(Atomicity)：<br>
      一个事务是一个不可分割的整体，事务操作要么都执行要么都不执行，不允许只执行(成功/失败)一部分
    - 一致性(Consistency):<br>
      一个事务在执行前后，数据库的数据应保持一致性。eg：银行转账，两个账户转收前后的金额之和不变
    - 隔离性(Isolation)：<br>
      并发事物间相互不影响，互不干扰;一个事务的执行不应影响其他事务的执行
    - 持久性(Durability)<br>
      事务一旦结束(提交/结束)数据就永久的保存到了数据库。
  - 事务并发产生的问题：
    - 脏读：<br>
      一个事务读取了另一个未提交事务回滚前的数据。
    - 不可重复读：<br>
      一个事务执行过程中多次查询返回不同查询结果。`原因：事务执行过程中，数据被其他事务提交修改(update)了`
    - 幻读：<br>
      一个事务再次查询同样数据发现数据条数变多或变少了。`原因：事务执行过程中，其他事物提交插入(insert)、删(delete)了符合要求的多条数据`
  - 事物的隔离级别：`级别越高，并发性能越差，效率越低，安全性越高`
    - 读未提交(Read uncommitted)：<br>
      可以`读取未提交`数据。`会出现脏、不可重复、幻读` 
    - 读提交(Read committed)：<br>
      事务操作`只能读取已经提交数据`.但不能防止，一个事务的中多次读取某数据库这之间的某时刻，出现其他事物对该数据的修改(提交后)、或增删相同属性的数据。`可以防止脏读，会出现不可重复读、幻读`
    - 可重复读(Repeatable read)：<br>
      `给读取的数据添加锁，防止其他事物修改此数据`。但不能防止其他事物增删具有相同属性的数据。`可以防止脏读、不可重复读`，`会出现幻读`
    - 序列化(Serializable)：
      事务只能一个个执行(串行)，不能并发执行。
    ```
    注：mysql的默认隔离级别：可重复读 ， oracle的默认隔离级别是 读未提交
    ```
  - 为什么要管理事务？如何管理事务？
    - 默认情况下，我们创建的数据库连接，是工作在`自动提交`的模式下的。一旦执行了DDL或DML语句，就会提交一次，相当于`一条语句就是一个事务`。在并发操作下，如果出现了异常，很难保证数据的一致性
    - 因此希望由`一组sql语句组成事务`，在`所有语句都执行完成后统一提交`。要么都执行成功，要么都执行失败。出现问题可以进行回滚。保证一致性
  - 实现：
    - JDBC中我们可以获取Connection连接对象，该对象可以实现事务的提交、回滚
      ```
      a、在sql语句执行前，通过setAutoCommit(false)关闭事务的自动提交，
      b、在所有sql代码执行结束后commit()事务。
      c、并将这段代码try_catch()，出现问题直接rollback()回滚事务
      为保证事务操作中每次都处理的是同一个Connection对象，将Connection与当前线程绑定。每次都操作的是当前线程的Connection对象，使用ThreadLocal
      ```