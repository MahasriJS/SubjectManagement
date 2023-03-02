
package com.project.collegemanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.project.collegemanagement.client.StudentManagementClient;
import com.project.collegemanagement.client.implem.StudentManagementClientImplem;
import com.project.collegemanagement.exception.InvalidChoiceException;

public class StudentManagementApp {
	public static void main(String[] args) {
		StudentManagementClient student = new StudentManagementClientImplem();
		System.out.println("1.Add student");
		System.out.println("2.Update student");
		System.out.println("3.Delete student");
		System.out.println("4.Get all student");
		System.out.println("5.Get student By email");
		System.out.println("Enter your option:");
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			int userOption = Integer.parseInt(bufferedReader.readLine());
			switch (userOption) {
			case 1:
				student.insertStudent();
			case 2:
				student.updateStudent();
			case 3:
				student.deleteStudent();
			case 4:
				student.getAllStudent();
			case 5:
				student.getStudentByEmail();
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		} catch (InvalidChoiceException | NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
}
