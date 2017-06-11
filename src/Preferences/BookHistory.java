package Preferences;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jfree.ui.RefineryUtilities;

import java.sql.ResultSetMetaData;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookHistory extends JFrame{
	private String driver = "com.mysql.jdbc.Driver";
	private String url ="jdbc:mysql://127.0.0.1:3306/test?";	
	private Connection dbConn;
	
	private JTextField search = new JTextField();
	private JButton doSearch = new JButton("search");
	private JComboBox variety = new JComboBox();
	private JComboBox time1 = new JComboBox();
	private JComboBox time2 = new JComboBox();
	private JLabel space = new JLabel("  空     ");
	private JLabel space1 = new JLabel("");
	private JLabel space2 = new JLabel("");
	private JLabel b1 = new JLabel("to",SwingConstants.CENTER);
	private Container cp;
	
	private JMenuBar jbr1 = new JMenuBar();
	private JMenu jm1 = new JMenu("使用者");
	private JMenu jm2 = new JMenu("檔案");
	private JMenuItem jmit1 = new JMenuItem("輸出圓餅圖");
	private JMenuItem jmit2 = new JMenuItem("輸出長條圖");
	private JMenuItem jmuDBConn =new JMenuItem("Connect");
	
    private String [][] tableData;
    private String [] bookSign;
	private TableModel tmodel;
	private JTable jtb1 ;
	
	private String td[][]; 
	
	
	public BookHistory(){
		JShowData(td);
		init();
		
	}
	
	private void init(){
		
		this.setTitle("search(user)");
		cp=this.getContentPane();
		cp.setLayout(new BorderLayout(2,3));
		
		this.setBounds(100, 100, 600, 600);
		this.setDefaultCloseOperation(BookHistory.DISPOSE_ON_CLOSE);
		Panel pel1 = new Panel();
		Panel pel2 = new Panel();
		pel1.setLayout(new GridLayout(1,5));
		pel2.setLayout(new GridLayout(2,1));
		cp.add(pel2,BorderLayout.NORTH);
		cp.add(new JScrollPane(jtb1),BorderLayout.CENTER);
		cp.add(space2,BorderLayout.SOUTH);
		cp.setBackground(Color.LIGHT_GRAY);
		pel2.add(jbr1);pel2.add(pel1);
		
		pel1.add(time1);pel1.add(time2);
		pel1.add(variety);pel1.add(search);pel1.add(doSearch);
			
		jbr1.add(jm1);jbr1.add(jm2);
		jm1.add(jmit1);jm1.add(jmit2); 
		jm2.add(jmuDBConn);
		//jm2.add(space);	
		
		time1.setBorder(BorderFactory.createTitledBorder("從"));
		time2.setBorder(BorderFactory.createTitledBorder("到"));
		variety.setBorder(BorderFactory.createTitledBorder("種類"));
		
		time1.addItem("日期");
		time2.addItem("日期");
		variety.addItem("借書時間");
		variety.addItem("歸還時間");
		
		String[] tpd = new String [6];
		//------------------------------------------
		jmuDBConn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 DBConnection("root","");
			}
		});
		
		//------------------------------------------
		jmit1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent a) {
//				System.out.println();
				ArrayList<TableDataList>tdlist=new ArrayList<TableDataList>();
				float a1 = 0,a2=0,a3=0,a4=0,a5=0;
				
				try{
					DBConnection("root","");
					Statement stmt = dbConn.createStatement();
					String data2 = "SELECT * FROM test1";
					ResultSet rs = stmt.executeQuery(data2);
					ResultSetMetaData rm = rs.getMetaData();
					int cnum = rm.getColumnCount();
					
					while(rs.next()){
						for(int i=1; i<=cnum; i++){
//							tpd1[i-1] =rs.getObject(i);
							tpd[i-1]=rs.getObject(i).toString();
							//System.out.println(rm.getColumnName(i)+":"+rs.getObject(i)+" ");
						}tdlist.add(new TableDataList(tpd[0],tpd[1],tpd[2],tpd[3],tpd[4],tpd[5]));
					System.out.println("");
					}
					
//					System.out.println(tdlist.size());
					
					String tmp [][]=new String [tdlist.size()][6];
					for(int i=0;i<tdlist.size();i++){
						tmp[i][0]=tdlist.get(i).retNum();
						tmp[i][1]=tdlist.get(i).retVariety();
						tmp[i][2]=tdlist.get(i).retBookName();
						tmp[i][3]=tdlist.get(i).Author();
						tmp[i][4]=tdlist.get(i).returnDate();
						tmp[i][5]=tdlist.get(i).Status();
					}
					
					for(int i=0;i<tdlist.size();i++){
						if(tmp[i][1].equals("國文類")){
							a1++;
//							System.out.println(a1);
						}else if(tmp[i][1].equals("英文類")){
							a2++;
						}else if(tmp[i][1].equals("數學類")){
							a3++;
						}else if(tmp[i][1].equals("資訊類")){
							a4++;
						}else {
							a5++;
						}
					}
					a1/=tdlist.size();a1*=100;
					a2/=tdlist.size();a2*=100;
					a3/=tdlist.size();a3*=100;
					a4/=tdlist.size();a4*=100;
					a5/=tdlist.size();a5*=100;
//					System.out.println(a1);
				}
				
				catch(Exception d){
					d.printStackTrace();
					//System.out.println("error:"+d.toString());
				}
				PieChart demo = new PieChart("Pie2", "What kind of book do you like?",a1,a2,a3,a4,a5);
	            demo.pack();  
	            demo.setVisible(true);
			}
		});
		
		//-----------------------------------------
		jmit2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent c) {
				BarChart longchart1 = new BarChart("<使用者偏好>");  
				longchart1.pack();  
				RefineryUtilities.centerFrameOnScreen(longchart1);  
				longchart1.setVisible(true);  
			}
		});
		
		
		doSearch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent b) {
				// TODO Auto-generated method stub
				ArrayList<TableDataList>tdlist=new ArrayList<TableDataList>();
				
				
				try{
					DBConnection("root","");
					Statement stmt = dbConn.createStatement();
					String data2 = "SELECT * FROM test1";
					ResultSet rs = stmt.executeQuery(data2);
					ResultSetMetaData rm = rs.getMetaData();
					int cnum = rm.getColumnCount();
					
					while(rs.next()){
						for(int i=1; i<=cnum; i++){
//							tpd1[i-1] =rs.getObject(i);
							tpd[i-1]=rs.getObject(i).toString();
							//System.out.println(rm.getColumnName(i)+":"+rs.getObject(i)+" ");
						}tdlist.add(new TableDataList(tpd[0],tpd[1],tpd[2],tpd[3],tpd[4],tpd[5]));
					System.out.println("");
					}
					
//					System.out.println(tdlist.size());
					
					String tmp [][]=new String [tdlist.size()][6];
					for(int i=0;i<tdlist.size();i++){
						tmp[i][0]=tdlist.get(i).retNum();
						tmp[i][1]=tdlist.get(i).retVariety();
						tmp[i][2]=tdlist.get(i).retBookName();
						tmp[i][3]=tdlist.get(i).Author();
						tmp[i][4]=tdlist.get(i).returnDate();
						tmp[i][5]=tdlist.get(i).Status();
					}
					
					td=tmp;
					bookSign = new String[]{"No.","類別","書名","作者","歸還日期","狀態"};
					jtb1.setModel(new DefaultTableModel(td,bookSign));
				}
				catch(Exception d){
					d.printStackTrace();
					//System.out.println("error:"+d.toString());
				}
				
//				for(int i=0;i<tdlist.size();i++){
//					for(int x=0;x<6;x++){
//						System.out.println(td[i][x]);
//					}
//				}
				
			}
			
		});
		
	}
	
	private void DBConnection(String id,String pw){
		try{
			Class.forName(driver);
			dbConn = DriverManager.getConnection(url,id,pw);
			//JOptionPane.showMessageDialog(null,"DB connecction success!!");
		}catch(SQLException sqle){
//			JOptionPane.showMessageDialog(null,"Error: "+ sqle.toString());
			System.out.println(sqle);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error: "+e.toString());
		}
	}
	
	/*
	 * JTable的設定
	 * td是要顯示的資料
	 */
	private void JShowData(String td [][]) {
		
//		String count [] = new String [datacount];
//		for(int i=0;i<datacount;i++){
//			String tmp = Integer.toString(i+1);
//			 count [i] = tmp+".";
//		}
//		String td1 [][]= new String[datacount][6];
//		for(int j=0;j<datacount;j++){
//			 for(int x=1;x<6;x++){
//				 td1[j][0]=count[j];
//				 td1[j][x]=td[j][x-1];
//			 }
//		 }
//		
        tableData = td;
        bookSign = new String[]{"No.","類別","書名","作者","歸還日期","狀態"};
        tmodel = new DefaultTableModel(tableData,bookSign); //建立表格
        
        /*
         * 	原本的是book =  new JTable(tmodel);
         * 為了禁止使用者修改表格內容改寫isCellEditable方法
         */
        jtb1 =  new JTable(tmodel){ public boolean isCellEditable
        	(int row, int column) { return false; }}; //建立JTable
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        //設定資料表並加入滾輪
        jtb1.getColumnModel().getColumn(4).setPreferredWidth(200);
        jtb1.getTableHeader().setReorderingAllowed(false); //關閉拖動欄位功能
//        jtb1.setShowHorizontalLines(false); //不顯示列橫線
        c.add(new JScrollPane(jtb1),BorderLayout.CENTER);

        //設定視窗
        //setSize(500,400);
        //固定範圍隨機出現的小動作
        //setLocation((int)(Math.random() * 50) + 5,250); 
        //setResizable(false);//視窗放大按鈕無效 
        //setVisible(true);

        //setDefaultCloseOperation();
    }
	

}


