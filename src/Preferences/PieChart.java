package Preferences;
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
import javax.swing.JFrame;   
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;  
import org.jfree.data.general.PieDataset;
//import org.jfree.util.Rotation;  

public class PieChart extends JFrame{
	private float v1;
	private float v2;
	private float v3;
	private float v4;
	private float v5;
	private DefaultPieDataset result;
//	public enum Library{
//		Chinese("Chinese"),Math("Math"),English("English"),
//		Info("Information"),Else("Else")
//		;
//		private String msg; 
//		private Library(String msg){
//			this.msg=msg;
//			}
//	}
	public PieChart(String applicationTitle,String ChartTitle,String[] vrlist,float[] vtl){
		super(applicationTitle);
//		System.out.println(vrlist.length);
		for(int i=0;i<vrlist.length;i++){
			System.out.println(vrlist[i]);
			System.out.println(vtl[i]);
		}
		PieDataset dataset = creatDataset(vrlist,vtl);
		JFreeChart chart =creatChart(dataset,ChartTitle);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(700, 300));
		setContentPane(chartPanel);
		setDefaultCloseOperation(PieChart.DISPOSE_ON_CLOSE);
	}


	

	private PieDataset creatDataset( String[] vrlist, float[] vtl){
		result= new DefaultPieDataset();
		for(int i=0;i<vrlist.length;i++){
			result.setValue(vrlist[i],vtl[i]);
		}
		return result;
	}
	private JFreeChart createChart(PieDataset dataset, String title) {          
        JFreeChart chart = ChartFactory.createPieChart(  
            title,                  // chart title  
            dataset,                // data  
            true,                   // include legend  
            true,  
            false  
        );     
        return chart;          
    }
	private JFreeChart creatChart(PieDataset dataset,String title){
		JFreeChart chart =ChartFactory.createPieChart3D(
				title,
				dataset,
				true,
				true,
				false
				);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(300);
//		plot.setStartAngle(180);
//		plot.setStartAngle(270);
		plot.setForegroundAlpha(0.4f);
		return chart;
	}
}
