package service;

import model.Resume;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 熊彩铃
 * @program HR_Version2
 * @description 增加、删除、修改、查找、展示简历的服务
 * @date 2020/7/6 0:19
 */
public class ResumeService {
    /**
     * 增加简历信息方法
     * */
    public void addResume(LinkedList<Resume> resumeList){
        System.out.println("*****欢迎进入增加简历信息页面*****");
        System.out.println("请依次输入姓名、身份证号码、学校、年龄");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String ID_number = input.nextLine();
        String school = input.nextLine();
        Integer age = input.nextInt();
        Resume resume = new Resume(name,ID_number,school,age);
        resumeList.add(resume);
        System.out.println("添加简历成功");
        show(resumeList);
    }
    /**
     * 根据姓名删除简历信息
     * */
    public void deleteResume(LinkedList<Resume> resumeLinkedList){
        System.out.println("*****欢迎进入删除简历信息页面*****");
        System.out.println("请输入待删除简历所属者的姓名");
        Scanner input= new Scanner(System.in);
        String name = input.nextLine();
        for(int i=0;i<resumeLinkedList.size();i++){
            if(resumeLinkedList.get(i).getName().equals(name)){
                resumeLinkedList.remove(i);
                System.out.println("删除简历信息成功");
                break;
            }else if(i==resumeLinkedList.size()-1){
                System.out.println("未找到符合条件的简历，无法删除");
            }
        }
        show(resumeLinkedList);
    }
    /**
     * 根据姓名修改简历信息
     * */
    public void modifyResume(LinkedList<Resume> resumeLinkedList){
        System.out.println("欢迎进入修改简历信息页面");
        System.out.println("请输入待修改简历所属者的姓名");
        System.out.println("请输入姓名、身份证号码、学校、年龄");
        Scanner input = new Scanner(System.in);
        String oldName = input.nextLine();
        String newName = input.nextLine();
        String newID_number = input.nextLine();
        String newSchool = input.nextLine();
        Integer newAge = input.nextInt();
        for(int i=0;i<resumeLinkedList.size();i++){
            if(resumeLinkedList.get(i).getName().equals(oldName)){
                resumeLinkedList.get(i).setName(newName);
                resumeLinkedList.get(i).setID_number(newID_number);
                resumeLinkedList.get(i).setSchool(newSchool);
                resumeLinkedList.get(i).setAge(newAge);
                System.out.println("修改简历信息成功");
                show(resumeLinkedList);
                break;
            }else if(i==resumeLinkedList.size()-1){
                System.out.println("未找到符合条件的简历，无法修改");
            }
        }
        show(resumeLinkedList);
    }

    /**
     * 根据姓名查找简历
     * */
    public void findResume(LinkedList<Resume> resumeLinkedList){
        System.out.println("欢迎进入查找简历信息页面");
        System.out.println("请输入待查找简历所属者的姓名");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        for(int i=0;i<resumeLinkedList.size();i++){
            if(resumeLinkedList.get(i).getName().equals(name)){
                Resume resume = resumeLinkedList.get(i);
                System.out.println("查找成功，简历信息如下：");
                System.out.println(resume.getName()+","+resume.getID_number()+","
                        +resume.getSchool()+","+resume.getAge());
                break;
            }else if(i==resumeLinkedList.size()){
                System.out.println("未找到符合条件的简历");
            }
        }
        show(resumeLinkedList);
    }

    /**
     * 展示简历信息
     * */
    private void show(LinkedList<Resume> resumeLinkedList) {
        System.out.println("本系统全部简历信息：");
        for(int i=0;i<resumeLinkedList.size();i++){
            Resume resume = resumeLinkedList.get(i);
            System.out.println(resume.getName()+","+resume.getID_number()+","
                    +resume.getSchool()+","+resume.getAge());
        }
    }
}
