package paintTool;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ShapePoint extends Shape{
    private LinkedList<Integer> pointX = new LinkedList<>();
    private LinkedList<Integer> pointY = new LinkedList<>();
    private String ShapeType;

    @Override
    public void addToArray(int x, int y) {
        pointX.add(x);
        pointY.add(y);
    }

    @Override
    public String printArrayX() {
        return pointX.toString();
    }
    @Override
    public String printArrayY() {
        return pointY.toString();
    }

    @Override
    public void paintComponent(Graphics g) {
        int[] xcordArr = generatePointArrayX(pointX);
        int[] ycordArr = generatePointArrayY(pointY);
        g.setColor(convertHex2RGB(getPenColour()));

        if (xcordArr.length == 1) {
            g.drawLine((int) xcordArr[0], (int) ycordArr[0], (int) xcordArr[0], (int) ycordArr[0]);
        }

    }
    @Override
    public LinkedList<Integer> returnArrayX() {
        return pointX;
    }
    @Override
    public LinkedList<Integer> returnArrayY() {
        return pointY;
    }
    @Override
    public int sizeOfArray(){
        return pointX.size();
    }
    @Override
    public void setShapeType(String value) {
        this.ShapeType = value;
    }
    @Override
    public String getShapeType() {
        return ShapeType;
    }
}
