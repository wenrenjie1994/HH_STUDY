package highLevel;
/*
java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作
相关方法：
	1、public static double abs(double num):获取绝对值
	2、public static double ceil(double num):向上取整
	3、public static double floor(double num):向下取整
	4、public satic long round(double num):四舍五入

Math.PI代表近似的圆周率常量（double）
 */
public class API07Math {

	public static void main(String[] args) {
		// 获取绝对值
		System.out.println(Math.abs(-3.12));//3.12
		
		//向上取整
		System.out.println(Math.ceil(3.45));//4.0
		
		//向下取整
		System.out.println(Math.floor(2.10));//2.0
		
		//四舍五入
		System.out.println(Math.round(2.94));//3
		
		//圆周率常量
		System.out.println(Math.PI);
		
/*
题目：计算-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个？
分析：
	1、既然已经确定了范围，for循环
	2、起点位置-10.8应该转换为-10，两种办法：
		2.1可以使用Math.ceil,向上取整
		2.2强转成int，自动舍弃所有小数
	3、每一个数字都是整数，所以步进表达式是num++
	4、获取绝对值，Math.abs
	5、一旦发现一个符合要求的整数，就让计数器++
 */
		double min = -10.8;
		double max = 5.9;
		int count = 0;//计数器
		
		//int i = (int)min，这样处理变量就是整数
		for(int i = (int)min; i < 5.9; i++) {
			int abs = Math.abs(i);//获取区间中的整数的绝对值
			if(abs > 6 || abs < 2.1) {
				System.out.println(i);
				count++;
			}
		}
		System.out.println("总共有符合要求的个数：" + count);

	}

}
