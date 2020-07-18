package practice;
/*
方法带参：小括号中有内容，方法需要数据条件
方法无参：小括号中留空，不需要任何数据条件，能独立完成任务
 */
public class Demo19MethodParam {

	public static void main(String[] args) {
		method1(10,20);
		method2();
	}
	
	//两个数字相乘，做乘法，必须知道两个数字各自是多少，否则无法进行计算（方法有参）
	public static void method1(int a, int b) {
		int result = a * b;
		System.out.println("结果是"+result);
	}
	
	//方法无参，如打印输出固定10次文本
	public static void method2() {
		for(int i = 0; i < 10; i++) {
			System.out.println("java");
		}
	}
		
	

}
