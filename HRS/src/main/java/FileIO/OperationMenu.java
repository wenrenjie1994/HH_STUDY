package FileIO;

import bean.Student;

import java.util.ArrayList;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/6 22:15
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

    public static void main(String[] args) {
        OperationSvc.getStudents("src/main/resources/data.txt",new ArrayList<Student>());
    }
}
