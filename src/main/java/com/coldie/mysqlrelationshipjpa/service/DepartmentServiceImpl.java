package com.coldie.mysqlrelationshipjpa.service;

import com.coldie.mysqlrelationshipjpa.model.Department;
import com.coldie.mysqlrelationshipjpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
