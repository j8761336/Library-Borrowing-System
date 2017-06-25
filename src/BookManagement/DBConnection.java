package BookManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSetMetaData;

public class DBConnection {
//	private String driver = "com.mysql.jdbc.Driver";
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncodeing=utf8";
	private Connection dbConn;
	private MainFrame frm;
	
	public DBConnection(MainFrame frm1, String id, String pw){
		try{
			Class.forName(driver);
			dbConn = DriverManager.getConnection(url, id, pw);
//			JOptionPane.showMessageDialog(frm, "Data connect sucess!");
		}catch(SQLException ex){
			System.out.println(ex.toString());
			JOptionPane.showMessageDialog(frm, ex.toString());
		}catch(Exception ex){
			JOptionPane.showMessageDialog(frm, ex.toString());
		}
	}
	public ResultSet getBookData(){
		ResultSet rs = null;
		try{
			Statement stm = dbConn.createStatement();
			String sqlStr = "select * from bookmanagement";
			rs = stm.executeQuery(sqlStr);
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(frm, ex.toString());
		}
		return rs;
	}
	public int getBookRowCount(){
		int rowCount = 0;
		try{
			ResultSetMetaData meta;
			ResultSet rs;
			rs = this.getBookData();
			meta = rs.getMetaData();
			while(rs.next()){rowCount++;}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		return rowCount;
	}
	public ResultSet getCategoryData(){
		ResultSet rs = null;
		try{
			Statement stm = dbConn.createStatement();
			String sqlStr = "select * from categorydata1";
			rs = stm.executeQuery(sqlStr);
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(frm, ex.toString());
		}
		return rs;
	}
	public int getCategoryRowCount(){
		int rowCount = 0;
		try{
			ResultSetMetaData meta;
			ResultSet rs;
			rs = this.getCategoryData();
			meta = rs.getMetaData();
			while(rs.next()){rowCount++;}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		return rowCount;
	}
	public void newCategory(String sum){
		try{
	        String query="INSERT INTO `categorydata1` (`id`, `category`) VALUES (NULL, '" + sum + "');";
	        Statement stmt = dbConn.createStatement();
	        stmt.executeUpdate(query);
	        JOptionPane.showMessageDialog(frm,"新增成功");
	    }catch (Exception ex) {
	        	JOptionPane.showMessageDialog(frm, ex.toString());
	    }
	}
	public void newBook(String bookname, String auther, String category){
		try{
	        String query="INSERT INTO `bookmanagement` (`id`, `category`, `booktitle`, `author`, `status`) VALUES (NULL, '" + bookname + "', '" + auther + "', '" + category + "', 'save');";
	        Statement stmt = dbConn.createStatement();
	        stmt.executeUpdate(query);
	        JOptionPane.showMessageDialog(frm,"新增成功");
	    }catch (Exception ex) {
	        	JOptionPane.showMessageDialog(frm, ex.toString());
	    }
	}
	public void deleteBook(int id){
		try{
	        String query="DELETE FROM `bookmanagement` WHERE `bookmanagement`.`id` = " + id;
	        Statement stmt = dbConn.createStatement();
	        stmt.executeUpdate(query);
	        JOptionPane.showMessageDialog(frm,"刪除成功");
	    }catch (Exception ex) {
	        	JOptionPane.showMessageDialog(frm, ex.toString());
	    }
	}
}