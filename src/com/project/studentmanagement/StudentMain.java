package com.project.studentmanagement;

import java.util.List;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		
		 Scanner sc=new Scanner(System.in);
		 StudentManagementSystem sms=new StudentManagementSystem();

		while(true) {
			System.out.println(".....Student Management System.....");
			System.out.println("1. Add Student");
			System.out.println("2. Remove Student");
			System.out.println("3. Search Student");
			System.out.println("4. Display all Students");
			System.out.println("5. Edit Student");
			System.out.println("6. Exit");
			
			System.out.println("Enter choice: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enetr roll no: ");
				int rollNo=sc.nextInt();
				System.out.println("Enter name: ");
				String name=sc.next();
				System.out.println("Enter email: ");
				String email=sc.next();
				System.out.println("Enter percentage: ");
				String percentage=sc.next();
				Student student=new Student(rollNo, name, email, percentage);
				sms.addStudent(student);
				break;
			
			case 2:
				System.out.println("Enter roll no: ");
				int rollno=sc.nextInt();
				sms.removeStudent(rollno);
				break;
				
			case 3:
				System.out.println("Enter rollno to search student: ");
				int roll_no=sc.nextInt();
				Student stud=sms.searchStudent(roll_no);
				if(stud!=null) {
					System.out.println("Student found: "+stud);
				}else {
					System.err.println("Student not found....");
				}
				break;
				
			case 4:
				List<Student> studentList=sms.displayAllStudent();
				if(studentList.isEmpty()) {
					System.err.println("Students not found...");
				}else {
					for(Student s:studentList) {
						System.out.println(s);
					}
				}
				break;
				
			case 5:
				System.out.println("Entwer roll no to edit details: ");
				int rollNum=sc.nextInt();
				System.out.println("Enter new name: ");
				String studName=sc.next();
				System.out.println("Enter new email: ");
				String studEmail=sc.next();
				System.out.println("Enter new percentage: ");
				String studPer=sc.next();
				sms.editStudent(rollNum, studName, studEmail, studPer);
				break;
				
			case 6:
				System.out.println("Exit from Student Management System...");
				System.exit(0);
			
			default:
				System.err.println("Wrong choice...");
			}
			
			 	
		}
	}

}
