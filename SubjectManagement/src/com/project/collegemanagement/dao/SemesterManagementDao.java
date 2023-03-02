package com.project.collegemanagement.dao;

import java.util.List;

import com.project.collegemanagement.entity.Semester;
import com.project.collegemanagement.exception.DaoException;

public interface SemesterManagementDao {
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	List<Semester> getAllSemester() throws DaoException;

}
