package operate;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;

public class ResumeOperate {

	// 展示所有简历
    public static void showResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		String sql = "select * from resume";
    		ResultSet rs = s.executeQuery(sql);
    		System.out.println("姓名"+'\t'+"身份证号"+'\t'+"学历"+'\t'+"电话号"+'\t'+"简历状态");
    		while (rs.next()) {
    			String name = rs.getString(1);
                String id = rs.getString("id");
                String eduction = rs.getString(3);
                String telephone = rs.getString(4);
                int process = rs.getInt(5);
                System.out.printf("%s\t%s\t%s\t%s\t%d%n", name, id, eduction, telephone, process);
            }
    		DBConnection.closeConnection(rs, s, c);
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    }
    
    //查看指定简历状态的简历
    public static void showAppointResume() {
    	try {
    		ArrayList<Integer> datas = new ArrayList<>();
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		
    		Scanner sc=new Scanner(System.in);
        	boolean keepon=false;
        	ResultSet rs;
        	do {
        		System.out.println("*****请输入要查询的简历状态*****");
            	System.out.println("-1：加入人才库");
            	System.out.println("0：已申请");
            	System.out.println("1：简历通过");
            	System.out.println("2：笔试通过");
            	System.out.println("3：面试通过");
            	System.out.println("4：体检通过");
            	System.out.println("5：背调通过");
            	System.out.println("6：已签约");
            	System.out.println("7：已入职");
            	int k = sc.nextInt();
            	sc.nextLine();
            	boolean notexist=true;
            	String sql = "select * from resume";
        		rs = s.executeQuery(sql);
            	while (rs.next()) {
            		String name = rs.getString(1);
                    String id = rs.getString("id");
                    String eduction = rs.getString(3);
                    String telephone = rs.getString(4);
                    int process = rs.getInt(5);
                    if(k == process) {
            			notexist=false;
            			System.out.println("姓名"+'\t'+"身份证号"+'\t'+"学历"+'\t'+"电话号"+'\t'+"简历状态");
            			System.out.printf("%s\t%s\t%s\t%s\t%d%n", name, id, eduction, telephone, process);
            		}
                }
            	if(notexist)
            		System.out.println("不存在该状态的简历");
            	System.out.println("*****是否继续查询（是/否）*****");
                if(sc.nextLine().equals("是"))
                	keepon=true;
                else
                	keepon=false;
        	}while(keepon);
        	DBConnection.closeConnection(rs, s, c);
    	} catch(SQLException e){
    		 e.printStackTrace();
    	}
    	
    }
	
	// 添加指定简历
    public static void addResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		Scanner sc = new Scanner(System.in);
            boolean keepon=false;
            do {
            	System.out.println("*****请依次输入姓名、身份证号、学历、电话号、简历状态（以行隔开）*****");
                String name = sc.nextLine();
                String id = sc.nextLine();
                String education = sc.nextLine();
                String telephone = sc.nextLine();
                int process = sc.nextInt();
                sc.nextLine();
                String sql="insert into resume values('"+name+"','"+id+"','"+education+"','"+telephone+"',"+process+")";
                s.execute(sql);
                
                System.out.println("*****是否继续添加（是/否）*****");
                if(sc.nextLine().equals("是"))
                	keepon=true;
                else
                	keepon=false;
            }while(keepon);
            DBConnection.closeConnection(s, c);
    	} catch(SQLException e){
   		 e.printStackTrace();
    	}
        System.out.println("添加成功");
    }

    //删除指定简历
    public static void deleteResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		Scanner sc = new Scanner(System.in);
            boolean keepon=false;
            do {
            	System.out.println("*****请输入要删除的简历对应的身份证号*****");
                String id = sc.nextLine();
                int count;
                String sql = "delete from resume where id = '" + id +"'";
                count = s.executeUpdate(sql);
                if(count == 0)
                	System.out.println("没有找到您想要删除的简历");
                
                System.out.println("*****是否继续删除（是/否）*****");
                if(sc.nextLine().equals("是"))
                	keepon=true;
                else
                	keepon=false;
            }while(keepon);
            DBConnection.closeConnection(s, c);
    	} catch(SQLException e){
      		 e.printStackTrace();
       	}
        System.out.println("操作完毕");
    }

    //修改指定简历
    public static void updateResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		ResultSet rs;
    		Scanner sc = new Scanner(System.in);
            boolean keepon=false;
            do {
            	System.out.println("*****请输入要修改的简历对应的身份证号*****");
                String id = sc.nextLine();
                String sql = "select * from resume where id = '" + id +"'";
                rs = s.executeQuery(sql);
                System.out.println("*****已找到要修改的简历*****");
        		System.out.println("****简历原始状态****");
        		System.out.println("姓名"+'\t'+"身份证号"+'\t'+"学历"+'\t'+"电话号"+'\t'+"简历状态");
        		rs.next();
        		System.out.printf("%s\t%s\t%s\t%s\t%d%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            	boolean iscompleted=false;
            	do {
            		System.out.println("*************************");
                	System.out.println("修改姓名——1");
                	System.out.println("修改身份证号——2");
                	System.out.println("修改学历——3");
                	System.out.println("修改电话号——4");
                	System.out.println("修改简历状态——5");
                	int choice=sc.nextInt();
                	sc.nextLine();
                	switch(choice) {
                	case 1:
                		{System.out.println("请输入新的姓名");
                		String sql1 = "update resume set name = '" + sc.nextLine() + "' where id = '" + id +"'";
                		s.executeUpdate(sql1);}
                        break;
                    case 2:
                    	{System.out.println("请输入新的身份证号");
                    	String sql2 = "update resume set id = '" + sc.nextLine() + "' where id = '" + id +"'";
                		s.executeUpdate(sql2);}
                        break;
                    case 3:
                    	{System.out.println("请输入新的学历");
                    	String sql3 = "update resume set education = '" + sc.nextLine() + "' where id = '" + id +"'";
                		s.executeUpdate(sql3);}
                        break;
                    case 4:
                    	{System.out.println("请输入新的电话号码");
                    	String sql4 = "update resume set telephone = '" + sc.nextLine() + "' where id = '" + id +"'";
                		s.executeUpdate(sql4);}
                        break;
                    case 5:
                    	{System.out.println("请输入新的简历状态");
                    	String sql5 = "update resume set process = " + sc.nextInt() + " where id = '" + id +"'";
                		s.executeUpdate(sql5);
                    	sc.nextLine();}
                        break;
                    default:
                        System.out.println("输入有误，请重新输入");
                	}
                	
                	System.out.println("*****是否继续修改本简历（是/否）*****");
                    if(sc.nextLine().equals("是"))
                    	iscompleted=true;
                    else
                    	iscompleted=false;
            	}while(iscompleted);
                System.out.println("修改成功");
                
                System.out.println("*****是否继续修改下一个简历（是/否）*****");
                if(sc.nextLine().equals("是"))
                	keepon=true;
                else
                	keepon=false;
            }while(keepon);
            DBConnection.closeConnection(rs, s, c);
    	} catch(SQLException e){
     		 e.printStackTrace();
      	}
        System.out.println("操作完毕");
    }

    // 查询指定简历
    public static void searchResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		ResultSet rs;
    		Scanner sc = new Scanner(System.in);
            boolean keepon=false;
            do {
            	System.out.println("*****请输入要查询的简历对应的身份证号*****");
                String id = sc.nextLine();
                String sql = "select * from resume where id = '" + id + "'";
                rs = s.executeQuery(sql);
                rs = s.executeQuery(sql);
            	System.out.println("找到您所查询的简历");
            	System.out.println("姓名"+'\t'+"身份证号"+'\t'+"学历"+'\t'+"电话号"+'\t'+"简历状态");
        		rs.next();
        		System.out.printf("%s\t%s\t%s\t%s\t%d%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                
                System.out.println("*****是否继续查询（是/否）*****");
                if(sc.nextLine().equals("是"))
                	keepon=true;
                else
                	keepon=false;
            }while(keepon);
    	} catch(SQLException e){
    		 e.printStackTrace();
     	}
        System.out.println("查询完毕");
    }

}
