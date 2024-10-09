package com.project.studentmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {

	//add student
	public void addStudent(Student student) {
		String query="Insert into student(rollno,name,email,percentage) values (?,?,?,?)";
		try(Connection conn=JDBCConnection.getConnection();
			PreparedStatement stmt=conn.prepareStatement(query)){
			stmt.setInt(1, student.getId());
			stmt.setString(2, student.getName());
			stmt.setString(3, student.getEmail());
			stmt.setString(4, student.getPercentage());
			stmt.executeUpdate();
			System.out.println("Student added successfully.......!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//remove student
	public void removeStudent(int rollNo) {
		String query="Delete from student where rollNo=?";
		try(Connection conn=JDBCConnection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(query)){
			stmt.setInt(1, rollNo);
			int deletedRow=stmt.executeUpdate();
			if(deletedRow>0) {
				System.out.println(deletedRow+" student removed successfully...!");
			}else {
				System.err.println("Student not found....");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//search student
	public Student searchStudent(int rollNo) {
		String query="Select * from student where rollNo=?";
		try(Connection conn=JDBCConnection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(query)){
			stmt.setInt(1, rollNo);
			ResultSet resultSet=stmt.executeQuery();
			 if (resultSet.next()) {
	                return new Student(
	                		resultSet.getInt("rollNo"),
	                		resultSet.getString("name"),
	                		resultSet.getString("email"),
	                		resultSet.getString("percentage")
	                );
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//display all students
	public List<Student> displayAllStudent() {
		String query="Select * from student";
		List<Student> studentList=new ArrayList<>();
		try(Connection conn=JDBCConnection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(query)){
			ResultSet resultSet=stmt.executeQuery();
			 while (resultSet.next()) {
	                Student student=new Student(
	                		resultSet.getInt("rollNo"),
	                		resultSet.getString("name"),
	                		resultSet.getString("email"),
	                		resultSet.getString("percentage")
	                );
	                studentList.add(student);
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}
	
	//edit student
	public void editStudent(int rollno,String name,String email,String percentage) {
		String query="Update student set name=? ,email=?,percentage=? where rollno=?";
		try(Connection conn=JDBCConnection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(query)){
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, percentage);
			stmt.setInt(4, rollno);
			
			int updatedRow=stmt.executeUpdate();
			if(updatedRow>0) {
				 System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
