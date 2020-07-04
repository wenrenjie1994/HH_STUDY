package sys;

import bean.Resume;
import bean.ResumeList;
import utils.DataOperate;

import java.util.Iterator;
import java.util.Scanner;

public class HRS {

    //ResumeList resumeList = new ResumeList();

    //添加简历
    public static void addResume(ResumeList resumeList) {

        System.out.println("欢迎进入添加简历界面");
        System.out.println("请依次输入简历需要添加的姓名，身份证，学校");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String idcard = scanner.nextLine();
        String school = scanner.nextLine();

        Resume newResume = new Resume(name,idcard,school);
        resumeList.add(newResume);
        DataOperate.saveData(resumeList);
        System.out.println("添加成功");
    }
    //删除简历
    public static void deleteResume(ResumeList resumeList) {

        System.out.println("欢迎进入删除简历界面");
        System.out.println("请输入需要删除简历的身份证");
        Scanner scanner=new Scanner(System.in);
        String id = scanner.nextLine();
        Iterator it = resumeList.iterator();
        boolean flag = true;
        while (it.hasNext()){

            Resume resume = (Resume) it.next();

            if (id.equals(resume.getId())){
                flag = false;
                resumeList.remove(resume);
                DataOperate.saveData(resumeList);
                System.out.println("删除成功");
                break;
            }
        }

        if (flag == true){
            System.out.println("没有该应聘者");
        }

    }
    //修改简历
    public static void updateResume(ResumeList resumeList) {
        System.out.println("欢迎进入修改简历界面");
        System.out.println("请输入需要修改简历的身份证");
        Scanner scanner=new Scanner(System.in);
        String id = scanner.nextLine();
        Iterator it = resumeList.iterator();
        boolean flag = true;
        while (it.hasNext()){

            Resume resume = (Resume) it.next();

            if (id.equals(resume.getId())){
                flag = false;
                System.out.println("请输入需要修改简历的姓名、身份证、学校");
                resume.setName(scanner.nextLine());
                resume.setId(scanner.nextLine());
                resume.setSchool(scanner.nextLine());
                System.out.println("修改成功");
                DataOperate.saveData(resumeList);
                break;
            }
        }
        if (flag == true){
            System.out.println("没有该应聘者");
        }
    }
    //查询简历
    public static void selectResume(ResumeList resumeList) {
        System.out.println("欢迎进入查询简历界面");
        System.out.println("请输入需要查询简历的身份证");
        Scanner scanner=new Scanner(System.in);
        String id = scanner.nextLine();
        Iterator it = resumeList.iterator();
        boolean flag = true;
        while (it.hasNext()){

            Resume resume = (Resume) it.next();

            if (id.equals(resume.getId())){
                flag = false;
                System.out.println("查询结果");
                System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
                        +" 学校："+resume.getSchool());
                break;
            }
        }
        if (flag == true){
            System.out.println("没有该应聘者");
        }
        DataOperate.saveData(resumeList);
    }





    //所有简历
    public static void showResume(ResumeList resumeList) {
        System.out.println("欢迎进入查询所有简历界面");



        Iterator it = resumeList.iterator();
        System.out.println("----------查询结果---------");
        while (it.hasNext()){

            Resume resume = (Resume) it.next();
            System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
                        +" 学校："+resume.getSchool());

        }
        System.out.println("-------------------");
        DataOperate.saveData(resumeList);
    }
}
