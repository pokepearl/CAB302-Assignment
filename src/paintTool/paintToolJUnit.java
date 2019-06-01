package paintTool;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import paintTool.ShapePoint;

import java.awt.*;
import java.io.File;
import java.util.LinkedList;

public class paintToolJUnit {

    @Test
    public void testPointContentX() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        assertEquals("[102]", test.printArrayX());
    }
    @Test
    public void testPointContentY() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        assertEquals("[225]", test.printArrayY());
    }
    @Test
    public void testPointContentFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        assertNotEquals("[103]", test.printArrayX());
    }
    @Test
    public void testPointContentMulti() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertEquals("[102, 95]", test.printArrayX());
    }
    @Test
    public void testPointContentMultiFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertNotEquals("[103, 93]", test.printArrayX());
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

    @Test
    public void testPointPrintX() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[102, 1, 132]", test.printArrayX());
    }
    @Test
    public void testPointPrintY() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[225, 20, 233]", test.printArrayY());
    }
    @Test
    public void testPointPrintXFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[102, 5, 132]", test.printArrayX());
    }
    @Test
    public void testPointPrintYFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[225, 25, 233]", test.printArrayY());
    }
    @Test
    public void testPointPen() {
        ShapePoint test = new ShapePoint();
        test.setPenColour("#00FF00");
        assertEquals("#00FF00", test.getPenColour());
    }
    @Test
    public void testPointPenFalse() {
        ShapePoint test = new ShapePoint();
        test.setPenColour("#00FF00");
        assertNotEquals("#00FFF0", test.getPenColour());
    }
    @Test
    public void testPointFill() {
        ShapePoint test = new ShapePoint();
        test.setFillColour("#00FF00");
        assertEquals("#00FF00", test.getFillColour());
    }
    @Test
    public void testPointFillOff() {
        ShapePoint test = new ShapePoint();
        test.setFillColour("OFF");
        assertEquals("OFF", test.getFillColour());
    }
    @Test
    public void testPointFillFalse() {
        ShapePoint test = new ShapePoint();
        test.setFillColour("#00FF00");
        assertNotEquals("#0FFFF0", test.getFillColour());
    }
    @Test
    public void testPointReturnArrX() {
        ShapePoint test = new ShapePoint();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertEquals(demo, test.returnArrayX());
    }
    @Test
    public void testPointReturnArrXFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertNotEquals(demo, test.returnArrayX());
    }
    @Test
    public void testPointReturnArrY() {
        ShapePoint test = new ShapePoint();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertEquals(demo, test.returnArrayY());
    }
    @Test
    public void testPointReturnArrYFalse() {
        ShapePoint test = new ShapePoint();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertNotEquals(demo, test.returnArrayY());
    }
    @Test
    public void testEllipseContentX() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        assertEquals("[102]", test.printArrayX());
    }
    @Test
    public void testEllipseContentY() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        assertEquals("[225]", test.printArrayY());
    }
    @Test
    public void testEllipseContentFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        assertNotEquals("[103]", test.printArrayX());
    }
    @Test
    public void testEllipseContentMulti() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertEquals("[102, 95]", test.printArrayX());
    }
    @Test
    public void testEllipseContentMultiFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertNotEquals("[103, 93]", test.printArrayX());
    }

    @Test
    public void testEllipseSize() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals(3, test.sizeOfArray());
    }
    @Test
    public void testEllipseSizeFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals(5, test.sizeOfArray());
    }
    @Test
    public void testEllipseType() {
        ShapeEllipse test = new ShapeEllipse();
        test.setShapeType("POINT");
        assertEquals("POINT", test.getShapeType());
    }
    @Test
    public void testEllipseTypeFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.setShapeType("RECTANGLE");
        assertNotEquals("POINT", test.getShapeType());
    }

    @Test
    public void testEllipsePrintX() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[102, 1, 132]", test.printArrayX());
    }
    @Test
    public void testEllipsePrintY() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[225, 20, 233]", test.printArrayY());
    }
    @Test
    public void testEllipsePrintXFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[102, 5, 132]", test.printArrayX());
    }
    @Test
    public void testEllipsePrintYFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[225, 25, 233]", test.printArrayY());
    }
    @Test
    public void testEllipsePen() {
        ShapeEllipse test = new ShapeEllipse();
        test.setPenColour("#00FF00");
        assertEquals("#00FF00", test.getPenColour());
    }
    @Test
    public void testEllipsePenFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.setPenColour("#00FF00");
        assertNotEquals("#00FFF0", test.getPenColour());
    }
    @Test
    public void testEllipseFill() {
        ShapeEllipse test = new ShapeEllipse();
        test.setFillColour("#00FF00");
        assertEquals("#00FF00", test.getFillColour());
    }
    @Test
    public void testEllipseFillOff() {
        ShapeEllipse test = new ShapeEllipse();
        test.setFillColour("OFF");
        assertEquals("OFF", test.getFillColour());
    }
    @Test
    public void testEllipseFillFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.setFillColour("#00FF00");
        assertNotEquals("#0FFFF0", test.getFillColour());
    }
    @Test
    public void testEllipseReturnArrX() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertEquals(demo, test.returnArrayX());
    }
    @Test
    public void testEllipseReturnArrXFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertNotEquals(demo, test.returnArrayX());
    }
    @Test
    public void testEllipseReturnArrY() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertEquals(demo, test.returnArrayY());
    }
    @Test
    public void testEllipseReturnArrYFalse() {
        ShapeEllipse test = new ShapeEllipse();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertNotEquals(demo, test.returnArrayY());
    }
    @Test
    public void testLineContentX() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        assertEquals("[102]", test.printArrayX());
    }
    @Test
    public void testLineContentY() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        assertEquals("[225]", test.printArrayY());
    }
    @Test
    public void testLineContentFalse() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        assertNotEquals("[103]", test.printArrayX());
    }
    @Test
    public void testLineContentMulti() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertEquals("[102, 95]", test.printArrayX());
    }
    @Test
    public void testLineContentMultiFalse() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertNotEquals("[103, 93]", test.printArrayX());
    }

    @Test
    public void testLineSize() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals(3, test.sizeOfArray());
    }
    @Test
    public void testLineSizeFalse() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals(5, test.sizeOfArray());
    }
    @Test
    public void testLineType() {
        ShapeLine test = new ShapeLine();
        test.setShapeType("POINT");
        assertEquals("POINT", test.getShapeType());
    }
    @Test
    public void testLineTypeFalse() {
        ShapeLine test = new ShapeLine();
        test.setShapeType("RECTANGLE");
        assertNotEquals("POINT", test.getShapeType());
    }

    @Test
    public void testLinePrintX() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[102, 1, 132]", test.printArrayX());
    }
    @Test
    public void testLinePrintY() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[225, 20, 233]", test.printArrayY());
    }
    @Test
    public void testLinePrintXFalse() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[102, 5, 132]", test.printArrayX());
    }
    @Test
    public void testLinePrintYFalse() {
        ShapeLine test = new ShapeLine();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[225, 25, 233]", test.printArrayY());
    }
    @Test
    public void testLinePen() {
        ShapeLine test = new ShapeLine();
        test.setPenColour("#00FF00");
        assertEquals("#00FF00", test.getPenColour());
    }
    @Test
    public void testLinePenFalse() {
        ShapeLine test = new ShapeLine();
        test.setPenColour("#00FF00");
        assertNotEquals("#00FFF0", test.getPenColour());
    }
    @Test
    public void testLineFill() {
        ShapeLine test = new ShapeLine();
        test.setFillColour("#00FF00");
        assertEquals("#00FF00", test.getFillColour());
    }
    @Test
    public void testLineFillOff() {
        ShapeLine test = new ShapeLine();
        test.setFillColour("OFF");
        assertEquals("OFF", test.getFillColour());
    }
    @Test
    public void testLineFillFalse() {
        ShapeLine test = new ShapeLine();
        test.setFillColour("#00FF00");
        assertNotEquals("#0FFFF0", test.getFillColour());
    }
    @Test
    public void testLineReturnArrX() {
        ShapeLine test = new ShapeLine();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertEquals(demo, test.returnArrayX());
    }
    @Test
    public void testLineReturnArrXFalse() {
        ShapeLine test = new ShapeLine();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertNotEquals(demo, test.returnArrayX());
    }
    @Test
    public void testLineReturnArrY() {
        ShapeLine test = new ShapeLine();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertEquals(demo, test.returnArrayY());
    }
    @Test
    public void testLineReturnArrYFalse() {
        ShapeLine test = new ShapeLine();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertNotEquals(demo, test.returnArrayY());
    }
    @Test
    public void testPolygonContentX() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        assertEquals("[102]", test.printArrayX());
    }
    @Test
    public void testPolygonContentY() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        assertEquals("[225]", test.printArrayY());
    }
    @Test
    public void testPolygonContentFalse() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        assertNotEquals("[103]", test.printArrayX());
    }
    @Test
    public void testPolygonContentMulti() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertEquals("[102, 95]", test.printArrayX());
    }
    @Test
    public void testPolygonContentMultiFalse() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertNotEquals("[103, 93]", test.printArrayX());
    }

    @Test
    public void testPolygonSize() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals(3, test.sizeOfArray());
    }
    @Test
    public void testPolygonSizeFalse() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals(5, test.sizeOfArray());
    }
    @Test
    public void testPolygonType() {
        ShapePolygon test = new ShapePolygon();
        test.setShapeType("POINT");
        assertEquals("POINT", test.getShapeType());
    }
    @Test
    public void testPolygonTypeFalse() {
        ShapePolygon test = new ShapePolygon();
        test.setShapeType("RECTANGLE");
        assertNotEquals("POINT", test.getShapeType());
    }

    @Test
    public void testPolygonPrintX() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[102, 1, 132]", test.printArrayX());
    }
    @Test
    public void testPolygonPrintY() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[225, 20, 233]", test.printArrayY());
    }
    @Test
    public void testPolygonPrintXFalse() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[102, 5, 132]", test.printArrayX());
    }
    @Test
    public void testPolygonPrintYFalse() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[225, 25, 233]", test.printArrayY());
    }
    @Test
    public void testPolygonPen() {
        ShapePolygon test = new ShapePolygon();
        test.setPenColour("#00FF00");
        assertEquals("#00FF00", test.getPenColour());
    }
    @Test
    public void testPolygonPenFalse() {
        ShapePolygon test = new ShapePolygon();
        test.setPenColour("#00FF00");
        assertNotEquals("#00FFF0", test.getPenColour());
    }
    @Test
    public void testPolygonFill() {
        ShapePolygon test = new ShapePolygon();
        test.setFillColour("#00FF00");
        assertEquals("#00FF00", test.getFillColour());
    }
    @Test
    public void testPolygonFillOff() {
        ShapePolygon test = new ShapePolygon();
        test.setFillColour("OFF");
        assertEquals("OFF", test.getFillColour());
    }
    @Test
    public void testPolygonFillFalse() {
        ShapePolygon test = new ShapePolygon();
        test.setFillColour("#00FF00");
        assertNotEquals("#0FFFF0", test.getFillColour());
    }
    @Test
    public void testPolygonReturnArrX() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertEquals(demo, test.returnArrayX());
    }
    @Test
    public void testPolygonReturnArrXFalse() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertNotEquals(demo, test.returnArrayX());
    }
    @Test
    public void testPolygonReturnArrY() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertEquals(demo, test.returnArrayY());
    }
    @Test
    public void testPolygonReturnArrYFalse() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertNotEquals(demo, test.returnArrayY());
    }
    @Test
    public void testPolygonDesiredLength() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(20,30);
        test.setDesiredLength(5);
        assertEquals(5, test.getDesiredLength());
    }
    @Test
    public void testPolygonDesiredLengthFalse() {
        ShapePolygon test = new ShapePolygon();
        test.addToArray(20,30);
        test.setDesiredLength(5);
        assertNotEquals(3, test.returnArrayY());
    }
    @Test
    public void testRectContentX() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        assertEquals("[102]", test.printArrayX());
    }
    @Test
    public void testRectContentY() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        assertEquals("[225]", test.printArrayY());
    }
    @Test
    public void testRectContentFalse() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        assertNotEquals("[103]", test.printArrayX());
    }
    @Test
    public void testRectContentMulti() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertEquals("[102, 95]", test.printArrayX());
    }
    @Test
    public void testRectContentMultiFalse() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        test.addToArray(95, 102);
        assertNotEquals("[103, 93]", test.printArrayX());
    }

    @Test
    public void testRectSize() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals(3, test.sizeOfArray());
    }
    @Test
    public void testRectSizeFalse() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals(5, test.sizeOfArray());
    }
    @Test
    public void testRectType() {
        ShapeRect test = new ShapeRect();
        test.setShapeType("POINT");
        assertEquals("POINT", test.getShapeType());
    }
    @Test
    public void testRectTypeFalse() {
        ShapeRect test = new ShapeRect();
        test.setShapeType("RECTANGLE");
        assertNotEquals("POINT", test.getShapeType());
    }

    @Test
    public void testRectPrintX() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[102, 1, 132]", test.printArrayX());
    }
    @Test
    public void testRectPrintY() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertEquals("[225, 20, 233]", test.printArrayY());
    }
    @Test
    public void testRectPrintXFalse() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[102, 5, 132]", test.printArrayX());
    }
    @Test
    public void testRectPrintYFalse() {
        ShapeRect test = new ShapeRect();
        test.addToArray(102, 225);
        test.addToArray(1, 20);
        test.addToArray(132, 233);
        assertNotEquals("[225, 25, 233]", test.printArrayY());
    }
    @Test
    public void testRectPen() {
        ShapeRect test = new ShapeRect();
        test.setPenColour("#00FF00");
        assertEquals("#00FF00", test.getPenColour());
    }
    @Test
    public void testRectPenFalse() {
        ShapeRect test = new ShapeRect();
        test.setPenColour("#00FF00");
        assertNotEquals("#00FFF0", test.getPenColour());
    }
    @Test
    public void testRectFill() {
        ShapeRect test = new ShapeRect();
        test.setFillColour("#00FF00");
        assertEquals("#00FF00", test.getFillColour());
    }
    @Test
    public void testRectFillOff() {
        ShapeRect test = new ShapeRect();
        test.setFillColour("OFF");
        assertEquals("OFF", test.getFillColour());
    }
    @Test
    public void testRectFillFalse() {
        ShapeRect test = new ShapeRect();
        test.setFillColour("#00FF00");
        assertNotEquals("#0FFFF0", test.getFillColour());
    }
    @Test
    public void testRectReturnArrX() {
        ShapeRect test = new ShapeRect();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertEquals(demo, test.returnArrayX());
    }
    @Test
    public void testRectReturnArrXFalse() {
        ShapeRect test = new ShapeRect();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertNotEquals(demo, test.returnArrayX());
    }
    @Test
    public void testRectReturnArrY() {
        ShapeRect test = new ShapeRect();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(30);
        assertEquals(demo, test.returnArrayY());
    }
    @Test
    public void testRectReturnArrYFalse() {
        ShapeRect test = new ShapeRect();
        test.addToArray(20,30);
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(20);
        assertNotEquals(demo, test.returnArrayY());
    }
    @Test
    public void testShapeColour() {
        ShapeRect test = new ShapeRect();
        Color colour = new Color(68,243,170);
        assertEquals(colour, test.convertHex2RGB("#44F3AA"));
    }
    @Test
    public void testShapeColourFalse() {
        ShapeRect test = new ShapeRect();
        Color colour = new Color(68,244,170);
        assertNotEquals(colour, test.convertHex2RGB("#44F3AA"));
    }
    @Test
    public void testShapeVecline() {
        ShapeRect test = new ShapeRect();
        test.setShapeType("RECTANGLE");
        test.addToArray(5, 5);
        test.addToArray(80, 30);
        assertEquals("RECTANGLE 0.05 0.05 0.3 0.3\n", test.vecFileLine(100, 100, test.returnArrayY(), test.returnArrayY()));
    }
    @Test
    public void testShapeVeclineFalse() {
        ShapeRect test = new ShapeRect();
        test.setShapeType("RECTANGLE");
        test.addToArray(5, 5);
        test.addToArray(80, 37);
        assertNotEquals("RECTANGLE 0.05 0.05 0.3 0.3", test.vecFileLine(100, 100, test.returnArrayY(), test.returnArrayY()));
    }
    @Test
    public void testFileExt() {
        File fl = new File("demo.vec");
        FileHandler fh = new FileHandler();
        assertEquals("vec", fh.getFileExt(fl));
    }
    @Test
    public void testFileExtFalse() {
        File fl = new File("demo.vec");
        FileHandler fh = new FileHandler();
        assertNotEquals("veX", fh.getFileExt(fl));
    }
    @Test
    public void testFilter() {
        File fl = new File("demo.vec");
        vecFilter vf = new vecFilter();
        assertTrue(vf.accept(fl));
    }
    @Test
    public void testFilterFalse() {
        File fl = new File("demo.veG");
        vecFilter vf = new vecFilter();
        assertFalse(vf.accept(fl));
    }

}
