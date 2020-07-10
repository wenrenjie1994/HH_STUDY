package DataBase.Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/10 22:43
 */

public class DBUtil {
    private static Connection con = null;
    private static Statement smt = null;
    private static ResultSet rs = null;
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
        static {
            ResourceBundle bundle = ResourceBundle.getBundle("db_setting");
            driver = bundle.getString("driver");
            url = bundle.getString("url");
            username = bundle.getString("username");
            password = bundle.getString("password");
        }

    private static Connection createConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("Can't load Driver");
        }
        return null;
    }

    public static int runUpdate(String sql) throws SQLException {
        int count = 0;
        if (con == null) {
            con = createConnection();
        }
        if (smt == null) {
            smt = con.createStatement();
        }

        count = smt.executeUpdate(sql);

        if (smt != null) {
            smt.close();
            smt = null;
        }
        if (con != null) {
            con.close();
            con = null;
        }
        return count;
    }


    public static ResultSet runQuery(String sql) throws SQLException {
        if (con == null) {
            con = createConnection();
        }
        if (smt == null) {
            smt = con.createStatement();
        }
        return smt.executeQuery(sql);
    }

    public static void releaseAll() {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (smt != null) {
            try {
                smt.close();
                smt = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException ex) {
                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void closeConnection(Connection conn) {
        System.out.println("...");
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
