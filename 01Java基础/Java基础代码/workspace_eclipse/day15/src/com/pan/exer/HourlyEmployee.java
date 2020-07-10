package com.pan.exer;

public class HourlyEmployee extends Employee {
	private int wage;
	private int hour;



	public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
		super(name, hour, birthday);
		this.wage = wage;
		this.hour = hour;
	}

	public void earnings() {
		System.out.println("小时工资为:" + wage * hour);
	}

	@Override
	public String toString() {
		return "HourlyEmployee [" + super.toString() + "]";
	}

}
