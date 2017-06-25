package BookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Frame1 extends JFrame{
	public JButton enter= new JButton("確定");
	public JTextField tf = new JTextField("");
	public JLabel text = new JLabel("請輸入要新增的類別名稱");
	private ResultSet rs;
	private ResultSetMetaData meta;
	private DBConnection dbConn = new DBConnection(null,"root","123456");
	public Frame1(){
		init();
		this.setTitle("新增類別");
	}
	private void init(){
		this.setBounds(800,400,300,200);
		this.setLayout(null);
		enter.setBounds(110, 75, 60, 25);
		tf.setBounds(110, 40, 60, 30);
		text.setBounds(70, 10, 150, 30);
		enter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				start();
			}
		});
		this.add(enter);
		this.add(tf);
		this.add(text);
	}
	private void start(){
		String sum = tf.getText();
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
				Boolean flag = true;
				for(int i = 0; i<dbConn.getCategoryRowCount();i++){
					if(data[i][1].equals(tf.getText())){
						flag = false;
						break;
					}
				}
				if(flag==true){
					dbConn.newCategory(tf.getText());
				}
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		this.setVisible(false);
	}
}
