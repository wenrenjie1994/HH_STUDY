package work;

import entity.Resume;
import entity.ReturnResult;

import java.util.LinkedList;

public class Parser {

    public ReturnResult addOrDeleteOrUpdateResume(String msg){
        ReturnResult rr = new ReturnResult();
        String[] returnMsg = msg.split("/n");
        if("true".equals(returnMsg[0])){
            rr.isSuccess=true;
        }
        else {
            rr.isSuccess=false;
            rr.failReason=returnMsg[1];
        }
        return rr;
    }

    public ReturnResult searchResume(String msg){
        ReturnResult rr =new ReturnResult();
        String[] returnMsg = msg.split("/n");
        if("true".equals(returnMsg[0])){
            rr.isSuccess=true;
            String[] resumesInfo=returnMsg[1].split(";");
            LinkedList<Resume> list=new LinkedList<>();
            for (String resumeInfo:resumesInfo) {
                 String[] res = resumeInfo.split(",");
                 Resume resume = new Resume(Integer.parseInt(res[0]),res[1],res[2],res[3]);
                 list.add(resume);
            }
            rr.resultData=list;
        }
        else {
            rr.isSuccess=false;
            rr.failReason=returnMsg[1];
        }
        return rr;
    }
}
