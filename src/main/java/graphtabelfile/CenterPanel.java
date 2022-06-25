package graphtabelfile;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;

public class CenterPanel extends JPanel {
    public CenterPanel(){
        double xMin = Verify.xMin;
        double xMax = Verify.xMax;
        int n = Verify.n;
        try {
            setLayout(new BorderLayout());
            add(new MakeGraph(xMin, xMax, n));
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Ошибка при построении графика!");
        }
    }
}
