/**
 * projectName: HRS3.0
 * fileName: DBConnection.java
 * packageName: util
 * date: 2020-07-14 23:02
 * copyright(c) tianyifan
 */
package database;

import com.alibaba.druid.pool.DruidDataSource;//引入站点的配置信息
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @version: V3.0
 * @author: tianyifan
 * @className: DBConnection
 * @packageName: util
 * @description: 数据库连接类
 * @date: 2020-07-14 23:02
 **/
public class DBConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";//JDBC驱动（本机数据库版本8.0）
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hrs?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";//数据库URL
    private static final String USERNAME = "root";//数据库用户名
    private static final String PASSWORD = "1234598760muhan";//数据库密码

    private static DruidDataSource DataSource=null;

    /**
     *@title: DBConnection
     *@description: 构造函数，完成数据库连接和连接对象的生成
     *@author: tianyifan
     *@date: 2020-07-15 12:01
     *@param: 无
     *@return: 无
     *@throws: 无
     */
    public DBConnection(){
    }

    /**
     *@title: createDBConnection
     *@description: 生成数据库连接并完成连接配置
     *@author: tianyifan
     *@date: 2020-07-15 11:58
     *@param:  无
     *@return: 无
     *@throws: 无
     */
    public void createDBConnection(){
        if(DataSource == null){
            DataSource = new DruidDataSource();//创建连接
            //设置连接参数
            DataSource.setUrl(DB_URL);
            DataSource.setDriverClassName(JDBC_DRIVER);
            DataSource.setUsername(USERNAME);
            DataSource.setPassword(PASSWORD);
            //设置初始化的大小及最小和最大
            DataSource.setInitialSize(1);
            DataSource.setMinIdle(1);
            DataSource.setMaxActive(20);
            //配置连接泄漏监测
            DataSource.setRemoveAbandoned(true);
            DataSource.setRemoveAbandonedTimeout(180);
            //设置获取连接等待超时时间
            DataSource.setMaxWait(20000);
            //设置检测间隔时间（检测并关闭空闲连接，毫秒）
            DataSource.setTimeBetweenEvictionRunsMillis(20000);
            //配置连接有效性检测，防止过期
            DataSource.setValidationQuery("select 'a'");
            DataSource.setTestWhileIdle(true);
            DataSource.setTestOnBorrow(true);
        }
    }

    /**
     *@title: getDBConnection
     *@description: 获取数据库连接
     *@author: tianyifan
     *@date: 2020-07-15 12:17
     *@param: 无
     *@return: java.sql.Connection
     *@throws: 无
     */
    public Connection getDBConnection() throws SQLException {
        Connection connection = null;
        createDBConnection();//生成数据库连接
        DruidPooledConnection druidPooledConnection = DataSource.getConnection();//获取连接
        return druidPooledConnection;
    }

    /**
     *@title: closeDataSource
     *@description: 关闭数据库连接池
     *@author: tianyifan
     *@date: 2020-07-16 11:03
     *@param: 无
     *@return: void
     *@throws: 无
     */
    public void closeDataSource(){
        DataSource.close();
    }

    /*public static void main(String[] args) throws SQLException {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getDBConnection();
        String sql = "select * from employee";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getInt(4));
        }
    }*/

}
