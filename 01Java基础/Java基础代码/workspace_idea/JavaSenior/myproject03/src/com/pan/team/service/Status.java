package com.pan.team.service;

public class Status {
	private String name;

	// 1.私有化构造器
	private Status(String name) {
		this.name = name;
	}

	// 2.内部创建类的对象(“三例设计模式”)
	public static Status FERR = new Status("Free");
	public static Status BUSY = new Status("BUSY");
	public static Status VACATION = new Status("VACATION");

	@Override
	public String toString() {
		return name;
	}

}
