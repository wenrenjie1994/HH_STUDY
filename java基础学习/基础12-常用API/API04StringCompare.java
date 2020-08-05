package highLevel;
/*
对于基本类型来说，==是进行数值的比较
对于引用类型来说，==是进行地址值的比较

常用的字符串内容比较方法：
	1、public boolean equals(Object obj):参数可以是任何对象，只有参数是一个字符串并且内容相同才返回true
	2、public boolean euquasIgnoreCase(String str):忽略大小写，进行比较
注意事项：
	1、任何对象都能用Object进行接收
	2、equals方法具有对称性，也就是a.euqals(b)和b.euqals(a)效果一样
 	3、如果比较双方一个常量一个变量，推荐把常量字符串写在前面
 */
public class API04StringCompare {

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello";
		char[] charArray = {'H', 'e', 'l', 'l', 'o'};
		String str3 = new String(charArray);
		
		System.out.println(str1.equals(str2));//true
		System.out.println(str1.equals(str3));//true
		System.out.println(str1.equals("Hello"));//true
		System.out.println("Hello".equals(str1));//true
		System.out.println("===============");

	}

}
