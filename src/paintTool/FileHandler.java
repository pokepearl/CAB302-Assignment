package paintTool;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileHandler {
    String lastPenColour = "#000000";
    String lastFillColour = "OFF";
    paintGUI GUI = new paintGUI();

    /**
     * Given a File variable and the array of drawn shape, creates and writes the instructions to
     * draw the shapes to a VEC file on the filesystem.
     * @param filepath File object containing the location of the desired file location.
     * @param shapeArray Array of shapes drawn in the canvas region of the main UI.
     * @param width Width of the canvas region of the main UI.
     * @param height Height of the canvas region of the main UI.
     */
    public void startSaveFile(File filepath, ArrayList<Shape> shapeArray, int width, int height) {
        BufferedWriter writer = null; //Initialise BufferedWriter for use
        if (!filepath.exists()) { //Check if file exists, create it if it doesn't.
            try {
                filepath.createNewFile();
            } catch (IOException x) {
                // Some other sort of failure, such as permissions.
                System.err.format("createFile error: %s%n", x);
            }

        }
        try {
            writer = new BufferedWriter(new FileWriter(filepath));
            for (int i = 0; i < shapeArray.size(); i++) { //Loop through shape array and write the instructions to the VEC file.
                Shape t2 = shapeArray.get(i);
                //String response = "";
                String penColour = "PEN " + t2.getPenColour() + "\n";
                String fillColour = "FILL " + t2.getFillColour() + "\n";
                String response = t2.vecFileLine(width, height, t2.returnArrayX(), t2.returnArrayY());
                System.out.println(response);
                if (!lastPenColour.equals(t2.getPenColour())) { //If last used pen colour doesn't equal the one saved in the Shape object, write it to file and update last used.
                    writer.write(penColour);
                    this.lastPenColour = t2.getPenColour();
                }
                if (!lastFillColour.equals(t2.getFillColour())) { //If last used fill colour doesn't equal the one saved in the Shape object, write it to file and update last used.
                    writer.write(fillColour);
                    this.lastFillColour = t2.getFillColour();
                }
                writer.write(response); //Write shape draw instruction to file.
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


    /**
     * Given a File object, returns the extension of the file.
     * @param file File object containing the location of the desired file location.
     * @return The extension of the file to write to.
     */
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