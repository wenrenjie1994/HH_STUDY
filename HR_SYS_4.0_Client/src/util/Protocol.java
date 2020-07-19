package util;

import model.Resume;

public class Protocol {
	public Protocol()
	{
		
	}
	public String AddResumeMessage(Resume resume)
	{
		String str="add/n"+resume.getName()+","+resume.getId()+","+resume.getSchool();
		return str;
	}

}

