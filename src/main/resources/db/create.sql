SET MODE PostgreSQL;

CREATE DATABASE your_news;
\c your_news;

CREATE TABLE departments (
 id int PRIMARY KEY auto_increment,
 departmentName VARCHAR,
 description VARCHAR,
 numberOfEmployees VARCHAR
);

CREATE TABLE news (
 id int PRIMARY KEY auto_increment,
 title VARCHAR,
 content VARCHAR,
 departmentID INTEGER
);

CREATE TABLE employees (
 id int PRIMARY KEY auto_increment,
 EmployeeName VARCHAR,
 position VARCHAR,
 role VARCHAR,
 departmentId INTEGER

);

 CREATE TABLE departments_employees (
 id int PRIMARY KEY auto_increment,
 employeeid INTEGER,
 departmentid INTEGER
);

CREATE DATABASE your_news_test WITH TEMPLATE your_news