package service;

import java.util.LinkedList;
import java.util.Scanner;
import model.Resume;

/**
 * @Author: chenlei
 * @Date: 2020/7/12 18:16
 */
public class ResumeService {
    private static LinkedList<Resume> resumeList;
    private FileService fileService;
    public ResumeService(FileService fileService) {
        this.fileService = fileService;
        resumeList = fileService.readFile();
    }

    public void run() {
        System.out.println("欢迎使用HR系统");
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        while (flag) {
            System.out.println("增加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("查询所有简历请按--5");
            System.out.println("退出请按--------0");
            int choice = scanner.nextInt();

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
                    showAllResume();
                    break;
                case 0:
                    fileService.writeFile(resumeList);
                    System.out.println("good bye");
                    flag = false;
                    break;
                default:
                    System.out.println("请输入正确的选项");
            }
        }
        scanner.close();
    }

    void addResume() {
        Resume resume = buildResume();
        Resume exitResume = findResume(resume.getName());
        if(exitResume != null) {
            System.out.println("您好，" + resume.getName() + "已经存在一份简历，请不要重复添加");
        }else{
            resumeList.add(resume);
            System.out.println("您好，" + resume.getName() + "的简历添加成功");
        }
    }
    void deleteResume(){
        System.out.println("请输入您要删除简历的姓名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Resume resume = findResume(name);
        if(resume != null) {
            resumeList.remove(resume);
            System.out.println(name + "的简历已经删除");
        }else{
            System.out.println("" + name + "的简历不存在");
        }
    }
    void updateResume(){
        System.out.println("请输入您要修改简历的姓名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Resume resume = findResume(name);
        if(resume != null) {
            System.out.println(name + "的简历已经找到");
            System.out.println("原简历信息为" + resume.toString());
            Resume newResume = buildResume();
            if(findResume(newResume.getName()) != null && !newResume.getName().equals(name)) {
                System.out.println("您输入的姓名已经存在，请检查后输入");
            }else {
                copy(newResume,resume);
                System.out.println("信息更新成功");
            }
        }else{
            System.out.println("未能找到" + name + "的简历");
        }
    }
    void showAllResume(){
        if(resumeList.size() != 0) {
            for(Resume resume : resumeList) {
                System.out.println(resume.toString());
            }
        }else{
            System.out.println("简历库中没有简历");
        }
    }

    void searchResume(){
        System.out.println("请输入您想要查询的简历姓名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Resume resume = findResume(name);
        if(resume != null) {
            System.out.println("已经找到" + name + "的简历，信息如下：");
            System.out.println(resume.toString());
        }else{
            System.out.println(name + "的简历不存在");
        }
    }
    private Resume findResume(String name) {
        for(Resume resume : resumeList) {
            if(resume.getName().equals(name)) {
                return resume;
            }
        }
        return null;
    }

    private Resume buildResume() {
        System.out.println("请依次输入姓名、职业、年龄");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String job = scanner.nextLine();
        Integer year = scanner.nextInt();
        Resume resume = new Resume(name,year,job);
        return resume;
    }
    private void  copy(Resume from, Resume to) {
        if(from!= null && to!= null) {
            to.setName(from.getName());
            to.setJob(from.getJob());
            to.setYear(from.getYear());
        }
    }
}
