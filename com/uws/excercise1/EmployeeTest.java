package com.uws.excercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    void constructor_setsAllFields() {
        Employee emp = new Employee(1, "Dean", "Agent", 60000.0);

        assertEquals(1, emp.getId());
        assertEquals("Dean", emp.getName());
        assertEquals("Agent", emp.getPosition());
        assertEquals(60000.0, emp.getSalary(), 0.0001);
    }

    @Test
    void setters_updateFields() {
        Employee emp = new Employee();
        emp.setId(2);
        emp.setName("Sam");
        emp.setPosition("Manager");
        emp.setSalary(45000.0);

        assertEquals(2, emp.getId());
        assertEquals("Sam", emp.getName());
        assertEquals("Manager", emp.getPosition());
        assertEquals(45000.0, emp.getSalary(), 0.0001);
    }
}
