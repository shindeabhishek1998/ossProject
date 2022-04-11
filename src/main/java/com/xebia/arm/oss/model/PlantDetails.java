package com.xebia.arm.oss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class PlantDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int plantId;

	private String plantName;

	private String plantAdd;

	private String contactNo;

	private int companyId;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private java.sql.Timestamp createdDate;

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
