package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    public Employee setUpEmployee(){
        Employee Employee = new Employee("JANE", "Auditor", "Audit", 2);
        return Employee;
    }

    @Test
    void getEmployeeName() {
        Employee Employee = setUpEmployee();
        assertEquals("JANE", Employee.getEmployeeName());

    }

    @Test
    void getPosition() {
        Employee Employee = setUpEmployee();
        assertEquals("Auditor", Employee.getPosition());
    }

    @Test
    void getRole() {
        Employee Employee = setUpEmployee();
        assertEquals("Audit", Employee.getRole());
    }


    @Test
    void getDepartmentId() {
        Employee Employee = setUpEmployee();
        assertEquals(2, Employee.getDepartmentId());
    }


    @Test
    void testEquals() {
        Employee Employee = setUpEmployee();
        Employee Employee2 = setUpEmployee();
        assertEquals(true, Employee.equals(Employee2));
    }
}