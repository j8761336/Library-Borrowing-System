package User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
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

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import dandan.DBConnection;

import java.util.Vector;
import java.sql.Statement;

//
public class SystemUser extends JFrame {
	//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// systemframe sf = new systemframe();
		// sf.setVisible(true);
		SystemUser su = new SystemUser();
		su.setVisible(true);
	}

	private JButton addjbtn = new JButton("新增");
	private JButton revjbtn = new JButton("修改");
	private JButton deljbtn = new JButton("刪除");
	private String jlbstr[] = { "帳號", "密碼", "姓名", "系級", "生日", "email", "電話", "權限", "刪除" };
	private JLabel jlb[] = new JLabel[9];
	// private JLabel accjlb = new JLabel("帳號");
	// private JLabel namejlb = new JLabel("姓名");
	// private JLabel datejlb = new JLabel("日期");
	// private JLabel condijlb = new JLabel("狀態");

	private JScrollPane datajsp;
	private JPanel funcjpl = new JPanel(new GridLayout(4, 1, 5, 20));
	private JPanel jlbjpl = new JPanel(new GridLayout(1, 9, 4, 4));
	private JPanel deljpl = new JPanel();
	private JButton deljbtn2 = new JButton("刪除");
	private JButton revjbtn2 = new JButton("修改");
	private JLabel mainjlb = new JLabel("帳號更動紀錄");
	private Font f1 = new Font(null, Font.BOLD, 16);
	private GridBagConstraints gbc = new GridBagConstraints();
	private Container cp;

	private DefaultTableModel model = new DefaultTableModel();
	public JTable table;
	private Connection dbConn;
	private Statement queryStmt;
	private ResultSet rs;
	private ResultSetMetaData meta;
	public int row = 0;
	public int j = 0;
	private int i = 0;

	public SystemUser() {
		setVisible(true);
		init();
	}

	private void init() {
		this.setBounds(10, 10, 1500, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("系統管理者");
		this.setLayout(new GridBagLayout());
		cp = this.getContentPane();
		table = new JTable(model) {

			public boolean isCellEditable(int row, int column) {
				return false;

			}

		};
		table.getTableHeader().setReorderingAllowed(false);
		// 使儲存格不可移動
		table.setFont(new Font(null, Font.PLAIN, 16));

		// deljpgjbtn.setPreferredSize(new Dimension(30,30));
		// deljpgjbtn.setIcon(icon);
		// deljpgjbtn.setSize(50, 50);
		funcjpl.add(addjbtn);
		funcjpl.add(revjbtn);
		funcjpl.add(deljbtn);
		addjbtn.setFont(f1);
		revjbtn.setFont(f1);
		deljbtn.setFont(f1);
		mainjlb.setFont(f1);
		datajsp = new JScrollPane(table);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 8;
		gbc.insets = new Insets(20, 20, 0, 0);
		cp.add(mainjlb, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		// gbc.gridheight = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(50, 20, 400, 50);
		cp.add(funcjpl, gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 3;
		gbc.weighty = 1;
		gbc.insets = new Insets(0, 0, 200, 100);
		cp.add(datajsp, gbc);

		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		revjbtn2.setVisible(false);
		revjbtn2.setFont(f1);
		gbc.insets = new Insets(400, 500, 0, 50);
		cp.add(revjbtn2, gbc);

		deljpl.add(deljbtn2);
		deljbtn2.setVisible(false);
		deljbtn.setFont(f1);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(600, 150, 0, 40);
		cp.add(deljpl, gbc);

		DBConnection sl = new DBConnection();
		dbConn = sl.getConn();
		try {
			queryStmt = (Statement) dbConn.createStatement();
			rs = queryStmt.executeQuery("select*from userdata");
			while (rs.next()) {
				row++;
			}

			String sqlStr = "select*from Userdata";
			rs = queryStmt.executeQuery(sqlStr);
			meta = rs.getMetaData();
			int count = meta.getColumnCount();
			for (int i = 0; i < 9; i++) {
				jlb[i] = new JLabel(jlbstr[i]);
				jlbjpl.add(jlb[i]);

			}
			for (int i = 0; i < 9; i++) {
				model.addColumn(jlbstr[i]);

			}
			table.setFont(new Font(null, Font.BOLD, 24));
			table.setModel(model);
			// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			// 可自訂表格寬度
			int a = 0;
			while (rs.next()) {

				Vector vc = new Vector();
				for (int i = 0; i < count; i++) {
					vc.addElement(rs.getString(i + 1));
				}

				// vc.addElement(deljpl[a]);
				// a++;
				model.addRow(vc);
				// table.setModel(model);
				table.setCellSelectionEnabled(true);
				datajsp.setBackground(Color.PINK);

			}

			table.setRowHeight(50);
			// 設定Table高度
			table.getTableHeader().setPreferredSize(new Dimension(table.getColumnModel().getTotalColumnWidth(), 50));
			// 表頭寬度設置
			table.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(new JCheckBox()));
			table.setDefaultRenderer(Object.class, new TableCellRenderer() {

				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
					// 判断是否为需要渲染的列
					if (column == 8) {
						// 和方法一基本一致
						JCheckBox box = new JCheckBox();
						box.setSelected(isSelected);
						// 设置单选box.setSelected(hasFocus);
						// box.setHorizontalAlignment((int) CENTER_ALIGNMENT);
						// // 0.5f
						return box;
					}
					// 如果不是需要渲染的列，封装文本域显示数据
					return new JTextArea(value.toString());
				}
			});
			// table.setRowSelectionAllowed(false);
			// table.setColumnSelectionAllowed(false);

			TableColumn tc = table.getColumnModel().getColumn(8);
			tc.setMaxWidth(0);
			tc.setPreferredWidth(0);
			tc.setMinWidth(0);
			tc.setWidth(0);
			table.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
			table.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);

			// int[] ar = table.getSelectedRow();
			// for (int i = 0; i < ar.length; i++) {
			// boolean v = (boolean) model.getValueAt(ar[i], 0);
			//
			//// model.removeRow(ar[i]);
			//
			// System.out.println(ar[i] + " ");
			// }
			// System.out.println(ar);
			// String c=(String) model.getValueAt(2,7);
			// System.out.println(c);

		} catch (SQLException e) {

		}

		addjbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CommonUser cu = new CommonUser();

			}

		});

		deljbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableColumn showdel = table.getColumnModel().getColumn(8);
				showdel.setMaxWidth(100);
				showdel.setPreferredWidth(100);
				showdel.setMinWidth(50);
				showdel.setWidth(50);
				table.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(70);
				table.getTableHeader().getColumnModel().getColumn(8).setMinWidth(50);
				deljbtn2.setVisible(true);
				deljbtn2.setFont(f1);
				deljbtn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int row[] = table.getSelectedRows();
						for (int i = 0; i < row.length; i++) {
							String str = (String) model.getValueAt(row[i], 0);
							model.removeRow(row[i]);
							try {
								queryStmt.executeUpdate("delete from userdata where account=" + str + "");
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "資料庫出錯");
							}
						}
					}

				});

			}

		});
		revjbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableColumn showdel = table.getColumnModel().getColumn(8);
				showdel.setMaxWidth(100);
				showdel.setPreferredWidth(100);
				showdel.setMinWidth(50);
				showdel.setWidth(50);
				table.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(70);
				table.getTableHeader().getColumnModel().getColumn(8).setMinWidth(50);
				revjbtn2.setVisible(true);
				revjbtn2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int row[] = table.getSelectedRows();
						for (int i = 0; i < row.length; i++) {
							String str = (String) model.getValueAt(row[i], 0);
							// ReviseData rd = new ReviseData(str);
							// rd.setVisible(true);
						}
					}
				});

			}

		});

	}

}
