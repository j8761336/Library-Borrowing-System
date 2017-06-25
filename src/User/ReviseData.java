package User;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dandan.DBConnection;

import java.sql.Statement;

public class ReviseData extends JFrame {
	private String account;
	private String jlbname[] = { "帳號:", "密碼", "系級:", "生日:", "E-mail:", "電話:", "權限" };
	private JLabel jlb[] = new JLabel[7];
	private JLabel jlb2[] = new JLabel[7];
	private JButton jbts[] = new JButton[7];
	private String jbtname = ("修改");
	private JPanel jlbjpl = new JPanel(new GridLayout(7, 1, 30, 30));
	private JPanel jlb2jpl = new JPanel(new GridLayout(7, 1, 30, 30));
	private JPanel jbtjpl = new JPanel(new GridLayout(7, 1, 20, 20));
	private Container cp;
	private Font ft = new Font(null, Font.CENTER_BASELINE, 24);

	private Connection dbConn;
	private ResultSet rs;
	private Statement queryStmt;
	private ResultSetMetaData meta;
	private int set;

	public ReviseData(String str, int a) {
		account = str;
		set = a;
		setVisible(true);
		init();
	}

	private void init() {
		this.setBounds(10, 10, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		this.setTitle("修改資料");
		for (int i = 0; i < 7; i++) {
			jlb[i] = new JLabel(jlbname[i]);
			jlbjpl.add(jlb[i]);
			jlb[i].setFont(ft);
		}
		for (int i = 0; i < 7; i++) {
			jlb2[i] = new JLabel();
			jlb2jpl.add(jlb2[i]);
			jlb2[i].setFont(ft);
		}
		for (int i = 0; i < 7; i++) {
			jbts[i] = new JButton("修改");
			jbtjpl.add(jbts[i]);
			jbts[i].setFont(ft);
		}
		if (set == 1) {
			jlb[6].setVisible(false);
			jlb2[6].setVisible(false);
			jbts[6].setVisible(false);
		}
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 1;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.weightx = 1;
		g.weighty = 1;
		g.fill = GridBagConstraints.NONE;
		g.anchor = GridBagConstraints.WEST;
		g.insets = new Insets(10, 50, 100, 100);
		cp.add(jlbjpl, g);
		g.gridx = 1;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.weightx = 1;
		g.weighty = 1;
		g.fill = GridBagConstraints.NONE;
		g.anchor = GridBagConstraints.CENTER;
		g.insets = new Insets(10, 40, 100, 0);
		cp.add(jlb2jpl, g);
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.weightx = 1;
		g.weighty = 1;
		g.fill = GridBagConstraints.NONE;
		g.anchor = GridBagConstraints.EAST;
		g.insets = new Insets(10, 0, 100, 100);
		cp.add(jbtjpl, g);
		try {
			DBConnection sql = new DBConnection();
			dbConn = sql.getConn();
			queryStmt = (Statement) dbConn.createStatement();
			rs = queryStmt.executeQuery("select * from usermanagement where userid=" + account + "");
			int colCount;
			meta = rs.getMetaData();
			colCount = meta.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < colCount - 1; i++) {
					jlb2[i].setText(rs.getString(i + 2));

				}

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫出錯");
		}
		for (int i = 0; i < 7; i++) {
			int k = i + 2;
			jbts[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Redata rd = new Redata(k, account);
					rd.setVisible(true);
				}
			});
		}
	}
}
