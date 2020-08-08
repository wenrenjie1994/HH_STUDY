package highLevel.Extends;

public class Phone {
	public Phone() {
		System.out.println("父类无参构造方法！");
	}
	
	public Phone(int num) {
		System.out.println("父类有参构造方法！");
	}
	
	public void call() {
		System.out.println("打电话。。。。");
	}
	
	public void show() {
		System.out.println("显示号码！");
	}
}
