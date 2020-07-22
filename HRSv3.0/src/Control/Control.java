package Control;

import Domain.Resume;
import Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    接收view层的数据
    传递给service层
 */
public class Control {
    private Service service = new Service();
    /*
        1.增加数据
     */
    public void addResume(){
        System.out.println("---------欢迎进入添加界面---------");
        System.out.println("请输入以下添加内容：");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的id：");
        String id = sc.next();
        //如果isExist返回值是true说明list是空的
        if(service.isExist(id)) {
            System.out.println("请输入学生的姓名：");
            String name = sc.next();
            System.out.println("请输入学生的学校：");
            String school = sc.next();
            System.out.println("请输入学生的邮箱：");
            String email = sc.next();
            //将简历信息添加到arraylist里
            Resume resume = new Resume(id,name,school,email);
            service.addResume(resume);
            System.out.println("-----数据添加成功！-----");
        }else{
            System.out.println("——————————抱歉！简历已存在！——————————");
        }
    }
    /*
        2.修改数据
     */
    public void editResume(){
        System.out.println("---------欢迎进入修改界面---------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生id：");
        String id = sc.next();
        if(service.isExist(id)){
            System.out.println("——————————抱歉！无该简历！——————————");
        }else{
            System.out.println("请重新输入学生姓名：");
            String name = sc.next();
            System.out.println("请重新输入学生学校：");
            String school = sc.next();
            System.out.println("请重新输入学生邮箱：");
            String email = sc.next();
            //将简历信息添加到arraylist里
            Resume resume = new Resume(id,name,school,email);
            service.editResume(resume);
            System.out.println("-----数据修改成功！-----");
        }
    }
    /*
        3.删除数据
     */
    public void deleteResume(){
        System.out.println("---------欢迎进入删除界面---------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生id：");
        String id = sc.next();
        if(service.isExist(id)){
            System.out.println("——————————抱歉！无该简历！——————————");
        }else{
            service.deleteResume(id);
        }
    }
    /*
        4.查询数据
     */
    public void selectResume(){
        System.out.println("---------欢迎进入查询界面---------");
        System.out.println("查询所有请按-----1");
        System.out.println("条件查询请按-----2");
        Scanner sc = new Scanner(System.in);
        int selectChoser = sc.nextInt();
        switch (selectChoser){
            case 1:
                service.selectAll();
                break;
            case 2:
                service.select();
                break;
            default:
                System.out.println("-----你的输入有误，请重新输入！-----");
        }
    }
}
