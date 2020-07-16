package gui;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.KeyStroke;

import control.Operator;
import model.Book;
import model.ReturnResult;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;  
public class AddBookFrame extends JFrame {
	private JTextField bookAuthorField;  
	private JTextField bookPriceField;
	private JTextField bookNameField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
  
    public AddBookFrame() {  

        super("添加图书");  
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
        JLabel lblNewLabel = new JLabel("书名");
        lblNewLabel.setForeground(new Color(102, 153, 102));
        lblNewLabel.setBounds(164, 87, 130, 48);
        getContentPane().add(lblNewLabel);
        lblNewLabel.setFont(f);
        
        JLabel lblNewLabel_1 = new JLabel("作者");
        lblNewLabel_1.setForeground(new Color(102, 153, 102));
        lblNewLabel_1.setBounds(164, 215, 130, 48);
        getContentPane().add(lblNewLabel_1);
        lblNewLabel_1.setFont(f);
        
        JLabel lblNewLabel_2 = new JLabel("价格");
        lblNewLabel_2.setForeground(new Color(102, 153, 102));
        lblNewLabel_2.setBounds(164, 334, 130, 48);
        getContentPane().add(lblNewLabel_2);
        lblNewLabel_2.setFont(f);
        
        bookAuthorField = new JTextField();
        bookAuthorField.setBounds(367, 221, 148, 36);
        bookAuthorField.setFont(a);
        getContentPane().add(bookAuthorField);
        bookAuthorField.setColumns(10);
        
        bookPriceField = new JTextField();
        bookPriceField.setBounds(367, 340 ,148, 36);
        bookPriceField.setFont(a);
        getContentPane().add(bookPriceField);
        bookPriceField.setColumns(10);
        
        bookNameField = new JTextField();
        bookNameField.setBounds(367, 93, 148, 36);
        bookNameField.setFont(a);
        getContentPane().add(bookNameField);
        bookNameField.setColumns(10);
        
        btnNewButton = new JButton("确定");
        btnNewButton.setBackground(SystemColor.info);
        btnNewButton.setForeground(new Color(102, 153, 102));
        AbstractAction add=new AbstractAction() {
        	@Override
            public void actionPerformed(ActionEvent e) {
				String bookName=bookNameField.getText();
				String bookAuthor =bookAuthorField.getText();
				double bookPrice =Double.parseDouble(bookPriceField.getText());
				//把界面中得到的三个数据放在Book里
				Book book=new Book(bookName,bookAuthor,bookPrice);
				Operator o =new Operator();
				//把Book传给Operator操作
				ReturnResult rr=o.addBook(book);
				if(rr.isSuccess){
					JOptionPane.showMessageDialog(null, "添加成功");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "添加失败");
				}
        	}
        };
        btnNewButton.addActionListener(add);
		InputMap imap = ((JComponent) getContentPane()).getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);  
		imap.put(KeyStroke.getKeyStroke("ENTER"), "okbutton");  
		ActionMap amap = ((JComponent) getContentPane()).getActionMap();  
		amap.put("okbutton", add);
        btnNewButton.setBounds(604, 457, 113, 48);
        btnNewButton.setFont(a);
        getContentPane().add(btnNewButton);
        
        btnNewButton_1 = new JButton("返回");
        btnNewButton_1.setBackground(SystemColor.info);
        btnNewButton_1.setForeground(new Color(102, 153, 102));
        btnNewButton_1.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
				MainClassFrame mainClassFrame=new MainClassFrame();
				mainClassFrame.setVisible(true);
				AddBookFrame.this.dispose();
        	}
        });
        btnNewButton_1.setBounds(817, 457, 113, 48);
        btnNewButton_1.setFont(a);
        getContentPane().add(btnNewButton_1);
        imagePanel.setOpaque(false);  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  
    public static void main(String[] args) {  
        new AddBookFrame();  
    }  
}  