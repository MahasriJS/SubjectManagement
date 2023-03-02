package com.project.collegemanagement.client.implem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.project.collegemanagement.client.StudentManagementClient;
import com.project.collegemanagement.entity.Department;
import com.project.collegemanagement.entity.Student;
import com.project.collegemanagement.exception.InvalidChoiceException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.StudentCustomException;
import com.project.collegemanagement.exception.StudentNotFoundException;
import com.project.collegemanagement.service.DepartmentManagementService;
import com.project.collegemanagement.service.StudentManagementService;
import com.project.collegemanagement.service.implem.DepartmentManagementServiceImplem;
import com.project.collegemanagement.service.implem.StudentManagementServiceImplem;

public class StudentManagementClientImplem implements StudentManagementClient {
	private String PhnoPattern = "[978]{1}\\d{9}";
	private String emailPattern = "[a-z0-9]+@(.+)";
	StudentManagementService studentService = new StudentManagementServiceImplem();
	DepartmentManagementService deptService = new DepartmentManagementServiceImplem();

	public void insertStudent() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			Student student = new Student();
			System.out.println("Enter student name");
			String name = bufferedReader.readLine();
			student.setName(name);
			System.out.println("Enter student age");
			Integer age = Integer.parseInt(bufferedReader.readLine());
			student.setAge(age);
			System.out.println("Enter student dob dd/mm/yyy");
			String dob = bufferedReader.readLine();
			student.setDob(dob);
			System.out.println("Enter student date of joining dd/mm/yyy");
			String dateOfJoining = bufferedReader.readLine();
			student.setDateOfJoining(dateOfJoining);
			System.out.println("Enter student mobile number(Only ten digits)");
			String phno = bufferedReader.readLine();
			student.setPhno(phno);
			System.out.println("Enter student email");
			String email = bufferedReader.readLine();
			student.setEmail(email);
			System.out.println("Enter student address");
			String studentAddress = bufferedReader.readLine();
			student.setAddress(studentAddress);
			System.out.println("Availabe departments  are");
			List<Department> departments = deptService.getAllDepartment();
			departments.stream().forEach(dept -> System.out.println(dept.getName()));
			System.out.println("Enter Department name");
			String deptName = bufferedReader.readLine();
			student.setDepartmentName(deptName);
			Long departmentId = departments.stream().filter(dept -> dept.getName().equals(deptName))
					.map(Department::getId).findFirst().orElse(null);
			boolean studentPhnoFlag = phno.matches(PhnoPattern);
			boolean studentEmailFlag = email.matches(emailPattern);
			if (!studentPhnoFlag || age < 17 || !studentEmailFlag) {
				throw new StudentCustomException("Invalid student Details!!");
			}

			studentService.addStudentDetails(student, departmentId);
		} catch (ServiceException | StudentCustomException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateStudent() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			Student student = new Student();
			Long updateDeptId = null;
			System.out.println("Enter the student email to update:");
			String updateEmail = bufferedReader.readLine();
			student.setEmail(updateEmail);
			System.out.println("1.Update student name");
			System.out.println("2.Update student age");
			System.out.println("3.Update student dob");
			System.out.println("4.Update student date of joining");
			System.out.println("5.Update student phno");
			System.out.println("6.Update student address");
			System.out.println("7.Update student department name");
			System.out.println("Enter your choice:");
			Integer userOption = Integer.parseInt(bufferedReader.readLine());
			switch (userOption) {
			case 1:
				System.out.println("Enter the new studet name to be update:");
				String updateName = bufferedReader.readLine();
				student.setName(updateName);

				break;
			case 2:
				System.out.println("Enter the new student age to be update:");
				Integer updateage = Integer.parseInt(bufferedReader.readLine());
				student.setAge(updateage);
				break;
			case 3:
				System.out.println("Enter the new student dob to be update:");
				String updatedob = bufferedReader.readLine();
				student.setDob(updatedob);
				break;
			case 4:
				System.out.println("Enter the new student date of joining dd/mm/yyy to be update:");
				String updatedateOfJoining = bufferedReader.readLine();
				student.setDateOfJoining(updatedateOfJoining);
				break;
			case 5:
				System.out.println("Enter the new student mobile number to be update:");
				String updatephno = bufferedReader.readLine();
				student.setPhno(updatephno);
				break;
			case 6:
				System.out.println("Enter the new student address to be update:");
				String updateaddress = bufferedReader.readLine();
				student.setAddress(updateaddress);
				break;
			case 7:
				System.out.println("Availabe departments are");
				List<Department> departments = deptService.getAllDepartment();
				departments.stream().forEach(dept -> System.out.println(dept.getName()));
				System.out.println("Enter new student department to be update:");
				String updateDeptName = bufferedReader.readLine();
				student.setDepartmentName(updateDeptName);
				updateDeptId = departments.stream().filter(dept -> dept.getName().equals(updateDeptName))
						.map(Department::getId).findFirst().orElse(null);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}

			studentService.updateStudentDetails(userOption, student, updateDeptId);
		} catch (ServiceException | InvalidChoiceException | IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void deleteStudent() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			Student student = new Student();
			System.out.println("Enter the student email to delete:");
			String deleteEmail = bufferedReader.readLine();
			student.setEmail(deleteEmail);
			studentService.deleteStudentDetails(student);
		} catch (ServiceException | IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void getAllStudent() {
		try {
			studentService.getAllStudent();
		} catch (ServiceException | StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getStudentByEmail() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			Student student = new Student();
			System.out.println("Enter the student email to fetch details:");
			String userStudEmail = bufferedReader.readLine();
			student = studentService.getStudentByEmail(userStudEmail);
		} catch (ServiceException | StudentNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
