package highLevel;
/*
String中与获取相关的常用方法：
	1、public int length():获取字符串中含有的字符个数，即字符串长度
	2、public String concat(String str):将当前字符串和参数字符串拼接成为返回值新的字符串
	3、public char charAt(int index):获取指定索引位置的单个字符（索引从0开始）
	4、public int indexOf(String str):查找参数字符串在本来字符串当中首次出现的索引位置，如果没有返回-1值
 */
public class API04StringGet {

	public static void main(String[] args) {
		//获取字符串长度
		String str1 = "sjxiqonchaoinqoerhfn";
		int num = str1.length();
		System.out.println("字符串长度：" + num);
				
		//拼接字符串
		String str2 = "Hello";
		String str3 = "World";
		String str4 = str2.concat(str3);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		//获取指定索引位置的单个字符
		char ch = "Hello".charAt(1);
		System.out.println("1号位置的字符：" + ch);
		
		//查找参数字符串在本来字符串当中出现的第一次索引位置。如果没有，则返回-1
		String original = "HelloWorld";
		int index = original.indexOf("Wor");
		System.out.println("第一次出现的索引值是:" + index);
	}

}
