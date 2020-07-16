/*王旭 Java项目2020年3月26日*/
package pers.wx.System_Exam;

public class System_Exam3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//演示使用输入流
	  	byte b[]=new byte[512]; //设定输入缓冲区为512Byte
	  	//使用输入流时必须进行异常捕捉
	    System.out.println("请输入不超过512B的字符串，按回车键结束：");
	  	try{
	  	    int i=0;
	  	    //从标准in设备输入数据到指定缓冲区 
	  	    //返回值i为输入的字节个数，注意：回车号也占据2个字节
	  	    //如果输入的字节个数大于缓冲区长度，则超出部分不会被接收。
	  	    i=System.in.read(b);

	  	    String s=new String(b,0,i); //把缓冲区中输入的数据转换为字符串
	  	    System.out.println("输入了 "+i+" 个字节的字符。");	
	  	    System.out.println("输出是: "+s);	
	        
	        /*由于System.in这个java“标准”输入流（InputStream类对象）
	        由java虚拟机自动已打开并且准备接受输入数据。
	        因此用完后也不必调用close()方法来关闭。
	        */

	  	   }
	  	 catch(Exception e) 
	  	   {
	  	   	//InputStream类的read()方法会抛出IOException类异常
	  	   	//IOException类在java.io包中定义，IOException类直接继承自Exception类
	  	   	System.out.print("输入出错！");	
	  	   }

	}

}
