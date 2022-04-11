package com.xebia.arm.oss.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.arm.oss.commonUtils.OSSConstants;
import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;
import com.xebia.arm.oss.response.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmpServiceInterface, OSSConstants {

	@Autowired
	EmployeeDaoInterface dao;

	@Override
	public EmployeeResponse firstAPI() {
		EmployeeResponse res = new EmployeeResponse();
		boolean flag = dao.firstAPI();
		if (flag) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("returning from dao layer with custom resopnse");
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to reach dao layer");
		}
		return res;
	}

	@Override
	public EmployeeResponse addEmployee(EmployeeDto request) {
		EmployeeResponse res = new EmployeeResponse();
		boolean flag = dao.addEmployee(request);
		if (flag) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee record added successfully");
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to add employee record");
		}
		return res;
	}

	@Override
	public EmployeeResponse addMultipleEmployees(EmployeeDto request) {
		EmployeeResponse res = new EmployeeResponse();
		boolean flag = dao.addMultipleEmployees(request);
		if (flag) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee record added successfully");
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to add employee record");
		}
		return res;
	}

	@Override
	public EmployeeResponse getEmployeeDetailsByBranchId(int branchId) {
		EmployeeResponse res = new EmployeeResponse();
		if (branchId > 0) {
			List<EmployeeDto> result = dao.getEmployeeDetailsByBranchId(branchId);
			if (result != null && result.size() > 0) {
				res.setStatusCode(STATUS_CODE_200);
				res.setStatus(STATUS_SUCCESS);
				res.setResult(RESULT_TRUE);
				res.setMessage("Employee record fetched successfully");
				res.setUserList(result);
			} else {
				res.setStatusCode(STATUS_CODE_200);
				res.setStatus(STATUS_FAIL);
				res.setResult(RESULT_FALSE);
				res.setMessage("unable to fetch employee record");
			}
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("bad request / branchId value should be greater than 0");
		}

		return res;
	}

	@Override
	public EmployeeResponse updateEmployeeDetails(EmployeeDto request) {
		EmployeeResponse res = new EmployeeResponse();
		boolean flag = dao.updateEmployeeDetails(request);
		if (flag) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee record updated successfully");
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to update the employee record");
		}
		return res;
	}

	@Override
	public EmployeeResponse getEmployeeDetails() {
		EmployeeResponse res = new EmployeeResponse();
		List<EmployeeDto> tempList = dao.getEmployeeDetails();
		if (tempList != null && !tempList.isEmpty()) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee record fetched successfully");
			res.setDtoList(tempList);
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to add fetch employee record");
		}
		return res;
	}

	@Override
	public EmployeeResponse getEmployeeDetailsByPlantId(EmployeeDto request) {

		EmployeeResponse res = new EmployeeResponse();
		List<EmployeeDto> tempList = dao.getEmployeeDetailsByPlantId(request);
		if (tempList != null && !tempList.isEmpty()) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee record fetched successfully");
			res.setDtoList(tempList);
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to add fetch employee record");
		}
		return res;
	}

	@Override
	public EmployeeResponse deleteEmployeeRecord(int empId) {
		EmployeeResponse res = new EmployeeResponse();
		boolean flag = dao.deleteEmployeeRecord(empId);
		if (flag) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee record deleted successfully");
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to delete  employee record");
		}
		return res;
	}

	@Override
	public EmployeeResponse deleteEmployeeRecordWithCreateNativeQuery(int empId) {
		EmployeeResponse res = new EmployeeResponse();
		boolean flag = dao.deleteEmployeeRecordWithCreateNativeQuery(empId);
		if (flag) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee record deleted successfully");
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to delete  employee record");
		}
		return res;
	}

	@Override
	public EmployeeResponse deleteEmployeeRecordWithCreateQuery(int empId) {

		EmployeeResponse res = new EmployeeResponse();
		boolean flag = dao.deleteEmployeeRecordWithCreateNativeQuery(empId);
		if (flag) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee record deleted successfully");
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to delete  employee record");
		}
		return res;
	}

	@Override
	public EmployeeResponse deleteMultipleEmployeeRecords(EmployeeDto request) {
		EmployeeResponse res = new EmployeeResponse();
		if (request.getEmpIds() != null && request.getEmpIds().length > 0) {
			boolean flag = dao.deleteMultipleEmployeeRecords(request);
			if (flag) {
				res.setStatusCode(STATUS_CODE_200);
				res.setStatus(STATUS_SUCCESS);
				res.setResult(RESULT_TRUE);
				res.setMessage("Employee record deleted successfully");
			} else {
				res.setStatusCode(STATUS_CODE_200);
				res.setStatus(STATUS_FAIL);
				res.setResult(RESULT_FALSE);
				res.setMessage("unable to delete  employee record");
			}
		} else {
			res.setStatusCode(STATUS_CODE_400);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("bad request");
		}

		return res;
	}

	/**
	 * @author Vinay B. Apr 9, 2022 11:37:21 PM
	 */
	@Override
	public EmployeeResponse getEmpDetailsByEmpId(int empId) {
		EmployeeResponse res = new EmployeeResponse();

		EmployeeDetails ed = dao.getEmpDetailsByEmpId(empId);
		if (ed != null) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee record deleted successfully");
			res.setEmpDetails(ed);
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to delete  employee record");
		}

		return res;
	}

}
