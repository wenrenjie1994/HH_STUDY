package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import model.BookList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class SearchResult extends JFrame {

	private final JPanel contentPanel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			SearchResult dialog = new SearchResult(null);
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchResult(BookList booklist) {
//		setBounds(100, 100, 450, 300);
        super("查询结果");
        setBackground(SystemColor.info);
        getContentPane().setForeground(new Color(102, 153, 102));
        getContentPane().setBackground(SystemColor.info);
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
        imagePanel.setOpaque(false);  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        
        
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.info);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.info);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(255, 204, 153));
				okButton.setForeground(new Color(102, 153, 102));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SearchResult.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(255, 204, 153));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SearchResult.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
			Container c=getContentPane();
			int bookCount = booklist.size();
			Object[][] data=new Object[bookCount] [3];//表格
			for(int i=0;i<bookCount;i++){
				data[i][0]=booklist.get(i).bookName;
				data[i][1]=booklist.get(i).bookAuthor;
				data[i][2]=booklist.get(i).bookPrice;
			}
			String[] rowName={"书名","作者","价格"};//表头
			JTable table=new JTable(data,rowName);
			table.setForeground(new Color(102, 153, 102));
			table.setBackground(SystemColor.info);
			JTableHeader header = table.getTableHeader();
			header.setPreferredSize(new Dimension(50, 40)); 
			Font f=new Font("宋体", Font.PLAIN, 20);
			header.setFont(f);
			table.setRowHeight(30);
			table.setFont(new Font("宋体", Font.PLAIN, 20));
			c.add(new JScrollPane(table));
	}

}
