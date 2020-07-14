package service;

import bean.Resume;

import java.util.LinkedList;
import java.util.Scanner;

public class Service {
    public void addResume(){
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
        int line = action.addResume(resume);
        if(line>0){
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
            System.out.println("退出请输入----------------3");
            int choice = scanner.nextInt();
            if(choice==1){
                deleteByName();
            }else if(choice==2){
                deleteById();
            }else if(choice==3){
                break;
            }
        }
    }
    public void deleteByName(){
        System.out.println("请输入要删除的求职者的名字：");
        Scanner scanner =new Scanner(System.in);
        String name = scanner.nextLine();
        Resume resume =new Resume(name,null,null,0,1);
        Action action =new Action();
        int line = action.deleteResumeByName(resume);
        if(line>0){
            System.out.println("删除成功");
        }else{
            System.out.println("该求职者不存在，删除失败");
        }
    }
    public void deleteById(){
        System.out.println("请输入要删除的求职者的身份证号码：");
        Scanner scanner =new Scanner(System.in);
        String id = scanner.nextLine();
        Resume resume =new Resume(null,id,null,0,1);
        Action action =new Action();
        int line = action.deleteResumeById(resume);
        if(line>0){
            System.out.println("删除成功");
        }else{
            System.out.println("该求职者不存在，删除失败");
        }
    }
    //查询
    public void searchResume(){
        while(true){
            System.out.println("*****欢迎进入简历查询界面*******");
            Scanner scanner =new Scanner(System.in);
            System.out.println("按姓名查询请输入-----1");
            System.out.println("按身份证查询请输入-----2");
            System.out.println("按学校查询请输入-----3");
            System.out.println("退出请输入-------4");
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
                System.out.println("输入错误，请重新输入");
            }
        }
    }
    public void searchByName(){
        System.out.println("请输入求职者姓名：");
        Scanner scanner =new Scanner(System.in);
        String name = scanner.nextLine();
        Resume resume =new Resume(name,null,null,0,1);
        Action action =new Action();
        LinkedList<Resume> list = action.searchResumeByName(resume);
        int len =list.size();
        if(len>0){
            for(int i=0;i<len;i++){
                System.out.println("姓名："+list.get(i).getName()+" "+"身份证号码："+list.get(i).getId()+" "
                        +"学校："+list.get(i).getSchool()+" "+"当前状态："+list.get(i).getProcess());
            }
        }else{
            System.out.println("姓名为"+name+"的简历没有找到！");
        }
    }
    public void searchById(){
        System.out.println("请输入求职者身份证号码：");
        Scanner scanner =new Scanner(System.in);
        String id = scanner.nextLine();
        Resume resume =new Resume(null,id,null,0,1);
        Action action =new Action();
        LinkedList<Resume> list = action.searchResumeById(resume);
        int len =list.size();
        if(len>0){
            for(int i=0;i<len;i++){
                System.out.println("姓名："+list.get(i).getName()+" "+"身份证号码："+list.get(i).getId()+" "
                        +"学校："+list.get(i).getSchool()+" "+"当前状态："+list.get(i).getProcess());
            }
        }else{
            System.out.println("身份证号码为"+id+"的简历没有找到！");
        }
    }
    public void searchBySchool(){
        System.out.println("请输入求职者学校：");
        Scanner scanner =new Scanner(System.in);
        String school = scanner.nextLine();
        Resume resume =new Resume(null,null,school,0,1);
        Action action =new Action();
        LinkedList<Resume> list = action.searchResumeBySchool(resume);
        int len =list.size();
        if(len>0){
            for(int i=0;i<len;i++){
                System.out.println("姓名："+list.get(i).getName()+" "+"身份证号码："+list.get(i).getId()+" "
                        +"学校："+list.get(i).getSchool()+" "+"当前状态："+list.get(i).getProcess());
            }
        }else{
            System.out.println("学校为"+school+"的简历没有找到！");
        }
    }
    public void update(){
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
        int line =action.updateResume(resume,oldResume);
        if(line>0){
            System.out.println("信息修改成功");
            System.out.println("修改后的信息为：");
            System.out.println("姓名："+name1+"身份证号码："+id1+"学校："+school1+"当前状态："+process1);
        }else{
            System.out.println("信息修改失败");
        }
    }

}
