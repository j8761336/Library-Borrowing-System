package BookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame3 extends JFrame{
	public JButton enter= new JButton("確定");
	public JTextField tf = new JTextField("");
	public JLabel text = new JLabel("請輸入要刪除的書籍編號");
	private DBConnection dbConn = new DBConnection(null,"root","123456");
	public Frame3(){
		init();
		this.setTitle("刪除書籍");
	}
	public void init(){
		this.setBounds(800,400,300,200);
		this.setLayout(null);
		enter.setBounds(110, 75, 60, 25);
		enter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				start();
			}
		});
		tf.setBounds(110, 40, 60, 30);
		text.setBounds(70, 10, 150, 30);
		this.add(enter);
		this.add(tf);
		this.add(text);
	}
	public void start(){
		dbConn.deleteBook(Integer.parseInt(tf.getText()));
		this.setVisible(false);
	}
}
