package com.project.collegemanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.project.collegemanagement.exception.InvalidChoiceException;

public class CollegeManagement {
	public static void main(String[] args) {
		System.out.println("1.STUDENT MANAGEMENT SYSTEM");
		System.out.println("2.STAFF MANAGEMENT SYSTEM");
		System.out.println("3.SUBJECT MANAGEMENT SYSTEM");
		System.out.println("4.Exit");
		System.out.println("Enter your choice:");

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				System.out.println("In Student application");
				StudentManagementApp.main(args);
				break;
			case 2:
				System.out.println("In Staff application");
				StaffManagementApp.main(args);
				break;
			case 3:
				System.out.println("In Subject application");
				SubjectManagementApp.main(args);
				break;
			case 4:
				System.out.println("Exited!!");
				System.exit(userChoice);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		} catch (InvalidChoiceException | NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
