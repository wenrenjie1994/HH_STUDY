package service;

import entity.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    public static void addStudent(LinkedList<Student> studentList,int number)
    {
        System.out.println("欢迎来到添加简历界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加应聘者的姓名，学校，应聘岗位");
        String studentName =input.nextLine();
        String school =input.nextLine();
        String position =input.nextLine();
        Student student= new Student(number,studentName,school,position);
        studentList.add(student);
        System.out.println("您已成功添加简历");
        showResume(studentList);

    }
    public static int deleteStudent(LinkedList<Student> studentList)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到删除简历界面");
        System.out.println("请输入需要删除的学生姓名");
        String name =input.nextLine();

        for(int i=0;i<studentList.size();i++)
        {
            if(studentList.get(i).getName().equals(name))
            {
                studentList.remove(i);
                System.out.println("您已成功删除该简历");
                break;
            }
            else if(i==studentList.size()-1) {
                System.out.println("没有查找到该简历");
            }
        }

        showResume(studentList);
        return studentList.getLast().getStuNo();
    }
    public static void updatestudent(LinkedList<Student> studentList)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到修改简历界面");
        System.out.println("请输入需要修改的学生姓名");
        String name=input.nextLine();

        for(int i=0;i<studentList.size();i++)
        {
            if(studentList.get(i).getName().equals(name))
            {
                System.out.println("请依次输入新的姓名，学校，应聘职位");
                String newName=input.nextLine();
                String school=input.nextLine();
                String position=input.nextLine();
                Student student=new Student(studentList.get(i).getStuNo(),newName,school,position);
                studentList.set(i, student);
                System.out.println("您已成功修改成功");
                showResume(studentList);
                break;
            }
            else if(i==studentList.size()-1) {
                System.out.println("没有查找到该简历");
            }
        }
    }

    public static void showResume(LinkedList<Student> studentList)
    {

            System.out.println("本LowB招聘管理系统共有"+studentList.size()+"份简历");
            for(int i=1;i<=studentList.size();i++) {
                System.out.println("第"+i+"份简历"+"---------"+"简历编号:"+studentList.get(i-1).getStuNo()+" 学生姓名："+studentList.get(i-1).getName()+" 来自 "+studentList.get(i-1).getSchool()+" 应聘职位是： "+studentList.get(i-1).getPosition());
            }
    }

}
