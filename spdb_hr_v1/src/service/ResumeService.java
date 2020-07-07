package service;

import bean.Resume;

import java.util.LinkedList;
import java.util.Scanner;


public class ResumeService {
    /**
     * 查看简历
     * @param resumeList
     */
    public static void showResume(LinkedList<Resume> resumeList){
        System.out.println("是否打印全部图书（y/n）:");
        Scanner sc = new Scanner(System.in);
        String index = sc.next();
        if(index.equals("y")){
            System.out.println("共有简历"+resumeList.size()+"份");
            for(int i=0;i<resumeList.size();i++){
                System.out.println("No."+(i+1)+":"+resumeList.get(i).getId()+','+resumeList.get(i).getName()+','+resumeList.get(i).getSchool()+','+resumeList.get(i).getProcess()+','+resumeList.get(i).getDeleteStatus());
            }
        }
    }

    /**
     * 按照ID查询简历
     * @param resumeList
     * @param id
     * @return
     */
    public static int selectResume(LinkedList<Resume> resumeList,String id){
        int remove_index = -1;
        for(int i=0;i<resumeList.size();i++){
            if(resumeList.get(i).getId().equals(id)){
                remove_index = i;
                break;
            }
        }
        return remove_index;

    }
    /**
     * 增加简历
     * @param resumeList
     */
    public static void addResume(LinkedList<Resume> resumeList){
        System.out.println("添加简历");
        Scanner sc = new Scanner(System.in);
        System.out.println("请按照身份证ID，姓名，学校添加，并以逗号隔开");
        String[] tmp = sc.nextLine().split(",");
        Resume resume = new Resume(tmp[0],tmp[1],tmp[2]);
        resumeList.add(resume);
        System.out.println("简历添加成功");
        showResume(resumeList);

    }

    /**
     * 简历删除
     * @param resumeList
     */
    public static void deleteResume(LinkedList<Resume> resumeList){
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到删除简历界面");
        System.out.println("输入需要删除的id");
        String tmp = sc.nextLine();
        int remove_index = selectResume(resumeList,tmp);
        if(remove_index>-1){
            resumeList.remove(remove_index);
            System.out.println("简历已成功删除");
        }else{
            System.out.println("没有此人简历");
        }
        showResume(resumeList);
    }

    public static void updateResume(LinkedList<Resume> resumeList){
        System.out.println("欢迎来到修改图书界面");
        System.out.println("请输入需要修改的id");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        int update_index = selectResume(resumeList,id);
        if(update_index>-1){
            System.out.println("请依次输入id,name,school,process,deleteStatus");
            String[] tmp = sc.nextLine().split(",");
            Resume newResume = new Resume(tmp[0],tmp[1],tmp[2],Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            resumeList.set(update_index,newResume);
        }else{
            System.out.println("没有此人简历");
        }
        showResume(resumeList);

    }
}
