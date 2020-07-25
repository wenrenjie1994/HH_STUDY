package client;

import database.dbConnection;
import student.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class clientHr {


    Map<String, student> student = new HashMap<String, student>();
    Map<String, String> info = new HashMap<String, String>();
    String url;
    dbConnection db = new dbConnection();

    public clientHr(String url) {
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
        this.url = url;
        this.readTxt();
        this.readDatabase();
    }

    public clientHr() {
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
//        this.url = url;
//        this.readTxt();
        this.readDatabase();
    }

    public void selectStudent() {
        for (student value : this.student.values()) {

            if (!value.isDelete) {
                value.select();
            }
        }
    }

    public int printWelcome() {

        System.out.println("====欢迎进入Hr系统！！！===");
        System.out.println("请输入对应的数字表示进行操作！");
        System.out.println("请按1进行查询学生信息操作");
        System.out.println("请按2进行查询学生教育经历信息操作");
        System.out.println("请按3进行查询学生招聘进程信息操作");
        System.out.println("请按4进行更改学生招聘进程信息操作");
        System.out.println("请按5退出程序");

        return 5;
    }

    public boolean choose(int num) {
        switch (num) {
            case 1:
                this.selectStudent();
                break;
            case 2:
                this.selectEducation();
                break;
            case 3:
                this.selectEvent();
                break;
            case 4:
                this.alterEvent();
                break;
            case 5:
//                this.writeTxt();
                this.saveToDatabase();
                System.out.println("程序结束！！！感谢使用。");
                return true;
        }

        return false;
    }

    private void alterEvent() {
        try {

            System.out.println("请输入要更正的信息类别");
            Scanner info = new Scanner(System.in);
            String infoString = info.nextLine();
            if (infoString.equals("手机号")) {
                System.out.println("身份证为不可修改信息！请重新输入");
                this.alterEvent();
            } else {
                System.out.println("请按手机号、更正信息输入要更正的信息");
                String[] infoInput = info.nextLine().split(" ");
//                self.student[phoneNumber].event[string] = info
                this.student.get(infoInput[0]).event.put(infoString, infoInput[1]);
//                获取学生
//                通过反射,找到对应的属性，给属性赋值

                System.out.println("更改成功");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("输入结构出错，请重新输入");
            this.alterEvent();
//            谭强 151645644 18398260508 男 1996 22 本科 川农 教师 10000
//            唐家鑫 511902199801011118 17781606563 男 1977 22 本科 村内 数据 10000
        }
    }

    private void selectEvent() {
        try {
            System.out.println("请输入要查询学生的手机号");
            Scanner info = new Scanner(System.in);
            String phoneNumber = info.nextLine();
            if (this.student.get(phoneNumber).isDelete) {
                System.out.println("输入结构或信息出错，请重新输入");
                this.selectEvent();
            } else {
                this.student.get(phoneNumber).getEvent();
                System.out.println("查询完毕！！！");
            }
        } catch (Exception e) {
            System.out.println("输入结构或信息出错，请重新输入");
            this.selectEvent();
        }
    }

    private void selectEducation() {
        try {
            System.out.println("请输入要查询学生的手机号");
            Scanner info = new Scanner(System.in);
            String phoneNumber = info.nextLine();
            if (this.student.get(phoneNumber).isDelete) {
                System.out.println("输入结构或信息出错，请重新输入");
                this.selectEducation();
            } else {
                this.student.get(phoneNumber).getEducation();
                System.out.println("查询完毕！！！");
            }
        } catch (Exception e) {
            System.out.println("输入结构或信息出错，请重新输入");
            this.selectEducation();
        }
    }

    private void alterEducation() {
        this.addEducation();
    }

    private void deleteEducation() {
//        简化流程
    }

    private void addEducation() {
        try {

            System.out.println("请按照手机号、学历、毕业学校、开始时间，结束时间顺序输入");
            Scanner info = new Scanner(System.in);
            String[] infoString = info.nextLine().split(" ");
//            System.out.println(infoString);
//            System.out.println(salary);
            this.student.get(infoString[0]).setEducation(infoString[1], infoString[2], infoString[3], infoString[4]);


        } catch (Exception e) {
            System.out.println("输入结构出错，请重新输入");
            this.addEducation();

        }
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

    public void writeTxt() {
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

    public void readTxt() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.url));
            String str;
            while ((str = in.readLine()) != null) {
                String[] infoString = str.split("\t");
                this.student.put(infoString[2], new student(infoString[0], infoString[1], infoString[2],
                        infoString[3], infoString[4], infoString[5], infoString[6], infoString[7],
                        infoString[8].equals("1")));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private void readDatabase() {
        try {
            this.student = this.db.selectStudent("student", this.student);
            this.student = this.db.selectEducation("stuEducation", this.student);
            this.student = this.db.selectEvent("event", this.student);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void saveToDatabase() {
        try {
            this.db.connectDelete("stuEducation");
            this.db.connectDelete("student");
            for (student value : this.student.values()) {

                this.db.connectInsert("student", value.writeStudent());
                if (!value.writeEducation().equals("")) {
//                    System.out.println(value.writeEducation());
                    this.db.connectInsert("stuEducation", value.writeEducation());
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
