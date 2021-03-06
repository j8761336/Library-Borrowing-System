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
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dandan.DBConnection;

import java.sql.Statement;

class CommonUser extends JFrame {
	private String jblname[] = { "帳號:", "輸入密碼:", "再次輸入密碼:", "系級:", "生日:", "E-Mail:", "電話:", "權限:" };
	private JLabel jbl[] = new JLabel[8];

	private JButton subjbtn = new JButton("送出");
	private JTextField jtf[] = new JTextField[8];
	private JPanel jlbjpl = new JPanel(new GridLayout(8, 1, 3, 3));
	private JPanel jtfjpl = new JPanel(new GridLayout(8, 1, 3, 3));
	private Container cp;
	private Font f1 = new Font(null, Font.CENTER_BASELINE, 24);

	private Connection dbConn;
	private Statement queryStmt, insertStmt;
	private ResultSet rs;
	private ResultSetMetaData meta;

	public CommonUser() {
		setVisible(true);
		init();
	}

	private void init() {
		this.setBounds(10, 10, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		subjbtn.setFont(f1);
		this.setTitle("創建一般使用者");
		for (int i = 0; i < 8; i++) {
			jbl[i] = new JLabel(jblname[i]);
			jlbjpl.add(jbl[i]);
			jbl[i].setFont(f1);

		}
		for (int i = 0; i < 8; i++) {
			jtf[i] = new JTextField();
			jtfjpl.add(jtf[i]);
		}
		GridBagConstraints g = new GridBagConstraints();
		g.weightx = 1;
		g.weighty = 1;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.gridx = 0;
		g.gridy = 0;
		g.insets = new Insets(100, 50, 0, 0);
		g.fill = GridBagConstraints.BOTH;
		g.anchor = GridBagConstraints.WEST;
		cp.add(jlbjpl, g);
		g.insets = new Insets(100, 0, 0, 50);
		g.fill = GridBagConstraints.BOTH;
		g.weightx = 2;
		g.gridwidth = 2;
		g.gridheight = 1;
		g.gridx = 1;
		g.gridy = 0;
		cp.add(jtfjpl, g);
		g.fill = GridBagConstraints.NONE;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.gridx = 1;
		g.gridy = 1;
		g.insets = new Insets(4, 300, 4, 4);
		cp.add(subjbtn, g);

		subjbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jtf[1].getText().equals(jtf[2].getText())) {
					String sqlStr = "insert into usermanagement(userid,password,subject,birthday,email,phone,authority) values"
							+ "('" + jtf[0].getText() + "','" + jtf[1].getText() + "','" + jtf[3].getText() + "','"
							+ jtf[4].getText() + "','" + jtf[5].getText() + "','" + jtf[6].getText() + "','"
							+ jtf[7].getText() + "')";
					try {
						DBConnection sq = new DBConnection();
						dbConn = sq.getConn();
						insertStmt = (Statement) dbConn.createStatement();
						insertStmt.executeUpdate(sqlStr);
						JOptionPane.showMessageDialog(null, "已新增帳號");
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "已有的帳號或系統出錯");

					}

				} else {
					JOptionPane.showMessageDialog(null, "密碼不一致");

				}

			}

		});

	}

}
