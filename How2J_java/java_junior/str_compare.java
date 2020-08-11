
package character;

public class TestString {
	public static void main(String[] args) {
		String str1 = "the light";
		String str2 = new String(str1);
		String str3 = str1.toUpperCase();

		System.out.println(str1 == str2);		// 用于判断是否是同一个字符串对象

		System.out.println(str1.equals(str2));	// 完全一样返回true
		System.out.println(str1.equals(str3));	// 大小写不一样，返回false

		System.out.println(str1.equalsIgnoreCase(str3));	// 忽略大小写的比较，返回true


		String s2 = "the";
		String s3 = "Ight";
		System.out.println(str1.startsWith(s2));	// 以.... 开始
		System.out.println(str1.endsWith(s3));		// 以.... 结束
	}
}