package com.uws.excercise3;

public class Bird {
    private String name;
    
    // Constructor, getters, setters...
    
    public Bird(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void fly() {
        System.out.println(name + " is flying high...");
    }

}
