package com.uws.excercise1.src;

public class EmployeePayRoll {

    public double calculateMonthlySalary(Employee employee) {
        return employee.getSalary() / 12;
    }
    
    public double calculateTax(Employee employee) {
        return employee.getSalary() * 0.2; // 20% tax
    }

}
