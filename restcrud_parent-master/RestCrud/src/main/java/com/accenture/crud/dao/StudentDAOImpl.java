package com.accenture.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.crud.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createStudent(Student student) {
		getCurrentSession().save(student);
	}

	@Override
	public Student getStudentById(int id) {
		return (Student) getCurrentSession().get(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() {
		return getCurrentSession().createQuery("from Student").list();
	}

	@Override
	public void updateStudent(Student student) {
		Student studentToUpdate = getStudentById(student.getId());
		if (studentToUpdate != null)
			getCurrentSession().merge(student);

	}

	@Override
	public void deleteStudent(int id) {
		Student student = getStudentById(id);
			if (student != null)
				getCurrentSession().delete(student);
	}

}
