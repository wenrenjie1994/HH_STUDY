package sys;

/**
 * Created by IntelliJ IDEA
 * @Author LC
 * @create 2020/7/12
 */

import bean.Resume;
import operation.Action;

import java.util.ArrayList;
import java.util.Scanner;

public class Sys {


    public static void main(String[] args) {

        ArrayList<Resume> resumes = new ArrayList<>();

        Scanner input= new Scanner(System.in);


        int flag=1;
        while(flag==1) {

            System.out.println("-----欢迎来到Hr管理系统首页-----");
            System.out.println("----请按照相应的指令完成操作-----");
            System.out.println("新增简历请输入----1");
            System.out.println("查询简历请输入----2");
            System.out.println("修改信息请输入----3");
            System.out.println("办理离职请输入----4");
            System.out.println("删除简历请输入----5");
            System.out.println("退出系统请输入----6");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addResume();break;
                case 2:
                    searchResume();break;
                case 3:
                   updateResume();break;
                case 4:
                    updateDelete();break;
                case 5:
                    deleteResume();break;
                case 6:
                    flag=0;
                    break;
                default:
                    System.out.println("请输入正确的操作");

            }
        }
        input.close();
        System.out.println("您已退出Hr管理系统，感谢您的使用");

    }


        //增删查改方法


        //添加简历
        public static void addResume(){
            System.out.println("--欢迎进入简历新增界面--");
            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入简历姓名，年龄，身份证号码，毕业院校,目前工作状态，是否离职");
            String resumeName=input.nextLine();
            int age=input.nextInt();
            input.nextLine();
            String resumeId=input.nextLine();
            String resumeSchool=input.nextLine();
            int processState=input.nextInt();
            input.nextLine();
            int deleteStatus=input.nextInt();
            input.nextLine();
            Resume resume= new Resume(resumeName,age,resumeId,resumeSchool,processState,deleteStatus);

            Action a = new Action();
            int change=a.addResume(resume);
            if(change>0){
               System.out.println("您已经成功录入信息");
            }
            else{
                System.out.println("添加简历失败");

            }
            System.out.println("==================");

        }
        //查询简历
        public static void searchResume(){
            System.out.println("--欢迎进入简历查询界面--");
            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入需要查询的简历姓名");
            String resumeName=input.nextLine();
            Resume resume =new Resume(resumeName,0,null,null,0,0);
            Action s=new Action();
            ArrayList<Resume> resumes =s.searchResume(resume);
            if(resumes.size()>0){
            for(int i=0;i<resumes.size();i++) {
                Resume arr = resumes.get(i);
                    if (arr.getDeleteStatus() == 1) {
                        System.out.println("该员工已离职");
                    }
                    else{
                        System.out.println("<<员工简历>>");
                        System.out.println("姓名"+arr.getName()+"\n"+"年龄"+arr.getAge()+"\n"
                                +"身份证号"+arr.getIdCard()+"\n"+"毕业院校"+arr.getSchool()+"\n"+"目前状态"+arr.getProcessState());
                    }
                }
            }
                else {
                        System.out.println("未找到该简历信息");
                        System.out.println("=================");

            }
        }
        //修改简历
        public  static void updateResume() {
            System.out.println("--欢迎进入简历修改界面--");
            Scanner input = new Scanner(System.in);
            System.out.println("请依次输入需要修改的简历姓名和身份证号码");
            String resumeName = input.nextLine();
            String resumeId = input.nextLine();
            Resume oldResume = new Resume(resumeName, 0, resumeId, null, 0, 0);
            Action u = new Action();
            ArrayList<Resume> resumes=u.searchByNameAndId(oldResume);
            if (resumes.size() > 0) {
                for (int i = 0; i < resumes.size(); i++) {
                    Resume arr = resumes.get(i);
                    if (arr.getDeleteStatus() == 1) {
                        System.out.println("该员工已离职");
                    } else {
                        System.out.println("<<员工简历>>");
                        System.out.println("姓名" + arr.getName() + "\n" + "年龄" + arr.getAge() + "\n"
                                + "身份证号" + arr.getIdCard() + "\n" + "毕业院校" + arr.getSchool() + "\n" + "目前状态" + arr.getProcessState());
                        System.out.println("===============");
                        System.out.println("请依次输入新的简历姓名，年龄，身份证号码，毕业院校，当前状态");
                        System.out.println("提示：   \n" +
                                "     * 0：已申请\n" +
                                "     * 1：简历通过\n" +
                                "     * 2：笔试通过\n" +
                                "     * 3：体检通过\n" +
                                "     * 4：背调通过\n" +
                                "     * 5：已签约\n" +
                                "     * 6：已入职\n" +
                                "     ");
                        String newresumeName = input.nextLine();
                        int newage = input.nextInt();
                        input.nextLine();
                        String newresumeId = input.nextLine();
                        String newresumeSchool = input.nextLine();
                        int newresumeState = input.nextInt();
                        input.nextLine();
                        int newwdelete = input.nextInt();
                        input.nextLine();
                        Resume resume = new Resume(newresumeName, newage, newresumeId, newresumeSchool, newresumeState, newwdelete);
                        int change=u.updateResume(resume,oldResume);
                        if (change>0){
                        System.out.println("您已经修改成功！");}
                        else {
                        System.out.println("================");
                        }
                    }
//

                }
            } else {
                System.out.println("未找到该简历信息");
                System.out.println("=================");

            }
        }



        //逻辑删除，整一个离职功能
        public  static void updateDelete() {
            System.out.println("--欢迎进入离职手续办理界面--");
            Scanner input = new Scanner(System.in);
            System.out.println("请依次输入需要办理离职的简历姓名和身份证号码");
            String resumeName = input.nextLine();
            String resumeId = input.nextLine();
            Resume oldResume = new Resume(resumeName, 0, resumeId, null, 0, 0);
            Action ud = new Action();
            ArrayList<Resume> resumes = ud.searchByNameAndId(oldResume);
            if (resumes.size() > 0) {
                for (int i = 0; i < resumes.size(); i++) {
                    Resume arr = resumes.get(i);
                    if (arr.getDeleteStatus() == 1) {
                        System.out.println("该员工已离职");
                    } else {
                        System.out.println("<<员工简历>>");
                        System.out.println("姓名" + arr.getName() + "\n" + "年龄" + arr.getAge() + "\n"
                                + "身份证号" + arr.getIdCard() + "\n" + "毕业院校" + arr.getSchool() + "\n" + "目前状态" + arr.getProcessState());
                        System.out.println("===============");
                        System.out.println("请确认为该员工办理离职请输入1|0");
                        int choice = input.nextInt();
                        if (choice == 1) {
                            System.out.println("===============");
                            System.out.println("确认办理。。。");
                            int newdeleteState = 1;
                            arr.setDeleteStatus(newdeleteState);
                            int change = ud.upadeteDelete(arr);
                            if (change > 0) {
                                System.out.println("该员工已离职");
                            } else {
                                System.out.println("离职失败");
                            }

                        } else {
                            System.out.println("已否认办理离职");
                        }


                    }
                }

            }
        }
            //删除简历
            public static void deleteResume(){
                System.out.println("--欢迎进入简历删除界面--");
                Scanner input = new Scanner(System.in);
                System.out.println("请依次输入需要删除的简历姓名和身份证号码");
                String resumeName = input.nextLine();
                String resumeId = input.nextLine();
                Resume resume =new Resume(resumeName,0,resumeId,null,0,0);
                Action d=new Action();
                ArrayList<Resume> resumes=d.searchByNameAndId(resume);
                if(resumes.size()>0){
                    for(int i=0;i<resumes.size();i++) {
                        Resume arr = resumes.get(i);
                        if (arr.getDeleteStatus() == 1) {
                            System.out.println("该员工已离职");
                        }
                        else{
                            System.out.println("<<员工简历>>");
                            System.out.println("姓名"+arr.getName()+"\n"+"年龄"+arr.getAge()+"\n"
                                    +"身份证号"+arr.getIdCard()+"\n"+"毕业院校"+arr.getSchool()+"\n"+"目前状态"+arr.getProcessState());
                            int change=d.deleteResumeByNameAndId(resume);
                            if(change>0){
                                System.out.println("成功删除简历！");
                            }
                            else{
                                System.out.println("删除简历失败");
                            }
                        }
                    }
                }
                else {
                    System.out.println("未找到该简历信息");
                    System.out.println("=================");

                }int change =d.deleteResumeByNameAndId(resume);
            }
}





