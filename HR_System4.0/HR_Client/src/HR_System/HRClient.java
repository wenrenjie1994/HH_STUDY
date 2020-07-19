package HR_System;

import service.Operator;

import java.util.Scanner;

public class HRClient {
    public static void main(String[] args) {
        Operator operator =new Operator();
        Scanner scanner =new Scanner(System.in);
        while(true){
            System.out.println("*****lzy招聘系统*********");
            System.out.println("添加求职者信息请输入1");
            System.out.println("删除求职者信息请输入2");
            System.out.println("更新求职者信息请输入3");
            System.out.println("查询求职者信息请输入4");
            System.out.println("****退出请输入5***");
            int choice = scanner.nextInt();
            if(choice==1){
                operator.add();
            }else if(choice==2){
                operator.deleteResume();
            }else if(choice==3){
                operator.updateResume();
            }else if(choice==4){
                operator.searchResume();
            }else if (choice==5){
                break;
            }else{
                System.out.println("输入错误，请重新输入");
            }
        }
        scanner.close();
        System.out.println("您已退出招聘系统");
    }

}
