package paintTool;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ShapeRect extends Shape{
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
        LinkedList<Integer> xcord = points.keySet().stream().collect(Collectors.toCollection(LinkedList::new));
        int[] xcordArr = generatePointArrayX(xcord);
        Collection<Integer> ycord = points.values();
        int[] ycordArr = generatePointArrayY(ycord);
        System.out.println(Arrays.toString(xcordArr));
        System.out.println(Arrays.toString(ycordArr));
        if (xcordArr.length == 2) {
            double width = 0;
            double height = 0;
            if (xcordArr[1] > xcordArr[0]) {
                width = xcordArr[1] - xcordArr[0];
                height = ycordArr[1] - ycordArr[0];
                if (getFillColour() != "OFF") {
                    g.setColor(convertHex2RGB(getFillColour()));
                    g.fillRect((int) xcordArr[0], (int) ycordArr[0], (int) width, (int) height);
                }
                g.setColor(convertHex2RGB(getPenColour()));
                g.drawRect((int) xcordArr[0], (int) ycordArr[0], (int) width, (int) height);
            } else {
                width = xcordArr[0] - xcordArr[1];
                height = ycordArr[0] - ycordArr[1];
                if (getFillColour() != "OFF") {
                    g.setColor(convertHex2RGB(getFillColour()));
                    g.fillRect((int) xcordArr[1], (int) ycordArr[1], (int) width, (int) height);
                }
                g.setColor(convertHex2RGB(getPenColour()));
                g.drawRect((int) xcordArr[1], (int) ycordArr[1], (int) width, (int) height);

            }

            System.out.println(width);
            System.out.println(height);
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
