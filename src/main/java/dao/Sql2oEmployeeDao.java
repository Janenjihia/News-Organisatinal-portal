package dao;

import Interfaces.EmployeeDao;
import models.Employee;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEmployeeDao implements EmployeeDao {

    private final Sql2o sql2o;

    public Sql2oEmployeeDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Employee employee) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO employees(employeeName, position, role, departmentid) VALUES (:employeeName, :position, :role, :departmentId );";
            int id = (int) con.createQuery(sql, true)
                    .bind(employee)
                    .executeUpdate()
                    .getKey();
            employee.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex + "Unable to add user" );
        }

    }

    @Override
    public List<Employee> getAll() {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM employees;").executeAndFetch(Employee.class);
        }
    }

    @Override
    public Employee findById(int id) {
        try(Connection con = sql2o.open()) {
          String sql = "SELECT * FROM employees WHERE id = :id; ";
          return con.createQuery(sql)
                  .addParameter("id", id)
                  .executeAndFetchFirst(Employee.class);
        }
    }

    @Override
    public void deleteById(int id) {
        try(Connection con = sql2o.open()) {
            String sql = "DELETE FROM employees WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }

    @Override
    public void clearAll() {
        try(Connection con = sql2o.open()){
            String sql = "DELETE FROM employees;";
            con.createQuery(sql).executeUpdate();
        }

    }
}
