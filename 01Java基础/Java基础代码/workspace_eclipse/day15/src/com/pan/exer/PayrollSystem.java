package com.pan.exer;

public class PayrollSystem {
	public static void main(String[] args) {
		Employee[] emps = new Employee[10];
//		MyDate m1 = new MyDate(2002, 2, 12);
//		MyDate m2 = new MyDate(1992, 4, 13);
		
		emps[0]=new SalariedEmployee("Tom", 18, new MyDate(2002, 2, 12), 2000);
		emps[1]=new HourlyEmployee("Jerry",22,new MyDate(1992, 4, 13),12,20);
		
		for(int i=0;i<2;i++) {
			emps[i].earnings();
//			System.out.println(emps[i].toString());
			System.out.println(emps[i]);
		}
		

		
	}
	}
	
