package basic.method.demo1.day3;

import java.util.ArrayList;

public class Demo02ArrayListStudent {
    public static void main(String[] args) {


        ArrayList<Student> list = new ArrayList<>();

        Student one = new Student("小红", 18);
        Student two = new Student("小兰", 19);
        Student three = new Student("小绿", 21);
        Student four = new Student("小黑", 20);

        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println("姓名为："+stu.getName()+",年龄为："+stu.getAge());
        }
        System.out.println("===============");



    }
}

