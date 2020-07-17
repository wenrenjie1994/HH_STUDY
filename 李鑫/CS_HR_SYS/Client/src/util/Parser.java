package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

public class Parser {

    /**先以“:”劈开得到是否成功和成功结果或者失败原因
     * 如果失败 returnResult.isSuccess=Failed returnResult.failReason为劈开的第二部分
     * 成功了returnResult.isSuccess=Success
     * 再以“;”劈开各简历
     * 再以“，”劈开每个简历的三个属性分别赋给Resume存到ResumeList
     * 再把ResumeList放到returnResult.resultData里
     * 返回returnResult
     * */

    // process: add, delete, update
    public ReturnResult parseProcess(String message) {

        ReturnResult returnResult = new ReturnResult();
        String[] arrayMessage = message.split(":");

        if (arrayMessage[0].equals("Success")) {
            returnResult.isSuccess = true;
        }

        else {
            returnResult.failReason = arrayMessage[1];
        }

        return returnResult;
    }

    public ReturnResult parseSearch(String message) {

        ReturnResult returnResult = new ReturnResult();
        String[] arrayMessage = message.split(":");

        if (arrayMessage[0].equals("Success")) {
            ResumeList resumeList = new ResumeList();

            returnResult.isSuccess = true;
            String[] resumeInfo = arrayMessage[1].split(";");
            int resumeSize = resumeInfo.length;

            for (int i=0; i<resumeSize; i++) {
                String[] info = resumeInfo[i].split(",");
                Resume r = new Resume(info[0], info[1], info[2]);
                resumeList.add(r);
            }
            returnResult.resultData = resumeList;
        }

        else {
            returnResult.isSuccess = false;
            returnResult.failReason = arrayMessage[1];
        }

        return returnResult;
    }


}
