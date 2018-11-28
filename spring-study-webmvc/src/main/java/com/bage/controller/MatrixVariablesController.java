package com.bage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;

// Note that to enable the use of matrix variables, you must set the removeSemicolonContent property of RequestMappingHandlerMapping to false. By default it is set to true.
@Controller
// <mvc:annotation-driven enable-matrix-variables="true"/>
public class MatrixVariablesController {

	// GET /pets/42;q=11;r=22
	@GetMapping("/pets/{petId}")
	public void findPet(@PathVariable String petId, @MatrixVariable int q) {

	        // petId == 42
	        // q == 11

	}
	
	// GET /pets/42
	@GetMapping("/pets2/{petId}")
	public void findPet(@MatrixVariable(required=false, defaultValue="1") int q) {

	        // q == 1

	}
	
	// GET /owners/42;q=11/pets/21;q=22
	@GetMapping("/owners/{ownerId}/pets/{petId}")
	public void findPet(
	                @MatrixVariable(name="q", pathVar="ownerId") int q1,
	                @MatrixVariable(name="q", pathVar="petId") int q2) {

	        // q1 == 11
	        // q2 == 22

	}
		
	// GET /owners/42;q=11;r=12/pets/21;q=22;s=23
	@GetMapping("/owners2/{ownerId}/pets/{petId}")
	public void findPet(
	                @MatrixVariable MultiValueMap<String, String> matrixVars,
	                @MatrixVariable(pathVar="petId") MultiValueMap<String, String> petMatrixVars) {

	        // matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
	        // petMatrixVars: ["q" : 11, "s" : 23]

	}
}
