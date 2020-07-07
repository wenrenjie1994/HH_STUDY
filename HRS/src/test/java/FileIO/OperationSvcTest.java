package FileIO;

import Bean.Student;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/6 23:09
 */
public class OperationSvcTest {
    String fileName = "data.txt";

    @Test
    public void readFileTest() throws IOException {
        ArrayList<Student> students = new ArrayList<Student>();
        OperationSvc.getStudents(fileName);
    }
}