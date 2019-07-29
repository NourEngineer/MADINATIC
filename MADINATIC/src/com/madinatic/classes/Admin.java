package com.madinatic.classes;

import java.sql.SQLException;

import com.madinatic.exception.ServiceException;

import Dao.DaoFactory;

public class Admin extends User{
	DaoFactory daoFactory = DaoFactory.getInstance();
	public void addSupervisor (Supervisor sup) throws SQLException {
		daoFactory.getSupervisorDAO().create(sup);
	}
	public void addService (Service ser) throws ServiceException, SQLException {
		daoFactory.getServiceDAO().create(ser);
	}
}
