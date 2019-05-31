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
import java.util.LinkedList;

public class paintGUI extends JFrame implements Runnable, MouseListener {
    private static final int WIDTH = 691;
    private static final int HEIGHT = 580;
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
    private int runClear = 0;

    /**
     * Given a mouse click inside the window, determine which part of the window was selected and act accordingly.
     * @param e MouseEvent registered to specific UI elements.
     */
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

                } else if (t2.getShapeType().equals("PLOT")) {
                    if (t2.sizeOfArray() < 1) {
                        t2.addToArray(e.getX(), e.getY());
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

    /**
     * Determine which operation to perform when one of the mouse buttons is pressed down.
     * @param e MouseEvent registered to specific UI elements.
     */
    public void mousePressed(MouseEvent e) {
        Object src = e.getSource();
        if (src == btnDrawPlot) {
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 500;
                ShapePoint temp = new ShapePoint();
                temp.setShapeType("PLOT");
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
            if (waitTime < System.currentTimeMillis()) {
                waitTime = System.currentTimeMillis() + 1000;
                savedObjects.clear();
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
                if (runClear == 1) {
                    this.savedObjects.clear();
                    repaint();
                    this.runClear = 0;
                }
                File selFile = fileSelect.getSelectedFile();
                try {
                    startOpenFile(selFile, savedObjects, pnlEditArea.getWidth(), pnlEditArea.getHeight());
                } catch (Exception exte) {

                }


            }
        }
    }

    /**
     * Check if mouse button has been released. Not used, only implemented as required by the Extend.
     * @param e MouseEvent registered to specific UI elements.
     */
    public void mouseReleased(MouseEvent e) {

    }
    /**
     * Check if mouse has entered a specific region. Not used, only implemented as required by the Extend.
     * @param e MouseEvent registered to specific UI elements.
     */
    public void mouseEntered(MouseEvent e) {

    }
    /**
     * Check if mouse has left a specific region. Not used, only implemented as required by the Extend.
     * @param e MouseEvent registered to specific UI elements.
     */
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Initial render function, initialises the UI and sidebar.
     */
    @Override
    public void run() {
        createGUI();
        generateSidebarButton();
    }

    /**
     * Creates the base elements of the UI. Initialises the BorderLayout, creates the panels, adds the MenuBar and
     * the appropriate listeners.
     */
    private void createGUI() {
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pnlBottombar = createPanel(Color.GRAY);
        pnlSidebar = createPanel(Color.LIGHT_GRAY);
        pnlEditArea = createPanel(Color.WHITE);
        getContentPane().add(pnlSidebar,BorderLayout.WEST);
        getContentPane().add(pnlEditArea,BorderLayout.CENTER);
        createMenuBar();
        setJMenuBar(menuBar);
        pnlEditArea.addMouseListener(this);
        repaint();
        setVisible(true);

    }

    /**
     * Creates the MenuBar and its sub-items, links them together and attaches the Mouse Listener
     */
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

    /**
     * Constructs the GridBagLayout of sidebar buttons, attaches the Mouse Listener and adds them to the panel.
     */
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

    /**
     * Creates a JPanel object for the main UI and sets the background colour.
     * @param c Desired Color of the panel.
     * @return JPanel object with the appropriate background colour.
     */
    private JPanel createPanel(Color c) {
        JPanel temp = new JPanel();
        temp.setBackground(c);
        return temp;
    }

    /**
     * Creates a JButton object with the specified text.
     * @param str Desired text to be displayed on the button.
     * @return JButton object with the appropriate text.
     */
    private JButton createButton(String str) {
        JButton temp = new JButton(str);
        temp.addMouseListener(this);
        return temp;
    }

    /**
     * Attaches a given component to a panel object within certain constraints.
     * @param jp The JPanel to attach the object to.
     * @param c The component to be attached to the panel.
     * @param constraints GridBsgConstraints element containing the positioning for the component.
     * @param x X Position within the panel.
     * @param y Y Position within the panel.
     * @param w Width of the component within the panel.
     * @param h Height of the component within the panel.
     */
    private void addToPanel(JPanel jp,Component c, GridBagConstraints constraints,int x, int y, int w, int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        jp.add(c, constraints);
    }

    /**
     * Main Function, creates a paintGUI option and runs the run function.
     * @param args Parameters.
     */
    public static void main(String[] args) {
        paintGUI GUI = new paintGUI();
        GUI.run();
    }

    /**
     * Opens a file to read from and creates shapes based on the lines within the file.
     * @param filepath File object containing the path to the file holding the instructions.
     * @param shapeArray Array to store the created shapes in.
     * @param width Width of the canvas region the shapes are drawn in.
     * @param height Height of the canvas region the shapes are drawn in.
     * @throws Exception General exception thrown if an issue occurs with the BufferedReader
     */
    public void startOpenFile(File filepath, ArrayList<Shape> shapeArray, int width, int height) throws Exception {
        this.lastPenColour = "#000000";
        this.lastFillColour = "OFF";
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String cache;
        while ((cache = reader.readLine()) != null ) {
            String[] elements = cache.split(" ");
            elements[0] = elements[0].toUpperCase();
            switch(elements[0]) {
                case "PEN":
                    this.lastPenColour = elements[1];
                    break;
                case "FILL":
                    this.lastFillColour = elements[1];
                    break;
                case "LINE":
                    Shape tempLine = new ShapeLine();
                    tempLine.setShapeType("LINE");
                    tempLine.setPenColour(lastPenColour);
                    tempLine.setFillColour(lastFillColour);
                    tempLine.addToArray((int) (width * Double.valueOf(elements[1])), (int) (height * Double.valueOf(elements[2])));
                    tempLine.addToArray((int) (width * Double.valueOf(elements[3])), (int) (height * Double.valueOf(elements[4])));
                    tempLine.paintComponent(pnlEditArea.getGraphics());
                    shapeArray.add(tempLine);
                    break;
                case "ELLIPSE":
                    Shape tempEllipse = new ShapeEllipse();
                    tempEllipse.setShapeType("ELLIPSE");
                    tempEllipse.setPenColour(lastPenColour);
                    tempEllipse.setFillColour(lastFillColour);
                    tempEllipse.addToArray((int) (width * Double.valueOf(elements[1])), (int) (height * Double.valueOf(elements[2])));
                    tempEllipse.addToArray((int) (width * Double.valueOf(elements[3])), (int) (height * Double.valueOf(elements[4])));
                    tempEllipse.paintComponent(pnlEditArea.getGraphics());
                    shapeArray.add(tempEllipse);
                    break;
                case "POLYGON":
                    ShapePolygon tempPoly = new ShapePolygon();
                    tempPoly.setShapeType("POLYGON");
                    tempPoly.setPenColour(lastPenColour);
                    tempPoly.setFillColour(lastFillColour);
                    LinkedList<Integer> xcord = new LinkedList<>();
                    LinkedList<Integer> ycord = new LinkedList<>();
                    String[] localElement = new String[elements.length-1];

                    for (int i = 1; i < elements.length; i++) {
                        localElement[i-1] = elements[i];
                    }
                    int polySize = localElement.length;
                    for (int i = 0; i < polySize; i++) {
                        if ((i & 1) == 0 ) {
                            xcord.add((int) (width * Double.valueOf(localElement[i])));
                        } else {
                            ycord.add((int) (height * Double.valueOf(localElement[i])));
                        }
                    }
                    for (int i = 0; i<xcord.size(); i++) {
                        tempPoly.addToArray(xcord.get(i), ycord.get(i));
                    }
                    tempPoly.setDesiredLength(polySize / 2);
                    tempPoly.paintComponent(pnlEditArea.getGraphics());
                    shapeArray.add(tempPoly);
                    break;
                case "RECTANGLE":
                    Shape tempRect = new ShapeRect();
                    tempRect.setShapeType("RECTANGLE");
                    tempRect.setPenColour(lastPenColour);
                    tempRect.setFillColour(lastFillColour);
                    tempRect.addToArray((int) (width * Double.valueOf(elements[1])), (int) (height * Double.valueOf(elements[2])));
                    tempRect.addToArray((int) (width * Double.valueOf(elements[3])), (int) (height * Double.valueOf(elements[4])));
                    tempRect.paintComponent(pnlEditArea.getGraphics());
                    shapeArray.add(tempRect);
                    break;
                case "PLOT":
                    Shape tempPlot = new ShapePoint();
                    tempPlot.setShapeType("PLOT");
                    tempPlot.setPenColour(lastPenColour);
                    tempPlot.setFillColour(lastFillColour);
                    tempPlot.addToArray((int) (width * Double.valueOf(elements[1])), (int) (height * Double.valueOf(elements[2])));
                    tempPlot.paintComponent(pnlEditArea.getGraphics());
                    shapeArray.add(tempPlot);
                    break;
                default:
                    System.out.println("Unsupported");
                    break;
            }
        }
    }
}
