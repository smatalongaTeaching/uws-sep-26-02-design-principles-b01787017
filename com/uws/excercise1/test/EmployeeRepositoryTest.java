package com.uws.excercise1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.uws.excercise1.src.Employee;
import com.uws.excercise1.src.EmployeeRepository;

public class EmployeeRepositoryTest {

    private final Path testXml = Path.of("Employees_Test.xml");

    @AfterEach
    void cleanup() throws Exception {
        Files.deleteIfExists(testXml);
    }

    @Test
    void saveThenLoad_returnsSameEmployee() {
        EmployeeRepository repo = new EmployeeRepository(testXml);
        Employee emp = new Employee(2, "Dean", "Agent", 60000.0);

        repo.saveToDatabase(emp);

        Employee loaded = repo.loadFromDatabase(2);

        assertNotNull(loaded);
        assertEquals(2, loaded.getId());
        assertEquals("Dean", loaded.getName());
        assertEquals("Agent", loaded.getPosition());
        assertEquals(60000.0, loaded.getSalary(), 0.0001);
    }

    @Test
    void loadNonExistentId_returnsNull() throws Exception {
        // Create an empty-but-valid XML store
        Files.writeString(testXml, "<employees></employees>");

        EmployeeRepository repo = new EmployeeRepository(testXml);

        Employee missing = repo.loadFromDatabase(999);
        assertNull(missing);
    }
}
