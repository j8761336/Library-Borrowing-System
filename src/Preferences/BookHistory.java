package Preferences;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BookHistory extends JFrame{
	private JTextField search = new JTextField();
	private JButton doSearch = new JButton("search");
	private JComboBox variety = new JComboBox();
	private JComboBox time1 = new JComboBox();
	private JComboBox time2 = new JComboBox();
	private JLabel space = new JLabel();
//	private JLabel time1 = new JLabel("time1");
//	private JLabel time2 = new JLabel("time2");
	private JLabel b1 = new JLabel("to",SwingConstants.CENTER);
	private Container cp;
	
	
	public BookHistory(){
		init();
	}
	private void init(){
		this.setTitle("search(user)");
		cp=this.getContentPane();
		cp.setLayout(new BorderLayout());
		
		this.setBounds(100, 100, 600, 600);
		this.setDefaultCloseOperation(BookHistory.DISPOSE_ON_CLOSE);
		Panel pel1 = new Panel();
		Panel pel2 = new Panel();
		pel1.setLayout(new GridLayout(1,6));
		pel2.setLayout(new GridLayout(2,1));
		cp.add(pel2,BorderLayout.NORTH);
		pel2.add(space);pel2.add(pel1);
		pel1.add(time1);pel1.add(b1);pel1.add(time2);
		pel1.add(variety);pel1.add(search);pel1.add(doSearch);
		
		
		
		
		
		
	}
}
