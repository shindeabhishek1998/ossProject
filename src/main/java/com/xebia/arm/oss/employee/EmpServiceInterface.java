package com.xebia.arm.oss.employee;

import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;
import com.xebia.arm.oss.response.EmployeeResponse;

public interface EmpServiceInterface {

	public EmployeeResponse firstAPI();

	public EmployeeResponse addEmployee(EmployeeDto request);

	public EmployeeResponse addMultipleEmployees(EmployeeDto request);

	public EmployeeResponse getEmployeeDetailsByBranchId(int branchId);

	public EmployeeResponse updateEmployeeDetails(EmployeeDto request);

	public EmployeeResponse getEmployeeDetails(EmployeeDto request);

	public EmployeeResponse getEmployeeDetailsByPlantId(EmployeeDto request);
}
