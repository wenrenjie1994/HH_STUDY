package utils;

import model.Resume;
import model.ResumeLinkedList;
import model.ReturnResult;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:Parser
 * @description:客户端协议（字符串）解析器（解析客户端发送过来的客户端协议）
 * @author: 何文艺
 * @create: 2020/7/17 16:38
 **/
public class Parser {
    static String[] aMessage;//客户端协议按"/n"分隔后得到的长度为2的字符串数组;aMessage[0]即操作，Message[1]即操作数据
    static String head;//head = aMessage[0]
    static String message;//message = aMessage[1]
    static ReturnResult rrs;

    public Parser() {

    }

    /*
        1.将客户端发过来的协议按"/n"分隔成 操作aMessage[0] 和 操作数据aMessage[1] 两个部分
        2.判断操作并把操作数据用相应的parser方法解析存到ResumeLinkedList里面
        3.令rrs.head = aMessage[0]，rrs.resultData = ResumeLinkedList = 相应的parser方法（aMessage[1]）
    */
    public ReturnResult parser(String str) {
        aMessage = str.split("/n");
        head = aMessage[0];
        message = aMessage[1];
        rrs = new ReturnResult();
        rrs.head = head;
        switch (head) {
            case "add":
                rrs.resultData = parserAdd(message);
                break;
            case "delete":
                rrs.resultData = parserDelete(message);
                break;
            case "update":
                rrs.resultData = parserUpdate(message);
                break;
            case "searchByName":
                rrs.resultData = parserSearchByName(message);
                break;
            case "searchById":
                rrs.resultData = parserSearchById(message);
                break;
            case "searchBySchool":
                rrs.resultData = parserSearchBySchool(message);
                break;
            case "searchByProcess":
                rrs.resultData = parserSearchByProcess(message);
                break;
            case "searchAll":
                rrs.resultData = parserSearchAll(message);
                break;
        }
        return rrs;
    }

    public ResumeLinkedList parserAdd(String message) {
        String[] str = message.split(",");
        String name = str[0];
        String id = str[1];
        String school = str[2];
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        resumeLinkedList.add(new Resume(name, id, school));
        return resumeLinkedList;
    }

    public ResumeLinkedList parserDelete(String message) {
        String id = message;
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        resumeLinkedList.add(new Resume(null, id, null));
        return resumeLinkedList;
    }

    public ResumeLinkedList parserUpdate(String message) {
        String[] str = message.split(";");
        String[] strArray = str[0].split(",");
        String newName = strArray[0];
        String newId = strArray[1];
        String newSchool = strArray[2];
        strArray = str[1].split(",");
        String oldName = strArray[0];
        String oldId = strArray[1];
        String oldSchool = strArray[2];
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        resumeLinkedList.add(new Resume(newName, newId, newSchool));
        resumeLinkedList.add(new Resume(oldName, oldId, oldSchool));
        return resumeLinkedList;
    }

    public ResumeLinkedList parserSearchByName(String message) {
        String name = message;
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        resumeLinkedList.add(new Resume(name, null, null));
        return resumeLinkedList;
    }

    public ResumeLinkedList parserSearchById(String message) {
        String id = message;
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        resumeLinkedList.add(new Resume(null, id, null));
        return resumeLinkedList;
    }

    public ResumeLinkedList parserSearchBySchool(String message) {
        String school = message;
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        resumeLinkedList.add(new Resume(null, null, school));
        return resumeLinkedList;
    }

    public ResumeLinkedList parserSearchByProcess(String message) {
        int process = Integer.parseInt(message);
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        resumeLinkedList.add(new Resume(null, null, null, process, 0));
        return resumeLinkedList;
    }

    public ResumeLinkedList parserSearchAll(String message) {
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        resumeLinkedList.add(new Resume(null, null, null));
        return resumeLinkedList;
    }
}
