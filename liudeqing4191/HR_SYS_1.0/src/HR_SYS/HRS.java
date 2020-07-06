package HR_SYS;

import loadandsaveData.DataOperate;
import model.Resume;
import service.ResumeService;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liudeqing4191
 * @date 2020/07/06
 * @project HR_SYS_1.0
 **/
public class HRS {
    public static void main(String[] args) {
        LinkedList<Resume> resumeList = new LinkedList<Resume>();
        Scanner input = new Scanner(System.in);
        DataOperate.loadData(resumeList);//下载所有简历

        boolean c = true;
        while (c) {

            System.out.println("-----欢迎进入idcard的hr系统-----");
            System.out.println("添加学生信息请按----1");
            System.out.println("删除学生信息请按----2");
            System.out.println("修改学生信息请按----3");
            System.out.println("查询学生信息请按----4");
            System.out.println("退出请按--------5");


            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    ResumeService.addResume(resumeList);
                    break;
                case 2:
                    ResumeService.deleteResume(resumeList);
                    break;
                case 3:
                    ResumeService.updateResume(resumeList);
                    break;
                case 4:
                    ResumeService.searchResume(resumeList);
                    break;
                case 5:
                    DataOperate.saveData(resumeList);
                    c = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }

        }
        input.close();
        System.out.println("您已经退出hr系统");
    }
}
