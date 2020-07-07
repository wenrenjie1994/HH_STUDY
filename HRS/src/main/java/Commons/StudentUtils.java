package Commons;

import Bean.Student;

import java.util.Scanner;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/7 15:31
 */
public class StudentUtils {
    public static void showMenu() {
        System.out.println("*****************************************");
        System.out.println("*********** Student Manager V1.0 ********");
        System.out.println("*****************************************");
        System.out.println("*** 1. show all students              ***");
        System.out.println("*** 2. add a student                  ***");
        System.out.println("*** 3. delete a student by index      ***");
        System.out.println("*** 4. update a student by index      ***");
        System.out.println("*** 0. exit                           ***");
        System.out.println("*****************************************");
        System.out.print("Please type a number to option: ");
    }

    public static Student buildStudent() {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.print("输入学生ID：");
        student.setStuID(sc.next());
        System.out.print("输入学生姓名：");
        student.setName(sc.next());
        System.out.print("输入学生年龄：");
        student.setAge(sc.nextInt());
        System.out.print("输入学生专业：");
        student.setMajor(sc.next());
        System.out.print("输入学生面试成绩：");
        student.setInterviewScore(sc.nextInt());
        return student;
    }
}
