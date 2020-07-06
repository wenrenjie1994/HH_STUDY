package FileIO;

import bean.Student;

import java.io.*;
import java.util.ArrayList;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/6 22:26
 */
public class OperationSvc {

    // 从文件中读学生列表
    public static void getStudents(String fileName, ArrayList<Student> arrStudents) {
        FileReader reader;
        try {
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
            System.out.println(arrStudents);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件错误。");
        }

    }

    // 学生列表保存到文件
    public static void saveStudents(String fileName, ArrayList<Student> arrStudents) {
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
}
