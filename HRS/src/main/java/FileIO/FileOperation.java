package FileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static Commons.StudentUtils.showMenu;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/6 22:15
 */
public class FileOperation {
    public final static String fileName = "src/main/resources/data.txt";

    public static void main(String[] args) throws IOException {
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
                case 0:
                    System.exit(0);
                default:
                    showMenu();
            }
        }
    }
}
