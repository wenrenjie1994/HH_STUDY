import java.sql.*;
import java.util.Scanner;

public class OperateMySQL {
    public static final String usr = "root";
    public static final String password = "314159";
    public static final String url = "jdbc:mysql://localhost:3306/testdatabase";
    public static final String jdbcDriver = "com.mysql.jdbc.Driver";

    //建立连接
    public static Connection ConnectDatabase()
    {
        Connection con = null;
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(url, usr, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    //关闭连接
    public static void close(Connection con)
    {
        if (con != null)
        {
            try
            {
                con.close();
            }catch (SQLException exception)
            {
                exception.printStackTrace();
            }
        }
    }
    public static void close(Statement sta)
    {
        if (sta != null)
        {
            try
            {
                sta.close();
                System.out.println("断开连接.");
            }catch (SQLException exception)
            {
                exception.printStackTrace();
            }
        }
    }
    //创建数据库
    public static void CreateDatabase(String nameDatabase,String nameTable)
    {
        try
        {
            Connection con;
            con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("数据库连接成功");
            }
            Statement stat = con.createStatement();//statement类用于执行sql语句
            String sql1 = "CREATE DATABASE " + nameDatabase +
                    " DEFAULT CHARACTER SET utf8";
            String sql2 = "USE " + nameDatabase;
            String sql3 = "CREATE TABLE " + nameTable +
                    "(name varchar(10)," +
                    "age int(4))character set utf8";
            stat.executeUpdate(sql1);
            stat.executeUpdate(sql2);
            stat.executeUpdate(sql3);
            close(con);
            close(stat);
        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }
    //增加数据
    public static void InsertData()
    {
        try
        {
            Connection con;
            con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("数据库连接成功！");
            }
            Statement stat = con.createStatement();
            String sql1 = "USE HRSDATABASE";
            String sql2 = "INSERT INTO JOBHUNTER VALUES (\"汪泽睿\",25)";
            stat.executeUpdate(sql1);
            stat.executeUpdate(sql2);
            close(con);
            close(stat);
        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }

    }
    //查询数据
    public static void  SearchData(String queryName)
    {
        try
        {
            Connection con;
            con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("连接数据库成功！");
            }
            Statement stat = con.createStatement();
            String sql1 = "USE HRSDATABASE";
            String sql2 = "SELECT * FROM JOBHUNTER WHERE NAME="+queryName;
            stat.executeUpdate(sql1);
            ResultSet results =  stat.executeQuery(sql2);
            while(results.next())
            {
                String name = results.getString("name");
                Integer age = results.getInt("age");

                System.out.println("name: "+name);
                System.out.println("age: "+age);
                System.out.println("\n");
            }
            close(con);
            close(stat);
        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }

    }

    //删除数据
    public static void DeleteData(String queryName)
    {
        try
        {
            Connection con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("连接数据库成功");
            }
            Statement stat = con.createStatement();
            String sql1 = "USE HRSDATABASE";
            String sql2 = "DELETE FROM JOBHUNTER WHERE NAME="+queryName;
            stat.executeUpdate(sql1);
            stat.executeUpdate(sql2);
            close(con);
            close(stat);
        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    //修改数据
    public static void UpdateData(String queryName,Integer updatedAge)
    {
        try
        {
            Connection con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("连接数据库成功");
            }
            Statement stat = con.createStatement();
            String sql1 = "USE HRSDATABASE";
            String sql2 = "UPDATe JOBHUNTER SET AGE="+updatedAge.toString()+" WHERE NAME="+queryName;
            System.out.println(sql2);
            stat.executeUpdate(sql1);
            stat.executeUpdate(sql2);
            close(con);
            close(stat);
        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据库名：");
        String nameDatabase = scanner.next();
        System.out.println("请输入表名：");
        String nameTable = scanner.next();
        CreateDatabase(nameDatabase,nameTable);
        InsertData();
        */
        //SearchData("\"a\"");
        //DeleteData("\"i\"");
        UpdateData("\"b\"",999);
    }
}
