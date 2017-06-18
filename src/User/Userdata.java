package User;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dandan.DBConnection;

import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

class Userdata extends JFrame {
	private String jlbname[] = { "帳號:", "姓名:", "系級:", "生日:", "email:", "電話:" };
	private JLabel jlb[] = new JLabel[6];
	private JLabel datajlb[] = new JLabel[6];
	private JButton jbtn = new JButton("修改資料");
	private JPanel jlbjpl = new JPanel(new GridLayout(6, 1, 3, 3));
	private JPanel datajlbjpl = new JPanel(new GridLayout(6, 1, 3, 3));
	private Container cp;
	private Font ft = new Font(null, Font.CENTER_BASELINE, 24);

	private Connection dbConn;
	private Statement queryStmt = null;
	private ResultSet rs = null;
	private ResultSetMetaData meta;
	private String Id, Pass;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Userdata rp = new Userdata("1", "1");
		rp.setVisible(true);
	}

	public Userdata(String id, String pass) {
		Id = id;
		Pass = pass;
		setVisible(true);
		DBConnection sc = new DBConnection();
		dbConn = sc.getConn();
		init();

	}

	private void init() {
		this.setBounds(10, 10, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		jbtn.setFont(ft);
		this.setTitle("使用者");
		// datajlbjpl.setBackground(Color.pink);
		for (int i = 0; i < 6; i++) {
			jlb[i] = new JLabel(jlbname[i]);
			jlbjpl.add(jlb[i]);
			jlb[i].setFont(ft);
		}
		for (int i = 0; i < 6; i++) {
			datajlb[i] = new JLabel("", SwingConstants.CENTER);
			datajlbjpl.add(datajlb[i]);
			datajlb[i].setFont(ft);

		}
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.NONE;
		g.anchor = GridBagConstraints.WEST;
		g.weightx = 1;
		g.weighty = 1;
		g.gridx = 0;
		g.gridy = 0;
		g.insets = new Insets(0, 200, 0, 0);
		cp.add(jbtn, g);
		g.fill = GridBagConstraints.BOTH;
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		g.gridheight = 2;
		g.weightx = 1;
		g.weighty = 1;
		g.insets = new Insets(0, 150, 20, 20);
		cp.add(jlbjpl, g);
		g.fill = GridBagConstraints.BOTH;
		g.gridwidth = 2;
		g.weightx = 1;
		g.weighty = 1;
		g.gridx = 1;
		g.gridy = 1;
		g.insets = new Insets(0, 0, 20, 200);

		cp.add(datajlbjpl, g);

		try {
			int colCount;
			rs = getData();
			meta = rs.getMetaData();
			colCount = meta.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < colCount - 2; i++) {
					if (i == 0) {
						datajlb[i].setText(rs.getString(1));
					} else {
						datajlb[i].setText(rs.getString(i + 2));
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "無法顯示資料");

		}
		jbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = 1;
				ReviseData re = new ReviseData(Id, a);
			}

		});

	}

	private ResultSet getData() {
		String sqlStr = "select*from Userdata where account=" + Id + "&&" + "Password=" + Pass + "";
		try {
			queryStmt = (Statement) dbConn.createStatement();
			rs = queryStmt.executeQuery(sqlStr);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料取得失敗");
		}
		return rs;
	}
}
