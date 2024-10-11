

# Student Management System

This project is a **console-based Student Management System** built using **Java** and **JDBC** to interact with a **MySQL** database. The system allows users to perform CRUD (Create, Read, Update, Delete) operations on student records. The project includes features like adding new students, editing existing students, removing students, searching for students, and displaying all students.

## Features

- **Add Student**: Add a new student record to the database.
- **Edit Student**: Modify existing student details.
- **Remove Student**: Delete a student record from the database.
- **Search Student**: Find a student by roll number.
- **Display All Students**: List all student records in the database.

## Prerequisites

### 1. Software Requirements
- **Java Development Kit (JDK)**: Version 8 or higher.
- **MySQL**: Version 5.x or higher.
- **MySQL JDBC Driver**: MySQL Connector/J (downloadable from the [MySQL official website](https://dev.mysql.com/downloads/connector/j/)).

### 2. MySQL Database Setup
Before running the project, make sure to set up the MySQL database:

```sql
CREATE DATABASE StudentDB;

USE StudentDB;

CREATE TABLE Students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    rollNumber INT UNIQUE NOT NULL,
    grade VARCHAR(10) NOT NULL
);
```

### 3. JDBC Setup
Make sure the **MySQL JDBC driver** is included in your project's classpath. If you're using Maven, include the following dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.x</version>
</dependency>
```

## Installation and Running the Project

### 1. Clone the repository
Clone the repository to your local machine using the following command:
```bash
git clone https://github.com/your-repo/student-management-system.git
```

### 2. Configure the Database Connection
Update the `DatabaseConnection` class to match your MySQL configuration:

```java
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/StudentDB";
    private static final String USER = "root";
    private static final String PASSWORD = "yourpassword";
}
```

Replace `yourpassword` with your MySQL root user password or another user's credentials.

### 3. Compile and Run the Project
1. Compile the Java files using the following command:
```bash
javac *.java
```

2. Run the main program:
```bash
java Main
```

Alternatively, if you are using an IDE like IntelliJ IDEA or Eclipse:
- Open the project in your IDE.
- Compile and run the `Main` class directly from the IDE.

## Usage
After running the program, you will be presented with a console menu to interact with the Student Management System:

```
Student Management System
1. Add Student
2. Edit Student
3. Remove Student
4. Search Student
5. Display All Students
6. Exit
Enter your choice: 
```

- Select an option by entering the corresponding number.
- Follow the prompts to perform operations like adding, searching, and modifying students.

### Example
To **add a new student**:
1. Select option `1`.
2. Enter the student's name, roll number, and grade when prompted.

To **search for a student**:
1. Select option `4`.
2. Enter the roll number of the student you want to search for.

## Input Validation
- The program ensures that **required fields** (name and grade) are not left empty.
- The **roll number** is validated to be unique when adding or editing a student.

## Project Structure

```
src/
│
├── DatabaseConnection.java   # Manages the database connection.
├── Student.java              # Represents the Student entity.
├── StudentManagementSystem.java # Handles CRUD operations on students.
└── Main.java                 # Entry point with console-based UI.
```
