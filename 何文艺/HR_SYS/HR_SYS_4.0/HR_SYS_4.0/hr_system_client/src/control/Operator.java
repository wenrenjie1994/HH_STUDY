package control;

import model.Resume;
import model.ReturnResult;
import net.Client;
import utils.Parser;
import utils.Protocol;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:Operator
 * @description:控制客户端和服务器端的交互
 * @author: 何文艺
 * @create: 2020/7/19 14:15
 **/
public class Operator {
/*
    1.把传过来的Resume放到Protocol.java中生成String类型的客户端协议
    2.把得到的协议通过Client.java里面的sendMessageToServer(String message)方法把协议发送到服务器端
    3.把服务器返回的服务器端协议放到Parser.java里面解析，生成ReturnResult类型的结果
    4.把结果在界面中输出
*/

    Client client = Client.getClient();

    public Operator() {

    }

    public ReturnResult addResume(Resume resume) {
        //创建一个客户端协议生成器
        Protocol protocol = new Protocol();
        //把传过来的Resume放到客户端协议生成器中生成String类型的客户端协议
        String message = protocol.addResumeMessage(resume);
        //把生成的协议发送到服务器端，并获得服务器端返回的服务器端协议
        String returnMessage = client.sendMessageToServer(message);
        //创建一个服务器端协议解析器
        Parser parser = new Parser();
        //解析服务器端发来的协议，并返回returnResult类型得结果
        ReturnResult returnResult = parser.parserAdd(returnMessage);
        return returnResult;
    }

    public ReturnResult deleteResume(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.deleteResumeMessage(resume);
        String returnMessage = client.sendMessageToServer(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserDelete(returnMessage);
        return returnResult;
    }

    public ReturnResult updateResume(Resume newResume, Resume oldResume) {
        Protocol protocol = new Protocol();
        String message = protocol.updateResumeMessage(newResume, oldResume);
        String returnMessage = client.sendMessageToServer(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserUpdate(returnMessage);
        return returnResult;
    }

    public ReturnResult searchResumeByName(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.searchByNameMessage(resume);
        String returnMessage = client.sendMessageToServer(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        return returnResult;
    }

    public ReturnResult searchResumeById(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.searchByIdMessage(resume);
        String returnMessage = client.sendMessageToServer(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        return returnResult;
    }

    public ReturnResult searchResumeBySchool(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.searchBySchoolMessage(resume);
        String returnMessage = client.sendMessageToServer(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        return returnResult;
    }

    public ReturnResult searchResumeByProcess(Resume resume) {
        Protocol protocol = new Protocol();
        String message = protocol.searchByProcessMessage(resume);
        String returnMessage = client.sendMessageToServer(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        return returnResult;
    }

    public ReturnResult searchAllResume() {
        Protocol protocol = new Protocol();
        String message = protocol.searchAllMessage();
        String returnMessage = client.sendMessageToServer(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        return returnResult;
    }

    public void CloseNet(String str) {
        String returnMessage = client.sendMessageToServer(str);
        client.closeClient();
    }
}
