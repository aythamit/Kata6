

package Vista;
import Modelo.Histogram;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class HistogramDisplay <T> extends ApplicationFrame {
    
    private Histogram<T> histogram = new Histogram<>();
    private final String nameEjeX;
    
    public HistogramDisplay(Histogram<T> histo, String name) {
        super("HISTOGRAMA");
        this.histogram = histo;
        nameEjeX = name;
        setContentPane( createPanel() );
        pack();

    }

 

    
    public void execute(){
        setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel panel = new ChartPanel( createChart( createDataset() ));
        panel.setPreferredSize(new Dimension(500,400));
        return panel;
    }
    
     private JFreeChart createChart(DefaultCategoryDataset dataSet) {
         JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart",
                 nameEjeX,"Nº Emails",dataSet,
                 PlotOrientation.VERTICAL,false,true,false);
         
         return chart;
         
     }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
        for (T key : histogram.keySet()) {
            dataset.addValue(histogram.get(key),"",(Comparable) key);
            //dataset.addValue(histogram.getKey(),"",(Comparable)	key);	
            //dataset.addValue(histogram.get(key),"",key);
        }
                
        
        return dataset;
    }
    
    
}
