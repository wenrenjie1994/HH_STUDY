package gui;

import control.Operator;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByResumeProcess extends JFrame {
	private JTextField resumeProcessField;
  
    public SearchByResumeProcess() {  

        super("按进度查找");
        getContentPane().setBackground(new Color(240, 240, 240));
        setSize(1024,623);  
        setLocation(200, 50);  
//        Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("6.png"), new Point(0, 0),"Slef");
//        getContentPane().setCursor(cursor);
        ImageIcon icon=new ImageIcon("11.jpg");
        this.setIconImage(icon.getImage());
        String path = "1.jpg";  
        ImageIcon background = new ImageIcon(path);  
        JLabel label = new JLabel(background);  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        getContentPane().setLayout(null);
        Font f=new Font("宋体",Font.BOLD,30);
        Font a=new Font("宋体",Font.BOLD,20);
        
        JLabel lblNewLabel = new JLabel("输入进度查找");
        lblNewLabel.setForeground(new Color(102, 153, 102));
        lblNewLabel.setBounds(186, 169, 224, 49);
        getContentPane().add(lblNewLabel);
        lblNewLabel.setFont(f);
        
        resumeProcessField = new JTextField();
        resumeProcessField.setBounds(557, 174, 233, 50);
        resumeProcessField.setFont(a);
        getContentPane().add(resumeProcessField);
        resumeProcessField.setColumns(10);
        
        JButton btnNewButton_2 = new JButton("确认");
        btnNewButton_2.setBackground(SystemColor.info);
        btnNewButton_2.setForeground(new Color(102, 153, 102));
        AbstractAction search=new AbstractAction() {
        	@Override
            public void actionPerformed(ActionEvent e) {
				int resumeProcess =Integer.parseInt(resumeProcessField.getText());
				Resume resume = new Resume(null, null);
				resume.setProcess(resumeProcess);

				Operator o =new Operator();
				ReturnResult rr=o.searchByProcess(resume);
				ResumeList resumes=(ResumeList) rr.resultData;//parse的结果转换成bookList放到弹框中显示
				int resumeCount = resumes.size();
				if(resumeCount>0)
				{
					SearchResult rs=new SearchResult(resumes);
					rs.setVisible(true);
				}
				else {
                    JOptionPane.showMessageDialog(null, "没有找到相关学生");
                }
        	}
        };
        btnNewButton_2.addActionListener(search);
		InputMap imap = ((JComponent) getContentPane()).getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);  
		imap.put(KeyStroke.getKeyStroke("ENTER"), "btnNewButton_2");  
		ActionMap amap = ((JComponent) getContentPane()).getActionMap();  
		amap.put("btnNewButton_2", search);
        btnNewButton_2.setBounds(557, 426, 113, 49);
        btnNewButton_2.setFont(a);
        getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("返回");
        btnNewButton_3.setBackground(SystemColor.info);
        btnNewButton_3.setForeground(new Color(102, 153, 102));
        btnNewButton_3.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
				SearchResumeFrame searchResumeFrame =new SearchResumeFrame();
				searchResumeFrame.setVisible(true);
				SearchByResumeProcess.this.dispose();
        	}
        });
        btnNewButton_3.setBounds(736, 426, 113, 49);
        btnNewButton_3.setFont(a);
        getContentPane().add(btnNewButton_3);

        imagePanel.setOpaque(false);  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  
    public static void main(String[] args) {  
        new SearchByResumeProcess();  
    }  
}  