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
 *过程服务器
 */
public class Server01 {
    private ServerSocket serverSocket;
    private InputStream is;
    private Socket client;
    private BufferedWriter bw;
    public static void main(String[] args) {
		Server01 server=new Server01();
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
			//读请求
			byte[] datas=new byte[1024*1024];
			is=client.getInputStream();
			int len=is.read(datas);
			String requestInfo=new String(datas,0,len);
		    System.out.println(requestInfo);
				//拼响应
				StringBuilder content=new StringBuilder();
				content.append("<html>");
				content.append("<head>");
				content.append("<title>");
				content.append("服务器响应成功");
				content.append("</title>");
				content.append("</head>");
				content.append("<body>");
				content.append("bigruili server");
				content.append("</body>");
				content.append("</html>");
				int size=content.toString().getBytes().length;//响应体字节长度
				StringBuilder responseInfo=new StringBuilder();
				String BLANK=" ";
				String ENTER="\r\n";
				//1.状态行 HTTP/1.1 200 OK
				responseInfo.append("HTTP/1.1").append(BLANK);
				responseInfo.append("200").append(BLANK);
				responseInfo.append("OK").append(ENTER);
				//2.响应头
				//Date:
				//Server:bigruili Server/0.0.1;charset=UTF-8
				//Content-type:text/html
				//Content-length:xxx
				//空一行
				responseInfo.append("Date:").append(new Date()).append(ENTER);
				responseInfo.append("Server:").append("bigruili Server/0.0.1;charset=UTF-8").append(ENTER);
				responseInfo.append("Content-type:").append("text/html").append(ENTER);
				responseInfo.append("Content-length:").append(size).append(ENTER);
				responseInfo.append(ENTER);
				//3.响应体
				responseInfo.append(content.toString());
				//写响应
				bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				bw.write(responseInfo.toString());
				bw.flush();
				System.out.println(responseInfo.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
    }
    //停止服务
    public void stop(){
    	try {
			if(is!=null){
				is.close();
				}
			if(client!=null){
				client.close();
			}
			if(bw!=null){
				bw.close();
			}
			if(serverSocket!=null){
				serverSocket.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
