package highLevel;
/*
1、如果一个成员变量使用了static关键字，那么这个变量不再属于对象自己，而是属于所在的类，多个对象共享一份数据

2、一旦使用static修饰成员方法，那么这就成为了静态方法，静态方法不属于对象，而是属于类的
 
3、如果没有static关键字的方法，那必须先创建对象，才能用“对象.方法”的形式使用方法
对于静态方法来说，可以通过“对象.方法”的形式进行调用（不推荐），也可以直接通过“类名.方法”的形式调用（推荐）
 
4、无论是成员变量，还是成员方法，如果有了static，都推荐使用类名称进行调用
	静态变量：类名称.静态变量
	静态方法：类名称.静态方法
5、静态代码块格式：
	public class 类名称 {
		static {
			//静态代码块内容
		}
	}
6、静态代码块特点：当第一次使用到本类时，静态代码块执行唯一的（即第一次创建对象时执行唯一的一次，后面创建的对象不再执行）
	静态内容总是优先于非静态，所以静态代码块比构造方法先执行
	静态代码块的典型用途：用来一次性对静态成员变量进行赋值

注意：
	1、对于本类当中的静态方法，可以省略类名称
	2、成员方法可以访问静态变量，静态方法不能访问非静态变量
	3、静态方法中不能使用this，因为this代表当前对象，通过谁调用的方法，谁就是当前对象
 */
public class API05StaticField {

	public static void main(String[] args) {
		//静态变量：类名称.静态变量
		Student.room = "101教室";
		
		Student one = new Student("zhangsan",18);
		System.out.println("姓名：" + one.getName() + ",年龄：" + one.getAge() + ",学号：" + one.getId());

		Student two = new Student("lisi",24);
		System.out.println("姓名：" + two.getName() + ",年龄：" + two.getAge() + ",学号：" + two.getId());

		//对于本类当中的静态方法，可以省略类名称
		staticMethod();
	}
	
	public static void staticMethod() {
		System.out.println("这是一个本类中的静态方法");
	}

}
