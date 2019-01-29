package com.accenture.crud.dao;

import java.util.List;

import com.accenture.crud.model.Library;

public interface LibraryDAO {
	public void createStudent(Library library);
	public Library getStudentById(int id);
	public List<Library> getLibrarys();
	public void updateLibrary(Library library);
	public void deleteStudent(int id);
}
