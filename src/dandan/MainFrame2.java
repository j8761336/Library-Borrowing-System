package dandan;
import java.awt.*;

import Preferences.BookHistory;
import Preferences.main;
import User.SystemUser;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dandan.DBConnection;
import ladylike778.LoanFrame;
import BookManagement.*;

import javax.swing.*;

import BookManagement.MainFrame;
import User.Userdata;
import dandan.DBConnection;
public class MainFrame2 extends JFrame{
	private Button btn1 =new Button("User management");
	private Button btn2 =new Button("Book management");
	private Button btn3 =new Button("Borrow books");
	private Button btn4 =new Button("Analysis & Report");

	
	public MainFrame2(){
		initComp();
	}
	private void initComp(){
		this.setSize(600,500);
		this.setLocation(100,200);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		
		this.setLayout(null);
		btn1.setLocation(100,100);
		btn2.setLocation(100,300);
		btn3.setLocation(400,100);
		btn4.setLocation(400,300);
		btn1.setSize(150,80);
		btn2.setSize(150,80);
		btn3.setSize(150,80);
		btn4.setSize(150,80);
		this.add(btn1);
		this.add(btn2);
//		this.add(btn3);
		this.add(btn4);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SystemUser su =new SystemUser();
			}
		});
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BookManagement.MainFrame nnnn = new MainFrame();
				
			}
		});

		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BookHistory bst = new BookHistory();
				bst.setVisible(true);
			}
		});
	}
}
