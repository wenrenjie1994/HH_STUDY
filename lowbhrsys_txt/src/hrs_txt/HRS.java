/**
 * A program for JAVA第一节课作业---图书管理系统
 * @version 1.2 2016-03-11
 * @author 文仁杰 2014214225
 */
package hrs_txt;
import java.util.LinkedList;
import java.util.Scanner;
import loadandsaveData.DataOperate;
import model.Resume;
import service.HRService;

public class HRS
{
	public static void main(String[] args) {

		LinkedList<Resume> resumeList = new LinkedList<Resume>();
		Scanner input = new Scanner(System.in);
		DataOperate.loadData(resumeList);//下载所有图书
		while(true)
		{
			System.out.println("************欢迎来到HR管理系统************");
			System.out.println("录入员工信息请按----------1");
			System.out.println("删除员工信息请按----------2");
			System.out.println("修改员工信息请按----------3");
			System.out.println("查询员工信息请按----------4");
			System.out.println("退出请按--------------5");
		//if语句指令判断
			int choice =input.nextInt();
			if(choice==1)
			{
				HRService.addResume(resumeList);
				DataOperate.saveData(resumeList);
			}
			else if(choice==2)
			{
				HRService.deleteResume(resumeList);
				DataOperate.saveData(resumeList);
			}
			else if(choice==3)
			{
				HRService.updateResume(resumeList);
				DataOperate.saveData(resumeList);
			}
			else if(choice==4)
			{
				HRService.showResume(resumeList);
				DataOperate.saveData(resumeList);
			}
			else if(choice==5)
			{
				break;
			}
			else {
				System.out.println("输入错误，请确认后重新输入");
			}
		}
		System.out.println("您已退出HR管理系统");
	}
}