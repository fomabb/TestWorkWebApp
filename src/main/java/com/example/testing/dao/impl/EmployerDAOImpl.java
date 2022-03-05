package com.example.testing.dao.impl;

import com.example.testing.dao.EmployeeDAO;
import com.example.testing.dto.EmployeeUpdate;
import com.example.testing.mapper.EmployeeRowMapper;
import com.example.testing.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployerDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_USER_SQL = "SELECT * FROM employee";
    private static final String ADD_USER_SQL = "INSERT INTO employee VALUES(0,?,?,?,?,?)";
    private static final String GET_BY_ID_SQL = "SELECT * FROM employee WHERE employee_id=?";
    private static final String DELETE_USER_SQL = "DELETE FROM employee WHERE employee_id=?";
    private static final String UPDATE_USER_SQL = "UPDATE employee SET department_id=?, job_title=? WHERE employee_id=?";

    @Override
    public List<Employee> getAllEmployee() {
        return jdbcTemplate.query(GET_ALL_USER_SQL, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee getById(long id) {
        return jdbcTemplate.query(GET_BY_ID_SQL, new Object[]{id}, new EmployeeRowMapper()).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void employeeAdd(Employee employee) {
        jdbcTemplate.update(ADD_USER_SQL, employee.getFirst_name(), employee.getLast_name(),
                employee.getDepartment_id(), employee.getJob_title(), employee.getGender());
    }

    @Override
    public void employeeDelete(long id) {
        System.out.println(id);
        jdbcTemplate.update(DELETE_USER_SQL, id);
    }

    @Override
    public void updateEmployee(long id, EmployeeUpdate employee) {
        jdbcTemplate.update(UPDATE_USER_SQL, employee.getDepartment_id(), employee.getJob_title(), id);
    }
}