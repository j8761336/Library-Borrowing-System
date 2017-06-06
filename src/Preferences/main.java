package Preferences;

import org.jfree.ui.RefineryUtilities;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    PieChart demo = new PieChart("Pie2", "What kind of book do you like?");  
            demo.pack();  
            demo.setVisible(true);
            //-----------------------------------
            BarChart longchart1 = new BarChart("<使用者偏好>");  
			longchart1.pack();  
			RefineryUtilities.centerFrameOnScreen(longchart1);  
			longchart1.setVisible(true);  
		    
		    //-----------------------------------
			String [][] htydata = {{"小說","哈利跌倒","J.K","2017/5/30","遺失"},{"參考書","教你三分鐘寫java","未知","2017/2/30","已歸還"}};
			int count= htydata.length;
			BookHistory bst = new BookHistory(htydata,count);
			bst.setVisible(true);
        
	}

}
