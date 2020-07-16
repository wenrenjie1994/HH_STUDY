package helloworld.lowbHrSystem1;

import java.util.ArrayList;
import java.util.Scanner;

public class HRS {
    Person[] personlist = new Person[100];
    ArrayList<Person> personArrayList = new ArrayList<>();
    PersonList persons = new PersonList();
    Scanner input = new Scanner(System.in);
    int personCount = 0;


        HRS() {
        while (true) {
            System.out.println("-----欢迎进入最LOW浦发年兽版招聘系统----");
            System.out.println("添加应聘人员---请输入1");
            System.out.println("移除应聘人员---请输入2");
            System.out.println("修改应聘人员信息---请输入3");
            System.out.println("查询应聘人员信息---请输入4");
            System.out.println("退出系统---请输入5");

            int choice = input.nextInt();
            switch (choice) {
                case 1:addPerson();
                break;
                case 2:remotePerson();
                break;
                case 3:updatePerson();
                break;
                case 4:showPerson();
                break;
                case 5:break;
                default:
                    System.out.println("输入错误，请重新输入");


            }
        }
    }

    public void addPerson() {

        System.out.println("欢迎进入添加应聘人员系统界面");
        Scanner input = new Scanner(System.in);
        if (personCount <= 1000) {
            System.out.println("请依次输入需要添加的员工名字，身份证号，毕业学校，以及应聘环节");
            String personName = input.nextLine();
            int personId = input.nextInt();
            String personSchool = input.nextLine();
            int personProcess = input.nextInt();

            Person person = new Person(personName, personId, personSchool, personProcess);
            personlist[personCount]=person;
            personCount++;
            System.out.println("您已成功添加一名新的应聘员工信息");
        } else {
            System.out.println("此次招聘人员已满，无法添加新员工");
        }
    }

    public void remotePerson() {
        System.out.println("欢迎进入移除应聘员工界面");
        System.out.println("请输入需要移除的员工姓名");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        if (personCount != 0) {
            for (int i = 0; i < personCount; i++) {
                if (personlist[i].getName().equals(name)) {
                for (int j = i;j<personCount-1;j++){
                    personlist[j]= personlist[j++];
                }
                    System.out.println("您已成功将该应聘人员移除");
                personCount--;
                break;
                }
                else if (i==personCount-1){
                    System.out.println("没有找到该人员");
                }
                else {
                    System.out.println("应聘系统为空，没有找到该人员");
                }
            }

        }
    }

    public void updatePerson(){
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入修改应聘人员信息界面");
        System.out.println("请输入需要修改的应聘人员姓名");
        String personName=input.nextLine();
        if (personCount != 0) {
            for (int i = 0; i < personCount; i++) {
                if (personlist[i].getName().equals(personName)) {
                    System.out.println("请依次输入新的人员姓名，身份证号，毕业学校，和应聘环节");
                    String newPersonName = input.nextLine();
                    int newPersonId = input.nextInt();
                    String newPersonSchool = input.next();
                    int newPersonProcess = input.nextInt();
                    Person person = new Person(newPersonName, newPersonId, newPersonSchool, newPersonProcess);

                    personlist[i] = person;
                    System.out.println("您已经修改成功");
                } else if (i == personCount - 1 || personCount == 0) {

                    System.out.println("没有查找到该书籍");
                } else {
                    System.out.println("系统为空，没有查找到该书籍");
                }
            }
        }
    }

    public void searchPerson(){
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入查询应聘人员界面");
        System.out.println("请输入需要查询的人员姓名");
        String personName=input.nextLine();
        for(int i=0;i<personCount;i++)
        {
            if(personlist[i].getName().equals(personName)) {
                System.out.println("应聘人员："+personlist[i].getName()+"\n"+
                        "身份证号为："+":"+personlist[i].getId()+"\n"
                        +"毕业学校为"+":"+personlist[i].getSchool()+"\n"
                        +"现在的应聘环节为"+personlist[i].getProcess());
                break;
            }
            else if(i==personCount-1) {
                System.out.println("没有查找到该人员，请重新输入");

            }
            }
    }

    public void showPerson(){
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要浏览所有应聘人员，是请输入Y");
        String chioce=input.nextLine();
        String Y="Y";
        if(chioce.equals(Y))
        {
            System.out.println("本应聘人员管理系统共有"+personCount+"本书");
            for(int i=0;i<personCount;i++) {
                System.out.println("第"+(i+1)+"人"+"----"+"是"+personlist[i].getName());

            }

        }
    }


}



