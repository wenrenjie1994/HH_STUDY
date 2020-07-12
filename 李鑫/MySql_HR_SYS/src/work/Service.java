package work;
import bean.Resume;
import bean.ResumeList;

import java.util.LinkedList;
import java.util.Scanner;


public class Service {

    public static Action action = new Action();

    public static void addResume() {
        System.out.println("欢迎来到简历添加界面");
        System.out.println("请依次输入学生名字，学生身份证号，学生学校");

        Scanner input = new Scanner(System.in);
        String name = input.next();
        String id = input.next();
        String school = input.next();

        int line = action.addResume(name, id, school);

        if (line != 0) {
            System.out.println("您已成功添加图书:)");
        }
        else {
            System.out.println("添加图书失败:(");
        }
    }

    // 通过名字删除简历
    public static void delResume() {
        System.out.println("欢迎来到简历删除界面");
        System.out.println("请输入需要删除的简历的学生名字");

        Scanner input = new Scanner(System.in);
        String name = input.next();

        int line = action.deleteResume(name);

        if (line != 0) {
            System.out.println("您已成功删除" + name + "的简历:)");
        }
        else {
            System.out.println("删除简历失败:(");
        }
    }

    // 通过名字修改简历信息
    public static void updateResume() {
        System.out.println("欢迎来到简历信息修改界面");
        System.out.println("请输入需要修改的简历的学生名字");

        Scanner input = new Scanner(System.in);
        String name = input.next();

        System.out.println("请依次输入学生名字，学生身份证号，学生学校");
        String newName = input.next();
        String newId = input.next();
        String newSchool = input.next();

        int line = action.updateResume(name, newName, newId, newSchool);

        if (line != 0) {
            System.out.println("您已成功修改原名为" + name + "的简历信息:)");
        }
        else {
            System.out.println("修改失败:(");
        }
    }

    // 通过名字显示简历信息
    public static void showResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要显示简历信息的名字");
        String name = input.next();

        ResumeList resumeList = action.searchResume(name);

        int size = resumeList.size();
        if (size == 0) {
            System.out.println("暂无" + name + "的简历信息:(");
        }

        for (int i=0; i<size; i++) {
            Resume r = resumeList.get(i);
            System.out.println(r.getName() + "的身份证号为：" + r.getId() + "，学校为：" + r.getSchool());
        }
    }
}
