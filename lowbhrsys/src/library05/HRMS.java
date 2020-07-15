/**
 * A program for 文本读写---简历管理系统
 * @version 2.0 2020-07-15
 * @author 王科文
 */
package library05;
import java.util.LinkedList;
import java.util.Scanner;
import loadandsaveData.DataOperate;
import model.Resume;
import service.ResumeService;

public class HRMS
{
	public static void main(String[] args) {

		LinkedList<Resume> resumeList = new LinkedList<Resume>();
		Scanner input = new Scanner(System.in);
		DataOperate.loadData(resumeList);//下载所有图书
		while(true)
		{
			System.out.println("************欢迎来到王老板简历管理系统************");
			System.out.println("增加简历请按----------1");
			System.out.println("删除简历请按----------2");
			System.out.println("修改简历请按----------3");
			System.out.println("查询简历请按----------4");
			System.out.println("退出并保存请按--------------5");
		//if语句指令判断
			int choice =input.nextInt();
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
				ResumeService.updateBook(resumeList);
			}
			else if(choice==4)
			{
				ResumeService.showBook(resumeList);
			}
			else if(choice==5)
			{
				DataOperate.saveData(resumeList);
				break;
			}
			else {
				System.out.println("输入错误，请确认后从新输入");
			}
		}
		System.out.println("您已退出简历管理系统");
	}
}