package service;


import bean.Resume_v3;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by guyaren
 */
public class HrService {

    /**
     * 增加简历
     */
    public static void addResume(){
        Scanner sc = new Scanner(System.in);
        Boolean flag = true;
        HrAction hrAction = new HrAction();
        System.out.println("添加简历界面");
        while(flag){
            System.out.println("请按照身份证ID，姓名，学校添加，并以逗号隔开");
            String[] tmp = sc.nextLine().split(",");
            if(tmp.length>1){
                Resume_v3 resume = new Resume_v3(tmp[0],tmp[1],tmp[2]);
                hrAction.addResume(resume);
            }else{
                flag=false;
            }
        }

    }

    /**
     * 简历删除
     */
    public static void deleteResume(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Boolean flag = true;
        HrAction hrAction = new HrAction();
        while (flag){
            System.out.println("删除简历界面");
            System.out.println("按编号----------1");
            System.out.println("按姓名----------2");
            System.out.println("按学校----------3");
            System.out.println("按状态----------4");
            System.out.println("退出------------5");
            int index = sc.nextInt();
            switch (index){
                case 1:
                    System.out.println("请输入编号");
                    hrAction.deleteResumeByID(sc1.nextLine());break;
                case 2:
                    System.out.println("请输入姓名");
                    hrAction.deleteResume("name='"+sc1.nextLine()+"'");break;
                case 3:
                    System.out.println("请输入学校名称");
                    hrAction.deleteResume("school='"+sc1.nextLine()+"'");break;
                case 4:
                    System.out.println("请输入简历进程");
                    hrAction.deleteResume("process="+sc1.nextLine());break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误，重新输入");
            }
        }
    }

    public static void SearchResume(){
        Scanner sc = new Scanner(System.in);
        Boolean flag = true;
        HrAction hrAction = new HrAction();
        while (flag){
            System.out.println("查询简历界面");
            System.out.println("按编号----------1");
            System.out.println("按姓名----------2");
            System.out.println("按学校----------3");
            System.out.println("按状态----------4");
            System.out.println("按删除----------5");
            System.out.println("退出------------6");
            int index = sc.nextInt();
            Resume_v3 res = null;
            LinkedList<Resume_v3> ress = null;
            Scanner sc1 = new Scanner(System.in);
            if(index==1){
                System.out.println("请输入编号");
                res =hrAction.searchResumeByID(sc1.nextLine());
                res.PrintString();
            }
            else if(index==2){
                System.out.println("请输入姓名");
                ress = hrAction.searchResume("name='"+sc1.nextLine()+"'");
                for(int i=0;i<ress.size();i++){
                    ress.get(i).PrintString();
                }
            }
            else if(index==3){
                System.out.println("请输入学校名称");
                ress = hrAction.searchResume("school='"+sc1.nextLine()+"'");
                for(int i=0;i<ress.size();i++){
                    ress.get(i).PrintString();
                }
            }
            else if(index==4){
                System.out.println("请输入简历进程");
                ress = hrAction.searchResume("process="+sc1.nextInt());
                for(int i=0;i<ress.size();i++){
                    ress.get(i).PrintString();
                }
            }
            else if(index==5){
                System.out.println("请输入简历状态");
                ress = hrAction.searchResume("process="+sc1.nextInt());
                for(int i=0;i<ress.size();i++){
                    ress.get(i).PrintString();
                }
            }
            else if(index==6){
                flag = false;
            }
            else{
                System.out.println("输入错误，重新输入");
            }
        }
    }

    public static void updateResume(){
        HrAction hrAction = new HrAction();
        System.out.println("修改简历界面");
        System.out.println("请输入需要修改的id");
        Scanner sc = new Scanner(System.in);
        Resume_v3 resume = hrAction.searchResumeByID(sc.nextLine());
        if(resume!=null){
            System.out.println("请依次输入id,name,school,process,deleteStatus");
            String[] tmp = sc.nextLine().split(",");
            Resume_v3 newResume = new Resume_v3(tmp[0],tmp[1],tmp[2],Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            hrAction.changeResume(newResume);
        }else{
            System.out.println("没有此人简历");
        }
    }


}
