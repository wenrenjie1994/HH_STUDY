package gui;

import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;

import control.Operator;
import model.Book;
import model.ReturnResult;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;  
public class DeleteBookFrame extends JFrame {
  
    public DeleteBookFrame() {  

        super("删除图书界面");  
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
        Font a=new Font("宋体",Font.BOLD,20);
        
        JButton btnNewButton = new JButton("按书名删除");
        btnNewButton.setForeground(new Color(102, 153, 102));
        btnNewButton.setBackground(SystemColor.info);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				DeleteByBookName deleteByBookName = new DeleteByBookName();
				deleteByBookName.setVisible(true);
				DeleteBookFrame.this.dispose();
        	}
        });
        btnNewButton.setBounds(402, 108, 174, 57);
        btnNewButton.setFont(a);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("按作者名删除");
        btnNewButton_1.setForeground(new Color(102, 153, 102));
        btnNewButton_1.setBackground(SystemColor.info);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				DeleteByBookAuthor deleteByBookAuthor = new DeleteByBookAuthor();
				deleteByBookAuthor.setVisible(true);
				DeleteBookFrame.this.dispose();
        	}
        });
        btnNewButton_1.setBounds(402, 238, 174, 57);
        btnNewButton_1.setFont(a);
        getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("返回");
        btnNewButton_2.setForeground(new Color(102, 153, 102));
        btnNewButton_2.setBackground(SystemColor.info);
        btnNewButton_2.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
				MainClassFrame mainClassFrame=new MainClassFrame();
				mainClassFrame.setVisible(true);
				DeleteBookFrame.this.dispose();
        	}
        });
        btnNewButton_2.setBounds(402, 368, 174, 57);
        btnNewButton_2.setFont(a);
        getContentPane().add(btnNewButton_2);

        imagePanel.setOpaque(false);  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  
    public static void main(String[] args) {  
        new DeleteBookFrame();  
    }  
}  

