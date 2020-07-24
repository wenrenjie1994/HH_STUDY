package practice;
/*
使用动态初始化数组时，其中的元素将会自动拥有一个默认值，规则如下：
	如果是整数类型，那么默认为0；
	如果是浮点类型，那么默认为0.0；
	如果是字符类型，那么默认为'\u0000'；
	如果是布尔类型，那么默认为false；
	如果是引用类型，那么默认为null
	
注意事项：
静态初始化也有默认值的过程，只不过系统自动马上将默认值替换成了大括号中的具体数值

 */
public class Demo26ArrayUse2 {

	public static void main(String[] args) {
		//动态初始化一个数组
		int[] array = new int[3];
		
		System.out.println(array);//内存地址
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		
		System.out.println("=========");
		
		//将数据123赋值交给数组array当中的1号元素
		array[0] = 123;
		System.out.println(array[0]);//123
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println("=========");
		
		//将array数组的地址值，赋值给arrayB数组
		int[] arrayB = array;
		System.out.println(arrayB[0]);//123
		System.out.println(arrayB[1]);
		System.out.println(arrayB[2]);
		System.out.println("==========");
		
		arrayB[0] = 666;
		arrayB[1] = 999;
		arrayB[2] = 111;
		//因为arrayB和array是同一个数组，所以arrayB数组里的值修改以后，array数组里的值也会修改
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
	}

}
/*
java的内存划分5个部分：
	1、栈（Stack）：存放的都是方法中的局部变量
		局部变量：方法的参数，或是方法{}内部的变量
		作用域：一旦超出作用域，立刻从栈内存中消失
	2、堆（Heap）：凡是new出来的东西，都在堆当中
		堆内存里面的东西都有一个地址值：16进制
		堆内存里面的数据，都有默认值。规则：
			如果是整数类型，那么默认为0；
			如果是浮点类型，那么默认为0.0；
			如果是字符类型，那么默认为'\u0000'；
			如果是布尔类型，那么默认为false；
			如果是引用类型，那么默认为null
	3、方法区（Method Area）：存储.class相关信息，包含方法的信息
	4、本地方法栈（Native Method Stack）：与操作系统相关
	5、寄存器（Register）：与CPU有关
*/