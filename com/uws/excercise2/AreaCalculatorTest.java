package com.uws.excercise2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AreaCalculatorTest {

    @Test
    void testCalculateAreaRectangle() {
        Rectangle rectangle = new Rectangle(4.0, 2.5);
        double area = AreaCalculator.calculateArea(rectangle);
        assertEquals(10.0, area, 0.0001);
    }

    @Test
    void testCalculateAreaCircle() {
        Circle circle = new Circle(3.0);
        double area = AreaCalculator.calculateArea(circle);
        assertEquals(Math.PI * 9.0, area, 0.0001);
    }
}
