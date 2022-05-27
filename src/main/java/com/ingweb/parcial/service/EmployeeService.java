package com.ingweb.parcial.service;

import com.ingweb.parcial.exception.UserNotFoundException;
import com.ingweb.parcial.model.Employee;
import com.ingweb.parcial.repo.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



@Service
public class EmployeeService {

    private final employeeRepo employeeRepo;

    @Autowired
    public EmployeeService(employeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("user by id" + id + "was not found"));
    }

    public void deleteEmployed(long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
