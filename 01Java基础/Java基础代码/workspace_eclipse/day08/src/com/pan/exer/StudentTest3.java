package com.pan.exer;

//一定要看对应的括号！！！


//定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩 score(int)。 
//创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
//问题一：打印出3年级(state值为3）的学生信息。 
//问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息

public class StudentTest3 {
	public static void main(String[] args) {
		//申明Student类型的数组
			Student3[] stu = new Student3[20];//对象数组
			for (int i=0;i<stu.length;i++) {
			//给每个位置new一个对象，相当于给数组元素赋值
			stu[i]=new Student3();
			//给对象的属性赋值
			stu[i].number=i+1;
			stu[i].score=(int)(0+Math.random()*(100-0+1));
			stu[i].state=(int)(1+Math.random()*(6-1+1));
			
			//方法一：赋值的时候就打印，不用方法
//			if (stu[i].state==3)
//			{
//				System.out.println(stu[i].state+"学号为："+stu[i].number+";"+"成绩为："+stu[i].score+";");
//			}
		}
			//方法二：最后再遍历，用方法
			for (int j=0;j<stu.length;j++) {
				if (stu[j].state==3) {
					stu[j].showInfo();
				}
			}
			
			System.out.println("**************");
			
			//***************************
			System.out.println("*******排序前*******");
			for (int j=0;j<stu.length;j++) {
					stu[j].showInfo();
			}
			
			
			for(int i=0;i<stu.length;i++) {
				for(int j=0;j<stu.length-1-i;j++) {
					if (stu[j].score>stu[j+1].score) {
						Student3 temp3=stu[j];
						stu[j]=stu[j+1];
						stu[j+1]=temp3;
					}
				}
			}
				System.out.println("*******排序后*******");

				for (int j=0;j<stu.length;j++) {
					stu[j].showInfo();
			}
				
		}//main的括号
}//类的括号




class Student3{
	int number;
	int state;
	int score;
	
	public void showInfo() {
		System.out.println("年级为："+state+";"+"学号为："+number+";"+"成绩为："+score+"。");
	}
	
}
