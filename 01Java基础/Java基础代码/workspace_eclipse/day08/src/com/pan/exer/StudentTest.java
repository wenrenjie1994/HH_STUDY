package com.pan.exer;

//测试和编写的类放在一起，只有测试的类才能写public

/*
 * 对象数组题目： 
 * 
 * 1.定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩 score(int)。
 * 2.创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
 * 3.问题一：打印出3年级(state值为3）的学生信息。
 * 4.问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
 */

public class StudentTest {
	public static void main(String[] args) {
		
		//2.创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
		
//		Student s1 = new Student();
//		Student s1 = new Student();
		//一个个赋值要赋值20次，所以要定义一个Student类型的数组(对象数组，类似String )
		Student[] stus = new Student[20];
		
//		
		for (int i=0; i< stus.length; i++) {
			//数组内部每个位置都new一个对象，每个对象都有三个属性
			//给数组元素赋值
			stus[i] = new Student();
			//给student对象的属性赋值
			stus[i].number = i+1;
			//[1,6]
			stus[i].state = (int)(Math.random()*(6 - 1 + 1)+1);
			//[0,100]
			stus[i].score = (int)(Math.random()*(100-0+1));
		}
//		
		//3.问题一：打印出3年级(state值为3）的学生信息。
		//先遍历所有学生的信息
		for (int i = 0; i< stus.length;i++) {
			System.out.println(stus[i].info());
		}
		System.out.println("-------------------------------------");
		//找出年级为3的学生信息打印出来
		for (int i = 0; i< stus.length;i++) {
			if (stus[i].state == 3) {
				System.out.println(stus[i].info() );
			}
		}
		System.out.println("-------------------------------------");
		//4.问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
		StudentTest test = new StudentTest();
		
		for(int i =0; i < stus.length - 1; i++) {
			for (int j = 0 ; j < stus.length -1 - i; j++) {
				if (stus[j].score < stus[j+1].score) {
					//如果需要换序，交换的是数组的元素：Student对象！！
//					Student temp = stus[j];
//					stus[j] = stus[j+1];
//					stus[j+1] = temp; 
					test.swop(stus[j],stus[j+1]);
							
				}
			}
		}
		
		for (int i = 0; i< stus.length;i++) {
			System.out.println(stus[i].info());
		}
		
	}

	public void swop (Student m, Student n) {
		Student temp;
		temp = m;
		m = n;
		n = temp;
	}

}


// 1.定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩 score(int)。
class Student{
	int number;
	int state;
	int score;
	
	//显示学生信息的方法
	public String info() {
		return "学号为：" + number + "," + "年级为：" + state + "成绩为：" + score;
	}
	
	
}
