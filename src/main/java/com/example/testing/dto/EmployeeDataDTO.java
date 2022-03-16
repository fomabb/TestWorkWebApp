package com.example.testing.dto;

import com.example.testing.model.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDataDTO {

    private long employee_id;

    private String first_name;

    private String last_name;

    private int department_id;

    private JobTitle job_title;

    private String gender;
}
