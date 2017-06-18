package User;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserShowinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Show sh = new Show();
		sh.setVisible(true);
	}

}

class Show extends JFrame {
	private JLabel namejlb = new JLabel("姓名");
	private JLabel namejlb2 = new JLabel("0");
	private JLabel idjlb = new JLabel("帳號");
	private JLabel idjlb2 = new JLabel("0");
	private JLabel namejlb3 = new JLabel("姓名");
	private JLabel idjlb3 = new JLabel("帳號");
	private JLabel datejlb = new JLabel("日期");
	private JLabel condijlb = new JLabel("狀態");
	private JPanel mainjpl = new JPanel(new GridLayout(2, 2, 3, 20));
	private JPanel showjpl = new JPanel(new GridLayout(1, 4, 3, 3));
	private Font f1 = new Font(null, Font.BOLD, 16);
	private Container cp;

	public Show() {
		init();
	}

	private void init() {
		this.setBounds(10, 10, 700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		this.setTitle("帳號資料顯示");
		mainjpl.add(namejlb);
		mainjpl.add(namejlb2);
		mainjpl.add(idjlb);
		mainjpl.add(idjlb2);
		showjpl.add(idjlb3);
		showjpl.add(namejlb3);
		showjpl.add(datejlb);
		showjpl.add(condijlb);
		namejlb.setFont(f1);
		namejlb2.setFont(f1);
		namejlb3.setFont(f1);
		idjlb.setFont(f1);
		idjlb2.setFont(f1);
		idjlb3.setFont(f1);
		datejlb.setFont(f1);
		condijlb.setFont(f1);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridheight = 2;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(50, 100, 0, 275);
		// gbc.insets=new Insets(top, left, bottom, right);
		cp.add(mainjpl, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 100, 0, 0);
		cp.add(showjpl, gbc);

	}

}
