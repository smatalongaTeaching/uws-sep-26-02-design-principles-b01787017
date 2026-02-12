package com.uws.excercise4;

public class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document document) {
        System.out.println("Printing document: " + document.getName());
    }
    
    @Override
    public void scan(Document document) {
        System.out.println("Scanning document: " + document.getName());
    }
    
    @Override
    public void fax(Document document) {
        System.out.println("Faxing document: " + document.getName());
    }
    
    @Override
    public void copy(Document document) {
        System.out.println("Copying document: " + document.getName());
    }
}
