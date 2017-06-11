package dandan;

import javax.swing.*;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/test?";
	private Connection dbConn;
	Frame frm = null;

	public DBConnection() {
		try {
			Class.forName(driver);
			dbConn = DriverManager.getConnection(url, "root", "123456");
			JOptionPane.showMessageDialog(null, "DB connecction success!!");
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error: " + sqle.toString());
			System.out.println(sqle);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.toString());
		}
	}

	public Connection getConn() {
		return dbConn;
	}

}
