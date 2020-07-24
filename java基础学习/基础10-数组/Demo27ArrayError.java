package practice;
/*
常见的数组错误异常：
	1、数组索引越界异常：ArrayIndexOutOfBoundsException
	2、空指针异常：NullPointerException
		数组必须进行new初始化才能使用其中的元素，如果只是赋值为一个null，没有new创建，将会发生空指针异常
 */
public class Demo27ArrayError {

	public static void main(String[] args) {
		int[] array = {10, 20, 30};
		System.out.println(array[0]);//10
		System.out.println(array[1]);//20
		System.out.println(array[2]);//30
		
		//数组索引并不存在，发生索引越界异常
		System.out.println(array[3]);
		
		int[] arrayB = null;
		//arrayB = new int[3];
		//数组还未创建内存空间且未赋值，发生空指针异常
		System.out.println(arrayB[0]);

	}

}
