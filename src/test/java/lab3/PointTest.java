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

    //triangle tests
    @Test
    public void test_0_05_1() {
        point = new Point(0d, 0.5, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void test_05_025_1() {
        point = new Point(0.5, 0.25, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void test_05_025_1_with_e() {
        point = new Point(0.5 + epsilon, 0.25 + epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }

    //rectangle tests
    @Test
    public void test_m1_05_1() {
        point = new Point(-1d, 0.5, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }

    @Test
    public void test_m1_05_1_with_e_tr() {
        point = new Point(-1d + epsilon, 0.5 + epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }

    @Test
    public void test_m1_05_1_with_e_bl() {
        point = new Point(-1d - epsilon, 0.5 - epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }

    //round tests border
    @Test
    public void test_0_m05_1() {
        point = new Point(0d, -0.5, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }
    @Test
    public void test_04_m03_1() {
        point = new Point(0.4, -0.3, 1);
        assertEquals(getMessage(point), point.getResult(), hit);
    }
    @Test
    public void test_04_m03_1_with_e() {
        point = new Point(0.4 + epsilon, -0.3 - epsilon, 1);
        assertEquals(getMessage(point), point.getResult(), missed);
    }
}
