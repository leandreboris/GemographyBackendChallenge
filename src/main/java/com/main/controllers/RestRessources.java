package com.main.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.models.Elements;
import com.main.models.Items;
import com.main.services.IFetchingService;
import com.main.services.LanguageComparator;

@RestController
public class RestRessources {
	
	// The nearly same processes with the MainController we just added Rest annotation and returned elements
	
	@Autowired
	public IFetchingService fetchingService;
	final String JsonUrl = "https://api.github.com/search/repositories?q=created:%3E2021-07-01&sort=stars&order=desc";
	
	
	@GetMapping("/api/v1/trendings")
	public List<Elements> index() throws IOException, InterruptedException {
		
		// We get the json elements parsed in a Java List
		List<Items> items = fetchingService.fetchItems(JsonUrl);
		
		// Cleaned languages list 
		List<String> languages = new ArrayList<String>();
		for (Items item : items) {
			if(item.getLanguage() == null) {
				item.setLanguage("Null");
			}
			languages.add(item.getLanguage());
		}
		
		
			
		
		// ( Optional )  Useful to sort elements
		LanguageComparator comparator = new LanguageComparator();
		Collections.sort(items, comparator);
		
		
		/* We are relating the languages used, their numbers and their repositories 
		 * for each languages : count and repositories
		 * */
		
		
		
		List<Elements> elements = new ArrayList<Elements>();
		int frequences = 0;
		
		// We are exploiting Set no-duplicate property to get the distinct languages
		Set<String> distinct = new HashSet<>(languages);
		for (String s: distinct) {
			ArrayList<String> repos = new ArrayList<String>();
			frequences = Collections.frequency(languages, s);
			
			// For each languages we take the repository's name
	        for (Items i : items) {
	        	if(i.getLanguage().equals(s)) {
	        		repos.add(i.getName());
	        	}
	        }
	     elements.add(new Elements(frequences,s, repos));
	     
	     // We reinitialize our array 
	     repos = new ArrayList<String>();
	     }
		
		
		
		return elements;
	}


}
