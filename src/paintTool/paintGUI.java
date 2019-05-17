package paintTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class paintGUI extends JFrame implements ActionListener, Runnable {
    private static final int WIDTH = 691;
    private static final int HEIGHT = 560;
    private JPanel pnlSidebar;
    private JPanel pnlBottombar;
    private JPanel pnlEditArea;
    private JButton btnDrawPlot = createButton("Plot");
    private JButton btnDrawLine = createButton("Line");
    private JButton btnDrawRect = createButton("Rectangle");
    private JButton btnDrawEcli = createButton("Eclipse");
    private JButton btnDrawPoly = createButton("Polygon");
    private JButton btnDrawUndo = createButton("Undo");
    private JMenuBar menuBar;
    private JMenu JM1, JM2, JM3;
    private long waitTime = 0;

    ArrayList<Shape> savedObjects = new ArrayList<>();


    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        if (src==btnDrawPlot) {

        } else if (src==btnDrawLine) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapeLine temp = new ShapeLine();
                temp.addToArray(10, 20);
                temp.addToArray(400, 350);
                System.out.println(temp.printArray());
                //drawLine(10, 10, 400, 400);
                temp.paintComponent(pnlEditArea.getGraphics());
            }

        } else if (src==btnDrawRect) {

        } else if (src==btnDrawEcli) {

        } else if (src==btnDrawPoly) {

        } else if (src==btnDrawUndo) {

        } else if (src==JM1) {

        } else if (src==JM2) {

        } else if (src==JM3) {

        }

    }

    @Override
    public void run() {
        createGUI();
        generateSidebarButton();
        System.out.println(pnlSidebar.getWidth());
        System.out.println(pnlEditArea.getWidth());
        System.out.println(pnlEditArea.getHeight());
    }
    private void createGUI() {
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pnlBottombar = createPanel(Color.GRAY);
        pnlSidebar = createPanel(Color.LIGHT_GRAY);
        pnlEditArea = createPanel(Color.WHITE);
        //getContentPane().add(pnlBottombar,BorderLayout.SOUTH);
        getContentPane().add(pnlSidebar,BorderLayout.WEST);
        getContentPane().add(pnlEditArea,BorderLayout.CENTER);
        createMenuBar();
        setJMenuBar(menuBar);
        repaint();
        setVisible(true);

    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        JM1 = new JMenu("New");
        JM2 = new JMenu("Save");
        JM3 = new JMenu("Load");
        menuBar.add(JM1);
        menuBar.add(JM2);
        menuBar.add(JM3);
        JM1.addActionListener(this);
        JM2.addActionListener(this);
        JM3.addActionListener(this);
    }
    private void generateSidebarButton() {
        GridBagLayout layout = new GridBagLayout();
        pnlSidebar.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 0;
        constraints.weighty = 0;
        btnDrawPlot.addActionListener(this);
        btnDrawLine.addActionListener(this);
        btnDrawRect.addActionListener(this);
        btnDrawEcli.addActionListener(this);
        btnDrawPoly.addActionListener(this);
        btnDrawUndo.addActionListener(this);
        addToPanel(pnlSidebar, btnDrawPlot, constraints, 0, 0, 2, 1);
        addToPanel(pnlSidebar, btnDrawLine, constraints, 0, 1, 2, 1);
        addToPanel(pnlSidebar, btnDrawRect, constraints, 0, 2, 2, 1);
        addToPanel(pnlSidebar, btnDrawEcli, constraints, 0, 3, 2, 1);
        addToPanel(pnlSidebar, btnDrawPoly, constraints, 0, 4, 2, 1);
        addToPanel(pnlSidebar, btnDrawUndo, constraints, 0, 5, 2, 1);
    }
    private JPanel createPanel(Color c) {
        JPanel temp = new JPanel();
        temp.setBackground(c);
        return temp;
    }
    private JButton createButton(String str) {
        JButton temp = new JButton(str);
        temp.addActionListener(this);
        return temp;
    }
    private void addToPanel(JPanel jp,Component c, GridBagConstraints constraints,int x, int y, int w, int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        jp.add(c, constraints);
    }
    private void drawLine(int x1,int y1,int x2,int y2) {
        Graphics g = pnlEditArea.getGraphics();
        g.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        paintGUI GUI = new paintGUI();
        GUI.run();
    }
}
