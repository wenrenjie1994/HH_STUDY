package sys;

import bean.Resume;

import java.util.Scanner;

public class TestHRS {

    public static void main(String[] args) {

        HRS hrs = new HRS();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("-----欢迎进入HR理系统-----");
            System.out.println("添加学生简历请按----1");
            System.out.println("删除学生简历请按----2");
            System.out.println("修改学生简历信息请按----3");
            System.out.println("查询学生简历信息请按----4");
            System.out.println("退出系统请按--------5");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("欢迎进入学生简历添加页面");
                    System.out.println("请依次输入学生简历的姓名，身份证号，学校");

                    String name1 = input.next();
                    String id = input.next();
                    String school = input.next();

                    Resume newResume = new Resume(name1, id, school);
                    hrs.addResume(newResume);
                    System.out.println("您已成功添加学生简历");
                    hrs.printResume(name1);
                    break;

                case 2:
                    System.out.println("欢迎进入删除学生简历界面");
                    System.out.println("请输入需要删除的学生简历姓名");
                    String name2 = input.next();
                    hrs.delResume(name2);
                    break;

                case 3:
                    System.out.println("欢迎进入学生简历信息修改界面");
                    System.out.println("请输入需要修改简历信息的学生名字");
                    String oriName = input.next();

                    System.out.println("请依次输入新的学生简历的姓名，身份证号，学校");
                    String newName = input.next();
                    String newId = input.next();
                    String newSchool = input.next();
                    hrs.updateResume(oriName, newName, newId, newSchool);

                    System.out.println("修改简历信息成功");
                    hrs.printResume(newName);
                    break;

                case 4:
                    System.out.println("欢迎进入查询简历信息界面");
                    System.out.println("请输入查询简历信息的学生名字");
                    String searchName = input.next();
                    hrs.printResume(searchName);
                    break;

                case 5:
                    input.close();//流啊 连接啊 这些东西 用完记得关；要么记得还（那么什么地方是需要还的，什么地方是关的）；
                    System.out.println("您已经退出简历信息管理系统");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
}

