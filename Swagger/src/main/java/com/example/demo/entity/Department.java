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

@Table(name="DEPARTMENT")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable{

	private static final Long serialversionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name="DEPARTMENT_NAME",length=100)
	private String departmentName;
}
