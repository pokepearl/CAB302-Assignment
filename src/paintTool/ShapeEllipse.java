package paintTool;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ShapeEllipse extends Shape{
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
        LinkedList<Double> xcord = points.keySet().stream().collect(Collectors.toCollection(LinkedList::new));
        double[] xcordArr = generatePointArrayX(xcord);
        Collection<Double> ycord = points.values();
        double[] ycordArr = generatePointArrayY(ycord);
        System.out.println(Arrays.toString(xcordArr));
        System.out.println(Arrays.toString(ycordArr));

        if (xcordArr.length == 2) {
            double width = 0;
            double height = 0;
            if (xcordArr[1] > xcordArr[0]) {
                width = xcordArr[1] - xcordArr[0];
                height = ycordArr[1] - ycordArr[0];
                g.drawOval((int) xcordArr[0], (int) ycordArr[0], (int) width, (int) height);
            } else {
                width = xcordArr[0] - xcordArr[1];
                height = ycordArr[0] - ycordArr[1];
                g.drawOval((int) xcordArr[1], (int) ycordArr[1], (int) width, (int) height);

            }

            System.out.println(width);
            System.out.println(height);
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
    @Override
    public String vecFileLine(int WindowX, int WindowY) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(WindowX);
        System.out.println(WindowY);
        LinkedList<Double> xcord = points.keySet().stream().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Double> ycord = points.values().stream().collect(Collectors.toCollection(LinkedList::new));
        String finalResponse = "";
        finalResponse = finalResponse.concat(getShapeType());
        for (int i = 0; i < xcord.size(); i++) {
            finalResponse = finalResponse.concat(" " + df.format(xcord.get(i) / WindowX) + " " + df.format(ycord.get(i) / WindowY));
        }
        return finalResponse;
    }
}
