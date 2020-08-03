package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

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
	public ReturnResult parserCRUD(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] aMessage=message.split("/n");
		if(aMessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=aMessage[1];
		}
		return returnResult;
	}

	public ReturnResult parserSearch(String message)
	{  
		ReturnResult returnResult = new ReturnResult();
		String[] aMessage=message.split("/n");
		if(aMessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
			String[] resumeInfo=aMessage[1].split(";");
			ResumeList resumeList=new ResumeList();
			int resumeSize=resumeInfo.length;
			for(int i=0;i<resumeSize;i++)
			{
				String[] resumeSte = resumeInfo[i].split(",");
				String resumeName = resumeSte[0];
				String resumeId = resumeSte[1];
				String resumeSchool = resumeSte[2];
				int process = Integer.parseInt(resumeSte[3]);

				Resume resume = new Resume(resumeName,resumeId,resumeSchool,process);
				resumeList.add(resume);
			}
			returnResult.resultData=resumeList;
		}
		else
		{
			returnResult.isSuccess = false;
			ResumeList resumeList = new ResumeList();
			returnResult.failReason = aMessage[1];
			returnResult.resultData = resumeList;
		}
		return returnResult;
	}

}