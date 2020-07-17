package util;

import model.ActionResult;
import model.Resume;
import model.ResumeList;

public class Protocol {

    /*
     * 把ActionResult的三个属性按ActionResult.isSuccess+":"+failReason或者ActionResult.isSuccess+":"+（ActionResult.resultData
     * 得到的字符串）格式编写
     * 在for循环里得到ActionResult.resultData的字符串
     * */

     // process: add, update, delete
    public String processResumeMessage(ActionResult actionResult) {
        String str;

        if (actionResult.isSuccess.equals("Success")) {
            str = actionResult.isSuccess + ":";
        }
        else {
            str = actionResult.isSuccess + ":" + actionResult.failReason;
        }

        return str;
    }

    public String searchResumeMessage(ActionResult actionResult) {
        StringBuilder str = new StringBuilder();

        if (actionResult.isSuccess.equals("Success")) {
            str = new StringBuilder(actionResult.isSuccess + ":");

            ResumeList resumeList = (ResumeList) actionResult.resultData;
            int listSize = resumeList.size();

            for (int i=0; i<listSize; i++) {
                Resume r = resumeList.get(i);
                String resumeString = String.format("%s,%s,%s;", r.getName(), r.getId(), r.getSchool());
                str.append(resumeString);
            }

        }
        else {
            str.append(actionResult.isSuccess).append(":").append(actionResult.failReason);
        }

        return str.toString();
    }
}
