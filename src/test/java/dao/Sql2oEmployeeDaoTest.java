package dao;

import models.Department;
import models.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oEmployeeDaoTest {
    Sql2oEmployeeDao sql2oEmployeeDao;
    private static Connection conn;


    @Before
    public void setup() {
        String connect = "jdbc:postgresql://localhost:5432/your_news";
        Sql2o sql2o = new Sql2o(connect, "jane", "2022@1234" );
        Sql2oEmployeeDao sql2oEmployeeDao =new Sql2oEmployeeDao(sql2o);
        conn = sql2o.open();
    }

    @Test
    public void  add_addsNewEmployee_true(){
        Employee employee= new Employee("Addy", "Editor", "Editing", 2);
        int id = employee.getId();
        sql2oEmployeeDao.add(employee);
        assertNotEquals(id,employee.getId());
    }

    @Test
    public void  geAll_returnsEmployees_true(){
        Employee employee= new Employee("Addy", "Editor", "Editing", 2);
        Employee employee2= new Employee("Addy", "Editor", "Editing", 2);
        sql2oEmployeeDao.add(employee);
        sql2oEmployeeDao.add(employee2);
        int expected = 2;
        assertEquals(expected,sql2oEmployeeDao.getAll().size());
    }


    @Test
    public void deleteById_DeletesCorrectEmployee_true() {
        Employee employee= new Employee("Addy", "Editor", "Editing", 2);
        sql2oEmployeeDao.add(employee);
        sql2oEmployeeDao.deleteById(employee.getId());
        assertEquals(0, sql2oEmployeeDao.getAll().size());
    }


    @After
    public void closeConn() {
        conn.close();
    }

}