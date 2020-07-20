package utils;

import model.Resume;
import model.ResumeLinkedList;
import model.ReturnResult;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:Parser
 * @description:服务器端协议（字符串）解析器（解析服务器端发送过来的服务器端协议）
 * @author: 何文艺
 * @create: 2020/7/19 9:56
 **/
public class Parser {
    ReturnResult returnResult = new ReturnResult();
    String[] aMessage;

/*
    1.服务器端协议按"/n"分隔后得到的长度为2的字符串数组aMessage;
      aMessage[0]=操作成功或失败，aMessage[1]=成功结果或失败原因
    2.如果操作成功，returnResult.isSuccess = true
      根据aMessage[1]生成ResumeLinkedList并放入returnResult.resultData
      以";"分割各本书，以","分隔书的各字段
    3.如果操作失败，returnResult.isSuccess = false,returnResult.failReason = aMessage[1]
*/

    public ReturnResult parserAdd(String message) {
        return parser_CUD(message);
    }

    public ReturnResult parserDelete(String message) {
        return parser_CUD(message);
    }

    public ReturnResult parserUpdate(String message) {
        return parser_CUD(message);
    }

    public ReturnResult parser_CUD(String message) {
        aMessage = message.split("/n");
        if (Boolean.parseBoolean(aMessage[0])) {
            returnResult.isSuccess = true;
        } else {
            returnResult.failReason = aMessage[1];
        }
        return returnResult;
    }

    public ReturnResult parserSearch(String message) {
        aMessage = message.split("/n");
        if (Boolean.parseBoolean(aMessage[0])) {
            String[] resumeArray = aMessage[1].split(";");
            ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
            for (int i = 0; i < resumeArray.length; i++) {
                String[] resumeInfo = resumeArray[i].split(",");
                resumeLinkedList.add(new Resume(resumeInfo[0],resumeInfo[1],resumeInfo[2],
                        Integer.parseInt(resumeInfo[3]),Integer.parseInt(resumeInfo[4])));
            }
            returnResult.isSuccess = true;
            returnResult.resultData = resumeLinkedList;
        } else {
            returnResult.isSuccess = false;
            returnResult.failReason = aMessage[1];
        }
        return returnResult;
    }
}
