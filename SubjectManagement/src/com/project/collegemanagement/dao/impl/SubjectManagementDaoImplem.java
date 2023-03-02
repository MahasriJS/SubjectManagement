package com.project.collegemanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.collegemanagement.dao.SubjectManagementDao;
import com.project.collegemanagement.entity.Subject;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.util.DBUtil;

public class SubjectManagementDaoImplem implements SubjectManagementDao {
	public void addSubjectDetails(Subject subject, Long courseId, Long semId) throws DaoException {
		try (Connection con = DBUtil.getConnection();) {
			String query = "INSERT INTO Subject(code,name,description,credits,course_id,sem_id) VALUES(?,?,?,?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, subject.getCode());
			preparedStmt.setString(2, subject.getName());
			preparedStmt.setString(3, subject.getDescription());
			preparedStmt.setInt(4, subject.getCredits());
			preparedStmt.setLong(5, courseId);
			preparedStmt.setLong(6, semId);
			long count = preparedStmt.executeUpdate();
			System.out.println(count + " " + "rows inserted!");

		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}

	}

	@Override
	public List<Subject> getAllSubject(Long courseId, Long semId) throws DaoException {
		List<Subject> subjectList = new ArrayList<>();
		try (Connection con = DBUtil.getConnection();) {
			String query = "SELECT *FROM subject WHERE course_id=? and sem_id=?";
			PreparedStatement preparedSt = con.prepareStatement(query);
			preparedSt.setLong(1, courseId);
			preparedSt.setLong(2, semId);
			ResultSet rs = preparedSt.executeQuery();
			while (rs.next()) {
				subjectList.add(new Subject(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return subjectList;
	}

}
