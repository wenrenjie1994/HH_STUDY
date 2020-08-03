package util;

import medol.Resume;
import medol.ResumeList;
import medol.ReturnResult;

public class Parser
{
	public Parser()
	{
		
	}
	static String[] amessage;
	static String head;
	static ReturnResult ss;
	static String message;

	public ReturnResult parser(String str)
	{
		/*
		 * 先按“/n”劈开得到想要的操作和操作数据
		 * if语句判断操作
		 * 把操作数据用相应的parser方法解析存到BookList中
		 * 令ReturnResult的head = 劈开得到的head
		 * 令ReturnResult的resultData等于BookList
		 * */
		amessage = str.split("/n");
		head = amessage[0];
		message = amessage[1];
		ss = new ReturnResult();
		ss.head = head;
		if(head.equals("add"))
		{
			ResumeList resumeList = parserAdd(message);
			ss.resultData = resumeList;
		}
		else if(head.equals("deletebyname"))
		{
			ResumeList resumeList = parserDeleteByName(message);
			ss.resultData = resumeList;
		}
		else if(head.equals("deletebyid"))
		{
			ResumeList resumeList = parserDeleteById(message);
			ss.resultData = resumeList;
		}
		else if(head.equals("change"))
		{
			ResumeList resumeList = parserChangeResume(message);
			ss.resultData = resumeList;
		}
		else if(head.equals("searchbyname"))
		{
			ResumeList resumeList = parserSearchByName(message);
			ss.resultData = resumeList;
		}
		else if(head.equals("searchbyid"))
		{
			ResumeList resumeList = parserSearchById(message);
			ss.resultData = resumeList;
		}
		else if(head.equals("searchbyschool"))
		{
			ResumeList resumeList = parserSearchBySchool(message);
			ss.resultData = resumeList;
		}
		else if(head.equals("searchbyprocess"))
		{
			ResumeList resumeList = parserSearchByProcess(message);
			ss.resultData = resumeList;
		}
		else if(head.equals("searchbykeyword"))
		{
			ResumeList resumeList = parserSearchByKeyWord(message);
			ss.resultData = resumeList;
		}
		return ss;
		
	}
	/*
	 * “;”劈开得到Book的三个属性
	 * 	","劈开book的三个属性存在Book中
	 * 最后都存在resumeList中返回
	 * * */
	public ResumeList parserAdd(String message) {
		String[] str = message.split(",");
		String workerName = str[0];
		String workerId = str[1];
		String workerSchool = str[2];
		int preProcess = Integer.parseInt(str[3]);
		Resume resume = new Resume(workerName, workerId, workerSchool, preProcess);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;
		
	}

	public ResumeList parserDeleteByName(String message) {
		String workerName = message;
		String workerId = null;
		String workerSchool = null;
		int preProcess = 0;
		Resume resume = new Resume(workerName, workerId, workerSchool, preProcess);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;
	}

	public ResumeList parserDeleteById(String message) {
		String workerName = null;
		String workerId = message;
		String workerSchool = null;
		int preProcess = 0;
		Resume resume = new Resume(workerName, workerId, workerSchool, preProcess);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;
	}

	public ResumeList parserDeleteBySchool(String message) {
		String workerName = null;
		String workerId = null;
		String workerSchool = message;
		int preProcess = 0;
		Resume resume = new Resume(workerName, workerId, workerSchool, preProcess);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;
	}

	public ResumeList parserChangeResume(String message) {
		String[] str = message.split(";");
		String[] oldResumeMessage = str[0].split(",");
		String oldWorkerName = oldResumeMessage[0];
		String oldWorkerId = oldResumeMessage[1];
		String oldWorkerSchool = oldResumeMessage[2];
		int oldPreProcess = Integer.parseInt(oldResumeMessage[3]);

		String[] resumeMessage = str[1].split(",");
		String workerName = resumeMessage[0];
		String workerId = resumeMessage[1];
		String workerSchool = resumeMessage[2];
		int preProcess = Integer.parseInt(resumeMessage[3]);

		Resume oldResume = new Resume(oldWorkerName, oldWorkerId, oldWorkerSchool, oldPreProcess);
		ResumeList resumeList = new ResumeList();
		resumeList.add(oldResume);
		Resume resume = new Resume(workerName, workerId, workerSchool, preProcess);
		resumeList.add(resume);
		return resumeList;
	}

	public ResumeList parserSearchByName(String message) {
		String workerName = message;
		Resume resume = new Resume(workerName, null, null, 0);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;
		
	}

	public ResumeList parserSearchById(String message) {
		String workerId = message;
		Resume resume = new Resume(null, workerId, null, 0);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;
		
	}

	public ResumeList parserSearchBySchool(String message) {
		String workerSchool = message;
		Resume resume = new Resume(null, null, workerSchool, 0);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;

	}

	public ResumeList parserSearchByProcess(String message) {
		int preProcess = Integer.parseInt(message);
		Resume resume = new Resume(null, null, null, preProcess);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;
	}

	public ResumeList parserSearchByKeyWord(String message) {
		String workerName = message;
		Resume resume = new Resume(workerName, null, null, 0);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;
	}
}
