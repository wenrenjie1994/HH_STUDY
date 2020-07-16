package util;

import model.Resume;

public class Protocol {
	public Protocol()
	{
		
	}
	public String AddResumeMessage(Resume resume)
	{
		String str="add/n"+resume.getId()+","+resume.getName()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus();
		return str;
	}
	public String deleteResumeMessage(Resume resume)
	{
		String str="delete/n"+resume.getId();
		return str;
	}
	
	public String updateResumeMessage(Resume resume)
	{
		String str="add/n"+resume.getId()+","+resume.getName()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus();
		return str;
	}
	public String searchResumeByIdMessage(Resume resume)
	{
		String str="searchbyid/n"+resume.getId();
		return str;
	}
	public String searchResumeByNameMessage(Resume resume)
	{
		String str="searchbyname/n"+resume.getName();
		return str;
	}
	public String searchResumeBySchoolMessage(Resume resume)
	{
		String str="searchbyschool/n"+resume.getSchool();
		return str;
	}
	public String searchResumeByProcessMessage(Resume resume)
	{
		String str="searchbyprocess/n"+resume.getProcess();
		return str;
	}
	public String searchResumeByKeyMessage(Resume resume)
	{
		String str="searchbykey/n"+resume.getName();
		return str;
	}

//	public String closenetMessage(String string)
//	{
//		String str=string+"/n";
//		return str;
//	}
}

