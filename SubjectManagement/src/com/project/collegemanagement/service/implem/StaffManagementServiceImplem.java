package com.project.collegemanagement.service.implem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.project.collegemanagement.dao.impl.StaffManagementDaoImplem;
import com.project.collegemanagement.entity.Staff;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.StaffNotFoundException;
import com.project.collegemanagement.service.StaffManagementService;

public class StaffManagementServiceImplem implements StaffManagementService {
	StaffManagementDaoImplem staffDaoImpl = new StaffManagementDaoImplem();

	@Override
	public void addStaffDetails(Staff staff, Long departmentId) throws ServiceException {

		try {
			staffDaoImpl.addStaffDetails(staff, departmentId);

		} catch (DaoException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void updateStaffDetails(Integer userOption, Staff staff, Long updateDeptId) throws ServiceException {
		try {
			Staff existingStaff = staffDaoImpl.getStaffByEmail(staff.getEmail());
			if (existingStaff != null) {
				staffDaoImpl.updateStaffDetails(userOption, staff, updateDeptId);
			} else {
				throw new StaffNotFoundException("staff Not found");
			}

		} catch (DaoException | StaffNotFoundException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void deleteStaffDetails(Staff staff) throws ServiceException {
		try {
			Staff existingStaff = staffDaoImpl.getStaffByEmail(staff.getEmail());
			if (existingStaff != null) {
				staffDaoImpl.deleteStaffDetails(staff);// }
			} else {
				throw new StaffNotFoundException("staff Not found");
			}

		} catch (DaoException | StaffNotFoundException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void getAllStaff() throws ServiceException, StaffNotFoundException {
		try {

			List<Staff> staffsList = new ArrayList<>();

			staffsList = staffDaoImpl.getAllStaff();
			if (!staffsList.isEmpty()) {
				Iterator<Staff> staffsItr = staffsList.iterator();
				while (staffsItr.hasNext()) {
					System.out.println(staffsItr.next());
				}
			} else {
				throw new StaffNotFoundException("staff Not found");
			}
		} catch (DaoException | StaffNotFoundException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

	@Override

	public void getStaffByEmail(String email) throws ServiceException, StaffNotFoundException {
		Staff staff = null;
		try {
			staff = staffDaoImpl.getStaffByEmail(email);
			if (staff != null) {
				System.out.println(staff);
			}

			else {
				throw new StaffNotFoundException("staff Not found");
			}
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
}
