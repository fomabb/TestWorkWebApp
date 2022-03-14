package com.example.testing.dto;

import com.example.testing.model.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegistrationDTO {

    private long employee_id;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]{2,30}$")
    private String first_name;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]{2,30}$")
    private String last_name;

    private int department_id;

    private Job job_title;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]{3,5}$")
    private String gender;
}
