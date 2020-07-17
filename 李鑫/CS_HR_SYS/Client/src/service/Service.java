package service;
import control.Operator;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;

import java.util.Scanner;


public class Service {

    private  Operator operator = new Operator();

    public  void addResume() {
        System.out.println("欢迎来到简历添加界面");
        System.out.println("请依次输入学生名字，学生身份证号，学生学校");

        Scanner input = new Scanner(System.in);

        String name = input.next();
        String id = input.next();
        String school = input.next();
        Resume resume = new Resume(name, id, school);

        ReturnResult returnResult = operator.addResume(resume);

        if (returnResult.isSuccess) {
            System.out.println("简历添加成功:)");
        }
        else {
            System.out.println("简历添加失败:(，失败原因：" + returnResult.failReason);
        }

    }

    // 通过名字删除简历
    public  void delResume() {
        System.out.println("欢迎来到简历删除界面");
        System.out.println("请输入需要删除的简历的学生名字");

        Scanner input = new Scanner(System.in);
        String name = input.next();

        Resume r = new Resume(name, null, null);

        ReturnResult returnResult = operator.deleteResume(r);

        if (returnResult.isSuccess) {
            System.out.println("简历删除成功:)");
        }
        else {
            System.out.println("简历删除失败:(，失败原因：" + returnResult.failReason);
        }

    }

    // 通过名字修改简历信息
    public  void updateResume() {
        System.out.println("欢迎来到简历信息修改界面");
        System.out.println("请输入需要修改的简历的学生名字");

        Scanner input = new Scanner(System.in);
        String name = input.next();

        Resume oldResume = new Resume(name, null, null);

        System.out.println("请依次输入学生名字，学生身份证号，学生学校");
        String newName = input.next();
        String newId = input.next();
        String newSchool = input.next();

        Resume newResume = new Resume(newName, newId, newSchool);

        ReturnResult returnResult = operator.updateResume(oldResume, newResume);

        if (returnResult.isSuccess) {
            System.out.println("简历修改成功:)");
        }
        else {
            System.out.println("简历修改失败:(，失败原因：" + returnResult.failReason);
        }
    }

    // 通过名字显示简历信息
    public  void showResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要显示简历信息的名字");
        String name = input.next();

        Resume resume = new Resume(name, null, null);

        ReturnResult returnResult = operator.searchResume(resume);

        if (!returnResult.isSuccess) {
            System.out.println(returnResult.failReason);
        }
        else {
            ResumeList resumeList = (ResumeList) returnResult.resultData;
            for (Resume r : resumeList) {
                System.out.println(r.getName() + "的身份证号为：" + r.getId() + "，学校为：" + r.getSchool());
            }
        }

    }

    public  void closeService(String string) {
        operator.closeNet(string);
    }
}
