package LinkList;

import Bean.Student;

import java.util.Scanner;

import static Commons.StudentUtils.*;

/**
 * @author：ljj0452@gmail.com
 * @time: 2020/7/4 22:47
 */
public class LLOperation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSvc svc = new StudentSvc();
        showMenu();
        while (true) {
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
