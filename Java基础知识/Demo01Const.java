/*
常量：在程序运行期间，固定不变的量
常量的分类：
1.字符串常量：凡是用双引号引起的部分，叫做字符串常量，例如"abc","123"
2.整数常量：直接写上的数字，没有小数点。 例如：100、200、0、-250
3.浮点数常量：直接写上的数字，有小数点。例如：2.5、-3.14、0.0
4.字符常量：凡是用单引号引起来的单个字符，例如'A'、'z'、'b'、'中'
5.布尔常量，true、false
6.空常量：null，代表没有任何数据。
*/
public class Demo01Const{
	public static void main(String[] args)
	{
		System.out.println("ABC");
		System.out.println("");//字符串两个引号中间对的内容为空
		System.out.println("xyz");
		
		//整数常量
		System.out.println(30);
		System.out.println(-500);
		
		//浮点数常量：直接写上的数字，有小数点。例如：2
		System.out.println(2.5);
		System.out.println(-2.5);
		
		//字符常量
		System.out.println('A');
		System.out.println('6');
		//System.out.println(''); 两个单引号中间必须有一个字符，没有不行
		//System.out.println("AB"); 俩个单引号中间必须有且仅有一个字符，有两个不行
		
		//布尔常量，true、false
		System.out.println(true);
		System.out.println(false);
		
		//空常量不可以直接用来打印输出
	}
}