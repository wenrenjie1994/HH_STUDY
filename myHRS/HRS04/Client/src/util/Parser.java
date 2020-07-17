package util;

/**
 * @Author lee
 * @Date 2020/7/16 3:06 PM
 **/

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

public class Parser {
    /**
     * 先以“/n”劈开得到是否成功和成功结果或者失败原因
     * 如果失败 returnResult.isSuccess=false returnResult.failReason为劈开的第二部分
     * 成功了returnResult.isSuccess=true
     * 再以“;”劈开各本书
     * 再以“，”劈开每本书的三个属性分别赋给Book存到BookList
     * 再把BookList放到returnResult.resultData里
     * 返回returnResult
     */
    public ReturnResult parserAdd(String message) {
        ReturnResult rrs = new ReturnResult();
        String[] allMessage = message.split("/n");
        if (allMessage[0].equals("Success")) {
            rrs.isSuccess = true;
        } else {
            rrs.failReason = allMessage[1];
        }
        return rrs;
    }

    public ReturnResult parserDelete(String message) {
        ReturnResult rrs = new ReturnResult();
        String[] allMessage = message.split("/n");
        if (allMessage[0].equals("Success")) {
            rrs.isSuccess = true;
        } else {
            rrs.failReason = allMessage[1];
        }
        return rrs;
    }

    public ReturnResult parserSearch(String message) {
        ReturnResult rrs = new ReturnResult();
        String[] allMessage = message.split("/n");
        if (allMessage[0].equals("Success")) {
            rrs.isSuccess = true;
            String[] resumeInfo = allMessage[1].split(";");
            ResumeList resumeList = new ResumeList();
            int resumeSize = resumeInfo.length;
            for (int i = 0; i < resumeSize; i++) {
                String[] resumeString = resumeInfo[i].split(",");
                String name = resumeString[0];
                String id = resumeString[1];
                String school = resumeString[2];
                Resume resume = new Resume(name, id, school);
                resumeList.add(resume);
            }
            rrs.resultData = resumeList;
        } else {
            rrs.isSuccess = false;
            ResumeList resumeList = new ResumeList(); // 返回空
            rrs.failReason = allMessage[1];
            rrs.resultData = resumeList;
        }
        return rrs;
    }

}
