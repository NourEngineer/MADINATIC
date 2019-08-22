package com.madinatic.classes;

import java.util.ArrayList;

public class Town {
	private int id_town;
	private String name;
	private int id_wilaya;
	private ArrayList<Service> services ;
	
	
	
	public ArrayList<Service> getServices() {
		return services;
	}
	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}
	public int getId_wilaya() {
		return id_wilaya;
	}
	public void setId_wilaya(int id_wilaya) {
		this.id_wilaya = id_wilaya;
	}
	public int getId_town() {
		return id_town;
	}
	public void setId_town(int id_town) {
		this.id_town = id_town;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
