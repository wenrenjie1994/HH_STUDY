package highLevel.Extends;

public class Teacher extends Employee {
	int sex = 1;//性别为男
	int age = 20;
	
	public void methodTeacher() {
		System.out.println("子类方法执行！");
		int age = 10;
		System.out.println(age);//10,局部变量
		System.out.println(this.age);//20,本类中的成员变量
		System.out.println(super.age);//30,父类中的成员变量
	}
	
	public void same() {
		System.out.println("子类重名方法执行！");
	}
}
