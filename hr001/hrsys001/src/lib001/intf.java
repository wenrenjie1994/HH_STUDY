package lib001;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: hr001
 * @description: 工具类
 * @author: Victor(LAI Wentao)
 * @create: 2020-07-10 20:57
 */
public class intf  {
    private employee[] employeeList=new employee[];
    ArrayList<employee> eArrayList=new ArrayList<>();
    employeeList employees = new employeeList();

    public   intf() {
        Scanner input = new Scanner(System.in);
        //打印主界面
        while (true) {
            
            System.out.println("**********欢迎来到Victor(LAI Wentao)的HR系统！**********");

            System.out.println("press 1 to add");
            System.out.println("press 2 to delete");
            System.out.println("press 3 to adjust");
            System.out.println("press 4 to find");
            System.out.println("press 5 to exit");

            System.out.println("press 6 to print all messages");
            //判断指令
            int choice = input.nextInt();
            if(choice==1)
            {
                add();
            }
            else if(choice==2)
            {
                delete();
            }
            else if(choice==3)
            {
                break;
            }
            else if(choice==4)
            {
                find();
            }
            else if(choice==5)
            {
                break;
            }
            else {
                System.out.println("输入错误，请确认后从新输入");
            }

        }
        System.out.println("已经退出系统！");
        input.close();
    }


    //增加员工信息
    private void add(){
        System.out.println("欢迎来到增加员工界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入员工姓名，年龄，性别，家乡，是否入职");
        String name =input.nextLine();
        int age = input.nextInt();
        String sex = input.nextLine();
        String home = input.nextLine();
        String entry = input.nextLine();
        employee e = new employee(name,age,sex,home,entry);
        employeeList[]= e;

    }

    //删除员工信息
    private void delete() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("欢迎来到删除员工信息界面");
            System.out.println("按姓名删除请按----------1");
            System.out.println("按家乡删除请按----------2");
            System.out.println("退出请按--------------3");
            int choice = input.nextInt();
            if (choice == 1) {
                deleteByName();
            } else if (choice == 2) {
                deleteByEntry();
            } else if (choice == 3) {
                break;
            }
            input.close();
        }

    }
    void deleteByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的员工姓名");
        String name =input.nextLine();
        employee e =new employee(name,0,null,null,null);

    }
    void deleteByEntry() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的员工家乡情况");
        String home =input.nextLine();
        employee e=new employee(null,0,null,home,null);

    }
    //查询员工
    void find()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的员工名字");
        String name =input.nextLine();
        employee e = new employee(name,0,null,null,null);
        int employeeCount = employeelist.size();
        if(employeeCount>0)
        {
            for(int i=0;i<employeeCount;i++) {
                System.out.println("<<"+elist.get(i).name+">>"+"  "
                        +"作者"+"："+elist.get(i).bookAuthor+"  "
                        +"价格"+"："+elist.get(i).bookPrice+"  ");
            }
        }
        else {
            System.out.println("没有找到姓名为"+name+"的y员工");
        }

    }

    public static void main(String[] args) {
        new intf();
    }

}

