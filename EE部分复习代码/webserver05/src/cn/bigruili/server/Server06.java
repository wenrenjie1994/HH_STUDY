package cn.bigruili.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
/**
 * 
 * @author RuiLi
 *  多线程
 */
public class Server06 {
    private ServerSocket serverSocket;
    private Socket client;
    private boolean isRunning;
    public static void main(String[] args) {
		Server06 server=new Server06();
		server.start();
		//server.stop();
	}
    //启动服务
    public void start(){
    	try {
    		serverSocket=new ServerSocket(8888);//服务器端口
    		isRunning=true;
    		receive();			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
			stop();
		}
    }
    //接收连接处理
    public void receive(){
		while(isRunning){
		try {
			client = serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			//多线程
			new Thread(new Dispatcher(client)).start();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	  }
    }
    //停止服务
    public void stop(){
    	try {
			if(client!=null){
				client.close();
			}
			if(serverSocket!=null){
				serverSocket.close();
			}
			isRunning=false;
			System.out.println("服务器停止");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器释放出错");
		}
    }
    
}
