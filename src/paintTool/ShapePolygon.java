package paintTool;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class ShapePolygon extends Shape{
    private LinkedList<Integer> pointX = new LinkedList<>();
    private LinkedList<Integer> pointY = new LinkedList<>();
    private String ShapeType;
    private int desiredLength = 0;

    /**
     *
     * @param x X Coordinate.
     * @param y Y Coordinate
     */
    @Override
    public void addToArray(int x, int y) {
        pointX.add(x);
        pointY.add(y);
    }
    /**
     *
     * @return String version of the array of X Points.
     */
    @Override
    public String printArrayX() {
        return pointX.toString();
    }
    /**
     *
     * @return String version of the array of Y Points.
     */
    @Override
    public String printArrayY() {
        return pointY.toString();
    }
    /**
     *
     * @param g The graphics region of the window section that allows elements to be drawn.
     */
    @Override
    public void paintComponent(Graphics g) {
        int[] xcordArr = generatePointArrayX(pointX);
        int[] ycordArr = generatePointArrayY(pointY);
        g.setColor(convertHex2RGB(getPenColour()));
        //ToDo Fix this
        if (!getFillColour().equals("OFF")) { //Check if fill colour isn't set to off and fill if needed.
                g.setColor(convertHex2RGB(getFillColour()));
                g.fillPolygon(xcordArr, ycordArr, getDesiredLength());
            }
            g.setColor(convertHex2RGB(getPenColour()));
            g.drawPolygon(xcordArr, ycordArr, getDesiredLength());

    }
    /**
     *
     * @return LinkedList of the original point array.
     */
    @Override
    public LinkedList<Integer> returnArrayX() {
        return pointX;
    }
    /**
     *
     * @return LinkedList of the original point array.
     */
    @Override
    public LinkedList<Integer> returnArrayY() {
        return pointY;
    }
    /**
     *
     * @return Total number of elements in the array of points.
     */
    @Override
    public int sizeOfArray(){
        return pointX.size();
    }
    /**
     *
     * @param value Shape Identifier (ex "RECTANGLE")
     */
    @Override
    public void setShapeType(String value) {
        this.ShapeType = value;
    }
    /**
     *
     * @return The shape identifier.
     */
    @Override
    public String getShapeType() {
        return ShapeType;
    }

    /**
     * Sets the desired length of a polygon shape.
     * @param length Number of vertices in the polygon.
     */
    public void setDesiredLength(int length) {
        this.desiredLength = length;
    }

    /**
     * Gets the desired length of a polygon.
     * @return Desired number of vertices.
     */
    public int getDesiredLength() {
        return desiredLength;
    }
}
