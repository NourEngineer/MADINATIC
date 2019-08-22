package com.madinatic.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;

import java.sql.Statement;

public class VerificationDAO {
	
	private static Connection connection ;

	public VerificationDAO() throws SQLException {
		super();
		VerificationDAO.setConnection(initConnectionVerificationDAO()) ;
 	}

	public static Connection initConnectionVerificationDAO() throws SQLException {
		
		try { Class.forName("com.mysql.jdbc.Driver");}
		catch(ClassNotFoundException e) {}
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/People","root","t;forever33");
		System.out.println("connectioncree !!");
		return connection;
	}
	
	public boolean VerifyIdCard(int id) throws SQLException {
		boolean result = false ;
		//Connection connection = initConnectionVerificationDAO();
		System.out.println("verification comanc� !!");

		Statement state = (Statement) getConnection().createStatement();
		ResultSet resultSet = state.executeQuery("select * from People where id_card ="+id);
		if(resultSet.first()) result = true;
		System.out.println("verification termin�   !!   le resultat est : "+ result);

		return result;
	}
	
	public boolean VerifyInfo(int id_card , String name , String first_name) throws SQLException {
		boolean result = false ;
		
		if(VerifyIdCard(id_card) ) {
			//Connection connection = initConnectionVerificationDAO();
		    Statement statement = (Statement) getConnection().createStatement();
		    System.out.println("//////Verificatiiiion");
			ResultSet resultSet = statement.executeQuery("select name_ , first_name from People where id_card ="+id_card+";");
			
			//if( (name.equals(resultSet.getString(name).toString())) && (first_name.equals(resultSet.getString(first_name).toString()) )) result=true ;
			if(resultSet.first()) {
			
			Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
			System.out.println( resultSet.getString("name_") );
			int comparaison_name = comparator.compare(name, resultSet.getString("name_") );
			System.out.println("//////Verificatiiiion");
			System.out.println(first_name+"   ");
			int comparaison_firstname = comparator.compare(first_name, resultSet.getString("first_name").toString());
			if(comparaison_name == 0 && comparaison_firstname == 0)  result = true ; 
			}
			
			System.out.println("le nom : "+ name + " le nom de la bdd : "+resultSet.getString("name_")) ;
		} 
	    return result ;
		
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		VerificationDAO.connection = connection;
	}
}
