package graphtabelfile;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NorthPanel extends JPanel {
    JButton btn1 = new JButton("График + таблица");
    private JButton btn2 = new JButton("Записать в файл");
    JButton btn3 = new JButton("Считать из файла");

    public NorthPanel() {
        add(btn1);
        add(btn2);
        add(btn3);
        ActionListener actionBtn2 = new ActionBtn2();
        btn2.addActionListener(actionBtn2);
    }

    private class ActionBtn2 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (Verify.getVerify() == -1) return;
            writeToFile();
        }
    }

    private void writeToFile() {
        double xMin = Verify.xMin;
        double xMax = Verify.xMax;
        int n = Verify.n;
        RWRandomAccessFile rwRAF = new RWRandomAccessFile(xMin, xMax, n);
        try {
            rwRAF.writeFile();
            JOptionPane.showMessageDialog(null, "Данные записаны в файл!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка при записи в файл! /n" +
                    ex.getMessage());
            Logger.getLogger(ActionBtn2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
class ActionBtn1 implements ActionListener{
    private Container c;
    ActionBtn1(Container c){
        this.c = c;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(Verify.getVerify() == -1) return;
        c.remove(4);
        c.remove(3);
        c.add(new EastPanel(), BorderLayout.EAST);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.validate();
    }
}
class ActionBtn3 implements ActionListener{
    private Container c;
    ActionBtn3(Container c){
        this.c = c;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        readFromFile();
        if(Verify.getVerify() == -1) return;
        c.remove(4);
        c.remove(3);
        c.add(new EastPanel(), BorderLayout.EAST);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.validate();
    }
    private void readFromFile(){
        String xMin, xMax, n;
        double[] y;
        RWRandomAccessFile rwRAF = new RWRandomAccessFile();
        try {
            y = rwRAF.readFile();
            JOptionPane.showMessageDialog(null, "Данные считаны из файла!");
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Ошибка при считывании  файла! /n"+
                    ex.getMessage());
            Logger.getLogger(ActionBtn3.class.getName()).log(Level.SEVERE, null, ex);
        }
        n = Integer.toString(rwRAF.getN());
        xMin = Double.toString(rwRAF.getXmin());
        xMax = Double.toString(rwRAF.getXmax());
        WestPanel.setText1(xMin);
        WestPanel.setText2(xMax);
        WestPanel.setText3(n);
    }
}



