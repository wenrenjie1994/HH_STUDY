package HR_SYS;

import control.Operator;
import model.Resume;
import model.ResumeLinkedList;
import model.ReturnResult;

import java.util.Scanner;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:HRS
 * @description:招聘系统
 * @author: 何文艺
 * @create: 2020/7/19 14:45
 **/
public class HRS {
    private Scanner input = new Scanner(System.in);

    HRS() {
        while (true) {
            System.out.println("-------LOWEST HR SYSTEM 1.0-------");
            System.out.println("----------添加简历请输入1----------");
            System.out.println("----------删除简历请输入2----------");
            System.out.println("----------修改简历请输入3----------");
            System.out.println("----------查找简历请输入4----------");
            System.out.println("----------想要退出请输入5----------");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addResume();
                    break;
                case 2:
                    deleteResume();
                    break;
                case 3:
                    updateResume();
                    break;
                case 4:
                    searchResume();
                    break;
                case 5:
                    exitSystem();
                    break;//该break;只会退出switch语句
                default:
                    System.out.println("输入错误！");
            }
            if (choice == 5) {
                break;//如果要退出系统需要退出while循环
            }
        }
        input.close();//关闭输入流
        System.out.println("您已经退出招聘系统！");
    }

    void exitSystem() {
        //想要退出系统，则发送"bye"到服务器，关闭客户端和服务器端连接
        new Operator().CloseNet("bye");
    }

    void addResume() {//添加简历
        String name, id, school;
        Scanner input = new Scanner(System.in);
        System.out.println("----------欢迎进入添加简历界面----------");
        System.out.println("请依次输入新的姓名，身份证号，学校：");
        name = input.nextLine();
        id = input.nextLine();
        school = input.nextLine();
        Resume resume = new Resume(name, id, school);
        Operator operator = new Operator();
        ReturnResult returnResult = operator.addResume(resume);
        if (returnResult.isSuccess) {
            System.out.println("添加简历成功！");
        } else {
            System.out.println("添加简历失败！");
            System.out.println("失败原因：" + returnResult.failReason);
        }
    }

    void deleteResume() {//删除简历
        String id;
        Scanner input = new Scanner(System.in);
        System.out.println("----------欢迎进入删除简历界面----------");
        System.out.println("请输入要删除简历的身份证号：");
        id = input.nextLine();
        Resume resume = new Resume(null, id, null);
        Operator operator = new Operator();
        ReturnResult returnResult = operator.deleteResume(resume);
        if (returnResult.isSuccess) {
            System.out.println("删除简历成功！");
        } else {
            System.out.println("删除简历失败！");
            System.out.println("失败原因：" + returnResult.failReason);
        }
    }

    void updateResume() {//修改简历
        String newName, newId, newSchool, oldId;
        Scanner input1 = new Scanner(System.in);
        System.out.println("----------欢迎进入更新简历界面----------");
        System.out.println("请输入要修改简历的身份证号：");
        oldId = input1.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("请依次输入新的姓名，身份证号，学校：");
        newName = input2.nextLine();
        newId = input2.nextLine();
        newSchool = input2.nextLine();
        Resume oldResume = new Resume(null, oldId, null);
        Resume newResume = new Resume(newName, newId, newSchool);
        Operator operator = new Operator();
        ReturnResult returnResult = operator.updateResume(newResume, oldResume);
        if (returnResult.isSuccess) {
            System.out.println("修改简历成功！");
        } else {
            System.out.println("修改简历失败！");
            System.out.println("失败原因：" + returnResult.failReason);
        }
    }

    void searchResume() {//查找简历
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("----------欢迎进入查询简历界面   ----------");
        System.out.println("----------按名字查询请输入1      ----------");
        System.out.println("----------按身份证号查询请输入2  ----------");
        System.out.println("----------按学校查询请输入3      ----------");
        System.out.println("----------按简历状态查询请输入4  -----------");
        System.out.println("----------查看系统所有简历请输入5 ----------");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                searchResumeByName();
                break;
            case 2:
                searchResumeById();
                break;
            case 3:
                searchResumeBySchool();
                break;
            case 4:
                searchResumeByProcess();
                break;
            case 5:
                searchAllResume();
                break;
            default:
                System.out.println("输入错误！");
        }
    }

    void searchResumeByName() {//通过名字查找简历
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您要查询简历的名字：");
        String name = input.nextLine();
        Resume resume = new Resume(name, null, null);
        Operator operator = new Operator();
        ReturnResult returnResult = operator.searchResumeByName(resume);
        ResumeLinkedList resumeLinkedList = (ResumeLinkedList) returnResult.resultData;
        if (returnResult.isSuccess) {
            showResume(resumeLinkedList);
        } else {
            System.out.println("查找简历失败！");
            System.out.println("失败原因：" + returnResult.failReason);
        }
    }

    void searchResumeById() {//通过身份证号查找简历
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您要查询简历的身份证号：");
        String id = input.nextLine();
        Resume resume = new Resume(null, id, null);
        Operator operator = new Operator();
        ReturnResult returnResult = operator.searchResumeById(resume);
        ResumeLinkedList resumeLinkedList = (ResumeLinkedList) returnResult.resultData;
        if (returnResult.isSuccess) {
            showResume(resumeLinkedList);
        } else {
            System.out.println("查找简历失败！");
            System.out.println("失败原因：" + returnResult.failReason);
        }
    }

    void searchResumeBySchool() {//通过学校查找简历
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您要查询简历的学校：");
        String school = input.nextLine();
        Resume resume = new Resume(null, null, school);
        Operator operator = new Operator();
        ReturnResult returnResult = operator.searchResumeBySchool(resume);
        ResumeLinkedList resumeLinkedList = (ResumeLinkedList) returnResult.resultData;
        if (returnResult.isSuccess) {
            showResume(resumeLinkedList);
        } else {
            System.out.println("查找简历失败！");
            System.out.println("失败原因：" + returnResult.failReason);
        }
    }

    void searchResumeByProcess() {//通过简历状态查找简历
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您要查询简历的状态：");
        int process = input.nextInt();
        Resume resume = new Resume(null, null, null, process, 0);
        Operator operator = new Operator();
        ReturnResult returnResult = operator.searchResumeByProcess(resume);
        ResumeLinkedList resumeLinkedList = (ResumeLinkedList) returnResult.resultData;
        if (returnResult.isSuccess) {
            showResume(resumeLinkedList);
        } else {
            System.out.println("查找简历失败！");
            System.out.println("失败原因：" + returnResult.failReason);
        }
    }

    void searchAllResume() {//查找所有简历
        Operator operator = new Operator();
        ReturnResult returnResult = operator.searchAllResume();
        ResumeLinkedList resumeLinkedList = (ResumeLinkedList) returnResult.resultData;
        if (returnResult.isSuccess) {
            showResume(resumeLinkedList);
        } else {
            System.out.println("查找简历失败！");
            System.out.println("失败原因：" + returnResult.failReason);
        }
    }

    void showResume(ResumeLinkedList resumeLinkedList) {//遍历简历
        int i;
        for (i = 0; i < resumeLinkedList.size(); i++) {
            Resume current = resumeLinkedList.get(i);
            if (current.deleteStatus == 1) {
                printResume(current);
            }
        }
    }

    void printResume(Resume current) {//打印简历
        System.out.println("名称：" + current.name +
                "\t身份证号：" + current.id +
                "\t学校：" + current.school +
                "\t简历状态：" + current.process);
    }

    public static void main(String[] args) {
        new HRS();
    }
}
