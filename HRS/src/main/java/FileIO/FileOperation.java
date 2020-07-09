package FileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static Commons.StudentUtils.buildStudent;
import static Commons.StudentUtils.showMenu;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/6 22:15
 */
public class FileOperation {
    public final static String fileName = "src/main/resources/data.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        showMenu();
        while (true) {
            switch (sc.nextInt()) {
                case 1:
                    OperationSvc.showAllStudents(fileName);
                    break;
                case 2:
                    OperationSvc.addStudent(fileName);
                    break;
                case 3:
                    System.out.print("输入需要删除的学生学号：");
                    OperationSvc.delStudentByStuID(fileName, sc.next());
                    break;
                case 4:
                    System.out.print("输入需要更新的学生学号：");
                    OperationSvc.updateStudent(fileName, sc.next(), buildStudent());
                    break;
                case 0:
                    System.exit(0);
                default:
                    showMenu();
            }
        }
    }
}
