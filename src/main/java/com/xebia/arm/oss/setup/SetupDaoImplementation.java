package com.xebia.arm.oss.setup;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.xebia.arm.oss.commonUtils.BaseRepository;
import com.xebia.arm.oss.dto.CompanyDto;
import com.xebia.arm.oss.dto.PlantDto;
import com.xebia.arm.oss.model.CompanyDetails;
import com.xebia.arm.oss.model.PlantDetails;

@Component
@Transactional
public class SetupDaoImplementation extends BaseRepository implements SetupDaoInterface {

	@Override
	public boolean addCompany(CompanyDto request) {
		boolean flag = false;
		Session session = getCurrentSession();

		CompanyDetails cd = new CompanyDetails();
		if (request.getCompanyId() > 0) {
			cd.setCompanyId(request.getCompanyId());
		}
		if (request.getCompanyName() != null) {
			cd.setCompanyName(request.getCompanyName());
		}
		if (request.getAdd() != null) {
			cd.setCompanyAdd(request.getAdd());
		}
		if (request.getContactNo() != null) {
			cd.setContactNo(request.getContactNo());
		}

		session.save(cd);
		flag = true;
		return flag;
	}

	@Override

	public boolean addPlant(PlantDto request) {
		boolean flag = false;
		Session session = getCurrentSession();

		try {
			CompanyDetails cf = session.get(CompanyDetails.class, request.getCompanyId());
			System.out.println("CompanyId get called");
			if (cf != null) {
				System.out.println("Company GET ID= " + cf.getCompanyId());
				System.out.println("company Get Details:: " + cf);
				PlantDetails ps = new PlantDetails();

				if (request.getPlantId() > 0) {
					ps.setPlantId(request.getPlantId());
				}
				if (request.getPlantName() != null) {
					ps.setPlantName(request.getPlantName());
				}
				if (request.getPlantAdd() != null) {
					ps.setPlantAdd(request.getPlantAdd());
				}
				if (request.getContactNo() != null) {
					ps.setContactNo(request.getContactNo());
				}
				ps.setCompanyId(request.getCompanyId());
				session.save(ps);
				flag = true;

			} else {
				System.out.println("Invalid Company ID");
			}
		} catch (EntityNotFoundException ex) {
			System.out.println("Invalid Company ID");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
}