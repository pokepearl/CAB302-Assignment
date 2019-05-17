package paintTool;

import java.awt.*;

public abstract class Shape {
    public abstract void addToArray(double x, double y);
    public abstract String printArray();
    public abstract void paintComponent(Graphics g);
}
