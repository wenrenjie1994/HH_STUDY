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
    public static ArrayList<Student> getStudents(String fileName) throws IOException {
        FileReader reader;
        reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        ArrayList<Student> arrStudents = new ArrayList<Student>();
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
    public static void showAllStudents(String fileName) throws IOException {
        System.out.println(getStudents(fileName));

    }

    // 添加一个学生
    public static void addStudent(String fileName) throws IOException {
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
        System.out.println("添加学生: " + newStudent.getName() + "成功。");
    }
}
