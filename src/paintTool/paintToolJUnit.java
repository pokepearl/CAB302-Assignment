package paintTool;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import paintTool.ShapePoint;

public class paintToolJUnit {

    @Test
    public void testPointContent() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        assertEquals("{102.0=225.0}", test.printArray());
    }
    @Test
    public void testPointContentFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        assertNotEquals("{102.0=227.0}", test.printArray());
    }
    @Test
    public void testPointContentMulti() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertEquals("{102.0=225.0, 95.0=102.0}", test.printArray());
    }
    @Test
    public void testPointContentMultiFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertNotEquals("{102.0=225.0}, {95.0=105.0}", test.printArray());
    }

    @Test
    public void testPointSize() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals(3, test.sizeOfArray());
    }
    @Test
    public void testPointSizeFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals(5, test.sizeOfArray());
    }
    @Test
    public void testPointType() {
        ShapePoint test = new ShapePoint();
        test.setShapeType("POINT");
        assertEquals("POINT", test.getShapeType());
    }
    @Test
    public void testPointTypeFalse() {
        ShapePoint test = new ShapePoint();
        test.setShapeType("RECTANGLE");
        assertNotEquals("POINT", test.getShapeType());
    }
}
