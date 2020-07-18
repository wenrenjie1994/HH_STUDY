package model;

import java.util.*;

import model.JobHunter;
import model.HRSDatabase;

public class Operator {
    private JobHunter inputJobHunterInf()
    {
        JobHunter jobHunter = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入求职者的以下信息：");
        System.out.println("姓名：");
        String name = scan.next();

        System.out.println("性别（男/女）：");
        String strGender = null;
        Boolean right1 = true;
        Gender gender = null;
        do
        {
            right1 = true;
            strGender = scan.next();
            switch(strGender)
            {
                case "男":{ gender = Gender.MALE; } break;
                case "女":{ gender = Gender.FEMALE; }break;
                default:
                {
                    System.out.println("性别输入错误，请重新输入：");
                    right1 = false;
                }break;
            }
        }while(!right1);

        System.out.println("年龄：");
        String strAge = scan.next();
        Integer age = Integer.valueOf(strAge);

        System.out.println("学历（学士/硕士/博士）：");
        Boolean right2 = true;
        String strDegree = null;
        Degree degree = null;
        do
        {
            right2 = true;
            strDegree = scan.next();
            switch(strDegree)
            {
                case "学士":{ degree = Degree.BACHELOR; }break;
                case "硕士":{ degree = Degree.MASTER; }break;
                case "博士":{ degree = Degree.DOCTOR; }break;
                default:
                {
                    System.out.println("学历输入错误，请重新输入：");
                    right2 = false;
                }break;
            }
        }while(!right2);

        System.out.println("阶段" +"\n"+
                "（简历接收：1" +"\n"+
                "面试通过：2" +"\n"+
                "OFFER已发送：3" +"\n"+
                "体检通过：4" +"\n"+
                "背调通过：5" +"\n"+
                "签约完成：6）");
        Boolean right3 = true;
        String  strStage = null;
        Stage stage = null;
        do
        {
            right3 = true;
            strStage = scan.next();
            switch(strStage)
            {
                case "1":{ stage = Stage.RESUME; }break;
                case "2":{ stage = Stage.INTERVIEW; }break;
                case "3":{ stage = Stage.OFFER; }break;
                case "4":{ stage = Stage.EXAMINATION; }break;
                case "5":{ stage = Stage.BACKGROUND; }break;
                case "6":{ stage = Stage.SIGN; }break;
                default:
                {
                    System.out.println("阶段数据输入错误，请重新输入：");
                    right3 = false;
                }break;
            }
        }while(!right3);

        jobHunter = new JobHunter(name,gender,age,degree,stage);
        return jobHunter;
    }
    public void addJobHunterInf(String nameDatabase,String nameTable)
    {
        JobHunter jobHunter = inputJobHunterInf();
        HRSDatabase.InsertData(nameDatabase,nameTable,jobHunter);
        System.out.println("成功添加求职者：" + jobHunter.getName() + "的数据");
    }
    public void deleteJobHunterInf(String nameDatabase,String nameTable)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入需要删除信息的求职者姓名：");
        System.out.println("姓名：");
        String queryName = scan.next();
        HRSDatabase.DeleteData(nameDatabase,nameTable,queryName);
        System.out.println("成功删除求职者：" + queryName + "的数据");
    }
    public void changeJobHunterInf(String nameDatabase,String nameTable)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入需要修改除信息的求职者姓名：");
        System.out.println("姓名：");
        String queryName = scan.next();
        JobHunter jobHunter = inputJobHunterInf();
        JobHunter queryJobHunter = HRSDatabase.SearchData(nameDatabase,nameTable,queryName);
        if (queryJobHunter != null)
        {
            System.out.println("修改前信息如下：");
            System.out.println("姓名："+queryJobHunter.getName());
            System.out.println("性别："+queryJobHunter.getGender().getChinese());
            System.out.println("年龄："+queryJobHunter.getAge().toString());
            System.out.println("学历："+queryJobHunter.getDegree().getChinese());
            System.out.println("阶段："+queryJobHunter.getStage().getChinese());
        }
        else
        {
            System.out.println("查无此人，请确定信息是否输入正确");
            return ;
        }
        HRSDatabase.UpdateData(nameDatabase,nameTable,queryName,jobHunter);
        System.out.println("成功修改求职者：" + queryName + "的数据");
        System.out.println("修改后信息如下：");
        System.out.println("姓名："+jobHunter.getName());
        System.out.println("性别："+jobHunter.getGender().getChinese());
        System.out.println("年龄："+jobHunter.getAge().toString());
        System.out.println("学历："+jobHunter.getDegree().getChinese());
        System.out.println("阶段："+jobHunter.getStage().getChinese());
    }
    public void queryJobHunterInf(String nameDatabase,String nameTable)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入需要查询信息的求职者姓名：");
        System.out.println("姓名：");
        String queryName = scan.next();
        JobHunter queryJobHunter =  HRSDatabase.SearchData(nameDatabase,nameTable,queryName);
        if (queryJobHunter != null)
        {
            System.out.println("查询信息如下：");
            System.out.println("姓名："+queryJobHunter.getName());
            System.out.println("性别："+queryJobHunter.getGender().getChinese());
            System.out.println("年龄："+queryJobHunter.getAge().toString());
            System.out.println("学历："+queryJobHunter.getDegree().getChinese());
            System.out.println("阶段："+queryJobHunter.getStage().getChinese());
        }
        else
        {
            System.out.println("查无此人，请确定信息是否输入正确");
        }
    }

}

