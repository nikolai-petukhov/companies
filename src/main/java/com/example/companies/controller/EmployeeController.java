package com.example.companies.controller;

import com.example.companies.model.CompanyType;
import com.example.companies.model.Employee;
import com.example.companies.repository.EmployeeRepository;
import com.example.companies.utils.exceptions.CompanyTypeNotFoundException;
import com.example.companies.utils.exceptions.EmployeeNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> geEmployeeList() {
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping()
    public Employee newEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("{id}")
    public Employee updateEmployee(
            @PathVariable("id") Employee employeeFromDb,
            @RequestBody Employee employee
    ) {
        BeanUtils.copyProperties(employee, employeeFromDb, "id");
        return employeeRepository.save(employeeFromDb);
    }


    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeRepository.deleteById(id);
    }
}
