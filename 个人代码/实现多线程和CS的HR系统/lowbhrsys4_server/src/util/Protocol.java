package util;

import model.ActionResult;
import model.Resume;

import java.util.ArrayList;

/**
 * 解析客户端请求信息和封装服务器端返回信息
 * @author 杜波
 * @version 创建时间: 2020/7/19 22:03
 */
public class Protocol {

	/**
	 * 1.拼装ActionResult的属性按ActionResult.isSuccess+"/n"
	 * 2.拼装ActionResult的属性按ActionResult.isSuccess+"/n"+failReason+"/n"
	 * 3.拼装ActionResult的属性按ActionResult.isSuccess+"/n"+ActionResult.resultData+"/n"
	 */
	public static String assembleMessage(ActionResult ar)
	{
		String str;
		boolean isSuccess=ar.getIsSuccess();
		if(isSuccess)
		{
			if(ar.getResultData()!=null){
				ArrayList<Resume> list=(ArrayList)ar.getResultData();
				str=isSuccess+"/n";
				for(int i=0;i<list.size();i++)
				{
					String bookstring=list.get(i).getResumeId()+","+list.get(i).getName()+","+list.get(i).getId()+","+list.get(i).getSchool()+","+list.get(i).getProcess()+";";
					str=str+bookstring;
				}
			}else {
				str=isSuccess+"/n";
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
}
