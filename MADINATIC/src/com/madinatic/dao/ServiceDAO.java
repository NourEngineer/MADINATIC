package com.madinatic.dao;

import com.madinatic.classes.Service;
import com.madinatic.exception.ServiceException;

import java.sql.*;

public class ServiceDAO extends DAO<Service>{
	
	public ServiceDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Service obj) throws SQLException , ServiceException {
		verifyDuplication(obj);
		connection.prepareStatement(""
				+ "insert into Service(service_name,username,email,siteweb,type_service,id_town)"
				+ " value('"+obj.getName()
				+"','"+obj.username()+"','"+obj.getEmail()+"','"+obj.getSite_web()+"','"+obj.getType_service().toString()+"',"+obj.getId_town()+")")
		.execute(); 
		return true;
	}
	
	public void verifyDuplication(Service obj) throws ServiceException , SQLException {
		PreparedStatement state = connection.prepareStatement("select * from Service where service_name = '"+obj.getName()+"' and id_town="+obj.getId_town());
		if(state.executeQuery().getFetchSize()!= 0) throw new ServiceException(true);
	}

	@Override
	public boolean delete(Service obj) throws SQLException {
		connection.prepareStatement("delete from Service where id_service = " + obj.getId_service()).execute();
		return false;
	}

	@Override
	public boolean update(Service obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Service find(int id) throws SQLException {
		// TODO Auto-generated method stub
		Service service = new Service();
		ResultSet set = connection.prepareStatement("select * from Service where id_service = " + Integer.toString(id) ).executeQuery();
		set.next();
		service.setId_service((Integer) set.getInt("id_service"));
		return service;
	}

}