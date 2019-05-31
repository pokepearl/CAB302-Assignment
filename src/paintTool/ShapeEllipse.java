package paintTool;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ShapeEllipse extends Shape{
    private LinkedList<Integer> pointX = new LinkedList<>();
    private LinkedList<Integer> pointY = new LinkedList<>();
    private String ShapeType;

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
        int[] xcordArr = generatePointArrayX(pointX); //Convert LinkedList points to integer array.
        int[] ycordArr = generatePointArrayY(pointY);
        g.setColor(convertHex2RGB(getPenColour())); //Set pen colour to the local pen colour

        if (xcordArr.length == 2) { //If array of points meets the minimum size, draw it.
            double width = 0;
            double height = 0;
            if (xcordArr[1] > xcordArr[0]) {
                width = xcordArr[1] - xcordArr[0];
                height = ycordArr[1] - ycordArr[0];
                if (!getFillColour().equals("OFF")) { //Check if fill colour isn't set to off and fill if needed.
                    g.setColor(convertHex2RGB(getFillColour()));
                    g.fillOval((int) xcordArr[0], (int) ycordArr[0], (int) width, (int) height);
                }
                g.setColor(convertHex2RGB(getPenColour()));
                g.drawOval((int) xcordArr[0], (int) ycordArr[0], (int) width, (int) height);
            } else {
                width = xcordArr[0] - xcordArr[1];
                height = ycordArr[0] - ycordArr[1];
                if (!getFillColour().equals("OFF")) {
                    g.setColor(convertHex2RGB(getFillColour()));
                    g.fillOval((int) xcordArr[1], (int) ycordArr[1], (int) width, (int) height);
                }
                g.setColor(convertHex2RGB(getPenColour()));
                g.drawOval((int) xcordArr[1], (int) ycordArr[1], (int) width, (int) height);

            }
        }

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
}
