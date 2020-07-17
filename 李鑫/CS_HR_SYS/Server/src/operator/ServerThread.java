package operator;

import model.ActionResult;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;
import util.Parser;
import util.Protocol;
import work.Action;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerThread extends Thread{

    private final Socket conn;
    private Action action;

    public ServerThread(Socket conn) {
        this.conn = conn;
        this.action = action = new Action();
    }

    @Override
    public void run() {

        while (true) {

            /*
             * 用Server中的getMessageByClient方法得到协议（字符串）
             * 把协议（字符串）放到parser里解析 返回得到ReturnResult（包含head和数据两个属性）类型结果
             * if语句判断head信息得到用户端想进行什么操作
             * 把ReturnResult的data转换为ResumeList从而得到Resume
             * 把得到的Resume传到Action进行连接数据库进行增删改查的操作并返回ActionResult（包含是否成功 ，失败愿意 ，成功结果三个属性）类型结果
             * 把ActionResult交给Protocol中编写协议（字符串）并返回
             * 用Server中的sendMessageToClient方法把协议（字符串）发送到客户端
             * 如果传过来的信息为"bye"关闭服务器跳出while
             * */

            String string;
            DataInputStream in;
            DataOutputStream out;
            try {

                /*
                * InputStreamReader 将字节流转换为字符流。是字节流通向字符流的桥梁。如果不指定字符集编码，该解码过程将使用平台默认的字符编码
                * OutputStreamWriter 将字符流转换为字节流。是字符流通向字节流的桥梁。如果不指定字符集编码，该解码过程将使用平台默认的字符编码
                * PrintWriter 是字符类型的打印输出流，使用BufferedWriter包装，减少方法的调用次数
                *
                * NOTE: 使用BufferedReader会出现不明BUG，无法从BufferedReader中读取数据，因此暂时使用DataInputStream类
                * in =new BufferedReader(new InputStreamReader(connection.getInputStream()));
				* out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())),true);
                * */

                in = new DataInputStream(conn.getInputStream());
                out = new DataOutputStream(conn.getOutputStream());
                string = in.readUTF();

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
                break;
            }

            if (string.equals("bye")) {
                try{
                    out.writeUTF("bye");
                    in.close();
                    out.close();
                    conn.close();
                    action.closeConnection();
                    break;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else {
                Parser parser = new Parser();
                ReturnResult returnResult = parser.parse(string);  // returnResult.head=操作指令，returnResult.data=数据
                ActionResult actionResult;

                if (returnResult.head.equals("add")) {  // 识别指令
                    Resume resume = (Resume) returnResult.resultData;  // 通过客户端的数据建立一个Resume对象
                    actionResult = action.addResume(resume);  // 执行add指令，返回结果对象
                    Protocol protocol = new Protocol();
                    String message = protocol.processResumeMessage(actionResult);  // 格式化（封装）结果数据
                    System.out.println("向客户端返回：" + message);
                    try {
                        out.writeUTF(message);  // 向客户端发送格式化的结果数据
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else if (returnResult.head.equals("delete")) {
                    Resume resume = (Resume) returnResult.resultData;
                    actionResult = action.deleteResume(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.processResumeMessage(actionResult);
                    System.out.println("向客户端返回：" + message);
                    try {
                        out.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else if (returnResult.head.equals("update")) {
                    ResumeList resumeList = (ResumeList) returnResult.resultData;
                    actionResult = action.updateResume(resumeList);
                    Protocol protocol = new Protocol();
                    String message = protocol.processResumeMessage(actionResult);
                    System.out.println("向客户端返回：" + message);
                    try {
                        out.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else if (returnResult.head.equals("search")) {
                    Resume resume = (Resume) returnResult.resultData;
                    actionResult = action.searchResume(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(actionResult);
                    System.out.println("向客户端返回：" + message);
                    try {
                        out.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
