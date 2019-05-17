package paintTool;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class ShapeLine extends Shape{
    private Map<Double, Double> points = new HashMap<>();

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
        double[] xcordArr = new double[xcord.size()];
        Collection<Double> ycord = points.values();
        int i = 0;
        for (Double d: xcord) {
            xcordArr[i] = d;
            i++;
        }
        System.out.println(Arrays.toString(xcordArr));
        double[] ycordArr = new double[ycord.size()];
        int o = 0;
        for (Double d: ycord) {
            ycordArr[o] = d;
            o++;
        }
        System.out.println(Arrays.toString(ycordArr));
        //g.drawLine();
    }
}
