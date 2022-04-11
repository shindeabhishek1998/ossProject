package com.xebia.arm.oss.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {
	public int empId;

	public String firstName;

	public String lastName;

	public String mobile;

	public String email;

	public int plantId;

	public List<EmployeeDto> empList;

	public String designation;

	private List<EmployeeDto> dtoList;

	private List<EmployeeDto> list;

	private int designationWiseEmpCount;

	private String employeeName;

	private Integer[] empIds;

	public Integer[] getEmpIds() {
		return empIds;
	}

	public void setEmpIds(Integer[] empIds) {
		this.empIds = empIds;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getDesignationWiseEmpCount() {
		return designationWiseEmpCount;
	}

	public void setDesignationWiseEmpCount(int designationWiseEmpCount) {
		this.designationWiseEmpCount = designationWiseEmpCount;
	}

	public Date dob;

	public List<EmployeeDto> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmployeeDto> empList) {
		this.empList = empList;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<EmployeeDto> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<EmployeeDto> dtoList) {
		this.dtoList = dtoList;
	}

	public int getEmpId() {
		return empId;
	}

	public List<EmployeeDto> getList() {
		return list;
	}

	public void setList(List<EmployeeDto> list) {
		this.list = list;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

}
