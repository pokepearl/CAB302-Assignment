package paintTool;

import java.io.File;
import java.util.ArrayList;

public class FileHandler {
    paintGUI GUI = new paintGUI();
    public void startSaveFile(File filepath, ArrayList<Shape> shapeArray, int width, int height) {
        System.out.println(filepath.toString());
        /*if (!filepath.exists()) {
            filepath.createNewFile();
        }*/
        for (int i = 0; i < shapeArray.size(); i++) {
            Shape t2 = shapeArray.get(i);
            //String response = "";
            String response = t2.vecFileLine(width, height);
            System.out.println(response);
        }
    }
}
