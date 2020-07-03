package practice;
/*
赋值运算符：
	基本赋值运算符：=，代表将右侧的数据交给左侧的变量
	复合赋值运算符：+=、-=、*=、/=、%=
注意：
	1.只有变量才能使用赋值运算符，常量不能放在赋值运算符左边
	2.复合赋值运算符其中隐含了一个强制类型转换
 */
public class Demo07Operator {
	public static void main(String[] args) {
		int a = 10;
		a += 10;
		System.out.println(a);//20
		
		int x = 10;
		x %= 3;
		System.out.println(x);//1

/*
比较运算符：>、<、>=、<=、==、!=
注意事项：
	1.比较运算符的结果一定是一个boolean值
	2.如果进行多次判断，不能连着写，如不能写1<x<3
 */
		System.out.println(10 > 5);//true
		int num1 = 10;
		int num2 = 12;
		System.out.println(num1<num2);//true
		System.out.println(num2>100);//false
	}

}