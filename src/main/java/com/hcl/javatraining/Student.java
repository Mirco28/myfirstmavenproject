package com.hcl.javatraining;

public class Student implements Comparable<Student>{
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


	public void setStudentID(int studentID) {
		this.studentID = studentID;
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
	public String toString() {
		return "studentID =" + studentID + ", name =" + name + ", age =" + age + "";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
	
		return name.compareTo(o.name);
	}
	
	
	
	
}


