package day06.demo;

import java.util.ArrayList;

//自定义4个学生对象，添加集合，并遍历
public class practice02 {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        //定义四个学生对象
        Student one = new Student("lisa:", 88.8);
        Student two = new Student("Dora:", 96.5);
        Student three = new Student("Marry:", 63);
        Student four = new Student("Linda:", 75);

        //添加到集合中
        studentList.add(one);
        studentList.add(two);
        studentList.add(three);
        studentList.add(four);

        //遍历集合
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getName() + " "
                    + studentList.get(i).getGrade());
        }


    }
}
