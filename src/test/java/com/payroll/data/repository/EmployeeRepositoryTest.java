package com.payroll.data.repository;

import com.payroll.data.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"classpath:db/insert.sql"})
@Slf4j
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void updateEmployeeRecordTest(){

        Employee employee = employeeRepository.findById(12).orElse(null);
        assertThat(employee).isNotNull();
        assertThat(employee.getFirstName()).isEqualTo("Bobi");
        assertThat(employee.getLastName()).isEqualTo("Wine");

        log.info("employee before save", employee);

        employee.setFirstName("John");

        employeeRepository.save(employee);
        assertThat(employee.getFirstName()).isEqualTo("John");
        assertThat(employee.getLastName()).isEqualTo("Wine");
        assertThat(employee.getRole()).isEqualTo("HR");

        log.info("Employee after save", employee);
    }
}