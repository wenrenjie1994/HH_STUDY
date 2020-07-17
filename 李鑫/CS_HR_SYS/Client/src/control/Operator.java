package control;

import model.Resume;
import model.ReturnResult;
import net.Client;
import util.Parser;
import util.Protocol;

public class Operator {

    Client client = Client.getClient();
    Protocol protocol = new Protocol();
    Parser parser = new Parser();

    /*
     * 模式
     * 把传过来的Resume放到Protocol中编写协议
     * 把得到的协议通过Client里的sendMessage2Sever方法把协议（字符串）发送到服务器
     * 把服务器返回的协议（也是字符串）parser 解析 解析后返回ReturnResult类型结果
     * 把结果在返回给界面输出
     * */

    public ReturnResult addResume(Resume resume) {

        String message = protocol.addResumeMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);

        return parser.parseProcess(returnMessage);
    }

    public ReturnResult deleteResume(Resume resume) {

        String message = protocol.deleteResumeMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);

        return parser.parseProcess(returnMessage);
    }

    public ReturnResult updateResume(Resume oldResume, Resume newResume) {

        String message = protocol.updateResumeMessage(oldResume, newResume);
        String returnMessage = client.sendMessage2Sever(message);

        return parser.parseProcess(returnMessage);
    }

    public ReturnResult searchResume(Resume resume) {
        String message = protocol.searchResumeMessage(resume);
        String returnMessage = client.sendMessage2Sever(message);

        return parser.parseSearch(returnMessage);
    }

    public void closeNet(String closeInstruction) {
        String returnMessage = client.sendMessage2Sever(closeInstruction);
        client.closeClient();
    }
}
