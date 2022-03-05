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

    private final EmployerService userService;

    @GetMapping("/hello")
    public String read() {
        return "Hello";
    }

    @GetMapping
    public List<EmployeeDataDTO> getAllUser() {
        return userService.getAllEmployee();
    }

    @GetMapping("/{id}")
    EmployeeDataDTO getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    void employeeRegistration(@Validated @RequestBody EmployeeRegistrationDTO userRegistrationDTO) {
        userService.employeeRegistration(userRegistrationDTO);
    }

    @DeleteMapping("/{id}")
    String employeeDelete(@PathVariable("id") long id) {
       return userService.employeeDelete(id);
    }

    @PutMapping("/{id}")
    void updateEmployee(@Validated @PathVariable long id, @RequestBody EmployeeUpdate employee) {
        userService.updateEmployee(id, employee);
    }
}
