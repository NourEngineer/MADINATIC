package com.madinatic.dao;

import java.sql.*;

import com.madinatic.classes.Supervisor;
import com.madinatic.dao.DAO;

public class SupervisorDAO extends DAO<Supervisor>{
	
	public SupervisorDAO(Connection connection) {
		super(connection);
	}


	@Override
	public boolean create(Supervisor obj) throws SQLException {
		PreparedStatement state = connection.prepareStatement("update Town set supervised = true where id_town = "+obj.getId_town());
		state.executeUpdate();
		state = connection.prepareStatement("insert into Employee(id_card) value("+obj.getId_town()+ ")");
		state.executeUpdate();
		ResultSet result = connection.prepareStatement("select * from Supervisor where id_town = "+Integer.toString(obj.getId_town())).executeQuery();
		int position = result.getFetchSize();
		System.out.println(position);
		state = connection.prepareStatement("insert into Acount values('"+obj.username(position)+"','"+obj.getPassword()+"')");
			state.executeUpdate();

		PreparedStatement statement = connection.prepareStatement(
				"insert into Supervisor values("+obj.getId_town()+","+obj.getId_town()+",true,'"+obj.username(0)+"')");
		statement.executeUpdate();
		return true;
	}

	@Override
	public boolean delete(Supervisor obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Supervisor obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Supervisor find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
