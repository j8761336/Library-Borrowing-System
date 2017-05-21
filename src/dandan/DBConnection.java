package dandan;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String driver = "com.mysql.jdbc.Driver";
	private String url ="jdbc:mysql.//120.108.117.245:3306/csieJava2?useUnicode==true&characterEncoding=utf8";
	private Connection dbConn;
	
	public DBConnection(String id,String pw){
		try{
			Class.forName(driver);
			dbConn = DriverManager.getConnection(url, id, pw);
			JOptionPane.showMessageDialog(null,"DB connecction success!!");
		}catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,"Error: "+ sqle.toString());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error: "+e.toString());
		}
	}
}
