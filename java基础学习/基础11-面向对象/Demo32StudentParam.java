package practice;

public class Demo32StudentParam {

	public static void main(String[] args) {
		Student student = new Student();
		student.name = "zhangsan";
		student.age = 24;
		
		method(student);//传递进去的参数是student的地址值
		
		Student student2 = getStudent();//返回Student类型
		System.out.println(student2.name);
		System.out.println(student2.age);
	}
	
	//使用对象作为方法的参数
	//当使用一个对象作为方法的参数时，传递进去的参数实际是对象的地址值
	public static void method(Student stu) {
		System.out.println(stu.name);
		System.out.println(stu.age);
	}
	
	//使用对象作为方法的返回值
	//当使用一个对象类型作为方法的返回值时，返回值其实就是对象的地址值
	public static Student getStudent() {
		Student stu = new Student();
		stu.name = "lisi";
		stu.age = 22;
		return stu; //返回一个对象
	}

}
