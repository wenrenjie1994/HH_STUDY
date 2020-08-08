package highLevel.Extends;
/*
在继承关系中，“子类就是一个父类”，也就是说，子类可以被当做父类看待
例如父类是员工，子类是讲师，那么“讲师就是一个员工”。关系：is-a

定义父类的格式：（一个普通的类定义）
public class 父类名称 {
	//....
}

定义子类格式：
public class 子类名称 extends 父类名称 {
	//...
}

在父子类的继承关系中。如果父类和子类的成员变量重名，则创建子类对象时，访问成员变量有两种方式：
	1、直接通过子类对象访问成员变量：等号左边是谁，就优先访问谁，没有则向上找
	2、间接通过成员方法访问成员变量：该方法属于谁，就优先访问谁，没有则向上找

区分子类方法中的三种重名：子类方法中的局部变量、子类的成员变量、父类的成员变量
	子类方法中的局部变量：    直接写局部变量
	本类中的成员变量：            this.成员变量名
	父类中的成员变量：            super.成员变量名     

在父子类的继承关系当中，创建子类对象，访问父子类中重名的成员方法的规则：
	创建的对象是谁，则优先用谁，没有则向上找
 */
public class Extends01 {

	public static void main(String[] args) {
		// 创建一个子类老师对象
		Teacher teacher1 = new Teacher();
		//Teacher当中什么都没有，但是会继承来自父类的method方法
		teacher1.method();
		
		//创建父类对象Employee
		Employee  employee = new Employee();
		System.out.println(employee.age);//只能使用父类的成员变量，没有子类的任何内容
		
		//创建子类对象Teacher2
		Teacher teacher2 = new Teacher();
		System.out.println(teacher2.sex);//子类的成员变量
	
		//子类和父类都有age这个成员变量，这里优先输出子类
		System.out.println(teacher2.age);
		teacher2.methodTeacher();
		
		//子类对象调用父子类重名的成员方法：创建的是new了子类对象，所以优先使用子类方法
		teacher2.same();
	}

}
