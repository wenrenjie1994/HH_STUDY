package cn.bigruili.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
	private BufferedWriter bw;
	//状态行+响应头
	private StringBuilder responseHead;
	//响应体
	private StringBuilder content;
	private int size;
	private final String BLANK=" ";
	private final String ENTER="\r\n";
	public Response() {
		responseHead=new StringBuilder();
		content=new StringBuilder();
		size=0;
	}
	public Response(Socket client) {
		this();
		try {
			bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			responseHead=null;
			System.out.println("响应封装失败");
		}
	}
	//拼接固定头信息
	private void creatHeadInfo(int code){
		//1.状态行 HTTP/1.1 200 OK
		responseHead.append("HTTP/1.1").append(BLANK);
		responseHead.append(code).append(BLANK);
		switch(code){
		   case 200:
		    responseHead.append("OK").append(ENTER);
		    break;
		   case 404:
		    responseHead.append("NOT FOUND").append(ENTER);
		    break;
		   case 505:
		    responseHead.append("SERVER ERROR").append(ENTER);
		    break;
		}
		//2.响应头
		//Date:
		//Server:bigruili Server/0.0.1;charset=UTF-8
		//Content-type:text/html
		//Content-length:xxx
		//空一行
		responseHead.append("Date:").append(new Date()).append(ENTER);
		responseHead.append("Server:").append("bigruili Server/0.0.1;charset=UTF-8").append(ENTER);
		responseHead.append("Content-type:").append("text/html").append(ENTER);
		responseHead.append("Content-length:").append(size).append(ENTER);
		responseHead.append(ENTER);
	}
	//动态添加响应体
	public Response print(String info){
		content.append(info);
		size+=info.getBytes().length;
		return this;
	}
	public Response println(String info){
		content.append(info).append(ENTER);
		size+=(info+ENTER).getBytes().length;
		return this;
	}
	//推送整个响应
	public void pushToBrowser(int code) throws IOException{
		if(responseHead==null){
			code=505;
		}
		creatHeadInfo(code);
		bw.append(responseHead);
		bw.append(content);
		bw.flush();
		System.out.print(responseHead.toString()+content.toString());
	}
	public void release(){
		try {
			if(bw!=null){
			bw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("响应释放出错");
		}
	}
}
	