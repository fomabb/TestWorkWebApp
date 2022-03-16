package com.example.testing.dto;

import com.example.testing.model.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdate {

    @NotEmpty
    @Pattern(regexp = "[1,2,3]")
    private int department_id;

    private JobTitle job_title;
}
