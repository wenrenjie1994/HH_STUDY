//使用三元运算符和标准的if-else语句分别实现：取两个数字中的较大值
public class IfTest {
	public static void main(String[] args) {
		int a,b;
		a = 5;
		b = 10;
		if(a >  b) {
			System.out.println("较大值是" + a);
		} else {
			System.out.println("较大值是" + b);
		}
		System.out.println("较大值是" + (a > b ? a : b));
	}
}