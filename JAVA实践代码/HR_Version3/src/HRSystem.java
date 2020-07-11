import service.ResumeService;

import java.util.Scanner;

/**
 * @author 熊彩铃
 * @program HR_Version3数据库版招聘系统
 * @description 数据库版招聘系统
 * @date 2020/7/11 14:52
 */
public class HRSystem {
    public HRSystem(){
        Scanner input = new Scanner(System.in);
        ResumeService resumeService = new ResumeService();

        while(true){
            System.out.println("********欢迎进入招聘系统*********");

            System.out.println("添加简历信息请按1");
            System.out.println("删除简历信息请按2");
            System.out.println("修改简历信息请按3");
            System.out.println("查找简历信息请按4");
            System.out.println("退出招聘系统请按0");

            Integer choice = input.nextInt();

            if(choice==1){
                resumeService.addResume();
            }else if(choice==2){
                resumeService.deleteResume();
            }else if(choice==3){
                resumeService.modifyResume();
            }else if(choice==4){
                resumeService.queryResume();
            }else if(choice==0){
                break;
            }else{
                System.out.println("输入有误，请重新输入0-4的整数");
            }
        }
    }
    public static void main(String[] args){
        new HRSystem();
    }

}
