package Service;

import Resume.StudentInformation;
import java.util.*;


//对数据库进行增改删查的方法
public class Service {
    //增加数据
    public static void addResume(ArrayList<StudentInformation> stinfo){
        System.out.println("---------欢迎进入添加界面---------");
        System.out.println("请输入以下添加内容：");
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        System.out.println("请输入学生的id：");
        int id = sc.nextInt();
        //检查是否是重复id
        for (int i = 0; i < stinfo.size(); i++) {
            if(stinfo.get(i).getId() == id){
                System.out.println("-----该id已存在!-----");
                flag = false;
            }
        }
        //非重复id可进行赋值
        if(flag) {
            System.out.println("请输入学生的姓名：");
            String name = sc.next();
            System.out.println("请输入学生的学校：");
            String school = sc.next();
            System.out.println("请输入学生的邮箱：");
            String email = sc.next();
            //将简历信息添加到arraylist里
            StudentInformation sresume = new StudentInformation(id,name,school,email);
            stinfo.add(sresume);
            System.out.println("-----数据添加成功！-----");
        }
    }
    //修改数据
    public static void editResume(ArrayList<StudentInformation> stinfo){
        System.out.println("---------欢迎进入编辑界面---------");
        System.out.println("-----以下是所有的简历信息：-----");
        selectAll(stinfo);
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要修改的学生id：");
        int id = sc.nextInt();
        for (int i = 0; i < stinfo.size(); i++) {
            if(stinfo.get(i).getId() == id){
                System.out.println("请输入学生的新姓名：");
                String name = sc.next();
                System.out.println("请输入学生的新学校：");
                String school = sc.next();
                System.out.println("请输入学生的新邮箱：");
                String email = sc.next();
                flag = false;
                //将简历信息添加到arraylist里
                StudentInformation chooser = stinfo.get(i);
                chooser.setName(name);
                chooser.setSchool(school);
                chooser.setEmail(email);
                System.out.println("-----数据修改成功！以下是更新后的数据：-----");
                selectAll(stinfo);
                break;
            }
        }
        if (flag){
            System.out.println("-----找不到对应的简历信息！-----");
        }
    }
    //删除数据
    public static void deleteResume(ArrayList<StudentInformation> stinfo){
        System.out.println("---------欢迎进入删除界面---------");
        System.out.println("-----以下是所有的简历信息：-----");
        selectAll(stinfo);
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要删除的学生id：");
        int id = sc.nextInt();
        for (int i = 0; i < stinfo.size(); i++) {
            if(stinfo.get(i).getId() == id){
                StudentInformation chooser = stinfo.get(i);
                stinfo.remove(chooser);
                flag = false;
                //将简历信息添加到arraylist里
                System.out.println("-----数据删除成功！以下是更新后的数据：-----");
                selectAll(stinfo);
                break;
            }
        }
        if (flag){
            System.out.println("-----找不到对应的简历信息！-----");
        }
    }

    //查询数据
    public static void selectResume(ArrayList<StudentInformation> stinfo){
        System.out.println("---------欢迎进入查询界面---------");
        System.out.println("查询所有简历请按-----1");
        System.out.println("条件查询简历请按-----2");
        Scanner sc = new Scanner(System.in);
        int selectChoser = sc.nextInt();
        switch (selectChoser){
            case 1:
                selectAll(stinfo);
                break;
            case 2:
                select(stinfo);
                break;
            default:
                System.out.println("-----你的输入有误，请重新输入！-----");
        }
    }
//查询所有学生的简历
    public static void selectAll(ArrayList<StudentInformation> stinfo){
        for (int i = 0; i < stinfo.size(); i++) {
            showResume(stinfo.get(i));
        }
    }
//查询指定学生的简历
    public static void select(ArrayList<StudentInformation> stinfo){
        System.out.println("请输入想要查询的学生id：");
        Scanner sc = new Scanner(System.in);
        int sid = sc.nextInt();
        boolean flag = true;
        for (int i = 0; i < stinfo.size(); i++) {
            if(stinfo.get(i).getId() == sid){
                showResume(stinfo.get(i));
                flag = false;
            }
        }
        if (flag){
            System.out.println("-----找不到对应的简历信息！-----");
        }

    }

    public static void showResume(StudentInformation resume){
        System.out.println("身份ID：" + resume.getId() + ", 姓名：" + resume.getName() +
                ", 学校：" + resume.getSchool() +  ", email:" + resume.getEmail());
    }
}
