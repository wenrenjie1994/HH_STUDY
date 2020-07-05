package LinkList;

import bean.Student;

import java.util.Scanner;

/**
 * @author：ljj0452@gmail.com
 * @time: 2020/7/4 22:47
 */
public class OperationMenu {

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

    public static void main(String[] args) {
        Student student = new Student("123", "Kevin", 11, "iot", 222);
        Scanner scanner = new Scanner(System.in);
        StudentSvc svc = new StudentSvc();
        showMenu();
        while (true) {
            System.out.print("Type a number to select: ");
            switch (scanner.nextInt()) {
                case 1:
                    svc.showAllStudents();
                    break;
                case 2:
                    svc.addStudent(buildStudent());
                    break;
                case 3:
                    System.out.print("输入删除索引：");
                    svc.delStudentByIndex(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("输入修改索引：");
                    svc.updateStudentByIndex(scanner.nextInt(), buildStudent());
                    break;
                case 0:
                    System.exit(0);
                default:
                    showMenu();
            }
        }
    }
}
