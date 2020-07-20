package util;
import medol.ResumeList;
import medol.ReturnResult;
import medol.Resume;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: HH_STUDY
 * @description:
 * @author: qiu haoran
 * @create: 2020-07-20 17:23
 */

public class ServerParser {
    static String[] amessage;
    static String head;
    static ReturnResult ss;
    static String message;

    public ServerParser() {
    }

    public ReturnResult parser(String str) {
        amessage = str.split("/n");
        head = amessage[0];
        message = amessage[1];
        ss = new ReturnResult();
        ss.head = head;
        ResumeList resumeList;
        if (head.equals("add")) {
            resumeList = this.parserAdd(message);
            ss.resultData = resumeList;
        }
//        else if (head.equals("deletebyid")) {
//            resumeList = this.parserDeleteByName(message);
//            ss.resultData = resumeList;
//        } else if (head.equals("deletebyauthor")) {
//            resumeList = this.parserDeleteByAuthor(message);
//            ss.resultData = resumeList;
//        } else if (head.equals("change")) {
//            resumeList = this.parserChangeResume(message);
//            ss.resultData = resumeList;
//        } else if (head.equals("searchbyname")) {
//            resumeList = this.parserSearchByName(message);
//            ss.resultData = resumeList;
//        } else if (head.equals("searchbyauthor")) {
//            resumeList = this.parserSearchByAuthor(message);
//            ss.resultData = resumeList;
//        } else if (head.equals("searchbyprice")) {
//            resumeList = this.parserSearchByPrice(message);
//            ss.resultData = resumeList;
//        } else if (head.equals("searchbykeyword")) {
//            resumeList = this.parserSearchByKeyWord(message);
//            ss.resultData = resumeList;
//        }

        return ss;
    }

    public ResumeList parserAdd(String message) {
        String[] str = message.split(",");
        String ReName=str[0];
        String ReId=str[1];
        Integer ReSchool=Integer.parseInt(str[2]);
        Integer ReProcess=Integer.valueOf(str[3]).intValue();
        Integer ReDeleteStatus=Integer.parseInt(str[4]);
        Resume resume = new Resume(ReName, ReId, ReSchool,ReProcess,ReDeleteStatus);
        ResumeList resumeList = new ResumeList();
        resumeList.add(resume);
        return resumeList;
    }

//    public ResumeList parserDeleteByName(String message) {
//        String resumeAuthor = null;
//        double resumePrice = 0.0D;
//        Resume resume = new Resume(message, (String)resumeAuthor, resumePrice);
//        ResumeList resumeList = new ResumeList();
//        resumeList.add(resume);
//        return resumeList;
//    }
//
//    public ResumeList parserDeleteByAuthor(String message) {
//        String resumeName = null;
//        double resumePrice = 0.0D;
//        Resume resume = new Resume((String)resumeName, message, resumePrice);
//        ResumeList resumeList = new ResumeList();
//        resumeList.add(resume);
//        return resumeList;
//    }
//
//    public ResumeList parserChangeResume(String message) {
//        String[] str = message.split(";");
//        String[] oldresumemessage = str[0].split(",");
//        String oldresumeName = oldresumemessage[0];
//        String oldresumeAuthor = oldresumemessage[1];
//        double oldresumePrice = Double.parseDouble(oldresumemessage[2]);
//        String[] resumemessage = str[1].split(",");
//        String resumeName = resumemessage[0];
//        String resumeAuthor = resumemessage[1];
//        double resumePrice = Double.parseDouble(resumemessage[2]);
//        Resume oldresume = new Resume(oldresumeName, oldresumeAuthor, oldresumePrice);
//        ResumeList resumeList = new ResumeList();
//        resumeList.add(oldresume);
//        Resume resume = new Resume(resumeName, resumeAuthor, resumePrice);
//        resumeList.add(resume);
//        return resumeList;
//    }
//
//    public ResumeList parserSearchByName(String message) {
//        Resume resume = new Resume(message, (String)null, 0.0D);
//        ResumeList resumeList = new ResumeList();
//        resumeList.add(resume);
//        return resumeList;
//    }
//
//    public ResumeList parserSearchByAuthor(String message) {
//        Resume resume = new Resume((String)null, message, 0.0D);
//        ResumeList resumeList = new ResumeList();
//        resumeList.add(resume);
//        return resumeList;
//    }
//
//    public ResumeList parserSearchByPrice(String message) {
//        double resumePrice = Double.parseDouble(message);
//        Resume resume = new Resume((String)null, (String)null, resumePrice);
//        ResumeList resumeList = new ResumeList();
//        resumeList.add(resume);
//        return resumeList;
//    }
//
//    public ResumeList parserSearchByKeyWord(String message) {
//        Resume resume = new Resume(message, (String)null, 0.0D);
//        ResumeList resumeList = new ResumeList();
//        resumeList.add(resume);
//        return resumeList;
//    }
}
