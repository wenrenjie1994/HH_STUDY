package utils;

import bean.Resume;

import java.util.LinkedList;
import java.util.Scanner;

public class ResumeOperate {
    /**
     * 添加简历
     *
     * @param resumes
     */
    public static void addResume(LinkedList<Resume> resumes) {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 添加简历(请依次输入姓名、身份证号、学校) *****");
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        Resume resume = new Resume(name, id, school);
        resumes.add(resume);
        System.out.println("已添加！");
    }

    /**
     * 删除简历
     *
     * @param resumes
     */
    public static void deleteResume(LinkedList<Resume> resumes) {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 删除简历(请输入身份证号) *****");
        String id = input.nextLine();
        if (resumes.size() == 0) {
            System.out.println("简历系统为空，没有找到该简历！");
            return;
        }
        for (Resume resume : resumes) {
            if (resume.getId().equals(id)) {
                resume.setDeleteStatus(1);
                System.out.println("已删除！");
                return;
            }
        }
        System.out.println("没有找到您想要删除的简历！");
    }

    /**
     * 修改简历
     *
     * @param resumes
     */
    public static void updateResume(LinkedList<Resume> resumes) {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 修改简历(请输入身份证号) *****");
        String id = input.nextLine();
        if (resumes.size() == 0) {
            System.out.println("简历系统为空，没有找到该简历！");
            return;
        }
        for (int i = 0; i < resumes.size(); i++) {
            if (resumes.get(i).getId().equals(id)) {
                System.out.println("找到原简历（请依次输入新的姓名、身份证号、学校、简历状态）");
                String newName = input.nextLine();
                String newID = input.nextLine();
                String newSchool = input.nextLine();
                int newProcess = input.nextInt();
                Resume resume1 = new Resume(newName, newID, newSchool);
                resume1.setProcess(newProcess);
                resumes.set(i, resume1);
                return;
            }
        }
        System.out.println("没有找到您想要修改的简历！");
    }

    /**
     * 查询简历
     *
     * @param resumes
     */
    public static void searchResume(LinkedList<Resume> resumes) {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 查找简历(请输入身份证号) *****");
        String id = input.nextLine();
        if (resumes.size() == 0) {
            System.out.println("简历系统为空，没有找到该简历！");
            return;
        }
        for (Resume resume : resumes) {
            if (resume.getId().equals(id)) {
                System.out.println("已找到简历！");
                System.out.println("姓    名：" + resume.getName());
                System.out.println("身份证号：" + resume.getId());
                System.out.println("学    校：" + resume.getSchool());
                System.out.println("简历状态：" + resume.getProcess());
                return;
            }
        }
        System.out.println("没有找到您想要查找的简历！");
    }

    /**
     * 展示简历
     *
     * @param resumes
     */
    public static void showResume(LinkedList<Resume> resumes) {
        System.out.println("本简历管理系统共有" + resumes.size() + "份简历！");
        for (Resume resume : resumes) {
            System.out.println(resume);
        }
    }
}
