package pers.wx.client;
import java.net.*;
import java.io.*;
public class wxclient {
public int data;
public int flag = 0;
 public static void main(String[] args){
	 wxclient c=new wxclient();
 }
 public wxclient(){
	 try{
		 Socket wxc=new Socket("192.168.1.2",9999);//进入端口，前面是服务器的Ip，自己电脑一般是127.0.0.1,后面的是端口，与服务器对应
	 PrintWriter pw=new PrintWriter(wxc.getOutputStream(),true);//IO流发送
	 while(flag!=1)
	 {
	 pw.println(data);//发送的内容
	 //pw.flush();
	 //s.shutdownInput();
	 }
	InputStream isr=wxc.getInputStream();//读取数据
	 BufferedReader br=new BufferedReader(new InputStreamReader(isr));//存到缓存区
	 String fanhui=br.readLine();//获取数据
	 System.out.println(fanhui);//输出数据
	 //s.close();
	 }catch(Exception e){
		 
	 }
 }
}