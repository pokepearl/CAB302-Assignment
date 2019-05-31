package paintTool;

import java.awt.*;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Shape {
    private String pencolour = "#000000";
    private String fillcolour = "OFF";
    public abstract void addToArray(int x, int y);
    public abstract String printArrayX();
    public abstract String printArrayY();
    public abstract LinkedList<Integer> returnArrayX();
    public abstract LinkedList<Integer> returnArrayY();
    public abstract int sizeOfArray();
    public abstract void setShapeType(String value);
    public abstract String getShapeType();
    public abstract void paintComponent(Graphics g);
    public int[] generatePointArrayX(LinkedList<Integer> xcord) {
        int[] xcordArr = new int[xcord.size()];
        int i = 0;
        for (Integer d: xcord) {
            xcordArr[i] = d;
            i++;
        }
        return xcordArr;
    }
    public int[] generatePointArrayY(Collection<Integer> ycord) {
        int[] ycordArr = new int[ycord.size()];
        int i = 0;
        for (Integer d: ycord) {
            ycordArr[i] = d;
            i++;
        }
        return ycordArr;
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

    public String vecFileLine(int WindowX, int WindowY, LinkedList<Integer> xcord, LinkedList<Integer> ycord) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(WindowX);
        System.out.println(WindowY);
        String finalResponse = "";
        finalResponse = finalResponse.concat(getShapeType());
        for (int i = 0; i < xcord.size(); i++) {
            finalResponse = finalResponse.concat(" " + df.format(xcord.get(i) / WindowX) + " " + df.format(ycord.get(i) / WindowY));
        }
        finalResponse = finalResponse.concat("\n");
        return finalResponse;
    }
    public void paintSet() {
        paintGUI pg = new paintGUI();
        paintComponent(pg.pnlEditArea.getGraphics());
    }
}
