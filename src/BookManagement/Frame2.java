package BookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Frame2 extends JFrame{
	public JLabel jlb1 = new JLabel("書名");
	public JLabel jlb2 = new JLabel("作者");
	public JLabel jlb3 = new JLabel("類別");
	public JTextField tf1 = new JTextField("");
	public JTextField tf2 = new JTextField("");
	public JButton enter= new JButton("確定");
	public JComboBox<String> comebox = new JComboBox();
	private ResultSet rs;
	private ResultSetMetaData meta;
	private DBConnection dbConn = new DBConnection(null,"root","123456");
	public Frame2(){
		init();
		this.setTitle("新增書籍");
	}
	private void init(){
		this.setBounds(800,350,300,350);
		this.setLayout(null);
		enter.setBounds(180, 250, 60, 25);
		enter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				start();
			}
		});
		jlb1.setBounds(50, 40, 60, 30);
		jlb2.setBounds(50, 90, 60, 30);
		jlb3.setBounds(50, 140, 60, 30);
		tf1.setBounds(90, 40, 90, 30);
		tf2.setBounds(90, 90, 90, 30);
		comebox.setBounds(90, 140, 90, 30);
		addContent();
		this.add(enter);
		this.add(jlb1);
		this.add(jlb2);
		this.add(jlb3);
		this.add(tf1);
		this.add(tf2);
		this.add(comebox);
	}
	public void addContent(){
		try{
			rs = dbConn.getCategoryData();
			if(rs!=null){
				meta = rs.getMetaData();
				int rowCount = 0;
				int colCount = 0;
				colCount = meta.getColumnCount();
				rowCount = dbConn.getCategoryRowCount();
				colCount = meta.getColumnCount();
				String[][] data = new String[rowCount][colCount];
				rowCount=0;
				while(rs.next()){
					for(int i=0; i < colCount; i++){
						data[rowCount][i] = rs.getString(i+1);
					}
					rowCount++;
				}
				for(int i = 0; i<dbConn.getCategoryRowCount();i++){
					comebox.addItem(data[i][1]);
				}
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	private void start(){
		dbConn.newBook(comebox.getSelectedItem().toString(),tf1.getText(),tf2.getText());
		this.setVisible(false);
	}
}
