/*王旭 Java项目2020年3月27日*/
package pers.wx.Try_Catch_Exam;

public class Try_Catch {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("异常捕捉的例子：");
	    System.out.println("请分别测试以下内容：");
	    System.out.println("1、无命令行参数");
	    System.out.println("2、命令行参数为0");
	    System.out.println("3、命令行参数为一个不能表示整数的字符串");
	    System.out.println("4、命令行参数为一个表示整数的字符串，例如5");
	    System.out.println("5、命令行参数为100");
	    System.out.println("6、命令行参数为-100");
	    System.out.println("*******************************************\n");
	    
	    Try_Catch t=new Try_Catch();
	    int i=t.my_test(args);
	    System.out.println("**************************");
	    System.out.println("函数返回值为："+i);
	  }
	  
	  //把命令行参数 String args[] 传递过来
	  public int my_test(String args[])
	  {  
	    int a,b,c;
	    try
	    {
	    	a=100;
	    	
	    	//把字符串转换为int值，此处有可能发生数组下标越界异常
	    	//还可能发生数值转换异常
	    	b=Integer.parseInt(args[0]);
	    	c=a/b;    //作除法运算，此处可能发生算术运算异常
	    	System.out.println("c=a/b="+c);
	    	
	    	//如果此处执行了return语句，则try-catch-finally语句之后的其他语句不会被执行，但finally语句仍然会被执行。
	    	if(b==100) return -1;
	    	
	    	//如果此处终止了JVM，则此后的所有语句，包括finally语句、main()函数中的其他语句都不会被执行了
	    	if(b==-100) System.exit(0);	
	    	
	    }
	    catch(ArrayIndexOutOfBoundsException e)
	    {
	    	//捕捉到数组下标越界异常
	    	System.out.println("捕捉到数组下标越界异常");
	    	e.printStackTrace(); //输出异常来源
	    	return 1;
	    }
	    catch(ArithmeticException e)
	    {
	    	//捕捉到算术运算异常
	    	System.out.println("捕捉到算术运算异常");
	    	e.printStackTrace(); //输出异常来源
	    	return 2;
	    }
	    catch(NumberFormatException e)
	    {
	    	//捕捉到数值转换异常
	    	System.out.println("捕捉到数值转换异常");
	    	e.printStackTrace(); //输出异常来源
	    	return 3;
	    }
	    finally
	    {
	    	System.out.println("finally模块总是会被执行。");
	    }
	    
	    System.out.println("这是在try-catch-finaly语句之后的语句。");
	    return 0;
	  }  
}
