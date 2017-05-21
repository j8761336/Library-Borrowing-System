package PenGuin;
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
import javax.swing.JFrame;   
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;  
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;  

public class PieChart extends JFrame{
	
	private DefaultPieDataset result;
	
	public enum Library{
		Chinese("Chinese"),Math("Math"),English("English"),a123("123");
		private String msg; 
		private Library(String msg){
			this.msg=msg;
			}
	}
	public PieChart(String applicationTitle,String ChartTitle){
		super(applicationTitle);
		PieDataset dataset = creatDataset();//這邊建立了餅圖
		JFreeChart chart =creatChart(dataset,ChartTitle);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(700, 300));
		setContentPane(chartPanel);
		setDefaultCloseOperation(PieChart.DISPOSE_ON_CLOSE);

	}
	/*
	 * 修改資料從這邊抓就好
	 */
	private PieDataset creatDataset(){
		result= new DefaultPieDataset();
		result.setValue(Library.Chinese, 25);
		result.setValue(Library.English, 25);
		result.setValue(Library.Math, 25);
		result.setValue(Library.a123, 25);
//		result.setValue(Library.Chinese, 33);
//		result.setValue(Library.English, 33);
//		result.setValue(Library.Math, 33);
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
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;
	}
}
