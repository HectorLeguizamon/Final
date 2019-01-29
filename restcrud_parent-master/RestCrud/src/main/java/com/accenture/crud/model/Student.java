package com.accenture.crud.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY_")
public class Student {
	@Column(name="ID_LIBRARY")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "NAME_LIBRARY")
	private String name;
	
	@Column(name = "EMPLOYEE")
	private String employee;
	
	@Column(name = "LOAN_DATE")
	private String password;
	
	@Column(name = "DELIVER_DATE")
	private char gender;
	
	@Column(name = "USER_LIBRARY")
	private String aess;
	
	public Student() {
		super();
	}

	public Student(int id, String name, String employee, String password, char gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
		this.password = password;
		this.gender = gender;
		this.aess = address;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return aess;
	}

	public void setAddress(String address) {
		this.aess = address;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", employee=" + employee + ", loan_date=" + password + ", deliver_date="
				+ gender + ", user=" + aess + "]";
	}
}