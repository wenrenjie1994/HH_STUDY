package util;

import model.*;

public class Parser {
    /**先以“/n”劈开得到是否成功和成功结果或者失败原因
     * 如果失败 returnResult.isSuccess=false returnResult.failReason为劈开的第二部分
     * 成功了returnResult.isSuccess=true
     * 再以“;”劈开各面试者
     * 再以“，”劈开每个面试者的5个属性分别赋给Interviewee存到IntervieweeList
     * 再把IntervieweeList放到returnResult.resultData里
     * 返回returnResult
     * */
    public ReturnResult parserOther(String message){
        ReturnResult returnResult = new ReturnResult();
        String[] messages=message.split("/n");
        if(messages[0].equals("Success")) {
            returnResult.isSuccess = true;
        } else {
            returnResult.failReason = messages[1];
        }
        return returnResult;
    }

    public ReturnResult parserSearch(String message){
        ReturnResult returnResult = new ReturnResult();
        String[] messages=message.split("/n");
        if(messages[0].equals("Success")){
            returnResult.isSuccess = true;
            String[] intervieweeInfo = messages[1].split(";");
            IntervieweeList iList = new IntervieweeList();
            int size = intervieweeInfo.length;
            for(int i=0; i<size; i++){
                String[] interviewee = intervieweeInfo[i].split(",");
                String name = interviewee[0];
                int age = Integer.parseInt(interviewee[1]);
                String school = interviewee[2];
                String ID = interviewee[3];
                String position = interviewee[4];
                Interviewee recruit = new Interviewee(name,age,school,ID,position);
                iList.add(recruit);
            }
            returnResult.resultData = iList;
        }else{
            returnResult.isSuccess = false;
            IntervieweeList iList = new IntervieweeList();
            returnResult.failReason = messages[1];
            returnResult.resultData = iList;
        }
        return returnResult;
    }
}
