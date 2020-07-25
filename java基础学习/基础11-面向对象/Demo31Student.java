package practice;
/*
定义一个类，用来模拟“学生”：
	属性（是什么）：
		姓名
		年龄
	行为（能做什么）：
		吃饭
		睡觉
		学习
对应到java中创建学生类的过程：
	成员变量（属性）：
		String name; //姓名
		int age; //年龄
	成员方法（行为）：
		public void eat() {}; //吃饭
		public void sleep() {}; //睡觉
		public void study() {};	//学习
注意事项：
	1、成员变量是直接定义在类当中的，在方法外边
	2、成员方法不要写static关键字
	3、如果成员变量没有进行赋值，将会有一个默认值
通常情况下，一个类不能直接使用，需要根据类创建一个对象，包括以下步骤：
	1、导包：导入需要创建的类的位置  import 包名称.类名称;（对于和当前类属于同一个包的情况，可以省略导包语句不写）
	2、创建
		格式： 类名称 对象名 = new 类名称();
	3、使用，分为两种情况
		a、使用成员变量：对象名.成员变量名
		b、使用成员方法：对象名.成员方法名()

 */
public class Demo31Student {
	public static void main(String[] args) {
		//1、导包
		//因为使用的Student类和当前类位于同一个包，因此导包语句可以省略不写
		
		//2、创建，格式：
		//类名称 对象名 = new 类名称();
		//根据Student类，创建一个名为stu的对象
		Student stu = new Student();
		
		//3、使用成员变量和成员方法
		//对象名.成员变量
		System.out.println(stu.name);//null
		System.out.println(stu.age);//0
		System.out.println("============");
		
		//改变对象当中的成员变量数值内容
		stu.name = "zhangsan";
		stu.age = 24;
		System.out.println(stu.name);//zhangsan
		System.out.println(stu.age);//24
		
		//对象名.成员方法
		stu.eat();
		stu.sleep();
		stu.study();
	}
}
