package com.uws.excercise1.src;

public class MainClass {
    
    public static void main(String[] args) {
       
        // Load employee from Employees.xml by ID
        Employee emp2 = new Employee();
        emp2 = emp2.loadFromDatabase(1);

        // Print loaded employee details
        System.out.println("Loaded Employee:");
        System.out.println("ID: " + emp2.getId());
        System.out.println("Name: " + emp2.getName());

        // You can also try loading a non-existent employee
       emp2 =  emp2.loadFromDatabase(999);
        if (emp2 == null) {
            System.out.println("Employee with ID 999 does not exist.");
        }

        
    }
}