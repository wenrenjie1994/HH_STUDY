package demo.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: TODO
 * @className:Demo01
 * @description:c3p0的演示
 * @author: 何文艺
 * @create: 2020/7/15 16:15
 **/
public class Demo01 {
    public static void main(String[] args) {
        //1.创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //2.获取连接对象
        try {
            for (int i = 0; i < 11; i++) {
                Connection conn = ds.getConnection();
                System.out.println(i + ":" + conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
