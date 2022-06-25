package graphtabelfile;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;


public class MainFrame extends JFrame {
    private static int height;
    private static int width;
    private Container c;
    private NorthPanel northPanel;
    public MainFrame(){
        setPosition();
        c = getContentPane();
        c.setLayout(new BorderLayout());
        northPanel = new NorthPanel();
        c.add(new WestPanel(), BorderLayout.WEST);
        c.add(new SouthPanel(), BorderLayout.SOUTH);
        c.add(northPanel, BorderLayout.NORTH);
        c.add(new EastPanel(), BorderLayout.EAST);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        northPanel.btn1.addActionListener(new ActionBtn1(c));
        northPanel.btn3.addActionListener(new ActionBtn3(c));
    }
    private void setPosition(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        width = Math.round(0.7f*screenSize.width);
        height = Math.round(0.55f*screenSize.height);
        int top = 0;
        int left = 0;
        setSize(width, height);
        setLocation(top, left);
    }
    public static int getH(){
        return height;
    }
    public static int getW(){
        return width;
    }
}
