package util;

import model.ActionResult;
import model.ResumeList;

public class Protocol {
	public Protocol()
	{
		
	}
	/*
	 * 把ActionResult的三个属性按ActionResult.isSuccess+"/n"+failReason或者ActionResult.isSuccess+"/n"+（ActionResult.resultData
	 * 得到的字符串）格式编写
	 * 在for循环里得到ActionResult.resultData的字符串
	 * */
	public String AddResumeMessage(ActionResult ar)
	{	
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}

	public String DeleteResumeMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String changeResumeMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
}
