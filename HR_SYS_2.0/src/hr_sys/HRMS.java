package hr_sys;
import java.util.LinkedList;
import java.util.Scanner;
import loadandsaveData.DataOperate;
import model.Resume;
import service.ResumeService;

public class HRMS {
    public static void main(String[] args) {
        //主程序入口
        String filepath="E:/HH_STUDY-xianyuhong5917/HR_SYS_2.0/out/resumelist.txt";
        LinkedList<Resume> resumeList = new LinkedList<Resume>();
        Scanner input = new Scanner(System.in);
        DataOperate.loadData(resumeList,filepath);
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
                ResumeService.addResume(resumeList);
            }
            else if(choice==2)
            {
                ResumeService.deleteResume(resumeList);
            }
            else if(choice==3)
            {
                ResumeService.updateResume(resumeList);
            }
            else if(choice==4)
            {
                ResumeService.searchResume(resumeList);
            }
            else if(choice==5)
            {
                DataOperate.saveData(resumeList,filepath);
                input.close();
                break;
            }else {
                System.out.println("输入错误，请重新输入");
            }
        }
        //关闭输入流
        System.out.println("您已经退出xxx简历管理系统");
        DataOperate.saveData(resumeList,filepath);
    }
}
