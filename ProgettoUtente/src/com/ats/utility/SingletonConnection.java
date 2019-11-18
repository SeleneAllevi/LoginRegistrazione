package com.ats.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//import exceptions.ConnessioneException;
import java.util.ResourceBundle;
import com.ats.exception.DaoException;



public class SingletonConnection {
	private static SingletonConnection scones;
	private static Connection conn;
	private static ResourceBundle rb = ResourceBundle.getBundle("risorse/info");
	private static String stringDriver = rb.getString("jdbc.stringDriver");
	private static String stringConnection = rb.getString("jdbc.stringConnection");
	private static String idConnection=rb.getString("jdbc.username");
	private static String passConnection=rb.getString("jdbc.password");
	
	
	private SingletonConnection() throws DaoException{
		try {
			
			Class.forName(stringDriver);
		} catch (ClassNotFoundException e) {
			throw new DaoException();
		}
	}
	public static Connection getConnection() throws DaoException {
		try {
			conn = DriverManager.getConnection(stringConnection,idConnection,passConnection);
		} catch (Exception e) {
			throw new DaoException();
		}
		return conn;
	}
	
	public static SingletonConnection getInstance()throws DaoException{
		if(scones==null)
			scones=new SingletonConnection();
		
		return scones; 
	}

}
