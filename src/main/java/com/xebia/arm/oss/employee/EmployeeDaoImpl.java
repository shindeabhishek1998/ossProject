package com.xebia.arm.oss.employee;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.xebia.arm.oss.commonUtils.BaseRepository;
import com.xebia.arm.oss.dto.EmployeeDto;
import com.xebia.arm.oss.model.EmployeeDetails;

@Component
@Transactional
public class EmployeeDaoImpl extends BaseRepository implements EmployeeDaoInterface {

	@Override
	public boolean firstAPI() {
		return true;
	}

	@Override
	public boolean addEmployee(EmployeeDto request) {
		boolean flag = false;
		Session session = getCurrentSession();

		// EmployeeDto request -> Data Transfer Object

		EmployeeDetails ed = new EmployeeDetails(); // Entity - represents database table
		// null

		/*
		 * if (request.getFirstName() != null) {
		 * ed.setFirstName(request.getFirstName()); }
		 * 
		 * if (request.getLastName() != null) { ed.setLastName(request.getLastName()); }
		 * if (request.getMobile() > 0) { ed.setMobileNumber(request.getMobile()); }
		 * ed.setAddress(request.getAddress());
		 * 
		 * session.save(ed);
		 */
		flag = true;
		return flag;
	}

	@Override
	public boolean addMultipleEmployees(EmployeeDto request) {
		boolean flag = false;

		int count = 1;
		for (EmployeeDto x : request.getEmpList()) {
			System.out.println("Printing object number - " + count);
			System.out.println(x.getFirstName());
			System.out.println(x.getLastName());
			System.out.println(x.getEmail());
			System.out.println(x.getMobile());
			count++;
		}
		flag = true;
		return flag;
	}

	@Override
	public List<EmployeeDto> getEmployeeDetailsByBranchId(int branchId) {

		List<EmployeeDto> empList = new ArrayList<>();

		EmployeeDto obj1 = new EmployeeDto();
		obj1.setFirstName("Abhishek");
		obj1.setFirstName("SHinde");
		obj1.setEmail("abhishek@gmail.com");
		empList.add(obj1);

		EmployeeDto obj2 = new EmployeeDto();
		obj2.setFirstName("Ananta");
		obj2.setFirstName("Kolhe");
		obj2.setEmail("ananta@gmail.com");
		empList.add(obj2);

		return empList;
	}

	@Override
	public boolean updateEmployeeDetails(EmployeeDto request) {
		Session session = getCurrentSession();

		// Session - GET // Param - ID (Parimary Key)

		/*
		 * EmployeeDetails ed = session.get(EmployeeDetails.class, request.getId());
		 * 
		 * System.out.println("Employee Address before update - " + ed.getAddress());
		 * 
		 * if (request.getAddress() != null) { ed.setAddress(request.getAddress()); }
		 * 
		 * session.update(ed);
		 * 
		 * System.out.println("Employee First Name - " + ed.getFirstName());
		 * System.out.println("Employee Last Name - " + ed.getLastName());
		 * System.out.println("Employee Address after update - " + ed.getAddress());
		 * System.out.println("Employee Id - " + ed.getId());
		 */

		return false;
	}

	@Override
	public List<EmployeeDto> getEmployeeDetails(EmployeeDto request) {
		Session session = getCurrentSession();

		List<EmployeeDto> dtoList = new ArrayList<>();

		// session - createQuery - HQL
		// Set parameter to the query - .setParameter(position,value);

		List<EmployeeDetails> list = session.createQuery("FROM EmployeeDetails where plantId=:locationId")
				.setParameter("locationId", request.getPlantId()).getResultList();

		for (EmployeeDetails x : list) {

			EmployeeDto dto = new EmployeeDto();
			dto.setEmpId(x.getEmpId());
			dto.setFirstName(x.getFirstName());
			dto.setLastName(x.getLastName());
			dtoList.add(dto);

		}

		// session - createNativeQuery - Database specific query

		return dtoList;
	}

	@Override
	public List<EmployeeDto> getEmployeeDetailsByPlantId(EmployeeDto request) {
		Session session = getCurrentSession();

		List<EmployeeDto> dtoList = new ArrayList<>();

		// session - createNativeQuery - Database specific query

		List<Object[]> objectList = session
				.createNativeQuery(
						"select first_name,last_name,email,mobile,emp_id from employee_details where plant_id=:locId")
				.setParameter("locId", request.getPlantId()).getResultList();

		for (Object[] x : objectList) {
			EmployeeDto dto = new EmployeeDto();

			if (x[0] != null) {
				String firstName = x[0].toString();
				dto.setFirstName(firstName);
			}

			if (x[1] != null) {
				String lastName = x[1].toString();
				dto.setLastName(lastName);
			}

			if (x[2] != null) {
				String email = x[2].toString();
				dto.setEmail(email);
			}

			if (x[3] != null) {
				String mobile = x[3].toString();
				dto.setMobile(mobile);
			}

			if (x[4] != null) {
				int empId = Integer.parseInt(String.valueOf(x[4]));
				dto.setEmpId(empId);
			}

			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public boolean deleteEmployeeRecord(int empId) {
		Session session = getCurrentSession();
		boolean flag = false;
		// Entity - Employee Details

		EmployeeDetails ed = session.load(EmployeeDetails.class, empId);
		if (ed != null) {
			session.delete(ed);
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean deleteEmployeeRecordWithCreateNativeQuery(int empId) {
		Session session = getCurrentSession();
		boolean flag = false;
		// Entity - Employee Details

		int rowsAffected = session.createNativeQuery("delete from employee_details where emp_id=:empId")
				.setParameter("empId", empId).executeUpdate();

		if (rowsAffected > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean deleteEmployeeRecordWithCreateQuery(int empId) {
		Session session = getCurrentSession();
		boolean flag = false;

		int roes = session.createQuery("FROM EmployeeDetails where empId=:emp_id").setParameter("empId", empId)
				.executeUpdate();

		if (roes > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean deleteMultipleEmployeeRecords(EmployeeDto request) {
		Session session = getCurrentSession();
		boolean flag = false;

		for (Integer x : request.getEmpIds()) {
			int rowsAffected = session.createNativeQuery("delete from employee_details where emp_id=:empId")
					.setParameter("empId", x).executeUpdate();

			if (rowsAffected > 0) {
				flag = true;
			}
		}

		return flag;
	}

}
