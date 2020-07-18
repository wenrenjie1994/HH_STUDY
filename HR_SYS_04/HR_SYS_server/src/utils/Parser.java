package utils;


import bean.Resume;
import bean.ResumeList;
import bean.ReturnResult;

public class Parser {

	static String[] amessage;
	static String head;
	static String message;

	static ReturnResult ss;

	public ReturnResult parser(String str){

		amessage = str.split("/n");
		head=amessage[0];
		message=amessage[1];

		ss=new ReturnResult();
		ss.head = head;
		if(head.equals("add"))
		{
			ResumeList resumeList=parserAdd(message);
			ss.resultData=resumeList;
		}
		else if(head.equals("deletebyid"))
		{
			//String id =parserDeleteById(message);
			ss.resultData=message;
		}
		else if(head.equals("update"))
		{
			ResumeList resumeList=parserUpdate(message);
			ss.resultData=resumeList;
		}
		else if(head.equals("searchbyid"))
		{
			//String id =parserSearchById(message);
			ss.resultData=message;
		}
		else if(head.equals("searchbyname"))
		{
			//String name =parserSearchByName(message);
			ss.resultData=message;
		}
		else if(head.equals("searchbyschool"))
		{
			//String school =parserSearchBySchool(message);
			ss.resultData=message;
		}
		else if(head.equals("searchall"))
		{
			//ResumeList resumeList=parserSearchAll();
			ss.resultData=null;
		}


		return ss;
	}

	private ResumeList parserUpdate(String message) {
		String[] str=message.split(";");
		String[] resume=str[0].split(",");
		String name=resume[0];
		String id=resume[1];
		String school=resume[2];
		Resume newR = new Resume(name,id,school);
		ResumeList list = new ResumeList();
		list.add(newR);
		return list;
	}


	private ResumeList parserAdd(String message) {
		String[] split = message.split(",");
		String name = split[0];
		String id = split[1];
		String school = split[2];

		Resume resume = new Resume(name, id, school);
		ResumeList resumeList = new ResumeList();
		resumeList.add(resume);
		return resumeList;
	}


}