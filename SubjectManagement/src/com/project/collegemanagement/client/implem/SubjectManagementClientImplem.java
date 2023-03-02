package com.project.collegemanagement.client.implem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.project.collegemanagement.client.SubjectManagementClient;
import com.project.collegemanagement.entity.Course;
import com.project.collegemanagement.entity.Department;
import com.project.collegemanagement.entity.Semester;
import com.project.collegemanagement.entity.Subject;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.SubjectCustomException;
import com.project.collegemanagement.exception.SubjectNotFoundException;
import com.project.collegemanagement.service.CourseManagementService;
import com.project.collegemanagement.service.DepartmentManagementService;
import com.project.collegemanagement.service.SemesterManagementService;
import com.project.collegemanagement.service.SubjectManagementService;
import com.project.collegemanagement.service.implem.CourseManagementServiceImplem;
import com.project.collegemanagement.service.implem.DepartmentManagementServiceImplem;
import com.project.collegemanagement.service.implem.SemesterManagementServiceImplem;
import com.project.collegemanagement.service.implem.SubjectManagementServiceImplem;

public class SubjectManagementClientImplem implements SubjectManagementClient {
	SemesterManagementService semService = new SemesterManagementServiceImplem();
	CourseManagementService courseService = new CourseManagementServiceImplem();
	SubjectManagementService subjectService = new SubjectManagementServiceImplem();
	DepartmentManagementService deptService = new DepartmentManagementServiceImplem();
	Subject subject = new Subject();

	public void insertSubject() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			System.out.println("Availabe departments  are");
			List<Department> departments = deptService.getAllDepartment();
			departments.stream().forEach(dept -> System.out.println(dept.getName()));
			System.out.println("Enter Department name");
			String deptName = bufferedReader.readLine();
			subject.setDeptName(deptName);
			Long departmentId = departments.stream().filter(dept -> dept.getName().equals(deptName))
					.map(Department::getId).findFirst().orElse(null);
			System.out.println("Availabe Course are");
			List<Course> courses = courseService.getAllCourseByDept(departmentId);
			courses.stream().forEach(course -> System.out.println(course.getName()));
			System.out.println("Enter Course name");
			String courseName = bufferedReader.readLine();
			subject.setCourseName(courseName);
			Long courseId = courses.stream().filter(course -> course.getName().equals(courseName)).map(Course::getId)
					.findFirst().orElse(null);
			System.out.println("Availabe semester  are");
			List<Semester> semesters = semService.getAllSemester();
			semesters.stream().forEach(semester -> System.out.println(semester.getName()));
			System.out.println("Enter Semester name");
			String semName = bufferedReader.readLine();
			subject.setCourseName(semName);
			Long semId = semesters.stream().filter(semester -> semester.getName().equals(semName)).map(Semester::getId)
					.findFirst().orElse(null);
			if (deptName == null || courseName == null || semName == null) {
				throw new SubjectCustomException("Invalid Subject Details!!");
			}
			System.out.println("Enter Subject code");
			String code = bufferedReader.readLine();
			subject.setCode(code);
			System.out.println("Enter Subject name");
			String name = bufferedReader.readLine();
			subject.setName(name);
			System.out.println("Enter Subject description");
			String description = bufferedReader.readLine();
			subject.setDescription(description);
			System.out.println("Enter Subject credits");
			Integer credits = Integer.parseInt(bufferedReader.readLine());
			subject.setCredits(credits);
			subjectService.addSubjectDetails(subject, courseId, semId);
		} catch (ServiceException | SubjectCustomException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void getAllSubject() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			System.out.println("Availabe departments  are");
			List<Department> departments = deptService.getAllDepartment();
			departments.stream().forEach(dept -> System.out.println(dept.getName()));
			System.out.println("Enter Department name");
			String deptName = bufferedReader.readLine();
			Long departmentId = departments.stream().filter(dept -> dept.getName().equals(deptName))
					.map(Department::getId).findFirst().orElse(null);
			subject.setDeptName(deptName);
			System.out.println("Availabe Course are");
			List<Course> courses = courseService.getAllCourseByDept(departmentId);
			courses.stream().forEach(course -> System.out.println(course.getName()));
			System.out.println("Enter Course name");
			String courseName = bufferedReader.readLine();
			Long courseId = courses.stream().filter(course -> course.getName().equals(courseName)).map(Course::getId)
					.findFirst().orElse(null);
			subject.setCourseName(courseName);
			System.out.println("Availabe semester  are");
			List<Semester> semesters = semService.getAllSemester();
			semesters.stream().forEach(semester -> System.out.println(semester.getName()));
			System.out.println("Enter Semester name");
			String semName = bufferedReader.readLine();
			subject.setCourseName(semName);
			Long semId = semesters.stream().filter(semester -> semester.getName().equals(semName)).map(Semester::getId)
					.findFirst().orElse(null);
			List<Subject> subjects = subjectService.getAllSubject(courseId, semId);
			subjects.stream()
					.forEach(subject -> System.out.println("Id :" + " " + subject.getId() + " " + "Code :" + " "
							+ subject.getCode() + " " + "Name :" + " " + subject.getName() + " " + "Description :" + " "
							+ subject.getDescription() + " " + "Subject :" + " " + subject.getCredits()));
		} catch (ServiceException | SubjectNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
