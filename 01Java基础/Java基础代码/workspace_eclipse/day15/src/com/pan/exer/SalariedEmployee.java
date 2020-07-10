package com.pan.exer;

public class SalariedEmployee extends Employee {
	private int monthlySalary;


	public SalariedEmployee(String name, int number, MyDate birthday, int monthlySalary) {
		super(name, monthlySalary, birthday);
		this.monthlySalary = monthlySalary;
	}

	
	
	public int getMonthlySalary() {
		return monthlySalary;
	}



	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}



	public void earnings() {
		System.out.println("月工资为:" + monthlySalary);
	}

	@Override
	public String toString() {
		return "SalariedEmployee [" + super.toString() + "]";
	}

}
