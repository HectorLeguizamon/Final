package com.accenture.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.crud.model.Student;
import com.accenture.crud.service.StudentService;

@RestController
@CrossOrigin(origins="*")
//@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	public StudentService studentService;
	
	@RequestMapping(value="/students/", method= RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> getStudents = studentService.getStudents();
		if(getStudents.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(getStudents,HttpStatus.OK);
	}
	
}
