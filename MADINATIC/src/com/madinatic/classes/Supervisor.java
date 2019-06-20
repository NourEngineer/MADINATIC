package com.madinatic.classes;

public class Supervisor extends User{
	private int id_town;

	public int getId_town() {
		return id_town;
	}

	public void setId_town(int id_town) {
		this.id_town = id_town;
	}
	
	
	// génére le username d'un superviseur

	public String username(int position ) {	
		/*
		 * @Param position indique le numero du dernier superviseur
		 */
		String username = "SUP_"+id_town+"_"+position;  
		return username;
	}
}
