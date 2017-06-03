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
	
	public BarChart(String frametitle){
		super(frametitle);//固定
		JPanel jp1 = createDemoPanel();
		jp1.setPreferredSize(new Dimension(650,350));//視窗大小
		setContentPane(jp1);
	}	
	
	
	private static CategoryDataset createDataset(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(20, "s1", "Math");
		dataset.addValue(50, "s2", "English");
		dataset.addValue(10, "s3", "Chinese");
		dataset.addValue(100, "s4", "a123");
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
	
	public static JPanel createDemoPanel(){
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}
}
