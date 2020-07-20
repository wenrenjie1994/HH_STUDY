package utils;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.ActionResult;
import model.ResumeLinkedList;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:Protocal
 * @description:服务器端协议（字符串）生成器（用来生成发送到客户端的服务器端协议）
 * @author: 何文艺
 * @create: 2020/7/17 16:19
 **/
public class Protocol {
    /*
    协议生成规则：
    1.如果数据库操作成功，协议 = ActionResult.isSuccess + "/n"
    2.如果数据库操作失败，协议 = ActionResult.isSuccess + "/n" + ActionResult.failReason
    3.如果数据库查询操作成功，协议 = ActionResult.isSuccess + "/n" + ActionResult.resultData
    */

    public Protocol() {

    }

    public String addResumeMessage(ActionResult actionResult) {
        return resumeMessage_CUD(actionResult);
    }

    public String deleteResumeMessage(ActionResult actionResult) {
        return resumeMessage_CUD(actionResult);
    }

    public String updateResumeMessage(ActionResult actionResult) {
        return resumeMessage_CUD(actionResult);
    }

    public String resumeMessage_CUD(ActionResult actionResult) {
        Boolean isSuccess = actionResult.isSuccess;
        if(isSuccess) {
            return isSuccess + "/n";
        } else {
            return isSuccess + "/n" + actionResult.failReason;
        }
    }

    public String searchByNameMessage(ActionResult actionResult) {
        return resumeMessage_R(actionResult);
    }

    public String searchByIdMessage(ActionResult actionResult) {
        return resumeMessage_R(actionResult);
    }

    public String searchBySchoolMessage(ActionResult actionResult) {
        return resumeMessage_R(actionResult);
    }

    public String searchByProcessMessage(ActionResult actionResult) {
        return resumeMessage_R(actionResult);
    }

    public String searchAllMessage(ActionResult actionResult) {
        return resumeMessage_R(actionResult);
    }

    public String resumeMessage_R(ActionResult actionResult) {
        String str;
        Boolean isSuccess = actionResult.isSuccess;
        if(isSuccess) {
            str = isSuccess + "/n";
            ResumeLinkedList resumeLinkedList = (ResumeLinkedList)actionResult.resultData;
            for (int i = 0; i < resumeLinkedList.size(); i++) {
                str += resumeLinkedList.get(i).name + "," + resumeLinkedList.get(i).id + "," +
                        resumeLinkedList.get(i).school + "," + resumeLinkedList.get(i).process +"," +
                        resumeLinkedList.get(i).deleteStatus + ";";
            }
        } else {
            str =  isSuccess + "/n" + actionResult.failReason;
        }
        return str;
    }
}
