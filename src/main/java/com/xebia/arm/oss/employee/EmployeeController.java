package com.xebia.arm.oss.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.arm.oss.Employeeresponse.EmployeeResponse;
import com.xebia.arm.oss.dto.EmployeeDto;

@RestController
@CrossOrigin
@RequestMapping(value = "employee")
public class EmployeeController {
	@Autowired
	EmployeeServiceInterface employee;

	@PostMapping(value = "addEmployee")
	public EmployeeResponse addEmployee(@RequestBody EmployeeDto request) {
		return employee.addEmployee(request);

	}

	@PostMapping(value = "updateEmployee")
	public EmployeeResponse updateEmployee(@RequestBody EmployeeDto request) {
		return employee.updateEmployee(request);

	}

	@PostMapping(value = "getEmployeeDetails")
	public EmployeeResponse getEmployeeDetails(@RequestBody EmployeeDto request) {
		return employee.getEmployeeDetails(request);
	}

	@PostMapping(value = "getEmployeeDetailsByplantId")
	public EmployeeResponse getEmployeeDetailsByplantId(@RequestBody EmployeeDto request) {
		return employee.getEmployeeDetailsByplantId(request);
	}

	@PostMapping(value = "addMultipleEmployeeDetails")
	public EmployeeResponse addMultipleEmployeeDetails(@RequestBody EmployeeDto request) {
		return employee.addMultipleEmployeeDetails(request);
	}

	@PostMapping(value = "getDesignationWiseEmployeeCount")
	public EmployeeResponse getDesignationWiseEmployeeCount(@RequestBody EmployeeDto request) {
		return employee.getDesignationWiseEmployeeCount(request);
	}

	@PostMapping(value = "generateEmployeeDOBReport")
	public EmployeeResponse generateEmployeeDOBReport(@RequestBody EmployeeDto request) {
		return employee.generateEmployeeDOBReport(request);
	}

	@PostMapping(value = "getSingleEmployeeDetils")
	public EmployeeResponse getSingleEmployeeDetils(@RequestBody EmployeeDto request) {
		return employee.getSingleEmployeeDetils(request);
	}

	@DeleteMapping(value = "deleteRecordFromEmployeeDetails/{empId}")
	public EmployeeResponse deleteRecordFromEmployeeDetails(@PathVariable("empId") int empId) {
		return employee.deleteRecordFromEmployeeDetails(empId);
	}

	@DeleteMapping(value = "deleterecordwithcreateNativeQuery/{empId}")
	public EmployeeResponse deleterecordwithcreateNativeQuery(@PathVariable("empId") int empId) {
		return employee.deleterecordwithcreateNativeQuery(empId);
	}

	@DeleteMapping(value = "deleteWithCreateQuery/{empId}")
	public EmployeeResponse deleteWithCreateQuery(@PathVariable("empId") int empId) {
		return employee.deleteWithCreateQuery(empId);
	}

	@PostMapping(value = "deleteMultipleEmpoyeeDetails")
	public EmployeeResponse deleteMultipleEmpoyeeDetails(@RequestBody EmployeeDto request) {
		return employee.deleteMultipleEmpoyeeDetails(request);
	}

}
