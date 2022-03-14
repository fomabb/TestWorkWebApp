package com.example.testing.controller;

import com.example.testing.dto.EmployeeDataDTO;
import com.example.testing.dto.EmployeeRegistrationDTO;
import com.example.testing.dto.EmployeeUpdate;
import com.example.testing.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Validated
public class EmployeeController {

    private final EmployerService employerService;

    @GetMapping("/hello")
    public String read() {
        return "Hello";
    }

    @GetMapping
    public List<EmployeeDataDTO> getAllEmployee() {
        return employerService.getAllEmployee();
    }

    @GetMapping("/{id}")
    EmployeeDataDTO getById(@PathVariable long id) {
        return employerService.getById(id);
    }

    @PostMapping("/add")
    void employeeRegistration(@Validated @RequestBody EmployeeRegistrationDTO employee) {
        employerService.employeeRegistration(employee);
    }

    @DeleteMapping("/{id}")
    String employeeDelete(@PathVariable("id") long id) {
        return employerService.employeeDelete(id);
    }

    @PutMapping("/{id}")
    void updateEmployee(@Validated @PathVariable long id, @RequestBody EmployeeUpdate employee) {
        employerService.updateEmployee(id, employee);
    }

    @GetMapping("department/{id}")
    List<EmployeeDataDTO> getDepartmentId(@Validated @PathVariable int id) {
        return employerService.getDepartmentId(id);
    }
}
