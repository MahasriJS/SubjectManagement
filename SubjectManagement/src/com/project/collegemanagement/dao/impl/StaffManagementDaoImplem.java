package com.project.collegemanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.collegemanagement.dao.StaffManagementDao;
import com.project.collegemanagement.entity.Staff;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.exception.InvalidChoiceException;
import com.project.collegemanagement.util.DBUtil;

public class StaffManagementDaoImplem implements StaffManagementDao {
	Scanner scanner = new Scanner(System.in);

	public void addStaffDetails(Staff staff, Long departmentId) throws DaoException {

		try (Connection con = DBUtil.getConnection();) {

			String query = "INSERT INTO staff(name,age,dob,date_of_joining,salary,domain,designation,phno,email,address,dept_id) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, staff.getName());
			preparedStmt.setInt(2, staff.getAge());
			preparedStmt.setString(3, staff.getDob());
			preparedStmt.setString(4, staff.getDateOfJoining());
			preparedStmt.setDouble(5, staff.getSalary());
			preparedStmt.setString(6, staff.getDomain());
			preparedStmt.setString(7, staff.getDesignation());
			preparedStmt.setString(8, staff.getPhno());
			preparedStmt.setString(9, staff.getEmail());
			preparedStmt.setString(10, staff.getAddress());
			preparedStmt.setLong(11, departmentId);
			long count = preparedStmt.executeUpdate();
			System.out.println(count + " " + "rows inserted!");
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}

	}

	public void updateStaffDetails(Integer userOption, Staff staff, Long updateDeptId) throws DaoException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement preparedStmt;
			switch (userOption) {
			case 1:
				preparedStmt = con.prepareStatement("UPDATE staff SET name=? where email=?");
				preparedStmt.setString(1, staff.getName());
				preparedStmt.setString(2, staff.getEmail());
				break;
			case 2:
				preparedStmt = con.prepareStatement("UPDATE staff Set age=? where email=?");
				preparedStmt.setInt(1, staff.getAge());
				preparedStmt.setString(2, staff.getEmail());
				break;
			case 3:
				preparedStmt = con.prepareStatement("UPDATE staff Set dob=? where email=?");
				preparedStmt.setString(1, staff.getName());
				preparedStmt.setString(2, staff.getEmail());
				break;
			case 4:
				preparedStmt = con.prepareStatement("UPDATE staff Set date_of_joining=? where email=?");
				preparedStmt.setString(1, staff.getDateOfJoining());
				preparedStmt.setString(2, staff.getEmail());
				break;
			case 5:
				preparedStmt = con.prepareStatement("UPDATE staff Set salary=? where email=?");
				preparedStmt.setDouble(1, staff.getSalary());
				preparedStmt.setString(2, staff.getEmail());
				break;
			case 6:
				preparedStmt = con.prepareStatement("UPDATE staff Set domain=? where email=?");
				preparedStmt.setString(1, staff.getDomain());
				preparedStmt.setString(2, staff.getEmail());
				break;
			case 7:
				preparedStmt = con.prepareStatement("UPDATE staff Set designation=? where email=?");
				preparedStmt.setString(1, staff.getDesignation());
				preparedStmt.setString(2, staff.getEmail());
				break;
			case 8:
				preparedStmt = con.prepareStatement("UPDATE staff Set phno=? where email=?");
				preparedStmt.setString(1, staff.getPhno());
				preparedStmt.setString(2, staff.getEmail());
				break;

			case 9:
				preparedStmt = con.prepareStatement("UPDATE staff Set address=? where email=?");
				preparedStmt.setString(1, staff.getAddress());
				preparedStmt.setString(2, staff.getEmail());
				break;

			case 10:
				preparedStmt = con.prepareStatement("UPDATE staff Set dept_id=? where email=?");
				preparedStmt.setLong(1, updateDeptId);
				preparedStmt.setString(2, staff.getEmail());
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

	public void deleteStaffDetails(Staff staff) throws DaoException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement preparedStmt = con.prepareStatement("DELETE FROM staff WHERE email=?");
			preparedStmt.setString(1, staff.getEmail());
			int count = preparedStmt.executeUpdate();
			System.out.println(count + "Rows deleted");
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}

	@Override

	public List<Staff> getAllStaff() throws DaoException {
		List<Staff> staffsList = new ArrayList<>();
		try (Connection con = DBUtil.getConnection();) {
			Statement st = con.createStatement();
			String query = "SELECT s.id,s.name,s.age,s.dob,s.date_of_joining,s.salary,s.domain,s.designation,s.phno,s.email,s.address,d.name FROM staff AS s INNER JOIN department AS d on s.dept_id=d.id";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				staffsList.add(new Staff(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12)));
			}
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return staffsList;

	}

	@Override

	public Staff getStaffByEmail(String email) throws DaoException {
		Staff staff = null;
		try (Connection con = DBUtil.getConnection();) {
			String query = "SELECT s.id,s.name,s.age,s.dob,s.date_of_joining,s.salary,s.domain,s.designation,s.phno,s.email,s.address,d.name FROM staff AS s INNER JOIN department AS d where email=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, email);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				staff = new Staff(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12));
			}
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return staff;
	}

}
