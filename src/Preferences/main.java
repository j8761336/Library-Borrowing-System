package Preferences;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
//			String [][] htydata = {{"小說","哈利跌倒","J.K","2017-5-30","遺失"},{"參考書","教你三分鐘寫java","未知","2017-2-30","已歸還"}};
//			String td [][] =  
			BookHistory bst = new BookHistory();
			bst.setVisible(true);
			
			//-----------------------------------
//			Ex2Frame ex2Frm = new Ex2Frame();
//	        ex2Frm.setVisible(true);
			//-----------------------------------
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//			String data1="INSERT INTO sells VALUES ('104021074','國文類','文學賞析','未知','','館藏')";
			Calendar calendar = new GregorianCalendar(2016, 6-1, 10,0,0,0);
			Date date = calendar.getTime();  
			String dts1 = sdf.format(date);
//			System.out.println(dts1);
			//先行定義時間格式
			
			//取得現在時間
			Date dt=new Date();
			//透過SimpleDateFormat的format方法將Date轉為字串
			String dts=sdf.format(dt);
//			System.out.println(dts);
			Calendar cal = Calendar.getInstance();
//			while(cal!=calendar){
//				Date tmpda = cal.getTime(); 
//				String tmp = sdf.format(tmpda);
//				System.out.println(tmp);
//				cal.add(Calendar.DAY_OF_MONTH, -1);
//			}
			
//			for(int i=0;i<10;i++){
//				cal.add(Calendar.DAY_OF_MONTH, -1);
//				Date tmpda = cal.getTime();
//				String tmp = sdf.format(tmpda);
//				System.out.println(tmp);
//			}
			Date tmpda = cal.getTime();
			//day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
			long day=((dt.getTime() - date.getTime())/86400000);
//			System.out.println(day);
	}

}
