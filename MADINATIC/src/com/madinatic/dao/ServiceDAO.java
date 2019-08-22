package com.madinatic.dao;

import com.madinatic.classes.DateOperation;
import com.madinatic.classes.Employee;
import com.madinatic.classes.Service;
import com.madinatic.classes.Supervisor;
import com.madinatic.classes.Town;
import com.madinatic.classes.TypeEmployee;
import com.madinatic.classes.TypeService;
import com.madinatic.classes.User;
import com.madinatic.exception.ServiceException;

import java.sql.*;

public class ServiceDAO extends DAO<Service>{
	
	static Statement state ;
	static ResultSet resultSet ;
	static PreparedStatement pr ;
	
	public ServiceDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Service obj) throws SQLException , ServiceException {
		/*verifyDuplication(obj);
		connection.prepareStatement(""
				+ "insert into Service(service_name,username,email,siteweb,type_service,id_town)"
				+ " value('"+obj.getName()
				+"','"+obj.username()+"','"+obj.getEmail()+"','"+obj.getSite_web()+"','"+obj.getType_service().toString()+"',"+obj.getTown().getId_town()+")")
		.execute(); */
		System.out.println("FirstName/***************"+obj.getEmployee().getFirst_name() +"+++++");
		
		try {
			// Verification :
			boolean verify = new VerificationDAO().VerifyInfo( obj.getEmployee().getId_card(),
			        obj.getEmployee().getName() , obj.getEmployee().getFirst_name() );
			System.out.println("Verify is to :" + verify);
			if( verify  && verifyDuplication(obj)) {
			   	
				System.out.println("//////YEEEES");
					obj.getEmployee().setDate_begin( Date.valueOf(java.time.LocalDate.now()) ) ;
				    
					/*state = ( Statement ) connection.createStatement() ;
					resultSet = state.executeQuery( "Select * from Town where "
							+ "name_ = '" + obj.getTown().getName() + "';" ) ;
					
					if( resultSet.first() ) {
						obj.getTown().setId_town( resultSet.getInt( "id_town" ) ) ;
					} */
					
										
					obj.setDate_create( Date.valueOf(java.time.LocalDate.now()) ) ;
			
					System.out.println("//////YEEEES");
					
					pr = connection.prepareStatement( "Insert into Acount ("
							+ "passeword, username , date_create) "
							+ "value ('"+obj.getPassword()+"'"
							+ ",'"+obj.getUsername()+"'"
							+ ",'"+java.time.LocalDate.now()+"');") ;
					pr.executeUpdate() ;
					System.out.println("//////YEEEES");
					connection.prepareStatement(""
							+ "insert into Service(service_name,username,email,siteweb,type_service,id_town)"
							+ " value('"+obj.getName()
							+"','"+obj.username()+"','"+obj.getEmail()+"','"+obj.getSite_web()+"','"+obj.getType_service().toString()+"',"+obj.getTown().getId_town()+")")
					.execute();
					System.out.println("//////YEEEES");
					state = ( Statement ) connection.createStatement() ; 
				    resultSet = state.executeQuery("select * from  Service "
				    		+"where id_town ="+obj.getTown().getId_town()+" and service_name = '"+obj.getName() +"';");
					if (resultSet.next()) {
						obj.setId_service(resultSet.getInt("id_service"));
						pr = connection.prepareStatement("insert into Employee ("
							+ "name_ , firstname , phone_number , type_emp , "
							+ "id_card , id_service, date_begin) "
							+ "values('"+obj.getEmployee().getName()+"'"
							+ ",'"+obj.getEmployee().getFirst_name()+"'"
							+ ",'"+obj.getEmployee().getPhone_number()+"'"
							+ ",'"+obj.getEmployee().getType_employee()+"'"
							+ ","+obj.getEmployee().getId_card()+","+obj.getId_service()+""
							+ ",'"+java.time.LocalDate.now()+"');");       
						pr.executeUpdate();	
			        }
					System.out.println("//////YEEEES");
			}
			
			
		}catch (Exception e) {
			System. out.println("Exception  occured");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean verifyDuplication(Service obj) throws ServiceException , SQLException {
		PreparedStatement state = connection.prepareStatement("select * from Service where service_name = '"+obj.getName()+"' and id_town="+obj.getTown().getId_town());
		if(state.executeQuery().getFetchSize()!= 0) {
			return false;
		}
		else return true;		
	}

	@Override
	public boolean delete(Service obj) throws SQLException {
		connection.prepareStatement("delete from Service where id_service = " + obj.getId_service()).execute();
		return false;
	}

	@Override
	public boolean update(Service obj) {
		// TODO Auto-generated method stub
		// Declaration : 
		
	    boolean updated = false ;
	    String password ;
	    
        try {
        	
        //  UPdate Password :
        	
            password = User.generatePassword();
    		obj.setPassword(password);
		 
    		System.out.println("le nouveau mot de passe est : "+password );
    		
    		pr = connection.prepareStatement("update Acount set passeword ="
    				+ " ' "+password+" ' "
    				+ "where username='"+obj.getUsername()+"';");
			pr.executeUpdate();
    		
       //  Update Employee if not insert ( if it is new ) : 
			
    	if( obj.getEmployee().getId_employee()==0 && 
    	    new VerificationDAO().VerifyInfo(obj.getEmployee().getId_card() ,
 		    obj.getEmployee().getName(),obj.getEmployee().getFirst_name() ) ) {
		
    			obj.getEmployee().setDate_begin(Date.valueOf(java.time.LocalDate.now()));
	 
				pr = connection.prepareStatement("update Employee set date_end ="
						+ " ' "+java.time.LocalDate.now()+" ' "
						+ " where id_service = "+obj.getId_service()+" "
					    + " order by date_begin desc ,id_employee desc limit 1");
				pr.executeUpdate();
				
				pr = connection.prepareStatement("insert into Employee ("
						+ "name_ , firstname , phone_number , type_emp , id_card "
						+ ", id_sup, date_begin) "
						+ "values('"+obj.getEmployee().getName()+" ' "
						+ ",'"+obj.getEmployee().getFirst_name()+" ' "
						+ ",'"+obj.getEmployee().getPhone_number()+" ' "
						+ ",'"+obj.getEmployee().getType_employee()+" ' "
						+ ", "+obj.getEmployee().getId_card()+" "
						+ ", "+obj.getId_service()+" "
						+ ",'"+java.time.LocalDate.now()+"') ; " ) ;       
				pr.executeUpdate();
				
				resultSet = state.executeQuery("select * from Employee "
						+ " where id_sup = "+obj.getId_service()+" "
						+ " order by id_employee desc, date_begin desc limit 0,1");
				if(resultSet.next())  
				   obj.getEmployee().setId_employee(resultSet.getInt("id_employee"));
				
    	}
    	
		updated = true ;	
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
        
		return updated;
	}

	@Override
	public Service find(int id) throws SQLException {
		Service service = new Service();
		User account = new User();
		Employee emp = new Employee();
		Town town = new Town();
		
		try {
			resultSet = connection.prepareStatement("select * from Service "
					+ "where id_service = "+id).executeQuery();
			if(resultSet.next()) { 
				service.setId_service(resultSet.getInt("id_service"));
				service.setUsername(resultSet.getString("username"));
				service.setType_service(TypeService.valueOf(resultSet.getString("type_service")));
				service.setName(resultSet.getString("service_name"));
				service.setEmail(resultSet.getString("email"));
				service.setSite_web(resultSet.getString("site_web"));
				town.setId_town(resultSet.getInt("id_town")) ;
				account.setUsername(resultSet.getString("username"));
				
				resultSet = state.executeQuery("select * from Town "
						+ "where id_town = "+town.getId_town());
				if(resultSet.next()) {
					town.setName(resultSet.getString("name_"));
					town.setId_wilaya(resultSet.getInt("id_wilaya"));
				}
				service.setTown(town);
				
				resultSet = state.executeQuery("select * from Employee "
						+ "where id_service ="+service.getId_service()+" "
						+ "&& type_emp = 'SERVICE_AGENT' "
						+ "order by date_begin desc, id_employee desc limit 0,1 ");
				if(resultSet.next()) {
					
				emp.setId_employee(resultSet.getInt("id_employee"));
				emp.setName(resultSet.getString("name_"));
				emp.setFirst_name(resultSet.getString("firstname"));
				emp.setId_card(resultSet.getInt("id_card"));
				emp.setPhone_number(resultSet.getString("phone_number"));
				emp.setDate_begin(resultSet.getDate("date_begin"));
				emp.setType_employee(TypeEmployee.SERVICE_AGENT);
				
				}
				
				service.setEmployee(emp);
				
				resultSet = state.executeQuery("select * from Acount"
						+ " where username = '"+account.getUsername()+"'");
				if(resultSet.next()) {
					
					service.setPassword(resultSet.getString("passeword"));
					service.setDate_create(resultSet.getDate("date_create"));
				}
				
			
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return service;
		/*// TODO Auto-generated method stub
		Service service = new Service();
		ResultSet set = connection.prepareStatement("select * from Service where id_service = " + Integer.toString(id) ).executeQuery();
		set.next();
		service.setId_service((Integer) set.getInt("id_service"));
		return service;*/
	}
	
	public Service find(String service_name,int id_town) throws SQLException {
		// TODO Auto-generated method stub
		Service service = new Service();
		ResultSet set = connection.prepareStatement("select * from Service where service_name= '" + service_name +"' and id_town = "+ id_town ).executeQuery();
		if(set.first())service.setId_service((Integer) set.getInt("id_service"));
		return service;
	}
	

}