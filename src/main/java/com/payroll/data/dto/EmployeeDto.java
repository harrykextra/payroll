package com.payroll.data.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EmployeeDto {

    @NotNull(message = "firstname must have a value")
    private String firstName;

    @NotNull(message = "lastname must have a value")
    private String lastName;

    @NotNull(message = "there should be a role")
    private String role;
}
