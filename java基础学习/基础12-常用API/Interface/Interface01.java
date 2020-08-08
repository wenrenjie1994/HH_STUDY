package highLevel.Interface;
/*
接口是一种引用数据类型

如何定义一个接口的格式：
public interface 接口名称 {
	//接口内容
}

接口使用步骤：
	1、接口不能直接使用，必须有一个“实现类”类实现该接口
		public class 实现类名称  implements 接口名称 {
			//...
	2、接口的实现类必须覆盖重写（）实现接口中的所有抽象方法
	3、创建实现类的对象，进行使用
注意事项：如果实现类并没有覆盖重写接口的所有抽象方法，那么这个实现类自己就必须是抽象类
 
 
接口的静态方法定义格式：
	public static 返回值类型    方法名称(参数列表) {
		方法体
	}
接口的静态方法的使用：通过接口名称，直接调用其中的静态方法
	格式：接口名称.静态方法名(参数);
注意事项：不能通过接口实现类的对象来调用接口的静态方法
 */
public class Interface01 {
	public static void main(String[] args) {
		InterfaceabstractImpl impl = new InterfaceabstractImpl();
		impl.methodAbstr();
		impl.methodAbstr2();
		impl.methodAbstr3();
		impl.methodAbstr4();
	}
}

/*
总结：
	在java 9+版本中，接口的内容可以有，[]代表可以省略不写：
1、成员变量其实是常量，格式：
	[public] [static] [final] 数据类型 常量名称 = 数据值;
	注意：常量必须进行赋值，而且一旦赋值不能改变；常量名称完全大写，用下划线进行分隔
2、接口中最重要的就是抽象方法，格式：
	[public] [abstract] 返回值类型    方法名称(参数列表);
	注意：实现类必须覆盖重写接口所有的抽象方法，除非实现类是抽象类
3、从java 8开始，接口允许定义默认方法，格式：
	[public] defualt 返回值类型   方法名称(参数列表) { 方法体 }
	注意：默认方法也可以被覆盖重写
4、从java 8开始，接口允许定义静态方法，格式：
	[public] static 返回值类型   方法名称(参数列表) {方法体}
	注意：应该通过接口名称进行调用，不能通过实现类对象调用接口静态方法
5、从java 9开始，接口允许定义私有方法，格式：
	普通私有方法：private 返回值类型    方法名称(参数列表) { 方法体}
	静态私有方法：private static  返回值类型    方法名称(参数列表) { 方法体}
	注意：private的方法只有接口自己才能调用，不能被实现类或别人使用
*/
