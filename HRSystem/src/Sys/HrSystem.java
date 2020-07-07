package Sys;

import bean.Person;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class HrSystem {

    private static LinkedList<Person> personList = new LinkedList<Person>();
    private static Scanner input;

    /**
     * 添加人员方法
     */
    public static void addPerson() {

        System.out.println("欢迎进入添加人员界面");
        input = new Scanner(System.in);
        System.out.println("请依次输入需要添加的姓名、身份证号、毕业院校、当前所在的阶段");

        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        int process = input.nextInt();

        Person person = new Person(name, id, school, process);
        personList.add(person);
        System.out.println("您已成功添加。当前目录中有如下人员：");
        for (Person person1 : personList) {
            System.out.println(person1.toString());
        }

    }

    /**
     * 删除人员方法
     */
    public static void deletePerson() {

        boolean deleteStatus = false;

        System.out.println("欢迎进入删除人员界面");
        input = new Scanner(System.in);
        System.out.println("请输入需要删除的人员的身份证号");

        String id = input.nextLine();

        //for循环删除LinkedList中元素需要使用迭代器
        for (Iterator<Person> iterator = personList.iterator(); iterator.hasNext(); ) {
            Person person = iterator.next();
            if (person.getId().equals(id)) {
                iterator.remove();
                deleteStatus = true;
            }
        }
        if (deleteStatus == true) {
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }

        System.out.println("剩余人员包括：");
        for (Person person : personList) {
            System.out.println(person.toString());
        }

    }

    /**
     * 查找人员信息
     */
    public static void searchPerson() {

        boolean searchStatus = false;

        System.out.println("欢迎进入查询界面");
        input = new Scanner(System.in);
        System.out.println("请输入需要查询的人员的身份证号");

        String id = input.nextLine();

        for (Person person : personList) {
            if (person.getId().equals(id)) {
                searchStatus = true;
                System.out.println(person.toString());
            }
            if (searchStatus == false) {
                System.out.println("查无此人");
            }
        }

    }

    /**
     * 修改人员信息
     */
    public static void updatePerson() {

        //目标人员的索引下标
        int Index = 0;
        //查询情况: true：查到该身份证号；false：查无此人
        boolean searchStatus = false;

        System.out.println("欢迎来到修改信息界面");
        input = new Scanner(System.in);
        System.out.println("请输入需要要修改的身份证号");

        String id = input.nextLine();

        for (Person person : personList) {
            if (person.getId().equals(id)) {
                searchStatus = true;
                break;
            }
            Index++;
        }

        if (searchStatus == true) {
            System.out.println("请依次输入新的姓名、身份证号、毕业院校、当前所在的阶段");
            String newName = input.nextLine();
            String newId = input.nextLine();
            String newSchool = input.nextLine();
            int newProcess = input.nextInt();
            Person newInformation = new Person(newName, newId, newSchool, newProcess);

            personList.set(Index, newInformation);

            System.out.println("修改成功");
            System.out.println(personList.get(Index).toString());
        } else {
            System.out.println("查无此人");
        }
    }

    public static void main(String[] args) {
        while (true) {

            System.out.println("-----欢迎进入人力资源管理系统-----");
            System.out.println("添加人员信息请按----1");
            System.out.println("删除人员信息请按----2");
            System.out.println("修改人员信息请按----3");
            System.out.println("查询人员信息请按----4");
            System.out.println("退出请按--------5");

            input = new Scanner(System.in);

            int choice = input.nextInt();

            //用switch退不出最外圈的循环，咋搞？
//            switch (choice) {
//                case 1:addPerson();break;
//                case 2:deletePerson();break;
//                case 3:updatePerson();break;
//                case 4:searchPerson();break;
//                case 5:break;
//                default:
//                    System.out.println("输入错误");
//            }

            //除了用if 还能用什么方式可以实现逻辑判断？
            if(choice==1)
            {
                addPerson();
            }
            else if(choice==2)
            {
                deletePerson();
            }
            else if(choice==3)
            {
                updatePerson();
            }
            else if(choice==4)
            {
                searchPerson();
            }
            else if(choice==5)
            {
                break;
            }else {
                System.out.println("输入错误，请重新输入");
            }
        }
        input.close();
        System.out.println("您已经退出人力资源管理系统");
    }
}
