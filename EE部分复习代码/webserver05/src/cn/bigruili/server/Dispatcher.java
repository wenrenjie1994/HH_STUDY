package cn.bigruili.server;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable{
	private Socket client;
	private Response rs;
    private Request rq;
   public Dispatcher(Socket client){
	   this.client=client;
	   try {
		     //实例化封装请求对象
		       rq=new Request(client);
		          //实例化封装响应对象
		            rs=new Response(client);
		  } catch (Exception e) {
			  this.release();
	  }
   }
	@Override
	public void run() {
		try {
			
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
		} catch (Exception e) {
			try {
				rs.pushToBrowser(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}		
		}
		release();
	}
public void release(){
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
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
