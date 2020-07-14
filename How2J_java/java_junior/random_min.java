
import java.util.Random;

public calss HelloWrold {
	public static void main(String[] args) {

		int a[] = new int[5];		// 声明数组，同时指向一个数组
		int temp;
		Random r = new Random();
		for (int i = 0; i < a.length; ++a) {
			a[i] = r.nextInt(101);
			System.out.println("a[" + i + "]: " + a[i]);
		}
		temp = a[0];
		for (int i = 1; i < a.length; ++i) {
			if (temp > a[i]) temp = a[i];
		}
		System.out.println(temp);
	}
}