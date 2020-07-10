package hr;

import student.student;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hr {


    Map<String, student> student = new HashMap<String, student>();
    Map<String, String> info = new HashMap<String, String>();
String url;
    public hr(String url) {
        this.info.put("姓名", "name");
        this.info.put("身份证号", "IDcard");
        this.info.put("手机号", "phoneNumber");
        this.info.put("出生日期", "birthday");

        this.info.put("性别", "gender");
        this.info.put("年龄", "age");
        this.info.put("学历", "degree");
        this.info.put("学校", "school");
        this.info.put("应聘岗位", "job");
        this.info.put("期望薪资", "salary");
        this.url=url;
        this.readTxt();
    }

    public void addStudent() {
        /*增加学生*/
        try {

            System.out.println("请按照姓名、身份证号、手机号，性别、出生日期、年龄、学历、学校、应聘岗位、期望薪资顺序输入");
            Scanner info = new Scanner(System.in);
            String[] infoString = info.nextLine().split(" ");
            String name = infoString[0];

            String IDcard = infoString[1];
            String phoneNumber = infoString[2];
            String gender = infoString[3];
            String birthday = infoString[4];
            String age = infoString[5];
            String degree = infoString[6];
            String school = infoString[7];
            String job = infoString[8];
            String salary = infoString[9];
//            System.out.println(infoString);
//            System.out.println(salary);
            if (student.containsKey(phoneNumber)) {
                System.out.println("此手机号已经存在，请添加不同手机号号同学");
                this.addStudent();
            } else {

                this.student.put(phoneNumber, new student(name, IDcard, phoneNumber, gender, birthday,
                        age, degree, school, job, salary));
                System.out.println("添加成功!!!");
            }

        } catch (Exception e) {
            System.out.println("输入结构出错，请重新输入");
            this.addStudent();

        }
    }

    public void deleteStudent() {
        /*删除学生*/
        try {

            System.out.println("请输入要删除学生的手机号");
            Scanner info = new Scanner(System.in);
            String phoneNumber = info.nextLine();
            if (this.student.get(phoneNumber).isDelete) {
                System.out.println("输入结构或信息出错，请重新输入");
                this.deleteStudent();
            } else {
                this.student.get(phoneNumber).isDelete = true;
                System.out.println("删除成功");
            }
        } catch (Exception e) {
            System.out.println("输入结构出错，请重新输入");
            this.deleteStudent();

        }
    }

    public void alterStudent() {
        /*删除学生*/
        try {

            System.out.println("请输入要更正的信息类别");
            Scanner info = new Scanner(System.in);
            String infoString = info.nextLine();
            if (infoString.equals("手机号")) {
                System.out.println("身份证为不可修改信息！请重新输入");
                this.alterStudent();
            } else {
                System.out.println("请按手机号、更正信息输入要更正的信息");
                String[] infoInput = info.nextLine().split(" ");
//                获取学生
//                通过反射,找到对应的属性，给属性赋值
                System.out.println(this.student.get(infoInput[0]));
                Field name = this.student.get(infoInput[0]).getClass().getDeclaredField(this.info.get(infoString));
                name.setAccessible(true);

                System.out.println(infoInput[0]);
                name.set(student.get(infoInput[0]), infoInput[1]);
                System.out.println("更改成功");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("输入结构出错，请重新输入");
            this.alterStudent();
//            谭强 151645644 18398260508 男 1996 22 本科 川农 教师 10000
//            唐家鑫 511902199801011118 17781606563 男 1977 22 本科 村内 数据 10000
        }
    }


    public void selectStudent() {
        for (student value : student.values()) {
            if (!value.isDelete) {
                value.select();
            }

        }
        System.out.println("查询完毕！！！");
    }

    public int printWelcome() {
        System.out.println("====欢迎进入Hr系统！！！===");
        System.out.println("请输入对应的数字表示进行操作！");
        System.out.println("请按1进行增加学生信息操作");
        System.out.println("请按2进行删除学生信息操作");
        System.out.println("请按3进行更改学生信息操作");
        System.out.println("请按4进行查询学生信息操作");
        System.out.println("请按5退出程序");
        return 5;
    }

    public boolean choose(int num) {

        switch (num) {
            case 1:
                this.addStudent();
                break;
            case 2:
                this.deleteStudent();
                break;
            case 3:
                this.alterStudent();
                break;
            case 4:
                this.selectStudent();
                break;
            case 5:
                this.writeTxt();
                System.out.println("程序结束！！！感谢使用。");
                return true;
        }
        return false;
    }

    public int inputNum(int max) {
        int num;
        try {
            Scanner info = new Scanner(System.in);
            num = Integer.parseInt(info.nextLine());

        } catch (Exception e) {
            System.out.println("输入非数字，请重新输入");
            num = this.inputNum(max);
        }
        if (num > max || num < 1) {
            System.out.println("请输入以上序号数字");
            num = this.inputNum(max);
        }
        return num;
    }
public void writeTxt(){
    try {
        BufferedWriter out = new BufferedWriter(new FileWriter(this.url));
        for (student value : student.values()) {
            out.write(value.writeInfo());


        }
        out.close();

    } catch (Exception e) {
        System.out.println(e);

    }
}

public void readTxt(){
                try {
                    BufferedReader in = new BufferedReader(new FileReader(this.url));
                    String str;
                    while ((str=in.readLine())!=null){
                        String[] infoString = str.split("\t");
                        this.student.put(infoString[2], new student(infoString[0], infoString[1], infoString[2],
                                infoString[3], infoString[4], infoString[5], infoString[6], infoString[7],
                                infoString[8], infoString[9], infoString[10].equals("True")));
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
}


    public void saveToDatabase() {

    }


}
