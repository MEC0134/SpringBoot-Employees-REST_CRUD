package com.luv2code.springboot.cruddemo.Service;

import com.luv2code.springboot.cruddemo.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteById(int id);

}
