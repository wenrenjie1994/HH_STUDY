package practice;
/*
变量：程序运行期间，内容可以发生改变的量
	变量的创建：
°	分布式
数据类型  变量名称； //创建一个变量
变量名称 = 数据值； //赋值，将右边的数据值赋值给左边的变量
°	一步到位式：
数据类型  变量名称 = 数据值； //创建变量的同时赋值

 */
public class Demo02Variable {
	public static void main(String[] args) {
		int num1; //创建一个变量
		num1 = 10; //给变量赋值存入数据
		System.out.println(num1);//输出变量值10
		
		//一步到位式定义变量
		int num2 = 24;
		System.out.println(num2);//24
		System.out.println("=======");
		
		byte num3 = 30; //注意：右侧数值的范围不能超过左侧数据类型的取值范围，byte范围：-128~127
		System.out.println(num3);//30
		
		//byte num4 = 400;//右侧超出了byte的数据范围，会提示错误！
		 short num5 = 50;
		 System.out.println(num5);//50
		 
		 long num6 = 300000000L;
		 System.out.println(num6);//300000000
		 
		 float num7 = 2.5f;
		 System.out.println(num7);//2.5
		 
		 double num8 = 1.2;
		 System.out.println(num8);//1.2
		 
		 char var1 = 'A';
		 System.out.println(var1);//A
		 var1 = '中';
		 System.out.println(var1);//中
		 
		 boolean var2 = true;
		 System.out.println(var2);//true
		 
		 //将一个变量的数据内容，赋值交给另一个变量
		 boolean var3 = var2;
		 System.out.println(var3);//true
	}

}
