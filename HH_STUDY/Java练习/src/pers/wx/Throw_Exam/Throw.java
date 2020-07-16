/*王旭 Java项目2020年3月27日*/
package pers.wx.Throw_Exam;

public class Throw {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 int a=10,b=55,x;    //若b换成5，则不会抛出，不会执行catch函数
		    try
		    
		{   //在必要时可以使用throw语句显示地抛出一个人为判断的异常，而不是靠系统自动抛出异常
		    	   if(a<b)  throw new Exception("我抛出的异常：b比a大");
		    	   x=a-b;
		    
		}
		    catch(Exception e)
		    
		{  //异常捕捉
		    	  x=b-a;
		    	  System.out.println(e.toString( ));
		    
		}
		    System.out.println(x);
		  }

}
