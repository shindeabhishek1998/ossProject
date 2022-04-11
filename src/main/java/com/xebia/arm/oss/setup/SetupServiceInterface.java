package com.xebia.arm.oss.setup;

import com.xebia.arm.oss.Employeeresponse.SetupResponse;
import com.xebia.arm.oss.dto.CompanyDto;

public interface SetupServiceInterface {

	public SetupResponse addCompany(CompanyDto request);

}
