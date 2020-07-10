package Main;

import Bean.Interviewee;
import Bean.IntervieweeList;
import Service.IntervieweeService;
import java.util.Scanner;

public class lowbHrSystem {
    public static IntervieweeService service = new IntervieweeService();
    public lowbHrSystem(){
        int quit = 0;
        Scanner input = new Scanner(System.in);

        while(quit == 0){
            System.out.println("************欢迎来到lowbHR管理系统************");
            System.out.println("增加面试者请按----------1");
            System.out.println("删除面试者请按----------2");
            System.out.println("修改面试者请按----------3");
            System.out.println("查询面试者请按----------4");
            System.out.println("退出请按---------------5");

            int choice = input.nextInt();
            switch (choice){
                case 1:
                    addInterviewee();
                    break;
                case 2:
                    deleteInterviewee();
                    break;
                case 3:
                    modifyInterviewee();
                    break;
                case 4:
                    findIntervieweeee();
                    break;
                case 5:
                    quit = 1;
                    break;
                default:
                    System.out.println("输入错误，请确认后从新输入");
            }
        }
    }

    void addInterviewee(){
        System.out.println("欢迎来到添加面试者界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加面试者姓名，年龄，身份证，毕业学校，面试岗位");
        String name=input.nextLine();
        int age = Integer.parseInt(input.nextLine());
        String ID=input.nextLine();
        String school=input.nextLine();
        String position=input.nextLine();
        Interviewee interviewee=new Interviewee(name,age,school,ID,position);
        int line = service.addInterviewee(interviewee);
        if(line>0){
            System.out.println("添加面试者成功");
        }
        else
        {
            System.out.println("添加面试者失败");
        }
    }

    void deleteInterviewee(){
        while(true)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("************欢迎来到删除面试者界面************");
            System.out.println("按姓名删除请按------------1");
            System.out.println("按身份证删除请按----------2");
            System.out.println("退出请按----------------3");
            int choice =input.nextInt();
            if(choice==1)
            {
                deleteByName();
            }
            else if(choice==2)
            {
                deleteByID();
            }
            else if(choice==3)
            {
                break;
            }
        }

    }

    void deleteByName(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的面试者姓名");
        String name =input.nextLine();
        int line = service.deleteIntervieweeByName(name);
        if(line>0)
        {
            System.out.println("删除面试者成功");
        }
        else
        {
            System.out.println("没有找到该面试者，无法删除");
        }
    }

    void deleteByID(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的面试者身份证号");
        String ID =input.nextLine();
        int line = service.deleteIntervieweeByID(ID);
        if(line>0)
        {
            System.out.println("删除面试者成功");
        }
        else
        {
            System.out.println("没有找到该面试者，无法删除");
        }
    }

    void modifyInterviewee(){
        System.out.println("欢迎来到修改面试者界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要修改的面试者身份证号码");
        String ID = input.nextLine();
        System.out.println("请依次输入需要修改的面试者姓名，年龄，毕业学校，面试岗位");
        String name=input.nextLine();
        int age = Integer.parseInt(input.nextLine());
        String school=input.nextLine();
        String position=input.nextLine();
        Interviewee interviewee=new Interviewee(name,age,school,ID,position);
        int line = service.modifyInterviewee(interviewee);
        if(line>0){
            System.out.println("修改面试者成功");
        }
        else
        {
            System.out.println("修改面试者失败");
        }
    }

    void findIntervieweeee(){
        while(true)
        {
            System.out.println("************欢迎来到查询面试者界面************");
            System.out.println("按面试者姓名查找请按----------1");
            System.out.println("按毕业学校查找请按-----------2");
            System.out.println("按面试岗位查找请按-----------3");
            System.out.println("退出请按-------------------4");
            Scanner input = new Scanner(System.in);
            int choice =input.nextInt();
            if(choice==1)
            {
                findByName();
            }
            else if(choice==2)
            {
                findBySchool();
            }
            else if(choice==3)
            {
                findByPosition();
            }
            else if(choice==4)
            {
                break;
            }
            else{
                System.out.println("输入有误，请检查！");
            }
        }
    }

    void findByName(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的面试者姓名");
        String name =input.nextLine();
        IntervieweeList intervieweeList= service.findIntervieweeByName(name);
        int bookCount = intervieweeList.size();
        if(bookCount>0)
        {
            for(int i=0;i<bookCount;i++) {
                System.out.println("姓名："+intervieweeList.get(i).getName()+"  "
                        +"年龄"+"："+intervieweeList.get(i).getAge()+"  "
                        +"身份证"+"："+intervieweeList.get(i).getID()+"  "
                        +"毕业学校"+"："+intervieweeList.get(i).getSchool()+"  "
                        +"面试岗位"+"："+intervieweeList.get(i).getPosition()+"  ");
            }
        }
        else {
            System.out.println("没有找到姓名为"+name+"的面试者");
        }
    }

    void findBySchool(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的学校名称");
        String school =input.nextLine();
        IntervieweeList intervieweeList= service.findIntervieweeBySchool(school);
        int bookCount = intervieweeList.size();
        if(bookCount>0)
        {
            for(int i=0;i<bookCount;i++) {
                System.out.println("姓名："+intervieweeList.get(i).getName()+"  "
                        +"年龄"+"："+intervieweeList.get(i).getAge()+"  "
                        +"身份证"+"："+intervieweeList.get(i).getID()+"  "
                        +"毕业学校"+"："+intervieweeList.get(i).getSchool()+"  "
                        +"面试岗位"+"："+intervieweeList.get(i).getPosition()+"  ");
            }
        }
        else {
            System.out.println("没有找到来自"+school+"的面试者");
        }
    }

    void findByPosition(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的面试岗位");
        String position =input.nextLine();
        IntervieweeList intervieweeList= service.findIntervieweeByPosition(position);
        int bookCount = intervieweeList.size();
        if(bookCount>0)
        {
            for(int i=0;i<bookCount;i++) {
                System.out.println("姓名："+intervieweeList.get(i).getName()+"  "
                        +"年龄"+"："+intervieweeList.get(i).getAge()+"  "
                        +"身份证"+"："+intervieweeList.get(i).getID()+"  "
                        +"毕业学校"+"："+intervieweeList.get(i).getSchool()+"  "
                        +"面试岗位"+"："+intervieweeList.get(i).getPosition()+"  ");
            }
        }
        else {
            System.out.println("没有找到面试岗位为"+position+"的面试者");
        }
    }

    public static void main(String[] args) {
        new lowbHrSystem();
    }
}
