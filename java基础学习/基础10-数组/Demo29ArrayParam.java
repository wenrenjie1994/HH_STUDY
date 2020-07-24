package practice;
/*
数组可以作为方法的参数
当调用方法的时候，向方法的小括号进行传参，传进去的其实是数组的地址值
一个方法可以有0、1、多个参数，但是只能有0或者1个返回值
如果想对方法中产生的多个结果进行返回，可以采用数组作为返回值类型

任何数据类型都能作为方法的参数类型，或者返回值类型
 */
public class Demo29ArrayParam {

	public static void main(String[] args) {
		int [] array = {10,20,30,40};
		printArray(array);//调用打印数组的方法
		System.out.println("============");
		
		int[] result = calculate(10, 20, 30);
		System.out.println("总和：" + result[0]);
		System.out.println("平均数：" + result[1]);

	}
	
	//数组作为方法参数
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	//数组作为返回值类型
	public static int[] calculate(int a, int b, int c) {
		int sum = a+b+c;
		int avg = sum / 3;
		
		//sum、avg这两个结果都希望返回。则可以把它们放在数组里
		int[] array = new int [2];
		array[0] = sum;
		array[1] = avg;
		
		return array;
	}

}
