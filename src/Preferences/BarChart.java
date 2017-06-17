package Preferences;
import java.awt.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;
public class BarChart extends ApplicationFrame{
	String [] vrlist;
	float vtl1[];
	public BarChart(String frametitle,String [] vrlist,float vtl1[]){
		super(frametitle);//固定
		this.vrlist=vrlist;
		this.vtl1=vtl1;
//		System.out.println(vrlist.length);
//		for(int i=0;i<vtl1.length;i++){
//		System.out.println(vtl1[i]);
//		}
		JPanel jp1 = createDemoPanel(vrlist,vtl1);
		jp1.setPreferredSize(new Dimension(650,350));//視窗大小
		setContentPane(jp1);
		setDefaultCloseOperation(BarChart.DISPOSE_ON_CLOSE);
	}	
	
	
	private static CategoryDataset createDataset(String [] vrlist,float vtl1[]){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<vtl1.length;i++){
//			dataset.addValue(vtl1[i],vrlist[i],vrlist[i]);
			dataset.addValue(vtl1[i],vrlist[i],vrlist[i]);
		}
//		dataset.addValue(20, "s1", "Math");
//		dataset.addValue(50, "s2", "English");
//		dataset.addValue(10, "s3", "Chinese");
//		dataset.addValue(100, "s4", "a123");
//		dataset.addValue(35, "s1-2", "Math");
//		dataset.addValue(20, "s2-2", "English");
//		dataset.addValue(90, "s2-3", "English");
//		dataset.addValue(50, "s3-1", "Chinese");
		return dataset;
	}
	
	private static JFreeChart createChart(CategoryDataset categorydataset){
//		JFreeChart jfreechart = ChartFactory.createBarChart3D(
		JFreeChart jfreechart = ChartFactory.createStackedBarChart(
				"使用者偏好", "類型", "數量(本)", categorydataset, PlotOrientation.VERTICAL, true, true, false);  
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();  
        categoryplot.setBackgroundPaint(Color.lightGray);  
        categoryplot.setRangeGridlinePaint(Color.white);  
//      BarRenderer stackedbarrenderer = (BarRenderer) categoryplot.getRenderer();
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer) categoryplot.getRenderer();   
        stackedbarrenderer.setBaseItemLabelsVisible(true);  
        stackedbarrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        return jfreechart;
	}
	
	public static JPanel createDemoPanel(String [] vrlist,float vtl1[]){
		JFreeChart jfreechart = createChart(createDataset(vrlist,vtl1));
		return new ChartPanel(jfreechart);
	}
}
