package util;

import model.ServiceResult;
import model.IntervieweeList;

public class Protocol {
    public Protocol()
    {

    }
    /*
     * 把ServiceResult的三个属性按ServiceResult.isSuccess+"/n"+failReason或者ServiceResult.isSuccess+"/n"+（ServiceResult.resultData
     * 得到的字符串）格式编写
     * 在for循环里得到ServiceResult.resultData的字符串
     * */

    public String getReturnMessage(ServiceResult sr){
        String str;
        String isSuccess = sr.isSuccess;
        if(isSuccess.equals("Success")){
            str = isSuccess + "/n";
        }
        else{
            str = isSuccess + "/n" + sr.failReason;
        }
        return str;
    }
    public String getSearchMessage(ServiceResult sr){
        String str;
        String isSuccess = sr.isSuccess;
        if(isSuccess.equals("Success")){
            IntervieweeList iList = (IntervieweeList)sr.resultData;
            str = isSuccess + "/n";
            int size = iList.size();
            for(int i = 0;i < size; i++){
                String intervieweeString = iList.get(i).getName() + "," + iList.get(i).getAge() + "," + iList.get(i).getSchool() + "," + iList.get(i).getID() + "," + iList.get(i).getPosition() + ";";
                str += intervieweeString;
            }
        }
        else{
            str = isSuccess + "/n" + sr.failReason;
        }
        return str;
    }
}
