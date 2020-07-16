package lib002;

import java.util.LinkedList;
import java.util.Scanner;

import static lib002.Data.saveData;
import static lib002.Data.loadData;

/**
 * @program: hr002
 * @description: 主
 * @author: Victor(LAI Wentao)
 * @create: 2020-07-16 13:01
 */
public class intf {
   public intf(){
       LinkedList<employee> elinkedList = new LinkedList<>();//   采用linkedlist链表进行,hr001采用的arraylist
       Scanner input = new Scanner(System.in);
       loadData(elinkedList);

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
               add(elinkedList);
           }
           else if(choice==2)
           {
               delete(elinkedList);
           }
           else if(choice==3)
           {
               update(elinkedList);
           }
           else if(choice==4)
           {
               find(elinkedList);
           }
           else if(choice==5)
           {
               saveData(elinkedList);  //存储后break退出系统
               break;
           }
           else {
               System.out.println("输错了兄弟！");
           }

       }
       System.out.println("已经退出系统！");
       input.close();
   }



    private void add(LinkedList<employee> elinkedList) {
        System.out.println("欢迎来到增加员工信息界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入员工姓名，年龄，性别，家乡，是否入职");
        String name =input.nextLine();
        String age = input.nextLine();
        String sex = input.nextLine();
        String home = input.nextLine();
        String entry = input.nextLine();
        employee e = new employee(name,age,sex,home,entry);
        elinkedList.add(e);
        System.out.println("添加成功啦！！");
        showList(elinkedList);
    }

    private void showList(LinkedList<employee> elinkedList) {  //和HR001一样
        for (int i = 0; i < elinkedList.size(); i++) {
            employee s = elinkedList.get(i);
            printEmployee(s);
        }
    }

    private void printEmployee(employee s) {
        System.out.println("姓名："+ s.getName());
        System.out.println("年龄："+ s.getAge());
        System.out.println("性别："+ s.getSex());
        System.out.println("家乡："+ s.getHome());
        System.out.println("是否入职："+ s.getEntry());
    }

    private void delete(LinkedList<employee> elinkedList) { /*hr采用int eNum进行判断信息是否为空（因为是内存，所以无关紧要）
       ，这里用elinkedList.size()
       */
        int flag = 0;
        System.out.println("欢迎来到员工信息修改界面");
        Scanner input = new Scanner(System.in);
        if(elinkedList.size()==0){
            System.out.println("没有信息改锤子！");
        }
        else {
            System.out.println("输入需要修改的员工的姓名");
            String name = input.nextLine();
            for (employee s : elinkedList) {                //foreach 循环
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

    private void update(LinkedList<employee> elinkedList) {
        int flag = 0;
        System.out.println("欢迎来到员工信息修改界面");
        Scanner input = new Scanner(System.in);
        if(elinkedList.size()==0){
            System.out.println("没有信息改锤子！");
        }
        else {
            System.out.println("输入需要修改的员工的姓名");
            String name = input.nextLine();
            for (employee s : elinkedList) {                //foreach 循环
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

    private void find(LinkedList<employee> elinkedList) {
        int flag = 0;
        System.out.println("欢迎来到员工信息查找界面");
        Scanner input = new Scanner(System.in);
        if(elinkedList.size()==0){
            System.out.println("空的呀！");
        }
        else{
            System.out.println("输入需要查询的员工的姓名");
            String name = input.nextLine();
            for (int i = 0;i< elinkedList.size();i++){
                employee s = elinkedList.get(i);
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
