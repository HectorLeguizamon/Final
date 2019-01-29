package com.accenture.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {

		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@PathVariable int id) {

		studentService.deleteStudent(id);
		return new ResponseEntity(HttpStatus.OK);

	}
	/*
	@RequestMapping(value = "/{id}+{name}+{email}+{password}+{gender}+{address}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudent(@PathVariable int id,@PathVariable String name,@PathVariable String email,@PathVariable String password,@PathVariable char gender,@PathVariable String address) {
		
		Student student = studentService.getStudentById(id);
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		student.setGender(gender);
		student.setAddress(address);
		
		studentService.updateStudent(student);
		return new ResponseEntity<String>(id+" , "+name+" "+email+" "+password+" "+gender+" "+address,HttpStatus.OK);

	}
	*/
	@RequestMapping(value = "/{id}+{name}+{email}+{password}+{gender}+{address}", method = RequestMethod.HEAD)
	public ResponseEntity<String> createStudent(@PathVariable int id,@PathVariable String name,@PathVariable String email,@PathVariable String password,@PathVariable char gender,@PathVariable String address) {
		
		//Student student = studentService.getStudentById(id);
		//student.setName(name);
		//student.setEmail(email);
		//student.setPassword(password);
		//student.setGender(gender);
		//student.setAddress(address);
		
		//studentService.updateStudent(student);
		Student stu = new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setEmployee(email);
		stu.setPassword(password);
		stu.setGender(gender);
		stu.setAddress(address);
		studentService.createStudent(stu);
		
		return new ResponseEntity<String>(id+" , "+name+" "+email+" "+password+" "+gender+" "+address,HttpStatus.OK);

	}
	
}
