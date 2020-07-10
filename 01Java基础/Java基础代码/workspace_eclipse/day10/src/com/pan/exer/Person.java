package com.pan.exer;
/*
 * 创建程序,在其中定义两个类：Person和PersonTest类。
 * 定义如下： 用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄。 
 * 在PersonTest类中实例化Person类的对象b， 调用setAge()和 getAge()方法，体会Java的封装性。 
 * 
 */
public class Person {
	private int age;
	
	public void setAge(int l) {
		if (l>=0 && l<=130) {
			age=l;
		}
		else {
			age=0;
		}
	}
	
	public int getAge() {
		return age;
	}

}
