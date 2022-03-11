package com.example.testing.dao;

import com.example.testing.dto.EmployeeUpdate;
import com.example.testing.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployee();

    Employee getById(long id);

    void employeeAdd(Employee user);

    void employeeDelete(long id);

    void updateEmployee(long id, EmployeeUpdate user);

    List<Employee> getDepartmentId(int id);
}
