package com.uws.excercise2.test;

import org.junit.jupiter.api.Test;

import com.uws.excercise2.src.AreaCalculator;
import com.uws.excercise2.src.Circle;
import com.uws.excercise2.src.Rectangle;

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
