package com.uws.excercise1.src;

public class MainClass {
    
    public static void main(String[] args) {

        EmployeeRepository repository = new EmployeeRepository();
        Employee emp2 = repository.loadFromDatabase(1);

        // Print loaded employee details
        System.out.println("Loaded Employee:");
        System.out.println("ID: " + emp2.getId());
        System.out.println("Name: " + emp2.getName());

        Employee emp3 = repository.loadFromDatabase(999);
        if (emp3 == null) {
            System.out.println("Employee with ID 999 does not exist.");
        }

    }
}