package model;

import java.sql.*;

import jdk.nashorn.internal.objects.annotations.Getter;
import model.JobHunter;

public class HRSDatabase {
    private static final String JDBCDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "314159";

    //建立连接
    private static Connection ConnectDatabase()
    {
        Connection con = null;
        try
        {
            Class.forName(JDBCDRIVER);
            con = DriverManager.getConnection(DBURL,USER,PASSWORD);
        }catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        return con;
    }
    //关闭连接
    private static void close(Connection con)
    {
        if(con != null)
        {
            try
            {
                con.close();
                System.out.println("成功断开数据库连接");
            }catch(SQLException exception)
            {
                exception.printStackTrace();
            }
        }
    }
    private static void close(Statement stat)
    {
        if (stat != null)
        {
            try
            {
                stat.close();
                System.out.println("成功关闭预处理对象");
            }catch (SQLException exception)
            {
                exception.printStackTrace();
            }
        }
    }

    //创建数据库
    public static void CreateDatabase(String nameDatabase)
    {
        try
        {
            Connection con;
            con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("成功数据库连接");
            }
            Statement stat = con.createStatement();//statement类用于执行sql语句
            String sql = "CREATE DATABASE " + nameDatabase +
                    " DEFAULT CHARACTER SET utf8";
            System.out.println("正在创建数据库："+nameDatabase);
            stat.executeUpdate(sql);
            System.out.println("成功创建数据库："+nameDatabase);
            close(con);
            close(stat);
        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }
    //创建表格
    public static void CreateTable(String nameDatabase,String nameTable)
    {
        try
        {
            Connection con;
            con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("成功数据库连接");
            }
            Statement stat = con.createStatement();//statement类用于执行sql语句
            String sql1 = "USE " + nameDatabase;
            String sql2 = "CREATE TABLE " + nameTable +
                    "(name VARCHAR(50)," +
                    "gender VARCHAR(50)," +
                    "age INT(10)," +
                    "degree VARCHAR(50)," +
                    "stage VARCHAR(50))character set utf8";
            System.out.println("正在数据库："+nameDatabase+"中创建表格："+nameTable);
            stat.executeUpdate(sql1);
            stat.executeUpdate(sql2);
            System.out.println("成功在数据库："+nameDatabase+"中创建表格："+nameTable);
            close(con);
            close(stat);
        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }
    //增加数据
    public static void InsertData(String nameDatabase,String nameTable,JobHunter jobHunter)
    {
        try
        {
            Connection con;
            con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("成功数据库连接");
            }
            Statement stat = con.createStatement();
            String sql1 = "USE " + nameDatabase;
            String sql2 = "INSERT INTO " + nameTable + " VALUES (" +
                    "\"" + jobHunter.getName() + "\"," +
                    "\"" + jobHunter.getGender().toString() + "\"," +
                    jobHunter.getAge().toString() +"," +
                    "\"" + jobHunter.getDegree().toString() + "\"," +
                    "\"" + jobHunter.getStage().toString() + "\")";
            System.out.println("正在插入数据");
            stat.executeUpdate(sql1);
            stat.executeUpdate(sql2);
            System.out.println("成功插入数据");
            close(con);
            close(stat);

        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }
    //删除数据
    public static void DeleteData(String nameDatabase,String nameTable,String queryName)
    {
        try
        {
            Connection con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("成功连接数据库");
            }
            Statement stat = con.createStatement();
            String sql1 = "USE " + nameDatabase;
            String sql2 = "DELETE FROM " + nameTable + " WHERE NAME="+
                    "\""+ queryName + "\"";
            System.out.println("正在删除数据");
            stat.executeUpdate(sql1);
            stat.executeUpdate(sql2);
            System.out.println("成功插入数据");
            close(con);
            close(stat);

        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    //查询数据
    public static JobHunter SearchData(String nameDatabase,String nameTable,String queryName)
    {
        JobHunter queryJobHunter = null;
        try
        {
            Connection con;
            con = ConnectDatabase();
            if(!con.isClosed())
            {
                System.out.println("成功连接数据库");
            }
            Statement stat = con.createStatement();
            String sql1 = "USE " + nameDatabase;
            String sql2 = "SELECT * FROM " + nameTable + " WHERE NAME="+
                    "\""+ queryName + "\"";
            System.out.println("正在查询数据");
            stat.executeUpdate(sql1);
            ResultSet results =  stat.executeQuery(sql2);
            System.out.println("成功查询数据");
            if(results != null)
            {
                while(results.next())
                {
                    String name = results.getString("name");
                    String strGender = results.getString("gender");
                    Integer age = results.getInt("age");
                    String strDegree = results.getString("degree");
                    String strStage = results.getString("stage");

                    Gender gender = Gender.valueOf(strGender);
                    Degree degree = Degree.valueOf(strDegree);
                    Stage stage = Stage.valueOf(strStage);

                    queryJobHunter = new JobHunter(name,gender,
                            age,degree,stage);
                }
            }
            close(con);
            close(stat);
        }catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        return queryJobHunter;
    }


}
