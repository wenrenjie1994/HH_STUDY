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
 *引入servlet服务器+xml的url获取servlet
 */
public class Server05 {
    private ServerSocket serverSocket;
    private Socket client;
    private Response rs;
    private Request rq;
    public static void main(String[] args) {
		Server05 server=new Server05();
		server.start();
		//server.stop();
	}
    //启动服务
    public void start(){
    	try {
    		serverSocket=new ServerSocket(8888);//服务器端口
    		receive();			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
			stop();
		}
    }
    //接收连接处理
    public void receive(){
		try {
			client = serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			//实例化封装请求对象
			rq=new Request(client);
				//实例化封装响应对象
				rs=new Response(client);
				//实例化Servlet
				Servlet se=WebApp.getServletFromUrl(rq.getUrl());
				if(se!=null){
			       se.service(rq, rs);
			       //推
			       rs.pushToBrowser(200);			
			        }else{
			        	//错误页面
			        	rs.pushToBrowser(404);			
			        }
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
    }
    //停止服务
    public void stop(){
    	try {
			if(client!=null){
				client.close();
			}
			if(rs!=null){
				rs.release();
			}
			if(rq!=null){
				rq.release();
			}
			if(serverSocket!=null){
				serverSocket.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器释放出错");
		}
    }
    
}
