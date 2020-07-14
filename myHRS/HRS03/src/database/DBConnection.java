package database;

/**
 * @Author lee
 * @Date 2020/7/13 11:46 PM
 **/

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    /**
     * final
     * 对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，
     * 则在对其初始化之后便不能再让其指向另一个对象。变量的初始化可以在两个地方，一是其定义处，二是在构造函数中，
     * 两者只能选其一。
     * <p>
     * static
     * 对于静态变量在内存中只有一个拷贝（节省内存），JVM只为静态分配一次内存，在加载类的过程中完成静态变量的内存
     * 分配，可用类名直接访问（方便），当然也可以通过对象来访问（但是这是不推荐的）。对于实例变量，每创建一个实例，
     * 就会为实例变量分配一次内存，实例变量可以在内存中有多个拷贝，互不影响（灵活）。
     * <p>
     * static final
     * 两者一起修饰成员变量和成员方法时，可简单理解为“全局常量”！对于变量，表示一旦给值就不可修改，并且通过类名
     * 可以访问，该变量被类的所有实例共享。
     */

    static final String url = "jdbc:mysql://127.0.0.1:3306/myhrs03";
    static final String user = "root";
    static final String password = "~1qaz2wsx";

    static final String name = "com.mysql.cj.jdbc.Driver";

    // This will load the MySQL driver, each DB has its own driver
    static {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception:" + cE.toString());
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(ResultSet rs, Statement statement, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO 重写？重载？ 作用是什么？

    /**
     * 重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
     * 每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。
     * 最常用的地方就是构造器的重载。
     */
    public static void closeConnection(Statement statement, Connection con) {
        closeConnection(null, statement, con);
    }
}
