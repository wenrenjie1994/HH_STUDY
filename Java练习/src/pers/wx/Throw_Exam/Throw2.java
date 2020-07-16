/*王旭 Java项目2020年3月27日*/
package pers.wx.Throw_Exam;

public class Throw2 {
	
	public void abs(int a,int b) throws Exception
    { if(a<b)  throw new Exception("我抛出的异常：b比a大");
      System.out.println("a比b大");
    }

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Throw2 my_test=new Throw2();
	      int a=3,b=10;
	      try 
	        {
	        	my_test.abs(a,b);
	        }
	      catch(Exception e)  //异常捕捉 
	        { 
	          System.out.println(e.toString( ));
	        }
	      

	}

}
