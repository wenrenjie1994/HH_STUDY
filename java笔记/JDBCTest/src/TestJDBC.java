import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            //System.out.println("数据库驱动加载成功！");
//            // 建立与数据库的Connection连接
//            // 这里需要提供：
//            // 数据库所处于的ip:127.0.0.1 (本机)
//            // 数据库的端口号： 3306 （mysql专用端口号）
//            // 数据库名称 test
//            // 编码方式 UTF-8
//            // 账号 root
//            // 密码 19941226
//
//            //建立与数据库的连接
//            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8",
//                    "root", "19941226");
//           // System.out.println("连接成功，获取链接对象：" + connection);
//
//            //创建Statement，其是执行SQL语句的，比如增加和删除
//            Statement statement = connection.createStatement();
//            //System.out.println("获取Statement对象：" + statement);
//
//            //准备SQL语句
//            String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
//            statement.execute(sql);
//            System.out.println("执行插入语句成功");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //这种写法会自动关闭流
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8",
//                "root", "19941226");
//             Statement statement = connection.createStatement();
//        ) {
//        增加
//        String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
//        删除
//        String sql = "delete from hero where id = 2";
//        修改
//        String sql = "update hero set name = 'mf' where id = 3";
//        s.execute(sql);
//        System.out.println("执行插入成功！");

//        执行查询操作
//            String sql = "select * from hero";
//            // 执行查询语句，并把结果集返回给ResultSet
//            ResultSet resultSet = statement.executeQuery(sql);
//            while(resultSet.next()){
//                int id =  resultSet.getInt("id");// 可以使用字段名
//                String name = resultSet.getString(2);// 也可以使用字段的顺序
//                float hp = resultSet.getFloat("hp");
//                int damage = resultSet.getInt(4);
//                System.out.printf("%d\t%s\t%f\t%%n", id, name, hp, damage);
//        获取总数
//            String sql = "select count(*) from hero";
//            ResultSet resultSet = statement.executeQuery(sql);
//            int total = 0;
//            while (resultSet.next()) {
//                total = resultSet.getInt(1);
//            }
//            System.out.println("表Hero中总共有：" + total + " 条数据");
//
//        使用查询语句判断账号密码是否正确
//            String name = "dashen";
//        正确的密码是：thisispassword
//            String password = "thisispassword1";
//
//            String sql = "select * from user where name = '" + name + "' and password = '" + password + "'";
//            ResultSet resultSet = statement.executeQuery(sql);
//            if (resultSet.next()) {
//                System.out.println("账号密码正确");
//            } else {
//                System.out.println("账号密码错误");
//            }
//            String sqlInsert = "insert into Hero values (null,'盖伦',616,100)";
//            String sqlDelete = "delete from Hero where id = 100";
//            String sqlUpdate = "update Hero set hp = 300 where id = 100";

        //execute和executeUpdate
        // 相同点：都可以执行增加，删除，修改
//            不同1：
//            execute可以执行查询语句
//            然后通过getResultSet，把结果集取出来
//                    executeUpdate不能执行查询语句
//            不同2:
//            execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
//            executeUpdate返回的是int，表示有多少条数据受到了影响

//            statement.execute(sqlInsert);
//            statement.execute(sqlDelete);
//            statement.execute(sqlUpdate);
//            statement.executeUpdate(sqlInsert);
//            statement.executeUpdate(sqlDelete);
//            statement.executeUpdate(sqlUpdate);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        使用预编译PreparedStatement
//        参数设置，可读性好，不易犯错
//        预编译机制，性能比Statement快
//        防止SQL注入式攻击
//        String sql = "insert into hero values(null,?,?,?)";
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8",
//                "root", "19941226");
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            //设置参数
//            preparedStatement.setString(1,"日女");
//            preparedStatement.setFloat(2,313.0f);
//            preparedStatement.setInt(3,50);
//            preparedStatement.execute();
//
//            //获取id
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if(resultSet.next()){
//                int id = resultSet.getInt(1);
//                System.out.println(id);
//            }
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }


        //使用事务
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8",
//                "root", "19941226");
//             Statement statement = connection.createStatement();
//        ) {
//            //有事务的前提下
//            //在事务中的多个操作，要么都成功，要么都失败
//            connection.setAutoCommit(false);
//
//            //加血的SQL
//            String sql1 = "update hero set hp=hp+1 where id=8";
//            statement.execute(sql1);
//            //减血的SQL(故意写错)
//            String sql2 = "updata hero set hp=hp-1 where id=8";
//            statement.execute(sql2);
//
//            connection.commit();

//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
        Hero hero = get(8);
        System.out.println(hero.name);
    }

    //ORM=Object Relationship Database Mapping
    //对象和关系数据库的映射
    //一个对象对应数据库中的一条记录
    public static Hero get ( int id) {
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8",
                "root", "19941226");
             Statement statement = connection.createStatement();
        ) {
            String sql = "select * from hero where id =" + id;
            ResultSet resultSet = statement.executeQuery(sql);
            //因为id是唯一的，所以这里使用if
            if (resultSet.next()) {
                hero = new Hero();
                String name = resultSet.getString(2);
                float hp = resultSet.getFloat("hp");
                int damage = resultSet.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }
}
