package Interfaces;

import models.News;

import java.util.Collection;
import java.util.List;

public interface NewsDao {

    //create
    void add(News news);

    //Read
    List<News> getAll();

    List<News> getall();

    List<News> getAllNewsByDepartment(int departmentId);
    News findById(int id);

    //Update


    //Delete
    void deleteById(int id);
    void clearAll();

}
