package com.example.u550583114;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentService{

	private List<Student> students; // a list to store Student objects

	public StudentService(){
		students = new ArrayList<>();
		try{
			// read the student.txt file
			File file = new File(getClass().getClassLoader().getResource("student.txt").toURI());
			Scanner scanner = new Scanner(file);
			scanner.nextLine(); // skip the header line in the file
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] parts = line.split(","); // split the line by comma

				// extrcat student information from the line
				int id = Integer.parseInt(parts[0]);
				String firstName = parts[1];
				double gpa = Double.parseDouble(parts[2]);
				String email = parts[3];
				String gender = parts[4];

				// create a new Student object and add it to the list
				students.add(new Student(id, firstName, gpa, email, gender));
			}
			scanner.close();
		}catch(FileNotFoundException | URISyntaxException e){
			System.out.println("Failed to load student data");
			e.printStackTrace();
		}
	}

	public List<Student> findByName(String name){
		List<Student> result = new ArrayList<>();
		for(Student student : students){
			// check if the student's first name matches the given name (case insensitive)
			if(student.getFirstName().equalsIgnoreCase(name)){
				result.add(student);
			}
		}
		return result;
	}

	public List<Student> findByGPA(double gpa){
		List<Student> result = new ArrayList<>();
		for(Student student : students){
			if(student.getGpa() == gpa){
				result.add(student);
			}
		}
		return result;
	}

	public List<Student> findByGender(String gender){
		List<Student> result = new ArrayList<>();
		for(Student student : students){
			// check if the student's gender matches the given gender (case insensitive)
			if(student.getGender().equalsIgnoreCase(gender)){
				result.add(student);
			}
		}
		return result;
	}

	public List<Student> findByGPAAndGender(double gpa, String gender){
		List<Student> result = new ArrayList<>();
		for(Student student : students){
			if(student.getGpa() == gpa && student.getGender().equalsIgnoreCase(gender)){
				result.add(student);
			}
		}
		return result;
	}

	public double calculateAverageGpa(){
		double sum = 0.0;
		for(Student student : students){
			sum += student.getGpa();
		}
		return sum / students.size();
	}
}

