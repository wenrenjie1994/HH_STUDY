
import java.awt.event.*;

import javax.swing.*;

import jiemian.Student;
import jiemian.TeacherMain;
import ywcl.LoginManager;

public class Login extends JFrame implements ActionListener {
	private JTextField textName;
	private JPasswordField textPassword;
	JComboBox cbSF;
	private JTextField textCheck;
	private JButton ok;

	public Login() {
		super("登录");
		JPanel panel = new JPanel();
		
		JLabel lableName = new JLabel("用户名：", JLabel.CENTER);
		textName = new JTextField(15);
		panel.add(lableName);
		panel.add(textName);
		JLabel labelPassword = new JLabel("密码：");
		textPassword = new JPasswordField(15);
		panel.add(labelPassword);
		panel.add(textPassword);
		String[] strSF = { "学生", "教师" };
		cbSF = new JComboBox(strSF);
		panel.add(new JLabel("身份："));
		panel.add(cbSF);
		ok = new JButton("登录");
		panel.add(ok);
		textCheck = new JTextField(20);
		textCheck.setVisible(false);
		panel.add(textCheck);
		getContentPane().add(panel);
		textName.addActionListener(this);
		ok.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			String name = textName.getText();
			String ps = new String(textPassword.getPassword());
			String sf = (String) cbSF.getSelectedItem();
			if ("教师".equals(sf)) {
				if (name.equals("admin") && ps.equals("123456")) {
					new TeacherMain ();
				} else {
					textCheck.setText("用户名与密码不正确，教师登录失败！");
					textCheck.setVisible(true);
					this.setSize(250, 160);
					textName.grabFocus();
				}
			} else if ("学生".equals(sf)) {
				 if (LoginManager.login(name,ps)){
				 new Student (name);
			} else {
				//textCheck.setText("用户名与密码不正确，学生登录失败！");
				JOptionPane.showMessageDialog(null, "用户名与密码不正确，学生登录失败！");
				//textCheck.setVisible(true);
				//this.setSize(250, 160);
				textName.grabFocus();

			}
		}
	  }
	}
	

	public static void main(String[] args) {
		Login frame = new Login();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 140);
		frame.setVisible(true);

	}

}
