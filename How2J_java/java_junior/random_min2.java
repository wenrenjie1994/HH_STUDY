
import java.util.Scanner;

public calss Demo {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		int a[] = new int[length];
		for (int i = 0; i < length; ++i) 
			a[i] = (int)(Math.random() * 100);
		int temp = a[0];
		int id = 0;
		for (int i = 0; i < a.length; ++i) {
			System.out.println(a[i] + " ");
			if (temp > a[i]) { temp = a[i]; id = i; }
		}
		System.out.println("a[" + id + "] = " + temp);
		s.close();
	}
}