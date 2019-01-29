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

import com.accenture.crud.model.Library;
import com.accenture.crud.service.LibraryService;

@RestController
@CrossOrigin(origins="*")
//@RequestMapping(value="/student")
public class LibraryController {
	@Autowired
	public LibraryService libraryService;
	
	@RequestMapping(value="/students/", method= RequestMethod.GET)
	public ResponseEntity<List<Library>> getStudents(){
		List<Library> getStudents = libraryService.getLibrary();
		if(getStudents.isEmpty()) {
			return new ResponseEntity<List<Library>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Library>>(getStudents,HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Library> getStudentById(@PathVariable int id) {

		Library library = libraryService.getLibraryById(id);
		return new ResponseEntity<Library>(library,HttpStatus.OK);

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@PathVariable int id) {

		libraryService.deleteLibrary(id);
		return new ResponseEntity(HttpStatus.OK);

	}
	
	@RequestMapping(value = "/{id}+{name}+{employee}+{loan_date}+{deliver_date}+{user_library}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudent(@PathVariable int id,@PathVariable String name,@PathVariable String employee,@PathVariable String loan_date,@PathVariable char deliver_date,@PathVariable String user_library) {
		
		Library library = libraryService.getLibraryById(id);
		library.setName(name);
		library.setEmployee(employee);
		library.setLoan_date(loan_date);
		library.setDeliver_date(deliver_date);
		library.setUser_library(user_library);
		
		libraryService.updateLibrary(library);
		return new ResponseEntity<String>(id+" , "+name+" "+employee+" "+loan_date+" "+deliver_date+" "+user_library,HttpStatus.OK);

	}
	/*
	@RequestMapping(value = "/{id}+{name}+{email}+{password}+{gender}+{address}", method = RequestMethod.HEAD)
	public ResponseEntity<String> createStudent(@PathVariable int id,@PathVariable String name,@PathVariable String email,@PathVariable String password,@PathVariable char gender,@PathVariable String address) {
		

		Student stu = new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setEmployee(email);
		stu.setPassword(password);
		stu.setGender(gender);
		stu.setAddress(address);
		studentService.createStudent(stu);
		
		return new ResponseEntity<String>(id+" , "+name+" "+email+" "+password+" "+gender+" "+address,HttpStatus.OK);

	} */
	
}
