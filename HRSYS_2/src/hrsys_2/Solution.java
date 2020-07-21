package hrsys_2;
import operate.ResumeOperate;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
        boolean notExit = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*****欢迎进入简历管理系统*****");
            System.out.println("查看所有简历——0");
            System.out.println("查看指定简历状态的简历——1");
            System.out.println("添加指定简历——2");
            System.out.println("删除指定简历——3");
            System.out.println("修改指定简历——4");
            System.out.println("查询指定简历——5");
            System.out.println("退出HR系统——6");
            /**
             * 错误：所有选项“否”退出都会出错
             * 思考：能否自行控制功能目录的跳出
             */
            switch (sc.nextInt()) {
                case 0:
                    ResumeOperate.showResume();
                    break;
                case 1:
                    ResumeOperate.showAppointResume();
                    break;
                case 2:
                    ResumeOperate.addResume();
                    break;
                case 3:
                    ResumeOperate.deleteResume();
                    break;
                case 4:
                    ResumeOperate.updateResume();
                    break;
                case 5:
                    ResumeOperate.searchResume();
                    break;
                case 6:
                	notExit = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }while (notExit);
        sc.close();
        System.out.println("已退出HR系统");
	}

}