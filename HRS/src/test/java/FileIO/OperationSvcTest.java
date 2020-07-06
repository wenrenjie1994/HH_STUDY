package FileIO;

import bean.Student;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/6 23:09
 */
public class OperationSvcTest {
    String fileName = "data.txt";

    @Test
    public void readFileTest() {
        ArrayList<Student> students = new ArrayList<Student>();
        OperationSvc.getStudents(fileName, students);
    }
}