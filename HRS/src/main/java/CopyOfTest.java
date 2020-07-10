import Bean.Student;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/10 00:15
 */
public class CopyOfTest {
    public static void main(String[] args) {
        Student student1=new Student("1234","kevin",18,"iot",99);
        Student student2=new Student("5678","kevin",19,"iot",19);
        ArrayList<Student> students=new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        for(Student temp:students){
            System.out.println(temp);
        }
    }


}
