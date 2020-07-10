package com.pan.exer;

//测试和编写的类放在一起，只有测试的类才能写public

/*
 * 对象数组题目： 
 * 
 * 1.定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩 score(int)。
 * 2.创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
 * 3.问题一：打印出3年级(state值为3）的学生信息。
 * 4.问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
 * 
 * 此代码是对StudentTest.java的优化，将操作数组的功能封装到方法中。
 */

public class StudentTest1 {
	public static void main(String[] args) {
		
		//2.创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
		
		//一个个赋值要赋值20次，所以要定义一个Student类型的数组(对象数组，类似String )
		Student1[] stus = new Student1[20];
		
		for (int i=0; i< stus.length; i++) {
			//数组内部每个位置都new一个对象，每个对象都有三个属性
			//给数组元素赋值
			stus[i] = new Student1();
			//给student对象的属性赋值
			stus[i].number = i+1;
			//[1,6]
			stus[i].state = (int)(Math.random()*(6 - 1 + 1)+1);
			//[0,100]
			stus[i].score = (int)(Math.random()*(100-0+1));
		}
		StudentTest1 test = new StudentTest1();
		
		//3.问题一：打印出3年级(state值为3）的学生信息。
		//先遍历所有学生的信息
		test.print(stus);		
		System.out.println("-------------------------------------");
		
		//找出年级为3的学生信息打印出来
		test.searchState(stus, 3);;
		System.out.println("-------------------------------------");
		
		//4.问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
		test.sort(stus);
		//遍历学生信息
		test.print(stus);	
	}
	
	/**
	 * 
	 * Description 遍历所有学生的信息
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年2月10日下午10:03:55
	 * @param stus：要打印的数组
	 */
	public void print(Student1[] stus) {
				for (int i = 0; i< stus.length;i++) {
					System.out.println(stus[i].info());
				}
	}
	/**
	 * 
	 * Description 查找数组中指定年级的学生
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年2月10日下午10:16:22
	 * @param stus：要查找的数组
	 * @param state：要查找的年级
	 */
	public void searchState(Student1[] stus, int state) {
		for (int i = 0; i< stus.length;i++) {
			if (stus[i].state == state) {
				System.out.println(stus[i].info() );
			}
		}
	}
	
	/**
	 * 
	 * Description 对数组进行冒泡排序
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年2月10日下午10:16:13
	 * @param stus：要排序的数组
	 */
	public void sort(Student1[] stus) {
		for(int i =0; i < stus.length - 1; i++) {
			for (int j = 0 ; j < stus.length -1 - i; j++) {
				if (stus[j].score < stus[j+1].score) {
					//如果需要换序，交换的是数组的元素：Student对象！！
					Student1 temp = stus[j];
					stus[j] = stus[j+1];
					stus[j+1] = temp; 
					
				}
			}
		}
	}

}


// 1.定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩 score(int)。
class Student1{
	int number;
	int state;
	int score;
	
	//显示学生信息的方法
	public String info() {
		return "学号为：" + number + "," + "年级为：" + state + "成绩为：" + score;
	}
	
//	public void swop (Student1 m, Student1 n) {
//		Student1 temp;
//		temp = m;
//		m = n;
//		n = temp;
//	}
}
