package practice;
/*
强制类型转换：
	1.特点：代码需要进行特殊的格式处理，不能自动完成
	2.格式：范围小的类型 范围小的变量名 = （范围小的类型）原本范围大的数据
注意：
	1.强制类型转换一般不推荐使用，因为有可能发生精度损失、数据溢出
 	2.byte、short、char这三种类型都可以发生数学运算，例如加法“+”
 	3.byte、short、char这三种类型在运算时都会被首先提升成为int类型再计算
 	4.boolean类型是不能发生数据类型转换
 */

public class Demo04DataType {

	public static void main(String[] args) {
		//左边int，右边long，int数据范围小于long，不能自动类型转换
		//需进行强制类型转换
		int num = (int)100L;
		System.out.println(num);//100
		
		//long强制转换为int类型
		//但long类型的数值超过了int的数值范围，强制转换以后发生了数据溢出
		int num2 = (int)6000000000L;
		System.out.println(num2);//1705032704

		//double --> int，强制类型转换
		int num3 = (int)3.99;
		System.out.println(num3);//3,发生了精度损失，所有的小数位都会被舍弃
		
		char var = 'A';
		//char进行运算时，会进行一个ASCII码的转换
		System.out.println(var+1);//66,A的ASCII码是65
		
		byte num4 = 40;
		byte num5 = 50;
		//byte+byte 等价于 int+int，因为byte做运算时会先提升为int
		int result1 = num4 + num5;
		System.out.println(result1);//90
		
		short num6 = 60;
		//byte+short --> int+int 
		int result2 = num4+num6;
		System.out.println(result2);
		
		//非要使用强制转换也可以，但必须保证不会发生数据溢出
		short result3 = (short)(num4+num6);
		System.out.println(result3);//也会输出100
	}
	

}
