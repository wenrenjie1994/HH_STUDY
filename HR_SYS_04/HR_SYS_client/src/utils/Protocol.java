package utils;

import bean.Resume;


public class Protocol {

	public String AddResumeMessage(Resume resume)
	{
		String str="add/n"+resume.getName()+","+resume.getId()+","+resume.getSchool();
		return str;
	}
	public String deleteResumeMessage(String id)
	{
		String str="deletebyid/n"+id;
		return str;
	}
	public String updateResumeMessage(Resume resume, String id)
	{
		String str="update/n"+resume.getName()+","+resume.getId()+","+resume.getSchool()+";"+id;
		return str;
	}
	public String selectResumeByIdMessage(String id)
	{
		String str="searchbyid/n"+id;
		return str;
	}
	public String selectResumeByNameMessage(String name)
	{
		String str="searchbyname/n"+name;
		return str;
	}
	public String selectResumeBySchoolMessage(String school)
	{
		String str="searchbyschool/n"+school;
		return str;
	}
	public String selectAllResumeMessage()
	{
		String str="searchall/nSelectAll";
		return str;
	}
	public String closenetMessage(String string)
	{
		String str=string+"/n";
		return str;
	}
}

