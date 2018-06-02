package com;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ReminderDB db = new ReminderDB();
		String event, date;
		while (true) {
			System.out.println("\n\nReminder Management System\n\n");
			System.out.println("1. Add Reminder");
			System.out.println("2. Update Reminder");
			System.out.println("3. View Reminder");
			System.out.println("4. Exit");
			System.out.print("Enter your choice :");
			int n = sc.nextInt();

			switch (n) {
			case 1:
				System.out.println("\n\n");
				System.out.println("Enter Event :");
				event = sc.next();
				System.out.println("Enter Date :");
				date = sc.next();

				ReminderBean r = new ReminderBean(event, date);
				db.addReminder(r);
				break;

			case 2:
				System.out.println("\n\n");
				db.viewAll();
				System.out.print("\nEnter the Id to update :");
				int id = sc.nextInt();
				System.out.println("Enter new Event :");
				event = sc.next();
				System.out.println("Enter new Date :");
				date = sc.next();

				ReminderBean r1 = new ReminderBean(event, date);
				r1.setId(id);
				db.updateReminder(r1);
				break;

			case 3:
				db.viewAll();
				break;

			case 4:
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Wrong choice! select a valid option!");
			}

		}
	}
	
	
}
