package User;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class SystemUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		systemframe sf = new systemframe();
		sf.setVisible(true);
	}

}

class systemframe extends JFrame {
	private JButton addjbtn = new JButton("新增使用者");
	private JButton revjbtn = new JButton("修改使用者");
	private JButton deljbtn = new JButton("刪除使用者");
	private JButton bookjbtn = new JButton("書籍管理");
	private JLabel accjlb = new JLabel("帳號");
	private JLabel namejlb = new JLabel("姓名");
	private JLabel datejlb = new JLabel("日期");
	private JLabel condijlb = new JLabel("狀態");
	private JPanel funcjpl = new JPanel(new GridLayout(4, 1, 10, 10));
	private JPanel jlbjpl = new JPanel(new GridLayout(1, 4, 4, 4));
	private JLabel mainjlb = new JLabel("帳號更動紀錄");
	private Font f1=new Font(null,Font.BOLD,16);
	private Container cp;

	public systemframe() {
		init();
	}

	private void init() {
		this.setBounds(10, 10, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		funcjpl.add(addjbtn);
		funcjpl.add(revjbtn);
		funcjpl.add(deljbtn);
		funcjpl.add(bookjbtn);
		jlbjpl.add(accjlb);
		jlbjpl.add(namejlb);
		jlbjpl.add(datejlb);
		jlbjpl.add(condijlb);
		addjbtn.setFont(f1);
		revjbtn.setFont(f1);
		deljbtn.setFont(f1);
		bookjbtn.setFont(f1);
		accjlb.setFont(f1);
		namejlb.setFont(f1);
		datejlb.setFont(f1);
		condijlb.setFont(f1);
		mainjlb.setFont(f1);
		this.setTitle("系統管理員介面");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(100,250,0,10);
		cp.add(mainjlb, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(50,50, 400, 10);
		cp.add(funcjpl, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 2;
		gbc.weighty = 0;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(50, 250, 600, 10);
		gbc.gridwidth=2;
		
		cp.add(jlbjpl, gbc);
	}

}

