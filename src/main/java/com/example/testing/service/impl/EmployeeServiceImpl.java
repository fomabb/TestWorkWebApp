package com.example.testing.service.impl;

import com.example.testing.dao.EmployeeDAO;
import com.example.testing.dto.EmployeeDataDTO;
import com.example.testing.dto.EmployeeRegistrationDTO;
import com.example.testing.dto.EmployeeUpdate;
import com.example.testing.exception.ExceptionCode;
import com.example.testing.model.Employee;
import com.example.testing.model.JobTitle;
import com.example.testing.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployerService {

    private final EmployeeDAO employeeDAO;

    @Override
    public List<EmployeeDataDTO> getAllEmployee() {
        return employeeDAO.getAllEmployee().stream()
                .map(employee -> new EmployeeDataDTO(employee.getEmployee_id(), employee.getFirst_name(),
                        employee.getLast_name(), employee.getDepartment_id(), employee.getJob_title(),
                        employee.getGender()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDataDTO getById(long id) {
        EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
        Employee employee = employeeDAO.getById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.NOT_EXISTING_EMPLOYEE.getErrorCode()));

        employeeDataDTO.setEmployee_id(employee.getEmployee_id());
        employeeDataDTO.setFirst_name(employee.getFirst_name());
        employeeDataDTO.setLast_name(employee.getLast_name());
        employeeDataDTO.setDepartment_id(employee.getDepartment_id());
        employeeDataDTO.setJob_title(employee.getJob_title());
        employeeDataDTO.setGender(employee.getGender().toUpperCase(Locale.ROOT));

        return employeeDataDTO;
    }

    @Override
    public void employeeRegistration(EmployeeRegistrationDTO employeeRegistrationDTO) {
        Employee employee = new Employee();
        employee.setFirst_name(employeeRegistrationDTO.getFirst_name());
        employee.setLast_name(employeeRegistrationDTO.getLast_name());
        employee.setDepartment_id(employeeRegistrationDTO.getDepartment_id());

        switch (employee.getDepartment_id()) {

            case 1:
                employee.setJob_title(JobTitle.valueOf(JobTitle.DEVELOPER.toString().toUpperCase(Locale.ROOT)));
                break;

            case 2:
                employee.setJob_title(JobTitle.valueOf(JobTitle.TESTER.toString().toUpperCase(Locale.ROOT)));
                break;

            case 3:
                employee.setJob_title(JobTitle.valueOf(JobTitle.MANAGER.toString().toUpperCase(Locale.ROOT)));
                break;

            default:
                throw new EntityNotFoundException(ExceptionCode.NOT_EXISTING_EMPLOYEE.getErrorCode());
        }

        if (employeeRegistrationDTO.getGender().equalsIgnoreCase("MEN") ||
                employeeRegistrationDTO.getGender().equalsIgnoreCase("WOMEN")) {
            employee.setGender(employeeRegistrationDTO.getGender().toUpperCase(Locale.ROOT));
        } else {
            throw new EntityNotFoundException(ExceptionCode.NOT_EXISTING_GENDER.getErrorCode());
        }

        employeeDAO.employeeAdd(employee);
    }

    @Override
    public String employeeDelete(long id) {
        getById(id);
        employeeDAO.employeeDelete(id);

        return "delete employee with id " + id;
    }

    @Override
    public void updateEmployee(long id, EmployeeUpdate employeeUpdate) {
        getById(id);

        switch (employeeUpdate.getDepartment_id()) {

            case 1:
                employeeUpdate.setJob_title(JobTitle.valueOf(JobTitle.DEVELOPER.toString().toUpperCase(Locale.ROOT)));
                break;

            case 2:
                employeeUpdate.setJob_title(JobTitle.valueOf(JobTitle.TESTER.toString().toUpperCase(Locale.ROOT)));
                break;

            case 3:
                employeeUpdate.setJob_title(JobTitle.valueOf(JobTitle.MANAGER.toString().toUpperCase(Locale.ROOT)));
                break;

            default:
                throw new EntityNotFoundException(ExceptionCode.NOT_EXISTING_DEPARTMENT.getErrorCode());
        }

        employeeDAO.updateEmployee(id, employeeUpdate);
    }

    @Override
    public List<EmployeeDataDTO> getDepartmentId(int id) {

        List<EmployeeDataDTO> employeeDataDTO = employeeDAO.getDepartmentId(id).stream()
                .map(employee -> new EmployeeDataDTO(employee.getEmployee_id(), employee.getFirst_name(),
                        employee.getLast_name(), employee.getDepartment_id(), employee.getJob_title(),
                        employee.getGender()))
                .collect(Collectors.toList());
        if (employeeDataDTO.size() != 0) {
            return employeeDataDTO;
        } else {
            throw new EntityNotFoundException(ExceptionCode.NOT_EXISTING_DEPARTMENT.getErrorCode());
        }
    }
}

