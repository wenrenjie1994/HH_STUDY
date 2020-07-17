package model;

import java.util.*;
import model.JobHunter;
public class Operate {
    public static void addJobHunterInf()
    {
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
                    System.out.println("性别输入错误，请重新输入");
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
                    System.out.println("阶段输入错误，请重新输入：");
                    right3 = false;
                }break;
            }
        }while(!right3);

        JobHunter jobHunter = new JobHunter(name,gender,age,degree,stage);
        System.out.println("名字： "+jobHunter.getName());
        System.out.println("性别： "+jobHunter.getGender().getChainese());
        System.out.println("年龄： "+jobHunter.getAge());
        System.out.println("学历： "+jobHunter.getDegree().getChinese());
        System.out.println("阶段： "+jobHunter.getStage().getChinese());
    }
    public static void deleteJobHunterInf()
    {
        System.out.println("删除");
    }
    public static void changeJobHunterInf()
    {
        System.out.println("修改");
    }
    public static void queryJobHunterInf()
    {
        System.out.println("查询");
    }
}
