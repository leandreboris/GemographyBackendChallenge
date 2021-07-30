package com.main.services;

import java.io.IOException;
import java.util.List;

import com.main.models.Items;

// Used to fetch json elements and parse them in Java Objects

public interface IFetchingService {
	
	public List<Items> fetchItems(String url) throws IOException, InterruptedException;

}
