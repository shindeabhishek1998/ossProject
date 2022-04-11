package com.xebia.arm.oss.employee;

import com.xebia.arm.oss.Employeeresponse.EmployeeResponse;
import com.xebia.arm.oss.dto.EmployeeDto;

public interface EmployeeServiceInterface {
	public EmployeeResponse addEmployee(EmployeeDto request);

	public EmployeeResponse updateEmployee(EmployeeDto request);

	public EmployeeResponse getEmployeeDetailsByplantId(EmployeeDto request);

	public EmployeeResponse getEmployeeDetailsbyempId(int empId);

	public EmployeeResponse addMultipleEmployeeDetails(EmployeeDto request);

	public EmployeeResponse getDesignationWiseEmployeeCount(EmployeeDto request);

	public EmployeeResponse getSingleEmployeeDetils(EmployeeDto request);

	public EmployeeResponse getEmployeeDetails(EmployeeDto request);

	public EmployeeResponse generateEmployeeDOBReport(EmployeeDto request);

	public EmployeeResponse deleteRecordFromEmployeeDetails(int empId);

	public EmployeeResponse deleterecordwithcreateNativeQuery(int empId);

	public EmployeeResponse deleteWithCreateQuery(int empId);

	public EmployeeResponse deleteMultipleEmpoyeeDetails(EmployeeDto request);

}
