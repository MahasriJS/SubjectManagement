package com.project.collegemanagement.service.implem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.project.collegemanagement.dao.impl.StudentManagementDaoImplem;
import com.project.collegemanagement.entity.Student;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.StudentNotFoundException;
import com.project.collegemanagement.service.StudentManagementService;

public class StudentManagementServiceImplem implements StudentManagementService {
	StudentManagementDaoImplem studDAOImpl = new StudentManagementDaoImplem();

	@Override
	public void addStudentDetails(Student student, Long departmentId) throws ServiceException {

		try {
			studDAOImpl.addStudentDetails(student, departmentId);

		} catch (DaoException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}

	}

	public void updateStudentDetails(Integer userOption, Student student, Long departmentId) throws ServiceException {
		try {
			Student existingStudent = studDAOImpl.getStudentByEmail(student.getEmail());
			if (existingStudent != null) {
				studDAOImpl.updateStudentDetails(userOption, student, departmentId);
			} else {
				throw new StudentNotFoundException("student Not found");
			}

		} catch (DaoException | StudentNotFoundException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}

	}

	public void deleteStudentDetails(Student student) throws ServiceException {
		try {

			Student existingStudent = studDAOImpl.getStudentByEmail(student.getEmail());
			if (existingStudent != null) {
				studDAOImpl.deleteStudentDetails(student);
			} else {
				throw new StudentNotFoundException("student Not found");
			}

		} catch (DaoException | StudentNotFoundException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

	public void getAllStudent() throws ServiceException, StudentNotFoundException {

		try {
			List<Student> studentsList = new ArrayList<>();
			studentsList = studDAOImpl.getAllStudent();
			if (!studentsList.isEmpty()) {
				Iterator<Student> studentsItr = studentsList.iterator();
				while (studentsItr.hasNext()) {
					System.out.println(studentsItr.next());
				}
			} else {
				throw new StudentNotFoundException("staff Not found");
			}
		} catch (DaoException e) {

			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

	public Student getStudentByEmail(String email) throws StudentNotFoundException, ServiceException {
		Student student = null;
		try {
			student = studDAOImpl.getStudentByEmail(email);
			if (student != null) {
				System.out.println(student);
			}

			else {
				throw new StudentNotFoundException("student Not found");
			}
			return studDAOImpl.getStudentByEmail(email);

		} catch (DaoException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

}
