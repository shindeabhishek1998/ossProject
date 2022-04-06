package com.xebia.arm.oss.employee;

import java.util.List;

import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;

public interface EmployeeDaoInterface {

	public boolean firstAPI();

	public boolean addEmployee(EmployeeDto request);

	public boolean addMultipleEmployees(EmployeeDto request);

	public List<EmployeeDto> getEmployeeDetailsByBranchId(int branchId);

	public boolean updateEmployeeDetails(EmployeeDto request);

	public List<EmployeeDto> getEmployeeDetails(EmployeeDto request);

	public List<EmployeeDto> getEmployeeDetailsByPlantId(EmployeeDto request);
}
