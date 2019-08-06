package com.madinatic.classes;

import java.sql.Date;

public class Employee {
	private int id_employee;
    private String firstname;
    private String name;
    private String phone_number;
    private TypeEmployee type_emp; 
    private int id_card; 
    private Date date_begin;
    private Date date_end;
    private int id_sup;
    private int id_service;
    
    public int getId_employee() {
		return id_employee;
	}
	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public TypeEmployee getType_emp() {
		return type_emp;
	}
	public void setType_emp(TypeEmployee type_emp) {
		this.type_emp = type_emp;
	}
	public int getId_card() {
		return id_card;
	}
	public void setId_card(int id_card) {
		this.id_card = id_card;
	}
	public Date getDate_begin() {
		return date_begin;
	}
	public void setDate_begin(Date date_begin) {
		this.date_begin = date_begin;
	}
	public Date getDate_end() {
		return date_end;
	}
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	public int getId_sup() {
		return id_sup;
	}
	public void setId_sup(int id_sup) {
		this.id_sup = id_sup;
	}
	public int getId_service() {
		return id_service;
	}
	public void setId_service(int id_service) {
		this.id_service = id_service;
	}
}
