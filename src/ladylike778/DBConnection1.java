package ladylike778;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class DBConnection1 {
	private String driver = "com.mysql.jdbc.Driver";
	private String url ="jdbc:mysql://127.0.0.1:3306/test?"+ "";
	public DBConnection1(String id,String pw){
		try{
//			System.out.println("hi");
			Class.forName(driver);
			System.out.println(driver);
DriverManager.getConnection(url, id, pw);
			System.out.println("hi");
			JOptionPane.showMessageDialog(null,"DB connecction success!!");
		}catch(SQLException sqle){
//			JOptionPane.showMessageDialog(null,"Error: "+ sqle.toString());
			System.out.println(sqle);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error: "+e.toString());
		}
	}
	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
}
