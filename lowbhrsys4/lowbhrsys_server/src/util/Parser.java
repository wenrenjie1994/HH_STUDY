package util;

import model.Interviewee;
import model.IntervieweeList;
import model.ReturnMessage;

public class Parser {
    public Parser()
    {

    }

    static String[] messageArray;
    static String head;
    static String message;
    static ReturnMessage returnMessage;

    public ReturnMessage parser(String str) {
        // 获取操作和数据
        messageArray = str.split("/n");
        head = messageArray[0];
        message = messageArray[1];
        returnMessage = new ReturnMessage();
        returnMessage.head = head;
        if(head.equals("add")){
            IntervieweeList iList = parserAdd(message);
            returnMessage.data = iList;
        }
        else if(head.equals("deleteByName")){
            IntervieweeList iList = parserDeleteByName(message);
            returnMessage.data = iList;
        }
        else if(head.equals("deleteByID")){
            IntervieweeList iList = parserDeleteByID(message);
            returnMessage.data = iList;
        }
        else if(head.equals("modify")){
            IntervieweeList iList = parserModify(message);
            returnMessage.data = iList;
        }
        else if(head.equals("searchByName")){
            IntervieweeList iList = parserSearchByName(message);
            returnMessage.data = iList;
        }
        else if(head.equals("searchBySchool")){
            IntervieweeList iList = parserSearchBySchool(message);
            returnMessage.data = iList;
        }
        else if(head.equals("searchByPosition")){
            IntervieweeList iList = parserSearchByPosition(message);
            returnMessage.data = iList;
        }
        return returnMessage;
    }
    // 添加解析
    public IntervieweeList parserAdd(String message){
        String[] str = message.split(",");
        String name = str[0];
        int age = Integer.parseInt(str[1]);
        String school = str[2];
        String ID = str[3];
        String position = str[4];
        Interviewee interviewee = new Interviewee(name,age,school,ID,position);
        IntervieweeList iList = new IntervieweeList();
        iList.add(interviewee);
        return iList;
    }
    // 删除解析
    public IntervieweeList parserDeleteByName(String message){
        String name = message;
        Interviewee interviewee = new Interviewee(name,0,null,null,null);
        IntervieweeList iList = new IntervieweeList();
        iList.add(interviewee);
        return iList;
    }

    public IntervieweeList parserDeleteByID(String message){
        String ID = message;
        Interviewee interviewee = new Interviewee(null,0,null,ID,null);
        IntervieweeList iList = new IntervieweeList();
        iList.add(interviewee);
        return iList;
    }
    // 修改解析
    public IntervieweeList parserModify(String message){
        String[] modifyString = message.split(",");
        String name = modifyString[0];
        int age = Integer.parseInt(modifyString[1]);
        String school = modifyString[2];
        String ID = modifyString[3];
        String position = modifyString[4];
        Interviewee interviewee = new Interviewee(name,age,school,ID,position);
        IntervieweeList iList = new IntervieweeList();
        iList.add(interviewee);
        return iList;
    }
    // 查询解析
    public IntervieweeList parserSearchByName(String message){
        String name = message;
        Interviewee interviewee = new Interviewee(name,0,null,null,null);
        IntervieweeList iList = new IntervieweeList();
        iList.add(interviewee);
        return iList;
    }
    public IntervieweeList parserSearchBySchool(String message){
        String school = message;
        Interviewee interviewee = new Interviewee(null,0,school,null,null);
        IntervieweeList iList = new IntervieweeList();
        iList.add(interviewee);
        return iList;
    }
    public IntervieweeList parserSearchByPosition(String message){
        String position = message;
        Interviewee interviewee = new Interviewee(null,0,null,null,position);
        IntervieweeList iList = new IntervieweeList();
        iList.add(interviewee);
        return iList;
    }
}
