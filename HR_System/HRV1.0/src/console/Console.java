package console;

import bean.*;

import java.security.Provider;
import java.util.Scanner;
import  java.util.LinkedList;

public class Console {
    public static void main(String[] args) {
        boolean exit =true;
        ResumeService service =new ResumeService();
        Scanner scanner =new Scanner(System.in);
        while(exit){
            System.out.println("*****lzy招聘系统*********");
            System.out.println("添加求职者信息请输入1");
            System.out.println("删除求职者信息请输入2");
            System.out.println("更新求职者信息请输入3");
            System.out.println("查询求职者信息请输入4");
            int choice = scanner.nextInt();
            if(choice==1){
                service.insert();
            }else if(choice==2){
                service.delete();
            }else if(choice==3){
                service.update();
            }else if(choice==4){
                service.query();
            }else{
                System.out.println("输入错误，请重新输入");
            }
        }
        scanner.close();
    }
}
