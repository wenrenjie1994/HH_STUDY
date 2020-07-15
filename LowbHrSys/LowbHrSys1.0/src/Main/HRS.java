package Main;

import bean.Operate;
import bean.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class HRS {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<Person>();
        Scanner input = new Scanner(System.in);
        int doCout=1;
        do{
            System.out.println("---欢迎进入简历管理系统---");
            System.out.println("添加简历请按---1");
            System.out.println("删除简历请按---2");
            System.out.println("查询简历请按---3");
            System.out.println("修改简历请按---4");
            System.out.println("查看所有简历请按---5");
            System.out.println("退出请按-------6");

            int choice = input.nextInt();
            switch(choice){
                //添加简历
                case 1:
                    Operate.addPerson(personList);
                    break;

                //删除简历
                case 2:
                    Operate.deletePerson(personList);
                    break;

                //查询简历
                case 3:
                    Operate.searchPerson(personList);
                    break;

                //修改简历
                case 4:
                    Operate.updatePerson(personList);
                    break;

                //查看所有简历
                case 5:
                    Operate.showPerson(personList);
                    break;

                default:
                    System.out.println("错误！输入格式有误，请重新输入！");

                //退出
                case 6:
                    System.out.println("您已退出简历管理系统~");
                    doCout = 0;

            }

        } while(doCout == 1);
        input.close();
    }
}
