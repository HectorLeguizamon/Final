package com.accenture.crud.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY_")
public class Library {
	@Column(name="ID_LIBRARY")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "NAME_LIBRARY")
	private String name;
	
	@Column(name = "EMPLOYEE")
	private String employee;
	
	@Column(name = "LOAN_DATE")
	private String loan_date;
	
	@Column(name = "DELIVER_DATE")
	private char deliver_date;
	
	@Column(name = "USER_LIBRARY")
	private String user_library;
	
	public Library() {
		super();
	}

	public Library(int id, String name, String employee, String loan_date, char deliver_date, String user_library) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
		this.loan_date = loan_date;
		this.deliver_date = deliver_date;
		this.user_library = user_library;
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

	public char getDeliver_date() {
		return deliver_date;
	}

	public void setDeliver_date(char deliver_date) {
		this.deliver_date = deliver_date;
	}

	public String getUser_library() {
		return user_library;
	}

	public void setUser_library(String user_library) {
		this.user_library = user_library;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", employee=" + employee + ", loan_date=" + loan_date + ", deliver_date="
				+ deliver_date + ", user=" + user_library + "]";
	}
}
