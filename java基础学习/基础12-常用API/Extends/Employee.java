package highLevel.Extends;
//创建一个员工类
public class Employee {
	int age = 30;
	
	public  void method() {
		System.out.println("父类方法执行！");
	}
	
	public void same() {
		System.out.println("父类重名方法执行！");
	}
}
