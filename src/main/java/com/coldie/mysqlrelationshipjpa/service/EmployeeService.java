package com.coldie.mysqlrelationshipjpa.service;

import com.coldie.mysqlrelationshipjpa.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    String deleteEmployeeById(Long id);
}
