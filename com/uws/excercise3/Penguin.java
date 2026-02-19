package com.uws.excercise3;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    public void swim() {
        System.out.println(getName() + " is swimming...");
    }
}
