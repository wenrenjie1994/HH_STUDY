package sys;
import bean.Resume;
import java.util.Scanner;

/*第一版本：*/
public class my_HRS {
    private int MAXSIZE=100;
    //在数组初始化
    private Resume[] resumeList=new Resume[MAXSIZE];
    //简历计数
    private int resumeCount=0;
    //获取标准输入流
    private Scanner input=new Scanner(System.in);



    my_HRS(){

        while(true)
        {

            System.out.println("-----欢迎进入xxx简历管理系统-----");
            System.out.println("学生信息录入请按----1");
            System.out.println("学生信息删除请按----2");
            System.out.println("学生信息修改请按----3");
            System.out.println("学生信息查询请按----4");
            System.out.println("退出请按--------5");


            int choice=input.nextInt();

            if(choice==1)
            {
                addResume();
            }
            else if(choice==2)
            {
                deleteResume();
            }
            else if(choice==3)
            {
                updateResume();
            }
            else if(choice==4)
            {
                searchResume();
            }
            else if(choice==5)
            {
                break;
            }else {
                System.out.println("输入错误，请重新输入");
            }
        }
        //关闭输入流
        input.close();
        System.out.println("您已经退出xxx简历管理系统");
    }

    //录入学生简历信息
    void addResume()
    {
        System.out.println("欢迎进入简历管理系统的录入界面");
        //判断简历管理系统是否溢出
        if(resumeCount<MAXSIZE)
        {
            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入需要录入学生信息的姓名、身份证号、毕业院校");
            String Name=input.nextLine();
            String Id=input.nextLine();
            String School=input.nextLine();



            Resume resume=new Resume(Name,Id,School);
            resumeList[resumeCount]=resume;
            resumeCount++;
            System.out.println("您已经成功录入学生信息");
            showResume();
        }
        else{
            System.out.println("简历管理系统已满，无法添加图书");
        }
    }

    //删除图书学生简历
    void deleteResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除学生信息界面");
        System.out.println("请输入需要删除的学生身份证号");

        String studentId=input.nextLine();
        if(resumeCount!=0)
        {
            for(int i=0;i<resumeCount;i++)
            {
                if(resumeList[i].getId().equals(studentId))
                {
                    for(int j=i;j<resumeCount-1;j++)
                    {
                        resumeList[j]=resumeList[j+1];
                    }
                    System.out.println("您已经成功删除改学生信息");
                    resumeCount--;
                    break;
                }
                else if(i==resumeCount-1) {
                    System.out.println("没有找到该学生信息，请核实后删除");
                }
            }
            showResume();
        }
        else{
            System.out.println("简历管理系统为空，没有找到该学生信息");
        }
    }

    //修改学生信息
    void updateResume()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入学生信息修改界面");
        System.out.println("请输入需要修改学生的身份证号");
        String studentId=input.nextLine();
        if(resumeCount!=0)
        {
            for(int i=0;i<resumeCount;i++)
            {
                if(resumeList[i].getId().equals(studentId))
                {
                    System.out.println("请依次输入该学生修改后的学生姓名、身份证号、毕业院校、简历进程状态、显示状态。");
                    System.out.println(
                            "其中简历进程有："+
                            " 0：已申请 " +
                            " 1：简历通过 " +
                            " 2：笔试通过 " +
                            " 3：体检通过 " +
                            " 4：背调通过 " +
                            " 5：已签约 " +
                            " 6：已入职");
                    System.out.println(
                            "显示状态有："+
                            "0 :不展示 " +
                            "1 :展示");
                    String newname=input.nextLine();
                    String newid=input.nextLine();
                    String newschool=input.nextLine();
                    int newprocess=input.nextInt();
                    int newdeleteStatus=input.nextInt();
                    resumeList[i].setName(newname);
                    resumeList[i].setId(newid);
                    resumeList[i].setSchool(newschool);
                    resumeList[i].setProcess(newprocess);
                    resumeList[i].setDeleteStatus(newdeleteStatus);
                    System.out.println("您已经修改成功");
                    showResume();
                }
                else if(i==resumeCount-1||resumeCount==0) {
                    System.out.println("没有查找到该学生的简历信息");
                }
            }
        }
        else{
            System.out.println("系统为空，没有查找到该学生的简历信息");
        }

    }

    //查询图书
    void searchResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入学生信息查询界面");
        System.out.println("请输入需要查询的学生身份证号");
        String studentId=input.nextLine();
        for(int i=0;i<resumeCount;i++)
        {
            if(resumeList[i].getId().equals(studentId))
            {
                System.out.println("学生姓名:"+resumeList[i].getName()+" "+
                        "身份证号"+":"+resumeList[i].getId()+" "
                        +"毕业院校"+":"+resumeList[i].getSchool()+" "
                        +"简历进程:"+resumeList[i].getProcess()+" "
                        +"简历显示状态:"+resumeList[i].getDeleteStatus());
                break;
            }
            else if(i==resumeCount-1) {
                System.out.println("没有查找到该学生，请重新输入");
            }
            else{
                System.out.println("系统为空，没有查找到该学生的简历信息");
            }
        }
    }

    //图书遍历
    void showResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要打印所有学生信息，是请输入Y，不用打印则输入任意");
        String XUANZE=input.nextLine();
        String Y="Y";
        if(XUANZE.equals(Y))
        {
            System.out.println("本简历管理系统共有"+resumeCount+"份学生简历信息");
            for(int i=0;i<resumeCount;i++) {
                System.out.println("学生姓名:"+resumeList[i].getName()+" "+
                        "身份证号"+":"+resumeList[i].getId()+" "
                        +"毕业院校"+":"+resumeList[i].getSchool()+" "
                        +"简历进程:"+resumeList[i].getProcess()+" "
                        +"简历显示状态:"+resumeList[i].getDeleteStatus());
            }
        }
    }

    public static void main(String[] args)
    {
        new my_HRS();
    }
}

