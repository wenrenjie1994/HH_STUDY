/*王旭 Java项目2020年3月27日*/
package pers.wx.Throw_Exam;

class 自定义异常类 extends Exception
{
  String msg;
  public 	自定义异常类() //构造方法
  {
    this.msg="";	
  }
  public 	自定义异常类(String s)  //构造方法
  {
    this.msg=s;	
  }
	public String toString()  //方法重写
	{
		return super.toString()+"："+this.msg;
	}
}

public class ExtendsException {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a=3;
    	int x;
    	自定义异常类 my_e=new 自定义异常类("数值小于100");
      try 
        {
        	if(a<100) throw my_e;  //自定义异常类只用于人为判断是否抛出异常的情况下
        	x=a/0;
        }
      catch(自定义异常类 e)  //捕捉“自定义异常类”异常
        { 
          System.out.println("捕捉到“自定义异常类”异常");
          e.printStackTrace(); //输出异常来源
        }  
      catch(ArithmeticException e)  //捕捉算术运算异常
        {
    	    System.out.println("捕捉到算术运算异常");
    	    e.printStackTrace(); //输出异常来源
        }     

	}

}
