package com.coldie.mysqlrelationshipjpa.response;

import java.util.List;

public class EmployeeResponse {
private Long id;

private String employeeName;

private List<String> departments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", departments=" + departments +
                '}';
    }
}
