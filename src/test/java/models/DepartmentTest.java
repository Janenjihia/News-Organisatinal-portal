package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    public Department setUpDepartment(){
        Department testDepartment = new Department("Tourism", "Nile perch", "2");
        return testDepartment;
    }

    @Test
    void getName_correctlyReturnsTheName() {
        Department testDepartment = setUpDepartment();
        assertEquals("Tourism", testDepartment.getName());

    }


    @Test
    void getDescription_correctlyReturnsTheDescription() {
        Department testDepartment = setUpDepartment();
        assertEquals("Nile perch", testDepartment.getDescription());
    }

    @Test
    void getNumberOfEmployees_correctlyReturnsNumberOfEmployees() {
        Department testDepartment = setUpDepartment();
        assertEquals("2", testDepartment.getNumberOfEmployees());
    }


    @Test
    void testEquals() {
        Department testDepartment = new Department("Tourism", "Nile perch", "2");
        Department testDepartment2 = new Department("Tourism", "Nile perch", "2");
        assertTrue(testDepartment.equals(testDepartment2));
    }

}