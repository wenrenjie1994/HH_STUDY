/**
 * projectName: HRS5.0_client
 * fileName: Client.java
 * packageName: net
 * date: 2020-08-03 16:01
 * copyright(c) tianyifan
 */
package net;

import java.io.*;
import java.net.Socket;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: Client
 * @packageName: net
 * @description: 客户端类
 * @date: 2020-08-03 16:01
 **/
public class Client {
    private static BufferedReader in;//输入流
    private static PrintWriter out;//输出流
    private Socket tcpConnection;//TCP连接

    /**
     *@title: Client
     *@description: 构造方法，启动客户端，初始化
     *@author: tianyifan
     *@date: 2020-08-03 16:07
     *@param: 无
     *@return: 无
     *@throws: 无
     */
    public Client() throws IOException {
        tcpConnection = new Socket("127.0.0.1", 8888);
        if (tcpConnection != null){
            System.out.println("连接服务器成功");
        }
        in = new BufferedReader(new InputStreamReader(tcpConnection.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpConnection.getOutputStream())),true);
    }

    private static class clientContainer{
        private static Client client;

        static {
            try {
                client = new Client();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *@title: getClient
     *@description: 获取实例化客户端对象方法
     *@author: tianyifan
     *@date: 2020-08-03 16:14
     *@param: 无
     *@return: net.Client
     *@throws: 无
     */
    public static Client getClient(){
        return clientContainer.client;
    }

    /**
     *@title: sendMssageToServer
     *@description: 向服务器端发送信息
     *@author: tianyifan
     *@date: 2020-08-03 16:16
     *@param: [message]
     *@return: java.lang.String
     *@throws: 无
     */
    public String sendMssageToServer(String message) throws IOException {
        String str = "";
        out.println(message);
        System.out.println("向服务器端发送信息："+message);
        str = in.readLine();
        return str;
    }

    /**
     *@title: closeClient
     *@description: 关闭客户端及各种流和连接
     *@author: tianyifan
     *@date: 2020-08-03 16:19
     *@param: 无
     *@return: void
     *@throws: 无
     */
    public void closeClient() throws IOException {
        in.close();
        out.close();
        tcpConnection.close();
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}
