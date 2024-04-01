package com.coldie.mysqlrelationshipjpa.repository;

import com.coldie.mysqlrelationshipjpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // @Query("FROM Employee e WHERE e.department.name = :name")
   // List<Employee> findByDepartmentName(String name);
}
