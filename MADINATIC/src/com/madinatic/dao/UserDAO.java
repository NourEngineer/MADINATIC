package com.madinatic.dao;

import java.sql.Connection;
import com.madinatic.classes.*;
import java.sql.SQLException;

import com.madinatic.classes.User;
import com.madinatic.exception.MadinaticException;

public class UserDAO extends DAO<User>{

	public UserDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(User obj) throws SQLException, MadinaticException {
		// TODO Auto-generated method stub
		connection.prepareStatement("insert into Acount values('"+((Service)obj).username()+"','"+User.generatePassword()+"','"+java.time.LocalDate.now() +"')").execute();
		
		return false;
	}

	@Override
	public boolean delete(User obj) throws SQLException {
		// TODO Auto-generated method stub
		connection.prepareStatement("delete from Employee where user_name = "+obj.getUsername());
		return false;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
