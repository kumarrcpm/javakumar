package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.req.EmployeeDeptReq;
import com.example.demo.res.EmployeeDeptRes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class TestServiceImpl {

	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	 @PersistenceContext
	 private EntityManager entityManager;
	
	public EmployeeDeptRes getemployeeDept() {
		// TODO Auto-generated method stub
		EmployeeDeptRes response = new EmployeeDeptRes();
		//List<EmployeeDeptRes> employeeDeptResList = new ArrayList<>();
		
		try {
			/*
			String sqlQuery = "SELECT D.DEPARTMENT_NAME FROM department D JOIN employee E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID WHERE E.EMPLOYEE_ID=100";
			Query query = entityManager.createNativeQuery(sqlQuery);
			List<String> departmentNames = query.getResultList();
			for (String departmentName : departmentNames) {
			    EmployeeDeptRes employeeDeptRes = new EmployeeDeptRes();
			    employeeDeptRes.setDepartmentName(departmentName);
			    employeeDeptResList.add(employeeDeptRes);
			}
			*/
			
			/*
			 * EmployeeDeptRes queryresponse=employeeRepository.findDeptName();
			 * response.setDepartmentName(queryresponse.getDepartmentName());
			 * employeeDeptResList.add(response);
			 */			

		CriteriaBuilder criteriaBuilder =  entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
		Join<Department, Employee> departmentJoin = employeeRoot.join("department");
		Predicate predicate =  criteriaBuilder.equal(employeeRoot.get("employeeId"),100L);
		criteriaQuery.select(departmentJoin.get("departmentName")).where(predicate);
		String departmentName = entityManager.createQuery(criteriaQuery).getSingleResult();
		response.setDepartmentName(departmentName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
