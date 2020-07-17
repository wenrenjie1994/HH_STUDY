package util;

/**
 * @Author lee
 * @Date 2020/7/15 7:43 PM
 **/

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

public class Parser {
    public Parser() {
    }

    static String[] allMessage; // 接收到的所有消息字符串
    static String head; // head，操作类型
    static ReturnResult rrs;
    static String message; // 具体数据

    public ReturnResult parser(String str) {
        /*
         * 先按“/n”split得到操作类型和操作数据
         * 把操作数据用相应的parser方法解析存到ResumeList中
         * 令ReturnResult的head等于split得到的head
         * 令ReturnResult的resultData等于ResumeList
         * */
        allMessage = str.split("/n");
        head = allMessage[0];
        message = allMessage[1];
        rrs = new ReturnResult();
        rrs.head = head;

        if (head.equals("addResume")) {
            ResumeList resumeList = parserAddResume(message);
            rrs.resultData = resumeList;
        } else if (head.equals("deleteResumeByName")) {
            ResumeList resumeList = parserDeleteResumeByName(message);
            rrs.resultData = resumeList;
        } else if (head.equals("deleteResumeById")) {
            ResumeList resumeList = parserDeleteResumeById(message);
            rrs.resultData = resumeList;
        } else if (head.equals("deleteResumeBySchool")) {
            ResumeList resumeList = parserDeleteResumeBySchool(message);
            rrs.resultData = resumeList;
        } else if (head.equals("searchResumeByName")) {
            ResumeList resumeList = parserSearchResumeByName(message);
            rrs.resultData = resumeList;
        } else if (head.equals("searchResumeById")) {
            ResumeList resumeList = parserSearchResumeById(message);
            rrs.resultData = resumeList;
        } else if (head.equals("searchResumeBySchool")) {
            ResumeList resumeList = parserSearchResumeBySchool(message);
            rrs.resultData = resumeList;
        }
        return rrs;

    }

    /*
     * “;”劈开得到Book的三个属性
     * 	","劈开book的三个属性存在Book中
     * 最后都存在BookList中返回
     * * */
    public ResumeList parserAddResume(String message) {
        String[] str = message.split(",");

        String name = str[0];
        String id = str[1];
        String school = str[2];

        Resume resume = new Resume(name, id, school);
        ResumeList resumeList = new ResumeList();
        resumeList.add(resume);
        return resumeList;

    }

    public ResumeList parserDeleteResumeByName(String message) {

        String name = message;
        String id = null;
        String school = null;

        Resume resume = new Resume(name, id, school);
        ResumeList resumeList = new ResumeList();
        resumeList.add(resume);
        return resumeList;

    }

    public ResumeList parserDeleteResumeById(String message) {
        String name = null;
        String id = message;
        String school = null;

        Resume resume = new Resume(name, id, school);
        ResumeList resumeList = new ResumeList();
        resumeList.add(resume);
        return resumeList;

    }

    public ResumeList parserDeleteResumeBySchool(String message) {
        String name = null;
        String id = null;
        String school = message;
        Resume resume = new Resume(name, id, school);
        ResumeList resumeList = new ResumeList();
        resumeList.add(resume);
        return resumeList;

    }

    public ResumeList parserSearchResumeByName(String message) {
        String name = message;
        Resume resume = new Resume(name, null, null);
        ResumeList resumeList = new ResumeList();
        resumeList.add(resume);
        return resumeList;
    }

    public ResumeList parserSearchResumeById(String message) {
        String id = message;
        Resume resume = new Resume(null, id, null);
        ResumeList resumeList = new ResumeList();
        resumeList.add(resume);
        return resumeList;
    }

    public ResumeList parserSearchResumeBySchool(String message) {
        String school = message;
        Resume resume = new Resume(null, null, school);
        ResumeList resumeList = new ResumeList();
        resumeList.add(resume);
        return resumeList;
    }
}
