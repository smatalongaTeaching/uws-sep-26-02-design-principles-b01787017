package com.uws.excercise2.src;

public class AreaCalculator {

    public static double calculateArea(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Shape must not be null");
        }
        return shape.area();
    }
}
