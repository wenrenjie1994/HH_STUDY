package HrS;

import DataOperate.DataOperate;
import Service.HrService;
import bean.Resume;

import java.util.ArrayList;
import java.util.Scanner;

public class HrS {


        public static void main(String[] args) {

            ArrayList<Resume> resumes = new ArrayList<>();

            Scanner input= new Scanner(System.in);

            DataOperate.loadData(resumes);

            int flag=1;
            while(flag==1) {
                DataOperate.saveData(resumes);
                System.out.println("-----欢迎来到Hr管理系统首页-----");
                System.out.println("----请按照相应的指令完成操作-----");
                System.out.println("新增简历请输入----1");
                System.out.println("查询简历请输入----2");
                System.out.println("修改信息请输入----3");
                System.out.println("办理离职请输入----4");
                System.out.println("退出系统请输入----5");

                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        HrService.addResume(resumes);break;
                    case 2:
                        HrService.searchResume(resumes);break;
                    case 3:
                        HrService.updateResume(resumes);break;
                    case 4:
                        HrService.deleteResume(resumes);break;
                    case 5:
                        flag=0;
                        break;
                    default:
                        System.out.println("请输入正确的操作");

                }
            }
            input.close();
            System.out.println("您已退出Hr管理系统，感谢您的使用");

        }


}
