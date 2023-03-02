package com.project.collegemanagement.dao;

import java.util.List;

import com.project.collegemanagement.entity.Staff;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.DataBaseCustomException;

public interface StaffManagementDao {
	/**
	 * 
	 * @param staff
	 * @param departmentId
	 * @throws DaoException
	 * @throws DataBaseCustomException
	 */
	void addStaffDetails(Staff staff, Long departmentId) throws DaoException;

	/**
	 * 
	 * @param staff
	 * @throws DaoException
	 */
	void deleteStaffDetails(Staff staff) throws DaoException;

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	List<Staff> getAllStaff() throws DaoException;

	/**
	 * 
	 * @param email
	 * @return
	 * @throws DaoException
	 * @throws DataBaseCustomException
	 */
	Staff getStaffByEmail(String email) throws DaoException;

	/**
	 * 
	 * @param userOption
	 * @param staff
	 * @param updateDeptId
	 * @throws DaoException
	 */
	void updateStaffDetails(Integer userOption, Staff staff, Long updateDeptId) throws DaoException;
}