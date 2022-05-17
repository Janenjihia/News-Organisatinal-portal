import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oEmployeeDao;
import dao.Sql2oNewsDao;
import models.Department;
import models.Employee;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import response.ResponseArray;

import java.util.Collections;
import java.util.List;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(4567);
        String connect = "jdbc:postgresql://localhost:5432/your_news";
        Sql2o sql2o = new Sql2o(connect, "jane", "2022@1234" );
        Sql2oDepartmentDao sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        Sql2oEmployeeDao sql2oEmployeeDao = new Sql2oEmployeeDao(sql2o);
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao(sql2o);
        Connection conn = sql2o.open();
        Gson gson = new Gson();

        //Create Department
        post("/department/new", "application/json" ,(request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            sql2oDepartmentDao.add(department);
            response.status(200);
            return gson.toJson(department);
        });

        //List Departments
        get("/departments", "application/json",(request, response) -> {
            List<Department> list = sql2oDepartmentDao.getAll();
            ResponseArray responseArray =  new ResponseArray(200,"success");
            responseArray.setData(Collections.singletonList(list));
            System.out.println(list.size());
            response.status(200);
            return gson.toJson(list);
        });


        // Find Department by id
        get("/departments/:id", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("id"));
            return gson.toJson(sql2oDepartmentDao.findById(departmentId));
        });

        //Find all Employees in a Department
        get("/departments/:departmentId/employees", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            return  gson.toJson(sql2oDepartmentDao.getAllEmployeesByDepartment(departmentId));
        });


        //Create New Employee
        post("/departments/:departmentId/employee/new", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            Department newDepartment = sql2oDepartmentDao.findById(departmentId);
            Employee employee = gson.fromJson(request.body(), Employee.class);
            sql2oEmployeeDao.add(employee);
            employee.setDepartmentId(newDepartment.getId());
            sql2oDepartmentDao.addEmployeeToDepartment(newDepartment, employee);
            response.status(200);
            return gson.toJson(employee);
        });


        //List All Employees
        get("/employees", "application/json", (request, response) -> {
            List<Employee> employees = sql2oEmployeeDao.getAll();
            response.status(200);
            return gson.toJson(employees);
        });

        //Find Employee by Id
        get("/employee/:id", "application/json", (request, response) -> {
            int employeeId = Integer.parseInt(request.params("id"));
            return gson.toJson(sql2oEmployeeDao.findById(employeeId));
        });


        //Create News
        post("/news/new", "application/json", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            sql2oNewsDao.add(news);
            response.status(200);
            return gson.toJson(news);
        });


        //List all News
        get("/news", "application/json", (request, response) -> {
            List<News> news = sql2oNewsDao.getall();
            response.status(200);
            return gson.toJson(news);
        });

        //List news per Department
        get ("/news/:departmentId", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            return gson.toJson(sql2oNewsDao.getAllNewsByDepartment(departmentId));
        });

        
        after((request, response) -> {
            response.type("application/json");
        });
    }
}
