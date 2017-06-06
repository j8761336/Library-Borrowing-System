package Preferences;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class BookHistory extends JFrame{
	private JTextField search = new JTextField();
	private JButton doSearch = new JButton("search");
	private JComboBox variety = new JComboBox();
	private JComboBox time1 = new JComboBox();
	private JComboBox time2 = new JComboBox();
	private JLabel space = new JLabel("  空     ");
	private JLabel space1 = new JLabel("");
	private JLabel space2 = new JLabel("");
//	private JLabel time1 = new JLabel("time1");
//	private JLabel time2 = new JLabel("time2");
	private JLabel b1 = new JLabel("to",SwingConstants.CENTER);
	private Container cp;
	
	private JMenuBar jbr1 = new JMenuBar();
	private JMenu jm1 = new JMenu("使用者");
	private JMenu jm2 = new JMenu("檔案");
	private JMenuItem jmit1 = new JMenuItem("輸出圓餅圖");
	private JMenuItem jmit2 = new JMenuItem("輸出長條圖");
	
    private String [][] tableData;
    private String [] bookSign;
	private DefaultTableModel tmodel;
	private JTable jtb1 ;
	
	public BookHistory(String td[][],int datacount){
		JShowData(td,datacount);
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
		pel1.setLayout(new GridLayout(1,6));
		pel2.setLayout(new GridLayout(3,1));
		cp.add(pel2,BorderLayout.NORTH);
		cp.add(new JScrollPane(jtb1),BorderLayout.CENTER);
		cp.add(space2,BorderLayout.SOUTH);
		cp.setBackground(Color.LIGHT_GRAY);
		pel2.add(jbr1);pel2.add(space1);pel2.add(pel1);
		
		pel1.add(time1);pel1.add(b1);pel1.add(time2);
		pel1.add(variety);pel1.add(search);pel1.add(doSearch);
		jbr1.add(jm1);jbr1.add(jm2);
		jm1.add(jmit1);jm1.add(jmit2);
		jm2.add(space);

	}
	
	private void JShowData(String td [][],int datacount) {
		
		String count [] = new String [datacount];
		for(int i=0;i<datacount;i++){
			String tmp = Integer.toString(i+1);
			 count [i] = tmp+".";
		}
		String td1 [][]= new String[datacount][6];
		for(int j=0;j<datacount;j++){
			 for(int x=1;x<6;x++){
				 td1[j][0]=count[j];
				 td1[j][x]=td[j][x-1];
			 }
		 }
		
        tableData = td1;
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
