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
		
		/*
		Adder adder = new Adder();
		adder.add(5).inc();
		System.out.printf("sum = %d",adder.value());
		*/
		
		/*
		int i = 10;
		Integer n = new Integer(i);
		Integer n2 = Integer.valueOf(i);
		Integer n3 = Integer.valueOf("10");
		System.out.printf("n = %d\nn2 = %d\nn3 = %d",n,n2,n3);
		*/
		
		/*
		// 向上转型为Number:
		Number num = new Integer(999);
		// 获取byte, int, long, float, double:
		byte b = num.byteValue();
		int n = num.intValue();
		long ln = num.longValue();
		float f = num.floatValue();
		double d = num.doubleValue();
		System.out.println(b);
		System.out.println(n);
		System.out.println(ln);
		System.out.println(f);
		System.out.println(d);*/
		
		/*
		Weekday day = Weekday.TUE;
		Weekday day2 = Weekday.THU;
		System.out.println(day.getDayvalue());
		System.out.println(day2.getDayvalue());
		System.out.println(day.getChinese());
		System.out.println(day.name());
		System.out.println(day.equals(day2));
		System.out.println(day.ordinal());
		System.out.println(day2.ordinal());
		*/
		return;
	
	}
}


enum Weekday{
	MON(0, "星期一"), TUE(1, "星期二"), WED(2, "星期三"), 
	THU(3, "星期四"), FRI(4, "星期五"), SAT(5, "星期六"), 
	SUN(6, "星期日");
	private final int dayvalue;
	private final String chinese;
	
	private Weekday(int dayvalue,String chinese) {
		this.dayvalue = dayvalue;
		this.chinese = chinese;
	}
	public int getDayvalue() {
		return dayvalue;
	}
	public String getChinese() {
		return chinese;
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
//JavaBean
class Person {
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String name;
    private int age;
}

