package com.main.models;

import java.util.ArrayList;


// (Optional) We use this class in order to have a simple way to display elements. We the number of names,
// the name of the name and the repositories that have used this name


public class Elements {
	private int total;
	private String name;
	private ArrayList<String> repos;
	
	
	
	public Elements(int total, String name, ArrayList<String> repos) {
		super();
		this.total = total;
		this.name = name;
		this.repos = repos;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getRepos() {
		return repos;
	}
	public void setRepos(ArrayList<String> repos) {
		this.repos = repos;
	}
	
	
	

}
