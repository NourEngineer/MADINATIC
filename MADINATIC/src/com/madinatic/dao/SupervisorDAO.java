package com.madinatic.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.madinatic.classes.DateOperation;
import com.madinatic.classes.Employee;
import com.madinatic.classes.Supervisor;
import com.madinatic.classes.Town;
import com.madinatic.classes.TypeEmployee;
import com.madinatic.classes.User;
import com.madinatic.exception.MadinaticException;
import java.sql.Statement;

public class SupervisorDAO extends DAO<Supervisor>{
	
	// Declarations  :
	
	static Statement state ;
	static ResultSet resultSet ;
	static PreparedStatement pr ;
	static VerificationDAO  verificatioDAO ;
	static Date date = new Date();

    
	//  Getters and setters  :
	
	public static VerificationDAO getVerificatioDAO() {
		return verificatioDAO;
	}

	public static void setVerificatioDAO( VerificationDAO verificatioDAO ) {
		SupervisorDAO.verificatioDAO = verificatioDAO;
	}
	
	//  Constructor  : 
	
	public SupervisorDAO( Connection connection ) {
		super( connection );
		try {
			setVerificatioDAO( new VerificationDAO() );
		} catch ( SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//  Methodes  :
	
	@Override
	public boolean create( Supervisor obj ) throws SQLException , MadinaticException {

		try {
			// Verification :
			boolean verify = getVerificatioDAO().VerifyInfo( obj.getEmployee().getId_card(),
			        obj.getEmployee().getName() , obj.getEmployee().getFirst_name() );
			System.out.println("Verify is t :" + verify);
			if( verify  ) {
			   	
				System.out.println("//////YEEEES");
					obj.getEmployee().setDate_begin( date ) ;
				    
					/*state = ( Statement ) connection.createStatement() ;
					resultSet = state.executeQuery( "Select * from Town where "
							+ "name_ = '" + obj.getTown().getName() + "';" ) ;
					
					if( resultSet.first() ) {
						obj.getTown().setId_town( resultSet.getInt( "id_town" ) ) ;
					} */
					
										
					obj.setDate_create( date ) ;
			
					System.out.println("//////YEEEES");
					
					pr = connection.prepareStatement( "Insert into Acount ("
							+ "passeword, username , date_create) "
							+ "value ('"+obj.getPassword()+"'"
							+ ",'"+obj.getUsername()+"'"
							+ ",'"+DateOperation.ConvertDate(date)+"');") ;
					pr.executeUpdate() ;
					System.out.println("//////YEEEES");
					pr = connection.prepareStatement("Insert into Supervisor ("
							+ "id_town , username) "
							+ "values("+obj.getTown().getId_town()+""
							+ ",'"+obj.getUsername()+"');") ;
					pr.executeUpdate();
					System.out.println("//////YEEEES");
					state = ( Statement ) connection.createStatement() ; 
				    resultSet = state.executeQuery("select * from  Supervisor "
				    		+"where id_town ="+obj.getTown().getId_town()+";");
					if (resultSet.next()) {
						obj.setId_sup(resultSet.getInt("id_sup"));
						pr = connection.prepareStatement("insert into Employee ("
							+ "name_ , firstname , phone_number , type_emp , "
							+ "id_card , id_sup, date_begin) "
							+ "values('"+obj.getEmployee().getName().toString()+"'"
							+ ",'"+obj.getEmployee().getFirst_name().toString()+"'"
							+ ",'"+obj.getEmployee().getPhone_number().toString()+"'"
							+ ",'"+obj.getEmployee().getType_employee()+"'"
							+ ","+obj.getEmployee().getId_card()+","+obj.getId_sup()+""
							+ ",'"+DateOperation.ConvertDate(date)+"');");       
						pr.executeUpdate();	
			        }
					System.out.println("//////YEEEES");
			}
			
			
		}catch (Exception e) {
			System. out.println("Exception  occured");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete( Supervisor obj ) {
		 
		try {
			
			pr = connection.prepareStatement("delete from Supervisor "
					+ "where id_sup = "+obj.getId_sup()+";");
		    pr.executeUpdate();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Supervisor sup) {
		
			// Declaration : 
		
		    boolean updated = false ;
		    String password ;
		    
            try {
            	
            //  UPdate Password :
            	
	            password = User.generatePassword();
	    		sup.setPassword(password);
    		 
	    		System.out.println("le nouveau mot de passe est : "+password );
	    		
	    		pr = connection.prepareStatement("update Acount set passeword ="
	    				+ " ' "+password+" ' "
	    				+ "where username='"+sup.getUsername()+"';");
				pr.executeUpdate();
	    		
           //  Update Employee if not insert ( if it is new ) : 
				
	    	if( sup.getEmployee().getId_employee()==0 && 
	    	    getVerificatioDAO().VerifyInfo(sup.getEmployee().getId_card() ,
	 		    sup.getEmployee().getName(),sup.getEmployee().getFirst_name() ) ) {
			
	    			sup.getEmployee().setDate_begin(date);
		 
					pr = connection.prepareStatement("update Employee set date_end ="
							+ " ' "+DateOperation.ConvertDate(date)+" ' "
							+ " where id_sup = "+sup.getId_sup()+" "
						    + " order by date_begin desc ,id_employee desc limit 1");
					pr.executeUpdate();
					
					pr = connection.prepareStatement("insert into Employee ("
							+ "name_ , firstname , phone_number , type_emp , id_card "
							+ ", id_sup, date_begin) "
							+ "values('"+sup.getEmployee().getName().toString()+" ' "
							+ ",'"+sup.getEmployee().getFirst_name().toString()+" ' "
							+ ",'"+sup.getEmployee().getPhone_number().toString()+" ' "
							+ ",'"+sup.getEmployee().getType_employee()+" ' "
							+ ", "+sup.getEmployee().getId_card()+" "
							+ ", "+sup.getId_sup()+" "
							+ ",'"+DateOperation.ConvertDate(date)+"') ; " ) ;       
					pr.executeUpdate();
					
					resultSet = connection.prepareStatement("select * from Employee "
							+ " where id_sup = "+sup.getId_sup()+" "
							+ " order by id_employee desc, date_begin desc limit 0,1").executeQuery();
					if(resultSet.next())  
					   sup.getEmployee().setId_employee(resultSet.getInt("id_employee"));
					
	    	}else {
	    		//TODO 
	    	}
	    	
			updated = true ;	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
            
			return updated;
			
	}

	@Override
	public Supervisor find(int id) {
		
		// Declaration :
		
		Supervisor sup = new Supervisor();
		User account = new User();
		Employee emp = new Employee();
		Town town = new Town();
		
		try {
			resultSet = state.executeQuery("select * from Supervisor "
					+ "where id_sup = "+id);
			if(resultSet.next()) { 
				sup.setId_sup(resultSet.getInt("id_sup"));
				town.setId_town(resultSet.getInt("id_town")) ;
				account.setUsername(resultSet.getString("username"));
				
				resultSet = state.executeQuery("select * from Town "
						+ "where id_town = "+town.getId_town());
				if(resultSet.next()) {
					town.setName(resultSet.getString("name_"));
					town.setId_wilaya(resultSet.getInt("id_wilaya"));
				}
				sup.setTown(town);
				
				resultSet = state.executeQuery("select * from Employee "
						+ "where id_sup ="+sup.getId_sup()+" "
						+ "&& type_emp = 'SUPERVISOR' "
						+ "order by date_begin desc, id_employee desc limit 0,1 ");
				if(resultSet.next()) {
					
				emp.setId_employee(resultSet.getInt("id_employee"));
				emp.setName(resultSet.getString("name_"));
				emp.setFirst_name(resultSet.getString("firstname"));
				emp.setId_card(resultSet.getInt("id_card"));
				emp.setPhone_number(resultSet.getString("phone_number"));
				emp.setDate_begin(resultSet.getDate("date_begin"));
				emp.setType_employee(TypeEmployee.SUPERVISOR);
				
				}
				
				sup.setEmployee(emp);
				
				resultSet = state.executeQuery("select * from Acount"
						+ " where username = '"+account.getUsername()+"'");
				if(resultSet.next()) {
					sup.setUsername(account.getUsername());
					sup.setPassword(resultSet.getString("passeword"));
					sup.setDate_create(resultSet.getDate("date_create"));
				}
				
			
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sup;
	}	

	
	public Supervisor find(String id) {
		
		// Declaration :
		
		Supervisor sup = new Supervisor();
		User account = new User();
		Employee emp = new Employee();
		Town town = new Town();
		
		try {
			resultSet = connection.prepareStatement("select * from Supervisor "
					+ "where id_town = "+id).executeQuery();
			
			if(resultSet.next()) { 
				sup.setId_sup(resultSet.getInt("id_sup"));
				town.setId_town(resultSet.getInt("id_town")) ;
				account.setUsername(resultSet.getString("username"));
				
				resultSet = connection.prepareStatement("select * from Town "
						+ "where id_town = "+town.getId_town()).executeQuery();
				if(resultSet.next()) {
					town.setName(resultSet.getString("name_"));
					town.setId_wilaya(resultSet.getInt("id_wilaya"));
				}
				sup.setTown(town);
				
				resultSet = connection.prepareStatement("select * from Employee "
						+ "where id_sup ="+sup.getId_sup()+" "
						+ "&& type_emp = 'SUPERVISOR' "
						+ "order by date_begin desc, id_employee desc limit 0,1 ").executeQuery();
				if(resultSet.next()) {
					
				emp.setId_employee(resultSet.getInt("id_employee"));
				emp.setName(resultSet.getString("name_"));
				emp.setFirst_name(resultSet.getString("firstname"));
				emp.setId_card(resultSet.getInt("id_card"));
				emp.setPhone_number(resultSet.getString("phone_number"));
				emp.setDate_begin(resultSet.getDate("date_begin"));
				emp.setType_employee(TypeEmployee.SUPERVISOR);
				
				}
				
				sup.setEmployee(emp);
				
				resultSet = connection.prepareStatement("select * from Acount"
						+ " where username = '"+account.getUsername()+"'").executeQuery();
				if(resultSet.next()) {
					sup.setUsername(account.getUsername());
					sup.setPassword(resultSet.getString("passeword"));
					sup.setDate_create(resultSet.getDate("date_create"));
				}
				
			
			}else {
				return null;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sup;
	}	
}
