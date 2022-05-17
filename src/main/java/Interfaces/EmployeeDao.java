package Interfaces;

import models.Department;
import models.Employee;

import java.util.List;

public interface EmployeeDao {

    //Create
    void add(Employee employee);

    //Read

    List<Employee> getAll();
    Employee findById(int id);


    //Update


    //Delete
    void deleteById(int id);
    void clearAll();

}
