package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Operator.ServerThread;

public class Server {
	

	static ServerSocket  ss;
	Socket tcpConnection ;
	public Server()
	{
		try {
			ss = new ServerSocket(1235);
			System.out.println("服务器启动了，等待客户端连接...");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true)
		{
			
			try {
				tcpConnection = ss.accept();//有新的Client连接
				System.out.println("有客服端连接上了");
				ServerThread r=new ServerThread(tcpConnection);//创建新的线程
				//每来一个女妖怪，我都要新建一个孙悟空，其实非常耗资源的，孙悟空解决了女妖怪过后，我又 手动把孙悟空杀了
				//线程池=粪坑
				r.start();//运行线程
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Server();

	}

}

