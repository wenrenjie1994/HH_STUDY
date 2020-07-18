package practice;
/*
方法其实就是若干语句的功能集合
定义方法的完整格式：
	修饰符  返回值类型  方法名称(参数类型  参数名称,...) {
		方法体
		return 返回值;
	}
方法的调用：
	1、单独调用：方法名称（参数）
	2、打印调用:System.out.println(方法名称(参数));
	3、赋值调用：数据类型 变量名称 = 方法名称(参数);

 */
public class Demo18MethodDefine {

	public static void main(String[] args) {
		//单独调用
		sum(2,3);
		
		//打印调用
		System.out.println(sum(1,2));
		
		//赋值调用
		int summary = sum(3,4);
		System.out.println(summary);

	}
	
	//定义一个 两个int相加的方法
	public static int sum(int a,int b) {
		int result = a + b;
		return result;
		
	}
	

}
