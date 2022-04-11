package com.xebia.arm.oss.employee;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.arm.oss.Employeeresponse.EmployeeResponse;
import com.xebia.arm.oss.commonUtils.OSSConstants;
import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface, OSSConstants {

	@Autowired
	EmployeeDaoInterface dao;

	public EmployeeResponse addEmployee(EmployeeDto request) {
		EmployeeResponse er = new EmployeeResponse();
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

		if (request.getMobile().length() > 0 && request.getMobile().length() < 11
				&& request.getMobile().length() == 10) {
			if (request.getEmail() != null) {
				Pattern pattern = Pattern.compile(regex);
				MatchResult matcher = pattern.matcher(request.getEmail());
				if (((java.util.regex.Matcher) matcher).matches()) {
					boolean flag = dao.addEmployee(request);
					if (flag) {
						er.setStatusCode(STATUS_CODE_200);
						er.setStatus(STATUS_SUCCESS);
						er.setResult(RESULT_TRUE);
						er.setMessage("Employee Record added Succesfully");
					} else {
						er.setStatusCode(STATUS_CODE_200);
						er.setStatus(STATUS_FAIL);
						er.setResult(RESULT_FALSE);
						er.setMessage("unable to add employee records");
					}
				} else {
					er.setStatusCode(STATUS_CODE_100);
					er.setStatus(STATUS_FAIL);
					er.setResult(RESULT_FALSE);
					er.setMessage("Invalid Email Address");
				}
			} else {
				er.setStatusCode(STATUS_CODE_100);
				er.setStatus(STATUS_FAIL);
				er.setResult(RESULT_FALSE);
				er.setMessage("Invalid Email Address");

			}

		} else {
			er.setStatusCode(STATUS_CODE_100);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("Invalid Mobile Number");
		}

		return er;
	}

	public EmployeeResponse updateEmployee(EmployeeDto request) {
		EmployeeResponse er = new EmployeeResponse();
		boolean flag = dao.updateEmployee(request);

		if (flag) {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_SUCCESS);
			er.setResult(RESULT_TRUE);
			er.setMessage("Employee Record Updated Succesfully");
		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("unable to update an employee records");
		}

		return er;
	}

	public EmployeeResponse getEmployeeDetails(EmployeeDto request) {
		EmployeeResponse er = new EmployeeResponse();
		List<EmployeeDetails> tempList = dao.getEmployeeDetails(request);
		if (tempList != null && !tempList.isEmpty()) {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_SUCCESS);
			er.setResult(RESULT_TRUE);
			er.setMessage("Employee record fetched successfully");
			er.setEmpList(tempList);
		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("unable to  fetch employee record");
		}
		return er;

	}

	public EmployeeResponse getEmployeeDetailsByplantId(EmployeeDto request) {
		EmployeeResponse er = new EmployeeResponse();
		List<EmployeeDto> tempList = dao.getEmployeeDetailsByplantId(request);
		if (tempList != null && !tempList.isEmpty()) {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_SUCCESS);
			er.setResult(RESULT_TRUE);
			er.setMessage("Employee record fetched successfully");
			er.setDtoList(tempList);
			;
		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("unable to  fetch employee record");
		}
		return er;
	}

	public EmployeeResponse getEmployeeDetailsbyempId(int empId) {
		EmployeeResponse res = new EmployeeResponse();
		if (empId > 0) {
			List<EmployeeDto> result = dao.getEmployeeDetailsbyempId(empId);
			if (result != null && result.size() > 0) {
				res.setStatusCode(STATUS_CODE_200);
				res.setStatus(STATUS_SUCCESS);
				res.setResult(RESULT_TRUE);
				res.setMessage("Employee record fetched successfully");
				res.setDtoList(result);
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
			res.setMessage("bad request / empId value should be greater than 0");
		}

		return res;
	}

	public EmployeeResponse addMultipleEmployeeDetails(EmployeeDto request) {
		EmployeeResponse er = new EmployeeResponse();
		boolean flag = dao.addMultipleEmployeeDetails(request);
		if (flag) {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_SUCCESS);
			er.setResult(RESULT_TRUE);
			er.setMessage("Employee Record added Succesfully");
		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("unable to add employee records");
		}
		return er;
	}

	public EmployeeResponse getDesignationWiseEmployeeCount(EmployeeDto request) {
		EmployeeResponse er = new EmployeeResponse();

		List<EmployeeDto> tempList = dao.getDesignationWiseEmployeeCount(request);
		if (tempList != null && !tempList.isEmpty()) {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_SUCCESS);
			er.setResult(RESULT_TRUE);
			er.setMessage("Employee record fetched with designation count");
			er.setDtoList(tempList);
		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("unable to  fetch employee designation count");
		}
		return er;
	}

	public EmployeeResponse generateEmployeeDOBReport(EmployeeDto request) {

		EmployeeResponse res = new EmployeeResponse();
		List<EmployeeDto> result = dao.generateEmployeeDOBReport(request);
		if (result != null && result.size() > 0) {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_SUCCESS);
			res.setResult(RESULT_TRUE);
			res.setMessage("Employee DOB report generate  successfully");
			res.setDtoList(result);
		} else {
			res.setStatusCode(STATUS_CODE_200);
			res.setStatus(STATUS_FAIL);
			res.setResult(RESULT_FALSE);
			res.setMessage("unable to generate DOB report");
		}

		return res;
	}

	public EmployeeResponse getSingleEmployeeDetils(EmployeeDto request) {
		EmployeeResponse er = new EmployeeResponse();
		EmployeeDto ed = dao.getSingleEmployeeDetils(request);
		if (ed != null) {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_SUCCESS);
			er.setResult(RESULT_TRUE);
			er.setMessage("Employee record fetched");
			er.setEd(ed);
		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("unable to  fetch employee record");
		}
		return er;
	}

	@Override
	public EmployeeResponse deleteRecordFromEmployeeDetails(int empId) {
		EmployeeResponse er = new EmployeeResponse();
		boolean flag = dao.deleteRecordFromEmployeeDetails(empId);
		if (flag) {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_SUCCESS);
			er.setResult(RESULT_TRUE);
			er.setMessage("Employee record deleted");

		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("unable to  delete employee record");
		}
		return er;

	}

	@Override
	public EmployeeResponse deleterecordwithcreateNativeQuery(int empId) {
		EmployeeResponse er = new EmployeeResponse();
		boolean flag = dao.deleterecordwithcreateNativeQuery(empId);
		if (flag) {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_SUCCESS);
			er.setResult(RESULT_TRUE);
			er.setMessage("Employee record deleted");
		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("unable to  delete employee record");
		}
		return er;
	}

	@Override
	public EmployeeResponse deleteWithCreateQuery(int empId) {
		EmployeeResponse er = new EmployeeResponse();
		boolean flag = dao.deleteWithCreateQuery(empId);
		if (flag) {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_SUCCESS);
			er.setResult(RESULT_TRUE);
			er.setMessage("  deleted employee record Successfully");
		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("unable record deleted");
		}
		return er;
	}

	@Override
	public EmployeeResponse deleteMultipleEmpoyeeDetails(EmployeeDto request) {
		EmployeeResponse er = new EmployeeResponse();
		if (request.getEmpIds() != null && request.getEmpIds().length > 0) {
			boolean flag = dao.deleteMultipleEmpoyeeDetails(request);
			if (flag) {
				er.setStatusCode(STATUS_CODE_200);
				er.setStatus(STATUS_SUCCESS);
				er.setResult(RESULT_TRUE);
				er.setMessage("  deleted employee record Successfully");
			} else {
				er.setStatusCode(STATUS_CODE_200);
				er.setStatus(STATUS_FAIL);
				er.setResult(RESULT_FALSE);
				er.setMessage("unable record deleted");
			}
		} else {
			er.setStatusCode(STATUS_CODE_200);
			er.setStatus(STATUS_FAIL);
			er.setResult(RESULT_FALSE);
			er.setMessage("bad request / empId should be greater than 0");
		}
		return null;
	}

}
