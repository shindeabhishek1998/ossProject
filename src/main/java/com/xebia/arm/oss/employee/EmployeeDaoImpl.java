package com.xebia.arm.oss.employee;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.xebia.arm.oss.commonUtils.BaseRepository;
import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;
import com.xebia.arm.oss.model.PlantDetails;

@Component
@Transactional
public class EmployeeDaoImpl extends BaseRepository implements EmployeeDaoInterface {

	public boolean addEmployee(EmployeeDto request) {
		boolean flag = false;
		Session session = getCurrentSession();
		try {
			PlantDetails cf = session.get(PlantDetails.class, request.getPlantId());
			System.out.println("Plant ID get Called called");
			if (cf != null) {
				System.out.println("Plant  ID= " + cf.getPlantId());
				System.out.println("Plant ID Get Details:: " + cf);

				EmployeeDetails ed = new EmployeeDetails();

				if (request.getEmpId() > 0) {
					ed.setEmpId(request.getEmpId());
				}
				if (request.getFirstName() != null) {
					ed.setFirstName(request.getFirstName());
				}
				if (request.getLastName() != null) {
					ed.setLastName(request.getLastName());
				}
				if (request.getMobile() != null) {
					ed.setMobile(request.getMobile());
				}

				ed.setEmail(request.getEmail());
				if (request.getDob() != null) {
					ed.setDob(request.getDob());
				}
				ed.setPlantId(request.getPlantId());
				session.save(ed);
				flag = true;
			} else {
				System.out.println("Invalid plant Id");
			}
		} catch (EntityNotFoundException ex) {
			System.out.println("Invalid Plant ID");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateEmployee(EmployeeDto request) {
		boolean flag = false;
		Session session = getCurrentSession();
		EmployeeDetails ed = session.get(EmployeeDetails.class, request.getEmpId());

		System.out.println("Employee firstName before update=" + ed.getFirstName());
		System.out.println("Employee lastName before update=" + ed.getLastName());
		System.out.println("Employee email before update=" + ed.getEmail());
		System.out.println("Employee dob before update=" + ed.getDob());
		System.out.println("Employee mobile before update=" + ed.getMobile());

		if (ed != null) {
			if (request.getFirstName() != null) {
				ed.setFirstName(request.getFirstName());
			}
			if (request.getMobile() != null) {
				ed.setMobile(request.getMobile());
			}
			if (request.getLastName() != null) {
				ed.setLastName(request.getLastName());
			}
			if (request.getEmail() != null) {
				ed.setEmail(request.getEmail());
			}
			if (request.getDob() != null) {
				ed.setDob(request.getDob());
			}

			session.update(ed);
		}

		System.out.println("Employee firstName after update=" + ed.getFirstName());
		System.out.println("Employee lastName after update=" + ed.getLastName());
		System.out.println("Employee email after update=" + ed.getEmail());
		System.out.println("Employee dob after update=" + ed.getDob());
		System.out.println("Employee mobile after update=" + ed.getMobile());
		flag = true;

		return flag;
	}

	public List<EmployeeDetails> getEmployeeDetails(EmployeeDto request) {

		Session session = getCurrentSession();
		List<EmployeeDetails> list = session.createQuery("FROM EmployeeDetails where plantId=:locationId")
				.setParameter("locationId", request.getPlantId()).getResultList();
		return list;

	}

	public List<EmployeeDto> getEmployeeDetailsByplantId(EmployeeDto request) {
		Session session = getCurrentSession();
		List<EmployeeDto> dtoList = new ArrayList<>();
		List<Object[]> objectList = session.createNativeQuery(
				"select first_name,last_name,email,mobile,emp_id from employee_details WHERE plant_id=:locationId")
				.setParameter("locationId", request.getPlantId()).getResultList();
		for (Object[] x : objectList) {
			EmployeeDto ed = new EmployeeDto();
			if (x[0] != null) {
				String firstName = x[0].toString();
				ed.setFirstName(firstName);
			}
			if (x[1] != null) {
				String lastName = x[1].toString();
				ed.setLastName(lastName);
			}
			if (x[2] != null) {
				String email = x[2].toString();
				ed.setEmail(email);
			}
			if (x[3] != null) {
				String mobile = x[3].toString();
				ed.setMobile(mobile);
			}
			if (x[4] != null) {
				int empId = Integer.parseInt(String.valueOf(x[4]));
				ed.setEmpId(0);
			}
			dtoList.add(ed);
		}

		return dtoList;

	}

	public List<EmployeeDto> getEmployeeDetailsbyempId(int empId) {
		Session session = getCurrentSession();
		List<EmployeeDto> list = session.createQuery("FROM EmployeeDetails where emp_id=:employeeId")
				.setParameter("employeeId", empId).getResultList();
		return list;

	}

	public boolean addMultipleEmployeeDetails(EmployeeDto request) {
		boolean flag = false;
		Session session = getCurrentSession();
		for (EmployeeDto x : request.getEmpList()) {
			EmployeeDetails ed = new EmployeeDetails();

			if (x.getFirstName() != null) {
				ed.setFirstName(x.getFirstName());
			}
			if (x.getLastName() != null) {
				ed.setLastName(x.getLastName());
			}
			if (x.getMobile() != null) {
				ed.setMobile(x.getMobile());
			}
			if (x.getEmail() != null) {
				ed.setEmail(x.getEmail());
			}

			if (x.getDob() != null) {
				ed.setDob(x.getDob());
			}
			if (x.getPlantId() > 0) {
				ed.setPlantId(x.getPlantId());
			}
			if (x.getDob() != null) {
				ed.setDob(x.getDob());
			}
			if (x.getDesignation() != null) {
				ed.setDesignation(x.getDesignation());
			}
			session.save(ed);
		}

		flag = true;
		return flag;

	}

	public List<EmployeeDto> getDesignationWiseEmployeeCount(EmployeeDto request) {

		Session session = getCurrentSession();
		List<EmployeeDto> dtoList = new ArrayList<>();
		List<Object[]> objectList = session.createNativeQuery(
				"SELECT  designation, COUNT(*) FROM hrms_db.employee_details  where plant_id=:locationId GROUP BY designation")
				.setParameter("locationId", request.getPlantId()).getResultList();
		for (Object[] x : objectList) {
			EmployeeDto ed = new EmployeeDto();

			if (x[0] != null) {
				System.out.println(x[1].toString());
				String designation = x[1].toString();
				ed.setDesignation(designation);
			}
			if (x[1] != null) {
				System.out.println((String.valueOf(x[2])));
				int designationWiseEmpCount = Integer.parseInt(String.valueOf(x[2]));
				ed.setDesignationWiseEmpCount(designationWiseEmpCount);

			}
			dtoList.add(ed);

		}
		return dtoList;
	}

	public EmployeeDto getSingleEmployeeDetils(EmployeeDto request) {
		Session session = getCurrentSession();
		List<Object[]> objectList = session.createNativeQuery(
				"SELECT emp_id,first_name,last_name,dob from employee_details where emp_id=:employeeId AND plant_id=:locatioId "
						+ " AND designation=:designations")
				.setParameter("employeeId", request.getEmpId()).setParameter("locatioId", request.getPlantId())
				.setParameter("designations", request.getDesignation()).getResultList();
		EmployeeDto ed = new EmployeeDto();
		for (Object[] x : objectList) {

			if (x[0] != null) {
				System.out.println((String.valueOf(x[0])));
				int empId = Integer.parseInt(String.valueOf(x[0]));
				ed.setEmpId(empId);
			}
			if (x[1] != null) {
				System.out.println(x[1].toString());
				String firstName = x[1].toString();
				ed.setFirstName(firstName);
			}
			if (x[2] != null) {
				System.out.println(x[2].toString());
				String lastName = x[2].toString();
				ed.setLastName(lastName);

			}

			if (x[3] != null) {
				System.out.println((String.valueOf(x[3])));
				Date dob = Date.valueOf(x[3].toString());
				ed.setDob(dob);
			}
		}
		return ed;
	}

	public List<EmployeeDto> generateEmployeeDOBReport(EmployeeDto request) {
		Session session = getCurrentSession();
		List<EmployeeDto> dtoList = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> objectList = session.createNativeQuery(
				"select emp_id,concat(first_name, ' ' ,last_name) as employeename,dob from hrms_db.employee_details where plant_id=:locId")
				.setParameter("locId", request.getPlantId()).getResultList();
		for (Object[] x : objectList) {
			EmployeeDto ed = new EmployeeDto();
			if (x[0] != null) {
				System.out.println((String.valueOf(x[0])));
				int empId = Integer.parseInt(String.valueOf(x[0]));
				ed.setEmpId(empId);
			}
			if (x[1] != null) {
				System.out.println(x[1].toString());
				String employeeName = x[1].toString();
				ed.setEmployeeName(employeeName);
			}
			if (x[2] != null) {
				System.out.println((String.valueOf(x[2])));
				Date dob = Date.valueOf(x[2].toString());
				ed.setDob(dob);

			}
			dtoList.add(ed);

		}
		return dtoList;
	}

	@Override
	public boolean deleteRecordFromEmployeeDetails(int empId) {
		Session session = getCurrentSession();
		boolean flag = false;

		EmployeeDetails ed = session.load(EmployeeDetails.class, empId);
		if (ed != null) {
			session.delete(ed);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleterecordwithcreateNativeQuery(int empId) {
		Session session = getCurrentSession();
		boolean flag = false;
		int result = session.createNativeQuery("delete from employee_details where emp_id=:empId")
				.setParameter("empId", empId).executeUpdate();
		if (result > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean deleteWithCreateQuery(int empId) {
		Session session = getCurrentSession();
		boolean flag = false;

		int roes = session.createQuery("delete FROM EmployeeDetails where empId=:employeeId")
				.setParameter("employeeId", empId).executeUpdate();

		if (roes > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean deleteMultipleEmpoyeeDetails(EmployeeDto request) {
		Session session = getCurrentSession();
		boolean flag = false;
		for (Integer x : request.getEmpIds()) {
			int resultset = session.createNativeQuery("delete from employee_details where emp_id=:empId")
					.setParameter("empId", x).executeUpdate();
			if (resultset > 0) {
				flag = true;
			}

		}
		return flag;

	}
}