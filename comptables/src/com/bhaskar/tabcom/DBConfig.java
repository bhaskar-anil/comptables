package com.bhaskar.tabcom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConfig {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/groceries";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "password";
	   
	   public Connection getConnection() {
	   Connection conn = null;


	      //STEP 2: Register JDBC driver
	      try {
			Class.forName("com.mysql.jdbc.Driver");
		      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	  
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   return conn;
	}//end main
}
