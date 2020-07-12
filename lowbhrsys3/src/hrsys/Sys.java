package hrsys;

import bean.Candidate;
import bean.CandidateList;
import work.Action;

import java.util.Scanner;

public class Sys
{
    public Sys()
    {
        while(true) {
            System.out.println("-----欢迎进入浦发招聘系统-----");
            System.out.println("添加应聘者信息请按1");
            System.out.println("删除应聘者信息请按2");
            System.out.println("查询应聘者信息请按3");
            System.out.println("更新应聘者信息亲按4");
            System.out.println("退出请按5");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("你已经退出系统");
                break;
            }

            switch (choice)
            {
                case 1:
                    addcandidate();
                    break;
                case 2:
                    deletecandidate();
                    break;
                case 3:
                    searchcandidate();
                    break;
                case 4:
                    updatecandidate();
                    break;
                default:
                    System.out.println("输入的是个啥？");
                    break;

            }

        }

    }

    void addcandidate()
    {
        System.out.println("欢迎来到添加应聘者界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加姓名，身份证号，学校，流程");
        String name=input.nextLine();
        String id=input.nextLine();
        String school=input.nextLine();
        int process=input.nextInt();

        Candidate candidate=new Candidate(name,id,school,process);

        Action a=new Action();
        int line=a.addcandidate(candidate);

        if(line>0)
        {
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

    }

    void deletecandidate()
    {
        System.out.println("欢迎进入删除应聘者信息界面");
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要删除的应聘者信息");
        String name=input.nextLine();
        Candidate candidate=new Candidate(name,null,null,0);
        Action a=new Action();
        int line=a.deleteCandidate(candidate);
        if(line>0)
        {
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    void updatecandidate()
    {
        System.out.println("欢迎进入修改应聘者信息界面");
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要修改的应聘者姓名");
        String name=input.nextLine();
        System.out.println("请依次输入修改后身份证号，学校，流程");
        String id=input.nextLine();
        String school=input.nextLine();
        int process=input.nextInt();
        Candidate candidate=new Candidate(name,id,school,process);
        Action a=new Action();
        int line=a.changeCandidate(candidate);
        if(line>0)
        {
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    void searchcandidate()
    {
        System.out.println("欢迎进入查找应聘者信息界面");
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要查找的应聘者信息");
        String name=input.nextLine();
        Candidate candidate=new Candidate(name,null,null,0);
        Action a=new Action();
        CandidateList list=a.searchByName(candidate);
        int count=list.size();
        if(count>0)
        {
            for(int i=0;i<count;i++)
            {
                System.out.println("姓名："+list.get(i).getName()+"身份证号："+list.get(i).getId()+"学校："+list.get(i)+
                        "流程："+list.get(i).getProcess());
            }
        }else{
            System.out.println("你输入的家伙不存在");
        }
    }

    public static void main(String[] args) {
        new Sys();
    }

}
