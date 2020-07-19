package service;

import client.Client;
import resume.Resume;
import tcp.Parser;
import tcp.Protocol;
import tcp.ReturnResult;

public class Action {
    Client client =new Client();
    //添加
    public ReturnResult addResume(Resume resume){
        Protocol protocol =new Protocol();
        String message = protocol.addResumeMessage(resume);
        String returnMessage =client.sendMessageToServer(message);
        Parser parser =new Parser();
        ReturnResult returnResult =parser.parserAdd(returnMessage);
        return returnResult;
    }
    //通过名字删除
    public ReturnResult deleteResumeByName(Resume resume){
        Protocol protocol =new Protocol();
        String message = protocol.deleteByNameMessage(resume);
        String returnMessage =client.sendMessageToServer(message);
        Parser parser =new Parser();
        ReturnResult returnResult =parser.parserDeleteByName(returnMessage);
        return returnResult;
    }
    //通过身份证号码删除
    public ReturnResult deleteResumeById(Resume resume){
        Protocol protocol =new Protocol();
        String message = protocol.deleteByIdMessage(resume);
        String returnMessage =client.sendMessageToServer(message);
        Parser parser =new Parser();
        ReturnResult returnResult =parser.parserDeleteById(returnMessage);
        return returnResult;
    }
    //通过学校删除
    public ReturnResult deleteResumeBySchool(Resume resume){
        Protocol protocol =new Protocol();
        String message = protocol.deleteBySchoolMessage(resume);
        String returnMessage =client.sendMessageToServer(message);
        Parser parser =new Parser();
        ReturnResult returnResult =parser.parserDeleteBySchool(returnMessage);
        return returnResult;
    }
    //更新
    public ReturnResult updateResume(Resume resume,Resume oldResume){
        Protocol protocol =new Protocol();
        String message = protocol.updateMessage(resume,oldResume);
        String returnMessage =client.sendMessageToServer(message);
        Parser parser =new Parser();
        ReturnResult returnResult =parser.parserUpdate(returnMessage);
        return returnResult;
    }
    //通过名字查询
    public ReturnResult searchResumeByName(Resume resume){
        Protocol protocol =new Protocol();
        String message = protocol.searchByNameMessage(resume);
        String returnMessage =client.sendMessageToServer(message);
        Parser parser =new Parser();
        ReturnResult returnResult =parser.parserSearchByName(returnMessage);
        return returnResult;
    }
    //通过身份证号码查询
    public ReturnResult searchResumeById(Resume resume){
        Protocol protocol =new Protocol();
        String message = protocol.searchByIdMessage(resume);
        String returnMessage =client.sendMessageToServer(message);
        Parser parser =new Parser();
        ReturnResult returnResult =parser.parserSearchById(returnMessage);
        return returnResult;
    }
    //通过学校查询
    public ReturnResult searchResumeBySchool(Resume resume){
        Protocol protocol =new Protocol();
        String message = protocol.searchBySchoolMessage(resume);
        String returnMessage =client.sendMessageToServer(message);
        Parser parser =new Parser();
        ReturnResult returnResult =parser.parserSearchBySchool(returnMessage);
        return returnResult;
    }
    public void closeNet(String message){
        String returnMessage =client.sendMessageToServer(message);
        client.closeClient();
    }
}
