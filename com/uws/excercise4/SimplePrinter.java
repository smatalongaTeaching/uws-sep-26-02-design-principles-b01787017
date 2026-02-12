package com.uws.excercise4;

public class SimplePrinter implements Machine {
    @Override
    public void print(Document document) {
        System.out.println("Printing document: " + document.getName());
    }
    
    @Override
    public void scan(Document document) {
        throw new UnsupportedOperationException("Simple printer cannot scan");
    }
    
    @Override
    public void fax(Document document) {
        throw new UnsupportedOperationException("Simple printer cannot fax");
    }
    
    @Override
    public void copy(Document document) {
        throw new UnsupportedOperationException("Simple printer cannot copy");
    }
}
