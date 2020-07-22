package sys;

import pojo.Resume;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * User: Alex FAN
 * Date: 2020/7/21
 * Time: 23:14
 * Description:
 */
public class HRS {

    InitResumeList initResumeList = new InitResumeList();
    ArrayList<Resume>list = initResumeList.initResume();
    /*System.out.println(list.size());*/

    private Scanner input=new Scanner(System.in);

    HRS() {


        while (true) {

            System.out.println("-----欢迎进入HR_ver1.0系统-----");
            System.out.println("查看申请中的简历请按------1");
            System.out.println("看简历通过的简历请按------2");
            System.out.println("看笔试通过的简历请按------3");
            System.out.println("看面试通过的简历请按------4");
            System.out.println("查看已签约的简历请按------5");
            System.out.println("退出请按--------6");

            int choice = input.nextInt();

            if (choice == 1) {
                select0();
            } else if (choice == 2) {
                select1();
            } else if (choice == 3) {
                select2();
            } else if (choice == 4) {
                select3();
            } else if (choice == 5) {
                select4();
            } else if (choice == 6) {
                System.out.println("您已经退出HR_ver1.0系统");
                input.close();
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }


        }

    }

    void select0(){

        for (int i = 0; i < list.size() ; i++) {
            int flag = 0;
            if(list.get(i).getFlag() == 0){
                System.out.println(list.get(i).getName());
                System.out.println(list.get(i).getSchool());
                System.out.println(list.get(i).getId());
                flag = 1;
                break;
            }
            if(flag == 0) {
                System.out.println("sorry no Resume");
            }
        }

    }

    void select1(){
        int flag = 0;
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).getFlag() == 1){
                System.out.println(list.get(i).getName());
                System.out.println(list.get(i).getSchool());
                System.out.println(list.get(i).getId());
                flag = 1;
                break;
            }
            if(flag == 0) {
                System.out.println("sorry no Resume");
            }
        }

    }

    void select2(){
        int flag = 0;
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).getFlag() == 2){
                System.out.println(list.get(i).getName());
                System.out.println(list.get(i).getSchool());
                System.out.println(list.get(i).getId());
                flag = 1;
                break;
            }
            if(flag == 0) {
                System.out.println("sorry no Resume");
            }
        }

    }

    void select3(){
        int flag = 0;
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).getFlag() == 3){
                System.out.println(list.get(i).getName());
                System.out.println(list.get(i).getSchool());
                System.out.println(list.get(i).getId());
                flag = 1;
                break;
            }
            if(flag == 0) {
                System.out.println("sorry no Resume");
            }
        }

    }

    void select4(){
        int flag = 0;
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).getFlag() == 4){
                System.out.println(list.get(i).getName());
                System.out.println(list.get(i).getSchool());
                System.out.println(list.get(i).getId());
                flag = 1;
                break;
            }
            if(flag == 0) {
                System.out.println("sorry no Resume");
            }
        }

    }

    void select5(){
        int flag = 0;
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).getFlag() == 5){
                System.out.println(list.get(i).getName());
                System.out.println(list.get(i).getSchool());
                System.out.println(list.get(i).getId());
                flag = 1;
                break;
            }
            if(flag == 0) {
                System.out.println("sorry no Resume");
            }
        }

    }
    public static void main(String[] args) {
       new HRS();

    }

}
