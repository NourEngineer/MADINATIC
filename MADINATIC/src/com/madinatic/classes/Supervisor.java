package com.madinatic.classes;

public class Supervisor extends User{
	
	// Declaration :
	private int id_sup ;
	private Employee employee ;
	private Town town = new Town();

	// Constrictor :
	
	public Supervisor(Employee employee) {
		super();
		this.employee = employee;
	}

	// Getters and Setters :
	
	
	public Supervisor(Employee employee, Town town) {
		super();
		this.employee = employee;
		this.town = town;
	}

	public Supervisor() {
		// TODO Auto-generated constructor stub
	}

	public int getId_sup() {
		return id_sup;
	}

	public void setId_sup(int id_sup) {
		this.id_sup = id_sup;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	
	// Methodes : 
	
		public String username() {	
			/*
			 * @Param position indique le numero du dernier superviseur
			 */
			String username = "SUP_"+town.getId_town();
			return username;
		}

		
}
