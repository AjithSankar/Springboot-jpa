package com.test.Springbootjpa.service;

import com.test.Springbootjpa.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();
    Optional<Employee> findById(int id);
    void save(Employee employee);
    void delete(int id);
}
