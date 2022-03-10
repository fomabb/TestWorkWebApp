package com.example.testing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private long employee_id;

    private String first_name;

    private String last_name;

    private int department_id;

    private Job job_title;

    private String gender;
}
