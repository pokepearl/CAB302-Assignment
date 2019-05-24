package paintTool;

import java.io.File;
import java.util.ArrayList;

public class FileHandler {
    paintGUI GUI = new paintGUI();
    public void startSaveFile(File filepath, ArrayList<Shape> shapeArray) {
        System.out.println(filepath.toString());
        /*if (!filepath.exists()) {
            filepath.createNewFile();
        }*/
        for (int i = 0; i < shapeArray.size(); i++) {
            Shape t2 = shapeArray.get(i);
            t2.vecFileLine(GUI.getCanvasX(), GUI.getCanvasY());
        }
    }
}
