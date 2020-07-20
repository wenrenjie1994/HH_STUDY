package operator;
import java.util.ArrayList;
import java.util.Scanner;
import bean.Resume;
import util.Parser;
import util.Protocol;
import work.Client;
import bean.ReturnResult;

public class HRS {
    private boolean iscndb=false;//是否采用数据库
    private int MAXSIZE=100;
    Client client=new Client();
//在数组初始化的时候，限制了数组的大小，有没有别的方式更好呢？
//    private HR[] HRList=new HR[MAXSIZE];
//用list实现动态数组
    ArrayList<Resume> ResumeArrayList=new ArrayList<>();
//数组初始化
//	int[]  shuzu=new int[1];
//	int[] shuzu1={1,2,3};
//	int[] shuzu3=new  int[]{1,2,3};
    private int HRCount=0;//都是数组带来的烦恼？还得防止越界；
    //获取标准输入流
    private Scanner input=new Scanner(System.in);
    HRS(){
        while(true)
        {

            System.out.println("-----欢迎进入qhr的HR管理系统-----");
            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("退出请按--------5");
            int choice=input.nextInt();
            //除了用if 还能用switch方式实现逻辑判断
            switch (choice){
                case 1:
                    addHRCS();
                    continue;
                case 2:
                    deleteHR();
                    continue;
                case 3:
                    updateHR();
                    continue;
                case 4:
                    searchHR();
                    continue;
                case 5:
                    input.close();//流啊 连接啊 这些东西 用完记得关；要么记得还（那么什么地方是需要还的，什么地方是关的）；
                    System.out.println("您已经退出简历管理系统");
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
    //添加简历
    void addHRCS()
    {
        System.out.println("欢迎进入添加简历界面");
        if(HRCount<MAXSIZE)//判断简历管理系统是否未满
        {
            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入需要添加简历的姓名，身份证号，学校，申请状态");
            String ReName=input.next();
            String ReId=input.next();
            String ReSchool=input.next();
            Integer ReProcess=input.nextInt();
            Resume Resume=new Resume(ReName,ReId,ReSchool,ReProcess,1);
//            String StrResume = ReName+","+ReId+","+ReSchool+","+ReProcess+"/"+"add";
            //用协议拼装
            Protocol protocol =new Protocol();
            String StrResume = protocol.AddResumeMessage(Resume);
            //建立通信,并得到返回
            String returnMessage = client.sendMessageToSever(StrResume);
            //解析服务器返回信息
            Parser parser = new Parser();
            ReturnResult returnResult = parser.parserAdd(returnMessage);
            HRCount++;
            System.out.println("服务器返回信息： "+returnResult);
            showHR();
        }
        else{
            System.out.println("简历管理系统已满，无法添加简历");
        }
    }

    //添加简历
    void addHR()
    {
        System.out.println("欢迎进入添加简历界面");
        if(HRCount<MAXSIZE)//判断简历管理系统是否未满
        {
            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入需要添加简历的姓名，身份证号，学校，申请状态");
            String ReName=input.nextLine();
            String ReId=input.nextLine();
            String ReSchool=input.nextLine();
            Integer ReProcess=input.nextInt();
//          Integer ReDeleteStatus=input.nextInt();
            //默认展示
            Resume Resume=new Resume(ReName,ReId,ReSchool,ReProcess,1);
            Resume.setProcess(ReProcess);
//            Resume.setDeleteStatus(ReDeleteStatus);
            //如果这个时候已经有79本书了，那么第79本书的位置是78
            ResumeArrayList.add(HRCount,Resume);
            HRCount++;
            System.out.println("您已经成功添加简历");
            showHR();
        }
        else{
            System.out.println("简历管理系统已满，无法添加简历");
        }
    }

    //物理删除简历
    void deleteHR()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除简历界面");
        System.out.println("请输入需要删除简历的所有者身份证号码");
        String id=input.nextLine();
        if(HRCount!=0)//简历管理系统不为空
        {
            for(int i=0;i<HRCount;i++)
            {
                if(ResumeArrayList.get(i).getId().equals(id))
                {
//                    for(int j=i;j<HRCount-1;j++)
//                    {
//                        HRList[j]=HRList[j+1];
//                    }
                    ResumeArrayList.remove(i);
                    System.out.println("您已经成功删除"+id+"的简历信息");
                    HRCount--;
                    break;
                }
                else if(i==HRCount-1) {
                    System.out.println("没有找到该简历");
                }
            }
            showHR();
        }
        else{
            System.out.println("简历管理系统为空，没有找到该简历");
        }
//		input.close();
    }
    //逻辑删除简历
    void deleteHR2()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除简历界面");
        System.out.println("请输入需要删除简历的所有者身份证号码");
        String id=input.nextLine();
        if(HRCount!=0)//简历管理系统不为空
        {
            for(int i=0;i<HRCount;i++)
            {
                if(ResumeArrayList.get(i).getId().equals(id))
                {
//
                    ResumeArrayList.get(i).setDeleteStatus(0);
                    System.out.println("您已经成功删除"+id+"的简历信息");
                    HRCount--;
                    break;
                }
                else if(i==HRCount-1) {
                    System.out.println("没有找到该简历");
                }
            }
            showHR();
        }
        else{
            System.out.println("简历管理系统为空，没有找到该简历");
        }
//		input.close();
    }
    //修改简历
    void updateHR()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入修改简历界面");
        System.out.println("请输入需要修改简历的所有者身份证号码");
        String id=input.nextLine();
        if(HRCount!=0)//简历管理系统不为空
        {
            for(int i=0;i<HRCount;i++)
            {
                if(ResumeArrayList.get(i).getId().equals(id))
                {
                    System.out.println("请依次输入新的姓名，身份证号，学校，申请状态");
                    String newname=input.nextLine();
                    String newreid=input.nextLine();
                    String newschool=input.nextLine();
                    Integer newprocess=input.nextInt();
                    Resume resume=new Resume(newname,newreid,newschool,newprocess,1);
                    ResumeArrayList.add(i,resume);
                    System.out.println("您已经修改成功");
                    showHR();
                }
                else if(i==HRCount-1||HRCount==0) {
                    System.out.println("没有查找到该书籍");
                }
            }
        }
        else{
            System.out.println("系统为空，没有查找到该书籍");
        }
//		input.close();
    }

    //查询简历
    void searchHR()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入查询简历界面");
        System.out.println("请输入需要查询的简历名");
        String id=input.nextLine();
        for(int i=0;i<HRCount;i++)
        {

            if(ResumeArrayList.get(i).getId().equals(id))
            {
                String chProcess []={"已申请","简历通过","笔试通过","体检通过","背调通过","已签约","已入职"};
                System.out.println("<<"+ResumeArrayList.get(i).getName()+">>"+"\n"+
                        "身份证号"+":"+ResumeArrayList.get(i).getId()+"\n"
                        +"学校"+":"+ResumeArrayList.get(i).getSchool()+"\n"
                        +"简历状态"+":"+ResumeArrayList.get(i).getProcess()+"\n"
                        +"位于第"+(i+1)+"位置");
                break;
            }
            else if(i==HRCount-1) {
                System.out.println("没有查找到该书籍，请重新输入");
            }
        }
//		input.close();
    }

    //简历遍历
    void showHR()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
        String XUANZE=input.nextLine();
        String Y="Y";
        if(XUANZE.equals(Y))
        {
            System.out.println("本简历管理系统共有"+HRCount+"条简历信息");
            for(int i=0;i<HRCount;i++) {
                System.out.println("第"+(i+1)+"条1"+"----"+"<<"+ResumeArrayList.get(i).getName()+">>");
            }
        }
//		input.close();
    }

    public static void main(String[] args)
    {
        new HRS();
    }
}
