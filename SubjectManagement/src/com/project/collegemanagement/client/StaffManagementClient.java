package com.project.collegemanagement.client;

import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.StaffCustomException;
import com.project.collegemanagement.exception.StaffNotFoundException;

public interface StaffManagementClient {
	/**
	 * 
	 * @throws StaffCustomException
	 * @throws ServiceException
	 */
	void insertStaff();

	/**
	 * To update the staff details
	 * 
	 * @throws Exception
	 */
	void updateStaff();

	/**
	 * 
	 * @throws StaffNotFoundException
	 * @throws ServiceException
	 */
	void deleteStaff();

	/**
	 * 
	 * @throws StaffNotFoundException
	 * @throws ServiceException
	 */
	void getAllStaff();

	/**
	 * 
	 * @throws ServiceException
	 */
	void getStaffByEmail();
}
