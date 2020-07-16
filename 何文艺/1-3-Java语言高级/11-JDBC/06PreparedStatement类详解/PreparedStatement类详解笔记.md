**PreparedStatement类详解笔记**  

----------


**PreparedStatement（Statement的子接口）：执行sql的对象**  
1.sql注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接，会造成安全性问题  

    输入任意用户名，输入密码'a' or 'a' = 'a'  
    sql:select * from user where username = "wqvrcqwrv" and password = 'a' or 'a' = 'a'  
    false and false or true = true将会查询出所有的目录  

2.解决方案：使用PreparedStatement对象来解决  
3.预编译的sql：参数使用?作为占位符（Statement执行的是静态的sql：所有的参数在生成sql的时候是拼接好的，静态sql容易产生sql注入问题）  
4.使用PreparedStatement的步骤：（比使用Statement麻烦一点，但更安全）  

    a.导入驱动jar包  
        复制jar包到项目的libs目录下  
        右键 --> Add As Library   
    b.注册驱动  
    c.获取数据库的连接对象 Connection  
    d.定义sql语句：
        sql的参数使用?作为占位符
        String sql = "select * from user where username = ? and password = ?";
    e.获取执行sql语句的对象 PreparedStatement
        Connection.preparedStatement(String sql)
    f.给?赋值：
        setXxx(参数1,参数2)
        参数1：?的位置编号从1开始
        参数2：?的值
    g.执行sql，接收返回结果，不需要传递sql语句  
    h.处理结果  
    i.释放资源  

5.注意：后期都会使用PreparedStatement来完成增删改查的所有操作
&nbsp;&nbsp;&nbsp;a.可以防止sql注入
&nbsp;&nbsp;&nbsp;b.效率更高