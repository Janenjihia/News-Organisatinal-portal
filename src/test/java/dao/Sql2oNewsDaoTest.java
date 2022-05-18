package dao;

import models.Department;
import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oNewsDaoTest {

    private Sql2oDepartmentDao sql2oDepartmentDao;
    private static Connection conn;


    @Before
    public void setup() {
        String connect = "jdbc:postgresql://localhost:5432/your_news";
        Sql2o sql2o = new Sql2o(connect, "jane", "2022@1234" );
        Sql2oDepartmentDao sql2oDepartmentDao1=new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @Test
    public void  add_addsNewDepartment_true(){
        Department department = new Department( "blog","lifestyle blog","3");
        int id = department.getId();
        sql2oDepartmentDao.add(department);
        assertNotEquals(id,department.getId());
    }

    @Test
    public void  geAll_returnsDepartments_true(){
        Department department = new Department( "blog","lifestyle blog","3");
        Department department2 = new Department( "blog","lifestyle blog","3");
        sql2oDepartmentDao.add(department);
        sql2oDepartmentDao.add(department2);
        int expected = 2;
        assertEquals(expected,sql2oDepartmentDao.getAll().size());
    }


    @Test
    public void deleteById_DeletesCorrectMentor_true() {
        Department department = new Department( "blog","lifestyle blog","3");
        sql2oDepartmentDao.add(department);

        sql2oDepartmentDao.deleteById(department.getId());
        assertEquals(0, sql2oDepartmentDao.getAll().size());
    }


    @After
    public void closeConn() {
        conn.close();
    }

}