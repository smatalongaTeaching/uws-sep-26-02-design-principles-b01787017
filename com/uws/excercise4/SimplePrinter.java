package com.uws.excercise4;

public class SimplePrinter implements Printer {
    @Override
    public void print(Document document) {
        System.out.println("Printing document: " + document.getName());
    }
}
