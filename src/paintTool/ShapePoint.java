package paintTool;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class ShapePoint extends Shape{
    private Map<Double, Double> points = new LinkedHashMap<>();
    private String ShapeType;

    @Override
    public void addToArray(double x, double y) {
        points.put(x, y);
    }

    @Override
    public String printArray() {
        return points.toString();
    }

    @Override
    public void paintComponent(Graphics g) {
        Set<Double> xcord = points.keySet().stream().collect(Collectors.toSet());
        double[] xcordArr = generatePointArrayX(xcord);
        Collection<Double> ycord = points.values();
        double[] ycordArr = generatePointArrayY(ycord);
        System.out.println(Arrays.toString(xcordArr));
        System.out.println(Arrays.toString(ycordArr));

        if (xcordArr.length == 1) {
            g.drawLine((int) xcordArr[0], (int) ycordArr[0], (int) xcordArr[0], (int) ycordArr[0]);
        }

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
