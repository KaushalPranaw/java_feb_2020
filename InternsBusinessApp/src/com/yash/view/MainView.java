package com.yash.view;

import java.util.Scanner;

import com.yash.controller.InternsController;
import com.yash.entities.Intern;
import com.yash.entities.Level;

public class MainView {
	private InternsController internsController;

	public MainView() {
		internsController = new InternsController();
	}

	public void mainMenu() {
		int id;
		String firstName;
		String lastName;
		int age;
		Level level;
		System.out.println("Enter \n");
		try (Scanner scanner = new Scanner(System.in)) {
			boolean exit = true;
			while (exit) {
				try {
					System.out.println("1. View All Interns\n" + "2. Register Intern\n" + "3. Update Intern\n"
							+ "4. Delete Intern\n" + "5. Exit\n" + "choose your choice");

					switch (scanner.nextInt()) {
					case 1:
						for (Intern o : internsController.getAllInterns()) {
							System.out.println(o);
						}
						break;
					case 2:
						System.out.println("Enter id firstName lastname, age and level 0 : beginner, 1:intermediate, 2:advance");
						id = scanner.nextInt();
						firstName = scanner.next();
						lastName = scanner.next();
						age = scanner.nextInt();
						level = null;
						switch (scanner.nextInt()) {
						case 0:
							level = Level.BEGINNER;
							break;
						case 1:
							level = Level.INTERMEDIATE;
							break;
						case 2:
							level = Level.ADVANCE;
							break;
						}
						Intern intern = new Intern(id, firstName, lastName, age, level);
						System.out.println(internsController.insert(intern));
						break;
					case 3:
						System.out.println("Enter id and level");
						id = scanner.nextInt();
						level = null;
						switch (scanner.nextInt()) {
						case 0:
							level = Level.BEGINNER;
							break;
						case 1:
							level = Level.INTERMEDIATE;
							break;
						case 2:
							level = Level.ADVANCE;
							break;
						}
						System.out.println(internsController.updateByLevel(id, level));
						break;
					case 4:
						System.out.println("Enter id");
						System.out.println(internsController.delete(scanner.nextInt()));
						break;
					case 5:
						exit = false;
						break;

					default:
						System.out.println("Wrong choice, Please try again");
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		}

	}
}
