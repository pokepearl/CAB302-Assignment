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

        if (xcordArr.length == 2) {
            double width = 0;
            double height = 0;
            if (xcordArr[1] > xcordArr[0]) {
                width = xcordArr[1] - xcordArr[0];
                height = ycordArr[1] - ycordArr[0];
                if (!getFillColour().equals("OFF")) {
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

            System.out.println(width);
            System.out.println(height);
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
