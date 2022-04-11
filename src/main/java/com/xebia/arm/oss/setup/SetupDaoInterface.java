package com.xebia.arm.oss.setup;

import com.xebia.arm.oss.dto.CompanyDto;
import com.xebia.arm.oss.dto.PlantDto;

public interface SetupDaoInterface {

	public boolean addCompany(CompanyDto request);

	public boolean addPlant(PlantDto request);
}
