package com.madinatic.classes;

import java.util.List;

public class Wilaya {
	private int id_wilaya;
	private String name;
	private List<Town> towns;
	
	public int getId_wilaya() {
		return id_wilaya;
	}
	public void setId_wilaya(int id_wilaya) {
		this.id_wilaya = id_wilaya;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Town> getTowns() {
		return towns;
	}
	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

}
