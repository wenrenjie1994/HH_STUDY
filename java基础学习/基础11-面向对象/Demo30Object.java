package practice;

import java.util.Arrays;

/*
面向过程：当需要实现一个对象的时候，每一个具体的步骤都要亲力亲为，详细处理每个细节
面向对象：当需要实现一个功能时，不关心具体步骤，而是找一个已经具有该功能的人。
 */
public class Demo30Object {

	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 50};
		
		//要求打印格式为：[10,,20,30,40,50]
		//使用面向过程的思想,，每一个步骤都要亲力亲为
		System.out.print("[");
		for(int i = 0; i < array.length; i++) {
			if(i == array.length - 1) {
				System.out.println(array[i] + "]");
			}else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.println("==========");
		
		//使用面向对象
		//找一个jdk给我们提供好的Arrays类，其中有一个toString方法
		System.out.println(Arrays.toString(array));

	}

}
