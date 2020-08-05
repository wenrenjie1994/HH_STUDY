package highLevel;

import java.util.ArrayList;
import java.util.Random;

/*
题目：用一个大集合存入20个1-100之间的随机数字，然后筛选其中的偶数元素，放到小集合中
要求使用自定义的方法来实现筛选

思路：
	1、需要创建一个集合用来存储数字<Integer>
	2、随机数字用Random
	3、for循环20次把随机数字放到大集合
	4、自定义方法，用来筛选偶数元素，返回一个小集合
 */
public class API03ArrayListPractice2 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random ran = new Random();
		
		//添加20个随机数字到大集合
		for (int i = 0; i < 20; i++) {
			int num = ran.nextInt(100) + 1;
			list.add(num);
		}
		System.out.println("大集合是：" + list);
		
		//输出筛选的小集合
		ArrayList<Integer> list2 = select(list);
		System.out.println("筛选出的小集合是：" + list2);

	}
	
	//该方法接受大集合参数，筛选偶数，返回小集合结果
	public static ArrayList<Integer> select(ArrayList<Integer> list) {
		//创建小集合
		ArrayList<Integer> smallList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			int num2 = list.get(i);
			if(num2 % 2 == 0) {
				smallList.add(num2);
			}
		}
		return smallList;
	}

}
