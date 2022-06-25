package graphtabelfile;

import javax.swing.JOptionPane;

public class Verify {
    public static double xMin = 0;
    public static double xMax = 10.0;
    public static int n = 100;

    public static int getVerify() {
        String txt1 = WestPanel.getText1();
        String txt2 = WestPanel.getText2();
        String txt3 = WestPanel.getText3();
        try {
            xMin = Double.valueOf(txt1);
        }catch (NumberFormatException e){
            String str = "X min не является числом";
            JOptionPane.showMessageDialog(null, str);
            return -1;
        }
        try {
            xMax = Double.valueOf(txt2);
        }catch (NumberFormatException e){
            String str = "X max не является числом";
            JOptionPane.showMessageDialog(null, str);
            return -1;
        }
        try {
            n = Integer.valueOf(txt3);
        }catch (NumberFormatException e){
            String str = "n не является числом";
            JOptionPane.showMessageDialog(null, str);
            return -1;
        }
        {
            String str = "допустимые значения n от 2 до 1000";
            if (n < 2 || n > 1000){
                JOptionPane.showMessageDialog(null, str);
                return -1;
            }
        }
        {
            String str = "Не допустимые значения: xMax - xMin <= 0";
            if (xMax - xMin <= 0.0){
                JOptionPane.showMessageDialog(null, str);
                return -1;
            }
        }
        return 0;
    }
}
