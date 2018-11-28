package com.bage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// A URI Template is a URI-like string, containing one or more variable names. When you substitute values for these variables, the template becomes a URI. For example http://www.example.com/users/{userId} contains the variable userId. Assigning the value fred to the variable yields http://www.example.com/users/fred.
@Controller
@RequestMapping("/owners/{ownerId}")
public class PathVariableController {

	@GetMapping("/owners/{ownerId}")
	public String findOwner(@PathVariable("ownerId") String theOwner, Model model) {
		// implementation omitted
		//Owner owner = ownerService.findOwner(ownerId);
		// Owner owner = null;
		 Object owner = null;
		model.addAttribute("owner", owner );
        return "displayOwner";
	}
	
	@GetMapping("/owners/{ownerId}/pets/{petId}")
	public String findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {
	        // Owner owner = ownerService.findOwner(ownerId);
			// Pet pet = owner.getPet(petId);
		 	Object pet = null;
	        model.addAttribute("pet", pet);
	        return "displayPet";
	}
	
	// URI Template Patterns with Regular Expressions
	@RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")
	public void handle(@PathVariable String version, @PathVariable String extension) {
	}
	
	
}
