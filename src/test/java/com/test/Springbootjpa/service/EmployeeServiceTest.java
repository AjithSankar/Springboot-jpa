package com.test.Springbootjpa.service;

import com.test.Springbootjpa.dao.EmployeeRepository;
import com.test.Springbootjpa.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeServiceTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findAll() {
        List<Employee> employees = employeeRepository.findAll();
        assertEquals(3, employees.size());
    }

    @Test
    void findById() {
    }
}