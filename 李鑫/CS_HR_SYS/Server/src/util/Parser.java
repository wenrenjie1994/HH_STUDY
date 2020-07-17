package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

public class Parser {

    public ReturnResult parse(String str) {

        /*
         * 先按“:”劈开得到想要的操作和操作数据
         * if语句判断操作
         * 把操作数据用相应的parser方法解析得到一个Resume或者ResumeList中
         * 令ReturnResult的head=劈开得到的head
         * 令ReturnResult的resultData等于Resume或者ResumeList
         * */

        // 操作数据
        ReturnResult returnResult = new ReturnResult();

        String[] arrayMessage = str.split(":");
        String head = arrayMessage[0];  // 操作指令
        String resumeInfo = arrayMessage[1];  // 操作数据
        returnResult.head = head;

        if (head.equals("add")) {
            returnResult.resultData = parseAdd(resumeInfo);
        }

        else if (head.equals("delete") || head.equals("search")) {
            returnResult.resultData = parseDeleteAndSearch(resumeInfo);
        }

        else if (head.equals("update")) {
            returnResult.resultData = parseUpdate(resumeInfo);
        }

        return returnResult;
    }

    // message: name, id, school
    public Resume parseAdd(String message) {
        String[] resumeInfo = message.split(",");
        return new Resume(resumeInfo[0], resumeInfo[1], resumeInfo[2]);
    }

    // 通过名字删除、查找简历
    // message: name
    public Resume parseDeleteAndSearch(String message) {
        return new Resume(message, null, null);
    }

    // 通过名字修改简历信息
    // message: old name, new name, new id, new school
    public ResumeList parseUpdate(String message) {
        String[] resumeInfo = message.split(",");
        ResumeList resumeList = new ResumeList();

        Resume oldResume = new Resume(resumeInfo[0], null, null);
        resumeList.add(oldResume);

        Resume newResume = new Resume(resumeInfo[1], resumeInfo[2], resumeInfo[3]);
        resumeList.add(newResume);

        return resumeList;
    }
}
