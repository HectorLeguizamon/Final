package com.accenture.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.crud.model.Library;

@Repository
public class LibraryDAOImpl implements LibraryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createStudent(Library library) {
		getCurrentSession().save(library);
	}

	@Override
	public Library getStudentById(int id) {
		return (Library) getCurrentSession().get(Library.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Library> getLibrarys() {
		return getCurrentSession().createQuery("from Student").list();
	}

	@Override
	public void updateLibrary(Library library) {
		Library studentToUpdate = getStudentById(library.getId());
		if (studentToUpdate != null)
			getCurrentSession().merge(library);

	}

	@Override
	public void deleteStudent(int id) {
		Library library = getStudentById(id);
			if (library != null)
				getCurrentSession().delete(library);
	}

}