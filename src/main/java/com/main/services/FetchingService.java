package com.main.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.models.Items;
import com.main.models.RepoJson;

@Service
public class FetchingService implements IFetchingService {
	
	
	// A simple httpClient to fetch our json data and mapp them in the specific objects
	
	@Override
	public List<Items> fetchItems(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")
				.uri(URI.create(url))
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		ObjectMapper obj = new ObjectMapper();
		RepoJson repos = obj.readValue(response.body(), RepoJson.class);
		List<Items> items = repos.getItems();
		return items;
	}
}
