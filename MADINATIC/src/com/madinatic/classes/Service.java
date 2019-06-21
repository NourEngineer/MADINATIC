package com.madinatic.classes;

public class Service extends User{
	private int id_service;
	private String name;
	private TypeService type_service;
	private String email;
	private String site_web;
	private int id_town;
	
	
	public int getId_service() {
		return id_service;
	}
	public void setId_service(int id_service) {
		this.id_service = id_service;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TypeService getType_service() {
		return type_service;
	}
	public void setType_service(TypeService type_service) {
		this.type_service = type_service;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite_web() {
		return site_web;
	}
	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}
	public int getId_town() {
		return id_town;
	}
	public void setId_town(int id_town) {
		this.id_town = id_town;
	}
	
	public String username() {
		return "SER"+getName()+getId_town();
	}
	
}

