package com.xebia.arm.oss.employee;

import java.util.List;

import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;
import com.xebia.arm.oss.response.EmployeeResponse;

public interface EmployeeDaoInterface {

	public boolean firstAPI();

	public boolean addEmployee(EmployeeDto request);

	public boolean addMultipleEmployees(EmployeeDto request);

	public List<EmployeeDto> getEmployeeDetailsByBranchId(int branchId);

	public boolean updateEmployeeDetails(EmployeeDto request);

	public List<EmployeeDto> getEmployeeDetails();

	public List<EmployeeDto> getEmployeeDetailsByPlantId(EmployeeDto request);

	public boolean deleteEmployeeRecord(int empId);

	public boolean deleteEmployeeRecordWithCreateNativeQuery(int empId);

	public boolean deleteEmployeeRecordWithCreateQuery(int empId);

	public boolean deleteMultipleEmployeeRecords(EmployeeDto request);

	public EmployeeDetails getEmpDetailsByEmpId(int empId);
}
