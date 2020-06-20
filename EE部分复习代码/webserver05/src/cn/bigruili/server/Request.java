package cn.bigruili.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
	//请求信息
    private String requestInfo;
    //请求方式
    private String method;
    //url
    private String url;
    //请求参数
    private String parameter;
    //io流
    private InputStream is;
    //存参集合
    private Map<String,List<String>> parameterMap;
    private final String ENTER="\r\n";
	public Request(Socket client) {
		parameterMap=new HashMap<>();
		byte[] datas=new byte[1024*1024];
		int len;
		try {
			is=client.getInputStream();
			len=is.read(datas);
			this.requestInfo=new String(datas,0,len);
	        System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		parseRequestInfo();
		
	}
	private void parseRequestInfo(){
		System.out.println("开始分解请求信息");
		System.out.println("1.请求方式");
		//GET /index.html?uname=lr&pwd=123456 HTTP/1.1
		//POST /index.html HTTP/1.1
		//开头到第一个/
		this.method=this.requestInfo.substring(0, this.requestInfo.indexOf("/"));
		this.method=this.method.trim();
		System.out.println(method);
		System.out.println("2.url+请求参数");
		//第一个/到HTTP/
		int start=this.requestInfo.indexOf("/")+1;
		int end=this.requestInfo.indexOf("HTTP/");
		String temp=this.requestInfo.substring(start, end).trim();
		System.out.println("3.url");
		int idx=temp.indexOf("?");
		if(idx>=0){//有参数
			String[] s=temp.split("\\?");//正则
			this.url=s[0].trim();
			this.parameter=s[1].trim();
		}
		System.out.println(url);
		System.out.println("4.请求参数");
		if(method.equals("POST")){
			String p=this.requestInfo.substring(this.requestInfo.lastIndexOf(ENTER));
		     p=p.trim();
		     if(this.parameter==null){
		    	 this.parameter=p;
		     }else{ 
		    	 this.parameter+="&"+p;
		     }}
		    this.parameter= this.parameter==null?"":this.parameter;
		    //请求参数转Map fav=rap&fav=basketball&uname=lr&pwd=
		    System.out.println(parameter);
		    converMap();
		
	}
	//分隔请求参数并转换成Map  
	private void converMap() {
		//1.分割请求参数 &
		String keyvalues[]=this.parameter.split("&");
		//2.分隔键值对 =
		for(String kvs:keyvalues){
			String kv[]=kvs.split("=");
			kv=Arrays.copyOf(kv, 2);
			//3.key value
			String key=kv[0];
			kv[1]=(kv[1]==null?null:decode(kv[1],"utf-8"));
			String value=kv[1];
			System.out.println(key);
			System.out.println(value);
			//4.存参
			if(!parameterMap.containsKey(key)){
				parameterMap.put(key,new ArrayList<String>());
			}
				parameterMap.get(key).add(value);
			}	 
		    System.out.println(parameterMap.toString());
		}
	
	//请求中值是中文
	private String decode(String value,String enc){
		try {
			return java.net.URLDecoder.decode(value, enc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("中文处理出错");
			return null;
		}
	}
	public void release(){
		try {
			if(is!=null){
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("请求释放出错");
		}
	}
	public String getMethod() {
		return method;
	}
	public String getUrl() {
		return url;
	}
	public String[] getParameters(String key) {
		List<String> values=this.parameterMap.get(key);
		if(values==null||values.size()<1){
			return null;
		}return values.toArray(new String[0]);
	}
	public String getParameter(String key) {
		String values[]=getParameters(key);
		return values==null?null:values[0];
	}
	public String getParameter1() {
		return parameter;
	}
	
	public Map<String, List<String>> getParameterMap() {
		return parameterMap;
	}
	
}
