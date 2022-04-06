package com.xebia.arm.oss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_salary")
public class Salary {

	@Id  // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	@Column(name = "sal_id")
	private int id;

	@Column(name = "employee_id")
	private int empId;

	@Column(name = "salary")
	private double salary;

}
