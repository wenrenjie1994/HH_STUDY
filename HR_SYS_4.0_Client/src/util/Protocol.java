package util;

import model.Resume;

public class Protocol {
	public Protocol()
	{
		
	}
	public String AddResumeMessage(Resume resume)
	{
		String str="add/n"+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus();
		return str;
	}
	public String deleteResumeById(Resume resume)
	{
		String str="deletebyid/n"+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus();
		return str;
	}

	public String changeResumeMessage(Resume resume,Resume oldresume)
	{
		String str="change/n"+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus()+";"
				+oldresume.getId();
		return str;
	}

}

