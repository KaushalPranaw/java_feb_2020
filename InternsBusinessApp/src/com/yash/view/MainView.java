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
		double marks;
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
						System.out.println("Enter id firstName lastname, age and marks");
						id = scanner.nextInt();
						firstName = scanner.next();
						lastName = scanner.next();
						age = scanner.nextInt();
						marks = scanner.nextDouble();
						level = null;
						if (marks > 75) {
							level = Level.ADVANCE;
						} else {
							if (marks > 65) {
								level = Level.INTERMEDIATE;
							} else {
								level = Level.BEGINNER;
							}
						}

						Intern intern = new Intern(id, firstName, lastName, age, level);
						System.out.println(internsController.insert(intern));
						break;
					case 3:
						System.out.println("Enter id and marks");
						id = scanner.nextInt();
						level = null;
						marks = scanner.nextDouble();
						level = null;
						if (marks > 75) {
							level = Level.ADVANCE;
						} else {
							if (marks > 65) {
								level = Level.INTERMEDIATE;
							} else {
								level = Level.BEGINNER;
							}
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
