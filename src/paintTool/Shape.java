package paintTool;

import java.awt.*;
import java.util.Collection;
import java.util.Set;

public abstract class Shape {
    public abstract void addToArray(double x, double y);
    public abstract String printArray();
    public abstract int sizeOfArray();
    public abstract void setShapeType(String value);
    public abstract String getShapeType();
    public abstract void paintComponent(Graphics g);
    public double[] generatePointArrayX(Set<Double> xcord) {
        double[] xcordArr = new double[xcord.size()];
        int i = 0;
        for (Double d: xcord) {
            xcordArr[i] = d;
            i++;
        }
        return xcordArr;
    }
    public double[] generatePointArrayY(Collection<Double> ycord) {
        double[] ycordArr = new double[ycord.size()];
        int i = 0;
        for (Double d: ycord) {
            ycordArr[i] = d;
            i++;
        }
        return ycordArr;
    }
}
