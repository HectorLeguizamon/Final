package com.accenture.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.crud.dao.StudentDAO;
import com.accenture.crud.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void createStudent(Student student) {
		studentDAO.createStudent(student);
	}

	@Override
	public Student getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	@Override
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);
	}

}
