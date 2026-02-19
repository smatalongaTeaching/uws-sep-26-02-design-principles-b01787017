package com.uws.excercise1.src;

import java.io.*;
import java.nio.file.Path;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class EmployeeRepository {

    private final Path xmlPath;

    public EmployeeRepository() {
        this(Path.of("Employees.xml"));
    }

    public EmployeeRepository(Path xmlPath) {
        this.xmlPath = xmlPath;
    }

    public void saveToDatabase(Employee employee) {
        try {
            File xmlFile = xmlPath.toFile();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;

            Element rootElement;
            if (xmlFile.exists() && xmlFile.length() > 0) {
                doc = dBuilder.parse(xmlFile);
                rootElement = doc.getDocumentElement();
            } else {
                doc = dBuilder.newDocument();
                rootElement = doc.createElement("employees");
                doc.appendChild(rootElement);
            }

            Element employeeElem = doc.createElement("employee");

            Element idElem = doc.createElement("id");
            idElem.appendChild(doc.createTextNode(String.valueOf(employee.getId())));
            employeeElem.appendChild(idElem);

            Element nameElem = doc.createElement("name");
            nameElem.appendChild(doc.createTextNode(employee.getName()));
            employeeElem.appendChild(nameElem);

            Element positionElem = doc.createElement("position");
            positionElem.appendChild(doc.createTextNode(employee.getPosition()));
            employeeElem.appendChild(positionElem);

            Element salaryElem = doc.createElement("salary");
            salaryElem.appendChild(doc.createTextNode(String.format("%.2f", employee.getSalary())));
            employeeElem.appendChild(salaryElem);

            rootElement.appendChild(employeeElem);

            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            System.out.println("Saved employee to " + xmlFile.getName() + ": " + employee.getName());
        } catch (Exception e) {
            System.out.println("Error saving to " + xmlPath + ": " + e.getMessage());
        }
    }

    public Employee loadFromDatabase(int id) {
        try {
            File xmlFile = xmlPath.toFile();
            if (!xmlFile.exists()) {
                System.out.println("Looking for: " + xmlFile.getAbsolutePath());
                System.out.println(xmlFile.getName() + " file not found.");
                return null;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            javax.xml.xpath.XPathFactory xPathFactory = javax.xml.xpath.XPathFactory.newInstance();
            javax.xml.xpath.XPath xpath = xPathFactory.newXPath();
            String expression = String.format("/employees/employee[id=%d]", id);

            Node employeeNode = (Node) xpath.evaluate(expression, doc, javax.xml.xpath.XPathConstants.NODE);

            if (employeeNode != null && employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) employeeNode;

                int empId = Integer.parseInt(elem.getElementsByTagName("id").item(0).getTextContent());
                String empName = elem.getElementsByTagName("name").item(0).getTextContent();
                String empPosition = elem.getElementsByTagName("position").item(0).getTextContent();
                String empSalary = elem.getElementsByTagName("salary").item(0).getTextContent();

                return new Employee(empId, empName, empPosition, Double.parseDouble(empSalary));
            } else {
                System.out.println("Employee with ID " + id + " not found in " + xmlFile.getName() + ".");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error loading from " + xmlPath + ": " + e.getMessage());
            return null;
        }
    }
}
