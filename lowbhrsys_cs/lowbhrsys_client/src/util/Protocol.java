package util;

import model.Resume;

public class Protocol {
	public Protocol()
	{
		
	}
	public String AddResumeMessage(Resume resume)
	{
		String str="add/n"+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess();
		return str;
	}
	public String deleteResumeByNameMessage(Resume resume)
	{
		String str="deletebyname/n"+resume.getName();
		return str;
	}
	public String deleteResumeByIdMessage(Resume resume)
	{
		String str="deletebyid/n"+resume.getId();
		return str;
	}
	public String changeResumeMessage(Resume resume, Resume oldResume)
	{
		String str="change/n"+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+";"+
				oldResume.getName()+","+oldResume.getId()+","+oldResume.getSchool()+","+oldResume.getProcess();
		return str;
	}
	public String searchResumeByNameMessage(Resume resume)
	{
		String str="searchbyname/n"+resume.getName();
		return str;
	}
	public String searchResumeByIdMessage(Resume resume)
	{
		String str="searchbyid/n"+resume.getId();
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
	public String searchResumeByKeyWordMessage(Resume resume)
	{
		String str="searchbykeyword/n"+resume.getName();
		return str;
	}
	public String listAllResumeInfoMessage()
	{
		String str="listallinfo";
		return str;
	}
	public String closeNetMessage(String string)
	{
		String str=string+"/n";
		return str;
	}
}

