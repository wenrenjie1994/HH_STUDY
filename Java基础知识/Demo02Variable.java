/*
基本数据类型
整数型 byte（字节型，1个字节） short（短整型，2个字节） int（整型，4个字节） long（长整型8个字节）
浮点型 float(单精度 4个字节) double（双精度，8个字节，默认）
字符型 char(2个字节)可以允许一个中文
布尔型 boolean （1个字节）

注意：
字符串不是基本类型，而是引用类型
2.浮点型可能只是一个近似值，并非精确的值
3.数据范围与字节数不一定相关，例如float数据范围比long更加广泛。
4.浮点数当中默认类型是double，如果一定要使用float类型，需要加上一个后缀F	
  如果是整数，默认为int,如果要使用long型，需要加上一个后缀L,推荐使用大写字母后缀
*/


/*
变量：程序运行期间，内容可以发生改变的量  

*/

public class Demo02Variable{
	public static void main(String[] args){
	//创建变量
	//格式：数据类型 变量名称；
	int num1;
	num1=10;
	System.out.println(num1 );
	
	byte num2=30;//数据数值不可以超过左侧数据类型的取值范围，byte的范围是128-（-127）
	System.out.println(num2);
	
	long num3=3000000000L;//一定要加L;运行结果不会有L
	System.out.println(num3);
	}
}