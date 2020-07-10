package com.pan.java;

public class valueTransferTest {
	public static void main(String[] args) {
		int m=10;
		int n=20;
		System.out.println("m="+m+",n="+n);
		
		valueTransferTest test = new valueTransferTest();
		test.swap(m, n);
		
		System.out.println("m="+m+",n="+n);
		
	}
	
	public void swap(int m,int n) {
		int temp=m;
		m=n;
		n=temp;
		System.out.println("m="+m+",n="+n);
	}
	

}
