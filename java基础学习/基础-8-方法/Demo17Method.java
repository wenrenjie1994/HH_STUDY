package practice;
/*
复习方法入门：
	定义格式：
	public static void 方法名称（）{
		方法体
	}
	调用格式：
	方法名称();
注意事项：
	1、方法定义的先后顺序无所谓
	2、方法定义必须是挨着的，不能在一个方法内部定义另外一个方法
	3、方法定义之后，自己不会执行，如果希望执行一定要进行方法的调用
	4、方法有返回值，必须写上return 返回值
	5、return后面的返回值类型必须与方法的返回值类型一致
	
 */
public class Demo17Method {

	public static void main(String[] args) {
		//在main函数中调用print方法
		print();

	}
	
	//新建方法print()实现打印输出矩形功能
	public static void print() {
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<20; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
