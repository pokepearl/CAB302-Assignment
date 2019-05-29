package paintTool;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class ShapePolygon extends Shape{
    private Map<Integer, Integer> points = new LinkedHashMap<>();
    private String ShapeType;
    private int desiredLength = 0;

    @Override
    public void addToArray(int x, int y) {
        points.put(x, y);
        System.out.println("qX " + x);
        System.out.println("qY " + y);
    }

    @Override
    public String printArray() {
        return points.toString();
    }

    @Override
    public void paintComponent(Graphics g) {
        LinkedList<Integer> xcord = points.keySet().stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(xcord.toString());
        int[] xcordArr = generatePointArrayX(xcord);
        Collection<Integer> ycord = points.values();
        int[] ycordArr = generatePointArrayY(ycord);
        //System.out.println(Arrays.toString(xcordArr));
        //System.out.println(Arrays.toString(ycordArr));
        g.setColor(convertHex2RGB(getPenColour()));

            if (getFillColour() != "OFF") {
                g.setColor(convertHex2RGB(getFillColour()));
                g.fillPolygon(xcordArr, ycordArr, xcord.size());
            }
            g.setColor(convertHex2RGB(getPenColour()));
            g.drawPolygon(xcordArr, ycordArr, xcord.size());

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
