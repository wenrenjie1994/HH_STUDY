package system;

import java.util.LinkedList;
import java.util.Scanner;

import loadandsavedata.DataOperate;
import module.Resume;
import service.*;

public class HRS {
    public static void main(String[] args) {
        boolean exit =true;
        LinkedList<Resume> list =new LinkedList<Resume>();
        DataOperate dataOperate =new DataOperate();
        dataOperate.loadData();
        list = dataOperate.getResumeList();
        ResumeService service =new ResumeService();
        service.setResumeList(list);
        Scanner scanner =new Scanner(System.in);
        while(exit){
            System.out.println("*****lzy招聘系统*********");
            System.out.println("添加求职者信息请输入1");
            System.out.println("删除求职者信息请输入2");
            System.out.println("更新求职者信息请输入3");
            System.out.println("查询求职者信息请输入4");
            System.out.println("****退出请输入5***");
            int choice = scanner.nextInt();
            if(choice==1){
                service.insert();
            }else if(choice==2){
                service.delete();
            }else if(choice==3){
                service.update();
            }else if(choice==4){
                service.query();
            }else if (choice==5){
                list=service.getResumeList();
                dataOperate.setResumeList(list);
                dataOperate.saveData();
                break;
            }else{
                System.out.println("输入错误，请重新输入");
            }
        }
        scanner.close();
    }
}
