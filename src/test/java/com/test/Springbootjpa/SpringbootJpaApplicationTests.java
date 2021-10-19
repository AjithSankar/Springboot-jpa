package com.test.Springbootjpa;

import com.test.Springbootjpa.dao.EmployeeRepository;
import com.test.Springbootjpa.entity.Employee;
import com.test.Springbootjpa.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringbootJpaApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @Test
    public void getUsers() {
        Mockito.when(employeeRepository.findAll()).thenReturn(
                Stream.of(new Employee(1, "Ajith", "Sankar", "ajith.sankar@gmail.com"), new Employee(2, "Ravi", "Kumar", "ravi.kumar@gmail.com"))
                        .collect(Collectors.toList())
        );
        assertEquals(2,employeeService.findAll().size());
    }

}
