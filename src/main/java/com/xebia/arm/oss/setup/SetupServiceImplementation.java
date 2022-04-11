package com.xebia.arm.oss.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.arm.oss.Employeeresponse.SetupResponse;
import com.xebia.arm.oss.commonUtils.OSSConstants;
import com.xebia.arm.oss.dto.CompanyDto;
import com.xebia.arm.oss.dto.PlantDto;

@Service
public class SetupServiceImplementation implements SetupServiceInterface, OSSConstants {
	@Autowired
	SetupDaoInterface dao;

	public SetupResponse addCompany(CompanyDto request) {
		SetupResponse cr = new SetupResponse();
		if (request.getContactNo().length() > 0 && request.getContactNo().length() < 11
				&& request.getContactNo().length() == 10) {
			boolean flag = dao.addCompany(request);
			if (flag) {
				cr.setStatusCode(STATUS_CODE_200);
				cr.setStatus(STATUS_SUCCESS);
				cr.setResult(RESULT_TRUE);
				cr.setMessage("Company Record added Succesfully");
			} else {
				cr.setStatusCode(STATUS_CODE_200);
				cr.setStatus(STATUS_FAIL);
				cr.setResult(RESULT_FALSE);
				cr.setMessage("unable to add Company records");
			}
		} else {
			cr.setStatusCode(STATUS_CODE_200);
			cr.setStatus(STATUS_FAIL);
			cr.setResult(RESULT_FALSE);
			cr.setMessage("Invalid Company ContactNo ");
		}

		return cr;

	}

	public SetupResponse addPlant(PlantDto request) {
		SetupResponse sr = new SetupResponse();
		if (request.getContactNo().length() > 0 && request.getContactNo().length() < 11
				&& request.getContactNo().length() == 10) {
			boolean flag = dao.addPlant(request);
			if (flag) {
				sr.setStatusCode(STATUS_CODE_200);
				sr.setStatus(STATUS_SUCCESS);
				sr.setResult(RESULT_TRUE);
				sr.setMessage("Plant Record added Succesfully");
			} else {
				sr.setStatusCode(STATUS_CODE_200);
				sr.setStatus(STATUS_FAIL);
				sr.setResult(RESULT_FALSE);
				sr.setMessage("unable to add Plant records");
			}
		} else {
			sr.setStatusCode(STATUS_CODE_200);
			sr.setStatus(STATUS_FAIL);
			sr.setResult(RESULT_FALSE);
			sr.setMessage("Invalid Plant ContactNo");
		}
		return sr;
	}
}
