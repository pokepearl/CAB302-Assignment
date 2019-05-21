package paintTool;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import paintTool.ShapePoint;

public class paintToolJUnit {

    @Test
    public void testPointSize() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        assertEquals("{102.0=225.0}", test.printArray());
    }
    @Test
    public void testPointSizeFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        assertNotEquals("{102.0=227.0}", test.printArray());
    }
}
