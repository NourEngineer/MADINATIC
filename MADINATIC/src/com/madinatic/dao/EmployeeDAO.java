package com.madinatic.dao;

//*******************************************************************************************************************************
import java.sql.Connection;
import java.sql.SQLException;

import com.madinatic.classes.Employee;
import java.sql.PreparedStatement;

//*******************************************************************************************************************************

public class EmployeeDAO extends DAO<Employee>{

	// Constructor :
	
	
	public EmployeeDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	
	// Methodes : 
	
	@Override
	public boolean create(Employee obj) throws SQLException {
		VerificationDAO vd = new VerificationDAO();
		
		//if(vd.VerifyIdCard(obj.getId_card()));
		
		//return false;
		
		//if(vd.VerifyIdCard(obj.getId_card())) {
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(""
							+ "insert into Town (name_, id_wilaya) value('miliana',44) ");
							//+ "(firstname,name_ ,phone_number ,type_emp ,id_card ,  date_begin )"
							//+ " values ("+obj.getFirst_name().toString()+","+ obj.getName().toString()+","+obj.getPhone_number().toString()+","+obj.getType_employee().toString()+","+obj.getId_card()+","+obj.getDate_begin().toString() + ")");
			statement.executeUpdate();
		//}
		
		return vd.VerifyIdCard(obj.getId_card());
		
	}

	@Override
	public boolean delete(Employee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Employee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
