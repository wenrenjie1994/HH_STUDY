import model.Resume;
import service.ResumeService;
import service.loadAndSaveService;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 熊彩铃
 * @program HR_Version2
 * @description 招聘系统文本储蓄版
 * @date 2020/7/6 0:54
 */
public class HRSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner((System.in));
        ResumeService resumeService = new ResumeService();
        LinkedList<Resume> resumeLinkedList = new loadAndSaveService().load();

        while (true) {
            System.out.println("*****欢迎进入招聘系统*****");

            System.out.println("添加简历信息请按 1");
            System.out.println("删除简历信息请按 2");
            System.out.println("修改简历信息请按 3");
            System.out.println("查找简历信息请按 4");
            System.out.println("退出系统请按 0");

            Integer choice = input.nextInt();

            if(choice==1){
                resumeService.addResume(resumeLinkedList);
            }else if(choice==2){
                resumeService.deleteResume(resumeLinkedList);
            }else if(choice==3){
                resumeService.modifyResume(resumeLinkedList);
            }else if(choice==4){
                resumeService.findResume(resumeLinkedList);
            }else if(choice==0){
                loadAndSaveService.save(resumeLinkedList);
                break;
            }else{
                System.out.println("请输入0-4的整数");
            }
        }
    }
}

