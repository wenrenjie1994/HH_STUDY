**DBC之CRUD练习笔记**  

----------


之前写的代码存在不规范的地方：  
1.不管程序执行成功还是失败都应该释放资源，不然就会存在内存泄露（内存因为程序中的垃圾没被释放而越来越小）的问题  
因此释放资源的操作应该写在final里，且应该处理异常而不是抛出异常  
2.先释放Statement，因为Statement是由Connection获取的  
3.若直接stmt.close()则很可能出现空指针异常  
因为若Connection conn = DriverManager.getConnection(...)语句出错，则直接跳到try语句里面处理异常，这个时候stmt还为null  
因此在释放之前应该先判断stmt是否为空，避免出现空指针异常  
      
    import java.sql.*;
    
    public class Demo02DBConnection {
        public static void main(String[] args){
            Statement stmt = null;
            Connection conn = null;
            try {
                //1.注册驱动
                Class.forName("com.mysql.jdbc.Driver");
                //2.定义sql
                String sql = "insert into student values(9, 'lili', 18, '女', '上海', 80, 99)";
                //3.获取数据库的连接对象
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
                //4.获取执行sql的对象
                stmt = conn.createStatement();
                //5.执行sql
                int count = stmt.executeUpdate(sql);
                //6.处理结果
                System.out.println(count);
                if(count > 0) {
                    System.out.println("成功！");
                } else {
                    System.out.println("失败！");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //7.释放资源
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
    }

一、INSERT语句  

    String sql = "insert into student values(9, 'lili', 18, '女', '上海', 80, 99)";

二、UPDATE语句  

    String sql = "update student set math = 90 where id = 5";

三、DELETE语句  

    String sql = "delete from student where id = 3";

四、DDL语句  

    String sql = "create table person(id int, name varchar(20))";