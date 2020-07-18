package utils;


import bean.Resume;
import bean.ResumeList;
import bean.ReturnResult;


public class Parser
{
	/**先以“/n”劈开得到是否成功和成功结果或者失败原因
	 * 如果失败 returnResult.isSuccess=false returnResult.failReason为劈开的第二部分
	 * 成功了returnResult.isSuccess=true
	 * 再以“;”劈开各本书
	 * 再以“，”劈开每本书的三个属性分别赋给Book存到BookList
	 * 再把BookList放到returnResult.resultData里
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
	public ReturnResult parserChange(String message)
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
			ResumeList resumeList=new ResumeList ();
			int resumesize=resumeinfo.length;
			for(int i=0;i<resumesize;i++)
			{
				String[] resume=resumeinfo[i].split(",");
				String name=resume[0];
				String id=resume[1];
				String school=resume[2];

				Resume newResume = new Resume(name,id,school);
				resumeList.add(newResume);
			}
			returnResult.resultData=resumeList;
		}
		else
		{
			returnResult.isSuccess = false;
			ResumeList resumeList=new ResumeList ();
			returnResult.failReason =amessage[1];
			returnResult.resultData=resumeList;
		}
		return returnResult;
	}

}