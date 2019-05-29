package paintTool;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ShapeLine extends Shape{
    private Map<Integer, Integer> points = new LinkedHashMap<>();
    private String ShapeType;

    @Override
    public void addToArray(int x, int y) {
        points.put(x, y);
    }

    @Override
    public String printArray() {
        return points.toString();
    }

    @Override
    public void paintComponent(Graphics g) {
        LinkedList<Integer> xcord = getLinkedX();
        int[] xcordArr = generatePointArrayX(xcord);
        LinkedList<Integer> ycord = getLinkedY();
        int[] ycordArr = generatePointArrayY(ycord);
        g.setColor(convertHex2RGB(getPenColour()));

        if (xcordArr.length == 2) {
            g.drawLine(xcordArr[0], ycordArr[0], xcordArr[1], ycordArr[1]);
        }

    }
    @Override
    public Map<Integer, Integer> returnArray() {
        return points;
    }
    @Override
    public int sizeOfArray(){
        return points.size();
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
