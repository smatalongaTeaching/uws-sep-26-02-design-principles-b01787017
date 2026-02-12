package com.uws.excercise3;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }
    
    // Penguin cannot fly, so this overridden method violates LSP
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly!");
    }
    
    public void swim() {
        System.out.println(getName() + " is swimming...");
    }
}

