**JDBC快速入门**  

----------


**一、JDBC概念**  
1.JDBC概念：Java DataBase Connectivity，Java数据库连接，Java语言操作数据库  
2.JDBC本质：其实是官方（sun公司）定义的一套操作所有关系型数据库的规则，即接口；各个数据库厂商去实现这套接口，提供数据库驱动jar包；我们可以使用这套接口编程，真正执行的代码是驱动jar包中的实现类  

**二、JDBC快速入门**  
1.步骤：  
a.导入驱动jar包  
&nbsp;&nbsp;&nbsp;复制jar包到项目的libs目录下  
&nbsp;&nbsp;&nbsp;右键 --> Add As Library   
b.注册驱动  
c.获取数据库的连接对象 Connection  
d.定义sql语句
String sql = "...";
e.获取执行sql语句的对象 Statement  
f.执行sql，接收返回结果  
g.处理结果  
h.释放资源  

**三、代码实现**  

    package dbconnection;  
      
    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.Statement;  
      
    public class Demo01DBConnection{  
        public static void main(String[] args) throws Exception{  
            //1.导入驱动jar包  
            //2.注册驱动  
            Class.forName("com.mysql.jdbc.Driver");  
            //3.获取数据库的连接对象  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");  
            //4.定义sql语句  
            String sql = "update student set math = 90 where id = 7";  
            //5.获取执行sql语句的对象 Statement  
            Statement stmt = conn.createStatement();  
            //6.执行sql，接收返回结果  
            int count = stmt.executeUpdate(sql);  
            //7.处理结果  
            System.out.println(count);  
            //8.释放资源  
            stmt.close();  
            conn.close();  
        }  
    }  
      
