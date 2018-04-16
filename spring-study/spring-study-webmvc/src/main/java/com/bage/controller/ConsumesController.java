package com.bage.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConsumesController {

	@PostMapping(path = "/pets", consumes = "application/json")
	public void addPet(@RequestBody Pet pet, Model model) {
	        // implementation omitted
	}
	
	@GetMapping(path = "/pets/{petId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Pet getPet(@PathVariable String petId, Model model) {
	        // implementation omitted
		return null;
	}
	
}
