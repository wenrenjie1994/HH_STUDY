package util;

/**
 * @Author lee
 * @Date 2020/7/15 7:44 PM
 **/

import model.ActionResult;
import model.ResumeList;

public class Protocol {

    public Protocol() {
    }

    /*
     * 把ActionResult的三个属性按ActionResult.isSuccess+"/n"+failReason或者ActionResult.isSuccess+"/n"+（ActionResult.resultData
     * 得到的字符串）格式编写
     * 在for循环里得到ActionResult.resultData的字符串
     * */
    public String addResumeMessage(ActionResult ars) {
        String str;
        String isSuccess = ars.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ars.failReason;
        }
        return str;
    }

    public String deleteResumeMessage(ActionResult ars) {
        String str;
        String isSuccess = ars.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ars.failReason;
        }
        return str;
    }

    public String searchResumeMessage(ActionResult ars) {
        String str;
        String isSuccess = ars.isSuccess;
        if (isSuccess.equals("Success")) {
            ResumeList resumeList = (ResumeList) ars.resultData;
            str = isSuccess + "/n";
            //for循环得到ActionResult.resultData字符对应的字符串
            int resumeSize = resumeList.size();
            for (int i = 0; i < resumeSize; i++) {
                String resumeString = resumeList.get(i).getName() + "," + resumeList.get(i).getId() + "," + resumeList.get(i).getSchool() + ";";
                str = str + resumeString;
            }
        } else {
            str = isSuccess + "/n" + ars.failReason;
        }
        return str;
    }
}
