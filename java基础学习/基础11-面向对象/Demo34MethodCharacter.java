package practice;
/*
面向对象三大特征：封装、继承、多态

封装性在java中的体现：
	1、方法就是一种封装
	2、关键字private也是一种封装：用private关键字将需要的成员变量进行修饰
		一旦使用private进行修饰，那么本类当中仍可访问，超出本类范围之外就不能再访问
		用private关键字修饰的成员变量，需要使用Getter/Setter方法来对成员变量进行间接访问和使用
 */
public class Demo34MethodCharacter {
	public static void main(String[] args) {
		int[] array = {5, 15, 25, 20, 100};
		int max = getMax(array);
		System.out.println("最大值：" + max);
		
	}
	
	//封装了一个getMax方法，用来实现求出数组最大值的功能
		public static int getMax(int[] array) {
			int max = array[0];
			for(int i = 1; i < array.length; i++) {
				if(array[i] > max) {
					max = array[i];
				}
			}
			return max;
	}
}
