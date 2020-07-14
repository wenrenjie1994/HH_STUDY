
public class HelloWorld {
	public static void main(String[] args) {
		for (int a = 0; a <= 8; ++a)
			for (int b = 0; b <= 8; ++b) 
				for (int c = 0; c <= 14; ++c) 
					for (int d = 0; d <= 10; ++d) 
						if (a + b == 8 && c - d == 6 && a + c == 14 && b + d == 10) 
							System.out.println(a + " " + b + "\n" + c +" " + d);
	}
}