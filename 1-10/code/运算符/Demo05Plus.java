public class Demo05Plus{
	public static void main(String[] args){
		//字符串类型的变量基本使用
		//数据类型 变量名称 = 数据值
		String  str1 = "Hello";
		System.out.println(str1);//Hello
		
		System.out.println("Hello" + "World");//HelloWorld
		
		String str2 = "java";
		//String + int --> String
		System.out.println(str2 + 20);//Java20
		
		//优先级问题
		//String + int + int
		//String       + int
		//String
		System.out.println(str2 + 20 + 30); //Java2030
		
		System.out.println(str2 + (20 + 30)); //Java50
		
	}
}