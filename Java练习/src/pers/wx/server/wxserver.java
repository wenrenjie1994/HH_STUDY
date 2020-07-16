package pers.wx.server;
import java.net.*;
import java.io.*;

public class wxserver {
	public wxserver(){
		try{
			ServerSocket wxs=new ServerSocket(9999);//设置服务器的端口
			System.out.println("服务器正在监听");
			Socket s=wxs.accept();//只有服务器被客户连接之后，才会执行后面的语句
			//System.out.println("22");//验证是否连接成功
			InputStreamReader isr=new InputStreamReader(s.getInputStream());//接收客户端的数据
			BufferedReader br=new BufferedReader(isr);//存入缓存
			String xinxi=br.readLine();//读出
			System.out.println(xinxi);//打印数据
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);//向客户端传数据
			pw.println("我是服务器");//数据是啥
			//ss.close();
		}catch(Exception e){
 
 
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		wxserver a=new wxserver();

	}

}
