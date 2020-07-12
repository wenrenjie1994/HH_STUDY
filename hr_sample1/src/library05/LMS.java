package library05;
import java.sql.*;

public class LMS {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYSQL",
                    "root", "yf195422");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

            // 创建Statement对象
            stmt = conn.createStatement();

            // 执行SQL语句
            rs = stmt.executeQuery("select * from staff");
            System.out.println("name\\id\\school");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                        + "\t" + rs.getInt(3) );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}


//package library05;
//import loadandsaveData.DataOperate;
//import model.People;
//import service.PeopleService;
//import java.util.Scanner;
//import java.util.LinkedList;
//public class LMS {
//
//    public static void main(String[] args)
//    {
//        Scanner input=new Scanner(System.in);
//        LinkedList<People> people=new LinkedList<>();
//        DataOperate.loadData(people);
////        int number;
//        boolean isContinue=true;
//        while(isContinue) {
//            System.out.println("欢迎进入浦发银行招聘系统！");
//            System.out.println("投递简历请按0！");
//            System.out.println("删除已经投递的简历请按1！");
//            System.out.println("修改已经投递的简历请按2！");
//            System.out.println("查询所有简历请按3！");
//            System.out.println("退出系统请按4！");
//            int number=input.nextInt();
//            switch (number) {
//                case 0: {//增
//                    PeopleService.addPeople(people);
//                    break;
//                }
//                case 1: {//删
//                    PeopleService.deletePeople(people);
//                    break;
//                }
//                case 2: {//改
//                    PeopleService.updatePeople(people);
//                    break;
//                }
//                case 3: {//查
//                    PeopleService.showPeople(people);
//                    break;
//                }
//                case 4:{
//                    DataOperate.saveData(people);
//                    isContinue=false;
//                    break;
//                }
//
//                default: {
//                    System.out.println("您的服务请求超出服务范围！");
//                }
//
//
//            }
//        }
//        input.close();
//        System.out.println("您已退出浦发招聘网站！");
//    }
//}
