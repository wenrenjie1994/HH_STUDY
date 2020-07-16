/*
强制类型转换
	1.特点：代码需要进行特殊的格式处理，不能自动转换
	2.格式：范围小的类型 范围小的变量名=（范围小的类型）原本范围大的数据
	
注意事项
	1.强制类型转换一般不推荐使用，因为有可能发生精度损失、数据溢出
	2.byte/shotr/char这三种类型都可以发生数学运算，例如“+”，
	3.byte/shotr/char这三种类型进行运算时计算机会自动提升为int类型
	4.boolean类型不能发生数据类型转换
	5.对于byte /short/char三种类型来说，如果右侧赋值的数值没有超过范围，
	那么Java编译器将会自动隐含地为我们补上一个（byte）(short)(char)
	6.在给变量进行赋值时，如果右侧的表达式当中全都是常量，没有任何变量，
	那么编译器 javac将会直接将若干个常量表达式计算得到结果
运算符
   加法
	1.对于数值来说，就是加法
	2.对于char类型来说，在计算之前，char会被提升为int，然后再计算
	3.对于字符串String(首字母大写，不是关键字)来说，加号代表字符串连接操作。
	  任何数据类型和字符串进行连接的时候，结果都会变成字符串
*/
public class Demo02DataType {
	public static void main(String[] args){
		int num1=(int)100L;
		System.out.println(num1);//100
		
		//long强制转换成int类型
		int num2=(int)6000000000L;
		System.out.println(num2);//1705032704
		
		//double-->int
		int num3=(int)3.99;
		System.out.println(num3);//3
		
		
		char zifu1='A';
		System.out.println(zifu1+1);//66,A被当作65进行处理
		
		byte num4=40;
		byte num5=50;
		//byte result1=num4+num5;  错误的
		int result1=num4+num5;
		System.out.println(result1);//90
		
		short a=5;
		short b=8;
		//short result=a+b;  写法错误，左侧需要是int类型
		
		//6.在给变量进行赋值时，如果右侧的表达式当中全都是常量，没有任何变量，
	    //    那么编译器 javac将会直接将若干个常量表达式计算得到结果
		//相当于 short result=13;
		//这称为“编译器的常量优化”。但是一旦表达式中有变量参与，那么久不能进行这种优化
		short result=5+8;
		System.out.println(result);//正确
		
		
	}
}