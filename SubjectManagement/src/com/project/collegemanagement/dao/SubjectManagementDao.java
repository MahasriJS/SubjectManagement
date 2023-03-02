package com.project.collegemanagement.dao;

import java.util.List;

import com.project.collegemanagement.entity.Subject;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.exception.SubjectNotFoundException;

public interface SubjectManagementDao {
	/**
	 * 
	 * @param subject
	 * @param courseId
	 * @param semId
	 * @throws DaoException
	 * @throws DataBaseCustomException
	 * @throws DepartmentNotFoundException
	 * @throws SemesterNotFoundException
	 */

	void addSubjectDetails(Subject subject, Long courseId, Long semId) throws DaoException;

	/**
	 * 
	 * @param courseId
	 * @param semId
	 * @return
	 * @throws DaoException
	 * @throws DataBaseCustomException
	 * @throws SubjectNotFoundException
	 * @throws SemesterNotFoundException
	 * @throws CourseNotFoundException
	 * @throws DepartmentNotFoundException
	 */

	List<Subject> getAllSubject(Long courseId, Long semId) throws DaoException;
}
