package com.madinatic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.madinatic.classes.Employee;
import com.madinatic.classes.TypeEmployee;
import com.madinatic.exception.EmployeeException;

public class EmployeeDAO extends DAO<Employee>{

	public EmployeeDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	

	public ResultSet verifyIdcard(Employee obj) throws EmployeeException , SQLException{
		try { Class.forName("com.mysql.jdbc.Driver");}
				catch(ClassNotFoundException e) {}
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/People","root","t;forever33");
		PreparedStatement state = connection.prepareStatement("select * from People where id_card ="+obj.getId_card());
		ResultSet set = state.executeQuery();
		set.last();
		//System.out.println("size of people having id card"+obj.getId_card() +" "+ set.getRow());
		//while(set.next()) System.out.println(set.getInt("id_card"));
		if(set.getRow()==0) throw new EmployeeException();
		connection.close();
		return set;
	}
	
	@Override
	public boolean create(Employee obj) throws SQLException, EmployeeException {
		// TODO Auto-generated method stub
		ResultSet set = verifyIdcard(obj);
		if(obj.getType_emp()==TypeEmployee.SUPERVISOR)
				connection.prepareStatement("insert into Employee(first_name,name_,phone_number,type_emp,id_card,date_begin,date_end,id_sup)"
				+ " value('"+set.getString("first_name")+"','"+set.getString("name_")+"','"+obj.getPhone_number()+"','"+
						obj.getType_emp().toString()+"',"+obj.getId_card()+","+obj.getDate_begin()+","+obj.getDate_end()+","+obj.getId_sup()+")").execute();
		else connection.prepareStatement("insert into Employee(first_name,name_,phone_number,type_emp,id_card,date_begin,date_end,id_service)"
			+ " value('"+set.getString("first_name")+"','"+set.getString("name_")+"','"+obj.getPhone_number()+"','"
					+ obj.getType_emp().toString()+"',"+obj.getId_card()+","+obj.getDate_begin()+","+obj.getDate_end()+","+obj.getId_service()+")").execute();
		return false;
	}

	@Override
	public boolean delete(Employee obj) throws SQLException {
		// TODO Auto-generated method stub
		connection.prepareStatement("delete from Employee where id_employee = "+obj.getId_employee());
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
