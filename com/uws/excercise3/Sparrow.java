package com.uws.excercise3;

public class Sparrow extends Bird {
    public Sparrow(String name) {
        super(name);
    }
    
    // Sparrow can fly, so no problem here
    @Override
    public void fly() {
        System.out.println(getName() + " is flying High and gracefully...");
    }

}


