package DataBase.Util.DAO;

import Bean.Student;

import java.util.ArrayList;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/13 17:44
 */
public interface IStudent {
    // 添加一个学生
    public boolean addStudent(Student student);

    // 更新学生
    public boolean updateStudent(Student student);

    // 删除学生（学号方式）
    public boolean delStudentByStuID(String stuID);

    // 查找学生（学号方式）
    public Student getStudentByStuID(String stuID);

    // 拿到所有学生
    public ArrayList<Student> getAllStudents();

}
