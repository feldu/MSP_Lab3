package lab3;


import lab3.model.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PointTest {
    private Point point;
    private final String hit = "Попала";
    private final String missed = "Не попала";
    private final double epsilon = 10e-10;

    private String getMessage(Point point) {
        return "Shit point (" + point.getX() + "," + point.getY() + ") with radius " + point.getR();
    }

    @Test
    public void zeroTest() {
        point = new Point(0d, 0d, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void IQuarterTest() {
        point = new Point(epsilon, epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void IIQuarterTest() {
        point = new Point(-epsilon, epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void IIIQuarterTest() {
        point = new Point(-epsilon, -epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }

    @Test
    public void IVQuarterTest() {
        point = new Point(epsilon, -epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    //triangle border tests
    @Test
    public void rightTriangleBorderTest() {
        point = new Point(1d, 0d, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void topTriangleBorderTest() {
        point = new Point(0d, 0.5, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void middleTriangleBorderTest() {
        point = new Point(0.5, 0.25, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void middleTriangleOutOfBorderTest() {
        point = new Point(0.5 + epsilon, 0.25 + epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }

    //rectangle border tests
    @Test
    public void topLeftRectangleBorderTest() {
        point = new Point(-1d, 0.5, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void topRectangleOutOfBorderTest() {
        point = new Point(-1d + epsilon, 0.5 + epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }

    @Test
    public void leftRectangleOutOfBorderTest() {
        point = new Point(-1d - epsilon, 0.5 - epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }

    //round border tests
    @Test
    public void bottomRoundBorderTest() {
        point = new Point(0d, -0.5, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void middleRoundBorderTest() {
        point = new Point(0.4, -0.3, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void middleRoundOutOfBorderTest() {
        point = new Point(0.4 + epsilon, -0.3 - epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }

    //todo: Fucking radius tests Ramil' blyat'
}
