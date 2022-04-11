package com.xebia.arm.oss.Employeeresponse;

import java.util.List;

import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;

public class EmployeeResponse {
	private int statusCode;

	private String status;

	private boolean result;

	private EmployeeDto ed;

	public EmployeeDto getEd() {
		return ed;
	}

	public void setEd(EmployeeDto ed) {
		this.ed = ed;
	}

	private String message;
	private List<EmployeeDetails> empList;
	private List<EmployeeDto> dtoList;
	private List<EmployeeDto> designationWiseEmpCount;

	public List<EmployeeDto> getDesignationWiseEmpCount() {
		return designationWiseEmpCount;
	}

	public void setDesignationWiseEmpCount(List<EmployeeDto> designationWiseEmpCount) {
		this.designationWiseEmpCount = designationWiseEmpCount;
	}

	public List<EmployeeDto> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<EmployeeDto> dtoList) {
		this.dtoList = dtoList;
	}

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

	public List<EmployeeDetails> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmployeeDetails> empList) {
		this.empList = empList;
	}

	

}
