package lab3;


import lab3.model.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PointTest {
    private Point point;
    private final String hit = "Попала";
    private final String missed = "Не попала";

    private String getMessage(Point point) {
        return "Shit point (" + point.getX() + "," + point.getY() + ") with radius " + point.getR();
    }

    //todo: rename methods
    @Test
    public void test_0_0_1() {
        point = new Point(0d, 0d, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void test_1_0_1() {
        point = new Point(1d, 0d, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void test_0_05_1() {
        point = new Point(0d, 0.5, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void test_0_0_111() { //todo cmm
        point = new Point(3d, 3d, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }
}
