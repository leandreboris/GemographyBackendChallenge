package com.main.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//This is the object model for the Json Main page, we ignored some 'unnecessary' properties

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepoJson {
	public Long total_count;
	public List<Items> items;
	public Long getTotal_count() {
		return total_count;
	}
	public void setTotal_count(Long total_count) {
		this.total_count = total_count;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "RepoJson [total_count=" + total_count + "]";
	}
	

}
