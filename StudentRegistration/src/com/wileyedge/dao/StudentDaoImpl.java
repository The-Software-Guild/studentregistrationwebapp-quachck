package com.wileyedge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wileyedge.model.Student;

public class StudentDaoImpl implements StudentDao {

	private String dbUrl;
	private String dbUser;
	private String dbPassword;

	public StudentDaoImpl(String dbUrl, String dbUser, String dbPassword) {
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
	}

	@Override
	public void saveStudent(Student student) throws Exception {
		Connection connection = null;
		try {
			connection = openConnection();
			String sql = "INSERT INTO student (name, age, mobile, address) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
			statement.setInt(3, student.getMobile());
			statement.setString(4, student.getAddress());
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Successfully added student");
			}
		} catch (SQLException e) {
			System.out.println("An error occurred while inserting student into the database");
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	private Connection openConnection() throws Exception {
		// register for type 4 drive(pure java)
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // type 4 driver is registered with DriverManager
			System.out.println("Successfully registered MySQL driver with DriverManager");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("Successfully connected to: " + connection);
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL suitable driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
