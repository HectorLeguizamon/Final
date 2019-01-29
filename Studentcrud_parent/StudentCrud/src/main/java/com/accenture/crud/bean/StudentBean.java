package com.accenture.crud.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.accenture.crud.Persistence.StudentPersistence;
import com.accenture.crud.model.Library;

@ManagedBean(name = "studentBean")
@RequestScoped
public class StudentBean {
	private List<Library> libraries;
	private StudentPersistence persistence;
	
	private String Tnombre;
	private int Tid;
	private int Tvalor;
	private String Tcorreo;
	private String Tpassword;
	private String Tgenero;
	private String Tciudad;

	
	
	
	
	public StudentBean (){
		persistence = new StudentPersistence();

	}
	@PostConstruct
	
	public void init() {
		this.findAllStudents();
		
		
	}
	
	
	
	public void findAllStudents() {
		libraries = persistence.getStudents();
		
	}
	
	public List<Library> getStudents() {
		return libraries;
	}

	public void setStudents(List<Library> libraries) {
		this.libraries = libraries;
	}
	
	public String saveAction() {
	    
		System.out.println("En saveAction: "+Tnombre);
		Library sstudent = new Library();
		for (Library stude : libraries){
			stude.setEditable(false);
		}
		
		sstudent.setName(Tnombre);
		sstudent.setEmployee(Tcorreo);
		sstudent.setLoan_date(Tpassword);
		sstudent.setDeliver_date(Tgenero);
		sstudent.setUser_library(Tciudad);
		
		System.out.println(sstudent.getName());
		persistence.set_edit_Students(sstudent);

		
		return null;
		
	}
	public String devuelve(int ipp) {
		String NN;
		NN = libraries.get(ipp).getName();
		return NN;
	}
	
	public String devuelveemail() {
		String NN;
		NN = libraries.get(Tid).getEmployee();
		return NN;
	}
	
	public void modific() {

		System.out.println("Entra a modificar");
		System.out.println(Tnombre);
		libraries.get(0).setName(Tnombre);
		persistence.fill_set_Students(libraries);
		
	}
	
	
	public void modificar() {

		System.out.println(Tcorreo);
		System.out.println(Tnombre);
		libraries.get(Tid-1).setName(Tnombre);
		libraries.get(Tid-1).setEmployee(Tcorreo);
		libraries.get(Tid-1).setLoan_date(Tpassword);
		libraries.get(Tid-1).setDeliver_date(Tgenero);
		libraries.get(Tid-1).setUser_library(Tciudad);
		persistence.fill_set_Students(libraries);
		
	}
	

	
	public void nuevo() {
		Library NuevStudent = new Library();
		
		System.out.println(Tcorreo);
		System.out.println(Tnombre);
		NuevStudent.setId(Tid);
		NuevStudent.setName(Tnombre);
		NuevStudent.setEmployee(Tcorreo);
		NuevStudent.setLoan_date(Tpassword);
		NuevStudent.setDeliver_date(Tgenero);
		NuevStudent.setUser_library(Tciudad);
		persistence.set_new_Students(NuevStudent);
		
	}
	
	
	public void borrar() {
		Library NuevStudent2 = new Library();
		NuevStudent2.setId(Tid);
		NuevStudent2.setName(Tnombre);
		NuevStudent2.setEmployee(Tcorreo);
		NuevStudent2.setLoan_date(Tpassword);
		NuevStudent2.setDeliver_date(Tgenero);
		NuevStudent2.setUser_library(Tciudad);
		persistence.set_delete_Students(NuevStudent2);
		
	}
	
	public void borrar2(Library NuevStudent2) {
				
		System.out.println(NuevStudent2.getName());
		persistence.set_delete_Students(NuevStudent2);
		
	}
	
	
	public void mostrar() {

		//students.get(Tid).setNombre(Tnombre);
		Tnombre = libraries.get(Tid-1).getName();
		Tcorreo = libraries.get(Tid-1).getEmployee();
		Tpassword = libraries.get(Tid-1).getLoan_date();
		Tgenero = libraries.get(Tid-1).getDeliver_date();
		Tciudad = libraries.get(Tid-1).getUser_library();
		
	}
	
	public void editAction(Library studen) {
	    
		Tid = studen.getId();
		Tnombre = studen.getName();
		Tcorreo = studen.getEmployee();
		Tpassword = studen.getLoan_date();
		Tgenero = studen.getDeliver_date();
		Tciudad = studen.getUser_library();
		studen.setEditable(true);
		System.out.println("Estoy en editAction: "+Tnombre);
		
	}
	public String getTnombre() {
		return Tnombre;
	}
	public void setTnombre(String tnombre) {
		Tnombre = tnombre;
	}
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	public int getTvalor() {
		return Tvalor;
	}
	public void setTvalor(int tvalor) {
		Tvalor = tvalor;
	}
	public String getTcorreo() {
		return Tcorreo;
	}
	public void setTcorreo(String tcorreo) {
		Tcorreo = tcorreo;
	}
	public String getTpassword() {
		return Tpassword;
	}
	public void setTpassword(String tpassword) {
		Tpassword = tpassword;
	}
	public String getTgenero() {
		return Tgenero;
	}
	public void setTgenero(String tgenero) {
		Tgenero = tgenero;
	}
	public String getTciudad() {
		return Tciudad;
	}
	public void setTciudad(String tciudad) {
		Tciudad = tciudad;
	}


	
	
}