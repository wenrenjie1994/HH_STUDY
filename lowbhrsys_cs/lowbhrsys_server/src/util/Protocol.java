package util;

import medol.ActionResult;
import medol.ResumeList;

public class Protocol {
	public Protocol()
	{
		
	}
	/*
	 * 把ActionResult的三个属性按ActionResult.isSuccess+"/n"+failReason或者ActionResult.isSuccess+"/n"+（ActionResult.resultData
	 * 得到的字符串）格式编写
	 * 在for循环里得到ActionResult.resultData的字符串
	 * */
	public String CRUDResumeMessage(ActionResult ar)
	{	
		String str;
		String isSuccess = ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str = isSuccess+"/n";
		}
		else
		{
			str = isSuccess+"/n"+ar.failReason;
		}
		return str;
	}

	public String searchResumeMessage(ActionResult ar)
	{
		String str;
		String isSuccess = ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			ResumeList resumeList = (ResumeList)ar.resultData;
			str = isSuccess+"/n";
			//for循环得到ActionResult.resultData字符对应的字符串
			int resumeSize = resumeList.size();
			for(int i=0;i<resumeSize;i++)
			{
				String resumeString = resumeList.get(i).getName()+","+resumeList.get(i).getId()+","+
						resumeList.get(i).getSchool()+","+resumeList.get(i).getProcess()+";";
				str = str + resumeString;
			}
		}
		else
		{
			str = isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
}
