package practice;
/*
定义一个方法的格式：
	public static void 方法名称() {
		方法体
	}
方法名称的命名规则和变量一样，使用小驼峰

注意事项：
	1.方法定义的先后顺序无所谓
	2.方法的定义不能产生嵌套包含关系
	3.要想执行方法要进行方法的调用

调用方法的格式：方法名称();
 */
public class Demo11Method {
	public static void main(String[] args) {
		//调用厨子的方法
		cook();
	}

	//厨子
	public static void cook() {
		System.out.println("洗菜");
	}
	
	//我
	public static void me() {
		System.out.println("吃");
	}
	
	//商贩
	public static void seller() {
		System.out.println("卖给厨子");
	}

}
