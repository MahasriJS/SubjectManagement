package com.project.collegemanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.collegemanagement.dao.StudentManagementDao;
import com.project.collegemanagement.entity.Student;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.exception.InvalidChoiceException;
import com.project.collegemanagement.util.DBUtil;

public class StudentManagementDaoImplem implements StudentManagementDao {

	@Override
	public void addStudentDetails(Student student, Long departmentId) throws DaoException {
		try (Connection con = DBUtil.getConnection();) {
			String query = "INSERT INTO student(name,age,dob,date_of_joining,phno,email,address,dept_id) VALUES(?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, student.getName());
			preparedStmt.setInt(2, student.getAge());
			preparedStmt.setString(3, student.getDob());
			preparedStmt.setString(4, student.getDateOfJoining());
			preparedStmt.setString(5, student.getPhno());
			preparedStmt.setString(6, student.getEmail());
			preparedStmt.setString(7, student.getAddress());
			preparedStmt.setLong(8, departmentId);
			long count = preparedStmt.executeUpdate();
			System.out.println(count + " " + "rows inserted!");
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}

	}

	@Override
	public void updateStudentDetails(Integer userOption, Student student, Long updateDeptId) throws DaoException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement preparedStmt;
			switch (userOption) {
			case 1:
				preparedStmt = con.prepareStatement("UPDATE student SET name=? where email=?");
				preparedStmt.setString(1, student.getName());
				preparedStmt.setString(2, student.getEmail());
				break;
			case 2:
				preparedStmt = con.prepareStatement("UPDATE student Set age=? where email=?");
				preparedStmt.setInt(1, student.getAge());
				preparedStmt.setString(2, student.getEmail());
				break;
			case 3:
				preparedStmt = con.prepareStatement("UPDATE student Set dob=? where email=?");
				preparedStmt.setString(1, student.getName());
				preparedStmt.setString(2, student.getEmail());
				break;
			case 4:
				preparedStmt = con.prepareStatement("UPDATE student Set date_of_joining=? where email=?");
				preparedStmt.setString(1, student.getDateOfJoining());
				preparedStmt.setString(2, student.getEmail());
				break;

			case 5:
				preparedStmt = con.prepareStatement("UPDATE student Set phno=? where email=?");
				preparedStmt.setString(1, student.getPhno());
				preparedStmt.setString(2, student.getEmail());
				break;

			case 6:
				preparedStmt = con.prepareStatement("UPDATE student Set address=? where email=?");
				preparedStmt.setString(1, student.getAddress());
				preparedStmt.setString(2, student.getEmail());
				break;
			case 7:
				preparedStmt = con.prepareStatement("UPDATE student Set dept_id=? where email=?");
				preparedStmt.setLong(1, updateDeptId);
				preparedStmt.setString(2, student.getEmail());
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
			int count = preparedStmt.executeUpdate();
			System.out.println(count + " " + "Rows updated");
		} catch (SQLException | InvalidChoiceException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}

	}

	@Override
	public void deleteStudentDetails(Student student) throws DaoException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement preparedStmt = null;
			String query = "DELETE FROM student WHERE email=?";
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, student.getEmail());
			int count = preparedStmt.executeUpdate();

			System.out.println(count + " " + "Rows Deleted!");

		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}

	@Override
	public List<Student> getAllStudent() throws DaoException {
		List<Student> studentList = new ArrayList<>();
		try (Connection con = DBUtil.getConnection();) {
			Statement st = con.createStatement();
			String query = "SELECT s.id,s.name,s.age,s.dob,s.date_of_joining,s.phno,s.email,s.address,d.name FROM student AS s INNER JOIN department AS d on s.dept_id=d.id";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				studentList.add(new Student(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}

		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return studentList;

	}

	@Override
	public Student getStudentByEmail(String email) throws DaoException {
		Student student = null;
		try (Connection con = DBUtil.getConnection();) {
			String query = "SELECT s.id,s.name,s.age,s.dob,s.date_of_joining,s.phno,s.email,s.address,d.name FROM student AS s INNER JOIN department AS d where email=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, email);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				student = new Student(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return student;
	}

}
