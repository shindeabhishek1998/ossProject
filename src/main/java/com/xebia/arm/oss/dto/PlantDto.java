package com.xebia.arm.oss.dto;

public class PlantDto {
	public int plantId;

	public String plantName;

	public String plantAdd;

	public String contactNo;

	public int companyId;

	public java.sql.Timestamp createdDate;

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantAdd() {
		return plantAdd;
	}

	public void setPlantAdd(String plantAdd) {
		this.plantAdd = plantAdd;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
