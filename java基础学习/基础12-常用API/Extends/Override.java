package highLevel.Extends;
/*
重写（Override）：在继承关系当中，方法的名称一样，参数列表也一样
重载（Overload）：方法的名称一样，参数列表不一样

方法的重写的特点：创建的是子类对象，则优先使用子类方法
方法的重写的注意事项：
	1、必须保证父子类之间的方法名称相同，参数列表也相同
	2、子类方法的返回值必须小于等于父类方法的返回值范围
		java.lang.Object类是所有类的公共最高父类，java.lang.String就是Object的子类
 	3、子类方法的权限修饰符必须大于等于父类方法的权限修饰符
 		public > protected > (default) > private [(default)不是关键字default，而是什么都不写，留空，如 int num;]

继承关系中，父子类构造方法的访问特点：
	1、子类构造方法当中有一个默认的“super()”调用，所以先调用父类构造，再调用子类构造
	2、子类构造可以通过super关键字来调用父类的重载构造方法
	3、super的父类构造方法调用，必须是子类构造方法的第一个语句，即子类构造方法不能调用多次super构造
  总结：子类必须调用父类的构造方法，不写则默认调用super()；写了则用指定的super()调用，且只能是第一个

super关键字的用法有三种：
	1、在子类的成员方法中，访问父类的成员变量
	2、在子类的成员方法中，访问父类的成员方法
	3、在子类的构造方法中，访问父类的构造方法
 */
public class Override {

	public static void main(String[] args) {
		
		Phone phone = new Phone();
		phone.call();
		phone.show();
		System.out.println("===========");
		
		NewPhone newPhone = new NewPhone();//先调用父类构造方法，再调用子类构造方法
		newPhone.call();
		newPhone.show();
	}

}
