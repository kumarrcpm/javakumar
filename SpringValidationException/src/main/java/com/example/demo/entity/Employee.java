package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable{

	private static final Long SERIALVERSIONUID=1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="EMPLOYEE_ID")
private Long employeeId;


@Column(name="EMPLOYEE_NAME",length=100)
private String employeeName;

@Column(name="DEPARTMENT_ID")
private Long departmentId;
}
