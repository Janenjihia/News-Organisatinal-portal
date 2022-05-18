//package dao;
//import models.Department;
//import org.junit.After;
//import org.junit.jupiter.api.Test;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//public class Sql2ODepartmentDaoTest {
//    private Sql2oDepartmentDao sql2oDepartmentDao;
//    private static Connection conn;
//
//
//    @Before
//    public void setup() {
//        String connect = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connect, "", "");
//        Sql2oDepartmentDao sql2oDepartmentDao1=new Sql2oDepartmentDao(sql2o);
//        conn = sql2o.open();
//    }
//
//    @Test
//    public void  add_addsNewDepartment_true(){
//        Department department = new Department( "blog","lifestyle blog","5", 2 );
//        int id = department.getId();
//        sql2oDepartmentDao.add(department);
//        assertNotEquals(id,department.getId());
//    }
//
//    @Test
//    public void  geAll_returnsDepartments_true(){
//        Department department = new Department( "blog","lifestyle blog",5 );
//        Department department2 = new Department( "blog","lifestyle blog",5 );
//        sql2oDepartmentDao.add(department);
//        sql2oDepartmentDao.add(department2);
//        int expected = 2;
//        assertEquals(expected,sql2oDepartmentDao.getAll().size());
//    }
//
//    @Test
//    public void update_updatesDepartmentDetails_true() {
//        Department department = new Department( "blog","lifestyle blog",5);
//        sql2oDepartmentDao.add(department);
//        department.setName("+blog");
//        sql2oDepartmentDao.update(department.getId(),department);
//        Department updatedDepartment= sql2oDepartmentDao.findById(department.getId());
//        assertNotEquals("blog", updatedDepartment.getDepartmentName());
//    }
//
//    @Test
//    public void deleteById_DeletesCorrectMentor_true() {
//        Department department = new Department( "blog","lifestyle blog",5 );
//        sql2oDepartmentDao.add(department);
//
//        sql2oDepartmentDao.deleteById(department.getId());
//        assertEquals(0, sql2oDepartmentDao.getAll().size());
//    }
//
//
//    @After
//    public void closeConn() {
//        conn.close();
//    }
//
//}