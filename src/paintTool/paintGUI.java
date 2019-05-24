package paintTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

public class paintGUI extends JFrame implements ActionListener, Runnable, MouseListener {
    private static final int WIDTH = 691;
    private static final int HEIGHT = 560;
    private JPanel pnlSidebar;
    private JPanel pnlBottombar;
    public JPanel pnlEditArea;
    private JButton btnDrawPlot = createButton("Plot");
    private JButton btnDrawLine = createButton("Line");
    private JButton btnDrawRect = createButton("Rectangle");
    private JButton btnDrawEcli = createButton("Eclipse");
    private JButton btnDrawPoly = createButton("Polygon");
    private JButton btnDrawUndo = createButton("Undo");
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem clear,save,load;
    private JFileChooser fileSelect = new JFileChooser();

    private long waitTime = 0;

    private ArrayList<Shape> savedObjects = new ArrayList<>();


    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        if (src==btnDrawPlot) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapePoint temp = new ShapePoint();
                temp.setShapeType("POINT");
                savedObjects.add(temp);
            }

        } else if (src==btnDrawLine) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapeLine temp = new ShapeLine();
                temp.setShapeType("LINE");
                savedObjects.add(temp);
            }

        } else if (src==btnDrawRect) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapeRect temp = new ShapeRect();
                temp.setShapeType("RECTANGLE");
                savedObjects.add(temp);
            }

        } else if (src==btnDrawEcli) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapeEclipse temp = new ShapeEclipse();
                temp.setShapeType("ECLIPSE");
                savedObjects.add(temp);
            }

        } else if (src==btnDrawPoly) {

        } else if (src==btnDrawUndo) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 1000;
                int size = savedObjects.size() - 1;
                savedObjects.remove(size);
                repaint();
                for (int i = 0; i < savedObjects.size(); i++) {
                    Shape t2 = savedObjects.get(i);
                    t2.paintComponent(pnlEditArea.getGraphics());
                }
            }

        } else if (src==clear) {
            System.out.println("JM1");
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 1000;
                System.out.println(savedObjects.size());
                savedObjects.clear();
                System.out.println(savedObjects.size());
                repaint();
            }
        } else if (src==save) {
            int resultVal = fileSelect.showSaveDialog(this);
            if (resultVal==JFileChooser.APPROVE_OPTION) {
                File selFile = fileSelect.getSelectedFile();
                FileHandler fileOperation = new FileHandler();
                fileOperation.startSaveFile(selFile, savedObjects, pnlEditArea.getWidth(), pnlEditArea.getHeight());

            }
        } else if (src==load) {
            int resultVal = fileSelect.showOpenDialog(this);
        }

    }
    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        if (waitTime < System.currentTimeMillis()) {
            waitTime = System.currentTimeMillis() + 500;
            int size = savedObjects.size() - 1;
            Shape t2 = savedObjects.get(size);
            if (t2.getShapeType().equals("LINE")) {
                if (t2.sizeOfArray() <= 1) {
                    t2.addToArray(e.getX(), e.getY());
                }

            } else if (t2.getShapeType().equals("POINT")) {
                if (t2.sizeOfArray() < 1) {
                    t2.addToArray(e.getX(), e.getY());
                    System.out.println(t2.printArray());
                }
            }else if (t2.getShapeType().equals("RECTANGLE")) {
                if (t2.sizeOfArray() <= 1) {
                    t2.addToArray(e.getX(), e.getY());
                }
            } else if (t2.getShapeType().equals("ECLIPSE")) {
                if (t2.sizeOfArray() <= 1) {
                    t2.addToArray(e.getX(), e.getY());
                }
            }
            t2.paintComponent(pnlEditArea.getGraphics());
            savedObjects.remove(size);
            savedObjects.add(t2);
        }
    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

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
        pnlEditArea.addMouseListener(this);
        repaint();
        setVisible(true);

    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        file = new JMenu("File");
        clear = new JMenuItem("New");
        save = new JMenuItem("Save");
        load = new JMenuItem("Load");
        file.add(clear);
        file.add(save);
        file.add(load);
        menuBar.add(file);
        clear.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
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

    public static void main(String[] args) {
        paintGUI GUI = new paintGUI();
        GUI.run();
    }

    public int getCanvasX() {
        return pnlEditArea.getWidth();
    }
    public int getCanvasY() {
        return pnlEditArea.getHeight();
    }
}
