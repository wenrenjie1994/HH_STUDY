import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo. {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "admin");
                Statement s = c.createStatement();
        )
        {
            String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            // String sql = "delete from hero where id = 5";
            //String sql = "update hero set name = 'name 5' where id = 3";
            s.execute(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}