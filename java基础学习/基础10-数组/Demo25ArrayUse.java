package practice;
/*
访问数组元素的格式：数组名称[索引值]
【注意】索引值从0开始，一直到“数组长度-1”为止
 */
public class Demo25ArrayUse {

	public static void main(String[] args) {
		int[] array = { 10, 20, 30 };
		System.out.println(array);//直接打印数组名称得到的是数组对应的：内存地址哈希值
		
		//直接打印数组中的元素
		System.out.println(array[0]);
		
		//将数组元素赋值给某个变量
		int num = array[1];
		System.out.println(num);
	}

}
