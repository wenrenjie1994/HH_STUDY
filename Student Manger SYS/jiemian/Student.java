package jiemian;

import java.awt.*;

import javax.swing.*;

import ywcl.StudentManager;

public class Student extends JFrame {
	public Student(String name) {
		super("学生查看信息界面");
		this.setLayout(new FlowLayout());
		Object[] stu = StudentManager.select(name);
		this.add(new JLabel("姓名："));
		JTextField nameText = new JTextField(name, 15);
		nameText.setEditable(false);
		this.add(nameText);
		this.add(new JLabel("密码："));
		JTextField psText = new JTextField("", 15);
		if (stu[1] != null)
			psText.setText(stu[1].toString());
		psText.setEditable(false);
		this.add(psText);
		this.add(new JLabel("照片"));
		JLabel zpLabel = new JLabel("   ");
		if (stu[2] != null) {
			zpLabel.setText("");
			zpLabel.setIcon(new ImageIcon((byte[]) stu[2]));
		}
		this.add(zpLabel);
		this.add(new JLabel("成绩："));
		JTextField cjText = new JTextField("", 15);
		if (stu[3] != null)
			cjText.setText(stu[3].toString());
		cjText.setEditable(false);
		this.add(cjText);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(250, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Student("lisi");

	}

}
