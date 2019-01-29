package com.accenture.crud.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.accenture.crud.Persistence.StudentPersistence;
import com.accenture.crud.model.Library;

@WebService
public class StudentCrudWS {

	public StudentPersistence persistence = new StudentPersistence();
	@WebMethod
	public List<Library> allStudent(){
		return persistence.fillStudents();
	}
	
	@WebMethod
	public Library findById(@WebParam(name = "id") int id) {
		return persistence.findById(id);
		
	}
	@WebMethod
	public String create(@WebParam(name = "student") Library library) {
		int saveResult = persistence.saveStudent(library);
		String navigationResult ="";
		if(saveResult !=0) {
			navigationResult = "Student was create succeful..!";
		}
		else
			navigationResult = "Student wasnot create..!";
		return navigationResult;
	}
	
	@WebMethod
	public String update(@WebParam(name = "student") Library library) {
		Library studentOld = persistence.findById(library.getId());
		String mensaje ="";
		if(studentOld != null) {
			persistence.updateStudent(library);
			mensaje = "Student was updated..!";
		}
		else
			mensaje = "Student doesn't";
		return mensaje;
	}
	
	@WebMethod
	public String deleteById(@WebParam(name = "id") int id) {
		return persistence.deltedById(id);
		
	}
	
	
}
