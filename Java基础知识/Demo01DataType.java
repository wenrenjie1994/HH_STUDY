/*
数据类型转换

当数据类型不一样时，将会发生数据类型装换

自动转换（隐式）
	1.特点：代码不需要进行特殊处理，自动完成
	2.规则，数据范围从小到大


*/

public class Demo01DataType{
	public static void main(String[] args){
		System.out.println(1024);
		System.out.println(3.14);
		
		long num1=100L;
		System.out.println(num1);//100
		
		//int -->long ,符合数值范围从小到达
		//这一行代码发生了自动类型转换
		long num2=100;//左边是long，右边是int,左右不一样
		System.out.println(num2);//100
		
		//左边是float，右边是long,左右不一样
		//long -->float,符合数值范围从小到大
		float num3=100L;
		System.out.println(num3);//
	}
}