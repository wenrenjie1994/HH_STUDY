package work;

import entity.Resume;
import entity.ReturnResult;

import java.util.LinkedList;

public class Protocol {
    public static String addResumeMessage(ReturnResult rr) {
        if(rr.isSuccess) {
           return rr.isSuccess+"/n";
        }
        else {
            return rr.isSuccess+"/n"+rr.failReason;
        }
    }

    public static String deleteResumeMessage(ReturnResult rr) {
        if(rr.isSuccess) {
            return rr.isSuccess+"/n";
        }
        else {
            return rr.isSuccess+"/n"+rr.failReason;
        }
    }


    public static String updateResumeMessage(ReturnResult rr) {
        if(rr.isSuccess) {
            return rr.isSuccess+"/n";
        }
        else {
            return rr.isSuccess+"/n"+rr.failReason;
        }
    }



    public static String findResumeMessage(ReturnResult rr)
    {
        String str;
        if(rr.isSuccess)
        {
            LinkedList<Resume>resumeList= (LinkedList<Resume>) rr.resultData;
            str=rr.isSuccess+"/n";
            //for循环得到ActionResult.resultData字符对应的字符串

            for(Resume resume:resumeList)
            {
                String string=resume.getId()+","+resume.getName()+","+resume.getSchool()+","+resume.getPosition()+";";
                str=str+string;
            }
        }
        else
        {
            str=rr.isSuccess+"/n"+rr.failReason;
        }
        return str;
    }



}
