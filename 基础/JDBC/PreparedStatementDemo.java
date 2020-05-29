import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
             // 根据sql语句创建PreparedStatement
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            // Statement需要进行字符串拼接，可读性和维修性比较差
            String sql0 = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            s.execute(sql0);

            // PreparedStatement 使用参数设置，可读性好，不易犯错
            // "insert into hero values(null,?,?,?)";
            // 设置参数
            ps.setString(1, "提莫");
            ps.setFloat(2, 313.0f);
            ps.setInt(3, 50);
            // 执行
            // PreparedStatement 执行10次，只需要1次把SQL语句传输到数据库端
            // 数据库对带?的SQL进行预编译
            // 每次执行，只需要传输参数到数据库端
            // 1. 网络传输量比Statement更小
            // 2. 数据库不需要再进行编译，响应更快
            for (int i = 0; i < 10; i++) {
                ps.setString(1, "提莫");
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}