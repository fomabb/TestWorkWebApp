package com.example.testing.service.impl;

import com.example.testing.dao.EmployeeDAO;
import com.example.testing.dto.EmployeeDataDTO;
import com.example.testing.dto.EmployeeRegistrationDTO;
import com.example.testing.dto.EmployeeUpdate;
import com.example.testing.model.Employee;
import com.example.testing.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployerService {

    private final EmployeeDAO userDAO;

    @Override
    public List<EmployeeDataDTO> getAllEmployee() {
        return userDAO.getAllEmployee().stream()
                .map(employee -> new EmployeeDataDTO(employee.getEmployee_id(), employee.getFirst_name(),
                        employee.getLast_name(), employee.getDepartment_id(), employee.getJob_title(),
                        employee.getGender()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDataDTO getById(long id) {
        EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
        Employee employee = userDAO.getById(id);
        employeeDataDTO.setEmployee_id(employee.getEmployee_id());
        employeeDataDTO.setFirst_name(employee.getFirst_name());
        employeeDataDTO.setLast_name(employee.getLast_name());
        employeeDataDTO.setDepartment_id(employee.getDepartment_id());
        employeeDataDTO.setGender(employee.getGender().toUpperCase(Locale.ROOT));


        return employeeDataDTO;
    }

    @Override
    public void employeeRegistration(EmployeeRegistrationDTO userRegistrationDTO) {
        Employee employee = new Employee();
        employee.setEmployee_id(employee.getEmployee_id());
        employee.setFirst_name(employee.getFirst_name());
        employee.setLast_name(employee.getLast_name());
        employee.setDepartment_id(employee.getDepartment_id());
        employee.setGender(employee.getGender().toUpperCase(Locale.ROOT));

        userDAO.employeeAdd(employee);
    }

    @Override
    public String employeeDelete(long id) {
        userDAO.employeeDelete(id);

        return "delete employee with id " + id;
    }

    @Override
    public void updateEmployee(long id, EmployeeUpdate employee) {
        getById(id);

        userDAO.updateEmployee(id, employee);
    }
}
