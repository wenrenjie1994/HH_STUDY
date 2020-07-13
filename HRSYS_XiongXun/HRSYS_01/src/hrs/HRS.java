package hrs;

import bean.Resume;

import java.util.Scanner;

public class HRS {

    private int MAXSIZE=100;
    private Resume[] resumeList=new Resume[MAXSIZE];

    private int resumeCount=0;
    //获取标准输入流
    private Scanner input=new Scanner(System.in);

    HRS(){
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
                    updateResume();
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
        System.out.println("欢迎进入添加简历界面");
        if(resumeCount<MAXSIZE)//判断图书管理系统是否未满
        {
            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入需要添加的简历姓名、身份证号、学校");
            String name=input.nextLine();
            String id=input.nextLine();
            String school=input.nextLine();

            Resume resume = new Resume(name,id,school);


            resumeList[resumeCount]=resume;
            resumeCount++;
            System.out.println("您已经成功添加该简历！");
            showResume();
        }
        else{
            System.out.println("HR管理系统简历已满，无法添加新的简历");
        }
    }

    //删除简历
    void deleteResume()
    {
        @SuppressWarnings("resource")//对被批注的代码元素内部的某些警告保持静默
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除简历界面");
        System.out.println("请输入需要删除的简历姓名");
        String name=input.nextLine();
        if(resumeCount!=0)//hr管理系统简历不为空
        {
            for(int i=0;i<resumeCount;i++)
            {
                if(resumeList[i].getName().equals(name))
                {
                    for(int j=i;j<resumeCount-1;j++)
                    {
                        resumeList[j]=resumeList[j+1];
                    }
                    System.out.println("您已经成功删除该简历！");
                    resumeCount--;
                    break;
                }
                else if(i==resumeCount-1) {
                    System.out.println("没有找到该简历");
                }
            }
            showResume();
        }
        else{
            System.out.println("HR系统简历为空，没有找到该简历");
        }
    }

    //修改简历
    void updateResume()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入修改简历界面");
        System.out.println("请输入需要修改的简历姓名");
        String name=input.nextLine();
        if(resumeCount!=0)//图书管理系统不为空
        {
            for(int i=0;i<resumeCount;i++)
            {
                if(resumeList[i].getName().equals(name))
                {
                    System.out.println("请依次输入新的简历姓名、身份证号、学校");
                    String newnName=input.nextLine();
                    String newId=input.nextLine();
                    String newSchool=input.nextLine();

                    Resume resume = new Resume(newnName,newId,newSchool);
                    resumeList[i]=resume;
                    System.out.println("您已经修改成功!");
                    showResume();
                }
                else if(i==resumeCount-1) {
                    System.out.println("没有查找到该简历");
                }
            }
        }
        else{
            System.out.println("hr系统简历为空，没有查找到该简历");
        }
    }

    //查询简历
    void searchResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入查询简历界面");
        System.out.println("请输入需要查询的简历名称：");
        String name=input.nextLine();
        for(int i=0;i<resumeCount;i++)
        {
            if(resumeList[i].getName().equals(name))
            {
                System.out.println(
                        "名称:"+resumeList[i].getName()+"\n"
                        +"省份证号:"+resumeList[i].getId()+"\n"
                        +"学校:"+resumeList[i].getSchool());
                break;
            }
            else if(i==resumeCount-1) {
                System.out.println("没有查找到该简历");
            }
        }
    }

    //图书遍历
    void showResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
        String choice=input.nextLine();
        if(choice.equalsIgnoreCase("Y"))
        {
            System.out.println("本HR管理系统共有"+resumeCount+"条简历");
            for(int i=0;i<resumeCount;i++) {
                System.out.println("名称:"+resumeList[i].getName() +","+"省份证号:"+resumeList[i].getId() +","+"学校:"+resumeList[i].getSchool());
            }
        }
    }

    public static void main(String[] args)
    {
        new HRS();
    }
}
