### Newsportal

Author JANE NJIHIA

## Brief description
NewsPortal is an Organisational news dissemination application.
Users can post news to the general staff or to staff in a specific department.

## User Requirements

The user would like to;

- Create departments
- Create news and categorize then as general or belonging to a specific department
- Add users to a department where one department has many users
- See individual users, their details like position,role and department.
- See department details like name, details and number of employees in the department
- See all users from a specific department and news relating to that department
- Post general news or news relating s a specific department.

## How it works

The application has four model classes;
-Employee
- News
- Department

DepartmentNews inherits from News.
In the database, model User maps to table users, model Department maps to table departments while model
News and model DepartmentNews map to one table news through single table inheritance.

Three dao interfaces and their corresponding implementation classes;
- Interface EmployeeDao implemented by class Sql2oEmployeeDao, handles CRUD data operations related to model User.
- Interface NewsDao implemented by class Sql2oNewsDao, handles CRUD data operations related to model News and DepartmentNews.
- Interface DepartmentDao implemented by class Sql2oDepartmentDao, handles CRUD data operations related to model Department.


## Setup Instructions
Fork the project on github  https://github.com/Janenjihia/upgraded-fiesta.git then clone it to your local repo.

## Technology used
- Java
- SparkJava
- Gradle
- JUnit 4
- Git VCS
- IntelliJ IDEA Community Edition
- Postgres
- Sql2o

## Known Bugs
There are no known bugs. Please submit those you find for correction.

## License
This project is licensed under the MIT Open Source license.
