package com.xebia.arm.oss.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.response.EmployeeResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmpServiceInterface empService;

	@GetMapping(value = "/firstAPI/{empId}") // api name
	public EmployeeResponse firstAPI(@PathVariable("empId") int empId) { // method name
		EmployeeResponse res = empService.firstAPI();
		return res;
	}

	@PostMapping(value = "/addEmployee")
	public EmployeeResponse addEmployee(@RequestBody EmployeeDto request) {
		return empService.addEmployee(request);

	}

	@PostMapping(value = "/addMultipleEmployees")
	public EmployeeResponse addMultipleEmployees(@RequestBody EmployeeDto request) {
		return empService.addMultipleEmployees(request);

	}

	@GetMapping(value = "/getEmployeeDetailsByBranchId/{branchId}") // api name
	public EmployeeResponse getEmployeeDetailsByBranchId(@PathVariable("branchId") int branchId) { // method name
		EmployeeResponse res = empService.getEmployeeDetailsByBranchId(branchId);
		return res;
	}

	@GetMapping(value = "/getEmpDetailsByEmpId/{empId}") // api name
	public EmployeeResponse getEmpDetailsByEmpId(@PathVariable("empId") int empId) { // method name
		return empService.getEmpDetailsByEmpId(empId);
	}

	@PostMapping(value = "/updateEmployeeDetails")
	public EmployeeResponse updateEmployeeDetails(@RequestBody EmployeeDto request) {
		return empService.updateEmployeeDetails(request);

	}

	@GetMapping(value = "/getEmployeeDetails")
	public EmployeeResponse getEmployeeDetails() {
		return empService.getEmployeeDetails();
	}

	@PostMapping(value = "/getEmployeeDetailsByPlantId")
	public EmployeeResponse getEmployeeDetailsByPlantId(@RequestBody EmployeeDto request) {
		return empService.getEmployeeDetailsByPlantId(request);
	}

	@DeleteMapping(value = "/deleteEmployeeRecord/{empId}")
	public EmployeeResponse deleteEmployeeRecord(@PathVariable("empId") int empId) {
		return empService.deleteEmployeeRecord(empId);
	}

	@DeleteMapping(value = "/deleteEmployeeRecordWithCreateNativeQuery/{empId}")
	public EmployeeResponse deleteEmployeeRecordWithCreateNativeQuery(@PathVariable("empId") int empId) {
		return empService.deleteEmployeeRecordWithCreateNativeQuery(empId);
	}

	@DeleteMapping(value = "/deleteEmployeeRecordWithCreateQuery/{empId}")
	public EmployeeResponse deleteEmployeeRecordWithCreateQuery(@PathVariable("empId") int empId) {
		return empService.deleteEmployeeRecordWithCreateQuery(empId);

	}

	@PostMapping(value = "/deleteMultipleEmployeeRecords")
	public EmployeeResponse deleteMultipleEmployeeRecords(@RequestBody EmployeeDto request) {
		return empService.deleteMultipleEmployeeRecords(request);

	}
}
