package highLevel;

import java.util.ArrayList;

/*
数组长度不可以发生改变，但ArrayList集合的长度是可以随意变化的

对于ArrayList来说，有一个尖括号<E>代表泛型
泛型：装在集合中的所有元素，全都是统一的什么类型
注意：泛型只能是引用类型，不能是基本类型

注意事项：
	对于ArrayList集合来说，直接打印得到的不是地址值，而是内容
	如果内容是空，得到的是空的中括号：[]
	
ArrayList常用方法：
	1、public boolean add(E e):向集合中添加元素，参数的类型和泛型一致
	2、public E get(int index):从集合中获取元素，参数是索引编号，返回值是对应位置的元素
	3、public E remove(int index):从集合中删除元素，参数是索引编号，返回值是被删除掉的元素
	4、public int size():获取集合的尺寸长度，返回值是集合中包含的元素个数
 */
public class API03ArrayList {

	public static void main(String[] args) {
		//创建了一个ArrayList集合，集合的名称是List，里面装的都是String类型的数据
		//备注：从JDK1.7+开始，右侧尖括号里的内容可以不写，但尖括号<>不可以省略
		ArrayList<String> list = new ArrayList<>();
		System.out.println(list);//[]
		
		//向集合中添加数据，使用add方法
		Boolean success = list.add("zhangsan");
		System.out.println(list);//zhangsan
		System.out.println("是否添加成功：" + success);//true

		list.add("lisi");
		list.add("wangmazi");
		
		//从集合中获取元素：get，索引值从0开始
		String  name = list.get(2);
		System.out.println("2号索引元素：" + name);
		
		//从集合中删除元素：remove，索引值从0开始
		String whoRemoved = list.remove(1);
		System.out.println("被删除的元素是：" + whoRemoved);
		
		//获取集合的长度，即集合中的元素个数
		int size = list.size();
		System.out.println("集合中的元素个数:" + size);
		
		//遍历集合
		for(int i = 0;i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
