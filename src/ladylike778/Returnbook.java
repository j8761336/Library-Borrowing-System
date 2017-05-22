package ladylike778;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class Returnbook extends JFrame {
	private JComboBox cate=new JComboBox();
	private JTextField bookname=new JTextField("書名");
	private JTextField bookid=new JTextField("編號");
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	private JPanel panel3=new JPanel();
	private JButton enter=new JButton("確認");
	
	
	
	
	public Returnbook(){
		init();
	}

	public void init() {
		this.setTitle("還書");
		Container cp = this.getContentPane();
		this.setBounds(100, 100, 600, 600);		
		cp.setLayout(new BorderLayout());	
		cp.add(panel2,BorderLayout.NORTH);
		cp.add(panel3,BorderLayout.SOUTH);
		panel3.setLayout(new GridLayout(1,1));
		panel2.setLayout(new GridLayout(1,3,5,5));
		panel2.add(cate);panel2.add(bookname);panel2.add(bookid);	
		cate.addItem("分類");panel3.add(enter);
		cate.setSelectedIndex(0);
		
		
	}

	
	}
	
	


