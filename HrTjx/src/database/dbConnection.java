package database;

import java.sql.*;
import java.util.Map;

import student.student;

public class dbConnection {
//'cdb-5buhylba.cd.tencentcdb.com',10056,'root','tangjiaxin19971218','hrSystem'
//String  url ="jdbc:mysql://云服务器ip地址:3306/访问的数据库名称";
    public static final String URL = "jdbc:mysql://cdb-5buhylba.cd.tencentcdb.com:10056/hrSystem?useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "tangjiaxin19971218";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT phoneNumber FROM student");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("phoneNumber"));
        }
        rs.close();
        conn.close();
    }
    public PreparedStatement   connectSelect(String table) throws SQLException {
//        预编译查询整个数据库
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//        占位符不能替代表名
        //        prestmt.setString(1,table);
//        System.out.println(table);
//        System.out.println(prestmt);
        //3.操作数据库，实现增删改查
        return conn.prepareStatement("select * from "+table+";");
    }
    public void connectDelete(String table) throws SQLException {
//        预编译删除整个数据库
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement prestmt = conn.prepareStatement("delete from  "+table+";");
//        prestmt.setString(1,table);
        prestmt.executeUpdate();
        prestmt.close();
    }
    public void connectInsert(String table, String content) throws SQLException {
//        预编译删除整个数据库
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement prestmt = conn.prepareStatement("insert into  "+table+"  values "+content+";");
//        System.out.println(prestmt);
//        prestmt.setString(1,content);
        prestmt.executeUpdate();
        prestmt.close();
    }
    public void close(ResultSet rs, PreparedStatement stmt) throws SQLException {
        rs.close();
        stmt.close();
    }
    public Map<String, student> selectStudent(String table, Map<String, student> studentMap) throws SQLException {
        PreparedStatement stmt=this.connectSelect(table);
        ResultSet rs = stmt.executeQuery();
        //如果有数据，rs.next()返回true
        while(rs.next()){
            student student1=new student(rs.getString("name"),
                    rs.getString("IDcard"),
                    rs.getString("phoneNumber"),
                    rs.getString("gender"),
                    rs.getString("birthday"),
                    rs.getString("age"),
                    rs.getString("job"),
                    rs.getString("salary"),
                    rs.getInt("isDelete")==1);
            studentMap.put(rs.getString("phoneNumber"), student1);

//            System.out.println(rs.getString("phoneNumber"));
        }
        this.close(rs, stmt);
        return studentMap;
    }
    public Map<String, student> selectEvent(String table, Map<String, student> studentMap) throws SQLException {
        PreparedStatement stmt=this.connectSelect(table);
        ResultSet rs = stmt.executeQuery();
        //如果有数据，rs.next()返回true
        while(rs.next()){
            studentMap.get(rs.getString("phoneNumber")).setEvent(
                    rs.getString("isCVPass"),
                    rs.getString("isWriExamination"),
                    rs.getString("isInterview"),
                    rs.getString("isPhyExamination"),
                    rs.getString("isSign")
                    );


//            System.out.println(rs.getString("phoneNumber"));
        }
        this.close(rs, stmt);
        return studentMap;
    }
    public Map<String, student> selectEducation(String table, Map<String, student> studentMap) throws SQLException {
        PreparedStatement stmt=this.connectSelect(table);
        ResultSet rs = stmt.executeQuery();
        //如果有数据，rs.next()返回true
        while(rs.next()){
            studentMap.get(rs.getString("phoneNumber")).setEducation(
                    rs.getString("degree"),
                    rs.getString("school"),
                    rs.getString("startTime"),
                    rs.getString("endTime")
            );


//            System.out.println(rs.getString("phoneNumber"));
        }
        this.close(rs, stmt);
        return studentMap;
    }
}