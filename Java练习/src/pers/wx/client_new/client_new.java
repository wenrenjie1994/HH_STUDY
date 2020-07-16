package pers.wx.client_new;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.util.*;
import java.net.*;
 
public class client_new
{
 
	private static String line=null;
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		runSocket();
		
	}
	private static void runSocket() throws IOException
	{
		final String HOST="192.168.1.2";
		//final String HOST="127.0.0.1";
		Socket socket = new Socket(HOST, 3574);//创建一个客户端连接
		OutputStream out = socket.getOutputStream();//获取服务端的输出流，为了向服务端输出数据
		InputStream in=socket.getInputStream();//获取服务端的输入流，为了获取服务端输入的数据
 
		PrintWriter bufw=new PrintWriter(out,true);
		BufferedReader bufr=new BufferedReader(new InputStreamReader(in));
		while (true) 
		{
			line=bufr.readLine();//读取服务端传来的数据
			if(line==null)
				break;
			System.out.println("服务端说:"+line);//打印服务端传来的数据
			bufw.println((new Date()) + ",Hello,I am Client!");//发送数据给服务端
 
		}
	}
	
}