package com.payroll.service.util;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    EmployeeMapper employeeMapper;

    @BeforeEach
    void setUp(){
        employeeMapper = Mappers.getMapper(EmployeeMapper.class);
    }

    @Test
    void givenEmployeeDtoSourceWhenMappedThenMapCorrectlyTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Susan");
        employeeDto.setLastName(null);
        employeeDto.setRole(null);

        Employee employee = new Employee();
        employee.setFirstName("Bob");
        employee.setLastName("Dan");
        employee.setRole("Mister");


        employeeMapper.updateEmployeeFromDto(employeeDto, employee);

        assertThat(employee.getFirstName()).isEqualTo("Susan");
        assertThat(employee.getLastName()).isEqualTo("Dan");
        assertThat(employee.getRole()).isEqualTo("Mister");
    }

}