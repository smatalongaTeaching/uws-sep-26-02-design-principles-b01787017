package com.uws.excercise2.src;

public class Circle implements Shape {
        private double radius;
    
    // Constructor, getters, setters...
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {  
        return Math.PI * radius * radius;
    }

}
