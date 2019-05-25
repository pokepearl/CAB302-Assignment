package paintTool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileHandler {
    paintGUI GUI = new paintGUI();
    public void startSaveFile(File filepath, ArrayList<Shape> shapeArray, int width, int height) {
        BufferedWriter writer = null;
        System.out.println(filepath.toString());
        if (!filepath.exists()) {
            try {
                filepath.createNewFile();
            } catch (IOException x) {
                // Some other sort of failure, such as permissions.
                System.err.format("createFile error: %s%n", x);
            }

        }
        for (int i = 0; i < shapeArray.size(); i++) {
            Shape t2 = shapeArray.get(i);
            //String response = "";
            String response = t2.vecFileLine(width, height);
            System.out.println(response);


            try {

                writer = new BufferedWriter(new FileWriter(filepath));
                writer.write(response);
            } catch (IOException x) {
                // Some other sort of failure, such as permissions.
                System.err.format("WriteFile error: %s%n", x);
            } finally {
                try {
                    writer.close();
                } catch (Exception e) {
            }

            }
        }
    }
    public String getFileExt(File file) {
        String fileExt = null;
        String str = file.getName();
        int i = str.lastIndexOf('.');

        if (i > 0 &&  i < str.length() - 1) {
            fileExt = str.substring(i+1).toLowerCase();
        }
        return fileExt;
    }
}
