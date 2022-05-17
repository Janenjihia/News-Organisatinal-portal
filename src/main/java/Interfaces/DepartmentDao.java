package Interfaces;

import models.Department;
import models.Employee;

import java.util.List;

public interface DepartmentDao {

    //Create

    void add(Department department);

    void addEmployeeToDepartment(Department department, Employee employee);

    //Read

    List<Department> getAll();
    List<Employee> getAllEmployeesByDepartment(int departmentId);
    Department findById(int id);

    // Update
//    void update(int id, String departmentName, String description, int numberOfEmployees);

    //Delete

    void deleteById(int id);

    void clearAll();

}
