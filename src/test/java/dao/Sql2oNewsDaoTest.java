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

    Sql2oNewsDao sql2oNewsDao;
    private static Connection conn;


    @Before
    public void setup() {
        String connect = "jdbc:postgresql://localhost:5432/your_news";
        Sql2o sql2o = new Sql2o(connect, "jane", "2022@1234" );
        Sql2oNewsDao sql2oNewsDao=new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @Test
    public void  add_addsNews_true(){
        News news =new News("Tourism", "Nile perch", 8);
        int id = news.getId();
        sql2oNewsDao.add(news);
        assertNotEquals(id,news.getId());
    }

    @Test
    public void  geAll_returnsNews_true(){
        News news =new News("Tourism", "Nile perch", 8);
        News news2 =new News("Tourism", "Nile perch", 8);
        sql2oNewsDao.add(news);
        sql2oNewsDao.add(news2);
        int expected = 2;
        assertEquals(expected,sql2oNewsDao.getAll().size());
    }


    @Test
    public void deleteById_DeletesCorrectMentor_true() {
        News news =new News("Tourism", "Nile perch", 8);
        sql2oNewsDao.add(news);
        sql2oNewsDao.deleteById(news.getId());
        assertEquals(0, sql2oNewsDao.getAll().size());
    }


    @After
    public void closeConn() {
        conn.close();
    }

}