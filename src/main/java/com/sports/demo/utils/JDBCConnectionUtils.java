package com.sports.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionUtils {
	private static   Connection connection ;
	
	public static Connection getConnection(){
		return connection;
		
	}
	
	public static void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fxlogin?useSSL=false", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(){
		if (null !=connection){
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		}
	}
	
	
}
