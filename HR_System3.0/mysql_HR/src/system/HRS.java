package system;

import service.Service;

import java.util.LinkedList;
import java.util.Scanner;

public class HRS {
    public static void main(String[] args) {
        Service service =new Service();
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
                service.addResume();
            }else if(choice==2){
                service.deleteResume();
            }else if(choice==3){
                service.update();
            }else if(choice==4){
                service.searchResume();
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
