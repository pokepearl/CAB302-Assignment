package paintTool;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class vecFilter extends FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }
        FileHandler fileTool = new FileHandler();
        String fileExt = fileTool.getFileExt(pathname);
        if (fileExt != null) {
            if (fileExt.equals("vec")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public String getDescription() {
        return "vec Files";
    }
}
