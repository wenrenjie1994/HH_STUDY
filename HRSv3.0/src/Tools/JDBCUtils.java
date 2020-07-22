package Tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/*
   获取数据库连接的工具类
 */
public class JDBCUtils {
    //创建BasicDataSource对象
    public static BasicDataSource dataSource = new BasicDataSource();
    //静态代码块,实现必要参数设置
    static {
        //这里5.0以后的版本需要加.cj,我使用的是8.0
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //?serverTimezone=UTC这个要加在文件夹后面，utc是世界时间，主要是设置时区，不过应该最好设置成北京时间吧，不写的话就会连不上数据库。
        dataSource.setUrl("jdbc:mysql://localhost:3306/HRSv3?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(2);
        dataSource.setInitialSize(10);
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
