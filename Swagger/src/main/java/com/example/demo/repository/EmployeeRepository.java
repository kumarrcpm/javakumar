package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.example.demo.res.EmployeeDeptRes;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

@Query(value="SELECT D.DEPARTMENT_NAME FROM department D JOIN employee E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID WHERE E.EMPLOYEE_ID=100;", nativeQuery = true)
EmployeeDeptRes findDeptName();
}
