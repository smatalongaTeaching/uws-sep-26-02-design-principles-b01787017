package com.uws.excercise1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.uws.excercise1.src.Employee;
import com.uws.excercise1.src.EmployeePayRoll;

public class EmployeePayrollTest {

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

    @Test
    void calculateMonthlySalary_andTax_returnZeroWhenSalaryIsZero() {
        Employee emp = new Employee(2, "Alex", "Agent", 0.0);
        EmployeePayRoll payroll = new EmployeePayRoll();

        assertEquals(0.0, payroll.calculateMonthlySalary(emp), 0.0001);
        assertEquals(0.0, payroll.calculateTax(emp), 0.0001);
    }

    @Test
    void payrollObject_canBeCreated() {
        EmployeePayRoll payroll = new EmployeePayRoll();
        assertNotNull(payroll);
    }
}
