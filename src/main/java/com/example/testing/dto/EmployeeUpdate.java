package com.example.testing.dto;

import com.example.testing.model.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdate {

    private int department_id;

    private JobTitle job_title;
}
