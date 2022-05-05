package com.hcl.javatraining;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StudentDriver {
	private static final Set<Student> studentSet = new TreeSet<>();

	public static void main(String[] args) {
		char choice = '\0';

		Scanner input = new Scanner(System.in);

		studentSet.add(new Student(1, "Nicolas", 24));
		studentSet.add(new Student(3, "Sebastian", 26));
		studentSet.add(new Student(4, "Diego", 24));
		studentSet.add(new Student(5, "Fernando", 40));
		studentSet.add(new Student(6, "Rodrigo", 45));

		do {
			System.out.println("Enter number from 1 to 5");
			int number = input.nextInt();
			switch (number) {
			case 1:
				addStudent(input);
				break;
			case 2:
				lookUpStudentById(input);
				break;
			case 3:
				updateStudentById(input);
				break;
			case 4:
				deleteStudentById(input);
				break;
			case 5:
				printStudentList();
				break;
			}

			System.out.println("Do you want to continue yes (Y) or No (N)");
			choice = input.next().charAt(0);

		} while (choice == 'Y' || choice == 'y');
	}

	static void addStudent(Scanner scanner) {

		System.out.println("Enter Student ID");
		int studentId = scanner.nextInt();

		System.out.println("Enter student name");
		String name = scanner.next();

		System.out.println("Enter Student Age");
		int age = scanner.nextInt();

		studentSet.add(new Student(studentId, name, age));
	}

	static boolean lookUpStudentById(Scanner scanner) {
		System.out.println("Enter Student ID");
		int studentId = scanner.nextInt(); 

		for (Student s : studentSet) {
			if (s.getStudentID() == studentId) {
				System.out.println("Student id = " + s.getStudentID() + " student name = " + s.getName()
						+ " student age = " + s.getAge());
				return true;
			}
		}

		System.out.println("Student not found ");
		return false;
	}

	static void updateStudentById(Scanner scanner) {
		System.out.println("Enter Student ID");
		int studentId = scanner.nextInt();

		for (Student s : studentSet) {
			if (s.getStudentID() == studentId) {
				studentSet.remove(s);
				
				System.out.println("Enter updated studentId");
				studentId = scanner.nextInt();
				
				System.out.println("Enter updated student name");
				String name = scanner.next();

				System.out.println("Enter updated Student Age");
				int age = scanner.nextInt();

				studentSet.add(new Student(studentId, name, age));
				break;
			}
		}

	}

	static void deleteStudentById(Scanner scanner) {
		System.out.println("Enter Student ID");
		int studentId = scanner.nextInt();

		for (Student s : studentSet) {
			if (s.getStudentID() == studentId) {
				studentSet.remove(s);
			}
		}

	}

	static void printStudentList() {

		for (Student s : studentSet) {
			System.out.println(s);
		}
	}
}
