package com.main.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.main.services.LanguageComparator;
import com.main.models.Elements;
import com.main.models.Items;
import com.main.services.IFetchingService;

@Controller
public class MainController {
	
	@Autowired
	public IFetchingService fetchingService;
	final String JsonUrl = "https://api.github.com/search/repositories?q=created:%3E2021-07-01&sort=stars&order=desc";
	
	
	@GetMapping("/")
	public String index(Model model) throws IOException, InterruptedException {
		
		// We get the json elements parsed in a Java List
		List<Items> items = fetchingService.fetchItems(JsonUrl);
		
		// Repositories count and cleaned languages list 
		int numberOfRepos = 0;
		List<String> languages = new ArrayList<String>();
		for (Items item : items) {
			numberOfRepos ++;
			if(item.getLanguage() == null) {
				item.setLanguage("Null");
			}
			languages.add(item.getLanguage());
		}
		
		
		// Setting totalRepositories fetched to the template
		model.addAttribute("totalRepos", numberOfRepos);
		
		
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
		
		
		
		// Adding our elements to display in the template
		model.addAttribute("elements", elements);
		
		
		// We display everything in a basic Thymeleaf template
		return "index";
	}

}
