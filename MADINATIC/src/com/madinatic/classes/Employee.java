package com.madinatic.classes;

import java.util.Date;

public class Employee {
	// Declaration :
	
	
	private int id_employee ;
	private String first_name ;
	private String name ;
	private String phone_number ;
	private TypeEmployee type_employee ;
	private int id_card ;
	private Date date_begin ;
	private Date date_end ;
	
	// Consrictor :
	
	
	public Employee(String name, String first_name, String phone_number, TypeEmployee type_employee, int id_card,
			Date date_begin, Date date_end) {
		super();
		this.first_name = first_name;
		this.name = name;
		this.phone_number = phone_number;
		this.type_employee = type_employee;
		this.id_card = id_card;
		this.date_begin = date_begin;
		this.date_end = date_end;
	}

	
	// Getters and Setters :
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public int getId_employee() {
		return id_employee;
	}

	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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

	public TypeEmployee getType_employee() {
		return type_employee;
	}

	public void setType_employee(TypeEmployee type_employee) {
		this.type_employee = type_employee;
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

	
	
	
	
	
}
