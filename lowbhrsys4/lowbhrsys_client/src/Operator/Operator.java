package Operator;

import model.*;
import util.*;
import net.Client;

public class Operator {
    Client client = Client.getClient();
    public Operator(){

    }
    /*
     * 模式
     * 把传过来的book放到Protocol中编写协议
     * 把得到的协议通过Client里的sendMessageToSever方法把协议（字符串）发送到服务器
     * 把服务器返回的协议（也是字符串）parser 解析 解析后返回ReturnResult类型结果
     * 把结果在返回给界面输出
     * */

    public ReturnResult add(Interviewee interviewee){
        Protocol protocol = new Protocol();
        String message = protocol.addMessage(interviewee);
        String returnMessage = client.sendMessageToSever(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserOther(returnMessage);
        return returnResult;
    }

    public ReturnResult deleteByName(Interviewee interviewee){
        Protocol protocol = new Protocol();
        String message = protocol.deleteByNameMessage(interviewee);
        String returnMessage = client.sendMessageToSever(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserOther(returnMessage);
        return returnResult;
    }

    public ReturnResult deleteByID(Interviewee interviewee){
        Protocol protocol = new Protocol();
        String message = protocol.deleteByIDMessage(interviewee);
        String returnMessage = client.sendMessageToSever(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserOther(returnMessage);
        return returnResult;
    }

    public ReturnResult modify(Interviewee interviewee){
        Protocol protocol = new Protocol();
        String message = protocol.modifyMessage(interviewee);
        String returnMessage = client.sendMessageToSever(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserOther(returnMessage);
        return returnResult;
    }

    public ReturnResult searchByName(Interviewee interviewee){
        Protocol protocol = new Protocol();
        String message = protocol.searchByNameMessage(interviewee);
        String returnMessage = client.sendMessageToSever(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        return returnResult;
    }

    public ReturnResult searchBySchool(Interviewee interviewee){
        Protocol protocol = new Protocol();
        String message = protocol.searchBySchoolMessage(interviewee);
        String returnMessage = client.sendMessageToSever(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        return returnResult;
    }

    public ReturnResult searchByPosition(Interviewee interviewee){
        Protocol protocol = new Protocol();
        String message = protocol.searchByPositionMessage(interviewee);
        String returnMessage = client.sendMessageToSever(message);
        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        return returnResult;
    }

    public void Closenet(String str){
        String returnMessage = client.sendMessageToSever(str);
        System.out.println(returnMessage);
        client.closeClient();
    }
}
