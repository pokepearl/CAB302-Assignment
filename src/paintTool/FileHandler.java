package paintTool;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileHandler {
    String lastPenColour = "#000000";
    String lastFillColour = "#ffffff";
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
        try {
            writer = new BufferedWriter(new FileWriter(filepath));
            for (int i = 0; i < shapeArray.size(); i++) {
                Shape t2 = shapeArray.get(i);
                //String response = "";
                String penColour = "PEN " + t2.getPenColour() + "\n";
                this.lastPenColour = t2.getPenColour();
                this.lastFillColour = t2.getFillColour();
                String fillColour = "FILL " + t2.getFillColour() + "\n";
                String response = t2.vecFileLine(width, height, t2.getLinkedX(), t2.getLinkedY());
                System.out.println(response);
                if (lastPenColour != "#000000") {
                    writer.write(penColour);
                }
                if (lastFillColour != "#000000") {
                    writer.write(fillColour);
                }
                writer.write(response);
            }


        } catch (IOException x) {
            System.err.format("WriteFile error: %s%n", x);

        } finally {
            try {
                writer.close();
            } catch (Exception x) {

            }
        }
    }

    public void startOpenFile(File filepath, ArrayList<Shape> shapeArray, int width, int height) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));

        String cache;
        while ((cache = reader.readLine()) != null ) {
            System.out.println(cache);
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
