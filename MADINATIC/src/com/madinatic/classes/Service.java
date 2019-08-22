package com.madinatic.classes;

public class Service extends User{
	private int id_service;
	private String name;
	private TypeService type_service;
	private String email;
	private String site_web;
	private Town town = new Town();
	private Employee employee;
	
	
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
	
	public String username() {
		return "SER"+getName()+town.getId_town();
	}
	public Town getTown() {
		return town;
	}
	public void setTown(Town town) {
		this.town = town;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}

