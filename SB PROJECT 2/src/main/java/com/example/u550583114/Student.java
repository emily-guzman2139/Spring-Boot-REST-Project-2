package com.example.u550583114;

public class Student {
	private int id;
	private String firstName;
	private double gpa;
	private String email;
	private String gender;

	public Student(int id, String firstName, double gpa, String email, String gender){
		this.id = id;
		this.firstName = firstName;
		this.gpa = gpa;
		this.email = email;
		this.gender = gender;
	}

	public int getId(){
		return id;
	}

	public String getFirstName(){
		return firstName;
	}

	public double getGpa(){
		return gpa;
	}

	public String getEmail(){
		return email;
	}

	public String getGender(){
		return gender;
	}
}
