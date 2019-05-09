package paintTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paintGUI extends JFrame implements ActionListener, Runnable {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;
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
        repaint();
        setVisible(true);
    }

    public static void main(String[] args) {
        paintGUI GUI = new paintGUI();
        GUI.run();
    }
}
