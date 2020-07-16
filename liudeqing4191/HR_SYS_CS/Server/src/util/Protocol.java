package util;

import model.ActionResult;
import model.ResumeList;


/**
 * @author : liudeqing4191
 * @program : util\Protocol.java
 * @description : 根据服务器操作结果 形成返回客户端的报文
 * @date : 2020/7/16 13:30
 */

public class Protocol {
    public Protocol() {

    }

    /*
     * 把ActionResult的三个属性按ActionResult.isSuccess+"/n"+failReason或者ActionResult.isSuccess+"/n"+（ActionResult.resultData
     * 得到的字符串）格式编写
     * 在for循环里得到ActionResult.resultData的字符串
     * */
    public String addResumeMessage(ActionResult ar) {
        String str;
        String isSuccess = ar.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }
        return str;
    }

    public String deleteResumeMessage(ActionResult ar) {
        String str;
        String isSuccess = ar.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }
        return str;
    }

    public String updataResumeMessage(ActionResult ar) {
        String str;
        String isSuccess = ar.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }
        return str;
    }

    public String searchResumeMessage(ActionResult ar) {
        String str;
        String isSuccess = ar.isSuccess;
        if (isSuccess.equals("Success")) {
            ResumeList resumes = (ResumeList) ar.resultData;
            str = isSuccess + "/n";
            //for循环得到ActionResult.resultData字符对应的字符串
            int resumesize = resumes.size();
            for (int i = 0; i < resumesize; i++) {
                String bookstring =
                        resumes.get(i).getId() + "," +
                                resumes.get(i).getName() + "," +
                                resumes.get(i).getSchool() + "," +
                                resumes.get(i).getProcess() + "," +
                                resumes.get(i).getDeleteStatus() + ";";
                str = str + bookstring;
            }
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }
        return str;
    }

}
