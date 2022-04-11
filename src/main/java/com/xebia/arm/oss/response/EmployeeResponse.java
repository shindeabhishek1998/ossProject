package com.xebia.arm.oss.response;

import java.util.List;

import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;

public class EmployeeResponse {

	private int statusCode;

	private String status;

	private boolean result;

	private String message;

	private List<EmployeeDto> userList;

	private List<EmployeeDetails> empList;

	private List<EmployeeDto> dtoList;

	private EmployeeDetails empDetails;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<EmployeeDto> getUserList() {
		return userList;
	}

	public void setUserList(List<EmployeeDto> userList) {
		this.userList = userList;
	}

	public List<EmployeeDetails> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmployeeDetails> empList) {
		this.empList = empList;
	}

	public List<EmployeeDto> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<EmployeeDto> dtoList) {
		this.dtoList = dtoList;
	}

	public EmployeeDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmployeeDetails empDetails) {
		this.empDetails = empDetails;
	}

}
