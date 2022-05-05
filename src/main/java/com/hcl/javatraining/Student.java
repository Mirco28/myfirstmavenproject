package com.hcl.javatraining;



public class Student{
	private int studentID;
	private String name;
	private int age;
	
	public Student(int studentID, String name, int age) {
		this.studentID = studentID;
		this.name = name;
		this.age = age;
	}
	public int getStudentID() {
		return studentID;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	@Override
	public int hashCode() {
		return this.studentID;
	}
	@Override
	public boolean equals(Object obj) {
	
		Student s = (Student) obj;
		
		return s.studentID == studentID;
	}
	@Override
	public String toString() {
		return "studentID =" + studentID + ", name =" + name + ", age =" + age + "";
	}
	
}


