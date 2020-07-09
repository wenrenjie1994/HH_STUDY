//数据类型转换

/* 	1.隐式类型转换
		自动转换，小转大
	
	
	2.显式类型转换
		大转小   可能存在精度损失，数据溢出
		
	3.注意
		byte/short/char 在运算时会转化为int，应使用int接收
		在给变量进行赋值时，等号右侧全为常量，编译器javac会直接将结果
		进行赋值，并直接进行类型转化（编译器常量优化）。
		short = 3 + 5;3和5都是int型，编译器自动进行类型转化（short）。
 */
public class Demo03DataType{
	public static void main(String[] args){
		System.out.println(1020); // 默认int
		System.out.println(3.14); // 默认double	
		
		//int 转 long 隐式类型转换
		long num1 = 100;
		System.out.println(num1); 
		
		double num2 = 3.1F;
		System.out.println(num2); 
		
		//long 转 float float虽然占用4字节但数据范围更大
		float num3 = 5L;
		System.out.println(num3);  
		
		//long 转 int 大转小
		byte num4 = (byte)128L;  
		System.out.println(num4); //-128  
		
		//应使用int接收
		short num6 = 3;
		int num5 = num6 + num6;
		System.out.println(num5);
		
		//隐式转换 Unicode码
		int num7 = '王';
		System.out.println(num7);
		
		
	}
}