package DataBase.Util.DAOImpl;

import Bean.Student;
import org.junit.Test;

import static Commons.StudentUtils.buildStudent;
import static org.junit.Assert.*;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/13 19:53
 */
public class StudentImplTest {
    private StudentImpl svc=new StudentImpl();
    @Test
    public void addStudentTest() {
    }

    @Test
    public void updateStudentTest() {
    }

    @Test
    public void delStudentByStuIDTest() {
    }

    @Test
    public void getStudentByStuIDTest() {
        String existId="1234";
        String notFoundId="1212121";
        assert svc.getStudentByStuID(existId)!=null;
        assert svc.getStudentByStuID(notFoundId)==null;
    }

    @Test
    public void getAllStudentsTest() {
        assertNotNull(svc.getAllStudents());
    }
}