package paintTool;

import java.util.HashMap;
import java.util.Map;

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
}
