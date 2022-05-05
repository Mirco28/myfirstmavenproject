package com.hcl.javatraining;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class StudentDriver {
	private static final Set<Student> studentSet = new TreeSet<>((o1,o2)->{
		if(o1.getName().compareTo(o2.getName()) == 0) {
			return o1.getAge() - o2.getAge();
		}
		return o1.getName().compareTo(o2.getName());
	});

	public static void main(String[] args) throws IOException {

		
		readFile();
		
		char choice = '\0';

		Scanner input = new Scanner(System.in);

		studentSet.add(new Student(1, "Nicolas", 24));
		studentSet.add(new Student(3, "Sebastian", 26));
		studentSet.add(new Student(4, "Diego", 24));
		studentSet.add(new Student(5, "Fernando", 40));
		studentSet.add(new Student(6, "Rodrigo", 45));
		
		

		do {
			printChoices();
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
			default:
				System.out.println("Choice is invalid please try again");
			}

			System.out.println("Do you want to continue yes (Y) or No (N)");
			choice = input.next().charAt(0);

		} while (choice == 'Y' || choice == 'y');
		writeToFile();
		
	}

	private static void readFile() throws IOException, FileNotFoundException {
		String line;
		try(FileReader readFile = new FileReader("StudentInfo.txt"); 
				BufferedReader br = new BufferedReader(readFile)){
			System.out.println("Currently in file");
			while((line = br.readLine()) != null) {
				
				System.out.println(line);
				
			}
			System.out.println();
		}
	}

	private static void writeToFile() throws IOException {
		try(FileWriter fileWrite = new FileWriter("StudentInfo.txt");){
			for(Student s : studentSet) {
				fileWrite.write("Student id = "+s.getStudentID() + ", Student name = " + s.getName() + ", Student Age = " + s.getAge() + "\n");
			}
		}
	}
	
	static void printChoices() {
		System.out.println("Choose 1 to add a student");
		System.out.println("Choose 2 to look up student by id");
		System.out.println("Choose 3 to update student by id");
		System.out.println("Choose 4 to delete student by id");
		System.out.println("Choose 5 to print student list");
		System.out.print("Enter your choise: ");
	}

	static boolean addStudent(Scanner scanner) throws IOException {
		String fileName = "StudentInfo.txt";
		System.out.println("Enter Student ID");
		int studentId = scanner.nextInt();

		System.out.println("Enter student name");
		String name = scanner.next();

		System.out.println("Enter Student Age");
		int age = scanner.nextInt();
		
		Student student = checkIfStudentExists(studentId);

		if(student != null) {
			System.out.printf("Student %s with idNumber %d already exists ", student.getName(), student.getStudentID());
			System.out.println();
			return false;
		}
		
		Student newStudent = new Student(studentId,name, age);
		studentSet.add(newStudent);
		
		try(FileWriter fileWrite = new FileWriter(fileName, true);){
				fileWrite.write("Student id = "+ newStudent.getStudentID() + ", Student name = " + 
						newStudent.getName() + ", Student Age = " + newStudent.getAge() + "\n");
			}
		
		return true;
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
		System.out.println("Enter Student ID of student you want to update");
		int studentId = scanner.nextInt();
		
		Student student = checkIfStudentExists(studentId);
		
		if(student != null) {
			System.out.printf("Student with id number %d found, current name is %s"
					+ "and age is %d\n", student.getStudentID(), student.getName(), student.getAge());
			
			System.out.println("Please enter a new name");
			student.setName(scanner.next());
			System.out.println("Please enter a new age");
			student.setAge(scanner.nextInt());
			
			System.out.println("Succesfully added student");
		}
		}

	

	static boolean deleteStudentById(Scanner scanner) {
		System.out.println("Enter Student ID");
		int studentId = scanner.nextInt();

		for (Student s : studentSet) {
			if (s.getStudentID() == studentId) {
				studentSet.remove(s);
				System.out.println("Student succesfully removed");
				return true;
			}
		}
		System.out.println("Student with that id does not exist");
		return false;

	}

	static void printStudentList() {

		for (Student s : studentSet) {
			System.out.println(s);
		}
	}
	
	private static Student checkIfStudentExists(int studentId) {
		for(Student student : studentSet) {
			if(student.getStudentID() == studentId) {
				return student;
			}
		}
		return null;
	}
}
