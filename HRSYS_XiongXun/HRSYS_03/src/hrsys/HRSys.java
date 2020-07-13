package hrsys;

import model.Resume;
import service.ResumeService;

import java.util.List;
import java.util.Scanner;

public class HRSys {
    public static void main(String[] args) {
        new HRSys();
    }

    //获取标准输入流
    private Scanner input=new Scanner(System.in);

    HRSys(){
        boolean flag=true;
        while(flag)
        {

            System.out.println("-----欢迎进入HR管理系统-----");
            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("退出请按--------0");

            int choice=input.nextInt();
            switch (choice) {
                case 1:
                    addResume();
                    break;
                case 2:
                    deleteResume();
                    break;
                case 3:
                    break;
                case 4:
                    searchResume();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误！请重新输入：");
            }

        }
        input.close();
        System.out.println("您已经退出HR管理系统");
    }

    //添加简历
    void addResume()
    {
        System.out.println("------------欢迎进入添加简历界面----------------");
        Scanner input=new Scanner(System.in);
        System.out.println("请依次输入需要添加的简历姓名、身份证号、学校");
        String name=input.nextLine();
        String id=input.nextLine();
        String school=input.nextLine();

        Resume resume = new Resume(name,id,school);

        ResumeService resumeService = new ResumeService();
        int result = resumeService.addResume(resume);
        if (result==1){
            System.out.println("您已经成功添加该简历！");
        }else {
            System.out.println("添加失败！");
        }
        showAllResume();
    }

    //删除简历
    void deleteResume()
    {
        @SuppressWarnings("resource")//对被批注的代码元素内部的某些警告保持静默
        boolean flagDelete = true;
        while (flagDelete){
            Scanner input=new Scanner(System.in);
            System.out.println("------------欢迎进入删除简历界面----------------");
            System.out.println("按姓名删除请按----1");
            System.out.println("按身份证号码删除请按----2");
            System.out.println("退出请按----0");

            int choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.println("请输入要删除的简历的姓名：");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    deleteResumeByName(name);
                    break;
                case 2:
                    System.out.println("请输入要删除的简历的身份证号：");
                    Scanner scanner2 = new Scanner(System.in);
                    String id = scanner2.nextLine();
                    deleteResumeById(id);
                    break;
                case 0:
                    flagDelete = false;
                    break;
                default:
                    System.out.println("输入错误！请重新输入：");
            }

        }
        showAllResume();
    }

    /**
     * 通过姓名删除简历
     */
    void deleteResumeByName(String name){
        ResumeService resumeService = new ResumeService();
        int result = resumeService.deleteResumeByName(name);
        if (result==1){
            System.out.println("您已经成功删除该简历！");
        }else {
            System.out.println("删除失败！");
        }
    }
    /**
     * 通过姓名删除简历
     */
    void deleteResumeById(String id){
        ResumeService resumeService = new ResumeService();
        int result = resumeService.deleteResumeById(id);
        if (result==1){
            System.out.println("您已经成功删除该简历！");
        }else {
            System.out.println("删除失败！");
        }
    }


    //修改简历
    void updateResume()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入修改简历界面");
        System.out.println("请输入需要修改的简历姓名");
        String name=input.nextLine();

    }

    //查询简历
    void searchResume()
    {
        @SuppressWarnings("resource")//对被批注的代码元素内部的某些警告保持静默
        boolean flagSearch = true;
        while (flagSearch){
            Scanner input=new Scanner(System.in);
            System.out.println("------------欢迎进入查询简历界面----------------");
            System.out.println("按姓名查询请按----1");
            System.out.println("按身份证号码查询请按----2");
            System.out.println("按学校查询请按----3");
            System.out.println("退出请按----0");

            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("请输入要查询的简历的姓名：");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    searchResumeByName(name);
                    break;
                case 2:
                    System.out.println("请输入要查询的简历的身份证号：");
                    Scanner scanner2 = new Scanner(System.in);
                    String id = scanner2.nextLine();
                    searchResumeById(id);
                    break;
                case 3:
                    System.out.println("请输入要查询的简历的学校：");
                    Scanner scanner3 = new Scanner(System.in);
                    String school = scanner3.nextLine();
                    searchResumeBySchool(school);
                    break;
                case 0:
                    flagSearch = false;
                    break;
                default:
                    System.out.println("输入错误！请重新输入：");
            }

        }

    }

    void searchResumeByName(String name){
        ResumeService resumeService = new ResumeService();
        List<Resume>  resumeList = resumeService.searchResumeByName(name);
        if (resumeList.size()>0){
            resumeList.forEach(resume -> System.out.println("查询结果："+resume.getName()+","+resume.getId()+","+resume.getSchool()));
        }else {
            System.out.println("抱歉，没有符合条件的简历信息！");
        }
    }

    void searchResumeById(String id){
        ResumeService resumeService = new ResumeService();
        List<Resume>  resumeList = resumeService.searchResumeById(id);
        if (resumeList.size()>0){
            resumeList.forEach(resume -> System.out.println("查询结果："+resume.getName()+","+resume.getId()+","+resume.getSchool()));
        }else {
            System.out.println("抱歉，没有符合条件的简历信息！");
        }
    }
    void searchResumeBySchool(String school){
        ResumeService resumeService = new ResumeService();
        List<Resume>  resumeList = resumeService.searchResumeBySchool(school);
        if (resumeList.size()>0){
            resumeList.forEach(resume -> System.out.println("查询结果："+resume.getName()+","+resume.getId()+","+resume.getSchool()));
        }else {
            System.out.println("抱歉，没有符合条件的简历信息！");
        }
    }

    //简历遍历
    void showAllResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
        String choice=input.nextLine();
        if(choice.equalsIgnoreCase("Y"))
        {
            ResumeService resumeService = new ResumeService();
            List<Resume> resumeList = resumeService.searchAllResume();
            System.out.println("全部简历：");
            resumeList.forEach(resume -> System.out.println(resume.getName()+","+resume.getId()+","+resume.getSchool()));

        }
    }
}
