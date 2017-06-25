package User;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dandan.DBConnection;

class Redata extends JFrame {
	private JLabel jlb1 = new JLabel("請輸入:");
	private JTextField jtf1 = new JTextField();
	private JButton jbt = new JButton("送出");
	private Container cp;
	private JPanel jpl = new JPanel(new GridLayout(1, 1, 3, 25));
	private JPanel jpl2 = new JPanel(new GridLayout(1, 1, 3, 20));
	private Font ft = new Font(null, Font.BOLD, 18);
	private String account;
	private Connection dbConn;
	private Statement queryStmt, insertStmt;
	private ResultSet rs;
	private ResultSetMetaData meta;
	private int i;

	public Redata(int k, String str) {
		i = k;
		account = str;
		init();
	}

	private void init() {
		this.setBounds(10, 10, 700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		this.setTitle("新資料");
		jpl.add(jlb1);
		jpl2.add(jtf1);
		jlb1.setFont(ft);
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.WEST;
		g.fill = GridBagConstraints.BOTH;
		g.weightx = 1;
		g.gridx = 0;
		g.gridy = 0;
		g.insets = new Insets(50, 50, 50, 0);
		cp.add(jpl, g);
		g.fill = GridBagConstraints.BOTH;
		g.gridx = 1;
		g.gridy = 0;
		g.weightx = 2;
		g.gridwidth = 2;
		g.insets = new Insets(50, 0, 40, 250);
		cp.add(jpl2, g);
		g.fill = GridBagConstraints.NONE;
		g.gridx = 1;
		g.gridy = 1;
		g.insets = new Insets(10, 230, 50, 200);
		cp.add(jbt, g);

		jbt.addActionListener(new ActionListener() {
			String str = "";

			public void actionPerformed(ActionEvent e) {
				switch (i) {
				case 2:
					str = "update usermanagement set userid='" + jtf1.getText() + "'where userid='" + account + "'";
					break;
				case 3:
					str = "update usermanagement set password='" + jtf1.getText() + "'where userid='" + account + "'";
					break;
				case 4:
					str = "update usermanagement set subject='" + jtf1.getText() + "'where userid='" + account + "'";
					break;
				case 5:
					str = "update usermanagement set birthday='" + jtf1.getText() + "'where userid='" + account + "'";
					break;
				case 6:
					str = "update usermanagement set email='" + jtf1.getText() + "'where userid='" + account + "'";
					break;
				case 7:
					str = "update usermanagement set phone='" + jtf1.getText() + "'where userid='" + account + "'";
					break;
				case 8:
					str = "update usermanagement set authority='" + jtf1.getText() + "'where userid='" + account + "'";
					break;

				}
				try {
					DBConnection sq = new DBConnection();
					dbConn = sq.getConn();
					insertStmt = dbConn.createStatement();
					insertStmt.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "修改成功");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}
}
