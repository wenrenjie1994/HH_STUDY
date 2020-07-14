**JDBC各个类详解笔记**  

----------


**一、DriverManager（类）：驱动管理对象**  
功能：  
1.注册驱动：告诉程序该使用哪一个数据库驱动jar包  
2.获取数据库连接：  

    static Connection getConnection(String url, String user, String password)  
    url:指定连接的路径   
        jdbc:mysql://ip地址（域名）:端口号/数据库名称  
        如果连接的是本机mysql服务器，并且mysql服务器默认端口号是3306，则url可以简写为jdbc:mysql:///数据库名称  
    user:用户名  
    password:密码  

**二、Connection（接口）：数据库连接对象**  
功能：  
1.获取执行sql的对象  

    Statement createStatement()  
    PreparedStatement prepareStatement(String sql)  

2.管理事务  

    开启事务：void setAutoCommit(boolean autoCommit) 调用该方法设置参数为false即开启事务  
    提交事务：void commit()  
    回滚事务：void rollback()  

**三、Statement（接口）：执行sql的对象**  
功能：执行sql  

    1.boolean	execute(String sql)：可以执行任意的sql（了解）  
    2.int	executeUpdate(String sql)：执行DML语句（INSERT、UPDATE、DELETE）、DDL（CREATE、ALTER、DROP）语句  
      返回值：影响的行数，可以通过影响的行数来判断DML语句是否执行成功，返回值>0则执行成功，否则失败  
    3.ResultSet executeQuery(String sql)：执行DQL（SELECT）语句  

**四、ResultSet：结果集对象**  

**五、PreparedStatement：执行sql的对象，功能比Statement更加强大**  