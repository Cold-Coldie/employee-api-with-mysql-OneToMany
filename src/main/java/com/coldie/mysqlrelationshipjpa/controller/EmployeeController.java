package com.coldie.mysqlrelationshipjpa.controller;

import com.coldie.mysqlrelationshipjpa.model.Department;
import com.coldie.mysqlrelationshipjpa.model.Employee;
import com.coldie.mysqlrelationshipjpa.request.EmployeeRequest;
import com.coldie.mysqlrelationshipjpa.response.EmployeeResponse;
import com.coldie.mysqlrelationshipjpa.service.DepartmentService;
import com.coldie.mysqlrelationshipjpa.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Operation(
            description = "Get all employees.",
            summary = "This endpoint returns all the Employees available. Each employee also contains it's corresponding departments."

    )
    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeResponse>> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeResponse> employeeResponses = new ArrayList<>();

        employees.forEach(employee -> {
           EmployeeResponse employeeResponse = new EmployeeResponse();

           employeeResponse.setId(employee.getId());
           employeeResponse.setEmployeeName(employee.getName());

           List<String> departments = new ArrayList<>();
           for (Department d : employee.getDepartments()) {
               departments.add(d.getName());
           }
           employeeResponse.setDepartments(departments);

           employeeResponses.add(employeeResponse);
        });

        return new ResponseEntity<List<EmployeeResponse>>(employeeResponses, HttpStatus.OK);
    }

    @Operation(
            description = "Get a single employee by \"id\".",
            summary = "This endpoint returns an Employee available having the \"id\" provided. It comes with its corresponding departments."

    )
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @Operation(
            description = "Create a new Employee",
            summary = "This endpoint is used to create a new Employee with its corresponding departments."

    )
    @PostMapping("/employee")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        Employee employee = new Employee(employeeRequest);
        employee = employeeService.saveEmployee(employee);

        for (String s : employeeRequest.getDepartment()) {
            Department department = new Department();
            department.setName(s);
            department.setEmployee(employee);

            departmentService.saveDepartment(department);
        }

        return new ResponseEntity<String>("Records saved successfully", HttpStatus.CREATED);
    }

    @Operation(
            description = "Update an Employee",
            summary = "This endpoint is used to update the details of an Employee. The \"id\" of the Employee must be provided"

    )
    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @Operation(
            description = "Delete an Employee",
            summary = "This endpoint is used to delete an Employee from the database. The \"id\" of the Employee must be provided"

    )
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return new ResponseEntity<String>(employeeService.deleteEmployeeById(id), HttpStatus.ACCEPTED);
    }
}
