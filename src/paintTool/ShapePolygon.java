package paintTool;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class ShapePolygon extends Shape{
    private Map<Integer, Integer> points = new LinkedHashMap<>();
    private LinkedList<Integer> pointX = new LinkedList<>();
    private LinkedList<Integer> pointY = new LinkedList<>();
    private String ShapeType;
    private int desiredLength = 0;

    @Override
    public void addToArray(int x, int y) {
        pointX.add(x);
        pointY.add(y);
        //System.out.println("qX " + x);
        //System.out.println("qY " + y);
    }

    @Override
    public String printArray() {
        return points.toString();
    }

    @Override
    public void paintComponent(Graphics g) {
        //LinkedList<Integer> xcord = getLinkedX();
        //System.out.println(xcord.toString());
        int[] xcordArr = generatePointArrayX(pointX);
        //LinkedList<Integer> ycord = getLinkedY();
        int[] ycordArr = generatePointArrayY(pointY);
        System.out.println(Arrays.toString(xcordArr));
        System.out.println(Arrays.toString(ycordArr));
        g.setColor(convertHex2RGB(getPenColour()));

            if (getFillColour() != "OFF") {
                g.setColor(convertHex2RGB(getFillColour()));
                g.fillPolygon(xcordArr, ycordArr, getDesiredLength());
            }
            g.setColor(convertHex2RGB(getPenColour()));
            g.drawPolygon(xcordArr, ycordArr, getDesiredLength());

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

    public void setDesiredLength(int length) {
        this.desiredLength = length;
    }
    public int getDesiredLength() {
        return desiredLength;
    }
}
