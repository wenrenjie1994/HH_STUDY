package com.pan.exer;

public class ArrayExer1 {
public static void main(String[] args) {
	//1.定义数组
	int[][] yanghui = new int [10][];
	//2.为数组元素赋值
	for (int i=0; i<yanghui.length; i++) {
		yanghui[i] = new int[i+1];
		//首末值为1
		yanghui[i][0]=1;
		yanghui[i][i]=1;
//		if (i>=2) {
			for (int j=1; j<yanghui[i].length-1; j++) {
				yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
//			}
		}
	}
//	yanghui[0][0] = 1;
//	yanghui[1][0] = 1;
//	yanghui[1][1] = 1;
//	System.out.println(yanghui[0][0]);
//	System.out.println(yanghui[1][0] + ' ' + yanghui[1][1]);
//	for (int i=1; i<9; i++) {
//		for (int j=1; j<i ; j++) {
//		yanghui[i][0] = 1;
//		yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][i];
//		yanghui[i][i] = 1;
//		System.out.println(yanghui[i][j] + ' ');
	
	//3.遍历数组
	for (int i=0; i<yanghui.length; i++) {
		for (int j=0; j<yanghui[i].length; j++) {
			System.out.print(yanghui[i][j]+ " ");
		}
		System.out.println();
	}
}
}
