package com.xebia.arm.oss.dto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {

	private int id;

	public String firstName;

	public String lastName;

	public String mobile;

	public String email;

	private List<EmployeeDto> empList;

	private String address;

	private int plantId;

	private int empId;

	/*
	 * public static void test1() { private List<EmployeeDto> empList = new
	 * ArrayList<>(); EmployeeDto obj1 = new EmployeeDto();
	 * obj1.setFirstName("Abhishek"); obj1.setFirstName("SHinde");
	 * 
	 * EmployeeDto obj2 = new EmployeeDto(); obj1.setFirstName("Ananta");
	 * obj1.setFirstName("Kolhe");
	 * 
	 * empList.add(obj1); empList.add(obj2); }
	 */

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

	public List<EmployeeDto> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmployeeDto> empList) {
		this.empList = empList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
