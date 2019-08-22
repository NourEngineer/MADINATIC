package com.madinatic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.madinatic.classes.*;

import com.madinatic.exception.MadinaticException;

public class WilayaDAO extends DAO<Wilaya>{

	public WilayaDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Wilaya obj) throws SQLException, MadinaticException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Wilaya obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Wilaya obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Wilaya find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Wilaya> restore() throws SQLException{
		System.out.println("yes");
		ArrayList<Wilaya> wilayas = new ArrayList<Wilaya>();
		Wilaya wilaya;
		ResultSet set = connection.prepareStatement("SELECT * FROM Wilaya").executeQuery();
		while(set.next()) {
			wilaya = new Wilaya();
			wilaya.setId_wilaya(set.getInt("id_wilaya"));
			wilaya.setName(set.getString("name_"));
			System.out.println(set.getString("name_"));
			ResultSet set2 = connection.prepareStatement("SELECT * FROM Town where id_wilaya ="+wilaya.getId_wilaya()).executeQuery();
			ArrayList<Town> towns = new ArrayList<>();
			while(set2.next()) {
				Town town = new Town();
				town.setId_town(set2.getInt("id_town"));
				town.setName(set2.getString("name_"));
				System.out.println("------------"+set2.getString("name_"));
				//recupération des services
				ResultSet set3 = connection.prepareStatement("SELECT id_service FROM Service where id_town ="+town.getId_town()).executeQuery();
				ArrayList<Service> services = new ArrayList<>();
				while(set3.next()) {
					Service service;
					ServiceDAO serviceDAO = new ServiceDAO(connection); 
					service = serviceDAO.find(set3.getInt("id_service"));
					services.add(service);
				}
				town.setServices(services);
				towns.add(town);
			}
			wilaya.setTowns(towns);
			wilayas.add(wilaya);
		}
		System.out.println("yes");
		return wilayas;
	}

}
