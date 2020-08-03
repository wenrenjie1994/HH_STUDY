package control;

import model.Resume;
import model.ReturnResult;
import net.Client;
import util.Parser;
import util.Protocol;

public class Operator {
	Client client;
	public Operator(Client client){
		this.client = client;
//		if (client == null)
//			client = new Client();

	} 
	/*
	 * 模式
	 * 把传过来的book放到Protocol中编写协议
	 * 把得到的协议通过Client里的sendMessageToSever方法把协议（字符串）发送到服务器
	 * 把服务器返回的协议（也是字符串）parser 解析 解析后返回ReturnResult类型结果
	 * 把结果在返回给界面输出
	 * */

	public ReturnResult addResume(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.AddResumeMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserCRUD(returnMessage);
		return returnResult;
	}
	public ReturnResult deleteResumeByName(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.deleteResumeByNameMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserCRUD(returnMessage);
		return returnResult;
	}
	public ReturnResult deleteResumeById(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.deleteResumeByIdMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserCRUD(returnMessage);
		return returnResult;
	}
	public ReturnResult changeResume(Resume resume, Resume oldResume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.changeResumeMessage(resume,oldResume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserCRUD(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByName(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByNameMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchById(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByIdMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchBySchool(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeBySchoolMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByProcess(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByProcessMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByKeyWord(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByKeyWordMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult listAllResumeInfo()
	{
		Protocol protocol = new Protocol();
		String message = protocol.listAllResumeInfoMessage();
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public void closeNet(String str)
	{
		String returnMessage = client.sendMessageToSever(str);
		client.closeClient();
	}

}
