package Dao;

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
		verifyIdcard(obj);
		connection.prepareStatement("insert into Employee(id_card) value("+obj.getId_card()+")").execute();
		connection.prepareStatement("insert into Acount values('"+obj.username()+"','"+obj.generatePassword()+"')").execute();
		System.out.println("here");
		connection.prepareStatement(""
				+ "insert into Service(id_card,service_name,username,current_,type_service,id_town)"
				+ " value("+obj.getId_card()+",'"+obj.getName()+
				"','"+obj.username()+"',true,'"+obj.getType_service().toString()+"',"+obj.getId_town()+")")
		.execute();
		
		return true;
	}
	public void verifyDuplication(Service obj) throws ServiceException , SQLException {
		PreparedStatement state = connection.prepareStatement("select * from Service where service_name = '"+obj.getName()+"' and id_town="+obj.getId_town());
		if(state.executeQuery().getFetchSize()!= 0) throw new ServiceException(true,false);
	}
	public void verifyIdcard(Service obj) throws ServiceException , SQLException{
		try { Class.forName("com.mysql.jdbc.Driver");}
				catch(ClassNotFoundException e) {}
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/People","root","t;forever33");
		PreparedStatement state = connection.prepareStatement("select * from People where id_card ="+obj.getId_card());
		ResultSet set = state.executeQuery();
		set.last();
		System.out.println("size of people having id card"+obj.getId_card() +" "+ set.getRow());
		
		while(set.next()) System.out.println(set.getInt("id_card"));
		if(set.getRow()==0) throw new ServiceException(false,true);
		connection.close();
	}

	@Override
	public boolean delete(Service obj) throws SQLException {
		
		connection.prepareStatement("delete from Service where id_service = " + obj.getId_service());
		return false;
	}

	@Override
	public boolean update(Service obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Service find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
