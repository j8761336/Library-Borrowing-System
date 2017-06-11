package dandan;

import javax.swing.*;

import java.sql.Statement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
	private GridBagConstraints gbc = new GridBagConstraints();
	private Container cp;
	private final boolean shouldFill = true;
	private JLabel jlbID = new JLabel("ID: ");
	private JLabel jlbPasswd = new JLabel("Password: ");
	private JTextField jtfID = new JTextField();
	private JPasswordField jpwf = new JPasswordField();
	private JButton jbtnExit = new JButton("Exit");
	private JButton jbtnGo = new JButton("Go");
	private Font font1 = new Font("Courier", Font.PLAIN, 20);
	private ResultSet rs;
	private Statement st;
	private Connection cn;

	public Login() {
		initComp();
	}

	private void initComp() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenDimension.width;
		double screenHeight = screenDimension.height;
		int frameWidth = 500, frameHeight = 300;
		this.setBounds((int) screenWidth / 2 - frameWidth / 2, (int) screenHeight / 2 - frameHeight / 2 - 50,
				frameWidth, frameHeight);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.weighty = 1.0;
		gbc.gridx = 1;
		gbc.gridy = 1;
		jlbID.setFont(font1);
		jlbID.setHorizontalAlignment(JLabel.RIGHT);
		cp.add(jlbID, gbc);

		gbc.weighty = 0;
		gbc.gridx = 1;
		gbc.gridy = 2;
		jlbPasswd.setFont(font1);
		cp.add(jlbPasswd, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		jtfID.setPreferredSize(new Dimension(120, 30));
		cp.add(jtfID, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		jpwf.setPreferredSize(new Dimension(120, 30));
		cp.add(jpwf, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weighty = 1.0;
		jbtnExit.setFont(font1);
		jbtnExit.setPreferredSize(new Dimension(40, 30));
		cp.add(jbtnExit, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		jbtnGo.setFont(font1);
		jbtnGo.setPreferredSize(new Dimension(40, 30));
		cp.add(jbtnGo, gbc);
		jbtnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		

		jbtnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection dbCon = new DBConnection();
				String id = jtfID.getText();
				char[] pawd = jpwf.getPassword();
				String str = "";
				for (int i = 0; i < pawd.length; i++) {
					str += pawd[i];
				}
				System.out.println(str);
				try {
					cn = dbCon.getConn();
//					rs = null;
					st = (Statement)cn.createStatement();
					String sqlStr = "select*from usermanagement where userid="+id+ "" ;
					rs = st.executeQuery(sqlStr);
					while (rs.next()) {
						if (rs.getString("password").equals(str)) {
							if (rs.getString("authority").equals("1")) {
								MainFrame1 mf1 = new MainFrame1();
								mf1.setVisible(true);
							}if (rs.getString("authority").equals("2")) {
								MainFrame2 mf2 = new MainFrame2();
								mf2.setVisible(true);
							} if (rs.getString("authority").equals("3")) {
								MainFrame3 mf3 = new MainFrame3();
								mf3.setVisible(true);
							}
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}

		});

		
	}
}
