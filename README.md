# TestWorkWebApp
# RESTful Web-application is written using the following technologies: 
  - Maven 
  - JDBC 
  - MySQL DB 
  - Spring Boot
### Short description of the project
MainApp

### Prerequisites:
- Java 11
- MySQl

# Data model
## ER diagram for the data model
![image](https://user-images.githubusercontent.com/93200046/158175074-24864113-0cd6-49a2-80e3-017625fa1a9d.png)


## RESTful API

**1. API Description of general methods for Employee**

METHOD | PATH | DESCRIPTION
------------|-----|------------
POST | /api/users | register new employee
DELETE | /api/users/{id} | delete user by id
PUT | /api/users/{id} | update department by id
GET | /api/users | get all employee
GET | /api/users/{id} | get employee by id
GET | /api/users/department/{id} | get employee by department by id

### My application requests in Postman
