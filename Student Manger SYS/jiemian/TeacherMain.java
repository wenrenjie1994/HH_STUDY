package jiemian;

import java.awt.event.*;
import javax.swing.*;

import jiemian.SelectByName;
import ywcl.CJManager;

public class TeacherMain extends JFrame implements ActionListener {
	JMenuBar menubar;
	JMenu stuMenu, searchMenu;
	JMenuItem addStu, searchStu1, searchStu2;
	JMenuItem cjAvg, cjJGL;// 平均成绩，及格率
	JLabel result;

	public TeacherMain() {
		setTitle("教师管理主界面");
		setSize(260, 150);
		setLocation(120, 120);
		setVisible(true);
		menubar = new JMenuBar();
		stuMenu = new JMenu("学生");
		JMenu cjMenu = new JMenu("成绩");
		addStu = new JMenuItem("添加学生");
		searchMenu = new JMenu("查询学生");
		searchStu1 = new JMenuItem("名称查询");
		searchStu2 = new JMenuItem("全部查询");
		searchMenu.add(searchStu1);
		searchMenu.add(searchStu2);
		stuMenu.add(addStu);
		stuMenu.add(searchMenu);
		cjAvg = new JMenuItem("平均成绩");
		cjJGL = new JMenuItem("及格率");
		cjMenu.add(cjAvg);
		cjMenu.add(cjJGL);
		menubar.add(stuMenu);
		menubar.add(cjMenu);
		setJMenuBar(menubar);
		result = new JLabel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(result);
		validate();
		addStu.addActionListener(this);
		searchStu1.addActionListener(this);
		searchStu2.addActionListener(this);
		cjAvg.addActionListener(this);
		cjJGL.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addStu) {
			new AddStudent();
		} else if (e.getSource() == searchStu1) {
			new SelectByName();
		} else if (e.getSource() == searchStu2) {
			new SelectAll();
		} else if (e.getSource() == cjAvg) {
			double avg = 0;
			avg = CJManager.average();
			result.setText("所有学生的平均成绩为：" + avg);
		} else if (e.getSource() == cjJGL) {
			double jgl = 0;
			jgl = CJManager.pass();
			result.setText("所有学生的及格率为：" + jgl);
		}
	}

	public static void main(String[] args) {
		TeacherMain win = new TeacherMain();
	}

}
