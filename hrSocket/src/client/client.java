package client;

import database.dbConnection;
import student.student;

import java.io.*;
import java.lang.reflect.Field;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class client extends Thread {


    Map<String, student> student = new HashMap<String, student>();
    Map<String, String> info = new HashMap<String, String>();
    String url;
    dbConnection db = new dbConnection();
    int max = 10;
    char[] cbuf= new char[1024];
    Socket conn = new Socket();

    public client(String url) {
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

    public client() {
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

    public client(Socket conn) {
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
        this.conn = conn;
    }

    public void addStudent() {
        /*增加学生*/
        try {

            conn.getOutputStream().write(
                    ("请按照姓名、身份证号、手机号，性别、出生日期、年龄、应聘岗位、期望薪资顺序输入").getBytes(StandardCharsets.UTF_8));
            conn.getOutputStream().flush();
            InputStreamReader info = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
            String[] infoString = info.toString().split(" ");
            String name = infoString[0];

            String IDcard = infoString[1];
            String phoneNumber = infoString[2];
            String gender = infoString[3];
            String birthday = infoString[4];

            String school = infoString[5];
            String job = infoString[6];
            String salary = infoString[7];
//            System.out.println(infoString);
//            System.out.println(salary);
            if (this.student.containsKey(phoneNumber)) {
                conn.getOutputStream().write(
                        ("-此手机号已经存在，请添加不同手机号号同学").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
//                System.out.println("此手机号已经存在，请添加不同手机号号同学");
                this.addStudent();
            } else {

                this.student.put(phoneNumber, new student(name, IDcard, phoneNumber,
                        gender, birthday, school, job, salary));
                conn.getOutputStream().write(
                        ("-添加成功!!!").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
                info.close();
//                System.out.println("添加成功!!!");
            }

        } catch (Exception e) {
            try {
                conn.getOutputStream().write(
                        ("-输入结构出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
//            System.out.println("输入结构出错，请重新输入");
            this.addStudent();

        }
    }

    public void deleteStudent() {
        /*删除学生*/
        try {
            conn.getOutputStream().write(
                    ("请输入要删除学生的手机号").getBytes(StandardCharsets.UTF_8));
            conn.getOutputStream().flush();
            InputStreamReader info = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);

            String phoneNumber = info.toString();
            if (this.student.get(phoneNumber).isDelete) {
                conn.getOutputStream().write(
                        ("-输入结构出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
                this.deleteStudent();
            } else {
                this.student.get(phoneNumber).isDelete = true;

                conn.getOutputStream().write(
                        ("-删除成功").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
                info.close();
//                System.out.println("删除成功");
            }
        } catch (Exception e) {
            try {
                conn.getOutputStream().write(
                        ("-输入结构出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            this.deleteStudent();

        }
    }

    public void alterStudent() {
        /*删除学生*/
        try {
            conn.getOutputStream().write(
                    ("请输入要更正的信息类别").getBytes(StandardCharsets.UTF_8));
            conn.getOutputStream().flush();
            InputStreamReader info = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);

            String infoString = info.toString();
            if (infoString.equals("手机号")) {
                conn.getOutputStream().write(
                        ("-手机号为不可修改信息！请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
//                System.out.println("身份证为不可修改信息！请重新输入");
                this.alterStudent();
            } else {
                conn.getOutputStream().write(
                        ("-请按手机号、更正信息输入要更正的信息").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
//                System.out.println("请按手机号、更正信息输入要更正的信息");
                info = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);

                String[] infoInput = info.toString().split(" ");
//                获取学生
//                通过反射,找到对应的属性，给属性赋值
//                System.out.println(this.student.get(infoInput[0]));
                Field name = this.student.get(infoInput[0]).getClass().getDeclaredField(this.info.get(infoString));
                name.setAccessible(true);

//                System.out.println(infoInput[0]);
                name.set(student.get(infoInput[0]), infoInput[1]);
                conn.getOutputStream().write(
                        ("-更改成功").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
                info.close();
//              System.out.println("更改成功");

            }
        } catch (Exception e) {
            try {
                conn.getOutputStream().write(
                        ("-输入结构出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println(e);
//            System.out.println("输入结构出错，请重新输入");
            this.alterStudent();
        }
    }


    public void selectStudent() {
        try {
            conn.getOutputStream().write(
                    ("请输入要查询学生的手机号").getBytes(StandardCharsets.UTF_8));
            conn.getOutputStream().flush();
            InputStreamReader info = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
            String phoneNumber = info.toString();
            if (this.student.get(phoneNumber).isDelete) {
                conn.getOutputStream().write(
                        ("-输入结构或信息出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
//                System.out.println("输入结构或信息出错，请重新输入");
                this.selectStudent();
            } else {
                conn.getOutputStream().write(
                        ("-" + this.student.get(phoneNumber).select()).getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
//this.student.get(phoneNumber).select();
                conn.getOutputStream().write(
                        ("-查询完毕！！！").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
                info.close();
//              System.out.println("查询完毕！！！");
            }
        } catch (Exception e) {
            try {
                conn.getOutputStream().write(
                        ("-输入结构或信息出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            this.selectStudent();
        }
    }

    public String printWelcome() {
//        System.out.println("====欢迎进入Hr系统！！！===");
//        System.out.println("请输入对应的数字表示进行操作！");
//        System.out.println("请按1进行增加学生基本信息操作");
//        System.out.println("请按2进行删除学生信息操作");
//        System.out.println("请按3进行更改学生基本信息操作");
//        System.out.println("请按4进行增加学生教育经历信息操作");
//        System.out.println("请按5进行删除学生教育经历信息操作");
//        System.out.println("请按6进行更改学生教育经历信息操作");
//        System.out.println("请按7进行查询学生信息操作");
//        System.out.println("请按8进行查询学生教育经历信息操作");
//        System.out.println("请按9进行查询学生招聘进程信息操作");
//        System.out.println("请按10退出程序");

        return "====欢迎进入Hr系统--学生界面！！！===\n" + "请输入对应的数字表示进行操作！\n" +
                "请按1进行增加学生信息操作\n" + "请按2进行删除学生基本信息操作\n" +
                "请按3进行更改学生基本信息操作\n" + "请按4进行增加学生教育经历信息操作\n" +
                "请按5进行删除学生教育经历信息操作\n" + "请按6进行更改学生教育经历信息操作\n" +
                "请按7进行查询学生信息操作\n" + "请按8进行查询学生教育经历信息操作\n" +
                "请按9进行查询学生招聘进程信息操作\n" + "请按10退出程序";
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
                this.addEducation();
                break;
            case 5:
                this.deleteEducation();
                break;
            case 6:
                this.alterEducation();
                break;
            case 7:
                this.selectStudent();
                break;
            case 8:
                this.selectEducation();
                break;
            case 9:
                this.selectEvent();
                break;
            case 10:
//                this.writeTxt();
                this.saveToDatabase();
//                System.out.println("程序结束！！！感谢使用。");
                try {
                    conn.getOutputStream().write(("程序结束！！！感谢使用。").getBytes(StandardCharsets.UTF_8));
                    conn.getOutputStream().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
        }

        return false;
    }

    private void selectEvent() {
        try {
            conn.getOutputStream().write(
                    ("请输入要查询学生的手机号").getBytes(StandardCharsets.UTF_8));
            conn.getOutputStream().flush();
            InputStreamReader info = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);

            String phoneNumber = info.toString();
            if (this.student.get(phoneNumber).isDelete) {
                conn.getOutputStream().write(
                        ("-输入结构或信息出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
                this.selectEvent();
            } else {
                conn.getOutputStream().write(
                        ("-" + this.student.get(phoneNumber).getEvent()).getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();

                conn.getOutputStream().write(
                        ("-查询完毕！！！").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
                info.close();
            }
        } catch (Exception e) {
            try {
                conn.getOutputStream().write(
                        ("-输入结构或信息出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            this.selectEvent();
        }
    }

    private void selectEducation() {
        try {
            conn.getOutputStream().write(
                    ("请输入要查询学生的手机号").getBytes(StandardCharsets.UTF_8));
            conn.getOutputStream().flush();
            InputStreamReader info = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);

            String phoneNumber = info.toString();
            if (this.student.get(phoneNumber).isDelete) {
                conn.getOutputStream().write(
                        ("-输入结构或信息出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
                this.selectEducation();
            } else {
                conn.getOutputStream().write(
                        ("-" + this.student.get(phoneNumber).getEducation()).getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();

                conn.getOutputStream().write(
                        ("-查询完毕！！！").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
                info.close();
            }
        } catch (Exception e) {
            try {
                conn.getOutputStream().write(
                        ("-输入结构或信息出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
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
            conn.getOutputStream().write(
                    ("请按照手机号、学历、毕业学校、开始时间，结束时间顺序输入").getBytes(StandardCharsets.UTF_8));
            conn.getOutputStream().flush();
            InputStreamReader info = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
            String[] infoString = info.toString().split(" ");
//            System.out.println(infoString);
//            System.out.println(salary);
            this.student.get(infoString[0]).setEducation(infoString[1], infoString[2], infoString[3], infoString[4]);
            conn.getOutputStream().write(
                    ("-添加成功").getBytes(StandardCharsets.UTF_8));
            conn.getOutputStream().flush();
            info.close();

        } catch (Exception e) {
            System.out.println(e);
            try {
                conn.getOutputStream().write(
                        ("-输入结构或信息出错，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            this.addEducation();

        }
    }

    public int inputNum() {
        int num;
        try {
            System.out.println(111);
            int data;
            int data1;
            while ((data=new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)).read(cbuf, 0, cbuf.length))!=-1){
                System.out.println(data);
                System.out.println(new String(cbuf,0,data));
            }
            System.out.println(new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)).readLine());
            System.out.println(555);
            num = Integer.parseInt(new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)).readLine());
            System.out.println(222);
        } catch (Exception e) {
            System.out.println(e);
            try {
                conn.getOutputStream().write(
                        ("输入非数字，请重新输入").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
            } catch (Exception e2) {
                System.out.println(e2);
            }
//            System.out.println("输入非数字，请重新输入");
            num = this.inputNum();
        }
        if (num > this.max || num < 1) {
            try {
                conn.getOutputStream().write(
                        ("请输入以上序号数字").getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println("请输入以上序号数字");
            num = this.inputNum();
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


    public void run() {
        try {
            while (true) {

                conn.getOutputStream().write((this.printWelcome()).getBytes(StandardCharsets.UTF_8));
                conn.getOutputStream().flush();
//                System.out.println(printWelcome());

                int result = this.inputNum();
                this.choose(result);
            }
        } catch (Exception e) {
            try {
                conn.getInputStream().close();
                conn.getOutputStream().close();
                conn.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
