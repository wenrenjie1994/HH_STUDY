package practice;
/*
方法的重载（overload）：多个方法的名称一样，但参数列表不同

方法重载中参数列表不同包括如下：
	1、参数个数不同
	2、参数类型不同
	3、参数的多类型顺序不同
注意事项：
	1、方法重载与参数的名称无关
	2、方法重载与返回值类型无关
 */
public class Demo22MethodOverload {

	public static void main(String[] args) {
		//调用功能类似的三个名称不同的方法
		System.out.println(sumTwo(10, 20));//30
		System.out.println(sumThree(10, 20, 30));//60
		System.out.println(sumFour(10, 20, 30, 40));//100
		
		//调用同一个方法
		System.out.println(sum(10, 20));
		System.out.println(sum(10, 20, 30));//60
		System.out.println(sum(10, 20, 30, 40));//100
	}
	
	//以下下三个方法想实现的功能类似，但参数列表不一样，导致需要写多个名称不同但功能类似的方法，太麻烦
	public static int sumTwo(int a,int b) {
		return a + b;
	}
	public static int sumThree(int a,int b,int c) {
		return a + b + c;
	}
	public static int sumFour(int a,int b,int c,int d) {
		return a + b + c + d;
	}
	
	//以下三个方法名称相同，但参数列表不同，构成了方法的重载
	public static int sum(int a,int b) {
		System.out.println("有2个参数的方法执行！");
		return a + b;
	}
	public static int sum(int a,int b,int c) {
		System.out.println("有3个参数的方法执行！");
		return a + b + c;
	}
	public static int sum(int a,int b,int c,int d) {
		System.out.println("有4个参数的方法执行！");
		return a + b + c + d;
	}

}
