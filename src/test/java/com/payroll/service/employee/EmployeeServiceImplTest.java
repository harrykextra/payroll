package com.payroll.service.employee;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import com.payroll.web.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts ={"classpath:db/insert.sql"} )
class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;
    @BeforeEach
    void setUp() {
    }

    @Test
    void whenUpdateEmployeeIsCalledThenUpdateNotNullValues() throws EmployeeNotFoundException{

        Employee existingEmployee = employeeService.findById(12);
        assertThat(existingEmployee.getFirstName()).isEqualTo("Bobi");
        assertThat(existingEmployee.getLastName()).isEqualTo("Wine");
        assertThat(existingEmployee.getRole()).isEqualTo("HR");

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setRole("Accountant");

        Employee updatedEmployee = employeeService.update(employeeDto, 12);

        assertThat(updatedEmployee.getFirstName()).isEqualTo("Bobi");
        assertThat(updatedEmployee.getLastName()).isEqualTo("Wine");
        assertThat(updatedEmployee.getRole()).isEqualTo("Accountant");
    }
}