package com.accenture.crud.Persistence;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Segment;

import javax.naming.spi.DirStateFactory.Result;

import com.accenture.crud.model.Library;


public class StudentPersistence {

	private List<Library> libraries;
	
	public Statement stmtObj;
	public Connection connObj; ;
	public ResultSet resultSetObj;
	public PreparedStatement pstmt;
	
	
	/*	public Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String db_url = "jdbc:mariadb://localhost:3306/students",
					db_userName = "root",
					db_password = "1234";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);
			} catch(Exception sqlException) {
				sqlException.printStackTrace();
			}
		return connObj;
	} */
	
		public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:XE",
					db_userName = "practicas",
					db_password = "1234";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);
			} catch(Exception sqlException) {
				sqlException.printStackTrace();
			}
		return connObj;
	}
	
	public StudentPersistence() {
		super();
		libraries = new ArrayList<Library>();
		this.libraries = this.fillStudents();
	}
	
	public void addStudent(Library library) {
		this.libraries.add(library);
	}
	
	public List<Library> fillStudents() {
		List<Library> studentList = new ArrayList<Library>();
		String sql = "select * from student_record";
		try {
			stmtObj = getConnection().createStatement();
			resultSetObj = stmtObj.executeQuery(sql);
			while(resultSetObj.next()) {
				Library library = new Library();
				library.setId(resultSetObj.getInt("student_id"));
				library.setName(resultSetObj.getString("student_name"));
				library.setEmployee(resultSetObj.getString("student_email"));
				library.setLoan_date(resultSetObj.getString("student_password"));
				library.setEmployee(resultSetObj.getString("student_email"));
				library.setDeliver_date(resultSetObj.getString("student_gender"));
				library.setUser_library(resultSetObj.getString("student_address"));
				studentList.add(library);
			}
			System.out.println("Total de estudiantes: " + studentList.size());
			connObj.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentList;
	}
	
	
	public void fill_set_Students(List<Library> studee) {
		//String sql = "UPDATE student_record SET student_name = ? WHERE student_id = ?";

		for(Library au: studee)
		{
		
		try {
	//		stmtObj = getConnection().createStatement();
//			resultSetObj = stmtObj.executeQuery(sql);
//			while(resultSetObj.next()) {
			PreparedStatement pstmt = getConnection().prepareStatement("UPDATE student_record SET student_name = ? WHERE student_id = ?");
            pstmt.setString(1, au.getName());
            pstmt.setInt(2, au.getId());
            pstmt.executeUpdate();
			
				PreparedStatement pstmt2 = getConnection().prepareStatement("UPDATE student_record SET student_email = ? WHERE student_id = ?");
                pstmt2.setString(1, au.getEmployee());
                pstmt2.setInt(2, au.getId());
                pstmt2.executeUpdate();
                
                PreparedStatement pstmt3 = getConnection().prepareStatement("UPDATE student_record SET student_password = ? WHERE student_id = ?");
                pstmt3.setString(1, au.getLoan_date());
                pstmt3.setInt(2, au.getId());
                pstmt3.executeUpdate();
                
                PreparedStatement pstmt4 = getConnection().prepareStatement("UPDATE student_record SET student_gender = ? WHERE student_id = ?");
                pstmt4.setString(1, au.getDeliver_date());
                pstmt4.setInt(2, au.getId());
                pstmt4.executeUpdate();
                
                PreparedStatement pstmt5 = getConnection().prepareStatement("UPDATE student_record SET student_address = ? WHERE student_id = ?");
                pstmt5.setString(1, au.getUser_library());
                pstmt5.setInt(2, au.getId());
                pstmt5.executeUpdate();
//			}
			System.out.println("Se cambio el nombre: ");
			connObj.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
		
	}
	
	
	
	
	public void set_new_Students(Library au) {
		//String sql = "UPDATE student_record SET student_name = ? WHERE student_id = ?";


		
		try {
	//		stmtObj = getConnection().createStatement();
//			resultSetObj = stmtObj.executeQuery(sql);
//			while(resultSetObj.next()) {
			
			PreparedStatement pstmt5 = getConnection().prepareStatement("INSERT INTO student_record VALUES (?,?,?,?,?,?)");
			pstmt5.setInt(1, au.getId());
			pstmt5.setString(2, au.getName());
            pstmt5.setString(3, au.getEmployee());
            pstmt5.setString(4, au.getLoan_date());
            pstmt5.setString(5, au.getDeliver_date());
            pstmt5.setString(6, au.getUser_library());
            pstmt5.executeUpdate();
			
			
//			}
			System.out.println("Se cambio el nombre: ");
			connObj.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public void set_delete_Students(Library au) {
		//String sql = "UPDATE student_record SET student_name = ? WHERE student_id = ?";


		
		try {
	//		stmtObj = getConnection().createStatement();
//			resultSetObj = stmtObj.executeQuery(sql);
//			while(resultSetObj.next()) {
			System.out.println(au.getId());
			PreparedStatement pstmt6 = getConnection().prepareStatement("DELETE FROM student_record WHERE student_id = ?");
			pstmt6.setInt(1, au.getId());
            pstmt6.executeUpdate();
			
			
//			}
			System.out.println("Se elimino ");
			connObj.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public List<Library> getStudents() {
		
		return this.libraries;
		
	}
	
public void setStudents(List<Library> sttuu) {
		
		
		this.libraries = sttuu;
		
	}

public void set_edit_Students(Library au) {
	//String sql = "UPDATE student_record SET student_name = ? WHERE student_id = ?";


	
	try {
//		stmtObj = getConnection().createStatement();
//		resultSetObj = stmtObj.executeQuery(sql);
//		while(resultSetObj.next()) {
		PreparedStatement pstmt = getConnection().prepareStatement("UPDATE student_record SET student_name = ? WHERE student_id = ?");
        pstmt.setString(1, au.getName());
        pstmt.setInt(2, au.getId());
        pstmt.executeUpdate();
		
			PreparedStatement pstmt2 = getConnection().prepareStatement("UPDATE student_record SET student_email = ? WHERE student_id = ?");
            pstmt2.setString(1, au.getEmployee());
            pstmt2.setInt(2, au.getId());
            pstmt2.executeUpdate();
            
            PreparedStatement pstmt3 = getConnection().prepareStatement("UPDATE student_record SET student_password = ? WHERE student_id = ?");
            pstmt3.setString(1, au.getLoan_date());
            pstmt3.setInt(2, au.getId());
            pstmt3.executeUpdate();
            
            PreparedStatement pstmt4 = getConnection().prepareStatement("UPDATE student_record SET student_gender = ? WHERE student_id = ?");
            pstmt4.setString(1, au.getDeliver_date());
            pstmt4.setInt(2, au.getId());
            pstmt4.executeUpdate();
            
            PreparedStatement pstmt5 = getConnection().prepareStatement("UPDATE student_record SET student_address = ? WHERE student_id = ?");
            pstmt5.setString(1, au.getUser_library());
            pstmt5.setInt(2, au.getId());
            pstmt5.executeUpdate();
		
//		}
		System.out.println("Se actualizo: ");
		connObj.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
}


public Library findById(int id) {
	Library library = new Library();
	String sql = "select * from student_record where student_id = ?";
	try {
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		resultSetObj = pstmt.executeQuery();
		while(resultSetObj.next()) {
			
			library.setId(resultSetObj.getInt("student_id"));
			library.setName(resultSetObj.getString("student_name"));
			library.setEmployee(resultSetObj.getString("student_email"));
			library.setLoan_date(resultSetObj.getString("student_password"));
			library.setEmployee(resultSetObj.getString("student_email"));
			library.setDeliver_date(resultSetObj.getString("student_gender"));
			library.setUser_library(resultSetObj.getString("student_address"));
			
		}
		connObj.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return library;
}

public int saveStudent(Library library) {
	int saveResult = 0;

	String sql = "INSERT INTO student_record VALUES (?,?,?,?,?,?)";
	try {
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, library.getId());
		pstmt.setString(2, library.getName());
        pstmt.setString(3, library.getEmployee());
        pstmt.setString(4, library.getLoan_date());
        pstmt.setString(5, library.getDeliver_date());
        pstmt.setString(6, library.getUser_library());
        saveResult = pstmt.executeUpdate();
		connObj.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return saveResult;
}

public String updateStudent(Library updateStudentObj) {
	

	String sql = "UPDATE student_record SET student_name = ?, student_email = ?, student_password = ?, student_gender = ?, student_address = ?  WHERE student_id = ?";
	try {
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, updateStudentObj.getName());
        pstmt.setString(2, updateStudentObj.getEmployee());
        pstmt.setString(3, updateStudentObj.getLoan_date());
        pstmt.setString(4, updateStudentObj.getDeliver_date());
        pstmt.setString(5, updateStudentObj.getUser_library());
        pstmt.setInt(6, updateStudentObj.getId());
        pstmt.executeUpdate();
		connObj.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "/students.xhtml?faces-redirect=true";
}

public String deltedById(int id) {
	String sql = "DELETE FROM student_record WHERE student_id = ?";
	try {
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
        pstmt.executeUpdate();
		connObj.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "/students.xhtml?faces-redirect=true";
}
	
}
