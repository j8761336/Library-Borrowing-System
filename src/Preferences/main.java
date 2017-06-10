package Preferences;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.jfree.ui.RefineryUtilities;

import com.sun.jmx.snmp.Timestamp;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		    PieChart demo = new PieChart("Pie2", "What kind of book do you like?");  
//            demo.pack();  
//            demo.setVisible(true);
            //-----------------------------------
//            BarChart longchart1 = new BarChart("<使用者偏好>");  
//			longchart1.pack();  
//			RefineryUtilities.centerFrameOnScreen(longchart1);  
//			longchart1.setVisible(true);  
		    
		    //-----------------------------------
			String [][] htydata = {{"小說","哈利跌倒","J.K","2017-5-30","遺失"},{"參考書","教你三分鐘寫java","未知","2017-2-30","已歸還"}};
//			String td [][] =  
			BookHistory bst = new BookHistory();
			bst.setVisible(true);
			
			//-----------------------------------
//			Ex2Frame ex2Frm = new Ex2Frame();
//	        ex2Frm.setVisible(true);
			//-----------------------------------
			
//			String data1="INSERT INTO sells VALUES ('104021074','國文類','文學賞析','未知','','館藏')";
					
	}

}
