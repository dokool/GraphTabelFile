package graphtabelfile;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class WestPanel extends JPanel {
    private static JTextField txt1 = new JTextField("0");
    private static JTextField txt2 = new JTextField("10");
    private static JTextField txt3 = new JTextField("100");
    public WestPanel() {
        int row = 3, col = 2, hgap = 0, vgap = 20;
        int w = Math.round(0.2f*MainFrame.getW());
        int h = Math.round(0.3f*MainFrame.getH());
        JPanel jp = new JPanel();
        jp.setBorder(new TitledBorder("Данные"));
        jp.setPreferredSize(new Dimension(w, h));
        jp.setLayout(new GridLayout(row, col, hgap, vgap));
        JLabel lbl1 = new JLabel("X min");
        JLabel lbl2 = new JLabel("X max");
        JLabel lbl3 = new JLabel("кол. точек (>1)");
        jp.add(lbl1);
        jp.add(txt1);
        jp.add(lbl2);
        jp.add(txt2);
        jp.add(lbl3);
        jp.add(txt3);
        add(jp);
    }
    public static String getText1(){return txt1.getText();}
    public static String getText2(){return txt2.getText();}
    public static String getText3(){return txt3.getText();}
    public static void setText1(String str) {txt1.setText(str);}
    public static void setText2(String str) {txt2.setText(str);}
    public static void setText3(String str) {txt3.setText(str);}
}
