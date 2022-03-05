package com.example.testing.service;

import com.example.testing.dto.EmployeeDataDTO;
import com.example.testing.dto.EmployeeRegistrationDTO;
import com.example.testing.dto.EmployeeUpdate;

import java.util.List;

public interface EmployerService {

    List<EmployeeDataDTO> getAllEmployee();

    EmployeeDataDTO getById(long id);

    void employeeRegistration(EmployeeRegistrationDTO userRegistrationDTO);

    String employeeDelete(long id);

    void updateEmployee(long id, EmployeeUpdate user);
}
