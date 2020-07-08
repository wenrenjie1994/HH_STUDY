package service;

import model.Resume;

import java.util.ArrayList;
import java.util.Scanner;

public class ResumeSevice {
    public static void addResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("欢迎来到添加简历界面");
        System.out.println("请依次输入需要添加的简历信息:姓名，身份证号，学校，简历状态( 0:已申请,1:简历通过,2:笔试通过," +
                "3:体检通过,4:背调通过,5:已签约,6:已入职)");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        int process = Integer.parseInt(input.nextLine());
        Resume Resume = new Resume(name, id, school, process);
        resumeArrayList.add(Resume);
        System.out.println("您已成功添加简历");
    }

    public static void deleteResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("欢迎来到删除简历界面");
        System.out.println("请输入需要删除的简历姓名");
        Scanner input = new Scanner(System.in);
        String ResumeName = input.nextLine();
        int ResumeCount = resumeArrayList.size();
        for (int i = 0; i < ResumeCount; i++) {
            if (resumeArrayList.get(i).getName().equals(ResumeName)) {
                resumeArrayList.remove(i);
                System.out.println("您已成功删除简历");
                break;
            } else if (i == ResumeCount - 1) {
                System.out.println("没有查找到该简历");
            }
        }
    }


    public static void updateResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("欢迎来到修改简历界面");
        System.out.println("请输入需要修改的简历姓名");
        Scanner input = new Scanner(System.in);
        String ResumeName = input.nextLine();
        int ResumeCount = resumeArrayList.size();
        if(ResumeCount==0){
            System.out.println("没有查找到该简历");
        }
        for (int i = 0; i < ResumeCount; i++) {
            if (resumeArrayList.get(i).getName().equals(ResumeName)) {
                System.out.println("请依次输入需要添加的简历信息:姓名，身份证号，学校，简历状态( 0:已申请,1:简历通过,2:笔试通过," +
                        "3:体检通过,4:背调通过,5:已签约,6:已入职)");
                String name = input.nextLine();
                String id = input.nextLine();
                String school = input.nextLine();
                int process = Integer.parseInt(input.nextLine());
                Resume Resume = new Resume(name, id, school, process);
                resumeArrayList.set(i, Resume);
                System.out.println("您已成功修改简历信息");
            } else if (i == ResumeCount - 1 || ResumeCount == 0) {
                System.out.println("没有查找到该简历");
            }
        }
    }

    public static void showResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("本简历管理系统共有" + resumeArrayList.size() + "简历");
        int ResumeCount = resumeArrayList.size();
        for (int i = 0; i < ResumeCount; i++) {
            System.out.println("第" + (i + 1) + "份" + "---------" + resumeArrayList.get(i).getName() + " " + resumeArrayList.get(i).getId() +
                    " " + resumeArrayList.get(i).getSchool() + " " + resumeArrayList.get(i).getProcess());
        }
    }

}
