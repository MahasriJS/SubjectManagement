package com.project.collegemanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.project.collegemanagement.client.SubjectManagementClient;
import com.project.collegemanagement.client.implem.SubjectManagementClientImplem;
import com.project.collegemanagement.exception.InvalidChoiceException;

public class SubjectManagementApp {
	public static void main(String[] args) {
		SubjectManagementClient subject = new SubjectManagementClientImplem();
		System.out.println("Enter your option:");
		System.out.println("1.Add Subject");
		System.out.println("2.Get all Subject");
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			int userOption = Integer.parseInt(bufferedReader.readLine());
			switch (userOption) {
			case 1:
				subject.insertSubject();
			case 2:
				subject.getAllSubject();
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		} catch (InvalidChoiceException | NumberFormatException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
