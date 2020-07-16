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
    public class ChangeBookFrame extends JFrame {
    	private JTextField oldbookNameField;  
    	private JTextField bookNameField;
    	private JTextField bookAuthorField;
    	private JTextField bookPriceField;
    	private JLabel lblNewLabel_2;
    	private JLabel lblNewLabel_3;
      
        public ChangeBookFrame() {  
            //设置标题  
            super("欢迎来到修改图书界面");  
            getContentPane().setBackground(new Color(240, 240, 240));
            setSize(1024,623);  
            setLocation(200, 50);  
//            Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("6.png"), new Point(0, 0),"Slef");
//            getContentPane().setCursor(cursor);
            ImageIcon icon=new ImageIcon("11.jpg");
            this.setIconImage(icon.getImage());
            String path = "1.jpg";  
            ImageIcon background = new ImageIcon(path);  
            JLabel label = new JLabel(background);  
            label.setBounds(0, 0, this.getWidth(), this.getHeight());  
            JPanel imagePanel = (JPanel) this.getContentPane();  
            getContentPane().setLayout(null);
            Font f=new Font("宋体",Font.BOLD,25);
            Font a=new Font("宋体",Font.BOLD,20);
            JLabel lblNewLabel = new JLabel("需要修改的书名");
            lblNewLabel.setForeground(new Color(102, 153, 102));
            lblNewLabel.setBounds(109, 94, 159, 44);
            lblNewLabel.setFont(a);
            getContentPane().add(lblNewLabel);
            
            oldbookNameField = new JTextField();
            oldbookNameField.setBounds(267, 94, 159, 43);
            oldbookNameField.setFont(a);
            getContentPane().add(oldbookNameField);
            oldbookNameField.setColumns(10);
            
            JLabel lblNewLabel_1 = new JLabel("新的书名");
            lblNewLabel_1.setForeground(new Color(102, 153, 102));
            lblNewLabel_1.setBounds(508, 94, 108, 44);
            lblNewLabel_1.setFont(f);
            getContentPane().add(lblNewLabel_1);
            
            bookNameField = new JTextField();
            bookNameField.setBounds(688, 94, 169, 44);
            getContentPane().add(bookNameField);
            bookNameField.setFont(a);
            bookNameField.setColumns(10);
            
            JButton btnNewButton_2 = new JButton("确认");
            btnNewButton_2.setBackground(SystemColor.info);
            btnNewButton_2.setForeground(new Color(102, 153, 102));
            AbstractAction change=new AbstractAction()  {
            	@Override
                public void actionPerformed(ActionEvent e) {
            		String oldBookName =oldbookNameField.getText();
    				String bookName =bookNameField.getText();
    				String bookAuthor =bookAuthorField.getText();
    				double bookPrice =Double.parseDouble(bookPriceField.getText());
    				//把界面中得到的四个数据放在两个Book里
    				Book oldBook=new Book(oldBookName,null,0);
    				Book book=new Book(bookName,bookAuthor,bookPrice);
    				Operator o =new Operator();
    				//把Book传给Operator操作
    				ReturnResult rr=o.changeBook(book,oldBook);
    				if(rr.isSuccess)
    				{
    					JOptionPane.showMessageDialog(null, "修改成功");
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "没有找到相应图书，添加失败");
    				}
            	}
            };
            btnNewButton_2.addActionListener(change);
    		InputMap imap = ((JComponent) getContentPane()).getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);  
    		imap.put(KeyStroke.getKeyStroke("ENTER"), "btnNewButton_2");  
    		ActionMap amap = ((JComponent) getContentPane()).getActionMap();  
    		amap.put("btnNewButton_2", change);
            btnNewButton_2.setBounds(331, 451, 113, 51);
            btnNewButton_2.setFont(a);
            getContentPane().add(btnNewButton_2);
            
            JButton btnNewButton_3 = new JButton("返回");
            btnNewButton_3.setBackground(SystemColor.info);
            btnNewButton_3.setForeground(new Color(102, 153, 102));
            btnNewButton_3.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				MainClassFrame mainClassFrame=new MainClassFrame();
    				mainClassFrame.setVisible(true);
    				ChangeBookFrame.this.dispose();
            	}
            });
            btnNewButton_3.setBounds(537, 451, 113, 51);
            btnNewButton_3.setFont(a);
            getContentPane().add(btnNewButton_3);
            
            bookAuthorField = new JTextField();
            bookAuthorField.setBounds(688, 217, 169, 44);
            bookAuthorField.setFont(a);
            getContentPane().add(bookAuthorField);
            bookAuthorField.setColumns(10);
            
            bookPriceField = new JTextField();
            bookPriceField.setBounds(690, 330, 167, 44);
            bookPriceField.setFont(a);
            getContentPane().add(bookPriceField);
            bookPriceField.setColumns(10);
            
            lblNewLabel_2 = new JLabel("新书作者");
            lblNewLabel_2.setForeground(new Color(102, 153, 102));
            lblNewLabel_2.setBounds(508, 217, 108, 44);
            lblNewLabel_2.setFont(f);
            getContentPane().add(lblNewLabel_2);
            
            lblNewLabel_3 = new JLabel("新书价格");
            lblNewLabel_3.setForeground(new Color(102, 153, 102));
            lblNewLabel_3.setBounds(508, 330, 108, 44);
            lblNewLabel_3.setFont(f);
            getContentPane().add(lblNewLabel_3);
            imagePanel.setOpaque(false);  
            this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
            setVisible(true);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        }  
      
        public static void main(String[] args) {  
            new ChangeBookFrame();  
        }  
    }  