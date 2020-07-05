package sys;

import bean.Resume;

import java.util.ArrayList;
import java.util.Scanner;

public class HRS {
    private ArrayList<Resume> resumeArrayList = new ArrayList<Resume>();//存储简历的数组
    private Scanner input = new Scanner(System.in);//获取标准输入流
    private int resumeCount = 0;//物理删除仅仅只是将删除状态deleteStatus改为0，该变量存储deleteStatus为1的简历总数

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
        Resume resume = new Resume(name, id, school);
        resumeArrayList.add(resume);
        resumeCount++;
        System.out.println("添加简历成功！");
        showResume();
    }

    void deleteResume() {//删除简历
        String id;
        int i;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        if (resumeCount == 0) {
            System.out.println("系统简历库为空，删除失败！");
        } else {
            System.out.println("----------欢迎进入删除简历界面----------");
            System.out.println("请输入要删除简历的身份证号：");
            id = input.nextLine();
            for (i = 0; i < resumeArrayList.size(); i++) {
                Resume current = resumeArrayList.get(i);
                if (current.getId().equals(id) && current.getDeleteStatus() == 1) {
                    current.setDeleteStatus(0);
                    resumeCount--;
                    flag = true;
                    System.out.println("删除简历成功！");
                    showResume();
                }
            }
            if (i >= resumeArrayList.size() && flag == false) {
                System.out.println("该简历不存在！请重新输入！");
                deleteResume();
            }
        }
    }

    void updateResume() {//修改简历
        String name, id, school;
        int i;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        if (resumeCount == 0) {
            System.out.println("系统简历库为空，修改失败！");
        } else {
            System.out.println("----------欢迎进入更新简历界面----------");
            System.out.println("请输入要修改简历的身份证号：");
            id = input.nextLine();
            for (i = 0; i < resumeArrayList.size(); i++) {
                Resume current = resumeArrayList.get(i);
                if (current.getId().equals(id) && current.getDeleteStatus() == 1) {
                    System.out.println("请依次输入新的姓名，身份证号，学校：");
                    name = input.nextLine();
                    id = input.nextLine();
                    school = input.nextLine();
                    Resume resume = new Resume(name, id, school);
                    resumeArrayList.set(i,resume);
                    System.out.println("修改简历成功！");
                    flag = true;
                    showResume();
                }
            }
            if (i >= resumeArrayList.size() && flag == false) {
                System.out.println("该简历不存在！请重新输入！");
                updateResume();
            }
        }
    }

    void searchResume() {//查找简历
        String name, id, school;
        int i;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        if (resumeCount == 0) {
            System.out.println("系统简历库为空，查找失败！");
        } else {
            System.out.println("----------欢迎进入查询简历界面----------");
            System.out.println("请输入要查找简历的身份证号：");
            id = input.nextLine();
            for (i = 0; i < resumeArrayList.size(); i++) {
                Resume current = resumeArrayList.get(i);
                if (current.getId().equals(id) && current.getDeleteStatus() == 1) {
                    printResume(current);
                    flag = true;
                }
            }
            if (i >= resumeArrayList.size() && flag == false) {
                System.out.println("该简历不存在！请重新输入！");
                searchResume();
            }
        }
    }

    void showResume() {//遍历简历
        int i;
        String isShow;
        Scanner input = new Scanner(System.in);
        System.out.println("是否显示系统中的所有简历？Y or N？");
        isShow = input.nextLine();
        if (isShow.equals("Y") || isShow.equals("y")) {
            for (i = 0; i < resumeArrayList.size(); i++) {
                Resume current = resumeArrayList.get(i);
                if (current.getDeleteStatus() == 1) {
                    printResume(current);
                }
            }
        }
    }

    void printResume(Resume current) {
        System.out.println("名称：" + current.getName() +
                "\t身份证号：" + current.getId() +
                "\t学校：" + current.getSchool() +
                "\t简历状态：" + current.getProcess());
    }

    public static void main(String[] args) {
        new HRS();
    }
}
