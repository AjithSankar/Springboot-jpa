package com.test.Springbootjpa.controller;

import com.test.Springbootjpa.dao.EmployeeRepository;
import com.test.Springbootjpa.entity.Employee;
import com.test.Springbootjpa.service.EmployeeService;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRestControllerTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getAllEmployeesTest() {
        List<Employee> employees = employeeRepository.findAll();
        assertEquals(3, employees.size());
    }

    @Test
    public void getEmployeeTest() {
        Optional<Employee> employee = employeeRepository.findById(1);
        if (!employee.isPresent()) {
            throw new RuntimeException("Employee not found");
        }
        Employee emp = employee.get();
        String name = emp.getFirstName();
        System.out.println("Employee name : " + name);
        assertEquals("Ajith", name);
    }

    @Test
    public void deleteTest() {
        employeeRepository.deleteById(1);
        List<Employee> employees = employeeRepository.findAll();
        assertEquals(2,employees.size());

    }


}
