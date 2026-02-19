package com.uws.excercise3;

public class Penguin extends Bird implements Swimmable {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming...");
    }
}
