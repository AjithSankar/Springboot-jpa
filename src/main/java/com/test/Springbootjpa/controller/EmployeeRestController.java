package com.test.Springbootjpa.controller;

import com.test.Springbootjpa.entity.Employee;
import com.test.Springbootjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        Optional<Employee> employee = employeeService.findById(id);
        if(!employee.isPresent()){
            throw new RuntimeException("Employee is not found");
        }
        return employee.get();
    }

    @PostMapping("/employees")
    public void save(@RequestBody Employee employee){

        employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable("id") int id){
        Optional<Employee> employee = employeeService.findById(id);
        if(!employee.isPresent()){
            throw new RuntimeException("Employee is not found");
        }
        employeeService.delete(id);
    }

    @PutMapping("/employees")
    public void update(@RequestBody Employee employee){
        Optional<Employee> employee1 = employeeService.findById(employee.getId());
        if(employee1.isPresent()){
            Employee oldEmp = employee1.get();
            oldEmp.setFirstName(employee.getFirstName());
            oldEmp.setLastName(employee.getLastName());
            oldEmp.setEmail(employee.getEmail());
            employeeService.save(oldEmp);

        }else{
            throw new RuntimeException("Employee not found");
        }

    }



}
