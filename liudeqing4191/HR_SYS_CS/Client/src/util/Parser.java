package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

public class Parser 
{
	/**先以“/n”劈开得到是否成功和成功结果或者失败原因
	 * 如果失败 returnResult.isSuccess=false returnResult.failReason为劈开的第二部分
	 * 成功了returnResult.isSuccess=true
	 * 再以“;”劈开各个同学
	 * 再以“，”劈开每个同学的五个属性分别赋给Resume存到ResumeList
	 * 再把ResumeList放到returnResult.resultData里
	 * 返回returnResult
	 * */
	public ReturnResult parserAdd(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}
	public ReturnResult parserDelete(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}
	public ReturnResult parserUpdate(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}
	public ReturnResult parserSearch(String message)
	{  
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;

			String[] resumeinfo=amessage[1].split(";");
			ResumeList resumes=new ResumeList();
			int resumesSize=resumeinfo.length;
			for(int i=0;i<resumesSize;i++)
			{
				String[] resume=resumeinfo[i].split(",");
				String resumeId=resume[0];
				String resumeName=resume[1];
				String resumeSchool=resume[2];
				int resumeProcess=Integer.parseInt(resume[3]);
				int resumeDeleteStatus=Integer.parseInt(resume[4]);
				Resume aresume=new Resume(resumeId,resumeName);
				aresume.setSchool(resumeSchool);
				aresume.setProcess(resumeProcess);
				aresume.setDeleteStatus(resumeDeleteStatus);
				resumes.add(aresume);
			}
			returnResult.resultData=resumes;
		}
		else
		{
			returnResult.isSuccess = false;
			ResumeList resumes=new ResumeList();
			returnResult.failReason =amessage[1];
			returnResult.resultData=resumes;
		}
		return returnResult;
	}

}