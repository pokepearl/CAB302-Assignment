package paintTool;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class vecFilter extends FileFilter {
    /**
     * Checks if a given file name fits the filter to only display 'VEC' files.
     * @param pathname File object containing the path of a given file to be tested with the filter.
     * @return true if the file ends in '.vec', false otherwise.
     */
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }
        FileHandler fileTool = new FileHandler();
        String fileExt = fileTool.getFileExt(pathname);
        if (fileExt != null) {
            if (fileExt.equals("vec") || fileExt.equals("VEC")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Creates the filter's name for use in the Open/Save Dialog boxes.
     * @return String of the name of the filter, "vec Files".
     */
    public String getDescription() {
        return "vec Files";
    }
}
