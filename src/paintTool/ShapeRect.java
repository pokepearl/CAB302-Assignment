package paintTool;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ShapeRect extends Shape{
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
        int[] xcordArr = generatePointArrayX(pointX);
        int[] ycordArr = generatePointArrayY(pointY);
        if (xcordArr.length == 2) {
            int width = 0;
            int height = 0;
            if (xcordArr[1] > xcordArr[0]) {
                width = xcordArr[1] - xcordArr[0];
                height = ycordArr[1] - ycordArr[0];
                if (!getFillColour().equals("OFF")) {
                    g.setColor(convertHex2RGB(getFillColour()));
                    g.fillRect((int) xcordArr[0], (int) ycordArr[0], (int) width, (int) height);
                }
                g.setColor(convertHex2RGB(getPenColour()));
                g.drawRect((int) xcordArr[0], (int) ycordArr[0], (int) width, (int) height);
            } else {
                width = xcordArr[0] - xcordArr[1];
                height = ycordArr[0] - ycordArr[1];
                if (!getFillColour().equals("OFF")) {
                    g.setColor(convertHex2RGB(getFillColour()));
                    g.fillRect((int) xcordArr[1], (int) ycordArr[1], (int) width, (int) height);
                }
                g.setColor(convertHex2RGB(getPenColour()));
                g.drawRect((int) xcordArr[1], (int) ycordArr[1], (int) width, (int) height);

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
