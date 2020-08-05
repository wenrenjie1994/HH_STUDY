package highLevel;

import java.util.ArrayList;
import java.util.Random;

public class API03ArrayListPractice {

	public static void main(String[] args) {
		/*
		题目一：生成6个1-33之间的随机整数，添加到集合，并遍历集合
		思路：
			1、需要存储6个数字，用集合<Integer>
			2、产生随机数，用Random
			3、for循环6次，产生6个随机数[循环内调用r.nextint(int n)，参数是33，范围是0-32，整体+1，范围才是1-33]
			4、每循环一次就添加一次到集合
			5、遍历集合
		 */
		ArrayList<Integer> list1 = new ArrayList<>();
		Random ran = new Random();
		
		//创建随机数并添加到集合
		for(int i = 0; i < 6; i++) {
			int num = ran.nextInt(33) + 1;
			list1.add(num);
		}
		
		//遍历整个集合
		for(int j = 0; j < list1.size(); j++) {
			System.out.println(list1.get(j));
		}
		System.out.println("==============");
		
		/*
		题目一：定义以指定格式打印集合的方法（ArrayList类型作为参数），使用{}扩起集合，使用@分隔每个元素
		格式参照：{元素@元素@元素}
		 */
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("zhangsna");
		list2.add("lisi");
		list2.add("wangmazi");
		
		printArrayList(list2);

	}
	//按题目格式打印的方法
	public static void printArrayList(ArrayList<String> list) {
		System.out.print("{");
		for(int i = 0 ; i < list.size(); i++) {
			String name = list.get(i);
			if(i == list.size()-1) {
				System.out.println(name + "}");
			}else {
				System.out.print(name + "@");
			}
		}
   }

}
