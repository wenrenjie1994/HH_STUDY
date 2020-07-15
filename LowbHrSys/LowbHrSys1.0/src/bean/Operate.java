package bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Operate {

    //添加简历
    public static void addPerson(ArrayList<Person> PersonList){
        System.out.println("hi欢迎进入添加简历界面~");
        Scanner input = new Scanner(System.in);
        System.out.println("请按顺序依次输入姓名，年龄，性别，毕业学校");
        String Name = input.nextLine();
        String Age = input.nextLine();
        String Sex = input.nextLine();
        String School = input.nextLine();
        Person person = new Person(Name,Age,Sex,School);
        PersonList.add(person);
        System.out.println("添加简历成功！");
        showPerson(PersonList);

    }

    //删除简历
    public static void deletePerson(ArrayList<Person> PersonList){

        System.out.println("hi欢迎进入删除简历界面~");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除简历的姓名：");
        String Name = input.nextLine();
        for (int i = 0; i < PersonList.size(); i++) {
            if( Name.equals(PersonList.get(i).getName())){
                PersonList.remove(i);
                System.out.println("删除简历成功！");
                break;
            }else if (i == PersonList.size()-1){
                System.out.println("失败！未找到该简历");
            }
        }
        showPerson(PersonList);


    }

    //查询简历
    public  static void searchPerson(ArrayList<Person> PersonList){
        System.out.println("hi欢迎进入查询简历界面~");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要查询简历的姓名：");
        String Name = input.nextLine();
        for (int i = 0; i < PersonList.size(); i++) {
            if(Name.equals(PersonList.get(i).getName())){
                System.out.println("姓名："+PersonList.get(i).getName());
                System.out.println("年龄："+PersonList.get(i).getAge());
                System.out.println("性别："+PersonList.get(i).getSex());
                System.out.println("毕业学校："+PersonList.get(i).getSchool());
                break;
            } else if(i == PersonList.size()-1){
                System.out.println("失败！未查询该简历");
            }
        }

    }

    //修改简历
    public static void updatePerson(ArrayList<Person> PersonList){
        System.out.println("hi欢迎进入修改简历界面~");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要修改简历的姓名：");
        String resumeCount = input.nextLine();
        for (int i = 0; i < PersonList.size(); i++) {
            if(resumeCount.equals(PersonList.get(i).getName())){
                System.out.println("请依次输入新的姓名，年龄，性别，毕业学院");
                String newName = input.nextLine();
                String newAge = input.nextLine();
                String newSex = input.nextLine();
                String newEducation = input.nextLine();
                Person d = new Person(newName,newAge,newSex,newEducation);
                PersonList.set(i,d);
                System.out.println("修改成功！");
                showPerson(PersonList);
                break;
            } else if (i == PersonList.size() - 1 || PersonList.size() == 0){
                System.out.println("没有查找到该简历");
            }
        }


    }

    //遍历简历
    public static void showPerson(ArrayList<Person> PersonList){
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印输入任意");
        Scanner input = new Scanner(System.in);
        String XUANZE = input.nextLine();
        if(XUANZE.equals("Y")||XUANZE.equals("y")){
            System.out.println("本简历管理系统共有"+ PersonList.size() +"个简历");
            for (int i = 0; i < PersonList.size(); i++) {
                System.out.println("第"+(i+1)+"个"+"---"+"<<"+PersonList.get(i).getName()+">>");
            }
        }

    }
}
