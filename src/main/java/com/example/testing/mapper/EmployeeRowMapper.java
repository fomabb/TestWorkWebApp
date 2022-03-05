package com.example.testing.mapper;

import com.example.testing.model.Employee;
import com.example.testing.util.constant.employeeConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployee_id(rs.getLong(employeeConstant.ID));
        employee.setFirst_name(rs.getString(employeeConstant.NAME));
        employee.setLast_name(rs.getString(employeeConstant.SURNAME));
        employee.setDepartment_id(rs.getString(employeeConstant.DEPORT_ID));
        employee.setJob_title(rs.getString(employeeConstant.JOB));
        employee.setGender(rs.getString(employeeConstant.GENDER));

        return employee;
    }
}
