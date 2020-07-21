package util;


import model.ActionResult;
import model.Resume;
import java.util.ArrayList;

/**
 * 解析服务器端返回的信息
 * @author 杜波
 * @version 创建时间: 2020/7/20 16:37
 */
public class Parser {
	/**先以“/n”劈开得到是否成功和成功结果或者失败原因
	 * 如果失败 returnResult.isSuccess=false returnResult.failReason为劈开的第二部分
	 * 成功了returnResult.isSuccess=true
	 * 再以“;”劈开各简历
	 * 再以“，”劈开简历的各个属性
	 * 再把list放到returnResult.resultData里
	 * 返回returnResult
	 * */
	public static ActionResult parserMessage(String message) {
		ActionResult returnResult = new ActionResult();
		String[] messages=message.split("/n");
		returnResult.setIsSuccess(Boolean.parseBoolean(messages[0]));
		int size=2;
		if(messages.length==size) {
			if(returnResult.getIsSuccess()){
				ArrayList<Resume> list=new ArrayList<>();
				String[] resumeInfo=messages[1].split(";");
				for(int i=0;i<resumeInfo.length;i++)
				{
					Resume resume=new Resume();
					String[] resumes=resumeInfo[i].split(",");
					resume.setResumeId(resumes[0]);
					resume.setName(resumes[1]);
					resume.setId(resumes[2]);
					resume.setSchool(resumes[3]);
					resume.setProcess(Integer.parseInt(resumes[4]));
					list.add(resume);

				}
				returnResult.setResultData(list);
			}else{
				returnResult.setFailReason(messages[1]);
			}


		}
		return returnResult;
	}

	public static void printResume(Object object){
		ArrayList<Resume> list=(ArrayList)object;
		System.out.println("简历ID  姓名  身份证号  学校名称  简历状态");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getResumeId()+" "+list.get(i).getName()+" "+list.get(i).getId()+" "+list.get(i).getSchool()+" "+list.get(i).getProcess());
		}
	}

}