package com.example.testing.dto;

import com.example.testing.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegistrationDTO {

    private long employee_id;

    private String first_name;

    private String last_name;

    private String department_id;

    private String job_title;

    private String gender;
}
