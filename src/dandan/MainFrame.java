package dandan;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame extends JFrame{
	private Button btn1 =new Button("User management");
	private Button btn2 =new Button("Book management");
	private Button btn3 =new Button("Borrow books");
	private Button btn4 =new Button("Analysis & Report");
	public MainFrame(){
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
		this.add(btn3);
		this.add(btn4);
	}
}
