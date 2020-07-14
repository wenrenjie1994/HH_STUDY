package gui;
    import javax.swing.ImageIcon;  
    import javax.swing.JFrame;  
    import javax.swing.JLabel;  
    import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;  
    public class SearchBookFrame extends JFrame {  
      
        public SearchBookFrame() {  
            //设置标题  
            super("欢迎来到查询图书界面");  
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
            Font a=new Font("宋体",Font.BOLD,20);
            
            JButton btnNewButton = new JButton("按书名查找");
            btnNewButton.setForeground(new Color(102, 153, 102));
            btnNewButton.setBackground(SystemColor.info);
            btnNewButton.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				SearchByBookName searchByBookName=new SearchByBookName();
    				searchByBookName.setVisible(true);
    				SearchBookFrame.this.dispose();
            	}
            });
            btnNewButton.setBounds(417, 65, 168, 49);
            btnNewButton.setFont(a);
            getContentPane().add(btnNewButton);
            
            JButton btnNewButton_1 = new JButton("按作者名查找");
            btnNewButton_1.setForeground(new Color(102, 153, 102));
            btnNewButton_1.setBackground(SystemColor.info);
            btnNewButton_1.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				SearchByBookAuthor searchByBookAuthor=new SearchByBookAuthor();
    				searchByBookAuthor.setVisible(true);
    				SearchBookFrame.this.dispose();
            	}
            });
            btnNewButton_1.setBounds(417, 159, 168, 49);
            btnNewButton_1.setFont(a);
            getContentPane().add(btnNewButton_1);
            
            JButton btnNewButton_2 = new JButton("按价格查找");
            btnNewButton_2.setForeground(new Color(102, 153, 102));
            btnNewButton_2.setBackground(SystemColor.info);
            btnNewButton_2.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				SearchByBookPrice searchByBookPrice=new SearchByBookPrice();
    				searchByBookPrice.setVisible(true);
    				SearchBookFrame.this.dispose();
            	}
            });
            btnNewButton_2.setBounds(417, 252, 168, 49);
            btnNewButton_2.setFont(a);
            getContentPane().add(btnNewButton_2);
            
            JButton btnNewButton_3 = new JButton("关键字查找");
            btnNewButton_3.setForeground(new Color(102, 153, 102));
            btnNewButton_3.setBackground(SystemColor.info);
            btnNewButton_3.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				SearchByKeyWord searchByPointWord=new SearchByKeyWord();
    				searchByPointWord.setVisible(true);
    				SearchBookFrame.this.dispose();
            	}
            });
            btnNewButton_3.setBounds(417, 342, 168, 49);
            btnNewButton_3.setFont(a);
            getContentPane().add(btnNewButton_3);
            
            JButton btnNewButton_4 = new JButton("返回");
            btnNewButton_4.setForeground(new Color(102, 153, 102));
            btnNewButton_4.setBackground(SystemColor.info);
            btnNewButton_4.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
    				MainClassFrame mainClassFrame=new MainClassFrame();
    				mainClassFrame.setVisible(true);
    				SearchBookFrame.this.dispose();
            	}
            });
            btnNewButton_4.setBounds(417, 431, 168, 49);
            btnNewButton_4.setFont(a);
            getContentPane().add(btnNewButton_4);
            imagePanel.setOpaque(false);  
            this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
            setVisible(true);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        }  
      
        public static void main(String[] args) {  
            new SearchBookFrame();  
        }  
    }  