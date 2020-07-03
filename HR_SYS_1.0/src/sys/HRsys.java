package sys;

import bean.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRsys {
    private List<Resume> resumes;
    private Scanner input;

    public HRsys(){
        init();

        while(true){
            System.out.println("-----欢迎进入菜鸡的人事管理系统-----");
            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("退出请按--------5");

            int choice = input.nextInt();
            switch (choice){
                case 1:
                    doAddResume();
                    break;
                case 2:
                    doDeleteResume();
                    break;
                case 3:
                    doUpdateResume();
                    break;
                case 4:
                    doSearchResume();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }

    private void doSearchResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎进入查询简历界面");
        System.out.println("请输入需要查询的求职者的身份证号");
        String id3 = input.nextLine();
        Resume resume = searchResume(id3);
        if(resume!= null){
            System.out.println("身份证号："+id3);
            System.out.println("姓名："+resume.getName());
            System.out.println("学校："+resume.getSchool());
            System.out.println("求职状态："+resume.getProcess());
        }else {
            System.out.println("求职者不存在！");
        }
    }

    private void doUpdateResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎进入修改简历界面");
        System.out.println("请输入需要修改的求职者的身份证号");
        String id2 = input.nextLine();
        System.out.println("请依次输入求职者的姓名，学校，求职状态");
        String name2 = input.nextLine();
        String school2 = input.nextLine();
        int process = input.nextInt();
        updateResume(id2, name2, school2, process);
    }

    private void doDeleteResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎进入删除简历界面");
        System.out.println("请输入需要删除的求职者的身份证号");
        String id1 = input.nextLine();
        deleteResume(id1);
    }

    private void doAddResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎进入添加简历界面");
        System.out.println("请依次输入求职者的身份证号，姓名，学校");
        String id = input.nextLine();
        String name = input.nextLine();
        String school = input.nextLine();
        addResume(name, school, id);
    }

    private void init(){
        resumes = new ArrayList<>();
        input = new Scanner(System.in);
    }



    private void addResume(String name, String school, String id){
        Resume resume = new Resume(name, id, school);
        resumes.add(resume);
    }

    private void deleteResume(String id){
        for(Resume resume: resumes){
            if(resume.getId().equals(id)){
                resume.setDeleteStatus(1);
            }
        }
    }

    private void updateResume(String id, String name, String school, int process){
        for(Resume resume: resumes){
            if(resume.getId().equals(id)){
                resume.setName(name);
                resume.setSchool(school);
                resume.setProcess(process);
            }
        }
    }

    private Resume searchResume(String id){
        for(Resume resume: resumes){
            if(resume.getId().equals(id)&&resume.getDeleteStatus()!=1){
                return resume;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new HRsys();
    }
}
