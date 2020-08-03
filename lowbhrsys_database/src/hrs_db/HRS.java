/**
 * A program for JAVA作业---图书管理系统
 * @version 2.0 2016-03-23
 * @author 文仁杰 2014214225
 */
package hrs_db;
import bean.Resume;
import bean.ResumeList;
import work.Action;

import java.util.Scanner;


public class HRS{
	public HRS(){
		Scanner input = new Scanner(System.in);
		//*************************主页面提示*******************************
		while(true){
			//.openData();
			System.out.println("************欢迎来到HR管理系统************");
			System.out.println("录入员工信息请按----------1");
			System.out.println("删除员工信息请按----------2");
			System.out.println("修改员工信息请按----------3");
			System.out.println("查询员工信息请按----------4");
			System.out.println("列出全部员工信息请按-------5");
			System.out.println("退出请按-----------------6");
		//if语句指令判断
			int choice =input.nextInt();
			if(choice==1){
				addResume();
			}
			else if(choice==2){
				deleteResume();
			}
			else if(choice==3){
				changeResume();
			}
			else if(choice==4){
				searchResume();
			}
			else if(choice==5){
				listAllResume();
			}
			else if(choice==6){
				break;
			}
			else{
				System.out.println("输入错误，请确认后重新输入");
			}
		}
		System.out.println("您已退出HR管理系统");
	}

	//*************************添加信息*******************************
	void addResume(){
		System.out.println("欢迎来到员工信息录入界面");
		Scanner input = new Scanner(System.in);
		System.out.println("请依次输入需要录入员工的名字，身份证号，学校，申请进度");
		String workerName = input.nextLine();
		String workerId = input.nextLine();
		String workerSchool = input.nextLine();
		int preProcess = input.nextInt();
		while (preProcess > 6 || preProcess <0){
			System.out.println("申请进度只能为0-6，请重新输入：");
			preProcess = input.nextInt();
		}
		int process = preProcess;

		Resume resume = new Resume(workerName, workerId, workerSchool, process);
		Action action = new Action("resumes");
		int line = action.addResumeInfo(resume);
		if(line>0){
			System.out.println("添加员工信息成功");
		}
		else {
			System.out.println("添加员工信息失败");
		}
	}
	//*************************删除信息*******************************
	void deleteResume(){
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("************欢迎来到员工信息删除界面************");
			System.out.println("按名字删除请按----------1");
			System.out.println("按id删除请按-----------2");
			System.out.println("退出请按---------------3");
			int choice =input.nextInt();
			if(choice==1){
				deleteByName();
			}
			else if(choice==2){
				deleteByAuthor();
			}
			else if(choice==3){
				break;
			}
		}

	}

	void deleteByName(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要删除的员工名字");
		String workerName = input.nextLine();
		Resume resume = new Resume(workerName,null,null,-1);
		Action action = new Action("resumes");
		int line = action.deleteResumeByName(resume);
		if(line>0){
			System.out.println("删除员工信息成功");
		}
		else {
			System.out.println("没有找到该员工，无法删除");
		}
	}

	void deleteByAuthor(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要删除的员工id");
		String workerId = input.nextLine();
		Resume resume = new Resume(null, workerId,null, -1);
		Action action = new Action("resumes");
		int line = action.deleteResumeById(resume);
		if(line>0){
			System.out.println("删除员工成功");
		}
		else{
			System.out.println("没有找到该员工，无法删除");
		}
	}

	//*************************修改信息*******************************
	void changeResume(){
		System.out.println("欢迎来到员工信息修改界面");
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要修改员工的身份证号");
		String oldWorkerId = input.nextLine();;

		System.out.println("请依次输入修改后员工的名字，身份证号，学校，申请进度");
		String workerName = input.nextLine();
		String workerId = input.nextLine();
		String workerSchool = input.nextLine();
		int preProcess = Integer.parseInt(input.nextLine());
		while (preProcess > 6 || preProcess <0){
			System.out.println("申请进度只能为0-6，请重新输入：");
			preProcess = input.nextInt();
		}
		int process = preProcess;

		Resume old_resume = new Resume(null, oldWorkerId, null, -1);
		Resume resume = new Resume(workerName, workerId, workerSchool, process);
		Action action = new Action("resumes");
		int line = action.changeResumeInfo(resume, old_resume);
		if(line>0){
			System.out.println("修改员工信息成功");
		}
		else {
			System.out.println("修改员工信息失败");
		}
	}

	//*************************查询信息*******************************
	void searchResume(){
		while(true){
			System.out.println("************欢迎来到员工查询界面************");
			System.out.println("按姓名查找请按----------1");
			System.out.println("按id查找请按----------2");
			System.out.println("按学校查找请按----------3");
			System.out.println("模糊查找请按------------4");
			System.out.println("退出请按----------------5");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			if(choice==1){
				searchResumeByName();
			}
			else if(choice==2){
				searchResumeById();
			}
			else if(choice==3){
				searchResumeBySchool();
			}
			else if(choice==4){
				searchResumeByPointWord();
			}
			else if(choice==5){
				break;
			}
			else{
				System.out.println("请输入数字1-5");
			}
		}

	}

	void searchResumeByName(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要查询的员工姓名");
		String workerName = input.nextLine();
		Resume resume = new Resume(workerName,null,null, -1);
		Action action = new Action("resumes");
		ResumeList resumeList = action.searchResumeByName(resume);
		int resumeCount = resumeList.size();
		if(resumeCount>0){
			for(int i=0; i<resumeCount; i++){
				System.out.println("姓名："+resumeList.get(i).getName()+"  "
									+"id:"+"："+resumeList.get(i).getId()+"  "
									+"学校"+"："+resumeList.get(i).getSchool()+"  "
						            +"进度"+"："+resumeList.get(i).getProcess());
			}
		}
		else {
			System.out.println("没有找到姓名为"+workerName+"的员工");
		}
	}

	void searchResumeById(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要查询的员工id");
		String workerId = input.nextLine();
		Resume resume = new Resume(null, workerId,null, -1);
		Action action = new Action("resumes");
		ResumeList resumeList = action.searchResumeById(resume);
		int resumeCount = resumeList.size();
		if(resumeCount>0){
			for(int i=0;i<resumeCount;i++)
				System.out.println("姓名："+resumeList.get(i).getName()+"  "
						+"id:"+"："+resumeList.get(i).getId()+"  "
						+"学校"+"："+resumeList.get(i).getSchool()+"  "
						+"进度"+"："+resumeList.get(i).getProcess());
			}
		else
			System.out.println("没有找到id为"+workerId+"的员工");
	}

	void searchResumeBySchool(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要查询的员工的学校");
		String workerSchool = input.nextLine();
		Resume resume = new Resume(null,null,workerSchool,-1);
		Action action = new Action("resumes");
		ResumeList resumeList = action.searchResumeBySchool(resume);
		int resumeCount = resumeList.size();
		if(resumeCount>0){
			for(int i=0;i<resumeCount;i++)
				System.out.println("姓名："+resumeList.get(i).getName()+"  "
						+"id:"+"："+resumeList.get(i).getId()+"  "
						+"学校"+"："+resumeList.get(i).getSchool()+"  "
						+"进度"+"："+resumeList.get(i).getProcess());
		}
		else {
			System.out.println("没有找到学校为"+workerSchool+"的员工");
		}
	}

	void searchResumeByPointWord(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入关键字");
		String keyWord = input.nextLine();

		Action action = new Action("resumes");
		ResumeList resumeList;
		if(!Character.isDigit(keyWord.charAt(0))){
			Resume resume = new Resume(keyWord,null,keyWord,-1);
			resumeList = action.searchResumeByPointword(resume);
		}
		else{
			Resume resumeId = new Resume(null,keyWord,null,Integer.parseInt(keyWord));
			resumeList = action.searchResumeByPointword(resumeId);
		}
		int resumeCount = resumeList.size();
		if(resumeCount>0){
			for(int i=0;i<resumeCount;i++)
				System.out.println("姓名："+resumeList.get(i).getName()+"  "
						+"id:"+"："+resumeList.get(i).getId()+"  "
						+"学校"+"："+resumeList.get(i).getSchool()+"  "
						+"进度"+"："+resumeList.get(i).getProcess());
		}
		else {
			System.out.println("没有找到与"+keyWord+"相关的员工信息");
		}
	}

	void listAllResume(){
		Action action = new Action("resumes");
		ResumeList resumeList = action.listAllResumeInfo();
		int resumeCount = resumeList.size();
		if(resumeCount>0){
			for(int i=0;i<resumeCount;i++)
				System.out.println("姓名："+resumeList.get(i).getName()+"  "
						+"id:"+"："+resumeList.get(i).getId()+"  "
						+"学校"+"："+resumeList.get(i).getSchool()+"  "
						+"进度"+"："+resumeList.get(i).getProcess());
		}
		else {
			System.out.println("数据库中无员工");
		}
	}

	public static void main(String[] args){
		new HRS();
	}
}