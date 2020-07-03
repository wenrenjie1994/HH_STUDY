package practice;
/*
 * 一旦运算中有不同类型的数据，结果将会是数据类型范围大的那种
 */
public class Demo05Operator {

	public static void main(String[] args) {
		//两个常量之间可以进行数学运算
		System.out.println(20+30);//50
		
		//两个变量之间也可以进行数学运算
		int a = 20;
		int b = 30;
		System.out.println(a - b);//-10

		//变量和常量之间可以混合使用
		System.out.println(a*10);//200
		
		int x = 10;
		int y = 3;
		
		int result1 = x/y;
		System.out.println(result1);//3,除法是整除，整数除以整数结果仍为整数
	
		int result2 = x % y;
		System.out.println(result2);//1
		
		double result3 = x + 2.5;
		System.out.println(result3);//12.5

/*
 四则运算中的加号的用法：
 	1.对于数值来说，是加法
 	2.对于字符char类型来说，在计算之前会通过ASCII表转换为int再计算
 	3.对于字符串String来说，加号代表字符串连接操作
 */
		//字符串类型变量的使用
		String str1 = "hello";
		System.out.println(str1+"world");//helloworld
		
		//任何数据类型和字符串进行连接的时候，结果都会变成字符串
		String str2 = "java";
		System.out.println(str2 + 20);//java20
		
		//优先级问题
		System.out.println(str2 + 20 + 30);//java2030
	}

}