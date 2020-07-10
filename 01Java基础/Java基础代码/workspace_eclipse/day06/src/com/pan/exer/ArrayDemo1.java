package com.pan.exer;

import java.util.Scanner;


/*
 * 2. 从键盘读入学生成绩，找出最高分， 并输出学生成绩等级。 
 * 成绩>=最高分-10    等级为’A’   
 * 成绩>=最高分-20    等级为’B’ 
 * 成绩>=最高分-30    等级为’C’   
 * 其余 等级为’D’
 */

public class ArrayDemo1 {
public static void main(String[] args) {
	//1.使用scanner读入学生人数
	Scanner scanner = new Scanner(System.in);
	System.out.print("请输入学生人数:");
	int number = scanner.nextInt();
	System.out.println("请输入" + number + "个成绩：");
	
	//2.根据学生人数创建数组，存储数据，动态初始化
	int[] scores = new int[number];
	
	//3.给数组元素赋值；
	for(int i=0; i<scores.length; i++) {
		scores[i]= scanner.nextInt();
	}
	
	//4.获取数组元素的最大值
	int maxscore = 0;
	for(int i=0; i<scores.length; i++) {
		if (scores[i] > maxscore)
			maxscore = scores[i];
	}
	System.out.println("最高分是：" + maxscore);
	
	//5.根据每个学生和最高分的差值，计算等级并输出
	char grade = ' ';
	for(int i=0; i<scores.length; i++) {
		if ( maxscore - scores[i] >= 10) {
			grade = 'A';
		}
		else if ( maxscore - scores[i] >= 20){
			grade = 'B';
		}
		else if ( maxscore - scores[i] >= 30){
			grade = 'C';
		}
		else {
			grade = 'D';
		}
		System.out.println("student " + i + " score is " + scores[i] + ", grade is " + grade);
	}
	
}
}
