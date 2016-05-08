package org.akhila.cloudservices.rest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	
	public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Connection connection =  null;
		
		// Store the database URL in a string
		String url = "jdbc:mysql://cloudservice.csa2yphklgn8.us-east-1.rds.amazonaws.com:3306/classicmodels"; 
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		// set the url, username and password for the databse 
		connection = DriverManager.getConnection(url,"root","cloud007");   
		return connection;
		
	}
}
