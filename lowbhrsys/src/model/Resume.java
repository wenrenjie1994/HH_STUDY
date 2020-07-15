/**
 * A program for 文本读写---简历管理系统
 * @version 2.0 2020-07-15
 * @author 王科文
 */
package model;

public class Resume {
	
	public String studentName;
	
	public int studnetID;
	
	public String studentSchool;



	public int process;


	public Resume(String studentName, int studnetID, String studentSchool, int process) {
		this.studentName = studentName;
		this.studnetID = studnetID;
		this.studentSchool = studentSchool;
		this.process = process;
	}
}
