package highLevel;

import java.util.Arrays;

/*
java.util.Arrays是一个与数组相关的工具类，里面提供了大量的静态方法，用来实现数组常见的操作
常用的几个数组工具类Arrays方法：
	1、public static String toString(数组):将参数数组变成字符串（按照默认格式：[元素1, 元素2, 元素3...]）
 	2、public static void sort(数组):按照默认升序（从小到大）对数组的元素进行排序

注意：
	1、如果是数值，sort默认按照升序从小到大
	2、如果是字符串，sort默认按照字母升序
	3、如果是自定义类型，那么这个自定义的类需要有Comparable或Comparator接口的支持
 */
public class API06Arrays {

	public static void main(String[] args) {
		int[] intArray = {10, 20, 30};
		String intStr = Arrays.toString(intArray); //[10, 20, 30]

		int[] array1 = {2, 6, 45, 3, 1};
		Arrays.sort(array1);
		System.out.println(Arrays.toString(array1));//[1, 2, 3, 6, 45]
		
		String[] array2 = {"bbb", "aaa", "ccc"};
		Arrays.sort(array2);
		System.out.println(Arrays.toString(array2));
	
/*
题目：请使用Arrays相关API，将一个随机字符串中的所有字符升序排列，并倒序打印
 */
		String str = "aoxfnoihcaosi";
		
		//升序排列,必须是一个数组，所以需要把字符转换成数组
		char[] chars = str.toCharArray();//字符转换成数组
		Arrays.sort(chars);//对数组进行升序排列
		
		//倒序遍历
		for(int i = chars.length - 1; i >=0; i--) {
			System.out.print(chars[i]);
		}
	}

}
