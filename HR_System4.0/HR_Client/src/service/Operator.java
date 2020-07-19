package service;

import resume.Resume;
import tcp.ReturnResult;

import java.util.LinkedList;
import java.util.Scanner;

public class Operator {
    public void add(){
        System.out.println("****欢迎来到添加简历界面****");
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入求职者姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入求职者身份证号码：");
        String id = scanner.nextLine();
        System.out.println("请输入求职者学校：");
        String school = scanner.nextLine();
        System.out.println("请输入求职者状态：\n" +
                "     0：已申请\n" +
                "     1：简历通过\n" +
                "     2：笔试通过\n" +
                "     3：面试通过\n" +
                "     4：体检通过\n" +
                "     5：背调通过\n" +
                "     6：已签约\n"+
                "     7：已入职");
        int process = scanner.nextInt();
        Resume resume =new Resume(name,id,school,process,1);
        Action action =new Action();
        ReturnResult returnResult =action.addResume(resume);
        if(returnResult.isSuccess){
            System.out.println("简历添加成功");
        }else{
            System.out.println("简历添加失败");
        }
    }
    public void deleteResume(){
        while(true){
            System.out.println("********欢迎进入简历删除界面********");
            Scanner scanner =new Scanner(System.in);
            System.out.println("按姓名删除请输入----------1");
            System.out.println("按身份证号码删除请输入----2");
            System.out.println("按学校删除请输入--------3");
            System.out.println("退出请输入----------------4");
            int choice = scanner.nextInt();
            if(choice==1){
                deleteByName();
            }else if(choice==2){
                deleteById();
            }else if(choice==3){
                deleteBySchool();
            }else if(choice==4){
                break;
            }else{
                System.out.println("输入错误！");
            }
        }

    }
    public void deleteByName(){
        System.out.println("请输入求职者姓名：");
        Scanner scanner =new Scanner(System.in);
        String name = scanner.nextLine();
        Resume resume =new Resume(name,null,null,0,1);
        Action action =new Action();
        ReturnResult returnResult = action.deleteResumeByName(resume);
        if(returnResult.isSuccess){
            System.out.println("简历删除成功");
        }else{
            System.out.println("简历删除失败");
        }

    }
    public void deleteById(){
        System.out.println("请输入求职者身份证号码：");
        Scanner scanner =new Scanner(System.in);
        String id = scanner.nextLine();
        Resume resume =new Resume(null,id,null,0,1);
        Action action =new Action();
        ReturnResult returnResult = action.deleteResumeById(resume);
        if(returnResult.isSuccess){
            System.out.println("简历删除成功");
        }else{
            System.out.println("简历删除失败");
        }

    }
    public void deleteBySchool(){
        System.out.println("请输入求职者学校：");
        Scanner scanner =new Scanner(System.in);
        String school = scanner.nextLine();
        Resume resume =new Resume(null,null,school,0,1);
        Action action =new Action();
        ReturnResult returnResult = action.deleteResumeBySchool(resume);
        if(returnResult.isSuccess){
            System.out.println("简历删除成功");
        }else{
            System.out.println("简历删除失败");
        }

    }
    public void updateResume(){
        System.out.println("请输入要修改的求职者的姓名：");
        Scanner scanner =new Scanner(System.in);
        String name = scanner.nextLine();
        Resume oldResume = new Resume(name,null,null,0,1);
        System.out.println("请输入该求职者的最新信息：");
        Scanner scanner1 =new Scanner(System.in);
        System.out.println("请输入求职者姓名：");
        String name1 = scanner1.nextLine();
        System.out.println("请输入求职者身份证号码：");
        String id1 = scanner1.nextLine();
        System.out.println("请输入求职者学校：");
        String school1 = scanner1.nextLine();
        System.out.println("请输入求职者状态：\n" +
                "     0：已申请\n" +
                "     1：简历通过\n" +
                "     2：笔试通过\n" +
                "     3：面试通过\n" +
                "     4：体检通过\n" +
                "     5：背调通过\n" +
                "     6：已签约\n"+
                "     7：已入职");
        int process1 = scanner.nextInt();
        Resume resume =new Resume(name1,id1,school1,process1,1);
        Action action =new Action();
        ReturnResult returnResult=action.updateResume(resume,oldResume);
        if(returnResult.isSuccess){
            System.out.println("信息修改成功");
            System.out.println("修改后的信息为：");
            System.out.println("姓名："+name1+"身份证号码："+id1+"学校："+school1+"当前状态："+process1);
        }else{
            System.out.println("信息修改失败");
        }

    }
    public void searchResume(){
        while (true){
            System.out.println("******欢迎进入简历查询界面******");
            System.out.println("按照姓名查询请输入----------1");
            System.out.println("按照身份证号码查询请输入-----2");
            System.out.println("按照学校查询请输入----------3");
            System.out.println("退出请按------------------4");
            Scanner scanner=new Scanner(System.in);
            int choice =scanner.nextInt();
            if(choice==1){
                searchByName();
            }else if(choice==2){
                searchById();
            }else if(choice==3){
                searchBySchool();
            }else if(choice==4){
                break;
            }else{
                System.out.println("输入错误");
            }
        }

    }
    public void searchByName(){
        System.out.println("请输入求职者姓名：");
        Scanner scanner=new Scanner(System.in);
        String name =scanner.nextLine();
        Resume resume =new Resume(name,null,null,0,1);
        Action action =new Action();
        ReturnResult returnResult =action.searchResumeByName(resume);
        LinkedList<Resume> list =(LinkedList<Resume>) returnResult.returnData;
        if(list.size()>0){
            System.out.println("查询到的简历信息如下：");
            printAll(list);
        }else{
            System.out.println("查询失败，没有此简历");
        }

 }
    public void searchById(){
        System.out.println("请输入求职者身份证号码：");
        Scanner scanner=new Scanner(System.in);
        String id =scanner.nextLine();
        Resume resume =new Resume(null,id,null,0,1);
        Action action =new Action();
        ReturnResult returnResult =action.searchResumeById(resume);
        LinkedList<Resume> list =(LinkedList<Resume>) returnResult.returnData;
        if(list.size()>0){
            System.out.println("查询到的简历如下：");
            printAll(list);
        }else{
            System.out.println("查询失败，没有此简历");
        }
    }
    public void searchBySchool(){
        System.out.println("请输入求职者学校：");
        Scanner scanner=new Scanner(System.in);
        String school =scanner.nextLine();
        Resume resume =new Resume(null,null,school,0,1);
        Action action =new Action();
        ReturnResult returnResult =action.searchResumeBySchool(resume);
        LinkedList<Resume> list =(LinkedList<Resume>) returnResult.returnData;
        if(list.size()>0){
            System.out.println("查询到的简历如下：");
            printAll(list);
        }else{
            System.out.println("查询失败，没有此简历");
        }

    }
    public void printAll(LinkedList<Resume> list){
        int len =list.size();
        for(int i=0;i<len;i++){
            printResume(list.get(i));
        }

    }
    public void printResume(Resume resume){
        System.out.println("姓名："+resume.getName()+" 身份证号码："+resume.getId()+" 学校："+resume.getSchool()+" 当前状态："+resume.getProcess());

    }

}
