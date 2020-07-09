package FileIO;

import Bean.Student;

import java.io.*;
import java.util.ArrayList;

import static Commons.StudentUtils.buildStudent;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/6 22:26
 */
public class OperationSvc {

    // 从文件中读学生列表
    public static ArrayList<Student> getStudents(String fileName) {
        ArrayList<Student> arrStudents = new ArrayList<Student>();
        try {
            FileReader reader;
            reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Student student = new Student();
                // line format: stuID-name-age-major-interviewScore
                String[] students = line.split("-");
                student.setStuID(students[0]);
                student.setName(students[1]);
                student.setAge(Integer.parseInt(students[2]));
                student.setMajor(students[3]);
                student.setInterviewScore(Integer.parseInt(students[4]));
                arrStudents.add(student);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取错误。");
        }
        return arrStudents;
    }

    // 学生列表保存到文件
    public static void saveStudents2File(String fileName, ArrayList<Student> arrStudents) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : arrStudents) {
                StringBuilder sb = new StringBuilder();
                sb.append(student.getStuID()).append("-")
                        .append(student.getName()).append("-")
                        .append(student.getAge()).append("-")
                        .append(student.getMajor()).append("-")
                        .append(student.getInterviewScore());
                bufferedWriter.write(sb.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件错误");
        }

    }

    // 输出学生列表, 象征性输出一下
    public static void showAllStudents(String fileName) {
        System.out.println(getStudents(fileName));

    }

    // 添加一个学生
    public static void addStudent(String fileName) {
        // 文件读到学生数组
        ArrayList<Student> arrStudents = getStudents(fileName);
        Student newStudent = buildStudent();
        for (Student inArray : arrStudents) {
            if (inArray.getStuID().equals(newStudent.getStuID())) {
                System.out.println("学生ID已存在，请重新添加！");
                return;
            }
        }
        arrStudents.add(newStudent);
        saveStudents2File(fileName, arrStudents);
        System.out.println("添加学生: " + newStudent.getName() + " 成功。");
    }

    // 修改学生
    public static void updateStudent(String fileName, String stuID, Student student) {
        ArrayList<Student> arrStudents = getStudents(fileName);
        // foreach flag
        int index = 0;

        //search student
        for (Student temp : arrStudents) {
            if (temp.getStuID().equals(stuID)) {
                // update
                arrStudents.set(index, student);
                // save to file
                saveStudents2File(fileName, arrStudents);
                System.out.println("学生信息更新成功。");
                return;
            }
            index++;
            // stuID not found
            if (index == arrStudents.size()) {
                System.out.println("该学生不存在！");
                return;
            }
        }
    }

    // 删除学生（使用学号）
    public static void delStudentByStuID(String fileName, String stuID) {
        ArrayList<Student> arrStudents = getStudents(fileName);
        // foreach flag
        int index = 0;

        //search student
        for (Student temp : arrStudents) {
            if (temp.getStuID().equals(stuID)) {
                // remove
                arrStudents.remove(index);
                // save to file
                saveStudents2File(fileName, arrStudents);
                System.out.println("删除学生:" + temp.getName() + " 成功。");
                return;
            }
            index++;
            // stuID not found
            if (index == arrStudents.size()) {
                System.out.println("该学生不存在！");
                return;
            }
        }

    }
}
