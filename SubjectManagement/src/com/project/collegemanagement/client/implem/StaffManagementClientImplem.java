package com.project.collegemanagement.client.implem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.project.collegemanagement.client.StaffManagementClient;
import com.project.collegemanagement.entity.Department;
import com.project.collegemanagement.entity.Staff;
import com.project.collegemanagement.exception.InvalidChoiceException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.StaffCustomException;
import com.project.collegemanagement.exception.StaffNotFoundException;
import com.project.collegemanagement.service.DepartmentManagementService;
import com.project.collegemanagement.service.StaffManagementService;
import com.project.collegemanagement.service.implem.DepartmentManagementServiceImplem;
import com.project.collegemanagement.service.implem.StaffManagementServiceImplem;

public class StaffManagementClientImplem implements StaffManagementClient {

	private String PhnoPattern = "[978]{1}\\d{9}";
	private String emailPattern = "[a-z0-9]+@(.+)";

	StaffManagementService staffService = new StaffManagementServiceImplem();
	DepartmentManagementService deptService = new DepartmentManagementServiceImplem();

	public void insertStaff() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			Staff staff = new Staff();
			System.out.println("Enter staff name");
			String name = bufferedReader.readLine();
			staff.setName(name);
			System.out.println("Enter staff age");
			Integer age = Integer.parseInt(bufferedReader.readLine());
			staff.setAge(age);
			System.out.println("Enter staff dob dd/mm/yyy");
			String dob = bufferedReader.readLine();
			staff.setDob(dob);
			System.out.println("Enter staff date of joining dd/mm/yyy");
			String dateOfJoining = bufferedReader.readLine();
			staff.setDateOfJoining(dateOfJoining);
			System.out.println("Enter staff salary");
			Double salary = Double.parseDouble(bufferedReader.readLine());
			staff.setSalary(salary);
			System.out.println("Enter staff domain");
			String domain = bufferedReader.readLine();
			staff.setDomain(domain);
			System.out.println("Enter staff designation");
			String designation = bufferedReader.readLine();
			staff.setDesignation(designation);
			System.out.println("Enter staff mobile number (Only ten digits)");
			String phno = bufferedReader.readLine();
			staff.setPhno(phno);
			System.out.println("Enter staff email");
			String email = bufferedReader.readLine();
			staff.setEmail(email);
			System.out.println("Enter staff address");
			String address = bufferedReader.readLine();
			staff.setAddress(address);
			System.out.println("Availabe departments  are");
			List<Department> departments = deptService.getAllDepartment();
			departments.stream().forEach(dept -> System.out.println(dept.getName()));
			System.out.println("Enter Department name");
			String deptName = bufferedReader.readLine();
			staff.setDepartmentName(deptName);
			Long departmentId = departments.stream().filter(dept -> dept.getName().equals(deptName))
					.map(Department::getId).findFirst().orElse(null);
			boolean staffPhnoFlag = phno.matches(PhnoPattern);
			boolean staffEmailFlag = email.matches(emailPattern);
			if (!staffPhnoFlag || age < 17 || !staffEmailFlag) {
				throw new StaffCustomException("Invalid staff Details!!");
			}

			staffService.addStaffDetails(staff, departmentId);
		} catch (ServiceException | StaffCustomException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateStaff() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			Staff staff = new Staff();
			Long updateDeptId = null;
			System.out.println("Enter the staff email to update:");
			String updateEmail = bufferedReader.readLine();
			staff.setEmail(updateEmail);
			System.out.println("1.Update staff name");
			System.out.println("2.Update staff age");
			System.out.println("3.Update staff dob");
			System.out.println("4.Update staff date of joining");
			System.out.println("5.Update staff salary");
			System.out.println("6.Update staff domain");
			System.out.println("7.Update staff designation");
			System.out.println("8.Update staff phno");
			System.out.println("9.Update staff address");
			System.out.println("10.Update staff department name");
			System.out.println("Enter your choice:");
			Integer userOption = Integer.parseInt(bufferedReader.readLine());
			switch (userOption) {
			case 1:
				System.out.println("Enter the new name to be update::");
				String updateName = bufferedReader.readLine();
				staff.setName(updateName);
				break;
			case 2:
				System.out.println("Enter new staff age to be update:");
				Integer updateage = Integer.parseInt(bufferedReader.readLine());
				staff.setAge(updateage);
				break;
			case 3:
				System.out.println("Enter new staff dob to be update:");
				String updatedob = bufferedReader.readLine();
				staff.setDob(updatedob);
				break;
			case 4:
				System.out.println("Enter new staff date of joining dd/mm/yyy to be update:");
				String updatedateOfJoining = bufferedReader.readLine();
				staff.setDateOfJoining(updatedateOfJoining);
				break;
			case 5:
				System.out.println("Enter new staff salary to be update:");
				Double updatesalary = Double.parseDouble(bufferedReader.readLine());
				staff.setSalary(updatesalary);
				break;
			case 6:
				System.out.println("Enter new staff domain to be update:");
				String updatedomain = bufferedReader.readLine();
				staff.setDomain(updatedomain);
				break;
			case 7:
				System.out.println("Enter new staff designation to be update:");
				String updatedesignation = bufferedReader.readLine();
				staff.setDesignation(updatedesignation);
				break;
			case 8:
				System.out.println("Enter new staff mobile number to be update:");
				String updatephno = bufferedReader.readLine();
				staff.setPhno(updatephno);
				break;

			case 9:
				System.out.println("Enter new staff address to be update:");
				String updateaddress = bufferedReader.readLine();
				staff.setAddress(updateaddress);
				break;
			case 10:
				System.out.println("Availabe departments are");
				List<Department> departments = deptService.getAllDepartment();
				departments.stream().forEach(dept -> System.out.println(dept.getName()));
				System.out.println("Enter new staff department to be update:");
				String updateDeptName = bufferedReader.readLine();
				staff.setDepartmentName(updateDeptName);
				updateDeptId = departments.stream().filter(dept -> dept.getName().equals(updateDeptName))
						.map(Department::getId).findFirst().orElse(null);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}

			staffService.updateStaffDetails(userOption, staff, updateDeptId);
		} catch (ServiceException | InvalidChoiceException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteStaff() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			Staff staff = new Staff();
			System.out.println("Enter the staff email to delete:");
			String deleteEmail = bufferedReader.readLine();
			staff.setEmail(deleteEmail);

			staffService.deleteStaffDetails(staff);
		} catch (ServiceException | IOException e) {
			e.printStackTrace();
		}
	}

	public void getAllStaff() {
		try {
			staffService.getAllStaff();
		} catch (ServiceException | StaffNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void getStaffByEmail() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			System.out.println("Enter the staff email to fetch details:");
			String userstaffEmail = bufferedReader.readLine();
			staffService.getStaffByEmail(userstaffEmail);
		} catch (ServiceException | StaffNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
