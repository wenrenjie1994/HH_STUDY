package service;

import entity.Resume;
import entity.ReturnResult;
import net.Client;
import work.Parser;
import work.Protocol;

public class Operator {
    static Client client =Client.getClient();

    static public ReturnResult addResume(Resume resume){
        Protocol protocol = new Protocol();
        String msg = protocol.add(resume);
        String returnMsg = client.sendMsgToServer(msg);
        Parser parser = new Parser();
        return parser.addOrDeleteOrUpdateResume(returnMsg);
    }

    static public ReturnResult deleteResumeById(int id){
        Protocol protocol = new Protocol();
        String msg = protocol.deleteById(id);
        String returnMsg = client.sendMsgToServer(msg);
        Parser parser = new Parser();
        return parser.addOrDeleteOrUpdateResume(returnMsg);
    }
    static public ReturnResult deleteResumeByName(String name){
        Protocol protocol = new Protocol();
        String msg = protocol.deleteByName(name);
        String returnMsg = client.sendMsgToServer(msg);
        Parser parser = new Parser();
        return parser.addOrDeleteOrUpdateResume(returnMsg);
    }

    static public ReturnResult updateResumeById(int id,Resume resume){
        Protocol protocol =new Protocol();
        String msg = protocol.updateById(id,resume);
        String returnMsg = client.sendMsgToServer(msg);
        Parser parser = new Parser();
        return parser.addOrDeleteOrUpdateResume(returnMsg);
    }
    static public ReturnResult updateResumeByName(String name,Resume resume){
        Protocol protocol =new Protocol();
        String msg = protocol.updateByName(name,resume);
        String returnMsg = client.sendMsgToServer(msg);
        Parser parser = new Parser();
        return parser.addOrDeleteOrUpdateResume(returnMsg);
    }

    static public ReturnResult findResumeById(int id){
        Protocol protocol = new Protocol();
        String msg = protocol.findById(id);
        String returnMsg = client.sendMsgToServer(msg);
        Parser parser = new Parser();
        return parser.searchResume(returnMsg);
    }
    static public ReturnResult findResumeByName(String name){
        Protocol protocol = new Protocol();
        String msg = protocol.findByName(name);
        String returnMsg = client.sendMsgToServer(msg);
        Parser parser = new Parser();
        return parser.searchResume(returnMsg);
    }
    static public ReturnResult findResumeByPosition(String position){
        Protocol protocol = new Protocol();
        String msg = protocol.findByPosition(position);
        String returnMsg = client.sendMsgToServer(msg);
        Parser parser = new Parser();
        return parser.searchResume(returnMsg);
    }
    static public ReturnResult searchAll(){
        Protocol protocol = new Protocol();
        String msg = protocol.searchAll();
        String returnMsg = client.sendMsgToServer(msg);
        Parser parser = new Parser();
        return parser.searchResume(returnMsg);
    }

    static public void closeNet() {
        String returnMessage=client.sendMsgToServer("bye");
        client.closeClient();
    }

}
