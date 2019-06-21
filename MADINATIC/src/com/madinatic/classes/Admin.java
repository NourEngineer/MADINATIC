package com.madinatic.classes;

import Dao.DaoFactory;

public class Admin extends User{
	DaoFactory daoFactory = DaoFactory.getInstance();
	public void addSupervisor (Supervisor sup) {
		try {
		daoFactory.getSupervisorDAO().create(sup);
		}catch(Exception e){
			System.out.println("j'ai pas peu admin");
		}
	}
	public void addService (Service ser) {
		try {
		daoFactory.getServiceDAO().create(ser);
		}catch(Exception e){
			System.out.println("j'ai pas peu admin");
		}
	}
}
