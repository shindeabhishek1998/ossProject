package com.xebia.arm.oss.employee;

import com.xebia.arm.oss.Employeeresponse.EmployeeResponse;
import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;

public interface EmpServiceInterface {

	public EmployeeResponse firstAPI();

	public EmployeeResponse addEmployee(EmployeeDto request);

	public EmployeeResponse addMultipleEmployees(EmployeeDto request);

	public EmployeeResponse getEmployeeDetailsByBranchId(int branchId);

	public EmployeeResponse updateEmployeeDetails(EmployeeDto request);

	public EmployeeResponse getEmployeeDetails();

	public EmployeeResponse getEmployeeDetailsByPlantId(EmployeeDto request);

	public EmployeeResponse deleteEmployeeRecord(int empId);

	public EmployeeResponse deleteEmployeeRecordWithCreateNativeQuery(int empId);

	public EmployeeResponse deleteEmployeeRecordWithCreateQuery(int empId);

	public EmployeeResponse deleteMultipleEmployeeRecords(EmployeeDto request);

	public EmployeeResponse getEmpDetailsByEmpId(int empId);
}
