package practice;
/*
 数据类型转换：当数据类型不一样时，将会发生数据类型转换
数据类型转换方式分为：自动类型转换和强制类型转换
 自动类型转换（隐式）：
 	1、特点：代码不需要进行特殊处理，自动完成
 	2、规则：数据范围从小到大
 */
public class Demo03DataType {
	public static void main(String[] args) {
		System.out.println(1024);//这是一个整数，默认为int类型
		System.out.println(3.14);//这是一个浮点数，默认为double类型
		
		//左边是long类型，右边是默认的int类型
		//int -> long，符合了数据范围从小到大的自动转换要求
		//发生了自动类型转换
		long num1 = 100;
		System.out.println(num1);//100
		
		//float -> double,发生了自动类型转换
		double num2 = 2.5F;
		System.out.println(num2);//2.5
		
		//左边是float类型，右边是long类型，自动转换
		//long -> float，范围是float更大一些，符合自动类型转换从小到大的规则
		float num3 = 30L;
		System.out.println(num3);//30.0
	}

}


