package BookManagement;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	public Container cp = new Container();
	public JPanel jpn = new JPanel();
	public JButton newBook= new JButton("新增書籍");
	public JButton modifyBook= new JButton("刪除書籍");
	public JButton newSort = new JButton("新增類別");
	public JLabel serch = new JLabel("搜尋");
	public JLabel jlb = new JLabel("借書紀錄");
	private ResultSet rs;
	private ResultSetMetaData meta;
	private DBConnection dbConn = new DBConnection(this,"root","123456");
	public JTextField tf = new JTextField("");
	public JTable jt = null;
	public Frame1 frm1 = new Frame1();
	public Frame2 frm2 = new Frame2();
	public Frame3 frm3 = new Frame3();
	public MainFrame(){
		init();
		this.setVisible(true);
		this.setTitle("書籍管理系統");
	}
	private void init(){
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout(3,3));
		showBookData();
		this.setBounds(100,100,750,450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		this.setLocationRelativeTo(null); 
		newBook.setBounds(30,70,100,40);
		modifyBook.setBounds(30, 130, 100, 40);
		newSort.setBounds(30, 190, 100, 40);
		newSort.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				showFrame1();
			}
		});
		newBook.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				showFrame2();
			}
		});
		modifyBook.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				showFrame3();
			}
		});
		jlb.setBounds(180, 25, 100, 40);
		serch.setBounds(520, 25, 50, 40);
		tf.setBounds(550, 37, 50, 20);
		jpn.add(newBook);
		jpn.add(modifyBook);
		jpn.add(newSort);
		cp.add(jpn,BorderLayout.NORTH);
	}
	private void showBookData(){
		try{
			rs = dbConn.getBookData();
			if(rs!=null){
				meta = rs.getMetaData();
				int rowCount = 0;
				int colCount = 0;
				colCount = meta.getColumnCount();
				rowCount = dbConn.getBookRowCount();
				Object[][] data = new Object[rowCount][colCount];
				rowCount = 0;
				while(rs.next()){
					for(int i=0; i < colCount; i++){
						data[rowCount][i] = rs.getObject(i+1);
					}
					rowCount++;
				}
				String[] item = {"編號", "類別", "書名", "作者", "狀態"};
				jt = new JTable(data,item);
				cp.add(new JScrollPane(jt),BorderLayout.CENTER);
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public void showFrame1(){
		frm1.setVisible(true);
	}
	public void showFrame2(){
		frm2.setVisible(true);
	}
	public void showFrame3(){
		frm3.setVisible(true);
	}
}
