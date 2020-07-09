/* 基本数据类型：
	整数型 byte short int（默认） long(分别占用1、2、4、8byte)
	浮点型 float double(默认)（4、8byte）
	字符型 char（2byte）
	bool型 boolean（1byte）
引用数据类型：
	字符串、数组、类、接口、Lambda
	
注意：
	1.字符串不是基本类型，而是引用类型
	2.浮点型可能为近似值
	3.数据范围与字节数不一定相关，如：float范围比long广泛
	4.float加上F后缀；long加上后缀L
 */
 
//变量
public class Demo02Variable{ 
	public static void main(String[] args){
		int num1 = 10;
		System.out.println(num1);
		
		byte num2 = 127;
		System.out.println(num2);
		
		boolean num3 = true;
		System.out.println(num3);
	}
}
 
 
 
 
 
 
 
 
 
 