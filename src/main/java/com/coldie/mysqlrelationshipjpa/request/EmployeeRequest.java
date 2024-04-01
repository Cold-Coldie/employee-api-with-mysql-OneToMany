package com.coldie.mysqlrelationshipjpa.request;

import java.util.List;

public class EmployeeRequest {
    private String name;

    private List<String> department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
