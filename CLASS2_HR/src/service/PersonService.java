package service;

import model.Person;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;

public class PersonService {
    //添加同学
    public static void addPerson(LinkedList<Person> personList){
        System.out.println("欢迎来到电子科大教务系统个人信息添加界面！");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要添加的个人信息，依次包括：姓名、学号、班级");
        String personName = sc.nextLine();
        Scanner sc0 = new Scanner(System.in);
        String personID = sc0.nextLine();
        Scanner sc1 = new Scanner(System.in);
        String personClass = sc1.nextLine();
        Person person = new Person(personName, personID, personClass);
        personList.add(person);
        System.out.println("已成功添加该同学");
        System.out.println("目前同学列表中有以下同学：");
        showPerson(personList);
    }

    //显示目前列表中所有的同学
    public static void showPerson(LinkedList<Person> personList) {
        System.out.println("是否打印出所有学生列表，选择Y/y打印，其他为不打印");
        Scanner sc = new Scanner(System.in);
        String jurdge = sc.nextLine();
        String Y = "Y";
        String y = "y";
        if(jurdge.equals(Y)|jurdge.equals((y))){
            System.out.println("列表中共有学生人数为"+personList.size()+"人");
            for (int i = 0; i < personList.size(); i++) {
                System.out.println("第"+(i+1)+"位学生个人名字为："+personList.get(i).getPersonName()+"；ID："+personList.get(i).getPersonID()+"；班级为："+personList.get(i).getPersonClass());
//                System.out.println("第"+(i+1)+"位学生个人ID——————"+personList.get(i).getPersonID());
//                System.out.println("第"+(i+1)+"位学生个人班级——————"+personList.get(i).getPersonClass());
            }
        }
    }
    //根据姓名或者ID两种方式删除学生信息
    public static void deletePerson(LinkedList<Person> personList){
        System.out.println("欢迎进入学生信息删除界面");
        System.out.println("请选择您的删除方式，输入1或2，其中:1根据姓名删除；2根据ID删除");
        Scanner sc = new Scanner(System.in);
        Integer input = sc.nextInt();
        if (input.equals(1)){
            System.out.println("请输入学生姓名");
            Scanner sc1 = new Scanner(System.in);
            String sc11 = sc1.nextLine();
            for (int i = 0; i <personList.size() ; i++) {
                if (personList.get(i).getPersonName().equals(sc11)){
                    personList.remove(i);
                    System.out.println("已删除该同学信息");
                    break;
                }else if (i == personList.size()-1){
                    System.out.println("未找到该同学信息");
                }
            }
        }else if (input.equals(2)){
            System.out.println("请输入学生ID");
            Scanner sc2 = new Scanner(System.in);
            String sc22 = sc2.nextLine();
            for (int i = 0; i <personList.size() ; i++) {
                if (personList.get(i).getPersonID().equals(sc22)){
                    personList.remove(i);
                    System.out.println("已删除该同学信息");
                    break;
                }else if (i == personList.size()-1){
                    System.out.println("未找到该同学信息");
                }
            }
        }else {
            System.out.println("输入有误");
        }
        showPerson(personList);
    }
    //修改学生个人信息
    public static void updatePerson(LinkedList<Person> personList){
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入学生信息修改界面，请输入需要更新的学生姓名");
        String student = sc.nextLine();
        int personCount = personList.size();
        for (int i = 0; i < personCount; i++) {
            if (personList.get(i).getPersonName().equals(student)){
                System.out.println("已查找到目标名字，请重新输入新的名字、ID、班级");
                String personName = sc.nextLine();
                Scanner sc0 = new Scanner(System.in);
                String personID = sc0.nextLine();
                Scanner sc1 = new Scanner(System.in);
                String personClass = sc1.nextLine();
                Person person = new Person(personName,personID,personClass);
                personList.set(i,person);
                System.out.println("修改成功");
                showPerson(personList);
            }else if (i == personCount-1||personCount==0){
                System.out.println("未查找到该同学");
            }
        }
        System.out.println("未查找到该同学");
    }

}
