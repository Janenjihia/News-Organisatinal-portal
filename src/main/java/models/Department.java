package models;

import java.util.Objects;

public class Department {
    private String departmentName;
    private String description;
    private String numberOfEmployees;
    private int id;

    public Department(String departmentName, String description, String numberOfEmployees){
        this.departmentName= departmentName;
        this.description= description;
        this.numberOfEmployees= numberOfEmployees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && departmentName.equals(that.departmentName) && description.equals(that.description) && numberOfEmployees.equals(that.numberOfEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, description, numberOfEmployees, id);
    }
}
