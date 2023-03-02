package com.project.collegemanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.collegemanagement.dao.CourseManagementDao;
import com.project.collegemanagement.entity.Course;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.util.DBUtil;

public class CourseManagementDaoImplem implements CourseManagementDao {

	@Override
	public List<Course> getAllCourseByDept(Long departmentId) throws DaoException {
		List<Course> courseList = new ArrayList<>();
		try (Connection con = DBUtil.getConnection();) {
			String query = "SELECT *FROM course where dept_id=?";
			PreparedStatement preparedSt = con.prepareStatement(query);
			preparedSt.setLong(1, departmentId);
			ResultSet rs = preparedSt.executeQuery();
			while (rs.next()) {
				courseList.add(
						new Course(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return courseList;
	}

}
