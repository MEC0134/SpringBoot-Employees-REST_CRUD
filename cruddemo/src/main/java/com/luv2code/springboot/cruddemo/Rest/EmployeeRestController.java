package com.luv2code.springboot.cruddemo.Rest;

import com.luv2code.springboot.cruddemo.Entity.Employee;
import com.luv2code.springboot.cruddemo.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/employees")

    public List<Employee> displayAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee displayEmployee(@PathVariable int empId) {

        Employee employeeFound = employeeService.findById(empId);

        if(employeeFound == null) {
            throw new RuntimeException("Employee cannot be found");
        }

        return employeeFound;
    }


    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }


    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<String> removeEmployee(@PathVariable int empId) {

        Employee theEmployee = employeeService.findById(empId);

        if(theEmployee == null) {
            throw new RuntimeException("Sorry, employee does not exist!");
        }

        // Return a JSON response indicating success
        employeeService.deleteById(empId);
        String jsonResponse = "{\"message\": \"Employee with id: " + empId + " deleted successfully\"}";
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }


}
