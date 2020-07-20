package model;
//‘±π§¿‡
public class Staff {
	private int age;
	private String staffId;
	private String name;
	private String sex;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Staff(int age, String staffId, String name, String sex) {
		this.age = age;
		this.staffId = staffId;
		this.name = name;
		this.sex = sex;
	}
	
	
}

