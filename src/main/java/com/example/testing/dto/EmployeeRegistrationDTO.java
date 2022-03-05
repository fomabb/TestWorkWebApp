package com.example.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegistrationDTO {

    private long employee_id;

    @Pattern(regexp = "^[a-zA-Z]{2,30}$")
    private String first_name;

    @Pattern(regexp = "^[a-zA-Z]{2,30}$")
    private String last_name;

    private String department_id;

    @Pattern(regexp = "^[a-zA-Z]{2,30}$")
    private String job_title;

    @Pattern(regexp = "^[a-zA-Z]{3,5}$")
    private String gender;
}
