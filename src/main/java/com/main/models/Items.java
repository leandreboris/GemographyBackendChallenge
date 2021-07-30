package com.main.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// This is the object model for the repositories, we ignored some 'unnecessary' properties

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
	public String name;
	public String language;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Items [name=" + name + ", language=" + language + "]";
	}
	
	

}
