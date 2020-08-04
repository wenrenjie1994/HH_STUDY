package highLevel;

import java.util.Scanner;

import practice.Person;

/*
创建对象的标准格式：
	类名称 对象名 = new 类名称();
	
匿名对象：只有右边的对象，没有左边的名字和赋值运算符
	new 类名称();
注意事项：匿名对象只能使用唯一的一次，下次再用必须再创建一个新对象
使用建议：如果确定有一个对象只需要使用唯一的一次，就可以用匿名对象
 */
public class Anonymous {

	public static void main(String[] args) {
		//一般类的使用
		Person  per = new Person();
		per.setAge(12);
		System.out.println(per.getAge()); //12
		
		//匿名对象
		new Person().setAge(24);
		System.out.println(new Person().getAge()); //0，因为这是新创建的一个对象，初始年龄为0
		
/*如果只想从键盘输入一个数字，要求使用普通对象和匿名对象的方式完成*/
		//普通使用方式
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		
		//匿名对象方式
		int num2 = new Scanner(System.in).nextInt();

/*如果想使用类作为方法传递的参数，要求使用一般写法和匿名对象完成*/
		//一般传参方法
		Scanner ex1 = new Scanner(System.in);
		methodParam(ex1);
		
		//匿名对象作为方法参数
		methodParam(new Scanner(System.in));
	}
	
	public static void methodParam(Scanner sc) {
		int a = sc.nextInt();
		System.out.println("输入的是：" + a);
	}
//同理，匿名对象也可作为方法的返回值使用
}
