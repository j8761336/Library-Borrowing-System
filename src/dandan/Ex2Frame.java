package dandan;

import java.awt.event.*;
import javax.swing.*;

public class Ex2Frame extends JFrame{
	private JMenuBar jmbar =new JMenuBar();
	private JMenu jmuFile =new JMenu("File");
	private JMenuItem jmuitemOpen =new JMenuItem("Open");
	private JMenuItem jmuitemExit =new JMenuItem("Exit");
	private JMenu jmuDB =new JMenu("Database");
	private JMenuItem jmuDBConn =new JMenuItem("Connect");
	private JMenuItem jmuDBDisConn =new JMenuItem("Disconnect");
	private DBConnection dbConn;
	
	public Ex2Frame(){
		initComp();
	}
	private void initComp(){
		this.setBounds(100,100,600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jmuFile.add(jmuitemOpen);
		jmuFile.add(jmuitemExit);
		jmuitemExit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		jmbar.add(jmuFile);
		jmuDB.add(jmuDBConn);
		jmuDB.add(jmuDBDisConn);
		jmbar.add(jmuDB);
		this.setJMenuBar(jmbar);
		jmuDBConn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dbConn =new DBConnection();
			}
		});
	}
}
