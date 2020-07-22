package Service;

import bean.Resume;

import java.util.ArrayList;
import java.util.Scanner;

public class HrService {

    //增删查改方法


    //添加简历
   public static void addResume(ArrayList<Resume> resumes){
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
//        int resumeState=input.nextInt();

        Resume resume= new Resume(resumeName,age,resumeId,resumeSchool,processState,deleteStatus);
        System.out.println("您已经成功录入信息");
        System.out.println("==================");

        resumes.add(resume);

    }
    //查询简历
    public static void searchResume(ArrayList<Resume> resumes){
        System.out.println("--欢迎进入简历查询界面--");
        Scanner input=new Scanner(System.in);
        System.out.println("请依次输入需要查询的简历姓名");
        String resumeName=input.nextLine();
        for(int n=1;n<=resumes.size();n++) {
            int i=n-1;
            Resume arr = resumes.get(i);
            if (arr.getName().equals(resumeName)) {
                if (arr.getDeleteStatus() == 1) {
                    System.out.println("该员工已离职");
                }
                else{
                    System.out.println("<<员工简历>>");
                    System.out.println("姓名"+arr.getName()+"\n"+"年龄"+arr.getAge()+"\n"
                            +"身份证号"+arr.getIdCard()+"\n"+"毕业院校"+arr.getSchool()+"\n"+"目前状态"+arr.getProcessState());
                }
            }
            else if(!(arr.getName().equals(resumeName))){
                if(n==resumes.size()){
                    System.out.println("未找到该简历信息");
                    System.out.println("=================");
                }
            }
        }
    }
    //修改简历
    public static void updateResume(ArrayList<Resume> resumes){
        System.out.println("--欢迎进入简历修改界面--");
        Scanner input=new Scanner(System.in);
        System.out.println("请依次输入需要修改的简历姓名和身份证号码");
        String resumeName=input.nextLine();
        String resumeId=input.nextLine();
        for(int n=1;n<=resumes.size();n++) {
            int i=n-1;
            Resume arr = resumes.get(i);
            if (arr.getName().equals(resumeName)&&arr.getIdCard().equals(resumeId)) {
                if (arr.getDeleteStatus() == 1) {
                    System.out.println("该员工已离职，无法修改");
                }
                else{
                    System.out.println("<<员工简历>>");
                    System.out.println("姓名"+arr.getName()+"\n"+"年龄"+arr.getAge()+"\n"
                            +"身份证号"+arr.getIdCard()+"\n"+"毕业院校"+arr.getSchool()+"\n"+"目前状态"+arr.getProcessState());
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
                    String newresumeName=input.nextLine();
                    int newage=input.nextInt();
                    input.nextLine();
                    String newresumeId=input.nextLine();
                    String newresumeSchool=input.nextLine();
                    int newresumeState=input.nextInt();
                    input.nextLine();
                    int newwdelete=input.nextInt();
                    input.nextLine();
                    Resume resume=new Resume(newresumeName,newage,newresumeId,newresumeSchool,newresumeState,newwdelete);
                    resumes.set(i,resume);
                    System.out.println("您已经修改成功！");
                    System.out.println("================");
                }
//                System.out.println("520");
            }
            else if((n==resumes.size())){
                    System.out.println("未找到该简历信息");
                    System.out.println("=================");

            }
        }
    }

    //逻辑删除，整一个离职功能
    public static void deleteResume(ArrayList<Resume> resumes) {
        System.out.println("--欢迎进入离职手续办理界面--");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要办理离职的简历姓名和身份证号码");
        String resumeName = input.nextLine();
        String resumeId = input.nextLine();
        for (int i = 0; i < resumes.size(); i++) {
            Resume arr = resumes.get(i);
            if (arr.getName().equals(resumeName) && arr.getIdCard().equals(resumeId)) {
                System.out.println("<<员工简历>>");
                System.out.println("姓名" + arr.getName() + "\n" + "年龄" + arr.getAge() + "\n"
                        + "身份证号" + arr.getIdCard() + "\n" + "毕业院校" + arr.getSchool() + "\n" + "目前状态" + arr.getProcessState());
                System.out.println("===============");


                System.out.println("请确认为该员工办理离职请输入1|0");
                int choice=input.nextInt();
                if (choice==1) {
                    System.out.println("===============");
                    System.out.println("确认办理。。。");
                    int newdeleteState = 1;
                    resumes.get(i).setDeleteStatus(newdeleteState);
                    System.out.println("该员工已离职");
                    for (int n = 0; i < resumes.size(); i++) {
                        Resume newarr = resumes.get(i);
                        System.out.println("<<离职员工简历>>");
                        System.out.println("姓名" + arr.getName() + "\n" + "年龄" + arr.getAge() + "\n"
                                + "身份证号" + arr.getIdCard() + "\n" + "毕业院校" + arr.getSchool() + "\n" + "目前状态已离职"


                        );
                        System.out.println("===============");
                    }
                }
                else {
                    System.out.println("已否认办理离职");
                }


            }
        }
    }
}
