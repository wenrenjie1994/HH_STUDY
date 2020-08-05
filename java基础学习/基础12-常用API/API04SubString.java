package highLevel;
/*
字符串的截取方法：
	1、public String subString(int index):截取从参数位置一直到字符串末尾，返回新字符串
	2、public String subString(int begin, int end):截取从begin开始，一直到end结束，这中间的字符串

字符串的分割方法：
	public String[] split(String regex):按照参数的规则（正则表达式规则），将字符串切分成若干部分
 */
public class API04SubString {

	public static void main(String[] args) {
		//截取从参数位置一直到字符串末尾，返回新字符串
		String str1 = "HelloWorld";
		String str2 = str1.substring(5);
		System.out.println(str1);//HelloWorld
		System.out.println(str2);//World
		
		//截取从begin开始，一直到end结束，这中间的字符串
		String str3 = str1.substring(4, 7);
		System.out.println(str3);//oWo
		
		//这种写法，strA字符串中原本的内容不会被改变，改变的是strA中保存的地址值
		String strA = "Hello";
		System.out.println(strA);//Hello
		strA = "Java";
		System.out.println(strA);//Java
		
		//字符串的分割
		String str4 = "aaa,bbb,ccc";
		String[] array1 = str4.split(",");
		for(int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}
		System.out.println("=========");
		
		String str5 = "aaa bbb ccc";
		String[] array2 = str5.split(" ");
		for(int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
		System.out.println("=========");
		
		String str6 = "aaa.bbb.ccc";
		String[] array3 = str6.split("\\.");//如果要按照“.”切分字符串，必须写成“\\.”形式，否则不能完成切分
		for(int i = 0; i < array3.length; i++) {
			System.out.println(array3[i]);
		}
		
		
	}

}
