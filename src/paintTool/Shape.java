package paintTool;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public abstract class Shape {
    private String pencolour = "#000000";
    private String fillcolour = "OFF";

    /**
     * Adds a given set of integers to the x and y point arrays.
     * @param x X Coordinate.
     * @param y Y Coordinate
     */
    public abstract void addToArray(int x, int y);

    /**
     * Converts X Point Array into String.
     * @return String version of the array of X Points.
     */
    public abstract String printArrayX();

    /**
     * Converts Y Point Array into String.
     * @return String version of the array of Y Points.
     */
    public abstract String printArrayY();

    /**
     * Returns the full list of contents stored within the X Point Array.
     * @return LinkedList of the original point array.
     */
    public abstract LinkedList<Integer> returnArrayX();

    /**
     * Returns the full list of contents stored within the X Point Array.
     * @return LinkedList of the original point array.
     */
    public abstract LinkedList<Integer> returnArrayY();

    /**
     * Gets the size of the arrays of points.
     * @return Total number of elements in the array of points.
     */
    public abstract int sizeOfArray();

    /**
     * Sets the shape identifier for the specific element, used in creating VEC instructions.
     * @param value Shape Identifier (ex "RECTANGLE")
     */
    public abstract void setShapeType(String value);

    /**
     * Gets the shape identifier for the element.
     * @return The shape identifier.
     */
    public abstract String getShapeType();

    /**
     * Draws the specific shape on in the Graphics region, setting colours as appropriate.
     * @param g The graphics region of the window section that allows elements to be drawn.
     */
    public abstract void paintComponent(Graphics g);

    /**
     * Generates an integer array based on the LinkedList of x points in a shape.
     * @param xcord LinkedList of X Points.
     * @return integer array of x points.
     */
    public int[] generatePointArrayX(LinkedList<Integer> xcord) {
        int[] xcordArr = new int[xcord.size()]; //Create array with the size of the LinkedList.
        int i = 0;
        for (Integer d: xcord) { //Iterate over LinkedList and add elements to int array.
            xcordArr[i] = d;
            i++;
        }
        return xcordArr;
    }

    /**
     * Generates an integer array based on the LinkedList of y points in a shape.
     * @param ycord LinkedList of Y Points.
     * @return integer array of y points.
     */
    public int[] generatePointArrayY(Collection<Integer> ycord) {
        int[] ycordArr = new int[ycord.size()]; //Create array with the size of the LinkedList.
        int i = 0;
        for (Integer d: ycord) { //Iterate over LinkedList and add elements to int array.
            ycordArr[i] = d;
            i++;
        }
        return ycordArr;
    }

    /**
     * Gets the HEX code of the current pen colour
     * @return HEX code of the pen colour
     */
    public String getPenColour() {
        return pencolour;
    }

    /**
     * Sets the current pen colour.
     * @param hex HEX code of the desired pen colour.
     */
    public void setPenColour(String hex) {
        this.pencolour = hex;
    }

    /**
     * Gets the HEX code of the current fill colour
     * @return HEX code of the fill colour
     */
    public String getFillColour() {
        return fillcolour;
    }

    /**
     * Sets the current fill colour.
     * @param hex HEX code of the desired fill colour.
     */
    public void setFillColour(String hex) {
        this.fillcolour = hex;
    }

    /**
     * Convert a HEX colour code to a Color object for use in graphics drawing.
     * @param hex HEX colour code
     * @return Color object with the equivalent RGB values set based on the HEX.
     */
    public Color convertHex2RGB(String hex) {
        return new Color( //Split HEX code into R,G,B values and convert them to a format Color understands.
                Integer.valueOf(hex.substring(1, 3), 16),
                Integer.valueOf(hex.substring(3, 5), 16),
                Integer.valueOf(hex.substring(5, 7), 16));
    }

    /**
     * Constructs the instruction string for drawing a shape. Designed to be written to a VEC file.
     * @param WindowX Width of the graphics drawing window.
     * @param WindowY Height of the graphics drawing window.
     * @param xcord LinkedList of X coordinates.
     * @param ycord LinkedList of Y coordinates.
     * @return Instruction String for a VEC file (in the format '"IDENTIFIER" X1 Y1...'
     */
    public String vecFileLine(int WindowX, int WindowY, LinkedList<Integer> xcord, LinkedList<Integer> ycord) {
        DecimalFormat df = new DecimalFormat("#.###"); //Set decimal format, trim results to 3 places.
        df.setRoundingMode(RoundingMode.CEILING); //Round up where needed.
        String finalResponse = "";
        finalResponse = finalResponse.concat(getShapeType()); //Add Shape identifier to string.
        for (int i = 0; i < xcord.size(); i++) { //Iterate over array and append decimal values to string.
            double xc1 = (double) xcord.get(i)/ WindowX;
            double yc1 = (double) ycord.get(i)/ WindowY;
            finalResponse = finalResponse.concat(" " + df.format(xc1) + " " + df.format(yc1));
        }
        finalResponse = finalResponse.concat("\n");
        return finalResponse;
    }
}
