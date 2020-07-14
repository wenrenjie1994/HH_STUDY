**JDBC登录案例练习笔记**（本练习所有代码存于05JDBC登录案例练习文件夹下）  

----------


**一、JDBC练习_SELECT语句**  
Student.java  

    package dbconnection;  
      
    public class Student {  
        private int id;  
        private String name;  
        private int age;  
        private String sex;  
        private String address;  
        private double math;  
        private double english;  
      
        //此处省略成员变量的getter/setter方法  
        //此处省略全参构造方法  
    }  

Demo03DBConnection.java  

    package dbconnection;  
      
    import javax.swing.plaf.nimbus.State;  
    import java.sql.*;  
    import java.util.ArrayList;  
      
    /*  
    查询student表的数据将其封装为对象，然后打印  
     */  
    public class Demo03DBConnection {   
        public static void main(String[] args) {  
            ArrayList<Student> studentArrayList = new ArrayList<>();  
            String url = "jdbc:mysql://localhost:3306/db";  
            String userName = "root";  
            String password = "root";  
            Connection conn = null;  
            Statement stmt = null;  
            ResultSet rs = null;  
            try {  
                Class.forName("com.mysql.jdbc.Driver");  
                String sql = "select * from student";  
                conn = DriverManager.getConnection(url, userName, password);  
                stmt = conn.createStatement();  
                rs = stmt.executeQuery(sql);  
                while (rs.next()) {  
                    studentArrayList.add(new Student(rs.getInt("id"), rs.getString("name"),  
                            rs.getInt("age"), rs.getString("sex"),  
                            rs.getString("address"), rs.getInt("math"),  
                            rs.getInt("english")));  
                }  
                for (int i = 0; i < studentArrayList.size(); i++) {  
                    Student s = studentArrayList.get(i);  
                    System.out.println("id：" + s.getId() + " 姓名：" + s.getName() + " 年龄：" + s.getAge() + " 性别：" +
                        s.getSex() + " 地址：" + s.getAddress() + " 数学：" + s.getMath() + " 英语：" + s.getEnglish());
                }  
            } catch (ClassNotFoundException e) {  
                e.printStackTrace();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            } finally {  
                if (rs != null) {  
                    try {  
                        rs.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }   
                if (stmt != null) {  
                    try {  
                        stmt.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }   
                }  
                if (conn != null) {  
                    try {  
                        conn.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
    }  

**二、JDBC工具类：JDBCUtils**  
1.目的：简化书写  
2.分析：  
a.抽取注册驱动的操作  
b.抽取一个方法获取连接对象  
&nbsp;&nbsp;&nbsp;需求：不想传递参数（麻烦），还得保证工具类的通用性  
&nbsp;&nbsp;&nbsp;解决：配置文件  
c.抽取一个方法来释放资源  

在src下创建dbconnection和util包、创建jdbc.properties文件  

jdbc.properties  

    url=jdbc:mysql://localhost:3306/db  
    userName=root  
    password=root  
    driver=com.mysql.jdbc.Driver  

JDBCUtils.java（在util包中）  

    package util;  
      
    import java.io.FileReader;  
    import java.io.IOException;  
    import java.net.URL;  
    import java.sql.*;  
    import java.util.Properties;  
      
    /*  
    JDBC工具类  
     */  
    public class JDBCUtils {  
        private static String url;  
        private static String userName;  
        private static String password;  
        private static String driver;  
        //文件的读取，只需要读取一次即可拿到这些值--->使用静态代码块  
        static {  
            //读取资源文件，获取值  
          
            try {  
                //1.创建Properties集合类对象  
                Properties pro = new Properties();  
                //获取src路径下的文件的方式--->ClassLoader类加载器  
                ClassLoader classLoader = JDBCUtils.class.getClassLoader();  
                URL res = ClassLoader.getSystemResource("jdbc.properties");  
                String path = res.getPath();  
                //2.加载文件  
                //pro.load(new FileReader("E:\IdeaProjects\basic-code\day0711-code\src\jdbc.properties"));
                pro.load(new FileReader(path));  
                //3.获取属性，赋值  
                url = pro.getProperty("url");  
                userName = pro.getProperty("userName");  
                password = pro.getProperty("password");  
                driver = pro.getProperty("driver");  
                //4.注册驱动  
                Class.forName(driver);  
            } catch (IOException e) {  
                e.printStackTrace();  
            } catch (ClassNotFoundException e) {  
                e.printStackTrace();  
            }  
        }  
        //获取连接：返回连接对象  
        public static Connection getConnection() {  
            try {  
                return DriverManager.getConnection(url, userName, password);  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
            return null;  
        }  
        //释放资源  
        public static void close(Statement stmt, Connection conn) {  
            if(stmt != null) {  
                try {  
                    stmt.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if(conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        public static void close(ResultSet rs, Statement stmt, Connection conn) {  
            if(rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }    
            }  
            if(stmt != null) {  
                try {  
                    stmt.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if(conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  

Demo03DBConnection.java（在dbconnection包中）  

    package dbconnection;  
      
    import util.JDBCUtils;  
    import java.sql.*;  
    import java.util.ArrayList;  
      
    /*  
    查询student表的数据将其封装为对象，然后打印  
     */  
    public class Demo03DBConnection {  
        public static void main(String[] args) {  
            ArrayList<Student> studentArrayList = new ArrayList<>();  
            Connection conn = null;  
            Statement stmt = null;  
            ResultSet rs = null;  
            try {  
                String sql = "select * from student";  
                conn = JDBCUtils.getConnection();  
                stmt = conn.createStatement();  
                rs = stmt.executeQuery(sql);  
                while (rs.next()) {  
                    studentArrayList.add(new Student(rs.getInt("id"), rs.getString("name"),
                            rs.getInt("age"), rs.getString("sex"),
                            rs.getString("address"), rs.getInt("math"),
                            rs.getInt("english")));
                }  
                for (int i = 0; i < studentArrayList.size(); i++) {  
                    Student s = studentArrayList.get(i);  
                    System.out.println("id：" + s.getId() + " 姓名：" + s.getName() + " 年龄：" + s.getAge() + " 性别：" +
                            s.getSex() + " 地址：" + s.getAddress() + " 数学：" + s.getMath() + " 英语：" + s.getEnglish());
                }  
           } catch (SQLException e) {  
                e.printStackTrace();  
            } finally {  
                JDBCUtils.close(rs, stmt, conn);  
            }  
        }  
    }  

三、JDBC登录案例  

User.java  

    package dbconnection;
    
    public class User {
        String username;
        String password;
    
        //此处省略成员变量的getter/setter方法
        //此处省略全参构造方法
    }

Demo04DBConnection.java  

    package dbconnection;
    
    import util.JDBCUtils;
    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.Scanner;
    
    /*
    1.通过键盘录入用户名和密码
    2.判断用户是否登陆成功
    */
    public class Demo04DBConnection {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String username, password;
            System.out.println("请分别输入用户名和密码：");
            username = sc.nextLine();
            password = sc.nextLine();
            if (logIn(new User(username, password))) {
                System.out.println("登陆成功！");
            } else {
                System.out.println("登陆失败！");
            }
            sc.close();
        }
    
        public static boolean logIn(User user) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                String sql = "select * from user where userName = '" + user.username + "' and password = '" + user.password + "'";
                conn = JDBCUtils.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                return re.next();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(rs, stmt, conn);
            }
            return false;
        }
    }