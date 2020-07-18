package sys;

import bean.Response;
import bean.Resume;
import utils.ResumeOperate;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class HRS {
    private static ResumeOperate resumeOperate = new ResumeOperate();

    public static void main(String[] args) throws IOException {
        boolean isExitRequested = false;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("***** 欢迎进入简历管理系统 *****");
            System.out.println("添加简历：1");
            System.out.println("删除简历：2");
            System.out.println("修改简历：3");
            System.out.println("查询简历：4");
            System.out.println("退出请按：5");
            switch (sc.nextInt()) {
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
                    isExitRequested = true;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
            if (isExitRequested) {
                break;
            }
        }
        sc.close();
        System.out.println("已退出！");
    }

    /**
     * 添加简历
     */
    private static void addResume() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 添加简历(请依次输入姓名、身份证号、学校) *****");
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        Resume resume = new Resume(name, id, school);
        Response response = resumeOperate.addResume(resume);
        if (response.isSuccess()) System.out.println("已添加！" + response);
        else System.out.println("添加失败！");
    }

    /**
     * 删除简历
     */
    private static void deleteResume() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 删除简历(请输入身份证号) *****");
        String id = input.nextLine();
        Resume resume = new Resume(null, id, null);
        Response response = resumeOperate.deleteResume(resume);
        if (response.isSuccess()) System.out.println("已删除！" + response);
        else System.out.println("没有找到您想要删除的简历！");
    }

    /**
     * 更新简历
     */
    private static void updateResume() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 修改简历(请输入身份证号) *****");
        String id = input.nextLine();
        Resume oldResume = new Resume(null, id, null);
        if (resumeOperate.searchResumeById(oldResume).isSuccess()) {
            System.out.println("找到原简历（请依次输入新的姓名、身份证号、学校、简历状态）");
            String newName = input.nextLine();
            String newID = input.nextLine();
            String newSchool = input.nextLine();
            int newProcess = input.nextInt();
            Resume newResume = new Resume(newName, newID, newSchool);
            newResume.setProcess(newProcess);
            Response response = resumeOperate.updateResume(newResume, oldResume);
            System.out.println("已更新！" + response);
        } else System.out.println("没有找到您想要修改的简历！");
    }

    /**
     * 查找简历
     */
    private static void searchResume() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean isExitRequested = false;
        while (true) {
            System.out.println("***** 查找简历(按姓名查找：1；按身份证号查找：2；退出：3) *****");
            switch (sc.nextInt()) {
                case 1:
                    searchResumeByName();
                    break;
                case 2:
                    searchResumeById();
                    break;
                case 3:
                    isExitRequested = true;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
            if (isExitRequested) {
                break;
            }
        }
        System.out.println("已退出简历查找系统！");
    }

    private static void searchResumeByName() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 查找简历(请输入姓名) *****");
        String name = input.nextLine();
        Resume resume = new Resume(name, null, null);
        Response response = resumeOperate.searchResumeByName(resume);
        if (response.isSuccess()) {
            LinkedList<Resume> resumes = (LinkedList<Resume>) response.getData();
            System.out.println("通过姓名共查到" + resumes.size() + "份简历！");
            for (Resume r : resumes) {
                System.out.println(r);
            }
        } else System.out.println("没有查找到相应简历！");
    }

    private static void searchResumeById() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 查找简历(请输入身份证号) *****");
        String id = input.nextLine();
        Resume resume = new Resume(null, id, null);
        Response response = resumeOperate.searchResumeById(resume);
        if (response.isSuccess()) {
            LinkedList<Resume> resumes = (LinkedList<Resume>) response.getData();
            System.out.println("通过身份证号共查到" + resumes.size() + "份简历！");
            for (Resume r : resumes) {
                System.out.println(r);
            }
        } else System.out.println("没有查找到相应简历！");
    }
}
