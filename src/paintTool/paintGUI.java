package paintTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class paintGUI extends JFrame implements Runnable, MouseListener {
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
    private JButton btnDrawColour = createButton("Pen Colour");
    private JButton btnDrawFill = createButton("Fill Colour");
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem clear,save,load;
    private JFileChooser fileSelect = new JFileChooser();

    private long waitTime = 0;

    public ArrayList<Shape> savedObjects = new ArrayList<>();
    private String lastPenColour = "#000000";
    private String lastFillColour = "OFF";

    private int allowedToEdit = 0;
    private int polygonSize = 0;
    private int buttonBlock = 0;

    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        if (allowedToEdit==1) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                int size = savedObjects.size() - 1;
                Shape t2 = savedObjects.get(size);
                if (t2.getShapeType().equals("LINE")) {
                    if (t2.sizeOfArray() <= 1) {
                        t2.addToArray(e.getX(), e.getY());
                    } else {
                        this.allowedToEdit = 0;
                    }

                } else if (t2.getShapeType().equals("POINT")) {
                    if (t2.sizeOfArray() < 1) {
                        t2.addToArray(e.getX(), e.getY());
                        System.out.println(t2.printArray());
                    } else {
                        this.allowedToEdit = 0;
                    }
                }else if (t2.getShapeType().equals("RECTANGLE")) {
                    if (t2.sizeOfArray() <= 1) {
                        t2.addToArray(e.getX(), e.getY());
                    } else {
                        this.allowedToEdit = 0;
                    }
                } else if (t2.getShapeType().equals("ECLIPSE")) {
                    if (t2.sizeOfArray() <= 1) {
                        t2.addToArray(e.getX(), e.getY());
                    } else {
                        this.allowedToEdit = 0;
                    }
                } else if (t2.getShapeType().equals("POLYGON")) {
                    if (t2.sizeOfArray() <= polygonSize) {
                        t2.addToArray(e.getX(), e.getY());
                    } else {
                        this.allowedToEdit = 0;
                    }

                }
                t2.paintComponent(pnlEditArea.getGraphics());
                savedObjects.remove(size);
                savedObjects.add(t2);
            }
        }

    }
    public void paintObj() {
        System.out.println("Enter Pr");
        Shape temp = savedObjects.get(savedObjects.size() - 1);
        System.out.println("Enter Pr");
        System.out.println(temp.printArray());
        System.out.println(temp.getShapeType());
        temp.paintComponent(pnlEditArea.getGraphics());
        System.out.println("Enter Pr");
        savedObjects.remove(savedObjects.size() - 1);
        System.out.println("Enter Pr");
        savedObjects.add(temp);
        System.out.println("Enter Pr");
        System.out.println("Exit Pr");
    }
    public void mousePressed(MouseEvent e) {
        Object src = e.getSource();
        if (src == btnDrawPlot) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapePoint temp = new ShapePoint();
                temp.setShapeType("POINT");
                temp.setPenColour(lastPenColour);
                temp.setFillColour(lastFillColour);
                savedObjects.add(temp);
                this.allowedToEdit = 1;
            }

        } else if (src == btnDrawLine) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapeLine temp = new ShapeLine();
                temp.setShapeType("LINE");
                temp.setPenColour(lastPenColour);
                temp.setFillColour(lastFillColour);
                savedObjects.add(temp);
                this.allowedToEdit = 1;
            }

        } else if (src == btnDrawRect) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapeRect temp = new ShapeRect();
                temp.setShapeType("RECTANGLE");
                temp.setPenColour(lastPenColour);
                temp.setFillColour(lastFillColour);
                savedObjects.add(temp);
                this.allowedToEdit = 1;
            }

        } else if (src == btnDrawEcli) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapeEllipse temp = new ShapeEllipse();
                temp.setShapeType("ECLIPSE");
                temp.setPenColour(lastPenColour);
                temp.setFillColour(lastFillColour);
                savedObjects.add(temp);
                this.allowedToEdit = 1;
            }

        } else if (src == btnDrawPoly) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 4000;
                this.polygonSize = 0;
                ShapePolygon temp = new ShapePolygon();
                temp.setShapeType("POLYGON");
                String points = JOptionPane.showInputDialog("Enter the desired number of vertices: ");
                temp.setPenColour(lastPenColour);
                temp.setFillColour(lastFillColour);
                savedObjects.add(temp);
                this.polygonSize = Integer.valueOf(points);
                temp.setDesiredLength(Integer.valueOf(points));
                System.out.println(polygonSize);
                this.allowedToEdit = 1;
            }

        } else if (src == btnDrawUndo) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 1000;
                int size = savedObjects.size() - 1;
                //pnlEditArea.getGraphics().dispose();
                savedObjects.remove(size);
                repaint();
                for (int i = 0; i < savedObjects.size(); i++) {
                    Shape t2 = savedObjects.get(i);
                    t2.paintComponent(pnlEditArea.getGraphics());
                }
            }
        } else if (src == btnDrawColour) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 4000;
                String hex = JOptionPane.showInputDialog("Enter Pen Colour Hexadecimal Value: ");
                this.lastPenColour = hex;
            }
        } else if (src == btnDrawFill) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 4000;
                String hex = JOptionPane.showInputDialog("Enter Fil Colour Hexadecimal Value: ");
                this.lastFillColour = hex;
            }
        } else if (src == clear) {
            System.out.println("JM1");
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 1000;
                System.out.println(savedObjects.size());
                savedObjects.clear();
                System.out.println(savedObjects.size());
                repaint();
            }
        } else if (src == save) {
            fileSelect.setFileFilter(new vecFilter());
            int resultVal = fileSelect.showSaveDialog(this);
            if (resultVal == JFileChooser.APPROVE_OPTION) {
                File selFile = fileSelect.getSelectedFile();
                FileHandler fileOperation = new FileHandler();
                fileOperation.startSaveFile(selFile, savedObjects, pnlEditArea.getWidth(), pnlEditArea.getHeight());
            }
        } else if (src == load) {
            fileSelect.setFileFilter(new vecFilter());
            int resultVal = fileSelect.showOpenDialog(this);
            if (resultVal == JFileChooser.APPROVE_OPTION) {
                File selFile = fileSelect.getSelectedFile();
                FileHandler fileOperation = new FileHandler();
                try {
                    startOpenFile(selFile, savedObjects, pnlEditArea.getWidth(), pnlEditArea.getHeight());
                } catch (Exception exte) {

                }


            }
        }
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
        clear.addMouseListener(this);
        save.addMouseListener(this);
        load.addMouseListener(this);
    }
    private void generateSidebarButton() {
        GridBagLayout layout = new GridBagLayout();
        pnlSidebar.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 0;
        constraints.weighty = 0;
        btnDrawPlot.addMouseListener(this);
        btnDrawLine.addMouseListener(this);
        btnDrawRect.addMouseListener(this);
        btnDrawEcli.addMouseListener(this);
        btnDrawPoly.addMouseListener(this);
        btnDrawUndo.addMouseListener(this);
        btnDrawColour.addMouseListener(this);
        btnDrawFill.addMouseListener(this);
        addToPanel(pnlSidebar, btnDrawPlot, constraints, 0, 0, 2, 1);
        addToPanel(pnlSidebar, btnDrawLine, constraints, 0, 1, 2, 1);
        addToPanel(pnlSidebar, btnDrawRect, constraints, 0, 2, 2, 1);
        addToPanel(pnlSidebar, btnDrawEcli, constraints, 0, 3, 2, 1);
        addToPanel(pnlSidebar, btnDrawPoly, constraints, 0, 4, 2, 1);
        addToPanel(pnlSidebar, btnDrawUndo, constraints, 0, 5, 2, 1);
        addToPanel(pnlSidebar, btnDrawColour, constraints, 0, 6, 2, 1);
        addToPanel(pnlSidebar, btnDrawFill, constraints, 0, 7, 2, 1);
    }
    private JPanel createPanel(Color c) {
        JPanel temp = new JPanel();
        temp.setBackground(c);
        return temp;
    }
    private JButton createButton(String str) {
        JButton temp = new JButton(str);
        temp.addMouseListener(this);
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
    public void startOpenFile(File filepath, ArrayList<Shape> shapeArray, int width, int height) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String cache;
        while ((cache = reader.readLine()) != null ) {
            String[] elements = cache.split(" ");
            switch(elements[0]) {
                case "LINE":
                    Shape temp = new ShapeLine();
                    temp.setShapeType("LINE");
                    temp.setPenColour(lastPenColour);
                    temp.setFillColour(lastFillColour);
                    temp.addToArray((int) (width * Double.valueOf(elements[1])), (int) (height * Double.valueOf(elements[2])));
                    temp.addToArray((int) (width * Double.valueOf(elements[3])), (int) (height * Double.valueOf(elements[4])));
                    temp.paintComponent(pnlEditArea.getGraphics());
                    break;
                default:
                    System.out.println("Unsupported");
                    break;
            }
        }
    }
}
