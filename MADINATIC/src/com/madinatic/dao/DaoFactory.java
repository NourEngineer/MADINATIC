package com.madinatic.dao;
import java.sql.*;

public class DaoFactory {
	private static String username = "root";
	private static String password = "t;forever33";
	private static String data_base_name = "Madinatic";
	private static String url = "jdbc:mysql://localhost:3306/" + data_base_name;
	
	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) { e.getMessage();}
		DaoFactory instance = new DaoFactory(url,username,password);
		return instance;
	}
	
	DaoFactory(String url,String username,String password) {
		DaoFactory.url = url;
		DaoFactory.Set(username,password);
	}
	
	public static void Set(String username,String password) {
		DaoFactory.username = username;
		DaoFactory.password = password;
	}
	
	public  Connection getConnection() throws SQLException {
		try {
		 return DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			System.out.println("Failed Connection DB: "+ data_base_name);
			return null;
		}
	}
	
	public SupervisorDAO getSupervisorDAO() {
		try {
		return new SupervisorDAO(this.getConnection());
		}catch(Exception e ) {
			e.getMessage();
			System.out.println("j'ai pas peu sup dao");
			return null;
		}
	}
	public ServiceDAO getServiceDAO() {
		try {
		return new ServiceDAO(this.getConnection());
		}catch(Exception e ) {
			e.getMessage();
			System.out.println("j'ai pas peu ser dao");
			return null;
		}
	}
	
}
