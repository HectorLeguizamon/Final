package com.accenture.crud.model;

public class Library {
	
	private int id;
	private String name;
	private String employee;
	private String loan_date;
	private String deliver_date;
	private String user_library;
	boolean editable;
	
	
	public Library() {
		super();
	}

	
	
	public Library(int id, String name, String employee, String loan_date, String deliver_date, String user_library) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
		this.loan_date = loan_date;
		this.deliver_date = deliver_date;
		this.user_library = user_library;
	}
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(String loan_date) {
		this.loan_date = loan_date;
	}

	public String getDeliver_date() {
		return deliver_date;
	}

	public void setDeliver_date(String deliver_date) {
		this.deliver_date = deliver_date;
	}

	public String getUser_library() {
		return user_library;
	}

	public void setUser_library(String user_library) {
		this.user_library = user_library;
	}
	



}
