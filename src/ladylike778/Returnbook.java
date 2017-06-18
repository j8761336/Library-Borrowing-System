package ladylike778;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Returnbook extends JFrame {
	String load[]=new String[7];
	private String driver = "com.mysql.jdbc.Driver";
	private String url ="jdbc:mysql://127.0.0.1:3306/test?"+ "";
	private Connection dbConn;
	private JTextField bookid=new JTextField("書籍編號");
	private JButton research=new JButton("查詢");
	private JPanel panel3=new JPanel();
	private JPanel panel4=new JPanel();
	private JPanel panel5=new JPanel();
	private JLabel aaaa=new JLabel();
	private JButton enter=new JButton("確認");
	private JTable loinfo;
	private String [][] tableData;
    private String [] bookSign;
	private TableModel tmodel;
	public Returnbook(String usersid){
		Showdata(usersid,load);
		this.setTitle("還書");
		Container cp = this.getContentPane();
		this.setBounds(100, 100, 600, 400);
		cp.setLayout(new BorderLayout(2,30));	
		cp.add(panel4,BorderLayout.NORTH);		
		cp.add(panel3,BorderLayout.SOUTH);
		cp.add(new JScrollPane(loinfo), BorderLayout.CENTER);
		panel3.setLayout(new GridLayout(1,1));		
		panel4.setLayout(new GridLayout(1,2));
		panel5.setLayout(new GridLayout(1,2));
		panel4.add(bookid);panel4.add(panel5);
		panel5.add(aaaa);panel5.add(research);		 	     
		panel3.add(enter);
		
		research.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				try{DBConnection("root","");
				Statement stmt= dbConn.createStatement();
				String data="SELECT*FROM op WHERE bookid="+bookid.getText();
				ResultSet rs=stmt.executeQuery(data);
				ResultSetMetaData rm=(ResultSetMetaData) rs.getMetaData();
				int co=rm.getColumnCount();
				Calendar cl=Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				while(rs.next()){
					for(int i=1;i<=co;i++){
						
						load[i-1]=rs.getString(i);						
						bookSign=new String[]{"借用者","分類","書名","編號","借出日期","應歸還日期","狀態"};
						String t[][] ={{usersid,load[0],load[1],load[2],load[4],sdf.format(cl.getTime()),load[6]}};
						tableData=t;						
						loinfo.setModel(new DefaultTableModel(tableData,bookSign));						
						}					
					}
				}
				catch (SQLException e1) {e1.printStackTrace();}}});
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					DBConnection("root","");
					Statement stmt= dbConn.createStatement();
					Calendar cl=Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				    System.out.println(sdf.format(cl.getTime()));
				    String data="INSERT op(userid,category,booktitle,bookid,loandate,returndate,status)VALUES"
							+ " ("+usersid+",'"+loinfo.getValueAt(0, 1)+"','"+loinfo.getValueAt(0, 2)+"','"+loinfo.getValueAt(0, 3)+"','"+loinfo.getValueAt(0, 4)+"','"+sdf.format(cl.getTime())+"','"+"已歸還"+"')";
					stmt.executeUpdate(data);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
				}
			
			});
		
	}
	  Returnbook(String id,String pw){
		  
		  try{
			Class.forName(driver);
			System.out.println(driver);

			dbConn = DriverManager.getConnection(url, id, pw);
			System.out.println("hi");
			JOptionPane.showMessageDialog(null,"DB connecction success!!");
		}catch(SQLException sqle){
//			JOptionPane.showMessageDialog(null,"Error: "+ sqle.toString());
			System.out.println(sqle);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error: "+e.toString());
		}
	}
	
	
	
					
	
	private void DBConnection(String id,String pw){
		try{
			Class.forName(driver);
			dbConn = DriverManager.getConnection(url,id,pw);
			
		}catch(SQLException sqle){			
			System.out.println(sqle);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error: "+e.toString());
		}
	}

	private void init() {		
		}
	
	        private void Showdata(String usersid,String load[]){						
        	String t[][] ={{usersid,load[0],load[1],load[2],load[3]}};			
	        	tableData=t;
			bookSign=new String[]{"借用者","分類","書名","編號","借出日期","歸還日期","狀態"};
			tmodel=new DefaultTableModel(tableData,bookSign);
			loinfo=new JTable(tmodel){
				public boolean isCallEditable(int row,int column){
					return false;}}; 
			Container c=getContentPane();
			c.setLayout(new BorderLayout());
			loinfo.getTableHeader().setReorderingAllowed(true);
			c.add(new JScrollPane(loinfo), BorderLayout.CENTER);
			
		}
	}