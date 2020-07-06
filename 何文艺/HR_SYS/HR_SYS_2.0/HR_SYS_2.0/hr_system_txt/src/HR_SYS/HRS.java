package HR_SYS;

import ioOperation.DataOperation;
import model.Resume;
import service.ResumeService;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @program: HR_SYS_2.0（基于txt文件）
 * @className: HRS
 * @description: 招聘系统
 * @author: 何文艺
 * @creat: 2020/7/6 15:59
 **/
public class HRS {
    public static void main(String[] args) {
        LinkedList<Resume> resumeLinkedList = new LinkedList<Resume>();//存储简历的链表
        Scanner input = new Scanner(System.in);//获取标准输入流
        DataOperation.loadData(resumeLinkedList);//加载所有图书

        while (true) {
            System.out.println("-------LOWEST HR SYSTEM 1.0-------");
            System.out.println("----------添加简历请输入1----------");
            System.out.println("----------删除简历请输入2----------");
            System.out.println("----------修改简历请输入3----------");
            System.out.println("----------查找简历请输入4----------");
            System.out.println("----------想要退出请输入5----------");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    ResumeService.addResume(resumeLinkedList);
                    break;
                case 2:
                    ResumeService.deleteResume(resumeLinkedList);
                    break;
                case 3:
                    ResumeService.updateResume(resumeLinkedList);
                    break;
                case 4:
                    ResumeService.searchResume(resumeLinkedList);
                    break;
                case 5:
                    break;//该break;只会退出switch语句
                default:
                    System.out.println("输入错误！");
            }
            if (choice == 5) {
                break;//如果要退出系统需要退出while循环
            }
        }
        input.close();//关闭输入流
        System.out.println("您已经退出招聘系统！");
    }
}
