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
 *引入servlet服务器
 */
public class Server04 {
    private ServerSocket serverSocket;
    private Socket client;
    private Response rs;
    private Request rq;
    public static void main(String[] args) {
		Server04 server=new Server04();
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
				Servlet se;
				if(rq.getUrl().equals("login")){
			        se=new LoginServlet();
			        se.service(rq, rs);
			        }else if(rq.getUrl().equals("reg")){
			        se=new RegisterServlet();
			        se.service(rq, rs);
			        }else{
			        	//首页
			        }
				//推
				rs.pushToBrowser(200);			
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
