package Preferences;

import org.jfree.ui.RefineryUtilities;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    PieChart demo = new PieChart("Pie2", "What kind of book do you like?");  
            demo.pack();  
            demo.setVisible(true);
//        BookHistory bst = new BookHistory();
//        bst.setVisible(true);
			LongChart longchart1 = new LongChart("Stacked Bar Chart Demo 1");  
			longchart1.pack();  
			RefineryUtilities.centerFrameOnScreen(longchart1);  
			longchart1.setVisible(true);  
	}

}
