
package com.project.collegemanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.project.collegemanagement.client.StaffManagementClient;
import com.project.collegemanagement.client.implem.StaffManagementClientImplem;
import com.project.collegemanagement.exception.InvalidChoiceException;

public class StaffManagementApp {
	public static void main(String[] args) {
		StaffManagementClient staff = new StaffManagementClientImplem();
		System.out.println("Enter your option:");
		System.out.println("1.Add staff");
		System.out.println("2.Update staff");
		System.out.println("3.Delete staff");
		System.out.println("4.Get all staff");
		System.out.println("5.Get staff By email");
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			int userOption = Integer.parseInt(bufferedReader.readLine());
			switch (userOption) {
			case 1:
				staff.insertStaff();
			case 2:
				staff.updateStaff();
			case 3:
				staff.deleteStaff();
			case 4:
				staff.getAllStaff();
			case 5:
				staff.getStaffByEmail();
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		} catch (IOException | InvalidChoiceException e) {
			System.out.println(e.getMessage());
		}
	}
}
