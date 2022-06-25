package graphtabelfile;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class MakeGraph extends JPanel {
    public MakeGraph(double xMin, double xMax, int n){
        XYSeries series1;
        XYDataset xyDataset1;
        String str = MyFunc.getMyFuncStr();
        series1 = new XYSeries(str);
        xyDataset1 = new XYSeriesCollection(series1);
        str = null;
        JFreeChart chart = ChartFactory.createXYLineChart(str, "x", "y",
                xyDataset1, PlotOrientation.VERTICAL, true, true, false);
        double dx = (xMax - xMin) / (n - 1);
        double x, y;
        for (int i=0; i<n; i++){
            x = xMin + dx*i;
            y = MyFunc.getMyFunc(x);
            series1.add(x, y);
        }
        setLayout(new BorderLayout());
        add(new ChartPanel(chart));
    }
}
