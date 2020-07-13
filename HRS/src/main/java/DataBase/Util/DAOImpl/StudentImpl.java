package DataBase.Util.DAOImpl;

import Bean.Student;
import DataBase.Util.DAO.IStudent;
import DataBase.Util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/13 17:46
 */
public class StudentImpl implements IStudent {
    public boolean addStudent(Student student) {
        String sql = "insert into tblstudent (stuID, name, age, major, interview_score, isDelete) values('" + student.getStuID() + "','" + student.getName() + "'," + student.getAge() + ",'" + student.getMajor() + "'," + student.getInterviewScore() + ",0 )";
        String existSql = "select stuID from tblstudent where stuID='" + student.getStuID() + "' and isDelete=0";
        try {
            if (!DBUtil.runQuery(existSql).next()) {
                DBUtil.runUpdate(sql);
                System.out.println("add student: " + student.getName() + " success!");
                return true;
            } else {
                System.out.println("ERROR! StudentID: " + student.getStuID() + " already exist! ");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        String selectSql = "select stuID from tblstudent where stuID='" + student.getStuID() + "' and isDelete=0";
        String updateSql = "update tblstudent set name='" + student.getName() + "',age=" + student.getAge() + ",major='" + student.getMajor() + "',interview_score=" + student.getInterviewScore() + " where stuID='" + student.getStuID() + "' and isDelete=0";
        try {
            if (DBUtil.runQuery(selectSql).next()) {
                DBUtil.runUpdate(updateSql);
                System.out.println("update student: " + student.getName() + " success!");
                return true;
            } else {
                System.out.println("Student: " + student.getStuID() + " doesn't exist!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delStudentByStuID(String stuID) {
        String selectSql = "select stuID from tblstudent where stuID='" + stuID + "' and isDelete=0";
        String delSql = "update tblstudent set idDelete=1 where stuID='" + stuID + "'";
        try {
            if (DBUtil.runQuery(selectSql).next()) {
                DBUtil.runUpdate(delSql);
                System.out.println("Student: " + stuID + " delete success!");
                return true;
            } else {
                System.out.println("Student: " + stuID + " doesn't exist!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Student getStudentByStuID(String stuID) {
        String selectSql = "select * from tblstudent where stuID='" + stuID + "' and isDelete=0";
        try {
            ResultSet rs = DBUtil.runQuery(selectSql);
            if (rs.next()) {
                System.out.println("find success.");
                return new Student(rs.getString("stuID"), rs.getString("name"), rs.getInt("age"), rs.getString("major"), rs.getInt("interview_score"));
            } else {
                System.out.println("student not found!");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Student> getAllStudents() {
        String selectSql = "select * from tblstudent where isDelete=0";
        try {
            ResultSet rs = DBUtil.runQuery(selectSql);
            ArrayList<Student> students = new ArrayList<Student>();
            if (!rs.next()) {
                System.out.println("student table is empty!");
                return null;
            }
            while (rs.next()) {
                students.add(new Student(rs.getString("stuID"), rs.getString("name"), rs.getInt("age"), rs.getString("major"), rs.getInt("interview_score")));
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
