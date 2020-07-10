public class CoreClass{
	public static void main(String[] args) {
		ClassString();
	}
	//String
	static void ClassString(){
		/*
		String s ="Hello";
		System.out.println(s);
		s = s.toUpperCase();
		System.out.println(s);
		*/
		
		/*
		String s1 = "hello";
		String s2 = "HELLO".toLowerCase();
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		*/
		
		/*
		String s1 = "\tHello\r\n";
		System.out.println(s1);
		s1 =s1.trim();
		System.out.println(s1);
		*/
		
		/*
		StringBuilder sb = new StringBuilder(1024);
		sb.append("hello").append(" ").append("world").append("!");
		System.out.println(sb);
		*/
		
		Adder adder = new Adder();
		adder.add(5).inc();
		System.out.printf("sum = %d",adder.value());
		
		return;
	
	}
}
class Adder{
	private int sum = 0;
	
	public Adder add(int n) {
		sum += n;
		return this;
	}
	
	public Adder inc() {
		sum++;
		return this;
	}
	
    public int value() {
        return sum;
    }

}

