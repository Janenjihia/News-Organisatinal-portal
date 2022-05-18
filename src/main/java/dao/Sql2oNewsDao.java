package dao;

import Interfaces.NewsDao;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {
    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news(title, content, departmentid) VALUES (:title, :content, :departmentId);";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException ex){
            System.out.println("Error in inserting news" + ex);
        }

    }

    @Override
    public List<News> getAll() {
        String sql = "SELECT * FROM news";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(News.class);
        }
    }

    @Override
    public List<News> getall() {
        String sql = "SELECT * FROM news";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(News.class);
        }
    }

    @Override
    public List<News> getAllNewsByDepartment(int departmentId) {
        String sql = "SELECT * FROM news WHERE departmentId = :departmentId";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int id) {
            String sql = "SELECT * FROM news where id = :id";
            try(Connection con = sql2o.open()){
                return con.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetchFirst(News.class);
            }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM news WHERE id =:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println("Error in deleting news" + ex);
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM news";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch ( Sql2oException ex){
            System.out.println("Error" + ex);
        }

    }
}
