//package com.ats.utility;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//import com.ats.exception.DaoException;
//
//
//
//public class ConnectionFactory {
////	String driver="oracle.jdbc.driver.OracleDriver";
////	String connectionUrl="jdbc:oracle:thin:@localhost:1521:xe";
////	String dbUser="studente";
////	String dbPassword="0000";
//	
//
//
//	private static ConnectionFactory connectionFactory=null;
//	private static ResourceBundle rb = ResourceBundle.getBundle("risorse/info");
//	private static String driver = rb.getString("jdbc.stringDriver");
//	private static String connectionUrl = rb.getString("jdbc.stringConnection");
//	private static String dbUser=rb.getString("jdbc.username");
//	private static String dbPassword=rb.getString("jdbc.password");
//
//
//	private ConnectionFactory()throws DaoException{
//
//		try {
//			//reflection
//			Class.forName(driver);
//		} catch (ClassNotFoundException e) {
//			throw new DaoException();
//		}
//
//
//	}
//
//	public Connection getConnection() throws DaoException{
//		Connection con=null;
//		try {
//			con= DriverManager.getConnection(connectionUrl,dbUser,dbPassword);
//		} catch (SQLException e) {
//			throw new DaoException();
//		}
//		return con;
//	}
//
//	//get instance istanzia automaticamente l'oggetto connectionFactory richiamando 
//	// il costruttore
//	// pattern singleton
//	public static ConnectionFactory getIstance()throws DaoException{
//
//		if(connectionFactory==null){
//			connectionFactory= new ConnectionFactory();
//		}
//
//		return connectionFactory;
//	}
//
//}
