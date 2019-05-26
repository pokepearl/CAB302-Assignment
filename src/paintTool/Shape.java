package paintTool;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Shape {
    private String pencolour = "#000000";
    private String fillcolour = "#000000";
    public abstract void addToArray(double x, double y);
    public abstract String printArray();
    public abstract Map<Double, Double> returnArray();
    public abstract int sizeOfArray();
    public abstract void setShapeType(String value);
    public abstract String getShapeType();
    public abstract void paintComponent(Graphics g);
    public double[] generatePointArrayX(LinkedList<Double> xcord) {
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
    public LinkedList<Double> getLinkedX() {
        return returnArray().keySet().stream().collect(Collectors.toCollection(LinkedList::new));
    }
    public LinkedList<Double> getLinkedY() {
        return returnArray().values().stream().collect(Collectors.toCollection(LinkedList::new));
    }
    public String getPenColour() {
        return pencolour;
    }
    public void setPenColour(String hex) {
        this.pencolour = hex;
    }
    public String getFillColour() {
        return fillcolour;
    }
    public void setFillColour(String hex) {
        this.fillcolour = hex;
    }
    public Color convertHex2RGB(String hex) {
        return new Color(
                Integer.valueOf(hex.substring(1, 3), 16),
                Integer.valueOf(hex.substring(3, 5), 16),
                Integer.valueOf(hex.substring(5, 7), 16));
    }

    public String vecFileLine(int WindowX, int WindowY, LinkedList<Double> xcord, LinkedList<Double> ycord) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(WindowX);
        System.out.println(WindowY);
        String finalResponse = "";
        finalResponse = finalResponse.concat(getShapeType());
        for (int i = 0; i < xcord.size(); i++) {
            finalResponse = finalResponse.concat(" " + df.format(xcord.get(i) / WindowX) + " " + df.format(ycord.get(i) / WindowY));
        }
        return finalResponse;
    }
}
