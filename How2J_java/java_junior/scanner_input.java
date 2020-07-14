import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int a = s.nextInt();		// 整数
		System.Out.println(a);

		float a = s.nextFloat();	// 浮点数
		System.out.println(a);

		String a = s.nextLine();	// 字符串
		System.out.println(a);

		int i = s.nextInt();		// 整数后加字符串
		System.out.println(i);
		String rn = s.nextLine();		// 读取换行符
		String a = s.nextLine();
		System.out.println(a);
		s.close();		// 避免浪费系统资源
	}
}