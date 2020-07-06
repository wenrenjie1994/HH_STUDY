package service;

import ioOperation.DataOperation;
import model.Resume;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @program: HR_SYS_2.0（基于txt文件）
 * @className: ResumeService
 * @description: 招聘系统提供增删改查操作
 * @author: 何文艺
 * @creat: 2020/7/6 16:08
 **/
public class ResumeService {
    public static void addResume(LinkedList<Resume> resumeLinkedList) {//添加简历
        String name, id, school;
        Scanner input = new Scanner(System.in);
        System.out.println("----------欢迎进入添加简历界面----------");
        System.out.println("请依次输入新的姓名，身份证号，学校：");
        name = input.nextLine();
        id = input.nextLine();
        school = input.nextLine();
        Resume resume = new Resume(name, id, school);
        resumeLinkedList.add(resume);
        DataOperation.saveData(resumeLinkedList);
        System.out.println("添加简历成功！");
        showResume(resumeLinkedList);
    }

    public static void deleteResume(LinkedList<Resume> resumeLinkedList) {//删除简历
        String id;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        if (resumeLinkedList.size() == 0) {
            System.out.println("系统简历库为空，删除失败！");
        } else {
            System.out.println("----------欢迎进入删除简历界面----------");
            System.out.println("请输入要删除简历的身份证号：");
            id = input.nextLine();
            Iterator<Resume> iterator = resumeLinkedList.iterator();//使用列表迭代器遍历LinkedList
            while (iterator.hasNext()) {
                Resume current = iterator.next();
                if (current.id.equals(id) && current.deleteStatus == 1) {
                    iterator.remove();
                    DataOperation.saveData(resumeLinkedList);
                    System.out.println("删除简历成功！");
                    flag = true;
                    showResume(resumeLinkedList);
                }
            }
            if (flag == false) {
                System.out.println("该简历不存在！请重新输入！");
                deleteResume(resumeLinkedList);
            }
        }
    }

    public static void updateResume(LinkedList<Resume> resumeLinkedList) {//修改简历
        String name, id, school;
        int i;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        if (resumeLinkedList.size() == 0) {
            System.out.println("系统简历库为空，修改失败！");
        } else {
            System.out.println("----------欢迎进入更新简历界面----------");
            System.out.println("请输入要修改简历的身份证号：");
            id = input.nextLine();
            for (i = 0; i < resumeLinkedList.size(); i++) {//使用for循环遍历LinkedList
                Resume current = resumeLinkedList.get(i);
                if (current.id.equals(id) && current.deleteStatus == 1) {
                    System.out.println("请依次输入新的姓名，身份证号，学校：");
                    name = input.nextLine();
                    id = input.nextLine();
                    school = input.nextLine();
                    Resume resume = new Resume(name, id, school);
                    resumeLinkedList.set(i,resume);
                    System.out.println("修改简历成功！");
                    DataOperation.saveData(resumeLinkedList);
                    flag = true;
                    showResume(resumeLinkedList);
                }
            }
            if (flag == false) {
                System.out.println("该简历不存在！请重新输入！");
                updateResume(resumeLinkedList);
            }
        }
    }

    public static void searchResume(LinkedList<Resume> resumeLinkedList) {//查找简历
        String name, id, school;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        if (resumeLinkedList.size() == 0) {
            System.out.println("系统简历库为空，查找失败！");
        } else {
            System.out.println("----------欢迎进入查询简历界面----------");
            System.out.println("请输入要查找简历的身份证号：");
            id = input.nextLine();
            ListIterator<Resume> listIterator = resumeLinkedList.listIterator();//使用列表迭代器遍历LinkedList
            while(listIterator.hasNext()){
                Resume current = listIterator.next();
                if (current.id.equals(id) && current.deleteStatus == 1) {
                    printResume(current);
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("该简历不存在！请重新输入！");
                searchResume(resumeLinkedList);
            }
        }
    }

    public static void showResume(LinkedList<Resume> resumeLinkedList) {//遍历简历
        String isShow;
        Scanner input = new Scanner(System.in);
        System.out.println("是否显示系统中的所有简历？Y or N？");
        isShow = input.nextLine();
        if (isShow.equals("Y") || isShow.equals("y")) {
            for(Resume ele : resumeLinkedList){//使用增强型for循环遍历LinkedList
                if (ele.deleteStatus == 1) {
                    printResume(ele);
                }
            }
        }
    }

    public static void printResume(Resume current) {//打印简历
        System.out.println("名称：" + current.name +
                "\t身份证号：" + current.id +
                "\t学校：" + current.school +
                "\t简历状态：" + current.process);
    }
}
