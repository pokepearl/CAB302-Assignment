package paintTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paintGUI extends JFrame implements ActionListener, Runnable {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;
    private JPanel pnlNavbar;
    private JPanel pnlSidebar;
    private JPanel pnlBottombar;
    private JPanel pnlEditArea;
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {
        createGUI();
    }
    private void createGUI() {
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pnlNavbar = createPanel(Color.GRAY);
        pnlBottombar = createPanel(Color.GRAY);
        pnlSidebar = createPanel(Color.LIGHT_GRAY);
        pnlEditArea = createPanel(Color.WHITE);
        getContentPane().add(pnlNavbar,BorderLayout.NORTH);
        getContentPane().add(pnlBottombar,BorderLayout.SOUTH);
        getContentPane().add(pnlSidebar,BorderLayout.WEST);
        getContentPane().add(pnlEditArea,BorderLayout.CENTER);
        repaint();
        setVisible(true);
    }
    private JPanel createPanel(Color c) {
        JPanel temp = new JPanel();
        temp.setBackground(c);
        return temp;
    }

    public static void main(String[] args) {
        paintGUI GUI = new paintGUI();
        GUI.run();
    }
}
