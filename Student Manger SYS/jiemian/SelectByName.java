package jiemian;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ywcl.LoginManager;

public class SelectByName extends JFrame implements ActionListener {
	private JTextField textName;
	private JButton ok;

	public SelectByName() {
		super("名称查询界面");
		this.setLayout(new FlowLayout());
		JLabel labelName = new JLabel("用户名：", JLabel.CENTER);
		textName = new JTextField(15);
		add(labelName);
		add(textName);
		ok = new JButton("查询");
		add(ok);
		ok.addActionListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(250, 140);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			// 显示查询结果界面
			String name = textName.getText();
			if (LoginManager.login2(name)){
			new Student(textName.getText());
			}else {
				JOptionPane.showMessageDialog(null, "您所查找的学生不存在！");
			}
		}
	}

	public static void mian(String args[]) {
		SelectByName frame = new SelectByName();
	}
}
