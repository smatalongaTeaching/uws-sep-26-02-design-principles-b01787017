package com.uws.excercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EmployeePayrollTest {

    @Test
    void calculateMonthlySalary_returnsSalaryDividedBy12() {
        Employee emp = new Employee(1, "Dean", "Agent", 60000.0);
        EmployeePayRoll payroll = new EmployeePayRoll();
        double monthly = payroll.calculateMonthlySalary(emp);
        assertEquals(5000.0, monthly, 0.0001);
    }

    @Test
    void calculateTax_returns20PercentOfSalary() {
        Employee emp = new Employee(1, "Dean", "Agent", 60000.0);
        EmployeePayRoll payroll = new EmployeePayRoll();
        double tax = payroll.calculateTax(emp);
        assertEquals(12000.0, tax, 0.0001);
    }
}
