package com.uws.excercise1;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;   

// Original code with SRP violation
public class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
        // Default constructor
    }

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void saveToDatabase() {
    // Save employee data to Employees.xml using XML libraries
    try {
        java.io.File xmlFile = new java.io.File("Employees.xml");
        javax.xml.parsers.DocumentBuilderFactory dbFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc;

        org.w3c.dom.Element rootElement;
        if (xmlFile.exists() && xmlFile.length() > 0) {
            doc = dBuilder.parse(xmlFile);
            rootElement = doc.getDocumentElement();
        } else {
            doc = dBuilder.newDocument();
            rootElement = doc.createElement("employees");
            doc.appendChild(rootElement);
        }

        org.w3c.dom.Element employeeElem = doc.createElement("employee");

        org.w3c.dom.Element idElem = doc.createElement("id");
        idElem.appendChild(doc.createTextNode(String.valueOf(id)));
        employeeElem.appendChild(idElem);

        org.w3c.dom.Element nameElem = doc.createElement("name");
        nameElem.appendChild(doc.createTextNode(name));
        employeeElem.appendChild(nameElem);

        org.w3c.dom.Element positionElem = doc.createElement("position");
        positionElem.appendChild(doc.createTextNode(position));
        employeeElem.appendChild(positionElem);

        org.w3c.dom.Element salaryElem = doc.createElement("salary");
        salaryElem.appendChild(doc.createTextNode(String.format("%.2f", salary)));
        employeeElem.appendChild(salaryElem);

        rootElement.appendChild(employeeElem);

        // Write the content into XML file
        javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
        javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
        javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
        javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
        transformer.transform(source, result);

        System.out.println("Saved employee to Employees.xml: " + name);
    } catch (Exception e) {
        System.out.println("Error saving to Employees.xml: " + e.getMessage());
    }
}

    public Employee loadFromDatabase(int id) {
    // Load employee data from Employees.xml by id using XPath
    try {
        Employee loadedEmployee = null;
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append(System.getProperty("user.dir"));
        pathBuilder.append(File.separator);
        pathBuilder.append("com");
        pathBuilder.append(File.separator);
        pathBuilder.append("uws");
        pathBuilder.append(File.separator);
        pathBuilder.append("excercise1");
        pathBuilder.append(File.separator);
        pathBuilder.append("Employees.xml");
        String path = pathBuilder.toString();
        
        File xmlFile = new File(path);
        if (!xmlFile.exists()) {
            System.out.println("Looking for: " + xmlFile.getAbsolutePath());
            System.out.println("Employees.xml file not found.");
            return null;
        }
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        // Use XPath to find the employee with the given id
        javax.xml.xpath.XPathFactory xPathFactory = javax.xml.xpath.XPathFactory.newInstance();
        javax.xml.xpath.XPath xpath = xPathFactory.newXPath();
        String expression = String.format("/employees/employee[id=%d]", id);
        org.w3c.dom.Node employeeNode = (org.w3c.dom.Node) xpath.evaluate(expression, doc, javax.xml.xpath.XPathConstants.NODE);

        if (employeeNode != null && employeeNode.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) employeeNode;
            String empName = elem.getElementsByTagName("name").item(0).getTextContent();
            String empPosition = elem.getElementsByTagName("position").item(0).getTextContent();
            String empSalary = elem.getElementsByTagName("salary").item(0).getTextContent();
            int empId = Integer.parseInt(elem.getElementsByTagName("id").item(0).getTextContent());

            // Set fields of this Employee object
            loadedEmployee = new Employee(empId, empName, empPosition, Double.parseDouble(empSalary));
        } else {
            //Improve error handling
            System.out.println("Employee with ID " + id + " not found in Employees.xml.");
        }
        return loadedEmployee;
    } catch (Exception e) {
        System.out.println("Error loading from Employees.xml: " + e.getMessage());
        return null;
    }
}   

    public double calculateMonthlySalary() {
        return salary / 12;
    }
    
    public double calculateTax() {
        return salary * 0.2; // 20% tax
    }
    
    
}
