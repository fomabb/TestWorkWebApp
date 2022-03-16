package com.example.testing.dao;

import com.example.testing.dto.EmployeeUpdate;
import com.example.testing.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    List<Employee> getAllEmployee();

    Optional<Employee> getById(long id);

    void employeeAdd(Employee employee);

    void employeeDelete(long id);

    void updateEmployee(long id, EmployeeUpdate employeeUpdate);

    List<Employee> getDepartmentId(int id);
}
