package service;
import model.People;
import loadandsaveData.DataOperate;
import java.util.LinkedList;
import java.util.Scanner;
public class PeopleService {
    public static void addPeople(LinkedList<People> people){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入要添加的人员的姓名和id信息！");
        String name=input.next();
        String id=input.next();
        people.add(new People(name,id));

//        input.close();
    }
    public static void deletePeople(LinkedList<People> people){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入要删除的人员id！");
        String s=input.next();
        for(int i=0;i<people.size();i++)
        {
            if(people.get(i).getID().equals(s))
            {
                people.remove(i);
                break;
            }
            System.out.printf("id为%s的人员信息已经删除！",s);
        }

    }
    public static void updatePeople(LinkedList<People> people){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入要修改的人员id！");
        String newID=input.next();
        for(int i=0;i<people.size();i++)
        {
            if(people.get(i).getID().equals(newID))
            {
                String oldname=people.get(i).getName();
                String newname=input.next();
                people.get(i).setName(newname);
                System.out.printf("id为%s的人员姓名由%s修改为%s！",newID,oldname,newname);
                break;
            }
        }
    }
    public static void showPeople(LinkedList<People> people){

        System.out.println("所有人员信息如下！");
        for(int i=0;i<people.size();i++)
        {
            System.out.printf("第%d为人员的信息为：\n姓名：%s，ID：%s，状态：%d\n",
                    i+1,people.get(i).getName(),people.get(i).getID(),people.get(i).getSchool());
        }

    }
}
