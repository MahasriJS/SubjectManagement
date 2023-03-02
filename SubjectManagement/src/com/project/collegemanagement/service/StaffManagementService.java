package com.project.collegemanagement.service;

import com.project.collegemanagement.entity.Staff;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.StaffNotFoundException;

public interface StaffManagementService {
	/**
	 * 
	 * @throws ServiceException
	 * @throws StaffNotFoundException
	 */
	void getAllStaff() throws ServiceException, StaffNotFoundException;

	/**
	 * 
	 * @param email
	 * @throws ServiceException
	 * @throws StaffNotFoundException
	 */
	void getStaffByEmail(String email) throws ServiceException, StaffNotFoundException;

	/**
	 * 
	 * @param userOption
	 * @param staff
	 * @param updateDeptId
	 * @throws ServiceException
	 */
	void updateStaffDetails(Integer userOption, Staff staff, Long updateDeptId) throws ServiceException;

	/**
	 * 
	 * @param staff
	 * @param departmentId
	 * @throws ServiceException
	 */

	void addStaffDetails(Staff staff, Long departmentId) throws ServiceException;

	/**
	 * 
	 * @param staff
	 * @throws ServiceException
	 */
	void deleteStaffDetails(Staff staff) throws ServiceException;

}
