package com.example.u550583114;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
		return ResponseEntity.ok(studentService.findByName(name));
	}

	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudentsByGpa(
		@RequestParam(required = false) Double gpa,
		@RequestParam(required = false) String gender
	) {
		if(gpa != null && gender != null){
			// both gpa and gender are provided
			return ResponseEntity.ok(studentService.findByGPAAndGender(gpa, gender));
		}
		if(gpa != null && gender == null){
			// only gpa is provided
			return ResponseEntity.ok(studentService.findByGPA(gpa));
		}
		if(gpa == null && gender != null){
			// only gender is provided
			return ResponseEntity.ok(studentService.findByGender(gender));
		}
		return ResponseEntity.badRequest().build(); // neither is provided
	}

	@GetMapping("/gpa")
	public ResponseEntity<Double> getAverageGpa() {
		return ResponseEntity.ok(studentService.calculateAverageGpa());
	}
}

