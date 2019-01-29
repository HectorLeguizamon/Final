package com.accenture.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.crud.dao.LibraryDAO;
import com.accenture.crud.model.Library;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryDAO libraryDAO;

	@Override
	public void createLibrary(Library library) {
		libraryDAO.createStudent(library);
	}

	@Override
	public Library getLibraryById(int id) {
		return libraryDAO.getStudentById(id);
	}

	@Override
	public List<Library> getLibrary() {
		return libraryDAO.getLibrarys();
	}

	@Override
	public void updateLibrary(Library library) {
		libraryDAO.updateLibrary(library);
	}

	@Override
	public void deleteLibrary(int id) {
		libraryDAO.deleteStudent(id);
	}

}
