package graphtabelfile;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new MainFrame();
        frame.setTitle("graph_table_file");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


class MyFunc{
    public static double getMyFunc(double x){
        return Math.sin(x);
    }
    public static String getMyFuncStr(){
        return "sin(x)";
    }
}