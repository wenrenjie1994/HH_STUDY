package control;

/**
 * @Author lee
 * @Date 2020/7/16 3:34 PM
 **/

import model.Resume;
import model.ReturnResult;
import net.Client;
import util.Parser;
import util.Protocol;

public class Operator {
    Client client = Client.getClient();

    public Operator() {

    }
    /*
     * 模式
     * 把传过来的book放到Protocol中编写协议
     * 把得到的协议通过Client里的sendMessageToSever方法把协议（字符串）发送到服务器
     * 把服务器返回的协议（也是字符串）parser 解析 解析后返回ReturnResult类型结果
     * 把结果在返回给界面输出
     * */

    public ReturnResult addResume(Resume resume) {
        System.out.println("add");
        Protocol protocol = new Protocol();
        String message = protocol.addResumeMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserAdd(returnMessage);
        return rrs;
    }

    public ReturnResult deleteResumeByName(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.deleteResumeByNameMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserDelete(returnMessage);
        return rrs;
    }

    public ReturnResult deleteResumeById(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.deleteResumeByIdMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserDelete(returnMessage);
        return rrs;
    }

    public ReturnResult deleteResumeBySchool(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.deleteResumeBySchoolMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserDelete(returnMessage);
        return rrs;
    }


    public ReturnResult searchResumeByName(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.searchResumeByNameMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserSearch(returnMessage);
        return rrs;
    }


    public ReturnResult searchResumeById(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.searchResumeByIdMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserSearch(returnMessage);
        return rrs;
    }


    public ReturnResult searchResumeBySchool(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.searchResumeBySchoolMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserSearch(returnMessage);
        return rrs;
    }

//
//    public void closeNet(String str) {
//        String returnMessage = client.sendMessage2Sever(str);
//        client.closeClient();
//    }

}

