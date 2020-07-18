package utils;

import bean.ActionResult;
import bean.ResumeList;

public class Protocol {


    public String AddResumeMessage(ActionResult ar) {
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

    public String DeleteResumeMessage(ActionResult ar) {
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

    public String UpdateResumeMessage(ActionResult ar) {
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

    public String SearchByIdMessage(ActionResult ar) {
        String str;
        String isSuccess=ar.isSuccess;
        if(isSuccess.equals("Success")){
            str=isSuccess+"/n";
            ResumeList resumeList = (ResumeList) ar.resultData;
            for (int i=0;i<resumeList.size();i++){
                str = str + resumeList.get(i).getName()+","
                        +resumeList.get(i).getId()+","+resumeList.get(i).getSchool()+";";
            }

        }else {
            str=isSuccess+"/n"+ar.failReason;
        }
        return str;
    }

    public String SearchByNameMessage(ActionResult ar) {
        String str;
        String isSuccess=ar.isSuccess;
        if(isSuccess.equals("Success")){
            str=isSuccess+"/n";
            ResumeList resumeList = (ResumeList) ar.resultData;
            for (int i=0;i<resumeList.size();i++){
                str = str + resumeList.get(i).getName()+","
                        +resumeList.get(i).getId()+","+resumeList.get(i).getSchool()+";";
            }

        }else {
            str=isSuccess+"/n"+ar.failReason;
        }
        return str;
    }

    public String SearchBySchoolMessage(ActionResult ar) {
        String str;
        String isSuccess=ar.isSuccess;
        if(isSuccess.equals("Success")){
            str=isSuccess+"/n";
            ResumeList resumeList = (ResumeList) ar.resultData;
            for (int i=0;i<resumeList.size();i++){
                str = str + resumeList.get(i).getName()+","
                        +resumeList.get(i).getId()+","+resumeList.get(i).getSchool()+";";
            }

        }else {
            str=isSuccess+"/n"+ar.failReason;
        }
        return str;
    }


    public String SearchAllMessage(ActionResult ar) {
        String str;
        String isSuccess=ar.isSuccess;
        if(isSuccess.equals("Success")){
            str=isSuccess+"/n";
            ResumeList resumeList = (ResumeList) ar.resultData;
            for (int i=0;i<resumeList.size();i++){
                str = str + resumeList.get(i).getName()+","
                        +resumeList.get(i).getId()+","+resumeList.get(i).getSchool()+";";
            }

        }else {
            str=isSuccess+"/n"+ar.failReason;
        }
        return str;
    }
}

