package com.xebia.arm.oss.employee;

import java.util.List;

import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;

public interface EmployeeDaoInterface {

	public boolean addEmployee(EmployeeDto request);

	public List<EmployeeDetails> getEmployeeDetails(EmployeeDto request);

	public List<EmployeeDto> getEmployeeDetailsByplantId(EmployeeDto request);

	public List<EmployeeDto> getEmployeeDetailsbyempId(int empId);

	public boolean addMultipleEmployeeDetails(EmployeeDto request);

	public List<EmployeeDto> getDesignationWiseEmployeeCount(EmployeeDto request);

	public EmployeeDto getSingleEmployeeDetils(EmployeeDto request);

	public boolean updateEmployee(EmployeeDto request);

	public List<EmployeeDto> getEmployeeDetails();

	public List<EmployeeDto> generateEmployeeDOBReport(EmployeeDto request);

	public boolean deleteRecordFromEmployeeDetails(int empId);

	public boolean deleterecordwithcreateNativeQuery(int empId);

	public boolean deleteWithCreateQuery(int empId);

	public boolean deleteMultipleEmpoyeeDetails(EmployeeDto request);

	public boolean deleteMultipleEmployeeRecords(EmployeeDto request);

	public EmployeeDetails getEmpDetailsByEmpId(int empId);
}
