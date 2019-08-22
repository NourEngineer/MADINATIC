package com.madinatic.classes;

import java.sql.SQLException;
import java.util.List;

import com.madinatic.dao.DaoFactory;
import com.madinatic.exception.MadinaticException;
import com.madinatic.exception.ServiceException;

public class Admin extends User{
	
	DaoFactory daoFactory = DaoFactory.getInstance();
	public void addSupervisor (Supervisor sup) throws SQLException, MadinaticException {
		daoFactory.getSupervisorDAO().create(sup);
	}
	public void addService (Service ser) throws ServiceException, SQLException {
		daoFactory.getServiceDAO().create(ser);
	}
	
}
