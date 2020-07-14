package lib001;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: hr001
 * @description: 工具类
 * @author: Victor(LAI Wentao)
 * @create: 2020-07-10 20:57
 */
public class intf  {
    ArrayList<employee> eArrayList=new ArrayList<>();//ArrayList泛型数组，不限制数组大小
    private int eNum=0;

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
                update();
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
                System.out.println("输错了兄弟！");
            }

        }
        System.out.println("已经退出系统！");
        input.close();
    }


    //增加员工信息
    private void add(){
        System.out.println("欢迎来到增加员工信息界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入员工姓名，年龄，性别，家乡，是否入职");
        String name =input.nextLine();
        String age = input.nextLine();
        String sex = input.nextLine();
        String home = input.nextLine();
        String entry = input.nextLine();
        employee e = new employee(name,age,sex,home,entry);
        eArrayList.add(e);
        eNum ++;
        System.out.println("添加成功啦！！");
        showList();
    }

//遍历打印信息
    private void showList() {
        for (int i = 0; i < eArrayList.size(); i++) {
            employee s = eArrayList.get(i);
            printEmployee(s);
        }
    }

    //打印信息
    private void printEmployee(employee s){
        System.out.println("姓名："+ s.getName());
        System.out.println("年龄："+ s.getAge());
        System.out.println("性别："+ s.getSex());
        System.out.println("家乡："+ s.getHome());
        System.out.println("是否入职："+ s.getEntry());
    }

    //删除员工信息
    private void delete() {
        int flag = 0;
        System.out.println("欢迎来到删除员工信息界面");
        Scanner input = new Scanner(System.in);
        if(eNum==0){
            System.out.println("木有信息啊，快去添加吧！");
        }
        else{
            System.out.println("请输入要删除的员工的姓名");
            String name = input.nextLine();
        for(int i = 0;i < eArrayList.size();i++){      //基础for循环，s完整写出。
            employee s = eArrayList.get(i);
    if(s.getName().equals(name)){
        eArrayList.remove(s);
        flag = 1;
    }
        }
            if(flag !=1){
        System.out.println("没有找到对应的员工，是不是输错啦！");
    }
        }
    }

    //修改员工信息
    private void update(){
        int flag = 0;
        System.out.println("欢迎来到员工信息修改界面");
        Scanner input = new Scanner(System.in);
        if(eNum==0){
            System.out.println("没有信息改锤子！");
        }
        else {
            System.out.println("输入需要修改的员工的姓名");
            String name = input.nextLine();
            for (employee s : eArrayList) {                //foreach 循环
                if (s.getName().equals(name)) {
                    System.out.println("找到啦！请输入新的姓名，年龄，性别，家庭住址，是否入职");
                    flag = 1;
                }
            }
            if(flag!=1) {
                    System.out.println("没有对应的员工哦！");
                }
        }

    }


    //查询员工
    private void find() {
        int flag = 0;
        System.out.println("欢迎来到员工信息查找界面");
        Scanner input = new Scanner(System.in);
        if(eNum==0){
            System.out.println("空的呀！");
        }
        else{
            System.out.println("输入需要查询的员工的姓名");
            String name = input.nextLine();
            for (int i = 0;i< eArrayList.size();i++){
                employee s = eArrayList.get(i);
                if(s.getName().equals(name)){
                    printEmployee(s);
                    flag =1;
                }
            }
                if(flag!=1){
                    System.out.println("没有这个员工哦！");
                }
        }
    }

    public static void main(String[] args) {
        new intf();
    }

}

