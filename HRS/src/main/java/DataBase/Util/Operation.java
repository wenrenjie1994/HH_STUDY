package DataBase.Util;

import DataBase.Util.DAOImpl.StudentImpl;

import java.util.Scanner;

import static Commons.StudentUtils.buildStudent;
import static Commons.StudentUtils.showMenu;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/15 14:34
 */
public class Operation {
    public static void main(String[] args) {
        StudentImpl svc = new StudentImpl();
        showMenu();
        Scanner sc = new Scanner(System.in);
        while (true) {
            switch (sc.nextInt()) {
                case 1:
                    System.out.println(svc.getAllStudents());
                    break;
                case 2:
                    svc.addStudent(buildStudent());
                    break;
                case 3:
                    System.out.print("输入要删除学生的学号：");
                    svc.delStudentByStuID(sc.next());
                    break;
                case 4:
                    svc.updateStudent(buildStudent());
                    break;
                case 0:
                    System.exit(0);
                default:
                    showMenu();
            }
        }

    }
}
