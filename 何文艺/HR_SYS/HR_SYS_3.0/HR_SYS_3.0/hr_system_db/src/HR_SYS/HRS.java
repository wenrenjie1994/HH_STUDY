package HR_SYS;

import model.Resume;
import service.ResumeService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: HR_SYS_3.0（基于数据库）
 * @className: HRS
 * @description: 招聘系统
 * @author: 何文艺
 * @creat: 2020/7/12 16:26
 **/
public class HRS {
    private ArrayList<Resume> resumeArrayList;
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

    void addResume() {//添加简历
        String name, id, school;
        Scanner input = new Scanner(System.in);
        System.out.println("----------欢迎进入添加简历界面----------");
        System.out.println("请依次输入新的姓名，身份证号，学校：");
        name = input.nextLine();
        id = input.nextLine();
        school = input.nextLine();
        if (new ResumeService().addResume(new Resume(name, id, school)) > 0) {
            System.out.println("添加简历成功！");
        } else {
            System.out.println("添加简历失败！");
        }
    }

    void deleteResume() {//删除简历
        String id;
        Scanner input = new Scanner(System.in);
        ResumeService r = new ResumeService();
        System.out.println("----------欢迎进入删除简历界面----------");
        System.out.println("请输入要删除简历的身份证号：");
        id = input.nextLine();
        if (new ResumeService().deleteResume(new Resume(null, id, null)) > 0) {
            System.out.println("删除简历成功！");
        } else {
            System.out.println("该简历不存在！请重新输入！");
            deleteResume();
        }
    }

    void updateResume() {//修改简历
        String name, id, school;
        Scanner input = new Scanner(System.in);
        System.out.println("----------欢迎进入更新简历界面----------");
        System.out.println("请依次输入新的姓名，身份证号，学校：");
        name = input.nextLine();
        id = input.nextLine();
        school = input.nextLine();
        if (new ResumeService().updateResume(new Resume(name, id, school)) > 0) {
            System.out.println("修改简历成功！");
        } else {
            System.out.println("该简历不存在！请重新输入！");
            updateResume();
        }
    }

    void searchResume() {//查找简历
        int choice;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        System.out.println("----------欢迎进入查询简历界面   ----------");
        System.out.println("----------按名字查询请输入1      ----------");
        System.out.println("----------按身份证号查询请输入2  ----------");
        System.out.println("----------按学校查询请输入3      ----------");
        System.out.println("----------按简历状态查询请输入4  -----------");
        System.out.println("----------查看系统所有简历请输入5 ----------");
        choice = input.nextInt();
        resumeArrayList = new ResumeService().searchResume(choice);
        if (resumeArrayList.size() > 0) {
            showResume(resumeArrayList);
        } else {
            System.out.println("该简历不存在！请重新输入！");
            searchResume();
        }
    }

    void showResume(ArrayList<Resume> resumeArrayList) {//遍历简历
        int i;
        for (i = 0; i < resumeArrayList.size(); i++) {
            Resume current = resumeArrayList.get(i);
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
