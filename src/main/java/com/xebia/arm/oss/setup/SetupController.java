package com.xebia.arm.oss.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.arm.oss.Employeeresponse.SetupResponse;
import com.xebia.arm.oss.dto.CompanyDto;
import com.xebia.arm.oss.dto.PlantDto;

@RestController
@CrossOrigin
@RequestMapping(value = "setup")
public class SetupController {

	@Autowired
	SetupServiceImplementation setup;

	@PostMapping(value = "addCompany")
	public SetupResponse addCompany(@RequestBody CompanyDto request) {
		return setup.addCompany(request);
	}

	@PostMapping(value = "addPlant")
	public SetupResponse addPlant(@RequestBody PlantDto request) {
		return setup.addPlant(request);

	}
}