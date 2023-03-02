package com.project.collegemanagement.dao;

import java.util.List;

import com.project.collegemanagement.entity.Student;
import com.project.collegemanagement.exception.DaoException;

public interface StudentManagementDao {
	/**
	 * 
	 * @param userOption
	 * @param Student
	 * @param updateDeptId
	 * @throws DaoException
	 */
	void updateStudentDetails(Integer userOption, Student Student, Long updateDeptId) throws DaoException;

	/**
	 * 
	 * @param student
	 * @throws DaoException
	 */
	void deleteStudentDetails(Student student) throws DaoException;

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	List<Student> getAllStudent() throws DaoException;

	/**
	 * 
	 * @param email
	 * @return
	 * @throws DaoException
	 */
	Student getStudentByEmail(String email) throws DaoException;

	/**
	 * 
	 * @param student
	 * @param departmentId
	 * @throws DaoException
	 */

	void addStudentDetails(Student student, Long departmentId) throws DaoException;

}
