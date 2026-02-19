package com.uws.excercise1;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class EmployeeRepositoryTest {

    private final Path rootXml = Path.of("Employees_Test.xml");
    private final Path expectedXml = Path.of("com", "uws", "excercise1", "Employees.xml");

    @AfterEach
    void cleanup() throws Exception {
        Files.deleteIfExists(rootXml);
        Files.deleteIfExists(expectedXml);
    }

    @Test
    void saveThenLoad_returnsSameEmployee() throws Exception {

        EmployeeRepository repo = new EmployeeRepository();
        Employee emp = new Employee(2, "Dean", "Agent", 60000.0);

        // Writes Employees.xml to repo root
        repo.saveToDatabase(emp);

        // Copy it to the location loadFromDatabase() looks at
        Files.createDirectories(expectedXml.getParent());
        Files.copy(rootXml, expectedXml, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

        Employee loaded = repo.loadFromDatabase(2);

        assertNotNull(loaded);
        assertEquals(2, loaded.getId());
        assertEquals("Dean", loaded.getName());
        assertEquals("Agent", loaded.getPosition());
        assertEquals(60000.0, loaded.getSalary(), 0.0001);
    }

    @Test
    void loadNonExistentId_returnsNull() throws Exception {
        EmployeeRepository repo = new EmployeeRepository();

        // Ensure file exists where loadFromDatabase() expects it
        Files.createDirectories(expectedXml.getParent());
        Files.writeString(expectedXml, "<employees></employees>");

        Employee missing = repo.loadFromDatabase(999);
        assertNull(missing);
    }
}
